/* Generated by Together */

package unit.com.om.onec.spi;

import junit.framework.*;
import junitx.framework.*;
import com.om.onec.spi.*;
import com.om.onec.cci.*;
import com.om.onec.*;
import javax.resource.spi.*;
import javax.resource.cci.*;
import javax.resource.ResourceException;
import javax.security.auth.Subject;
import java.util.HashSet;
import onec.IDispatchProxy;
import java.io.*;
/** JUnit TestCase. 
 * @testfamily JUnit
 * @testkind testcase
 * @testsetup Default TestCase
 * @testedclass com.om.onec.adapter.spi.ManagedConnectionImpl
 * Author Sash
*/
public class TestManagedConnectionImpl extends PrivateTestCase {
    private ManagedConnectionFactoryImpl mcfi;
    private ManagedConnectionImpl mci;
    private Connection con;
    private Subject s;

    /** Constructs a test case with the given name. */
    public TestManagedConnectionImpl(String name) {
    	super(name);
    }

    /** Sets up the fixture, for example, open a network connection. This method is called before a test is executed. */
    protected void setUp()
     throws ResourceException, IOException {
       mcfi = new ManagedConnectionFactoryImpl();
	   assertNotNull("Unable to create managed connection factory", mcfi);

       OneCDBProperties dbp = new OneCDBProperties();

       mcfi.setDbPath(dbp.getDBPath());
       mcfi.setDbUser(dbp.getUserName());
       mcfi.setDbPassword(dbp.getPassword());

       s = new Subject();
       System.out.println("Creating managedConnectionImpl...");
	   mci = (ManagedConnectionImpl)mcfi.createManagedConnection(s, null);
	   assertNotNull("Unable to create managedConnectionImpl", mci);
    }

    /** Tears down the fixture, for example, close a network connection. This method is called after a test is executed. */
    protected void tearDown() throws ResourceException {
        // Write your code here
        if(mci.getClient()!=null)
            mci.destroy();
        mci=null;
        mcfi=null;
        s=null;
    }

    public void testGetConnection()
        throws ResourceException {
        System.out.println("Testing GetConnection()");
        con = (Connection) mci.getConnection(s,null);
        assertNotNull("Unable to get connection", con);
    }

    public void testAssociateConnection()
        throws ResourceException {
        System.out.println("Testing AssociateConnection()...");
        con = (Connection) mci.getConnection(s,null);
        mci.associateConnection(con);
    }

    public void testRemoveConnection ()
        throws ResourceException, TestAccessException {
        System.out.println("Testing removeConnection()...");
        con = (Connection) mci.getConnection(s,null);
        HashSet ts = (HashSet)get(mci,"m_connections");
	    assertTrue("HashSet not null!",!(ts.isEmpty()));

        mci.removeConnection(con);
        ts = (HashSet)get(mci,"m_connections");
		assertTrue("HashSet not null!",ts.isEmpty());
    }

 	public void testCleanup () throws ResourceException {
        System.out.println("Testing cleanup()...");
        mci.cleanup();
    }

    public void testDestroy ()
      throws ResourceException, TestAccessException {
        System.out.println("Testing destroy()...");
        con = (Connection) mci.getConnection(s,null);

		HashSet ts = (HashSet)get(mci,"m_connections");
        assertTrue("HashSet null!",!(ts.isEmpty()));
        Subject sub = (Subject)get(mci,"m_subject");
        assertNotNull("Subject null!",sub);
        IDispatchProxy d = (IDispatchProxy)get(mci,"m_dispatchProxy");
        assertNotNull("Dispatch null!",d);

		mci.destroy();

        ts = (HashSet)get(mci,"m_connections");
        assertTrue("HashSet not null!",ts.isEmpty());
        sub = (Subject)get(mci,"m_subject");
        assertNull("Subject not null!",sub);
        d = (IDispatchProxy)get(mci,"m_dispatchProxy");
        assertNull("Dispatch not null!",d);
    }
/*
    public void testAddConnectionEventListener() {
        //add code here
    }

     public void testRemoveConnectionEventListener() {
        //add code here
    }
*/

}