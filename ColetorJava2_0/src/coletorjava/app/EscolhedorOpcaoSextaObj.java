package coletorjava.app;

import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoReferenciaRegraColecao;
import coletorjava.util.UtilData;

public class EscolhedorOpcaoSextaObj {
	
	OpcaoReferenciaRegraColecao opcaoReferenciaSrv = FabricaRegra.getInstancia().getOpcaoReferenciaRegraColecao();

	public void processaDia(String dataAnterior) {
		try {
			boolean ehSexta = false;
			if (dataAnterior.length()>5) {
				ehSexta = UtilData.ehSexta(dataAnterior);
				if (ehSexta) {
					opcaoReferenciaSrv.getFiltro().setDataSexta(dataAnterior);
					opcaoReferenciaSrv.GeraReferenciaDia();
				}
			}
			System.out.println("Escolhedor Sexta - Data: " + dataAnterior + "(" + ehSexta + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
