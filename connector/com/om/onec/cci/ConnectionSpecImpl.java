package com.om.onec.cci;

import javax.resource.cci.*;

/**
 * The interface ConnectionSpec is used by an application component to pass connection request-specific properties to
 * the getConnection method.
 * @author DenisS
 * @version 1.0
 * @description The interface ConnectionSpec is used by an application component to pass connection request-specific
 * properties to the getConnection method.
 * @testcase com.om.onec.junit.unit.com.om.onec.adapter.cci.TestConnectionSpecImpl
 */
public class ConnectionSpecImpl implements ConnectionSpec {
    private String userName = null;
    private String password = null;

    public ConnectionSpecImpl(String userN, String passwd) {
        userName = userN;
        password = passwd;
    }

    public void setUserName(String newUserName) {
        userName = newUserName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getPassword() {
        return password;
    }
}
