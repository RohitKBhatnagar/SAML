/* Licensed to Jenkins CI under one or more contributor license
agreements.  See the NOTICE file distributed with this work
for additional information regarding copyright ownership.
Jenkins CI licenses this file to you under the Apache License,
Version 2.0 (the "License"); you may not use this file except
in compliance with the License.  You may obtain a copy of the
License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License. */

package org.jenkinsci.plugins.saml;

import hudson.Extension;
import hudson.Util;

import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import hudson.security.LDAPSecurityRealm;
import hudson.util.FormValidation;
import hudson.util.Secret;
import jenkins.security.plugins.ldap.LDAPExtendedTemplate;
import jenkins.security.plugins.ldap.LDAPGroupMembershipStrategy;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundConstructor;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static hudson.Util.*;
import static org.jenkinsci.plugins.saml.SamlSecurityRealm.ERROR_NOT_VALID_NUMBER;
import static org.jenkinsci.plugins.saml.SamlSecurityRealm.ERROR_ONLY_SPACES_FIELD_VALUE;

/**
 * Simple immutable data class to hold the optional advanced configuration data section
 * of the plugin's configuration page
 */
public class SamlAdvancedConfiguration extends AbstractDescribableImpl<SamlAdvancedConfiguration> {
    private final Boolean forceAuthn;
    private final String authnContextClassRef;
    private final String spEntityId;
    private final String nameIdPolicyFormat;
    /**
     * @deprecated not used anymore
     */
    @Deprecated
    private Integer maximumSessionLifetime;

    //--------------------------------------------------------------
    //Addition for supporting LDAP Configuration Begins here --Rohit
    private static final Logger LOGGER = LDAPSecurityRealm.LOGGER;
    private final Boolean forceLDAPUser;
    /**
     * LDAP server name(s) separated by spaces, optionally with TCP port number, like "ldap.acme.org"
     * or "ldap.acme.org:389" and/or with protocol, like "ldap://ldap.acme.org".
     */
    private final String server;

    /**
     * The root DN to connect to. Normally something like "dc=sun,dc=com"
     */
    private final String rootDN;
    /**
     * Allow the rootDN to be inferred? Default is false.
     * If true, allow rootDN to be blank.
     */
    private final boolean inhibitInferRootDN;
    private String userSearchBase;
    private String userSearch;
    private String groupSearchBase;
    private String groupSearchFilter;

    private LDAPGroupMembershipStrategy groupMembershipStrategy;
    /**
     * If non-null, we use this and {@link #getManagerPassword()}
     * when binding to LDAP.
     *
     * This is necessary when LDAP doesn't support anonymous access.
     */
    private final String managerDN;
    /**
     * Password used to first bind to LDAP.
     */
    private final Secret managerPasswordSecret;
    private String displayNameAttributeName;
    private String mailAddressAttributeName;
    /**
     * If true, then any operation using this configuration which fails to connect to the server will try
     * again using the next configuration. This could be a security issue if the same username exists in
     * multiple LDAP configurations but should not correspond to the same Jenkins user, so it defaults to false.
     */
    private boolean ignoreIfUnavailable;
    private Map<String,String> extraEnvVars;

    private transient LDAPExtendedTemplate ldapTemplate;
    private transient String id;
    //Addition to support LDAP Configuration Ends here --Rohit
    //--------------------------------------------------------------

    /*@DataBoundConstructor
    public SamlAdvancedConfiguration(Boolean forceAuthn,
                                     String authnContextClassRef,
                                     String spEntityId,
                                     String nameIdPolicyFormat,
                                     Integer maximumSessionLifetime) {
        this.forceAuthn = (forceAuthn != null) ? forceAuthn : false;
        this.authnContextClassRef = Util.fixEmptyAndTrim(authnContextClassRef);
        this.spEntityId = Util.fixEmptyAndTrim(spEntityId);
        this.nameIdPolicyFormat = Util.fixEmptyAndTrim(nameIdPolicyFormat);
    }*/

