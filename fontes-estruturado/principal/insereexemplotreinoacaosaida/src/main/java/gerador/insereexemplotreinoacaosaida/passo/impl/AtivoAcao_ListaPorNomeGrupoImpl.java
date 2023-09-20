package gerador.insereexemplotreinoacaosaida.passo.impl;


import gerador.insereexemplotreinoacaosaida.passo.*;



public class AtivoAcao_ListaPorNomeGrupoImpl extends AtivoAcao_ListaPorNomeGrupo {

	@Override
	protected boolean executaCustom(String nomeGrupoAcao) {
		this.nomeGrupo = nomeGrupoAcao;
		return true;
	} 


	
	
}

