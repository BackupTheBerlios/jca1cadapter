package com.om.onec.cci;

import javax.resource.cci.*;
import java.util.*;

/** @author Nio
 *  ManagedConnectionImpl credentials definition
 *
 */
  
public class ConnectionSpecImpl implements ConnectionSpec {

    //stores server ip
    private String servIp = null;
    
    //stores username under NT domain
    private String userName = null;
    
    //stores password under NT domain
    private String password = null;
    
    //stores NT domain name
    private String domain = null;
    
    
    //stores user name to access 1C
    private String dbUserName = null;
    
    //stores password to access 1C
    private String dbPassword = null;
    
    //stores path to 1C database
    private String dbPath = null;
    
    public ConnectionSpecImpl(Properties props) {
	setUpProperties(props);
    }    

    public ConnectionSpecImpl(String ip, String domain, String user, String password, String dbuser, String dbpass, String dbpath) {
	this.servIp = ip;
        this.userName = user;
        this.password = password;
	this.domain = domain;
	
	this.dbUserName = dbuser;
	this.dbPassword = dbpass;
	this.dbPath = dbpath;
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
    
    public void setDomain(String domain) {
	this.domain = domain;
    }
    
    public String getDomain() {
	return this.domain;
    }
    
    public void setServerIp(String ip) {
	this.servIp = ip;
    }
    
    public String getServerIp() {
	return this.servIp;
    }
    
    public void setDbUser(String user) {
	this.dbUserName = user;
    }
    
    public String getDbUser() {
	return this.dbUserName;
    }
    
    public void setDbPassword(String pass) {
	this.dbPassword = pass;
    }
    
    public String getDbPassword() {
	return this.dbPassword;
    }
    
    public void setDbPath(String path) {
	this.dbPath = path;
    }
    
    public String getDbPath() {
	return this.dbPath;
    }
    
    public void setUpProperties(Properties prop) {
	this.servIp = prop.getProperty("Ip");
        this.userName = prop.getProperty("User");
        this.password = prop.getProperty("Password");
	this.domain = prop.getProperty("Domain");
	
	this.dbUserName = prop.getProperty("DbUser");
	this.dbPassword = prop.getProperty("DbPassword");
	this.dbPath = prop.getProperty("DbPath");
    }
    
}