    @DataBoundConstructor
    public SamlAdvancedConfiguration(Boolean forceAuthn,
                                     String authnContextClassRef,
                                     String spEntityId,
                                     String nameIdPolicyFormat,
                                     Integer maximumSessionLifetime,
                                     Boolean forceLDAPUser,
                                     String server,
                                     boolean inhibitInferRootDN,
                                     String rootDN,
                                     String userSearchBase,
                                     String userSearch,
                                     String groupSearchBase,
                                     String groupSearchFilter,
                                     String managerDN,
                                     Secret managerPasswordSecret,
                                     String displayNameAttributeName,
                                     String mailAddressAttributeName) {
        this.forceAuthn = (forceAuthn != null) ? forceAuthn : false;
        this.authnContextClassRef = Util.fixEmptyAndTrim(authnContextClassRef);
        this.spEntityId = Util.fixEmptyAndTrim(spEntityId);
        this.nameIdPolicyFormat = Util.fixEmptyAndTrim(nameIdPolicyFormat);
        //For LDAP integration
        this.forceLDAPUser = (forceLDAPUser != null) ? forceLDAPUser:true;
        this.server = server.trim();
        this.inhibitInferRootDN = inhibitInferRootDN;
        if (!inhibitInferRootDN && fixEmptyAndTrim(rootDN) == null) {
            rootDN = fixNull(inferRootDN(server));
        }
        this.rootDN = rootDN;
        this.userSearchBase = userSearchBase;
        this.userSearch = userSearch; //LDAPSecurityRealm.DescriptorImpl.DEFAULT_USER_SEARCH;
        this.groupSearchBase = groupSearchBase;
        this.groupSearchFilter = groupSearchFilter;

        this.managerDN = fixEmpty(managerDN);
        this.managerPasswordSecret = managerPasswordSecret;

        this.displayNameAttributeName = displayNameAttributeName; //LDAPSecurityRealm.DescriptorImpl.DEFAULT_DISPLAYNAME_ATTRIBUTE_NAME;
        this.mailAddressAttributeName = mailAddressAttributeName; //LDAPSecurityRealm.DescriptorImpl.DEFAULT_MAILADDRESS_ATTRIBUTE_NAME;
    }

    public Boolean getForceAuthn() {
        return forceAuthn;
    }

    public String getAuthnContextClassRef() {
        return authnContextClassRef;
    }

    public String getSpEntityId() {
        return spEntityId;
    }

    public String getNameIdPolicyFormat() {
        return nameIdPolicyFormat;
    }

    //--------------------------------------------------------------
    //Addition for supporting LDAP Configuration Begins here --Rohit
    public Boolean getForceLDAPUser() { return forceLDAPUser; }
    /**
     * LDAP server name(s) separated by spaces, optionally with TCP port number, like "ldap.acme.org"
     * or "ldap.acme.org:389" and/or with protocol, like "ldap://ldap.acme.org".
     */
    public String getServer() {
        return server;
    }

    public String getServerUrl() {
        StringBuilder buf = new StringBuilder();
        boolean first = true;
        for (String s : Util.fixNull(server).split("\\s+")) {
            if (s.trim().length() == 0) continue;
            if (first) first = false;
            else buf.append(' ');
            buf.append(addPrefix(s));
        }
        return buf.toString();
    }

    /**
     * If the given "server name" is just a host name (plus optional host name), add ldap:// prefix.
     * Otherwise assume it already contains the scheme, and leave it intact.
     */
    private static String addPrefix(String server) {
        if (server.contains("://")) return server;
        else return "ldap://" + server;
    }

    /**
     * Infer the root DN.
     *
     * @return null if not found.
     */
    private String inferRootDN(String server) {
        try {
            Hashtable<String, String> props = new Hashtable<String, String>();
            if (managerDN != null) {
                props.put(Context.SECURITY_PRINCIPAL, managerDN);
                props.put(Context.SECURITY_CREDENTIALS, getManagerPassword());
            }
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            props.put(Context.PROVIDER_URL, LDAPSecurityRealm.toProviderUrl(getServerUrl(), ""));

            DirContext ctx = new InitialDirContext(props);
            Attributes atts = ctx.getAttributes("");
            Attribute a = atts.get("defaultNamingContext");
            if (a != null && a.get() != null) // this entry is available on Active Directory. See http://msdn2.microsoft.com/en-us/library/ms684291(VS.85).aspx
                return a.get().toString();

            a = atts.get("namingcontexts");
            if (a == null) {
                LOGGER.warning("namingcontexts attribute not found in root DSE of " + server);
                return null;
            }
            return a.get().toString();
        } catch (NamingException e) {
            LOGGER.log(Level.WARNING, "Failed to connect to LDAP to infer Root DN for " + server, e);
            return null;
        }
    }

    /**
     * The root DN to connect to. Normally something like "dc=sun,dc=com"
     */
    public String getRootDN() {
        return rootDN;
    }

    public String getLDAPURL() {
        return LDAPSecurityRealm.toProviderUrl(getServerUrl(), fixNull(rootDN));
    }

    /**
     * Allow the rootDN to be inferred? Default is false.
     * If true, allow rootDN to be blank.
     */
    public boolean isInhibitInferRootDN() {
        return inhibitInferRootDN;
    }

