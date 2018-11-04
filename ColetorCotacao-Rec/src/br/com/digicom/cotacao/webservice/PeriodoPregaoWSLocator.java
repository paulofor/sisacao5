/**
 * PeriodoPregaoWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.digicom.cotacao.webservice;

public class PeriodoPregaoWSLocator extends org.apache.axis.client.Service implements PeriodoPregaoWS {

    public PeriodoPregaoWSLocator() {
    }


    public PeriodoPregaoWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PeriodoPregaoWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PeriodoPregaoWSSoap
    private java.lang.String PeriodoPregaoWSSoap_address = "http://digicom.kinghost.net/sisacaoweb2online/ws/PeriodoPregaoWS.asmx";

    public java.lang.String getPeriodoPregaoWSSoapAddress() {
        return PeriodoPregaoWSSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PeriodoPregaoWSSoapWSDDServiceName = "PeriodoPregaoWSSoap";

    public java.lang.String getPeriodoPregaoWSSoapWSDDServiceName() {
        return PeriodoPregaoWSSoapWSDDServiceName;
    }

    public void setPeriodoPregaoWSSoapWSDDServiceName(java.lang.String name) {
        PeriodoPregaoWSSoapWSDDServiceName = name;
    }

    public PeriodoPregaoWSSoap getPeriodoPregaoWSSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PeriodoPregaoWSSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPeriodoPregaoWSSoap(endpoint);
    }

    public PeriodoPregaoWSSoap getPeriodoPregaoWSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            PeriodoPregaoWSSoapStub _stub = new PeriodoPregaoWSSoapStub(portAddress, this);
            _stub.setPortName(getPeriodoPregaoWSSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPeriodoPregaoWSSoapEndpointAddress(java.lang.String address) {
        PeriodoPregaoWSSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (PeriodoPregaoWSSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                PeriodoPregaoWSSoapStub _stub = new PeriodoPregaoWSSoapStub(new java.net.URL(PeriodoPregaoWSSoap_address), this);
                _stub.setPortName(getPeriodoPregaoWSSoapWSDDServiceName());
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
        if ("PeriodoPregaoWSSoap".equals(inputPortName)) {
            return getPeriodoPregaoWSSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "PeriodoPregaoWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "PeriodoPregaoWSSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PeriodoPregaoWSSoap".equals(portName)) {
            setPeriodoPregaoWSSoapEndpointAddress(address);
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
