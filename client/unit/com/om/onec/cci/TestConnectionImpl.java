/* Generated by Together */

package unit.com.om.onec.cci;

import junit.framework.*;
import junitx.framework.*;

import com.om.onec.spi.*;
import com.om.onec.cci.*;
import com.om.onec.*;
import com.linar.jintegra.*;

import java.io.IOException;

import javax.resource.ResourceException;

public class TestConnectionImpl extends TestCase {
    private ManagedConnectionFactoryImpl mcf;
    private ManagedConnectionImpl mc;
    private InteractionImpl i;
    private ConnectionImpl c;

    public TestConnectionImpl(String name) {
        super(name);
    }

    public void setUp() throws IOException, ResourceException {
        com.linar.jintegra.Cleaner.trackObjectsInCurrentThread();
	    com.linar.jintegra.AuthInfo.setThreadDefault((new AuthProperties()).getAuthInfo());

        mcf = new ManagedConnectionFactoryImpl();

        OneCDBProperties dbp = new OneCDBProperties();

        mcf.setDbPath(dbp.getDBPath());
        mcf.setDbUser(dbp.getUserName());
        mcf.setDbPassword(dbp.getPassword());

        mc = (ManagedConnectionImpl)mcf.createManagedConnection(null, null);

        c = new ConnectionImpl(mc);

    }

    public void tearDown() throws ResourceException {
        if(mc.getClient()!=null) mc.destroy();
        mc=null;

        mcf=null;
        i=null;

        com.linar.jintegra.Cleaner.releaseAllInCurrentThread();
	    com.linar.jintegra.AuthInfo.setThreadDefault(null);

    }

    public void testCreateInteraction() throws ResourceException {
        assertNotNull("Unable to create interaction", c.createInteraction());
    }

    public void testGetManagedConnection() throws ResourceException {
        assertNotNull("Unable to get ManagedConnection", c.getManagedConnection());
    }

    public void testClose() throws ResourceException {
        c.close();
        assertNull("Close failed", c.getManagedConnection());
    }

}
