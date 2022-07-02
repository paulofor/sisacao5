package br.com.sisacao.coletor.diario.legado;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSource2019 extends MySqlDataSource {

	public DataSource2019() {
		super("jdbc:mysql://d555d.vps-kinghost.net/lojadigicom35", "lojadigicom35", "Sisacao005%");
	}
}
