/**
 * PeriodoPregaoObjetoWs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.digicom.cotacao.webservice;

public class PeriodoPregaoObjetoWs  implements java.io.Serializable {
    private long idPeriodoPregao;

    private java.lang.String horaInicio;

    private java.lang.String horaTermino;

    private java.lang.String dataInicioPeriodo;

    private java.lang.String dataTerminoPeriodo;

    public PeriodoPregaoObjetoWs() {
    }

    public PeriodoPregaoObjetoWs(
           long idPeriodoPregao,
           java.lang.String horaInicio,
           java.lang.String horaTermino,
           java.lang.String dataInicioPeriodo,
           java.lang.String dataTerminoPeriodo) {
           this.idPeriodoPregao = idPeriodoPregao;
           this.horaInicio = horaInicio;
           this.horaTermino = horaTermino;
           this.dataInicioPeriodo = dataInicioPeriodo;
           this.dataTerminoPeriodo = dataTerminoPeriodo;
    }


    /**
     * Gets the idPeriodoPregao value for this PeriodoPregaoObjetoWs.
     * 
     * @return idPeriodoPregao
     */
    public long getIdPeriodoPregao() {
        return idPeriodoPregao;
    }


    /**
     * Sets the idPeriodoPregao value for this PeriodoPregaoObjetoWs.
     * 
     * @param idPeriodoPregao
     */
    public void setIdPeriodoPregao(long idPeriodoPregao) {
        this.idPeriodoPregao = idPeriodoPregao;
    }


    /**
     * Gets the horaInicio value for this PeriodoPregaoObjetoWs.
     * 
     * @return horaInicio
     */
    public java.lang.String getHoraInicio() {
        return horaInicio;
    }


    /**
     * Sets the horaInicio value for this PeriodoPregaoObjetoWs.
     * 
     * @param horaInicio
     */
    public void setHoraInicio(java.lang.String horaInicio) {
        this.horaInicio = horaInicio;
    }


    /**
     * Gets the horaTermino value for this PeriodoPregaoObjetoWs.
     * 
     * @return horaTermino
     */
    public java.lang.String getHoraTermino() {
        return horaTermino;
    }


    /**
     * Sets the horaTermino value for this PeriodoPregaoObjetoWs.
     * 
     * @param horaTermino
     */
    public void setHoraTermino(java.lang.String horaTermino) {
        this.horaTermino = horaTermino;
    }


    /**
     * Gets the dataInicioPeriodo value for this PeriodoPregaoObjetoWs.
     * 
     * @return dataInicioPeriodo
     */
    public java.lang.String getDataInicioPeriodo() {
        return dataInicioPeriodo;
    }


    /**
     * Sets the dataInicioPeriodo value for this PeriodoPregaoObjetoWs.
     * 
     * @param dataInicioPeriodo
     */
    public void setDataInicioPeriodo(java.lang.String dataInicioPeriodo) {
        this.dataInicioPeriodo = dataInicioPeriodo;
    }


    /**
     * Gets the dataTerminoPeriodo value for this PeriodoPregaoObjetoWs.
     * 
     * @return dataTerminoPeriodo
     */
    public java.lang.String getDataTerminoPeriodo() {
        return dataTerminoPeriodo;
    }


    /**
     * Sets the dataTerminoPeriodo value for this PeriodoPregaoObjetoWs.
     * 
     * @param dataTerminoPeriodo
     */
    public void setDataTerminoPeriodo(java.lang.String dataTerminoPeriodo) {
        this.dataTerminoPeriodo = dataTerminoPeriodo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PeriodoPregaoObjetoWs)) return false;
        PeriodoPregaoObjetoWs other = (PeriodoPregaoObjetoWs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idPeriodoPregao == other.getIdPeriodoPregao() &&
            ((this.horaInicio==null && other.getHoraInicio()==null) || 
             (this.horaInicio!=null &&
              this.horaInicio.equals(other.getHoraInicio()))) &&
            ((this.horaTermino==null && other.getHoraTermino()==null) || 
             (this.horaTermino!=null &&
              this.horaTermino.equals(other.getHoraTermino()))) &&
            ((this.dataInicioPeriodo==null && other.getDataInicioPeriodo()==null) || 
             (this.dataInicioPeriodo!=null &&
              this.dataInicioPeriodo.equals(other.getDataInicioPeriodo()))) &&
            ((this.dataTerminoPeriodo==null && other.getDataTerminoPeriodo()==null) || 
             (this.dataTerminoPeriodo!=null &&
              this.dataTerminoPeriodo.equals(other.getDataTerminoPeriodo())));
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
        _hashCode += new Long(getIdPeriodoPregao()).hashCode();
        if (getHoraInicio() != null) {
            _hashCode += getHoraInicio().hashCode();
        }
        if (getHoraTermino() != null) {
            _hashCode += getHoraTermino().hashCode();
        }
        if (getDataInicioPeriodo() != null) {
            _hashCode += getDataInicioPeriodo().hashCode();
        }
        if (getDataTerminoPeriodo() != null) {
            _hashCode += getDataTerminoPeriodo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PeriodoPregaoObjetoWs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "PeriodoPregaoObjetoWs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPeriodoPregao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IdPeriodoPregao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horaInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HoraInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horaTermino");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HoraTermino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInicioPeriodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataInicioPeriodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataTerminoPeriodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DataTerminoPeriodo"));
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
