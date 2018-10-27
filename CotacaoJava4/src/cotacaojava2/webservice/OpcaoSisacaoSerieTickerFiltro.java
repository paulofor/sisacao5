/**
 * OpcaoSisacaoSerieTickerFiltro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public class OpcaoSisacaoSerieTickerFiltro  implements java.io.Serializable {
    private java.lang.String dataAtual;

    private float precoReferencia;

    private java.lang.String nomeTicker;

    private java.lang.String dataCotacaoReferencia;

    private long codigoTickerReferenteA;

    private long codigoOpcaoSisacaoSerieReferenteA;

    public OpcaoSisacaoSerieTickerFiltro() {
    }

    public OpcaoSisacaoSerieTickerFiltro(
           java.lang.String dataAtual,
           float precoReferencia,
           java.lang.String nomeTicker,
           java.lang.String dataCotacaoReferencia,
           long codigoTickerReferenteA,
           long codigoOpcaoSisacaoSerieReferenteA) {
           this.dataAtual = dataAtual;
           this.precoReferencia = precoReferencia;
           this.nomeTicker = nomeTicker;
           this.dataCotacaoReferencia = dataCotacaoReferencia;
           this.codigoTickerReferenteA = codigoTickerReferenteA;
           this.codigoOpcaoSisacaoSerieReferenteA = codigoOpcaoSisacaoSerieReferenteA;
    }


    /**
     * Gets the dataAtual value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @return dataAtual
     */
    public java.lang.String getDataAtual() {
        return dataAtual;
    }


    /**
     * Sets the dataAtual value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @param dataAtual
     */
    public void setDataAtual(java.lang.String dataAtual) {
        this.dataAtual = dataAtual;
    }


    /**
     * Gets the precoReferencia value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @return precoReferencia
     */
    public float getPrecoReferencia() {
        return precoReferencia;
    }


    /**
     * Sets the precoReferencia value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @param precoReferencia
     */
    public void setPrecoReferencia(float precoReferencia) {
        this.precoReferencia = precoReferencia;
    }


    /**
     * Gets the nomeTicker value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @return nomeTicker
     */
    public java.lang.String getNomeTicker() {
        return nomeTicker;
    }


    /**
     * Sets the nomeTicker value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @param nomeTicker
     */
    public void setNomeTicker(java.lang.String nomeTicker) {
        this.nomeTicker = nomeTicker;
    }


    /**
     * Gets the dataCotacaoReferencia value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @return dataCotacaoReferencia
     */
    public java.lang.String getDataCotacaoReferencia() {
        return dataCotacaoReferencia;
    }


    /**
     * Sets the dataCotacaoReferencia value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @param dataCotacaoReferencia
     */
    public void setDataCotacaoReferencia(java.lang.String dataCotacaoReferencia) {
        this.dataCotacaoReferencia = dataCotacaoReferencia;
    }


    /**
     * Gets the codigoTickerReferenteA value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @return codigoTickerReferenteA
     */
    public long getCodigoTickerReferenteA() {
        return codigoTickerReferenteA;
    }


    /**
     * Sets the codigoTickerReferenteA value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @param codigoTickerReferenteA
     */
    public void setCodigoTickerReferenteA(long codigoTickerReferenteA) {
        this.codigoTickerReferenteA = codigoTickerReferenteA;
    }


    /**
     * Gets the codigoOpcaoSisacaoSerieReferenteA value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @return codigoOpcaoSisacaoSerieReferenteA
     */
    public long getCodigoOpcaoSisacaoSerieReferenteA() {
        return codigoOpcaoSisacaoSerieReferenteA;
    }


    /**
     * Sets the codigoOpcaoSisacaoSerieReferenteA value for this OpcaoSisacaoSerieTickerFiltro.
     * 
     * @param codigoOpcaoSisacaoSerieReferenteA
     */
    public void setCodigoOpcaoSisacaoSerieReferenteA(long codigoOpcaoSisacaoSerieReferenteA) {
        this.codigoOpcaoSisacaoSerieReferenteA = codigoOpcaoSisacaoSerieReferenteA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OpcaoSisacaoSerieTickerFiltro)) return false;
        OpcaoSisacaoSerieTickerFiltro other = (OpcaoSisacaoSerieTickerFiltro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataAtual==null && other.getDataAtual()==null) || 
             (this.dataAtual!=null &&
              this.dataAtual.equals(other.getDataAtual()))) &&
            this.precoReferencia == other.getPrecoReferencia() &&
            ((this.nomeTicker==null && other.getNomeTicker()==null) || 
             (this.nomeTicker!=null &&
              this.nomeTicker.equals(other.getNomeTicker()))) &&
            ((this.dataCotacaoReferencia==null && other.getDataCotacaoReferencia()==null) || 
             (this.dataCotacaoReferencia!=null &&
              this.dataCotacaoReferencia.equals(other.getDataCotacaoReferencia()))) &&
            this.codigoTickerReferenteA == other.getCodigoTickerReferenteA() &&
            this.codigoOpcaoSisacaoSerieReferenteA == other.getCodigoOpcaoSisacaoSerieReferenteA();
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
        if (getDataAtual() != null) {
            _hashCode += getDataAtual().hashCode();
        }
        _hashCode += new Float(getPrecoReferencia()).hashCode();
        if (getNomeTicker() != null) {
            _hashCode += getNomeTicker().hashCode();
        }
        if (getDataCotacaoReferencia() != null) {
            _hashCode += getDataCotacaoReferencia().hashCode();
        }
        _hashCode += new Long(getCodigoTickerReferenteA()).hashCode();
        _hashCode += new Long(getCodigoOpcaoSisacaoSerieReferenteA()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OpcaoSisacaoSerieTickerFiltro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoSerieTickerFiltro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAtual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataAtual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precoReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PrecoReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeTicker");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NomeTicker"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataCotacaoReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataCotacaoReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoTickerReferenteA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CodigoTickerReferenteA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoOpcaoSisacaoSerieReferenteA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CodigoOpcaoSisacaoSerieReferenteA"));
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
