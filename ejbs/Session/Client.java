/* Generated by Together */

package Session;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import javax.ejb.EJBException;
import javax.resource.ResourceException;
import com.om.onec.DocumentDesc;

public interface Client extends EJBObject {
    public void doTest() throws RemoteException, EJBException;

    public void getContext() throws RemoteException, EJBException;

    void testImportData(DocumentDesc dd)throws RemoteException, EJBException, Exception;

    /** @link dependency */

    /*#ClientBean lnkSession1Bean;*/
}
