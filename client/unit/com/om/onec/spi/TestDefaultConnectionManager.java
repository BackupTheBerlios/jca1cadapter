package unit.com.om.onec.spi;

import junit.framework.*;
import com.om.onec.spi.*;
import com.om.onec.cci.*;
import com.om.onec.*;

import java.io.IOException;


/** JUnit TestCase. 
 * @testfamily JUnit
 * @testkind testcase
 * @testsetup Default TestCase
 * @testedclass com.om.onec.adapter.spi.DefaultConnectionManager*/
public class TestDefaultConnectionManager extends TestCase {
    ManagedConnectionFactoryImpl mcf;
    DefaultConnectionManager dcm;
    ConnectionImpl c;

    /** Constructs a test case with the given name. */
    public TestDefaultConnectionManager(String name) {
        super(name);
    }

    /** Sets up the fixture, for example, open a network connection. This method is called before a test is executed. */
    protected void setUp() throws IOException {
        mcf = new ManagedConnectionFactoryImpl();
        dcm = new DefaultConnectionManager();

        OneCDBProperties dbp = new OneCDBProperties();

        mcf.setDbPath(dbp.getDBPath());
        mcf.setUserName(dbp.getUserName());
        mcf.setPassword(dbp.getPassword());

        com.linar.jintegra.Cleaner.trackObjectsInCurrentThread();
	    com.linar.jintegra.AuthInfo.setThreadDefault((new AuthProperties()).getAuthInfo());
    }

    /** Tears down the fixture, for example, close a network connection. This method is called after a test is executed. */
    protected void tearDown() {

        com.linar.jintegra.Cleaner.releaseAllInCurrentThread();
	    com.linar.jintegra.AuthInfo.setThreadDefault(null);

        dcm=null;
        c=null;
        mcf=null;
    }

    public void testAllocateConnection() throws javax.resource.ResourceException {
        assertNotNull("Failed to Associate connection", dcm.allocateConnection(mcf, null));
    }
}
