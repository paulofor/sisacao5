/**
 * DiaPregaoObjetoWs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.digicom.cotacao.webservice;

public class DiaPregaoObjetoWs  implements java.io.Serializable {
    private long idDiaPregao;

    private java.lang.String data;

    private boolean feriado;

    public DiaPregaoObjetoWs() {
    }

    public DiaPregaoObjetoWs(
           long idDiaPregao,
           java.lang.String data,
           boolean feriado) {
           this.idDiaPregao = idDiaPregao;
           this.data = data;
           this.feriado = feriado;
    }


    /**
     * Gets the idDiaPregao value for this DiaPregaoObjetoWs.
     * 
     * @return idDiaPregao
     */
    public long getIdDiaPregao() {
        return idDiaPregao;
    }


    /**
     * Sets the idDiaPregao value for this DiaPregaoObjetoWs.
     * 
     * @param idDiaPregao
     */
    public void setIdDiaPregao(long idDiaPregao) {
        this.idDiaPregao = idDiaPregao;
    }


    /**
     * Gets the data value for this DiaPregaoObjetoWs.
     * 
     * @return data
     */
    public java.lang.String getData() {
        return data;
    }


    /**
     * Sets the data value for this DiaPregaoObjetoWs.
     * 
     * @param data
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }


    /**
     * Gets the feriado value for this DiaPregaoObjetoWs.
     * 
     * @return feriado
     */
    public boolean isFeriado() {
        return feriado;
    }


    /**
     * Sets the feriado value for this DiaPregaoObjetoWs.
     * 
     * @param feriado
     */
    public void setFeriado(boolean feriado) {
        this.feriado = feriado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DiaPregaoObjetoWs)) return false;
        DiaPregaoObjetoWs other = (DiaPregaoObjetoWs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idDiaPregao == other.getIdDiaPregao() &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            this.feriado == other.isFeriado();
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
        _hashCode += new Long(getIdDiaPregao()).hashCode();
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        _hashCode += (isFeriado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DiaPregaoObjetoWs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "DiaPregaoObjetoWs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDiaPregao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdDiaPregao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feriado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Feriado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
