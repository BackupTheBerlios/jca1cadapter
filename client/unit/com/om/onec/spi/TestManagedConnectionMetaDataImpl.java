/* Generated by Together */

package unit.com.om.onec.spi;

import junit.framework.*;
import com.om.onec.spi.ManagedConnectionMetaDataImpl;

/** JUnit TestCase. 
 * @testfamily JUnit
 * @testkind testcase
 * @testsetup Default TestCase
 * @testedclass com.om.onec.adapter.spi.ManagedConnectionImpl
 * Author Sash
*/
public class TestManagedConnectionMetaDataImpl extends TestCase {
    private String EISname = "1C Enterprise";
    private String EISversion = "version 7.7";
    private int maxCon = 100;
    private String username = "TestName";
    private ManagedConnectionMetaDataImpl mcmdi;

/** Constructs a test case with the given name. */
    public TestManagedConnectionMetaDataImpl(String name) {
    	super(name);
    }
    /** Sets up the fixture, for example, open a network connection. This method is called before a test is executed. */
    protected void setUp() {
        mcmdi = new ManagedConnectionMetaDataImpl(EISname,EISversion,
            maxCon,username);
    }
    /** Tears down the fixture, for example, close a network connection. This method is called after a test is executed. */
    protected void tearDown() {
        // Write your code here
    }

	public void testGetEISProductName() {
        //System.out.println("Testing getEISProductName()...");
        assertEquals("Invoked method getEISProductName FAILED!",EISname,
            mcmdi.getEISProductName());
        System.out.println("EISProductName - " + EISname);
    }

    public void testGetEISProductVersion() {
        assertEquals("Invoked method getEISProductVersion FAILED!",EISversion,
            mcmdi.getEISProductVersion());
        System.out.println("EISProductVersion - " + EISversion);
    }

    public void testGetMaxConnections() {
        assertEquals("Invoked method getMaxConnections FAILED!",maxCon,
            mcmdi.getMaxConnections());
        System.out.println("Max connections value is - " + maxCon);
    }

    public void testGetUserName() {
        assertEquals("Invoked method getUserName FAILED!",username,
            mcmdi.getUserName());
        System.out.println("UserName - " + username);
    }

    public void testToString() {
        System.out.println(mcmdi.toString());
    }
}
