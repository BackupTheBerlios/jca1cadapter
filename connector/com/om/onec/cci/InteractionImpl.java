/* Generated by Together */

package com.om.onec.cci;

//import
import javax.resource.ResourceException;
import javax.resource.cci.*;

import com.om.onec.spi.ManagedConnectionImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.io.IOException;

import com.linar.jintegra.*;

import onec.IDispatchProxy;

/**
 * class implements EIS function access mechanism
 * @author Andrej N. Chuchalov
 * @version 1.3
 * @testcase com.om.onec.junit.unit.com.om.onec.adapter.cci.TestInteractionImpl
 */
public class InteractionImpl implements Interaction {
    /**
     * class constructor
     */
    public InteractionImpl(Connection connection) {
        m_connection = (ConnectionImpl)connection;
    }

    public void clearWarnings() {
    }

    public ResourceWarning getWarnings() {
        return null;
    }

    public void close() throws ResourceException {
        m_connection.close();
    }

    public Connection getConnection() {
        return m_connection;
    }

    private void exec(String functionName, int functionMethod, Record record)
        throws ResourceException, NoSuchMethodException, IOException, NoSuchFieldException {

        // Variable to store result of execution
        Object res=null;
        //Parameter list
        Variant[] vParams = null;

        //Input parameters reference
        RecordImpl rec = ((ResultSetImpl)((MappedRecordImpl)record).get("import")).getRecord();
        System.out.println("Transferred "+rec.getCount()+" parameters.");

        /**
        * next section defines which method to use
        * InteractionSpecImpl.MID_CALL calls method of EIS instance
        * InteractionSpecImpl.MID_GET gets object attribute
        * InteractionSpecImpl.MID_PUT puts object attribute
        * */
        //Calling 1C function
        switch(functionMethod) {
        case InteractionSpecImpl.MID_CALL: //method calling
        	//retrieving parameters list
            int vCount = rec.getCount(); //total parameters
       		vParams = new Variant[vCount]; //parameter list

            //adding each parameter to parameter list
            for(int i=0; i<vCount; i++) {
                Integer id = new Integer(i+1);
                Object o = rec.getValue("param"+id.toString());
                //checking if stored parameter has a valid type of Variant
                if(!(o instanceof Variant)) {
                    throw new ResourceException("Inavlid store format. Expecting Variant, but found: "+o.toString());
                }
                Variant value = (Variant)o;
                vParams[i] = value; //add value to list
            }
            res = m_dp.invokeMethodByName(functionName, vParams); //method execution
            break;

        case InteractionSpecImpl.MID_GET: //get attribute
            res = m_dp.getPropertyByName(functionName);
        	break;

        case InteractionSpecImpl.MID_PUT: //put attribute
            vParams = new Variant[] {(Variant)rec.getValue("param1")}; //just one parameter available
            m_dp.setPropertyByName(functionName, vParams);
            break;

        //this applies if method id is out of specified above range
        default: throw new ResourceException("Method not supported.");
        }
        //logging execution success
        System.out.println("[Interaction] -> Execute: done...");

        //check if there is a execution result
        if(res!=null) {

            //get export record reference
	        ResultSetImpl rse = (ResultSetImpl)((MappedRecordImpl)record).get("export");
    	    System.out.println("[Interaction] -> Execute: setting results...");

            //result is a single value
        	rse.getRecord().getFields().put("param1", res);
        	System.out.println("[Interaction] -> Execute: adding value... " + res.toString());
        }
    }

    /**
     * Method execute(InteractionSpec interactionSpec, Record input, Record output)
     * checks for valid parameters used to execute method of EIS
     */
    public boolean execute(InteractionSpec interactionSpec, Record input, Record output)
        throws ResourceException {
        //Have to instantiate InteractionSpec value to execute
        if (interactionSpec == null) {
            throw new ResourceException("Undefined InteractionSpec parameter. Cannot execute!");
        }
        //Obtainig function name to execute
        String functionName = ((InteractionSpecImpl)interactionSpec).getFunctionName();
		//Obtaining function method
        int functionMethod = ((InteractionSpecImpl)interactionSpec).getFunctionMethod();
        //functionName is nesessary parameter
        if (((functionName == null) || (functionName.equals("")))&&(!(functionMethod==InteractionSpecImpl.MID_CALL))) {
            throw new ResourceException("Undefined function name for method CALL in the InteractionSpec parameter.");
        }
        //checking function method range
        if ((!(functionMethod==InteractionSpecImpl.MID_CALL))&&(!(functionMethod==InteractionSpecImpl.MID_GET))&&
            (!(functionMethod==InteractionSpecImpl.MID_PUT))) {
            throw new ResourceException("Unsupported function method.");
        }

        //obtaining dispatch object
        m_dp = ((InteractionSpecImpl)interactionSpec).getDispatchObject();
        if (m_dp==null) {
            throw new ResourceException("No dispatch object defined.");
        }
        try {
            //function execution
        	exec(functionName, functionMethod, input);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Record execute(InteractionSpec interactionSpec, Record input) throws ResourceException {
        if(execute(interactionSpec, input, input)) {
        	return input;
        }
        else {
            return null;
        }
    }

    /** ���������� ���������� �������� ������ �� ������ Connection */
    private ConnectionImpl m_connection;

    /** @supplierCardinality 0..1 */
    private InteractionSpecImpl lnkInteractionSpecImpl;

    /** @supplierCardinality 0..1 */
    private RecordFactoryImpl lnkRecordFactoryImpl;

    /** @supplierCardinality 0..* */
    private MappedRecordImpl lnkMappedRecordImpl;

    private IDispatchProxy m_dp;
}
