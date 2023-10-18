package gerador.insereexemplotreinoacaosaida.passo.impl;


import br.com.gersis.loopback.modelo.RegraProjecao;
import gerador.insereexemplotreinoacaosaida.passo.*;



public class RegraProjecao_FinalizaInsercaoImpl extends RegraProjecao_FinalizaInsercao {

	@Override
	protected boolean executaCustom(RegraProjecao regraSaida) {
		this.idRegraProjecao = new Integer(regraSaida.getId().toString());
		this.idGrupoAcao = 12;
		return true;
	} 


}

