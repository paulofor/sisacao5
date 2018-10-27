package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class DispositivoUsuarioVo implements DispositivoUsuario
{
		
	public long getIdObj()
    {
       return idDispositivoUsuario;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdDispositivoUsuario\" : \"" + idDispositivoUsuario + "\" "
		+ ", \"NumeroCelular\" : \"" + numeroCelular + "\" "
		+ ", \"CodigoDispositivo\" : \"" + codigoDispositivo + "\" "
		+ ", \"TipoAcesso\" : \"" + tipoAcesso + "\" "
		+ ", \"MelhorPath\" : \"" + melhorPath + "\" "
		+ ", \"IdUsuarioRa\" : \"" + idUsuarioRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private DispositivoUsuarioDerivada derivada = null;
	private DispositivoUsuarioDerivada getDerivada() {
		if (derivada==null) {
			derivada = new DispositivoUsuarioDerivada(this);
		}
		return derivada;
	}

	private DispositivoUsuarioAgregado agregado = null;
	private DispositivoUsuarioAgregado getAgregado() {
		if (agregado==null) {
			agregado = new DispositivoUsuarioAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public Usuario getUsuarioReferenteA(boolean lazyLoader)
	{
		return getAgregado().getUsuarioReferenteA(lazyLoader); 
	} 
	public void setUsuarioReferenteA(Usuario value) 
	{
		getAgregado().setUsuarioReferenteA(value); 
	} 
	/*
	public void setUsuarioReferenteAComReversao(Usuario value) 
	{
		getAgregado().setUsuarioReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaUsuario_ReferenteA(Usuario value)
	{
		getAgregado().setUsuarioReferenteA(value); 
	} 
	public Usuario getCorrenteUsuario_ReferenteA()
	{
		return getAgregado().getUsuarioReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idDispositivoUsuario;
	public long getIdDispositivoUsuario()
	{
		return idDispositivoUsuario;
	}
	public  void setIdDispositivoUsuario(long value)
	{
		idDispositivoUsuario = value; 
	}
	
	
	
	
	
	private String numeroCelular;
	public String getNumeroCelular()
	{
		return numeroCelular;
	}
	public  void setNumeroCelular(String value)
	{
		numeroCelular = value; 
	}
	
	
	
	
	
	private String codigoDispositivo;
	public String getCodigoDispositivo()
	{
		return codigoDispositivo;
	}
	public  void setCodigoDispositivo(String value)
	{
		codigoDispositivo = value; 
	}
	
	
	
	
	
	private String tipoAcesso;
	public String getTipoAcesso()
	{
		return tipoAcesso;
	}
	public  void setTipoAcesso(String value)
	{
		tipoAcesso = value; 
	}
	
	
	
	
	
	private String melhorPath;
	public String getMelhorPath()
	{
		return melhorPath;
	}
	public  void setMelhorPath(String value)
	{
		melhorPath = value; 
	}
	
	
	
	
		
	private long idUsuarioRa;
	public long getIdUsuarioRa() {
		// relacionamento
		if (idUsuarioRa==0 && this.getUsuarioReferenteA(false)!=null) 
			return getUsuarioReferenteA(false).getIdObj();
		else
			return idUsuarioRa;
	}
	public void setIdUsuarioRa(long _valor) {
		idUsuarioRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
