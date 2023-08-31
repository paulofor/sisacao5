/* tslint:disable */
import { Injectable, Inject, Optional } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { SDKModels } from './SDKModels';
import { BaseLoopBackApi } from '../core/base.service';
import { LoopBackConfig } from '../../lb.config';
import { LoopBackAuth } from '../core/auth.service';
import { LoopBackFilter,  } from '../../models/BaseModels';
import { ErrorHandler } from '../core/error.service';
import { Observable, Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { PrevisaoTeste } from '../../models/PrevisaoTeste';
import { SocketConnection } from '../../sockets/socket.connections';


/**
 * Api services for the `PrevisaoTeste` model.
 */
@Injectable()
export class PrevisaoTesteApi extends BaseLoopBackApi {

  constructor(
    @Inject(HttpClient) protected http: HttpClient,
    @Inject(SocketConnection) protected connection: SocketConnection,
    @Inject(SDKModels) protected models: SDKModels,
    @Inject(LoopBackAuth) protected auth: LoopBackAuth,
    @Optional() @Inject(ErrorHandler) protected errorHandler: ErrorHandler
  ) {
    super(http,  connection,  models, auth, errorHandler);
  }

  /**
   * Patch an existing model instance or insert a new one into the data source.
   *
   * @param {object} data Request data.
   *
   *  - `data` – `{object}` - Model instance data
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `PrevisaoTeste` object.)
   * </em>
   */
  public patchOrCreate(data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/PrevisaoTestes";
    let _routeParams: any = {};
    let _postBody: any = {
      data: data
    };
    let _urlParams: any = {};
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * Patch attributes for a model instance and persist it into the data source.
   *
   * @param {any} id PrevisaoTeste id
   *
   * @param {object} data Request data.
   *
   *  - `data` – `{object}` - An object of model property name/value pairs
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `PrevisaoTeste` object.)
   * </em>
   */
  public patchAttributes(id: any, data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/PrevisaoTestes/:id";
    let _routeParams: any = {
      id: id
    };
    let _postBody: any = {
      data: data
    };
    let _urlParams: any = {};
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {object} data Request data.
   *
   *  - `ticker` – `{any}` - 
   *
   *  - `resultado` – `{any}` - 
   *
   *  - `diaNumPrevisao` – `{any}` - 
   *
   *  - `treinoRedeId` – `{any}` - 
   *
   *  - `valorEntrada` – `{any}` - 
   *
   *  - `valorReferencia` – `{any}` - 
   *
   *  - `tipoCompraVenda` – `{any}` - 
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `PrevisaoTeste` object.)
   * </em>
   */
  public RecebePrevisaoTreinoTeste(ticker: any = {}, resultado: any = {}, diaNumPrevisao: any = {}, treinoRedeId: any = {}, valorEntrada: any = {}, valorReferencia: any = {}, tipoCompraVenda: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "POST";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/PrevisaoTestes/recebePrevisaoTreinoTeste";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof ticker !== 'undefined' && ticker !== null) _urlParams.ticker = ticker;
    if (typeof resultado !== 'undefined' && resultado !== null) _urlParams.resultado = resultado;
    if (typeof diaNumPrevisao !== 'undefined' && diaNumPrevisao !== null) _urlParams.diaNumPrevisao = diaNumPrevisao;
    if (typeof treinoRedeId !== 'undefined' && treinoRedeId !== null) _urlParams.treinoRedeId = treinoRedeId;
    if (typeof valorEntrada !== 'undefined' && valorEntrada !== null) _urlParams.valorEntrada = valorEntrada;
    if (typeof valorReferencia !== 'undefined' && valorReferencia !== null) _urlParams.valorReferencia = valorReferencia;
    if (typeof tipoCompraVenda !== 'undefined' && tipoCompraVenda !== null) _urlParams.tipoCompraVenda = tipoCompraVenda;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {object} data Request data.
   *
   *  - `previsao` – `{object}` - 
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `PrevisaoTeste` object.)
   * </em>
   */
  public AtualizaResultadoTeste(previsao: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "POST";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/PrevisaoTestes/atualizaResultadoTeste";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof previsao !== 'undefined' && previsao !== null) _urlParams.previsao = previsao;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {object} data Request data.
   *
   *  - `idTreino` – `{number}` - 
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `PrevisaoTeste` object.)
   * </em>
   */
  public AtualizaPosicaoDiaPorTreino(idTreino: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "POST";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/PrevisaoTestes/atualizaPosicaoDiaPorTreino";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof idTreino !== 'undefined' && idTreino !== null) _urlParams.idTreino = idTreino;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} treinoRedeId 
   *
   * @param {number} diaNumInicial 
   *
   * @param {number} diaNumFinal 
   *
   * @param {number} limiteValor 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `PrevisaoTeste` object.)
   * </em>
   */
  public ListaComDiarioTargetStopTeste(treinoRedeId: any = {}, diaNumInicial: any = {}, diaNumFinal: any = {}, limiteValor: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/PrevisaoTestes/listaComDiarioTargetStopTeste";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof treinoRedeId !== 'undefined' && treinoRedeId !== null) _urlParams.treinoRedeId = treinoRedeId;
    if (typeof diaNumInicial !== 'undefined' && diaNumInicial !== null) _urlParams.diaNumInicial = diaNumInicial;
    if (typeof diaNumFinal !== 'undefined' && diaNumFinal !== null) _urlParams.diaNumFinal = diaNumFinal;
    if (typeof limiteValor !== 'undefined' && limiteValor !== null) _urlParams.limiteValor = limiteValor;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} treinoRedeId 
   *
   * @param {number} qtdeScore 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `PrevisaoTeste` object.)
   * </em>
   */
  public ListaComDiarioTargetStopPeriodoTesteScore(treinoRedeId: any = {}, qtdeScore: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/PrevisaoTestes/listaComDiarioTargetStopPeriodoTesteScore";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof treinoRedeId !== 'undefined' && treinoRedeId !== null) _urlParams.treinoRedeId = treinoRedeId;
    if (typeof qtdeScore !== 'undefined' && qtdeScore !== null) _urlParams.qtdeScore = qtdeScore;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * The name of the model represented by this $resource,
   * i.e. `PrevisaoTeste`.
   */
  public getModelName() {
    return "PrevisaoTeste";
  }
}
