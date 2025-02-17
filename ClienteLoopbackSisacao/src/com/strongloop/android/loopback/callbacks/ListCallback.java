package com.strongloop.android.loopback.callbacks;

import com.strongloop.android.remoting.VirtualObject;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;

import java.util.List;

public interface ListCallback<T extends VirtualObject> {
    public void onSuccess(List<T> objects);
    public void onError(Throwable t);

}
