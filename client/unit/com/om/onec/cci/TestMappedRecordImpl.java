package unit.com.om.onec.cci;

import junit.framework.*;
import junitx.framework.*;
import com.om.onec.cci.MappedRecordImpl;
import com.om.onec.cci.ResultSetImpl;
import com.om.onec.cci.RecordImpl;
import javax.resource.cci.Record;
import javax.resource.cci.ResultSet;
import java.util.HashMap;
import com.linar.jintegra.Variant;

/** JUnitX PrivateTestCase. 
 * @testfamily JUnitX
 * @testkind testcase
 * @testsetup PrivateTestCase
 * @testedclass com.om.onec.adapter.cci.MappedRecordImpl
 * @author Sergey Yu. Terentjev (Squat) DJSquat@mail.ru
 * @version 1.0*/
public class TestMappedRecordImpl extends PrivateTestCase {

    private MappedRecordImpl mri;

    /** Constructs a test case with the given name. */
    public TestMappedRecordImpl(String name) {
        super(name);
    }

    /** Sets up the fixture, for example, open a network connection. This method is called before a test is executed. */
    protected void setUp() {
        mri = new MappedRecordImpl();
    }

    /** Tears down the fixture, for example, close a network connection. This method is called after a test is executed. */
    protected void tearDown() {
        mri = null;
    }

    public void testConstructor() throws TestAccessException {
        System.out.println("The \"testConstructor\" is started...");
		ResultSet rsi = (ResultSet) mri.get("import");
        assertNotNull("Import result set is null", rsi);
		ResultSet rse = (ResultSet) mri.get("export");
        assertNotNull("Import result set is null", rse);
        System.out.println("The \"testConstructor\" is finished");
    }

}
