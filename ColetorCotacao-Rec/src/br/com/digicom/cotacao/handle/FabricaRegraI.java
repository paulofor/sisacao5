package br.com.digicom.cotacao.handle;

import br.com.digicom.cotacao.regracolecao.CotacaoRegraColecao;



public abstract interface FabricaRegraI
{
  public abstract CotacaoRegraColecao getCotacaoRegraColecao();
}
