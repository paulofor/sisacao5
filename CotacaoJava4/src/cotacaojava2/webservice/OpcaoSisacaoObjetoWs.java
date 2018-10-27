/**
 * OpcaoSisacaoObjetoWs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public class OpcaoSisacaoObjetoWs  implements java.io.Serializable {
    private long idOpcaoSisacao;

    private java.lang.String codigoMercado;

    private float precoExercicio;

    private long idTickerDd;

    private long idOpcaoSisacaoSeriePa;

    private TickerObjetoWs tickerDerivativoDe;

    private OpcaoSisacaoSerieObjetoWs opcaoSisacaoSeriePertenceA;

    public OpcaoSisacaoObjetoWs() {
    }

    public OpcaoSisacaoObjetoWs(
           long idOpcaoSisacao,
           java.lang.String codigoMercado,
           float precoExercicio,
           long idTickerDd,
           long idOpcaoSisacaoSeriePa,
           TickerObjetoWs tickerDerivativoDe,
           OpcaoSisacaoSerieObjetoWs opcaoSisacaoSeriePertenceA) {
           this.idOpcaoSisacao = idOpcaoSisacao;
           this.codigoMercado = codigoMercado;
           this.precoExercicio = precoExercicio;
           this.idTickerDd = idTickerDd;
           this.idOpcaoSisacaoSeriePa = idOpcaoSisacaoSeriePa;
           this.tickerDerivativoDe = tickerDerivativoDe;
           this.opcaoSisacaoSeriePertenceA = opcaoSisacaoSeriePertenceA;
    }


    /**
     * Gets the idOpcaoSisacao value for this OpcaoSisacaoObjetoWs.
     * 
     * @return idOpcaoSisacao
     */
    public long getIdOpcaoSisacao() {
        return idOpcaoSisacao;
    }


    /**
     * Sets the idOpcaoSisacao value for this OpcaoSisacaoObjetoWs.
     * 
     * @param idOpcaoSisacao
     */
    public void setIdOpcaoSisacao(long idOpcaoSisacao) {
        this.idOpcaoSisacao = idOpcaoSisacao;
    }


    /**
     * Gets the codigoMercado value for this OpcaoSisacaoObjetoWs.
     * 
     * @return codigoMercado
     */
    public java.lang.String getCodigoMercado() {
        return codigoMercado;
    }


    /**
     * Sets the codigoMercado value for this OpcaoSisacaoObjetoWs.
     * 
     * @param codigoMercado
     */
    public void setCodigoMercado(java.lang.String codigoMercado) {
        this.codigoMercado = codigoMercado;
    }


    /**
     * Gets the precoExercicio value for this OpcaoSisacaoObjetoWs.
     * 
     * @return precoExercicio
     */
    public float getPrecoExercicio() {
        return precoExercicio;
    }


    /**
     * Sets the precoExercicio value for this OpcaoSisacaoObjetoWs.
     * 
     * @param precoExercicio
     */
    public void setPrecoExercicio(float precoExercicio) {
        this.precoExercicio = precoExercicio;
    }


    /**
     * Gets the idTickerDd value for this OpcaoSisacaoObjetoWs.
     * 
     * @return idTickerDd
     */
    public long getIdTickerDd() {
        return idTickerDd;
    }


    /**
     * Sets the idTickerDd value for this OpcaoSisacaoObjetoWs.
     * 
     * @param idTickerDd
     */
    public void setIdTickerDd(long idTickerDd) {
        this.idTickerDd = idTickerDd;
    }


    /**
     * Gets the idOpcaoSisacaoSeriePa value for this OpcaoSisacaoObjetoWs.
     * 
     * @return idOpcaoSisacaoSeriePa
     */
    public long getIdOpcaoSisacaoSeriePa() {
        return idOpcaoSisacaoSeriePa;
    }


    /**
     * Sets the idOpcaoSisacaoSeriePa value for this OpcaoSisacaoObjetoWs.
     * 
     * @param idOpcaoSisacaoSeriePa
     */
    public void setIdOpcaoSisacaoSeriePa(long idOpcaoSisacaoSeriePa) {
        this.idOpcaoSisacaoSeriePa = idOpcaoSisacaoSeriePa;
    }


    /**
     * Gets the tickerDerivativoDe value for this OpcaoSisacaoObjetoWs.
     * 
     * @return tickerDerivativoDe
     */
    public TickerObjetoWs getTickerDerivativoDe() {
        return tickerDerivativoDe;
    }


    /**
     * Sets the tickerDerivativoDe value for this OpcaoSisacaoObjetoWs.
     * 
     * @param tickerDerivativoDe
     */
    public void setTickerDerivativoDe(TickerObjetoWs tickerDerivativoDe) {
        this.tickerDerivativoDe = tickerDerivativoDe;
    }


    /**
     * Gets the opcaoSisacaoSeriePertenceA value for this OpcaoSisacaoObjetoWs.
     * 
     * @return opcaoSisacaoSeriePertenceA
     */
    public OpcaoSisacaoSerieObjetoWs getOpcaoSisacaoSeriePertenceA() {
        return opcaoSisacaoSeriePertenceA;
    }


    /**
     * Sets the opcaoSisacaoSeriePertenceA value for this OpcaoSisacaoObjetoWs.
     * 
     * @param opcaoSisacaoSeriePertenceA
     */
    public void setOpcaoSisacaoSeriePertenceA(OpcaoSisacaoSerieObjetoWs opcaoSisacaoSeriePertenceA) {
        this.opcaoSisacaoSeriePertenceA = opcaoSisacaoSeriePertenceA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OpcaoSisacaoObjetoWs)) return false;
        OpcaoSisacaoObjetoWs other = (OpcaoSisacaoObjetoWs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idOpcaoSisacao == other.getIdOpcaoSisacao() &&
            ((this.codigoMercado==null && other.getCodigoMercado()==null) || 
             (this.codigoMercado!=null &&
              this.codigoMercado.equals(other.getCodigoMercado()))) &&
            this.precoExercicio == other.getPrecoExercicio() &&
            this.idTickerDd == other.getIdTickerDd() &&
            this.idOpcaoSisacaoSeriePa == other.getIdOpcaoSisacaoSeriePa() &&
            ((this.tickerDerivativoDe==null && other.getTickerDerivativoDe()==null) || 
             (this.tickerDerivativoDe!=null &&
              this.tickerDerivativoDe.equals(other.getTickerDerivativoDe()))) &&
            ((this.opcaoSisacaoSeriePertenceA==null && other.getOpcaoSisacaoSeriePertenceA()==null) || 
             (this.opcaoSisacaoSeriePertenceA!=null &&
              this.opcaoSisacaoSeriePertenceA.equals(other.getOpcaoSisacaoSeriePertenceA())));
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
        _hashCode += new Long(getIdOpcaoSisacao()).hashCode();
        if (getCodigoMercado() != null) {
            _hashCode += getCodigoMercado().hashCode();
        }
        _hashCode += new Float(getPrecoExercicio()).hashCode();
        _hashCode += new Long(getIdTickerDd()).hashCode();
        _hashCode += new Long(getIdOpcaoSisacaoSeriePa()).hashCode();
        if (getTickerDerivativoDe() != null) {
            _hashCode += getTickerDerivativoDe().hashCode();
        }
        if (getOpcaoSisacaoSeriePertenceA() != null) {
            _hashCode += getOpcaoSisacaoSeriePertenceA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OpcaoSisacaoObjetoWs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoObjetoWs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOpcaoSisacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdOpcaoSisacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoMercado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CodigoMercado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precoExercicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PrecoExercicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTickerDd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdTickerDd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOpcaoSisacaoSeriePa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdOpcaoSisacaoSeriePa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tickerDerivativoDe");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TickerDerivativoDe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "TickerObjetoWs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("opcaoSisacaoSeriePertenceA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoSeriePertenceA"));
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
