package com.om.onec.spi;

import java.io.Serializable;
import java.util.*;
import javax.resource.cci.ConnectionSpec;
import javax.resource.spi.ConnectionRequestInfo;

public class ConnectionRequestInfoMap implements ConnectionRequestInfo, Map, ConnectionSpec, Serializable {
    public ConnectionRequestInfoMap() {
        m_map = new HashMap(10);
    }

    public ConnectionRequestInfoMap(Map map) {
        if (map != null)
            m_map = map;
    }

    public void clear() throws UnsupportedOperationException {
        m_map.clear();
    }

    public boolean containsKey(Object obj) throws ClassCastException, NullPointerException {
        return m_map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return m_map.containsValue(obj);
    }

    public Set entrySet() {
        return m_map.entrySet();
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if (obj != null && (obj instanceof ConnectionRequestInfoMap)) {
            ConnectionRequestInfoMap connectionrequestinfomap = (ConnectionRequestInfoMap)obj;
            flag = m_map.equals(connectionrequestinfomap.m_map);
        }
        return flag;
    }

    public Object get(Object obj) throws ClassCastException, NullPointerException {
        return m_map.get(obj);
    }

    public int hashCode() {
        return m_map.hashCode();
    }

    public boolean isEmpty() {
        return m_map.isEmpty();
    }

    public Set keySet() {
        return m_map.keySet();
    }

    public Object put(Object obj, Object obj1) throws UnsupportedOperationException, ClassCastException,
        IllegalArgumentException, NullPointerException {
            return m_map.put(obj, obj1);
    }

    public void putAll(Map map) throws UnsupportedOperationException, ClassCastException,
        IllegalArgumentException, NullPointerException {
            m_map.putAll(map);
    }

    public Object remove(Object obj) throws UnsupportedOperationException {
        return m_map.remove(obj);
    }

    public int size() {
        return m_map.size();
    }

    public Collection values() {
        return m_map.values();
    }

    private static final int iINITIAL_CAPACITY = 10;
    private Map m_map;
}
