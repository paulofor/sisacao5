package br.com.sisacao.coletor.diario.processamento;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.sisacao.coletor.diario.daobase.ColetorDiarioDaoBase;
import br.com.sisacao.coletor.diario.daobase.DatasetColetorDiario;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class ExecutaColetaDiario extends  ColetorDiarioDaoBase{

	
	public ExecutaColetaDiario() {
		this.dummy = new DummyDaoBase();
	}
	
	@Override
	protected void executaImpl() {
		DatasetColetorDiario ds = (DatasetColetorDiario) getComum();
		DiaPregao diaPregao = ds.getDiaPregao();
		String dataAnterior = Integer.toString(diaPregao.getDiaNum());
		// AAAAMMDD
		// 01234567
		String mesDia = dataAnterior.substring(4, 6) + dataAnterior.substring(6);
		String ano = dataAnterior.substring(2,4);
		TransferidorObj obj = new TransferidorObj();
   		obj.main(mesDia,ano);
   		
   		System.out.println("final da transferencia");
   		//Sem memoria pra isso
   		ParserDiarioObj objParse = new ParserDiarioObj();
   		objParse.inicio("20" + ano + mesDia);
   		
		executaProximo();
	}

	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}
	
	

}
