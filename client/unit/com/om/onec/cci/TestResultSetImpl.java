package com.om.onec.junit.unit.com.om.onec.adapter.cci;

import junit.framework.*;
import junitx.framework.*;
import com.om.onec.adapter.cci.ResultSetImpl;
import com.om.onec.adapter.cci.RecordImpl;
import javax.resource.cci.Record;
import java.util.HashMap;
import com.linar.jintegra.Variant;

/** JUnitX PrivateTestCase. 
 * @testfamily JUnitX
 * @testkind testcase
 * @testsetup PrivateTestCase
 * @testedclass com.om.onec.adapter.cci.ResultSetImpl
 * @author Sergey Yu. Terentjev (Squat) DJSquat@mail.ru
 * @version 1.0*/
public class TestResultSetImpl extends PrivateTestCase {
    private RecordImpl recImpl ;
    private ResultSetImpl rsi;
    /** Constructs a test case with the given name. */
    public TestResultSetImpl(String name) {
        super(name);
    }

    /** Sets up the fixture, for example, open a network connection. This method is called before a test is executed. */
    protected void setUp() {
        recImpl = new RecordImpl("test");
        rsi = new ResultSetImpl(recImpl);

    }

    /** Tears down the fixture, for example, close a network connection. This method is called after a test is executed. */
    protected void tearDown() {
		recImpl = null;
        rsi = null;
    }


    public void testString() throws TestAccessException {
        String test = new String("Test");
        rsi.updateString("test", test);
        String test2 = rsi.getString("test");
        assert("Error reading/writing string", test.equalsIgnoreCase(test2));
    }

    public void testByte() throws TestAccessException {
        byte test = 5;
        rsi.updateByte("test", test);
        byte test2 = rsi.getByte("test");
        assert("Error reading/writing byte", (test==test2));
    }

    public void testFloat() throws TestAccessException {
        float test = 5;
        rsi.updateFloat("test", test);
        float test2 = rsi.getFloat("test");
        assert("Error reading/writing float", test2>0);
    }

    public void testDouble() throws TestAccessException {
        double test = 5;
        rsi.updateDouble("test", test);
        double test2 = rsi.getDouble("test");
        assert("Error reading/writing double", test>0);
    }

    public void testObject() throws TestAccessException {
        Object test = new Object();
        rsi.updateObject("test", test);
        Object test2 = rsi.getObject("test");
        assertNotNull("Error reading/writing object", test2);
    }





}
