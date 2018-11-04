package br.com.digicom.cotacao.callback;

import br.com.digicom.parse.callback.ICallbackParse;

public abstract interface ICallbackCotacao extends ICallbackParse
{
  public abstract void setTicker(String paramString);
}

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.callback.ICallbackCotacao
 * JD-Core Version:    0.6.0
 */