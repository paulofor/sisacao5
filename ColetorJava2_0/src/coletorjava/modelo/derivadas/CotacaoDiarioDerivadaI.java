package coletorjava.modelo.derivadas;


import br.com.digicom.lib.*;
import java.util.List;

public interface CotacaoDiarioDerivadaI
 { 
	public String getLinhaArquivoHistorico();
	public void setLinhaArquivoHistorico( String dado );

	public String getNomeTicker();
	public void setNomeTicker( String dado );

	public String getDataAAAAMMDD();
	public void setDataAAAAMMDD( String dado );

	public String getLinhaLog();
	public void setLinhaLog( String dado );

	public boolean getEhOpcao();
	public void setEhOpcao( boolean dado );

	public float getPrecoExercicio();
	public void setPrecoExercicio( float dado );

	public String getDataVencimento();
	public void setDataVencimento( String dado );

	public String getNomeResArquivo();
	public void setNomeResArquivo( String dado );

	public String getEspecificacaoArquivo();
	public void setEspecificacaoArquivo( String dado );

	public String getMesAnoOpcao();
	public void setMesAnoOpcao( String dado );

	public String getLinhaArquivoDiario();
	public void setLinhaArquivoDiario( String dado );

}
