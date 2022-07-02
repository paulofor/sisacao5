package br.com.sisacao.coletor.diario.processamento;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.sisacao.coletor.diario.daobase.ColetorDiarioDaoBase;
import br.com.sisacao.coletor.diario.daobase.DatasetColetorDiario;

public class ExecutaColetaDiario extends  ColetorDiarioDaoBase{

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
   		
   		//Sem memoria pra isso
   		ParserDiarioObj objParse = new ParserDiarioObj();
   		objParse.inicio("20" + ano + mesDia);
   		
		finalizar();
	}

}
