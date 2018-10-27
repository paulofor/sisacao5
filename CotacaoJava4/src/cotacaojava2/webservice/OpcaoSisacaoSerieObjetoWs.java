/**
 * OpcaoSisacaoSerieObjetoWs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public class OpcaoSisacaoSerieObjetoWs  implements java.io.Serializable {
    private long idOpcaoSisacaoSerie;

    private boolean construida;

    private boolean possuiIntraday;

    private java.lang.String mesAno;

    private java.lang.String letra;

    private java.lang.String dataVencimento;

    private java.lang.String dataInicioColeta;

    public OpcaoSisacaoSerieObjetoWs() {
    }

    public OpcaoSisacaoSerieObjetoWs(
           long idOpcaoSisacaoSerie,
           boolean construida,
           boolean possuiIntraday,
           java.lang.String mesAno,
           java.lang.String letra,
           java.lang.String dataVencimento,
           java.lang.String dataInicioColeta) {
           this.idOpcaoSisacaoSerie = idOpcaoSisacaoSerie;
           this.construida = construida;
           this.possuiIntraday = possuiIntraday;
           this.mesAno = mesAno;
           this.letra = letra;
           this.dataVencimento = dataVencimento;
           this.dataInicioColeta = dataInicioColeta;
    }


    /**
     * Gets the idOpcaoSisacaoSerie value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @return idOpcaoSisacaoSerie
     */
    public long getIdOpcaoSisacaoSerie() {
        return idOpcaoSisacaoSerie;
    }


    /**
     * Sets the idOpcaoSisacaoSerie value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @param idOpcaoSisacaoSerie
     */
    public void setIdOpcaoSisacaoSerie(long idOpcaoSisacaoSerie) {
        this.idOpcaoSisacaoSerie = idOpcaoSisacaoSerie;
    }


    /**
     * Gets the construida value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @return construida
     */
    public boolean isConstruida() {
        return construida;
    }


    /**
     * Sets the construida value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @param construida
     */
    public void setConstruida(boolean construida) {
        this.construida = construida;
    }


    /**
     * Gets the possuiIntraday value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @return possuiIntraday
     */
    public boolean isPossuiIntraday() {
        return possuiIntraday;
    }


    /**
     * Sets the possuiIntraday value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @param possuiIntraday
     */
    public void setPossuiIntraday(boolean possuiIntraday) {
        this.possuiIntraday = possuiIntraday;
    }


    /**
     * Gets the mesAno value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @return mesAno
     */
    public java.lang.String getMesAno() {
        return mesAno;
    }


    /**
     * Sets the mesAno value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @param mesAno
     */
    public void setMesAno(java.lang.String mesAno) {
        this.mesAno = mesAno;
    }


    /**
     * Gets the letra value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @return letra
     */
    public java.lang.String getLetra() {
        return letra;
    }


    /**
     * Sets the letra value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @param letra
     */
    public void setLetra(java.lang.String letra) {
        this.letra = letra;
    }


    /**
     * Gets the dataVencimento value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @return dataVencimento
     */
    public java.lang.String getDataVencimento() {
        return dataVencimento;
    }


    /**
     * Sets the dataVencimento value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @param dataVencimento
     */
    public void setDataVencimento(java.lang.String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }


    /**
     * Gets the dataInicioColeta value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @return dataInicioColeta
     */
    public java.lang.String getDataInicioColeta() {
        return dataInicioColeta;
    }


    /**
     * Sets the dataInicioColeta value for this OpcaoSisacaoSerieObjetoWs.
     * 
     * @param dataInicioColeta
     */
    public void setDataInicioColeta(java.lang.String dataInicioColeta) {
        this.dataInicioColeta = dataInicioColeta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OpcaoSisacaoSerieObjetoWs)) return false;
        OpcaoSisacaoSerieObjetoWs other = (OpcaoSisacaoSerieObjetoWs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idOpcaoSisacaoSerie == other.getIdOpcaoSisacaoSerie() &&
            this.construida == other.isConstruida() &&
            this.possuiIntraday == other.isPossuiIntraday() &&
            ((this.mesAno==null && other.getMesAno()==null) || 
             (this.mesAno!=null &&
              this.mesAno.equals(other.getMesAno()))) &&
            ((this.letra==null && other.getLetra()==null) || 
             (this.letra!=null &&
              this.letra.equals(other.getLetra()))) &&
            ((this.dataVencimento==null && other.getDataVencimento()==null) || 
             (this.dataVencimento!=null &&
              this.dataVencimento.equals(other.getDataVencimento()))) &&
            ((this.dataInicioColeta==null && other.getDataInicioColeta()==null) || 
             (this.dataInicioColeta!=null &&
              this.dataInicioColeta.equals(other.getDataInicioColeta())));
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
        _hashCode += new Long(getIdOpcaoSisacaoSerie()).hashCode();
        _hashCode += (isConstruida() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isPossuiIntraday() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMesAno() != null) {
            _hashCode += getMesAno().hashCode();
        }
        if (getLetra() != null) {
            _hashCode += getLetra().hashCode();
        }
        if (getDataVencimento() != null) {
            _hashCode += getDataVencimento().hashCode();
        }
        if (getDataInicioColeta() != null) {
            _hashCode += getDataInicioColeta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OpcaoSisacaoSerieObjetoWs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "OpcaoSisacaoSerieObjetoWs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idOpcaoSisacaoSerie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdOpcaoSisacaoSerie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("construida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Construida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("possuiIntraday");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PossuiIntraday"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesAno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MesAno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("letra");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Letra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataVencimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataVencimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInicioColeta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataInicioColeta"));
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
