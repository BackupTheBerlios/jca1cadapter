/* Generated by Together */

package com.om.onec.cci;

import javax.resource.cci.ResultSet;
import javax.resource.cci.Record;
import javax.resource.*;

import java.math.BigDecimal;

import java.io.InputStream;
import java.io.Reader;
import java.io.IOException;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.SQLWarning;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Ref;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Array;

import java.util.Calendar;
import java.util.Map;

import com.linar.jintegra.*;

/**
 * @author Andrej N. Chuchalov
 * @version 1.00
 * @testcase com.om.onec.junit.unit.com.om.onec.adapter.cci.TestResultSetImpl
 * @stereotype tested
 */
public class ResultSetImpl implements ResultSet {
    private RecordImpl m_record;

    /** @supplierCardinality 0..1 */
    private RecordImpl lnkRecordImpl;

    public ResultSetImpl(RecordImpl record) {
        this.m_record = record;
    }

    public String getRecordName() {
        return m_record.getRecordName();
    }

    public void setRecordName(String par1) {
        m_record.setRecordName(par1);
    }

    public void setRecordShortDescription(String par1) {
        m_record.setRecordShortDescription(par1);
    }

    public String getRecordShortDescription() {
        return m_record.getRecordShortDescription();
    }

    public RecordImpl getRecord() {
        return this.m_record;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean next() {
        return false;
    }

    public void close() {
    }

    public boolean wasNull() {
        return false;
    }

    public String getString(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public boolean getBoolean(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public byte getByte(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public short getShort(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public int getInt(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public long getLong(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public float getFloat(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public double getDouble(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public BigDecimal getBigDecimal(int par1, int par2) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public byte[] getBytes(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public Date getDate(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public Time getTime(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public Timestamp getTimestamp(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public InputStream getAsciiStream(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public InputStream getUnicodeStream(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public InputStream getBinaryStream(int par1) {
        throw new UnsupportedOperationException("Use get operation using column name instead of column index.");
    }

    public String getString(String par1) {
        if (!(m_record.getValue(par1)instanceof Variant)) {
            System.out.println("Unknown data type: " + m_record.getValue(par1).toString());
            return null;
        }
        Variant variantValue = (Variant)m_record.getValue(par1);
        if (variantValue == null) {
            System.out.println("Variant value is null!");
            return null;
        } else {
            System.out.println("Setting string value...");
            String stringValue = variantValue.getBSTR();
            return stringValue;
        }
    }

    public boolean getBoolean(String par1) {
        if (!(m_record.getValue(par1)instanceof Variant)) {
            System.out.println("Unknown data type: " + m_record.getValue(par1).toString());
            return false;
        }
        Variant variantValue = (Variant)m_record.getValue(par1);
        if (variantValue == null) {
            System.out.println("Variant value is null!");
            return false;
        } else {
            System.out.println("Setting string value...");
            boolean booleanValue = variantValue.getBOOL();
            return booleanValue;
        }
    }

    public byte getByte(String par1) {
        if (!(m_record.getValue(par1)instanceof Variant)) {
            System.out.println("Unknown data type: " + m_record.getValue(par1).toString());
            return 0;
        }
        Variant variantValue = (Variant)m_record.getValue(par1);
        if (variantValue == null) {
            System.out.println("Variant value is null!");
            return 0;
        } else {
            System.out.println("Setting string value...");
            byte byteValue = variantValue.getUI1();
            return byteValue;
        }
    }

    public short getShort(String par1) {
        if (!(m_record.getValue(par1)instanceof Variant)) {
            System.out.println("Unknown data type: " + m_record.getValue(par1).toString());
            return 0;
        }
        Variant variantValue = (Variant)m_record.getValue(par1);
        if (variantValue == null) {
            System.out.println("Variant value is null!");
            return 0;
        } else {
            System.out.println("Setting string value...");
            short shortValue = variantValue.getI2();
            return shortValue;
        }
    }

    public int getInt(String par1) {
        if (!(m_record.getValue(par1)instanceof Variant)) {
            System.out.println("Unknown data type: " + m_record.getValue(par1).toString());
            return 0;
        }
        Variant variantValue = (Variant)m_record.getValue(par1);
        if (variantValue == null) {
            System.out.println("Variant value is null!");
            return 0;
        } else {
            System.out.println("Setting string value...");
            int intValue = variantValue.getUI4();
            return intValue;
        }
    }

    public long getLong(String par1) {
/*        Variant variantValue = new Variant(m_record.getValue(par1));
        long longValue = variantValue.toInt();
        return longValue;*/ return 0;
    }

    public float getFloat(String par1) {
        if (!(m_record.getValue(par1)instanceof Variant)) {
            System.out.println("Unknown data type: " + m_record.getValue(par1).toString());
            return 0;
        }
        Variant variantValue = (Variant)m_record.getValue(par1);
        if (variantValue == null) {
            System.out.println("Variant value is null!");
            return 0;
        } else {
            System.out.println("Setting string value...");
            float floatValue = variantValue.getR4();
            return floatValue;
        }
    }

    public double getDouble(String par1) {
        if (!(m_record.getValue(par1)instanceof Variant)) {
            System.out.println("Unknown data type: " + m_record.getValue(par1).toString());
            return 0;
        }
        Variant variantValue = (Variant)m_record.getValue(par1);
        if (variantValue == null) {
            System.out.println("Variant value is null!");
            return 0;
        } else {
            System.out.println("Setting string value...");
            double doubleValue = variantValue.getR8();
            return doubleValue;
        }
    }

    public BigDecimal getBigDecimal(String par1, int par2) {
        throw new UnsupportedOperationException("Data type BigDecimal is not supported.");
    }

    public byte[] getBytes(String par1) {
        throw new UnsupportedOperationException("Data type BigDecimal is not supported.");
    }

    public Date getDate(String par1) {
        if (!(m_record.getValue(par1)instanceof Variant)) {
            System.out.println("Unknown data type: " + m_record.getValue(par1).toString());
            return null;
        }
        Variant variantValue = (Variant)m_record.getValue(par1);
        if (variantValue == null) {
            System.out.println("Variant value is null!");
            return null;
        } else {
            System.out.println("Setting string value...");
            Date dateValue = (java.sql.Date)variantValue.getDATE();
            return dateValue;
        }
    }

    public Time getTime(String par1) {
        throw new UnsupportedOperationException("Data type Time is not supported.");
    }

    public Timestamp getTimestamp(String par1) {
        throw new UnsupportedOperationException("Data type TimeStamp is not supported.");
    }

    public InputStream getAsciiStream(String par1) {
        throw new UnsupportedOperationException("Data type InputStream is not supported.");
    }

    public InputStream getUnicodeStream(String par1) {
        throw new UnsupportedOperationException("Data type InputStream is not supported.");
    }

    public InputStream getBinaryStream(String par1) {
        throw new UnsupportedOperationException("Data type InputStream is not supported.");
    }

    public SQLWarning getWarnings() {
        return null;
    }

    public void clearWarnings() {
    }

    public String getCursorName() {
        return null;
    }

    public ResultSetMetaData getMetaData() {
        return null;
    }

    public Object getObject(int par1) {
        // Write your code here
        return null;
    }

    public Object getObject(String par1) {
        System.out.println("Setting object value...");
        return m_record.getValue(par1);
    }

    public int findColumn(String par1) {
        // Write your code here
        return 0;
    }

    public Reader getCharacterStream(int par1) {
        // Write your code here
        return null;
    }

    public Reader getCharacterStream(String par1) {
        // Write your code here
        return null;
    }

    public BigDecimal getBigDecimal(int par1) {
        // Write your code here
        return null;
    }

    public BigDecimal getBigDecimal(String par1) {
        // Write your code here
        return null;
    }

    public boolean isBeforeFirst() {
        // Write your code here
        return false;
    }

    public boolean isAfterLast() {
        // Write your code here
        return false;
    }

    public boolean isFirst() {
        // Write your code here
        return false;
    }

    public boolean isLast() {
        // Write your code here
        return false;
    }

    public void beforeFirst() {
        // Write your code here
    }

    public void afterLast() {
        // Write your code here
    }

    public boolean first() {
        // Write your code here
        return false;
    }

    public boolean last() {
        // Write your code here
        return false;
    }

    public int getRow() {
        // Write your code here
        return 0;
    }

    public boolean absolute(int par1) {
        // Write your code here
        return false;
    }

    public boolean relative(int par1) {
        // Write your code here
        return false;
    }

    public boolean previous() {
        // Write your code here
        return false;
    }

    public void setFetchDirection(int par1) {
        // Write your code here
    }

    public int getFetchDirection() {
        // Write your code here
        return 0;
    }

    public void setFetchSize(int par1) {
        // Write your code here
    }

    public int getFetchSize() {
        // Write your code here
        return 0;
    }

    public int getType() {
        // Write your code here
        return 0;
    }

    public int getConcurrency() {
        // Write your code here
        return 0;
    }

    public boolean rowUpdated() {
        // Write your code here
        return false;
    }

    public boolean rowInserted() {
        // Write your code here
        return false;
    }

    public boolean rowDeleted() {
        // Write your code here
        return false;
    }

    public void updateNull(int par1) {
        // Write your code here
    }

    public void updateBoolean(int par1, boolean par2) {
        // Write your code here
    }

    public void updateByte(int par1, byte par2) {
        // Write your code here
    }

    public void updateShort(int par1, short par2) {
        // Write your code here
    }

    public void updateInt(int par1, int par2) {
        // Write your code here
    }

    public void updateLong(int par1, long par2) {
        // Write your code here
    }

    public void updateFloat(int par1, float par2) {
        // Write your code here
    }

    public void updateDouble(int par1, double par2) {
        // Write your code here
    }

    public void updateBigDecimal(int par1, BigDecimal par2) {
        // Write your code here
    }

    public void updateString(int par1, String par2) {
        // Write your code here
    }

    public void updateBytes(int par1, byte[] par2) {
        // Write your code here
    }

    public void updateDate(int par1, Date par2) {
        // Write your code here
        
    }

    public void updateTime(int par1, Time par2) {
        // Write your code here
    }

    public void updateTimestamp(int par1, Timestamp par2) {
        // Write your code here
    }

    public void updateAsciiStream(int par1, InputStream par2, int par3) {
        // Write your code here
    }

    public void updateBinaryStream(int par1, InputStream par2, int par3) {
        // Write your code here
    }

    public void updateCharacterStream(int par1, Reader par2, int par3) {
        // Write your code here
    }

    public void updateObject(int par1, Object par2, int par3) {
        // Write your code here
    }

    public void updateObject(int par1, Object par2) {
        // Write your code here
    }

    public void updateNull(String par1) {
        // Write your code here
    }

    public void updateBoolean(String par1, boolean par2) {
        Variant value = new Variant(par1, Variant.VT_BOOL, par2);
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing Boolean parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void updateByte(String par1, byte par2) {
        Variant value = new Variant(par1, Variant.VT_UI1, par2);
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing Byte parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void updateShort(String par1, short par2) {
        Variant value = new Variant(par1, Variant.VT_I2, par2);
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing Short parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void updateInt(String par1, int par2) {
        Variant value = new Variant(par1, Variant.VT_UI4, par2);
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing Integer parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void updateLong(String par1, long par2) {
        // Write your code here
    }

    public void updateFloat(String par1, float par2) {
        Variant value = new Variant(par1, Variant.VT_R4, par2);
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing Float parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void updateDouble(String par1, double par2) {
        Variant value = new Variant(par1, Variant.VT_R8, par2);
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing Double parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void updateBigDecimal(String par1, BigDecimal par2) {
        Variant value = new Variant(par1, Variant.VT_DECIMAL, par2);
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing BigDecimal parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void updateString(String par1, String par2) {
        Variant value = new Variant(par1, Variant.VT_BSTR, par2);
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing String parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void updateBytes(String par1, byte[] par2) {
        // Write your code here
    }

    public void updateDate(String par1, Date par2) {
        Variant value = new Variant(par1, Variant.VT_DATE, par2);
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing Date parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void updateTime(String par1, Time par2) {
        // Write your code here
    }

    public void updateTimestamp(String par1, Timestamp par2) {
        // Write your code here
    }

    public void updateAsciiStream(String par1, InputStream par2, int par3) {
        // Write your code here
    }

    public void updateBinaryStream(String par1, InputStream par2, int par3) {
        // Write your code here
    }

    public void updateCharacterStream(String par1, Reader par2, int par3) {
        // Write your code here
    }

    public void updateObject(String par1, Object par2, int par3) {
    }

    public void updateObject(String par1, Object par2) {
        Variant value = null;
        try {
        	 value = new Variant(par1, Variant.VT_DISPATCH, par2);
        } catch(IOException e) {
            e.printStackTrace();
        }
        try {
            m_record.updateValue(par1, value);
        }
        catch (ResourceException e) {
            e.printStackTrace();
        }
        System.out.println("Storing Dispatch parameter. Total: "+ (new Integer(m_record.getCount())).toString());
    }

    public void insertRow() {
        // Write your code here
    }

    public void updateRow() {
        // Write your code here
    }

    public void deleteRow() {
        // Write your code here
    }

    public void refreshRow() {
        // Write your code here
    }

    public void cancelRowUpdates() {
        // Write your code here
    }

    public void moveToInsertRow() {
        // Write your code here
    }

    public void moveToCurrentRow() {
        // Write your code here
    }

    public Statement getStatement() {
        // Write your code here
        return null;
    }

    public Object getObject(int par1, Map par2) {
        // Write your code here
        return null;
    }

    public Ref getRef(int par1) {
        // Write your code here
        return null;
    }

    public Blob getBlob(int par1) {
        // Write your code here
        return null;
    }

    public Clob getClob(int par1) {
        // Write your code here
        return null;
    }

    public Array getArray(int par1) {
        // Write your code here
        return null;
    }

    public Object getObject(String par1, Map par2) {
        // Write your code here
        return null;
    }

    public Ref getRef(String par1) {
        // Write your code here
        return null;
    }

    public Blob getBlob(String par1) {
        // Write your code here
        return null;
    }

    public Clob getClob(String par1) {
        // Write your code here
        return null;
    }

    public Array getArray(String par1) {
        // Write your code here
        return null;
    }

    public Date getDate(int par1, Calendar par2) {
        // Write your code here
        return null;
    }

    public Date getDate(String par1, Calendar par2) {
        // Write your code here
        return null;
    }

    public Time getTime(int par1, Calendar par2) {
        // Write your code here
        return null;
    }

    public Time getTime(String par1, Calendar par2) {
        // Write your code here
        return null;
    }

    public Timestamp getTimestamp(int par1, Calendar par2) {
        // Write your code here
        return null;
    }

    public Timestamp getTimestamp(String par1, Calendar par2) {
        // Write your code here
        return null;
    }

    public void clear() {
        m_record.clear();
        System.out.println("Clearing parameter list. Total: "+ (new Integer(m_record.getCount())).toString());
    }
}
