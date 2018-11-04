/**
 * DiaPregaoFiltro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.digicom.cotacao.webservice;

public class DiaPregaoFiltro  implements java.io.Serializable {
    private DiaPregaoObjetoWs diaPregaoPesquisa;

    private java.lang.String diaInicialConsulta;

    private java.lang.String diaFinalConsulta;

    private long diasDeslocamento;

    private java.lang.String tickerConsultaErro;

    private long codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui;

    public DiaPregaoFiltro() {
    }

    public DiaPregaoFiltro(
           DiaPregaoObjetoWs diaPregaoPesquisa,
           java.lang.String diaInicialConsulta,
           java.lang.String diaFinalConsulta,
           long diasDeslocamento,
           java.lang.String tickerConsultaErro,
           long codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui) {
           this.diaPregaoPesquisa = diaPregaoPesquisa;
           this.diaInicialConsulta = diaInicialConsulta;
           this.diaFinalConsulta = diaFinalConsulta;
           this.diasDeslocamento = diasDeslocamento;
           this.tickerConsultaErro = tickerConsultaErro;
           this.codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui = codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui;
    }


    /**
     * Gets the diaPregaoPesquisa value for this DiaPregaoFiltro.
     * 
     * @return diaPregaoPesquisa
     */
    public DiaPregaoObjetoWs getDiaPregaoPesquisa() {
        return diaPregaoPesquisa;
    }


    /**
     * Sets the diaPregaoPesquisa value for this DiaPregaoFiltro.
     * 
     * @param diaPregaoPesquisa
     */
    public void setDiaPregaoPesquisa(DiaPregaoObjetoWs diaPregaoPesquisa) {
        this.diaPregaoPesquisa = diaPregaoPesquisa;
    }


    /**
     * Gets the diaInicialConsulta value for this DiaPregaoFiltro.
     * 
     * @return diaInicialConsulta
     */
    public java.lang.String getDiaInicialConsulta() {
        return diaInicialConsulta;
    }


    /**
     * Sets the diaInicialConsulta value for this DiaPregaoFiltro.
     * 
     * @param diaInicialConsulta
     */
    public void setDiaInicialConsulta(java.lang.String diaInicialConsulta) {
        this.diaInicialConsulta = diaInicialConsulta;
    }


    /**
     * Gets the diaFinalConsulta value for this DiaPregaoFiltro.
     * 
     * @return diaFinalConsulta
     */
    public java.lang.String getDiaFinalConsulta() {
        return diaFinalConsulta;
    }


    /**
     * Sets the diaFinalConsulta value for this DiaPregaoFiltro.
     * 
     * @param diaFinalConsulta
     */
    public void setDiaFinalConsulta(java.lang.String diaFinalConsulta) {
        this.diaFinalConsulta = diaFinalConsulta;
    }


    /**
     * Gets the diasDeslocamento value for this DiaPregaoFiltro.
     * 
     * @return diasDeslocamento
     */
    public long getDiasDeslocamento() {
        return diasDeslocamento;
    }


    /**
     * Sets the diasDeslocamento value for this DiaPregaoFiltro.
     * 
     * @param diasDeslocamento
     */
    public void setDiasDeslocamento(long diasDeslocamento) {
        this.diasDeslocamento = diasDeslocamento;
    }


    /**
     * Gets the tickerConsultaErro value for this DiaPregaoFiltro.
     * 
     * @return tickerConsultaErro
     */
    public java.lang.String getTickerConsultaErro() {
        return tickerConsultaErro;
    }


    /**
     * Sets the tickerConsultaErro value for this DiaPregaoFiltro.
     * 
     * @param tickerConsultaErro
     */
    public void setTickerConsultaErro(java.lang.String tickerConsultaErro) {
        this.tickerConsultaErro = tickerConsultaErro;
    }


    /**
     * Gets the codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui value for this DiaPregaoFiltro.
     * 
     * @return codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui
     */
    public long getCodigoCotacaoProcessadaEmCotacaoProcessadaListaPossui() {
        return codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui;
    }


    /**
     * Sets the codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui value for this DiaPregaoFiltro.
     * 
     * @param codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui
     */
    public void setCodigoCotacaoProcessadaEmCotacaoProcessadaListaPossui(long codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui) {
        this.codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui = codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DiaPregaoFiltro)) return false;
        DiaPregaoFiltro other = (DiaPregaoFiltro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.diaPregaoPesquisa==null && other.getDiaPregaoPesquisa()==null) || 
             (this.diaPregaoPesquisa!=null &&
              this.diaPregaoPesquisa.equals(other.getDiaPregaoPesquisa()))) &&
            ((this.diaInicialConsulta==null && other.getDiaInicialConsulta()==null) || 
             (this.diaInicialConsulta!=null &&
              this.diaInicialConsulta.equals(other.getDiaInicialConsulta()))) &&
            ((this.diaFinalConsulta==null && other.getDiaFinalConsulta()==null) || 
             (this.diaFinalConsulta!=null &&
              this.diaFinalConsulta.equals(other.getDiaFinalConsulta()))) &&
            this.diasDeslocamento == other.getDiasDeslocamento() &&
            ((this.tickerConsultaErro==null && other.getTickerConsultaErro()==null) || 
             (this.tickerConsultaErro!=null &&
              this.tickerConsultaErro.equals(other.getTickerConsultaErro()))) &&
            this.codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui == other.getCodigoCotacaoProcessadaEmCotacaoProcessadaListaPossui();
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
        if (getDiaPregaoPesquisa() != null) {
            _hashCode += getDiaPregaoPesquisa().hashCode();
        }
        if (getDiaInicialConsulta() != null) {
            _hashCode += getDiaInicialConsulta().hashCode();
        }
        if (getDiaFinalConsulta() != null) {
            _hashCode += getDiaFinalConsulta().hashCode();
        }
        _hashCode += new Long(getDiasDeslocamento()).hashCode();
        if (getTickerConsultaErro() != null) {
            _hashCode += getTickerConsultaErro().hashCode();
        }
        _hashCode += new Long(getCodigoCotacaoProcessadaEmCotacaoProcessadaListaPossui()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DiaPregaoFiltro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "DiaPregaoFiltro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diaPregaoPesquisa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DiaPregaoPesquisa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "DiaPregaoObjetoWs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diaInicialConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DiaInicialConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diaFinalConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DiaFinalConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diasDeslocamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DiasDeslocamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tickerConsultaErro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TickerConsultaErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoCotacaoProcessadaEmCotacaoProcessadaListaPossui");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CodigoCotacaoProcessadaEmCotacaoProcessadaListaPossui"));
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
