package com.om.onec.spi;

import java.io.Serializable;
import javax.resource.ResourceException;
import javax.resource.spi.*;

/**
 * @testcase com.om.onec.junit.unit.com.om.onec.adapter.spi.TestDefaultConnectionManager 
 */
public class DefaultConnectionManager implements ConnectionManager, Serializable {
    public DefaultConnectionManager() {
    }

    public Object allocateConnection(ManagedConnectionFactory managedConnectionFactory, ConnectionRequestInfo connectionRequestInfo)
        throws ResourceException {
            ManagedConnectionImpl managedConnection =
                (ManagedConnectionImpl)managedConnectionFactory.createManagedConnection(null, connectionRequestInfo);
            return managedConnection.getConnection(null, connectionRequestInfo);
    }
}
