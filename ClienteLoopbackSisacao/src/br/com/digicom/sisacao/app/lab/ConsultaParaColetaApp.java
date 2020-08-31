package br.com.digicom.sisacao.app.lab;

public class ConsultaParaColetaApp {

	public static void main(String[] args) {
		System.out.println("Ola mundo");
		RestAdapter adapter = new RestAdapter("http://validacao.kinghost.net:21040/api");
		RepositorioBase.DispositivoUsuarioRepository rep = adapter.createRepository(RepositorioBase.DispositivoUsuarioRepository.class);
		
		rep.cosmeticCenterNotificacao(new ListCallback<DispositivoUsuario>() { 
            
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<DispositivoUsuario> objects) {
				System.out.println("Total Dispositivo: " + objects.size());
				for (DispositivoUsuario item : objects) {
					System.out.println("Token:" + item.getTokenFcm());
				}
			} 
        });
	}

}
