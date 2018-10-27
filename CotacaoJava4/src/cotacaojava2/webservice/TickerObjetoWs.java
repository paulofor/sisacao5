/**
 * TickerObjetoWs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public class TickerObjetoWs  implements java.io.Serializable {
    private long idTicker;

    private java.lang.String nome;

    private java.lang.String empresa;

    private java.lang.String tipoAcao;

    private java.lang.String dataInicio;

    private boolean emEstudo;

    private boolean ativoOpcao;

    private boolean ativoOnline;

    public TickerObjetoWs() {
    }

    public TickerObjetoWs(
           long idTicker,
           java.lang.String nome,
           java.lang.String empresa,
           java.lang.String tipoAcao,
           java.lang.String dataInicio,
           boolean emEstudo,
           boolean ativoOpcao,
           boolean ativoOnline) {
           this.idTicker = idTicker;
           this.nome = nome;
           this.empresa = empresa;
           this.tipoAcao = tipoAcao;
           this.dataInicio = dataInicio;
           this.emEstudo = emEstudo;
           this.ativoOpcao = ativoOpcao;
           this.ativoOnline = ativoOnline;
    }


    /**
     * Gets the idTicker value for this TickerObjetoWs.
     * 
     * @return idTicker
     */
    public long getIdTicker() {
        return idTicker;
    }


    /**
     * Sets the idTicker value for this TickerObjetoWs.
     * 
     * @param idTicker
     */
    public void setIdTicker(long idTicker) {
        this.idTicker = idTicker;
    }


    /**
     * Gets the nome value for this TickerObjetoWs.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this TickerObjetoWs.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the empresa value for this TickerObjetoWs.
     * 
     * @return empresa
     */
    public java.lang.String getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this TickerObjetoWs.
     * 
     * @param empresa
     */
    public void setEmpresa(java.lang.String empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the tipoAcao value for this TickerObjetoWs.
     * 
     * @return tipoAcao
     */
    public java.lang.String getTipoAcao() {
        return tipoAcao;
    }


    /**
     * Sets the tipoAcao value for this TickerObjetoWs.
     * 
     * @param tipoAcao
     */
    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }


    /**
     * Gets the dataInicio value for this TickerObjetoWs.
     * 
     * @return dataInicio
     */
    public java.lang.String getDataInicio() {
        return dataInicio;
    }


    /**
     * Sets the dataInicio value for this TickerObjetoWs.
     * 
     * @param dataInicio
     */
    public void setDataInicio(java.lang.String dataInicio) {
        this.dataInicio = dataInicio;
    }


    /**
     * Gets the emEstudo value for this TickerObjetoWs.
     * 
     * @return emEstudo
     */
    public boolean isEmEstudo() {
        return emEstudo;
    }


    /**
     * Sets the emEstudo value for this TickerObjetoWs.
     * 
     * @param emEstudo
     */
    public void setEmEstudo(boolean emEstudo) {
        this.emEstudo = emEstudo;
    }


    /**
     * Gets the ativoOpcao value for this TickerObjetoWs.
     * 
     * @return ativoOpcao
     */
    public boolean isAtivoOpcao() {
        return ativoOpcao;
    }


    /**
     * Sets the ativoOpcao value for this TickerObjetoWs.
     * 
     * @param ativoOpcao
     */
    public void setAtivoOpcao(boolean ativoOpcao) {
        this.ativoOpcao = ativoOpcao;
    }


    /**
     * Gets the ativoOnline value for this TickerObjetoWs.
     * 
     * @return ativoOnline
     */
    public boolean isAtivoOnline() {
        return ativoOnline;
    }


    /**
     * Sets the ativoOnline value for this TickerObjetoWs.
     * 
     * @param ativoOnline
     */
    public void setAtivoOnline(boolean ativoOnline) {
        this.ativoOnline = ativoOnline;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TickerObjetoWs)) return false;
        TickerObjetoWs other = (TickerObjetoWs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idTicker == other.getIdTicker() &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa()))) &&
            ((this.tipoAcao==null && other.getTipoAcao()==null) || 
             (this.tipoAcao!=null &&
              this.tipoAcao.equals(other.getTipoAcao()))) &&
            ((this.dataInicio==null && other.getDataInicio()==null) || 
             (this.dataInicio!=null &&
              this.dataInicio.equals(other.getDataInicio()))) &&
            this.emEstudo == other.isEmEstudo() &&
            this.ativoOpcao == other.isAtivoOpcao() &&
            this.ativoOnline == other.isAtivoOnline();
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
        _hashCode += new Long(getIdTicker()).hashCode();
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getEmpresa() != null) {
            _hashCode += getEmpresa().hashCode();
        }
        if (getTipoAcao() != null) {
            _hashCode += getTipoAcao().hashCode();
        }
        if (getDataInicio() != null) {
            _hashCode += getDataInicio().hashCode();
        }
        _hashCode += (isEmEstudo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAtivoOpcao() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAtivoOnline() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TickerObjetoWs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "TickerObjetoWs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTicker");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdTicker"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Empresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoAcao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TipoAcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emEstudo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "EmEstudo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ativoOpcao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AtivoOpcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ativoOnline");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AtivoOnline"));
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
