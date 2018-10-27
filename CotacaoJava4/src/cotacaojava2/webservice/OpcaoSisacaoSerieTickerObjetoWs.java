/**
 * OpcaoSisacaoSerieTickerObjetoWs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public class OpcaoSisacaoSerieTickerObjetoWs  implements java.io.Serializable {
    private long idOpcaoSisacaoSerieTicker;

    private float precoReferencia;

    private java.lang.String dataPrecoReferencia;

    private long idTickerRa;

    private long idOpcaoSisacaoSerieRa;

    private TickerObjetoWs tickerReferenteA;

    private OpcaoSisacaoSerieObjetoWs opcaoSisacaoSerieReferenteA;

    public OpcaoSisacaoSerieTickerObjetoWs() {
    }

    public OpcaoSisacaoSerieTickerObjetoWs(
           long idOpcaoSisacaoSerieTicker,
           float precoReferencia,
           java.lang.String dataPrecoReferencia,
           long idTickerRa,
           long idOpcaoSisacaoSerieRa,
           TickerObjetoWs tickerReferenteA,
           OpcaoSisacaoSerieObjetoWs opcaoSisacaoSerieReferenteA) {
           this.idOpcaoSisacaoSerieTicker = idOpcaoSisacaoSerieTicker;
           this.precoReferencia = precoReferencia;
           this.dataPrecoReferencia = dataPrecoReferencia;
           this.idTickerRa = idTickerRa;
           this.idOpcaoSisacaoSerieRa = idOpcaoSisacaoSerieRa;
           this.tickerReferenteA = tickerReferenteA;
           this.opcaoSisacaoSerieReferenteA = opcaoSisacaoSerieReferenteA;
    }


    /**
     * Gets the idOpcaoSisacaoSerieTicker value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @return idOpcaoSisacaoSerieTicker
     */
    public long getIdOpcaoSisacaoSerieTicker() {
        return idOpcaoSisacaoSerieTicker;
    }


    /**
     * Sets the idOpcaoSisacaoSerieTicker value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @param idOpcaoSisacaoSerieTicker
     */
    public void setIdOpcaoSisacaoSerieTicker(long idOpcaoSisacaoSerieTicker) {
        this.idOpcaoSisacaoSerieTicker = idOpcaoSisacaoSerieTicker;
    }


    /**
     * Gets the precoReferencia value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @return precoReferencia
     */
    public float getPrecoReferencia() {
        return precoReferencia;
    }


    /**
     * Sets the precoReferencia value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @param precoReferencia
     */
    public void setPrecoReferencia(float precoReferencia) {
        this.precoReferencia = precoReferencia;
    }


    /**
     * Gets the dataPrecoReferencia value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @return dataPrecoReferencia
     */
    public java.lang.String getDataPrecoReferencia() {
        return dataPrecoReferencia;
    }


    /**
     * Sets the dataPrecoReferencia value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @param dataPrecoReferencia
     */
    public void setDataPrecoReferencia(java.lang.String dataPrecoReferencia) {
        this.dataPrecoReferencia = dataPrecoReferencia;
    }


    /**
     * Gets the idTickerRa value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @return idTickerRa
     */
    public long getIdTickerRa() {
        return idTickerRa;
    }


    /**
     * Sets the idTickerRa value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @param idTickerRa
     */
    public void setIdTickerRa(long idTickerRa) {
        this.idTickerRa = idTickerRa;
    }


    /**
     * Gets the idOpcaoSisacaoSerieRa value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @return idOpcaoSisacaoSerieRa
     */
    public long getIdOpcaoSisacaoSerieRa() {
        return idOpcaoSisacaoSerieRa;
    }


    /**
     * Sets the idOpcaoSisacaoSerieRa value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @param idOpcaoSisacaoSerieRa
     */
    public void setIdOpcaoSisacaoSerieRa(long idOpcaoSisacaoSerieRa) {
        this.idOpcaoSisacaoSerieRa = idOpcaoSisacaoSerieRa;
    }


    /**
     * Gets the tickerReferenteA value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @return tickerReferenteA
     */
    public TickerObjetoWs getTickerReferenteA() {
        return tickerReferenteA;
    }


    /**
     * Sets the tickerReferenteA value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @param tickerReferenteA
     */
    public void setTickerReferenteA(TickerObjetoWs tickerReferenteA) {
        this.tickerReferenteA = tickerReferenteA;
    }


    /**
     * Gets the opcaoSisacaoSerieReferenteA value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @return opcaoSisacaoSerieReferenteA
     */
    public OpcaoSisacaoSerieObjetoWs getOpcaoSisacaoSerieReferenteA() {
        return opcaoSisacaoSerieReferenteA;
    }


    /**
     * Sets the opcaoSisacaoSerieReferenteA value for this OpcaoSisacaoSerieTickerObjetoWs.
     * 
     * @param opcaoSisacaoSerieReferenteA
     */
    public void setOpcaoSisacaoSerieReferenteA(OpcaoSisacaoSerieObjetoWs opcaoSisacaoSerieReferenteA) {
        this.opcaoSisacaoSerieReferenteA = opcaoSisacaoSerieReferenteA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OpcaoSisacaoSerieTickerObjetoWs)) return false;
        OpcaoSisacaoSerieTickerObjetoWs other = (OpcaoSisacaoSerieTickerObjetoWs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idOpcaoSisacaoSerieTicker == other.getIdOpcaoSisacaoSerieTicker() &&
            this.precoReferencia == other.getPrecoReferencia() &&
            ((this.dataPrecoReferencia==null && other.getDataPrecoReferencia()==null) || 
             (this.dataPrecoReferencia!=null &&
              this.dataPrecoReferencia.equals(other.getDataPrecoReferencia()))) &&
            this.idTickerRa == other.getIdTickerRa() &&
            this.idOpcaoSisacaoSerieRa == other.getIdOpcaoSisacaoSerieRa() &&
            ((this.tickerReferenteA==null && other.getTickerReferenteA()==null) || 
             (this.tickerReferenteA!=null &&
              this.tickerReferenteA.equals(other.getTickerReferenteA()))) &&
            ((this.opcaoSisacaoSerieReferenteA==null && other.getOpcaoSisacaoSerieReferenteA()==null) || 
             (this.opcaoSisacaoSerieReferenteA!=null &&
              this.opcaoSisacaoSerieReferenteA.equals(other.getOpcaoSisacaoSerieReferenteA())));
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
        _hashCode += new Long(getIdOpcaoSisacaoSerieTicker()).hashCode();
        _hashCode += new Float(getPrecoReferencia()).hashCode();
        if (getDataPrecoReferencia() != null) {
            _hashCode += getDataPrecoReferencia().hashCode();
        }
        _hashCode += new Long(getIdTickerRa()).hashCode();
        _hashCode += new Long(getIdOpcaoSisacaoSerieRa()).hashCode();
        if (getTickerReferenteA() != null) {
            _hashCode += getTickerReferenteA().hashCode();
        }
        if (getOpcaoSisacaoSerieReferenteA() != null) {
            _hashCode += getOpcaoSisacaoSerieReferenteA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OpcaoSisacaoSerieTickerObjetoWs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoSerieTickerObjetoWs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOpcaoSisacaoSerieTicker");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdOpcaoSisacaoSerieTicker"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precoReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PrecoReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataPrecoReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataPrecoReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTickerRa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdTickerRa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOpcaoSisacaoSerieRa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdOpcaoSisacaoSerieRa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tickerReferenteA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TickerReferenteA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "TickerObjetoWs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("opcaoSisacaoSerieReferenteA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoSerieReferenteA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoSerieObjetoWs"));
        elemField.setMinOccurs(0);
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
