/* Generated by Together */

package com.om.onec.junit.feature;

import com.om.onec.adapter.cci.ConnectionFactoryImpl;
import com.om.onec.adapter.spi.ManagedConnectionFactoryImpl;
import javax.resource.spi.ConnectionManager;
import javax.resource.cci.*;
import javax.resource.NotSupportedException;
import javax.naming.*;
import junit.framework.*;

/** @author Andrej N. Chuchalov */
public class ConnectionFactoryImplTest extends TestCase {
    private ConnectionFactoryImpl m_cf;
    private InitialContext ctx;

    public static Test suite() {
        return new TestSuite(ConnectionFactoryImplTest.class);
    }

    public ConnectionFactoryImplTest(String name) {
        super(name);
    }

    public void testing() {
        try {
            m_cf = (ConnectionFactoryImpl)ctx.lookup("java:comp/env/eis/OneC");
            assertNull("Connection Factory was not found.", m_cf);
            Connection connection = m_cf.getConnection();
            assertNull("No connection could be found.", connection);
            Reference ref = new Reference("");
            m_cf.setReference(ref);
            ref = m_cf.getReference();
            assertNull("Null reference", ref);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUp() throws NamingException {
        System.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        System.setProperty("java.naming.provider.url", "localhost:1099");
        ctx = new InitialContext();
    }

    public void main(String[] args) {
        testing();
    }
}