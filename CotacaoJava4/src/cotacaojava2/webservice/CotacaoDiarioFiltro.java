/**
 * CotacaoDiarioFiltro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public class CotacaoDiarioFiltro  implements java.io.Serializable {
    private CotacaoDiarioObjetoWs cotacao;

    private java.lang.String nomeTicker;

    private java.lang.String data;

    public CotacaoDiarioFiltro() {
    }

    public CotacaoDiarioFiltro(
           CotacaoDiarioObjetoWs cotacao,
           java.lang.String nomeTicker,
           java.lang.String data) {
           this.cotacao = cotacao;
           this.nomeTicker = nomeTicker;
           this.data = data;
    }


    /**
     * Gets the cotacao value for this CotacaoDiarioFiltro.
     * 
     * @return cotacao
     */
    public CotacaoDiarioObjetoWs getCotacao() {
        return cotacao;
    }


    /**
     * Sets the cotacao value for this CotacaoDiarioFiltro.
     * 
     * @param cotacao
     */
    public void setCotacao(CotacaoDiarioObjetoWs cotacao) {
        this.cotacao = cotacao;
    }


    /**
     * Gets the nomeTicker value for this CotacaoDiarioFiltro.
     * 
     * @return nomeTicker
     */
    public java.lang.String getNomeTicker() {
        return nomeTicker;
    }


    /**
     * Sets the nomeTicker value for this CotacaoDiarioFiltro.
     * 
     * @param nomeTicker
     */
    public void setNomeTicker(java.lang.String nomeTicker) {
        this.nomeTicker = nomeTicker;
    }


    /**
     * Gets the data value for this CotacaoDiarioFiltro.
     * 
     * @return data
     */
    public java.lang.String getData() {
        return data;
    }


    /**
     * Sets the data value for this CotacaoDiarioFiltro.
     * 
     * @param data
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CotacaoDiarioFiltro)) return false;
        CotacaoDiarioFiltro other = (CotacaoDiarioFiltro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cotacao==null && other.getCotacao()==null) || 
             (this.cotacao!=null &&
              this.cotacao.equals(other.getCotacao()))) &&
            ((this.nomeTicker==null && other.getNomeTicker()==null) || 
             (this.nomeTicker!=null &&
              this.nomeTicker.equals(other.getNomeTicker()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData())));
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
        if (getCotacao() != null) {
            _hashCode += getCotacao().hashCode();
        }
        if (getNomeTicker() != null) {
            _hashCode += getNomeTicker().hashCode();
        }
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CotacaoDiarioFiltro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "CotacaoDiarioFiltro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cotacao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Cotacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "CotacaoDiarioObjetoWs"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
