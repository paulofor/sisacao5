package coletorjava.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletorjava.modelo.*;
import coletorjava.modelo.agregado.*;
import coletorjava.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class UsuarioVo implements Usuario
{
		
	public long getIdObj()
    {
       return idUsuario;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdUsuario\" : \"" + idUsuario + "\" "
		+ ", \"NomeUsuario\" : \"" + nomeUsuario + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private UsuarioDerivada derivada = null;
	private UsuarioDerivada getDerivada() {
		if (derivada==null) {
			derivada = new UsuarioDerivada(this);
		}
		return derivada;
	}

	private UsuarioAgregado agregado = null;
	private UsuarioAgregado getAgregado() {
		if (agregado==null) {
			agregado = new UsuarioAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaDispositivoUsuario_Usa() {
		return getAgregado().existeListaDispositivoUsuario_Usa();
	}
	public void criaVaziaListaDispositivoUsuario_Usa() {
		getAgregado().criaVaziaListaDispositivoUsuario_Usa();
	}
	public List<DispositivoUsuario> getListaDispositivoUsuario_Usa() 
	{
		return getAgregado().getListaDispositivoUsuario_Usa(); 
	} 
	public void setListaDispositivoUsuario_Usa(List<DispositivoUsuario> value) 
	{
		getAgregado().setListaDispositivoUsuario_Usa(value); 
	} 
	public void addListaDispositivoUsuario_Usa(DispositivoUsuario value) 
	{
		getAgregado().addListaDispositivoUsuario_Usa(value); 
	} 
	public DispositivoUsuario getCorrenteDispositivoUsuario_Usa()
	{
		return getAgregado().getCorrenteDispositivoUsuario_Usa(); 
	} 
	

	
	
	
	
	
	private long idUsuario;
	public long getIdUsuario()
	{
		return idUsuario;
	}
	public  void setIdUsuario(long value)
	{
		idUsuario = value; 
	}
	
	
	
	
	
	private String nomeUsuario;
	public String getNomeUsuario()
	{
		return nomeUsuario;
	}
	public  void setNomeUsuario(String value)
	{
		nomeUsuario = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
