/* Generated by Together */

package com.om.onec.cci;

import javax.resource.cci.RecordFactory;
import javax.resource.ResourceException;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.IndexedRecord;

public class RecordFactoryImpl implements RecordFactory {
    public MappedRecord createMappedRecord(String recordName) throws ResourceException {
        MappedRecordImpl result = new MappedRecordImpl();
        result.setRecordName(recordName);
        return result;
    }

    public IndexedRecord createIndexedRecord(String recordName) throws ResourceException {
        throw new ResourceException("Indexed records are not supported.");
    }
}
