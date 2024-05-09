package jenkins.security.plugins.ldap;

import org.jvnet.localizer.Localizable;
import org.jvnet.localizer.ResourceBundleHolder;

public class Messages {
    private static final ResourceBundleHolder holder = ResourceBundleHolder.get(Messages.class);

    public Messages() {
    }

    public static String LDAPSecurityRealm_InvalidPortNumber() {
        return holder.format("LDAPSecurityRealm.InvalidPortNumber", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_InvalidPortNumber() {
        return new Localizable(holder, "LDAPSecurityRealm.InvalidPortNumber", new Object[0]);
    }

    public static String LDAPSecurityRealm_UnableToConnect(Object arg0, Object arg1) {
        return holder.format("LDAPSecurityRealm.UnableToConnect", new Object[]{arg0, arg1});
    }

    public static Localizable _LDAPSecurityRealm_UnableToConnect(Object arg0, Object arg1) {
        return new Localizable(holder, "LDAPSecurityRealm.UnableToConnect", new Object[]{arg0, arg1});
    }

    public static String UserDetails_Disabled(Object arg0) {
        return holder.format("UserDetails.Disabled", new Object[]{arg0});
    }

    public static Localizable _UserDetails_Disabled(Object arg0) {
        return new Localizable(holder, "UserDetails.Disabled", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_UsernameMismatch(Object arg0, Object arg1) {
        return holder.format("LDAPSecurityRealm.UsernameMismatch", new Object[]{arg0, arg1});
    }

    public static Localizable _LDAPSecurityRealm_UsernameMismatch(Object arg0, Object arg1) {
        return new Localizable(holder, "LDAPSecurityRealm.UsernameMismatch", new Object[]{arg0, arg1});
    }

    public static String LDAPSecurityRealm_PotentialLockout(Object arg0) {
        return holder.format("LDAPSecurityRealm.PotentialLockout", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_PotentialLockout(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.PotentialLockout", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_UserLookupInconclusive(Object arg0) {
        return holder.format("LDAPSecurityRealm.UserLookupInconclusive", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_UserLookupInconclusive(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.UserLookupInconclusive", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_CouldNotRetrieveEmailAddress() {
        return holder.format("LDAPSecurityRealm.CouldNotRetrieveEmailAddress", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_CouldNotRetrieveEmailAddress() {
        return new Localizable(holder, "LDAPSecurityRealm.CouldNotRetrieveEmailAddress", new Object[0]);
    }

    public static String LDAPSecurityRealm_NotSameServer() {
        return holder.format("LDAPSecurityRealm.NotSameServer", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_NotSameServer() {
        return new Localizable(holder, "LDAPSecurityRealm.NotSameServer", new Object[0]);
    }

    public static String LDAPSecurityRealm_EmptyDisplayName() {
        return holder.format("LDAPSecurityRealm.EmptyDisplayName", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_EmptyDisplayName() {
        return new Localizable(holder, "LDAPSecurityRealm.EmptyDisplayName", new Object[0]);
    }

    public static String LDAPSecurityRealm_UserEmail(Object arg0) {
        return holder.format("LDAPSecurityRealm.UserEmail", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_UserEmail(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.UserEmail", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_UserConfiguration(Object arg0) {
        return holder.format("LDAPSecurityRealm.UserConfiguration", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_UserConfiguration(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.UserConfiguration", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_NoGroupMembership() {
        return holder.format("LDAPSecurityRealm.NoGroupMembership", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_NoGroupMembership() {
        return new Localizable(holder, "LDAPSecurityRealm.NoGroupMembership", new Object[0]);
    }

    public static String LDAPSecurityRealm_GroupLookupFailed(Object arg0) {
        return holder.format("LDAPSecurityRealm.GroupLookupFailed", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_GroupLookupFailed(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.GroupLookupFailed", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_LoginHeader() {
        return holder.format("LDAPSecurityRealm.LoginHeader", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_LoginHeader() {
        return new Localizable(holder, "LDAPSecurityRealm.LoginHeader", new Object[0]);
    }

    public static String LDAPSecurityRealm_EmptyEmailAddress() {
        return holder.format("LDAPSecurityRealm.EmptyEmailAddress", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_EmptyEmailAddress() {
        return new Localizable(holder, "LDAPSecurityRealm.EmptyEmailAddress", new Object[0]);
    }

    public static String LDAPSecurityRealm_SyntaxOfServerField() {
        return holder.format("LDAPSecurityRealm.SyntaxOfServerField", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_SyntaxOfServerField() {
        return new Localizable(holder, "LDAPSecurityRealm.SyntaxOfServerField", new Object[0]);
    }

    public static String LDAPSecurityRealm_AuthenticationSuccessful() {
        return holder.format("LDAPSecurityRealm.AuthenticationSuccessful", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_AuthenticationSuccessful() {
        return new Localizable(holder, "LDAPSecurityRealm.AuthenticationSuccessful", new Object[0]);
    }

    public static String LDAPSecurityRealm_AuthenticationFailedEmptyPass(Object arg0) {
        return holder.format("LDAPSecurityRealm.AuthenticationFailedEmptyPass", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_AuthenticationFailedEmptyPass(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.AuthenticationFailedEmptyPass", new Object[]{arg0});
    }

    public static String FromGroupSearchLDAPGroupMembershipStrategy_DisplayName() {
        return holder.format("FromGroupSearchLDAPGroupMembershipStrategy.DisplayName", new Object[0]);
    }

    public static Localizable _FromGroupSearchLDAPGroupMembershipStrategy_DisplayName() {
        return new Localizable(holder, "FromGroupSearchLDAPGroupMembershipStrategy.DisplayName", new Object[0]);
    }

    public static String LDAPSecurityRealm_UserDn(Object arg0) {
        return holder.format("LDAPSecurityRealm.UserDn", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_UserDn(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.UserDn", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_UserLookupSuccessful() {
        return holder.format("LDAPSecurityRealm.UserLookupSuccessful", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_UserLookupSuccessful() {
        return new Localizable(holder, "LDAPSecurityRealm.UserLookupSuccessful", new Object[0]);
    }

    public static String LDAPSecurityRealm_BasicGroupMembership() {
        return holder.format("LDAPSecurityRealm.BasicGroupMembership", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_BasicGroupMembership() {
        return new Localizable(holder, "LDAPSecurityRealm.BasicGroupMembership", new Object[0]);
    }

    public static String LDAPSecurityRealm_LockoutHeader() {
        return holder.format("LDAPSecurityRealm.LockoutHeader", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_LockoutHeader() {
        return new Localizable(holder, "LDAPSecurityRealm.LockoutHeader", new Object[0]);
    }

    public static String LDAPSecurityRealm_AvailableAttributes() {
        return holder.format("LDAPSecurityRealm.AvailableAttributes", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_AvailableAttributes() {
        return new Localizable(holder, "LDAPSecurityRealm.AvailableAttributes", new Object[0]);
    }

    public static String FromUserRecordLDAPGroupMembershipStrategy_DisplayName() {
        return holder.format("FromUserRecordLDAPGroupMembershipStrategy.DisplayName", new Object[0]);
    }

    public static Localizable _FromUserRecordLDAPGroupMembershipStrategy_DisplayName() {
        return new Localizable(holder, "FromUserRecordLDAPGroupMembershipStrategy.DisplayName", new Object[0]);
    }

    public static String LDAPSecurityRealm_IsAttributeNameCorrect(Object arg0) {
        return holder.format("LDAPSecurityRealm.IsAttributeNameCorrect", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_IsAttributeNameCorrect(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.IsAttributeNameCorrect", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_DnMismatch(Object arg0, Object arg1) {
        return holder.format("LDAPSecurityRealm.DnMismatch", new Object[]{arg0, arg1});
    }

    public static Localizable _LDAPSecurityRealm_DnMismatch(Object arg0, Object arg1) {
        return new Localizable(holder, "LDAPSecurityRealm.DnMismatch", new Object[]{arg0, arg1});
    }

    public static String LDAPSecurityRealm_UserLookupBadCredentials() {
        return holder.format("LDAPSecurityRealm.UserLookupBadCredentials", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_UserLookupBadCredentials() {
        return new Localizable(holder, "LDAPSecurityRealm.UserLookupBadCredentials", new Object[0]);
    }

    public static String LDAPSecurityRealm_GroupLookupManagerDnPermissions() {
        return holder.format("LDAPSecurityRealm.GroupLookupManagerDnPermissions", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_GroupLookupManagerDnPermissions() {
        return new Localizable(holder, "LDAPSecurityRealm.GroupLookupManagerDnPermissions", new Object[0]);
    }

    public static String LDAPSecurityRealm_BasicGroupMembershipDetail() {
        return holder.format("LDAPSecurityRealm.BasicGroupMembershipDetail", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_BasicGroupMembershipDetail() {
        return new Localizable(holder, "LDAPSecurityRealm.BasicGroupMembershipDetail", new Object[0]);
    }

    public static String LDAPSecurityRealm_GroupLookupNotPossible() {
        return holder.format("LDAPSecurityRealm.GroupLookupNotPossible", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_GroupLookupNotPossible() {
        return new Localizable(holder, "LDAPSecurityRealm.GroupLookupNotPossible", new Object[0]);
    }

    public static String LDAPSecurityRealm_UserLookupManagerDnPermissions() {
        return holder.format("LDAPSecurityRealm.UserLookupManagerDnPermissions", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_UserLookupManagerDnPermissions() {
        return new Localizable(holder, "LDAPSecurityRealm.UserLookupManagerDnPermissions", new Object[0]);
    }

    public static String LDAPSecurityRealm_NoDisplayName() {
        return holder.format("LDAPSecurityRealm.NoDisplayName", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_NoDisplayName() {
        return new Localizable(holder, "LDAPSecurityRealm.NoDisplayName", new Object[0]);
    }

    public static String LDAPSecurityRealm_UserLookupDoesNotExist(Object arg0) {
        return holder.format("LDAPSecurityRealm.UserLookupDoesNotExist", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_UserLookupDoesNotExist(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.UserLookupDoesNotExist", new Object[]{arg0});
    }

    public static String UserDetails_Expired(Object arg0, Object arg1) {
        return holder.format("UserDetails.Expired", new Object[]{arg0, arg1});
    }

    public static Localizable _UserDetails_Expired(Object arg0, Object arg1) {
        return new Localizable(holder, "UserDetails.Expired", new Object[]{arg0, arg1});
    }

    public static String LDAPSecurityRealm_UserLookupFailed(Object arg0) {
        return holder.format("LDAPSecurityRealm.UserLookupFailed", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_UserLookupFailed(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.UserLookupFailed", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_DisplayName() {
        return holder.format("LDAPSecurityRealm.DisplayName", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_DisplayName() {
        return new Localizable(holder, "LDAPSecurityRealm.DisplayName", new Object[0]);
    }

    public static String LDAPSecurityRealm_GroupLookupNotPossibleDetail() {
        return holder.format("LDAPSecurityRealm.GroupLookupNotPossibleDetail", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_GroupLookupNotPossibleDetail() {
        return new Localizable(holder, "LDAPSecurityRealm.GroupLookupNotPossibleDetail", new Object[0]);
    }

    public static String LDAPSecurityRealm_UserLookupSettingsCorrect() {
        return holder.format("LDAPSecurityRealm.UserLookupSettingsCorrect", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_UserLookupSettingsCorrect() {
        return new Localizable(holder, "LDAPSecurityRealm.UserLookupSettingsCorrect", new Object[0]);
    }

    public static String LDAPSecurityRealm_GroupMembershipMismatch() {
        return holder.format("LDAPSecurityRealm.GroupMembershipMismatch", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_GroupMembershipMismatch() {
        return new Localizable(holder, "LDAPSecurityRealm.GroupMembershipMismatch", new Object[0]);
    }

    public static String LDAPSecurityRealm_GroupLookupManagerDnRequired() {
        return holder.format("LDAPSecurityRealm.GroupLookupManagerDnRequired", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_GroupLookupManagerDnRequired() {
        return new Localizable(holder, "LDAPSecurityRealm.GroupLookupManagerDnRequired", new Object[0]);
    }

    public static String LDAPSecurityRealm_LookupHeader() {
        return holder.format("LDAPSecurityRealm.LookupHeader", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_LookupHeader() {
        return new Localizable(holder, "LDAPSecurityRealm.LookupHeader", new Object[0]);
    }

    public static String LDAPSecurityRealm_UnknownHost(Object arg0) {
        return holder.format("LDAPSecurityRealm.UnknownHost", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_UnknownHost(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.UnknownHost", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_DnParse(Object arg0) {
        return holder.format("LDAPSecurityRealm.DnParse", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_DnParse(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.DnParse", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_GroupLookupSettingsCorrect() {
        return holder.format("LDAPSecurityRealm.GroupLookupSettingsCorrect", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_GroupLookupSettingsCorrect() {
        return new Localizable(holder, "LDAPSecurityRealm.GroupLookupSettingsCorrect", new Object[0]);
    }

    public static String LDAPSecurityRealm_UserLookupManagerDnRequired() {
        return holder.format("LDAPSecurityRealm.UserLookupManagerDnRequired", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_UserLookupManagerDnRequired() {
        return new Localizable(holder, "LDAPSecurityRealm.UserLookupManagerDnRequired", new Object[0]);
    }

    public static String UserDetails_Inactive(Object arg0, Object arg1) {
        return holder.format("UserDetails.Inactive", new Object[]{arg0, arg1});
    }

    public static Localizable _UserDetails_Inactive(Object arg0, Object arg1) {
        return new Localizable(holder, "UserDetails.Inactive", new Object[]{arg0, arg1});
    }

    public static String LDAPSecurityRealm_UserId(Object arg0) {
        return holder.format("LDAPSecurityRealm.UserId", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_UserId(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.UserId", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_UserDisplayName(Object arg0) {
        return holder.format("LDAPSecurityRealm.UserDisplayName", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_UserDisplayName(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.UserDisplayName", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_UserLookupManagerDnCorrect() {
        return holder.format("LDAPSecurityRealm.UserLookupManagerDnCorrect", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_UserLookupManagerDnCorrect() {
        return new Localizable(holder, "LDAPSecurityRealm.UserLookupManagerDnCorrect", new Object[0]);
    }

    public static String LDAPSecurityRealm_GroupLookupSuccessful(Object arg0) {
        return holder.format("LDAPSecurityRealm.GroupLookupSuccessful", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_GroupLookupSuccessful(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.GroupLookupSuccessful", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_CouldNotRetrieveDisplayName() {
        return holder.format("LDAPSecurityRealm.CouldNotRetrieveDisplayName", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_CouldNotRetrieveDisplayName() {
        return new Localizable(holder, "LDAPSecurityRealm.CouldNotRetrieveDisplayName", new Object[0]);
    }

    public static String LDAPSecurityRealm_AtLeastOne() {
        return holder.format("LDAPSecurityRealm.AtLeastOne", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_AtLeastOne() {
        return new Localizable(holder, "LDAPSecurityRealm.AtLeastOne", new Object[0]);
    }

    public static String UserDetails_CredentialsExpired(Object arg0) {
        return holder.format("UserDetails.CredentialsExpired", new Object[]{arg0});
    }

    public static Localizable _UserDetails_CredentialsExpired(Object arg0) {
        return new Localizable(holder, "UserDetails.CredentialsExpired", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_GroupMembership() {
        return holder.format("LDAPSecurityRealm.GroupMembership", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_GroupMembership() {
        return new Localizable(holder, "LDAPSecurityRealm.GroupMembership", new Object[0]);
    }

    public static String LDAPSecurityRealm_NoEmailAddress() {
        return holder.format("LDAPSecurityRealm.NoEmailAddress", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_NoEmailAddress() {
        return new Localizable(holder, "LDAPSecurityRealm.NoEmailAddress", new Object[0]);
    }

    public static String LDAPSecurityRealm_DisplayNameMismatch(Object arg0, Object arg1) {
        return holder.format("LDAPSecurityRealm.DisplayNameMismatch", new Object[]{arg0, arg1});
    }

    public static Localizable _LDAPSecurityRealm_DisplayNameMismatch(Object arg0, Object arg1) {
        return new Localizable(holder, "LDAPSecurityRealm.DisplayNameMismatch", new Object[]{arg0, arg1});
    }

    public static String UserDetails_Locked(Object arg0) {
        return holder.format("UserDetails.Locked", new Object[]{arg0});
    }

    public static Localizable _UserDetails_Locked(Object arg0) {
        return new Localizable(holder, "UserDetails.Locked", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_GroupMembershipMatch() {
        return holder.format("LDAPSecurityRealm.GroupMembershipMatch", new Object[0]);
    }

    public static Localizable _LDAPSecurityRealm_GroupMembershipMatch() {
        return new Localizable(holder, "LDAPSecurityRealm.GroupMembershipMatch", new Object[0]);
    }

    public static String LDAPSecurityRealm_PotentialLockout2(Object arg0) {
        return holder.format("LDAPSecurityRealm.PotentialLockout2", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_PotentialLockout2(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.PotentialLockout2", new Object[]{arg0});
    }

    public static String LDAPSecurityRealm_EmailAddressMismatch(Object arg0, Object arg1) {
        return holder.format("LDAPSecurityRealm.EmailAddressMismatch", new Object[]{arg0, arg1});
    }

    public static Localizable _LDAPSecurityRealm_EmailAddressMismatch(Object arg0, Object arg1) {
        return new Localizable(holder, "LDAPSecurityRealm.EmailAddressMismatch", new Object[]{arg0, arg1});
    }

    public static String LDAPSecurityRealm_AuthenticationFailed(Object arg0) {
        return holder.format("LDAPSecurityRealm.AuthenticationFailed", new Object[]{arg0});
    }

    public static Localizable _LDAPSecurityRealm_AuthenticationFailed(Object arg0) {
        return new Localizable(holder, "LDAPSecurityRealm.AuthenticationFailed", new Object[]{arg0});
    }
}


