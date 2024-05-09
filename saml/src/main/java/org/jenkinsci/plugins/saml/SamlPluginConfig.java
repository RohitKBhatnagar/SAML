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

import jenkins.model.Jenkins;
import org.apache.commons.lang.StringUtils;

import static org.jenkinsci.plugins.saml.SamlSecurityRealm.CONSUMER_SERVICE_URL_PATH;
import static org.jenkinsci.plugins.saml.SamlSecurityRealm.DEFAULT_USERNAME_CASE_CONVERSION;

/**
 * contains all the Jenkins SAML Plugin settings
 */
public class SamlPluginConfig {
    private String displayNameAttributeName;
    private String groupsAttributeName;
    private int maximumAuthenticationLifetime;
    private String emailAttributeName;

    private final IdpMetadataConfiguration idpMetadataConfiguration;
    private final String usernameCaseConversion;
    private final String usernameAttributeName;
    private final String logoutUrl;
    private final String binding;

    private SamlEncryptionData encryptionData;
    private SamlAdvancedConfiguration advancedConfiguration;
    private SamlLdapLookUp ldapLookUp;

    public SamlPluginConfig(String displayNameAttributeName, String groupsAttributeName,
                            int maximumAuthenticationLifetime, String emailAttributeName, IdpMetadataConfiguration idpMetadataConfiguration,
                            String usernameCaseConversion, String usernameAttributeName, String logoutUrl, String binding,
                            SamlEncryptionData encryptionData, SamlAdvancedConfiguration advancedConfiguration, SamlLdapLookUp ldapLookUp) {
        this.displayNameAttributeName = displayNameAttributeName;
        this.groupsAttributeName = groupsAttributeName;
        this.maximumAuthenticationLifetime = maximumAuthenticationLifetime;
        this.emailAttributeName = emailAttributeName;
        this.idpMetadataConfiguration = idpMetadataConfiguration;
        this.usernameCaseConversion = StringUtils.defaultIfBlank(usernameCaseConversion, DEFAULT_USERNAME_CASE_CONVERSION);
        this.usernameAttributeName = hudson.Util.fixEmptyAndTrim(usernameAttributeName);
        this.logoutUrl = logoutUrl;
        this.binding = binding;
        this.encryptionData = encryptionData;
        this.advancedConfiguration = advancedConfiguration;
        this.ldapLookUp = ldapLookUp;
    }

    public String getUsernameAttributeName() {
        return usernameAttributeName;
    }


    public String getDisplayNameAttributeName() {
        return displayNameAttributeName;
    }

    public String getGroupsAttributeName() {
        return groupsAttributeName;
    }

    public Integer getMaximumAuthenticationLifetime() {
        return maximumAuthenticationLifetime;
    }

    public SamlAdvancedConfiguration getAdvancedConfiguration() {
        return advancedConfiguration;
    }

    //Added for SAML based LDAP user look up
    public SamlLdapLookUp getLdapLookUp() { return ldapLookUp; }
    public Boolean getForceLDAPUser() {
        return getAdvancedConfiguration() != null ? getAdvancedConfiguration().getForceLDAPUser() : Boolean.TRUE;
    }

    public Boolean getForceAuthn() {
        return getAdvancedConfiguration() != null ? getAdvancedConfiguration().getForceAuthn() : Boolean.FALSE;
    }

    public String getAuthnContextClassRef() {
        return getAdvancedConfiguration() != null ? getAdvancedConfiguration().getAuthnContextClassRef() : null;
    }

    public String getSpEntityId() {
        return getAdvancedConfiguration() != null ? getAdvancedConfiguration().getSpEntityId() : null;
    }

    public String getNameIdPolicyFormat() {
        return getAdvancedConfiguration() != null ? getAdvancedConfiguration().getNameIdPolicyFormat() : null;
    }

    public SamlEncryptionData getEncryptionData() {
        return encryptionData;
    }

    public String getUsernameCaseConversion() {
        return usernameCaseConversion;
    }

    public String getEmailAttributeName() {
        return emailAttributeName;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public String getConsumerServiceUrl() {
        return baseUrl() + CONSUMER_SERVICE_URL_PATH;
    }

    public String baseUrl() {
        return Jenkins.get().getRootUrl();
    }

    public IdpMetadataConfiguration getIdpMetadataConfiguration() {
        return idpMetadataConfiguration;
    }

    public String getBinding() {
        return binding;
    }

    /*
     * For LDAP User Look Up
     */
    public String getServer() { return getLdapLookUp() != null ? getLdapLookUp().getServer() : null; }
    public String getRootDN() { return getLdapLookUp() != null ? getLdapLookUp().getServer() : null; }
    public boolean isInhibitInferRootDN() { return getLdapLookUp() != null ? getLdapLookUp().isInhibitInferRootDN() : false; }
    public String getUserSearchBase() { return getLdapLookUp() != null ? getLdapLookUp().getUserSearchBase() : null; }
    public String getUserSearch() { return getLdapLookUp() != null ? getLdapLookUp().getUserSearch() : null; }
    public String getGroupSearchBase() { return getLdapLookUp() != null ? getLdapLookUp().getGroupSearchBase() : null; }
    public String getGroupSearchFilter() { return getLdapLookUp() != null ? getLdapLookUp().getGroupSearchFilter() : null; }
    public String getManagerDN() { return getLdapLookUp() != null ? getLdapLookUp().getManagerDN() : null; }
    public String getManagerPassword() { return getLdapLookUp() != null ? getLdapLookUp().getManagerPassword() : null; }
    //public String getDisplayNameAttributeName() { return getLdapLookUp() != null ? getLdapLookUp().getDisplayNameAttributeName() : null; }
    public String getMailAddressAttributeName() { return getLdapLookUp() != null ? getLdapLookUp().getMailAddressAttributeName() : null; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SamlPluginConfig{");
        sb.append("idpMetadataConfiguration='").append(getIdpMetadataConfiguration()).append('\'');
        sb.append(", displayNameAttributeName='").append(getDisplayNameAttributeName()).append('\'');
        sb.append(", groupsAttributeName='").append(getGroupsAttributeName()).append('\'');
        sb.append(", emailAttributeName='").append(getEmailAttributeName()).append('\'');
        sb.append(", usernameAttributeName='").append(getUsernameAttributeName()).append('\'');
        sb.append(", maximumAuthenticationLifetime=").append(getMaximumAuthenticationLifetime());
        sb.append(", usernameCaseConversion='").append(getUsernameCaseConversion()).append('\'');
        sb.append(", logoutUrl='").append(getLogoutUrl()).append('\'');
        sb.append(", binding='").append(getBinding()).append('\'');
        sb.append(", encryptionData=").append(getEncryptionData());
        sb.append(", advancedConfiguration=").append(getAdvancedConfiguration());
        sb.append(", ldapLookUp=").append(getLdapLookUp());
        sb.append('}');
        return sb.toString();
    }
}
