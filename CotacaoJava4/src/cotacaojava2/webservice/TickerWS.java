/**
 * TickerWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public interface TickerWS extends javax.xml.rpc.Service {
    public java.lang.String getTickerWSSoapAddress();

    public TickerWSSoap getTickerWSSoap() throws javax.xml.rpc.ServiceException;

    public TickerWSSoap getTickerWSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
