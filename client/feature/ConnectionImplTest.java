/* Generated by Together */

package feature;

import com.om.onec.cci.*;
import com.om.onec.spi.*;
import javax.resource.cci.*;
import javax.resource.spi.*;
import javax.security.auth.Subject;
import junit.framework.*;

/** @author Andrej N. Chuchalov */
public class ConnectionImplTest extends TestCase {
    public static Test suite() {
        return new TestSuite(ConnectionImplTest.class);
    }

    public ConnectionImplTest(String name) {
        super(name);
    }

    public void testing() {
        try {
            ManagedConnectionFactoryImpl mcf = new ManagedConnectionFactoryImpl();
            Subject subject = new Subject();
            ManagedConnectionImpl managedConnection = new ManagedConnectionImpl(mcf, subject, null);
            Connection connection = new ConnectionImpl(managedConnection);
            Interaction interaction = connection.createInteraction();
            ConnectionMetaData connectionMetaData = connection.getMetaData();
            ResultSetInfo resultSetInfo = connection.getResultSetInfo();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUp() {
    }

    public void main(String[] args) {
        testing();
    }
}
