/**
 * OpcaoSisacaoSerieTickerWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public class OpcaoSisacaoSerieTickerWSLocator extends org.apache.axis.client.Service implements OpcaoSisacaoSerieTickerWS {

    public OpcaoSisacaoSerieTickerWSLocator() {
    }


    public OpcaoSisacaoSerieTickerWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OpcaoSisacaoSerieTickerWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OpcaoSisacaoSerieTickerWSSoap
    private java.lang.String OpcaoSisacaoSerieTickerWSSoap_address = "http://digicom.kinghost.net/sisacaoweb2online/ws/OpcaoSisacaoSerieTickerWS.asmx";

    public java.lang.String getOpcaoSisacaoSerieTickerWSSoapAddress() {
        return OpcaoSisacaoSerieTickerWSSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OpcaoSisacaoSerieTickerWSSoapWSDDServiceName = "OpcaoSisacaoSerieTickerWSSoap";

    public java.lang.String getOpcaoSisacaoSerieTickerWSSoapWSDDServiceName() {
        return OpcaoSisacaoSerieTickerWSSoapWSDDServiceName;
    }

    public void setOpcaoSisacaoSerieTickerWSSoapWSDDServiceName(java.lang.String name) {
        OpcaoSisacaoSerieTickerWSSoapWSDDServiceName = name;
    }

    public OpcaoSisacaoSerieTickerWSSoap getOpcaoSisacaoSerieTickerWSSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OpcaoSisacaoSerieTickerWSSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOpcaoSisacaoSerieTickerWSSoap(endpoint);
    }

    public OpcaoSisacaoSerieTickerWSSoap getOpcaoSisacaoSerieTickerWSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            OpcaoSisacaoSerieTickerWSSoapStub _stub = new OpcaoSisacaoSerieTickerWSSoapStub(portAddress, this);
            _stub.setPortName(getOpcaoSisacaoSerieTickerWSSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOpcaoSisacaoSerieTickerWSSoapEndpointAddress(java.lang.String address) {
        OpcaoSisacaoSerieTickerWSSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (OpcaoSisacaoSerieTickerWSSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                OpcaoSisacaoSerieTickerWSSoapStub _stub = new OpcaoSisacaoSerieTickerWSSoapStub(new java.net.URL(OpcaoSisacaoSerieTickerWSSoap_address), this);
                _stub.setPortName(getOpcaoSisacaoSerieTickerWSSoapWSDDServiceName());
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
        if ("OpcaoSisacaoSerieTickerWSSoap".equals(inputPortName)) {
            return getOpcaoSisacaoSerieTickerWSSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoSerieTickerWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoSerieTickerWSSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OpcaoSisacaoSerieTickerWSSoap".equals(portName)) {
            setOpcaoSisacaoSerieTickerWSSoapEndpointAddress(address);
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
