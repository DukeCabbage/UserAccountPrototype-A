package com.cabbage.useraccountprototype.useraccount;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressWarnings({"unused", "WeakerAccess"})
public class ZoroEndUser {

    public static final String INCOMPLETE = "INCOMPLETE";
    public static final String VERIFIED = "VERIFIED";
    public static final String PENDING = "PENDING_VERIFICATION";
    public static final String DISABLED = "DISABLED";

    @NonNull @AccountStatus private String accountStatus = INCOMPLETE;
    @Nullable private String cognitoUserName;
    @Nullable private String cognitoPhoneNumber;
    @NonNull private String name = "";
    @NonNull private String email = "";
    @NonNull private String countryCode = "";
    @NonNull private String phoneNumber = "";

    public static ZoroEndUser mockUser() {
        ZoroEndUser mockUser = new ZoroEndUser();
        mockUser.accountStatus = INCOMPLETE;
        mockUser.cognitoUserName = "xxx";
        mockUser.countryCode = "1";
        mockUser.phoneNumber = "6047632293";
        mockUser.cognitoPhoneNumber = "+" + mockUser.countryCode + mockUser.phoneNumber;
        mockUser.name = "Joker";
        mockUser.email = "joker@gmail.com";
        return mockUser;
    }

    @StringDef({INCOMPLETE, VERIFIED, PENDING, DISABLED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AccountStatus {
    }
}
