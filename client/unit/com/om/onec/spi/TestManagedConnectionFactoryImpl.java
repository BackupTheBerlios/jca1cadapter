/* Generated by Together */
package unit.com.om.onec.spi;

import junit.framework.*;
import com.om.onec.spi.*;
import com.om.onec.cci.*;
import com.om.onec.*;
import javax.resource.spi.*;
import javax.resource.cci.ConnectionFactory;
import javax.resource.ResourceException;
import javax.security.auth.Subject;
import java.util.*;
import java.io.IOException;

/** JUnit TestCase. 
 * @testfamily JUnit
 * @testkind testcase
 * @testsetup Default TestCase
 * @testedclass com.om.onec.adapter.spi.ManagedConnectionFactoryImpl
 * Author Sash
*/
public class TestManagedConnectionFactoryImpl extends TestCase {
    private ManagedConnectionFactoryImpl mcfi;
    private ManagedConnection mc; 
    private ConnectionManager cm;
    private Subject s;

    /** Constructs a test case with the given name. */
    public TestManagedConnectionFactoryImpl(String name) {
        super(name);
    }

    /** Sets up the fixture, for example, open a network connection. This method is called before a test is executed. */
    protected void setUp() throws IOException {
      mcfi = new ManagedConnectionFactoryImpl();
	  assertNotNull("Unable to create managed connection factory", mcfi);

      OneCDBProperties dbp = new OneCDBProperties();

      mcfi.setDbPath(dbp.getDBPath());
      mcfi.setDbUser(dbp.getUserName());
      mcfi.setDbPassword(dbp.getPassword());

      com.linar.jintegra.Cleaner.trackObjectsInCurrentThread();
	  com.linar.jintegra.AuthInfo.setThreadDefault((new AuthProperties()).getAuthInfo());
    }

    /** Tears down the fixture, for example, close a network connection. This method is called after a test is executed. */
    protected void tearDown() {
        // Write your code here
      com.linar.jintegra.Cleaner.releaseAllInCurrentThread();
	  com.linar.jintegra.AuthInfo.setThreadDefault(null);
    }

    public void testCreateConnectionFactory()
        throws ResourceException{
        System.out.println("Testing CreateConnectionFactory(ConnectionManager cm)");
        ConnectionFactoryImpl cf = (ConnectionFactoryImpl)mcfi.createConnectionFactory(null);
        assertNotNull("Unable to create connection factory", cf);
    }

    public void testCreateConnectionFactoryAgain()
        throws ResourceException {
        System.out.println("Testing CreateConnectionFactory()");
        ConnectionFactoryImpl cf = (ConnectionFactoryImpl)mcfi.createConnectionFactory();
        assertNotNull("Unable to create connection factory", cf);
    }

    public void testCreateManagedConnection()
        throws ResourceException {
        System.out.println("Testing CreateManagedConnection");
        ManagedConnectionImpl mc = (ManagedConnectionImpl)mcfi.createManagedConnection(null, null);
        assertNotNull("Unable to create managed connection", mc);
    }

    public void testMatchManagedConnections()
        throws ResourceException {
        System.out.println("Testing MatchManagedConnection");
        Set cset = new HashSet();
        ManagedConnection mc = mcfi.createManagedConnection(null, null);
        cset.add(mc);
        ManagedConnection resmc =
           mcfi.matchManagedConnections(cset,s, null);
        assertNotNull("MatchManagedConnections has null result", resmc);
    }

}
