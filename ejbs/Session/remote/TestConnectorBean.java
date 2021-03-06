/* Generated by Together */

package Session.remote;

import com.om.onec.cci.*;
import com.om.onec.spi.ManagedConnectionImpl;
import com.om.onec.*;
import com.om.onec.DocumentDesc;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.naming.*;
import javax.resource.ResourceException;

import java.rmi.RemoteException;
import java.io.IOException;

import onec.IDispatchProxy;

import com.linar.jintegra.*;

/**
 * @ejbHome <{com.om.onec.junit.ejbs.Session.TestConnectorHome}>
 * @ejbRemote <{com.om.onec.junit.ejbs.Session.TestConnector}>
 * @author Sergey Yu. Terentjev
 * @version 1.0
 * @description Test recieving connection from Connector deployed to JBoss server
 * @ejbStateful
 */
public class TestConnectorBean implements SessionBean {
    private SessionContext ctx;
    private InitialContext iCtx;
    private ConnectionFactoryImpl cf;
    private ConnectionImpl c;
    private ConnectionSpecImpl ConnectionProperties;

    public void setSessionContext(SessionContext context) throws RemoteException, EJBException {
        System.out.println("[EJB] -> setSessionContext");
        ctx = context;
    }

    public boolean getConnection() {
        try {
            System.out.println("Retrieving connection...");
            if (ConnectionProperties == null)
                c = (ConnectionImpl)cf.getConnection();
            else
                c = (ConnectionImpl)cf.getConnection(ConnectionProperties);
            if (c != null) {
                System.out.println("Retrieving connection done");
                return true;
            }
            else {
                System.out.println("Retrieving connection failed");
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean closeConnection() {
        try {
            System.out.println("Closing connection...");
            c.close();
            ManagedConnectionImpl mc = (ManagedConnectionImpl)PrivilegedAccessor.getValue(c, "mc");
            if (mc != null) {
                System.out.println("Closing connection failed");
                return false;
            }
            else {
                System.out.println("Closing connection done");
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ConnectionFactoryImpl getConnectionFactory() {
        return this.cf;
    }

    public ConnectionImpl getConnectionHandle() {
        return this.c;
    }

    public void ejbActivate() throws RemoteException, EJBException {
        System.out.println("[EJB] -> ejbActivate");
    }

    public boolean lookupFactory(String jndiName) {
        try {
            System.out.println("[EJB] -> lookupFactory: Looking up connection factory...");
            Object lf = iCtx.lookup(jndiName);
            if (lf == null) {
                System.out.println("lookup in lookupFactory returned null for specified jndi name!");
            } else {
                System.out.println("result of lookup is: " + lf.toString());
            }
            cf = (ConnectionFactoryImpl)lf;
            if (cf != null) {
                System.out.println("[EJB] -> lookupFactory: Looking up connection factory done");
                return true;
            }
            else {
                System.out.println("[EJB] -> lookupFactory: Looking up connection factory failed");
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void ejbPassivate() throws RemoteException, EJBException {
        System.out.println("[EJB] -> ejbPassivate");
    }

    public void ejbRemove() throws RemoteException, EJBException {
        System.out.println("[EJB] -> ejbRemove");
    }

    public void ejbCreate() throws CreateException, EJBException, RemoteException {
        try {
            System.out.println("[EJB] -> ejbCreate: Creating initial context...");
            iCtx = new InitialContext();

            /*remove that for __Container-managed Sign-on EIS__*/

//            ConnectionProperties = new ConnectionSpecImpl("", "");
            System.out.println("[EJB] -> ejbCreate: Creating initial context done");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int testJavaTestAsInt(int aValue) throws ResourceException {
/*        // Create instance of Interaction
        InteractionImpl i = (InteractionImpl)c.createInteraction();
        // Create MappedRecord for data exchange zwischen Adapter and ERP
        MappedRecordImpl mr = (MappedRecordImpl)cf.getRecordFactory().createMappedRecord("");
        // Create input parameters
        ResultSetImpl rs = (ResultSetImpl)mr.get("import");
        // Set the value to aValue
        rs.updateInt("param1", aValue);
        // Create InteractionSpec to set addition parameters, in our case -
        // function name
        InteractionSpecImpl is = new InteractionSpecImpl(0, "javatest");
        // Try to execute ERP function if failed - returns -1
        if (!i.execute(is, mr, mr)) {
            // Execution failed!!
            System.out.println("Execution failed");
            return -1;
        } else {
            // Try to get output results from ERP
            ResultSetImpl rse = (ResultSetImpl)mr.get("export");
            // Check if we have the result set if no - returns -2
            if (rse == null) {
                // No result set from ERP
                System.out.println("ResultSet is null");
            }
            System.out.println("Export data exists...");
            // Get returned from ERP value
            int res = rse.getInt("param1");
            // Return real value from ERP
            return res;
        }*/
        return 0;
    }

    public void testWriteData(DocumentDesc dd) throws ResourceException {
        try { AuthInfo.setThreadDefault((new AuthProperties()).getAuthInfo());
	} catch(Exception e) { }
        Cleaner.trackObjectsInCurrentThread();

        try {

            //Declaring dispatch objects
	        IDispatchProxy system=null;
    	    IDispatchProxy tovar=null;
            IDispatchProxy currentTovar=null;
        	IDispatchProxy doc=null;

	   		// Create instance of InteractionSpec
    	   	InteractionSpecImpl is = new InteractionSpecImpl(0, "createobject");

            //Obtaining and setting 1C system handle
        	system = (IDispatchProxy)c.getManagedConnection().getClient();
			is.setDispatchObject(system);

    	    // Create MappedRecord for data exchange zwischen Adapter and ERP
			MappedRecordImpl mr = (MappedRecordImpl)cf.getRecordFactory().createMappedRecord("");

    	   	// Create input parameters
			ResultSetImpl rsi = (ResultSetImpl)mr.get("import");
    	    ResultSetImpl rse = (ResultSetImpl)mr.get("export");

            //Define object to create and update input parameter
			String objectName = "����������.������������"; //Setting object name
			rsi.updateString("param1", objectName); //adding parameter value

            //Creating interaction instance
			InteractionImpl i = (InteractionImpl)c.createInteraction(); //creating Interaction
			i.execute(is, mr, mr); //execute

            //new dispatch object - tovar
            tovar = new IDispatchProxy(rse.getObject("param1")); //extracting results

            //Find tovar by code
            System.out.println("Executing: FindByCode()");
            is.setDispatchObject(tovar); 			//Setting new dispatch object
            is.setFunctionName("FindByCode");	//Setting function name - New
            rsi.clear(); 						//Clearing input parameters
            rse.clear(); 						//Clearing output parameters
            rsi.updateFloat("param1", dd.getCode());	//Updating 1st parameter
            rsi.updateFloat("param2", 0);		//Updating 2nd parameter
            i.execute(is, mr, mr); 				//Executing function

            float result = rse.getFloat("param1"); //checking result of function execution

            //Setting pointer to current tovar
            is.setFunctionName("CurrentItem");
            rsi.clear();
            rse.clear();
            i.execute(is, mr, mr);

            //This pointer we will add to our document
            currentTovar = new IDispatchProxy(rse.getObject("param1"));

            /**
            * Next section creates
            * new document named in objectName
            * */
            //restoring system dispatch object stored in 'system'
	        is.setDispatchObject(system);
            is.setFunctionName("createobject");	//We create new object
			rsi.clear();
        	rse.clear();
			objectName = "��������.������������������"; //Setting object name
			rsi.updateString("param1", objectName); //adding parameter value

			i.execute(is, mr, mr); //execute

			doc = new IDispatchProxy(rse.getObject("param1")); //extracting results

            //Creating new document format - New()
            System.out.println("Executing: New()");
            is.setDispatchObject(doc); 			//Setting new dispatch object
            is.setFunctionName("New"); 			//Setting function name - New
            rsi.clear(); 						//Clearing input parameters
            rse.clear(); 						//Clearing output parameters
            i.execute(is, mr, mr); 				//Executing function

            //Setting time settings to use current
            System.out.println("Executing: AutoTimeCurrent()");
            rsi.clear();
            rse.clear();
            is.setFunctionName("AutoTimeCurrent");
            i.execute(is, mr, mr);

            //Adding new line
            System.out.println("Executing: NewLine()");
            rsi.clear();
            rse.clear();
            is.setFunctionName("NewLine");
            i.execute(is, mr, mr);

            //Setting attribute format - SetAttrib(<attribute_name>, <attribute_value>)
            System.out.println("Executing: SetAttrib()");
            is.setFunctionName("setAttrib");
            rsi.clear();
            rsi.updateString("param1", "�����");  			//Setting String parameter
            rsi.updateObject("param2", currentTovar);				//Inserting our pointer created before
            rse.clear();
            i.execute(is, mr, mr);

            //Setting attribute format - SetAttrib(<attribute_name>, <attribute_value>)
            System.out.println("Executing: SetAttrib()");
            rsi.clear();
            rsi.updateString("param1", "����������");  	//Setting String parameter
            rsi.updateFloat("param2", dd.getQuantity());					//Setting Integer parameter
            rse.clear();
            i.execute(is, mr, mr);

            //Setting price
            System.out.println("Executing: SetAttrib()");
            rsi.clear();
            rsi.updateString("param1", "����");  	//Setting String parameter
            rsi.updateFloat("param2", dd.getPrice());					//Setting Integer parameter
            rse.clear();
            i.execute(is, mr, mr);

            //Storing document format - Write()
            System.out.println("Executing: Write()");
            rsi.clear();
            rse.clear();
            is.setFunctionName("Write");
            i.execute(is, mr, mr);

            //MakeActions
            System.out.println("Executing: MakeActions()");
            rsi.clear();
            rse.clear();
            is.setFunctionName("MakeActions");
            i.execute(is, mr, mr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
		System.out.println("Cleaning objects in current thread...");
        	Cleaner.releaseAllInCurrentThread();		
		System.out.println("...done");
		AuthInfo.setThreadDefault(null);
        };
    }
}
