/* Generated by Together */

package com.om.onec.cci;

import javax.resource.cci.MappedRecord;
import java.util.Hashtable;

/**
 * @testcase com.om.onec.junit.unit.com.om.onec.adapter.cci.TestMappedRecordImpl
 * @stereotype tested 
 */
public class MappedRecordImpl extends Hashtable implements MappedRecord {
    private String m_recordName;
    private String m_description;

    /** @supplierCardinality 0..* */
    private ResultSetImpl lnkResultSetImpl;

    public MappedRecordImpl() {
        put("import", new ResultSetImpl(new RecordImpl("")));
        put("export", new ResultSetImpl(new RecordImpl("")));
    }

    public String getRecordName() {
        return this.m_recordName;
    }

    public void setRecordName(String par1) {
        this.m_recordName = par1;
    }

    public void setRecordShortDescription(String par1) {
        this.m_description = par1;
    }

    public String getRecordShortDescription() {
        return this.m_description;
    }
}
