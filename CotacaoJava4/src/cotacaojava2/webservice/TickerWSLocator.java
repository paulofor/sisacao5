/**
 * TickerWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public class TickerWSLocator extends org.apache.axis.client.Service implements TickerWS {

    public TickerWSLocator() {
    }


    public TickerWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TickerWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TickerWSSoap
    private java.lang.String TickerWSSoap_address = "http://digicom.kinghost.net/sisacaoweb2online/ws/TickerWS.asmx";

    public java.lang.String getTickerWSSoapAddress() {
        return TickerWSSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TickerWSSoapWSDDServiceName = "TickerWSSoap";

    public java.lang.String getTickerWSSoapWSDDServiceName() {
        return TickerWSSoapWSDDServiceName;
    }

    public void setTickerWSSoapWSDDServiceName(java.lang.String name) {
        TickerWSSoapWSDDServiceName = name;
    }

    public TickerWSSoap getTickerWSSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TickerWSSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTickerWSSoap(endpoint);
    }

    public TickerWSSoap getTickerWSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            TickerWSSoapStub _stub = new TickerWSSoapStub(portAddress, this);
            _stub.setPortName(getTickerWSSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTickerWSSoapEndpointAddress(java.lang.String address) {
        TickerWSSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (TickerWSSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                TickerWSSoapStub _stub = new TickerWSSoapStub(new java.net.URL(TickerWSSoap_address), this);
                _stub.setPortName(getTickerWSSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TickerWSSoap".equals(inputPortName)) {
            return getTickerWSSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "TickerWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "TickerWSSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TickerWSSoap".equals(portName)) {
            setTickerWSSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