    /**
     * Specifies the relative DN from {@link #rootDN the root DN}.
     * This is used to narrow down the search space when doing user search.
     *
     * Something like "ou=people" but can be empty.
     */
    public String getUserSearchBase() {
        return userSearchBase;
    }

    /**
     * Query to locate an entry that identifies the user, given the user name string.
     *
     * Normally "uid={0}"
     *
     * @see FilterBasedLdapUserSearch
     */
    public String getUserSearch() {
        return userSearch;
    }

    /**
     * This defines the organizational unit that contains groups.
     *
     * Normally "" to indicate the full LDAP search, but can be often narrowed down to
     * something like "ou=groups"
     *
     * @see FilterBasedLdapUserSearch
     */
    public String getGroupSearchBase() {
        return groupSearchBase;
    }

    /**
     * Query to locate an entry that identifies the group, given the group name string. If non-null it will override
     * the default specified by {@link LDAPSecurityRealm#GROUP_SEARCH}
     *
     */
    public String getGroupSearchFilter() {
        return groupSearchFilter;
    }

    /**
     * If non-null, we use this and {@link #getManagerPassword()}
     * when binding to LDAP.
     *
     * This is necessary when LDAP doesn't support anonymous access.
     */
    public String getManagerDN() {
        return managerDN;
    }

    /**
     * Password used to first bind to LDAP.
     */
    public String getManagerPassword() {
        return Secret.toString(managerPasswordSecret);
    }

    public Secret getManagerPasswordSecret() {
        return managerPasswordSecret;
    }

    public String getDisplayNameAttributeName() {
        return StringUtils.defaultString(displayNameAttributeName, LDAPSecurityRealm.DescriptorImpl.DEFAULT_DISPLAYNAME_ATTRIBUTE_NAME);
    }

    public String getMailAddressAttributeName() {
        return StringUtils.defaultString(mailAddressAttributeName, LDAPSecurityRealm.DescriptorImpl.DEFAULT_MAILADDRESS_ATTRIBUTE_NAME);
    }
    //Addition to support LDAP Configuration Ends here --Rohit

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SamlAdvancedConfiguration{");
        sb.append("forceAuthn=").append(getForceAuthn());
        sb.append(", authnContextClassRef='").append(StringUtils.defaultIfBlank(getAuthnContextClassRef(), "none")).append('\'');
        sb.append(", spEntityId='").append(StringUtils.defaultIfBlank(getSpEntityId(), "none")).append('\'');
        sb.append(", nameIdPolicyFormat='").append(StringUtils.defaultIfBlank(getNameIdPolicyFormat(), "none")).append('\'');
        sb.append(", forceLDAPUser=").append(getForceLDAPUser());
        sb.append('}');
        return sb.toString();
    }

    @Extension
    public static final class DescriptorImpl extends Descriptor<SamlAdvancedConfiguration> {
        public DescriptorImpl() {
            super();
        }

        public DescriptorImpl(Class<? extends SamlAdvancedConfiguration> clazz) {
            super(clazz);
        }

        @Override
        public String getDisplayName() {
            return "Advanced Configuration";
        }


        public FormValidation doCheckAuthnContextClassRef(@org.kohsuke.stapler.QueryParameter String authnContextClassRef) {
           return SamlFormValidation.checkStringFormat(authnContextClassRef);
        }


        public FormValidation doCheckSpEntityId(@org.kohsuke.stapler.QueryParameter String spEntityId) {
            return SamlFormValidation.checkStringFormat(spEntityId);
        }

        public FormValidation doCheckNameIdPolicyFormat(@org.kohsuke.stapler.QueryParameter String nameIdPolicyFormat) {
            return SamlFormValidation.checkStringFormat(nameIdPolicyFormat);
        }

        public FormValidation doCheckMaximumSessionLifetime(@org.kohsuke.stapler.QueryParameter String maximumSessionLifetime) {
            if (StringUtils.isEmpty(maximumSessionLifetime)) {
                return hudson.util.FormValidation.ok();
            }

            long i = 0;
            try {
                i = Long.parseLong(maximumSessionLifetime);
            } catch (NumberFormatException e) {
                return hudson.util.FormValidation.error(ERROR_NOT_VALID_NUMBER, e);
            }

            if (i < 0) {
                return hudson.util.FormValidation.error(ERROR_NOT_VALID_NUMBER);
            }

            if (i > Integer.MAX_VALUE) {
                return hudson.util.FormValidation.error(ERROR_NOT_VALID_NUMBER);
            }

            return hudson.util.FormValidation.ok();
        }

    }
}