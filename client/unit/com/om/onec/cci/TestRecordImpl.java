package com.om.onec.junit.unit.com.om.onec.adapter.cci;

import junit.framework.*;
import junitx.framework.*;
import com.om.onec.adapter.cci.RecordImpl;
import javax.resource.ResourceException;
import java.util.HashMap;

/** JUnitX PrivateTestCase for testing class com.om.onec.junit.unit.com.om.onec.adapter.cci.RecordImpl
 * @testfamily JUnitX
 * @testkind testcase
 * @testsetup PrivateTestCase
 * @testedclass com.om.onec.adapter.cci.RecordImpl
 * @author Sergey Yu. Terentjev (Squat) DJSquat@mail.ru
 * @version 1.0*/
public class TestRecordImpl extends PrivateTestCase {
    private RecordImpl recImpl;
    /** Constructs a test case with the given name. */
    public TestRecordImpl(String name) {
        super(name);
    }

    /** Sets up the fixture, for example, open a network connection. This method is called before a test is executed. */
    protected void setUp() throws TestAccessException  {
        	recImpl = new RecordImpl("test");

            // Add two elements
            recImpl.addValue("test1", (Object) "test1");
            recImpl.addValue("test2", (Object) "test2");

    }

    public void testGetCount()  throws TestAccessException {
        System.out.println("The \"testGetCount\" is started");
        int Count = recImpl.getCount();
        System.out.println("Returned from function: " + Count);
        HashMap Fields = (HashMap) get(recImpl, "m_fields");
        int CountExpected = Fields.size();
        System.out.println("Returned from variable: " + CountExpected);
        assertEquals("Wrong work of getCount() method", Count, CountExpected);
        System.out.println("Returned value must be: 2");
		assertEquals("getCount() must return 2, but it returns: " + Count, Count, 2);
        System.out.println("The \"testGetCount\" is finished");
    }

    /** Tears down the fixture, for example, close a network connection. This method is called after a test is executed. */
    protected void tearDown() {
        recImpl = null;
    }

    public void testAddValue() throws TestAccessException {
        System.out.println("The \"testAddValue\" is started");
		System.out.println("Adding item \"test3\"=\"test3\"");
        recImpl.addValue("test3", (Object) "test3");
		HashMap Fields = (HashMap) get(recImpl, "m_fields");
        String str = (String) Fields.get("test3");
        System.out.println("The value must be \"test3\"");
        System.out.println("Value is: " + str);
        assertEquals("The value must be \"test3\"", str, "test3");
        System.out.println("The \"testAddValue\" is finished");
    }

    public void testUpdateValue() throws TestAccessException,  ResourceException  {
        System.out.println("The \"testUpdateValue\" is started");
		System.out.println("Updating item \"test2\" to \"NewValue\"");
        recImpl.updateValue("test2", (Object) "NewValue");
        HashMap Fields = (HashMap) get(recImpl, "m_fields");
        String str = (String) Fields.get("test2");
        System.out.println("The value must be \"NewValue\"");
        System.out.println("Value is: " + str);
        assertEquals("The value must be \"NewValue\"", str, "NewValue");
        System.out.println("The \"testUpdateValue\" is finished");
    }

    public void testEquals() throws TestAccessException {
        System.out.println("The \"testEquals\" is started");

        System.out.println("The \"testEquals\" is finished");
    }

    public void testClone() throws TestAccessException {
        System.out.println("The \"testClone\" is started");

        System.out.println("The \"testClone\" is finished");
    }
}
