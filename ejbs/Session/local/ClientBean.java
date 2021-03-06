/* Generated by Together */

package Session.local;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.rmi.RemoteException;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.naming.*;
import javax.rmi.PortableRemoteObject;
import com.om.onec.DocumentDesc;
import Session.remote.*;

/**
 * @ejbHome <{com.om.onec.junit.ejbs.Session.ClientHome}>
 * @ejbRemote <{com.om.onec.junit.ejbs.Session.Client}>
 */
public class ClientBean implements SessionBean {
    private SessionContext ctx;
    private Object ref;

    public void doTest() {
/*        try {
            System.out.println("[Client EJB] -> doTest...");
            TestConnectorHome tch = (TestConnectorHome)PortableRemoteObject.narrow(ref, TestConnectorHome.class);
            TestConnector tc = tch.create();
            System.out.println("Testing 1st connection factory lookup...");
            tc.lookupFactory("java:1CConnector");
            System.out.println("Test 1st connection factory lookup done");
            System.out.println("Testing 1st connection retrieving...");
            tc.getConnection();
            System.out.println("Testing 1st connection retreving done");
            System.out.println("Testing 1st connection closing...");
            tc.closeConnection();
            Thread.sleep(10000);
            System.out.println("Testing 1st connection closing done");
            tc.remove();
            TestConnectorHome tch1 = (TestConnectorHome)PortableRemoteObject.narrow(ref, TestConnectorHome.class);
            Thread.sleep(100000);
            TestConnector tc1 = tch1.create();
            tc1.lookupFactory("java:1CConnector");
            Thread.sleep(10000);
            System.out.println("Test 2nd connection factory lookup done");
            System.out.println("Testing 2nd connection retrieving...");
            tc1.getConnection();
            Thread.sleep(10000);
            System.out.println("Testing 2nd connection retreving done");
            System.out.println("Testing 2nd connection closing...");
            tc1.closeConnection();
            Thread.sleep(10000);
            System.out.println("Testing 2nd connection closing done");
            tc1.remove();
            Thread.sleep(100000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void getContext() {
        System.out.println("[Client EJB] -> getContext...");
        try {
            System.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            System.setProperty("java.naming.provider.url", "localhost:1099");
            System.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            InitialContext jndiContext = new InitialContext(System.getProperties());
            System.out.println("Got context");
            ref = jndiContext.lookup("TestConnectorBean");
            System.out.println("Got reference");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSessionContext(SessionContext context) throws RemoteException, EJBException {
        System.out.println("[Client EJB] -> setSessionContext...");
        ctx = context;
    }

    public void ejbActivate() throws RemoteException, EJBException {
        System.out.println("[Client EJB] -> ejbActivate...");
    }

    public void ejbPassivate() throws RemoteException, EJBException {
        System.out.println("[Client EJB] -> ejbPassivate...");
    }

    public void ejbRemove() throws RemoteException, EJBException {
        System.out.println("[Client EJB] -> ejbRemove...");
    }

    public void ejbCreate() throws CreateException, EJBException, RemoteException {
        System.out.println("[Client EJB] -> ejbCreate...");
    }

    public void testImportData(DocumentDesc dd) throws Exception {
        System.out.println("[Client EJB] -> testImportData()...");

        //getting remote object
        TestConnectorHome tch = (TestConnectorHome)PortableRemoteObject.narrow(ref, TestConnectorHome.class);
        TestConnector tc = tch.create();

        //Obtaining connection factory of the resource adapter
        System.out.println("Testing 1st connection factory lookup...");
        tc.lookupFactory("java:1CConnector");
        System.out.println("Test 1st connection factory lookup done");

		//retrieving a conncetion
        System.out.println("Testing 1st connection retrieving...");
        tc.getConnection();
        System.out.println("Testing 1st connection retreving done");

        //test interaction implementation by testWriteData() method call of EJB
		tc.testWriteData(dd);

        //Now closing a connection
        System.out.println("Testing 1st connection closing...");
        tc.closeConnection();
        System.out.println("Testing 1st connection closing done");

        //Removing EJB
        tc.remove();
    }
}
