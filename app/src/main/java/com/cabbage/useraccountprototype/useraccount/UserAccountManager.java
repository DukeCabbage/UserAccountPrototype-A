package com.cabbage.useraccountprototype.useraccount;

public interface UserAccountManager {

    ZoroEndUser getUser();

    ZoroEndUser signUp(String phoneNumber, String countryCode, String password);

    ZoroEndUser login(String cognitoPhoneNumber, String password);
}
