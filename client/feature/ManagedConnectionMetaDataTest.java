/* Generated by Together */

package com.om.onec.junit.feature;

import com.om.onec.adapter.spi.ManagedConnectionMetaDataImpl;
import junit.framework.*;

/** @author Andrej N. Chuchalov */
public class ManagedConnectionMetaDataTest extends TestCase {
    protected String m_eis = "1C Enterprise";
    protected String m_eisVersion = "7.7";
    protected int m_maxConnections = 999;
    protected String m_userName = "Test";
    protected String m_info;

    public static Test suite() {
        return new TestSuite(ManagedConnectionMetaDataTest.class);
    }

    public ManagedConnectionMetaDataTest(String name) {
        super(name);
    }

    public void testing() {
        try {
            ManagedConnectionMetaDataImpl managedConnectionMetaData =
                new ManagedConnectionMetaDataImpl(m_eis, m_eisVersion, m_maxConnections, m_userName);
            m_eis = managedConnectionMetaData.getEISProductName();
            m_eisVersion = managedConnectionMetaData.getEISProductVersion();
            m_maxConnections = managedConnectionMetaData.getMaxConnections();
            m_userName = managedConnectionMetaData.getUserName();
            m_info = managedConnectionMetaData.toString();
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