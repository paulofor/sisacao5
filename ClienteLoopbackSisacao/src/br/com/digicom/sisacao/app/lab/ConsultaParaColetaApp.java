package br.com.digicom.sisacao.app.lab;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;

public class ConsultaParaColetaApp {

	public static void main(String[] args) {
		System.out.println("Ola mundo");
		RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
		RepositorioAcaoBase.AtivoAcaoRepository rep = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
		
		rep.findAll(new ListCallback<AtivoAcao>() { 
            
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				System.out.println("Total Acao: " + objects.size());
				for (AtivoAcao item : objects) {
					System.out.println("Token:" + item.getTicker());
				}
			} 
        });
	}

}
