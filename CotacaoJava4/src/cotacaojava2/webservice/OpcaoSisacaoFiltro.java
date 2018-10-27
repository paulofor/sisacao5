/**
 * OpcaoSisacaoFiltro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public class OpcaoSisacaoFiltro  implements java.io.Serializable {
    private java.lang.String dataAtivo;

    private long codigoTickerDerivativoDe;

    private long codigoOpcaoSisacaoSeriePertenceA;

    public OpcaoSisacaoFiltro() {
    }

    public OpcaoSisacaoFiltro(
           java.lang.String dataAtivo,
           long codigoTickerDerivativoDe,
           long codigoOpcaoSisacaoSeriePertenceA) {
           this.dataAtivo = dataAtivo;
           this.codigoTickerDerivativoDe = codigoTickerDerivativoDe;
           this.codigoOpcaoSisacaoSeriePertenceA = codigoOpcaoSisacaoSeriePertenceA;
    }


    /**
     * Gets the dataAtivo value for this OpcaoSisacaoFiltro.
     * 
     * @return dataAtivo
     */
    public java.lang.String getDataAtivo() {
        return dataAtivo;
    }


    /**
     * Sets the dataAtivo value for this OpcaoSisacaoFiltro.
     * 
     * @param dataAtivo
     */
    public void setDataAtivo(java.lang.String dataAtivo) {
        this.dataAtivo = dataAtivo;
    }


    /**
     * Gets the codigoTickerDerivativoDe value for this OpcaoSisacaoFiltro.
     * 
     * @return codigoTickerDerivativoDe
     */
    public long getCodigoTickerDerivativoDe() {
        return codigoTickerDerivativoDe;
    }


    /**
     * Sets the codigoTickerDerivativoDe value for this OpcaoSisacaoFiltro.
     * 
     * @param codigoTickerDerivativoDe
     */
    public void setCodigoTickerDerivativoDe(long codigoTickerDerivativoDe) {
        this.codigoTickerDerivativoDe = codigoTickerDerivativoDe;
    }


    /**
     * Gets the codigoOpcaoSisacaoSeriePertenceA value for this OpcaoSisacaoFiltro.
     * 
     * @return codigoOpcaoSisacaoSeriePertenceA
     */
    public long getCodigoOpcaoSisacaoSeriePertenceA() {
        return codigoOpcaoSisacaoSeriePertenceA;
    }


    /**
     * Sets the codigoOpcaoSisacaoSeriePertenceA value for this OpcaoSisacaoFiltro.
     * 
     * @param codigoOpcaoSisacaoSeriePertenceA
     */
    public void setCodigoOpcaoSisacaoSeriePertenceA(long codigoOpcaoSisacaoSeriePertenceA) {
        this.codigoOpcaoSisacaoSeriePertenceA = codigoOpcaoSisacaoSeriePertenceA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OpcaoSisacaoFiltro)) return false;
        OpcaoSisacaoFiltro other = (OpcaoSisacaoFiltro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataAtivo==null && other.getDataAtivo()==null) || 
             (this.dataAtivo!=null &&
              this.dataAtivo.equals(other.getDataAtivo()))) &&
            this.codigoTickerDerivativoDe == other.getCodigoTickerDerivativoDe() &&
            this.codigoOpcaoSisacaoSeriePertenceA == other.getCodigoOpcaoSisacaoSeriePertenceA();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDataAtivo() != null) {
            _hashCode += getDataAtivo().hashCode();
        }
        _hashCode += new Long(getCodigoTickerDerivativoDe()).hashCode();
        _hashCode += new Long(getCodigoOpcaoSisacaoSeriePertenceA()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OpcaoSisacaoFiltro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoFiltro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataAtivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoTickerDerivativoDe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CodigoTickerDerivativoDe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOpcaoSisacaoSeriePertenceA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CodigoOpcaoSisacaoSeriePertenceA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
