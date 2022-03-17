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
import { CotacaoIntradayAcaoResultadoValor } from '../../models/CotacaoIntradayAcaoResultadoValor';
import { SocketConnection } from '../../sockets/socket.connections';


/**
 * Api services for the `CotacaoIntradayAcaoResultadoValor` model.
 */
@Injectable()
export class CotacaoIntradayAcaoResultadoValorApi extends BaseLoopBackApi {

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
   * This usually means the response is a `CotacaoIntradayAcaoResultadoValor` object.)
   * </em>
   */
  public patchOrCreate(data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/CotacaoIntradayAcaoResultadoValors";
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
   * @param {any} id CotacaoIntradayAcaoResultadoValor id
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
   * This usually means the response is a `CotacaoIntradayAcaoResultadoValor` object.)
   * </em>
   */
  public patchAttributes(id: any, data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/CotacaoIntradayAcaoResultadoValors/:id";
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
   * @param {string} codigoRegra 
   *
   * @param {number} diaNumInicial 
   *
   * @param {number} diaNumFinal 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `CotacaoIntradayAcaoResultadoValor` object.)
   * </em>
   */
  public ObtemResultadoRegraData(codigoRegra: any = {}, diaNumInicial: any = {}, diaNumFinal: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/CotacaoIntradayAcaoResultadoValors/obtemResultadoRegraData";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof codigoRegra !== 'undefined' && codigoRegra !== null) _urlParams.codigoRegra = codigoRegra;
    if (typeof diaNumInicial !== 'undefined' && diaNumInicial !== null) _urlParams.diaNumInicial = diaNumInicial;
    if (typeof diaNumFinal !== 'undefined' && diaNumFinal !== null) _urlParams.diaNumFinal = diaNumFinal;
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
   *  - `lista` – `{any}` - 
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `CotacaoIntradayAcaoResultadoValor` object.)
   * </em>
   */
  public InsereLista(lista: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "POST";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/CotacaoIntradayAcaoResultadoValors/insereLista";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof lista !== 'undefined' && lista !== null) _urlParams.lista = lista;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {string} ticker 
   *
   * @param {number} idRegra 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `CotacaoIntradayAcaoResultadoValor` object.)
   * </em>
   */
  public ObtemListaTickerRegra(ticker: any = {}, idRegra: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/CotacaoIntradayAcaoResultadoValors/obtemListaTickerRegra";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof ticker !== 'undefined' && ticker !== null) _urlParams.ticker = ticker;
    if (typeof idRegra !== 'undefined' && idRegra !== null) _urlParams.idRegra = idRegra;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} idRegra 
   *
   * @param {number} diaNum 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `CotacaoIntradayAcaoResultadoValor` object.)
   * </em>
   */
  public ObtemPorRegraData(idRegra: any = {}, diaNum: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/CotacaoIntradayAcaoResultadoValors/obtemPorRegraData";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof idRegra !== 'undefined' && idRegra !== null) _urlParams.idRegra = idRegra;
    if (typeof diaNum !== 'undefined' && diaNum !== null) _urlParams.diaNum = diaNum;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {string} codigoGrupo 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `CotacaoIntradayAcaoResultadoValor` object.)
   * </em>
   */
  public ObtemDatasPorGrupo(codigoGrupo: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/CotacaoIntradayAcaoResultadoValors/obtemDatasPorGrupo";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof codigoGrupo !== 'undefined' && codigoGrupo !== null) _urlParams.codigoGrupo = codigoGrupo;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {string} codigoGrupo 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `CotacaoIntradayAcaoResultadoValor` object.)
   * </em>
   */
  public ObtemDatasPorGrupoComAtraso(codigoGrupo: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/CotacaoIntradayAcaoResultadoValors/obtemDatasPorGrupoComAtraso";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof codigoGrupo !== 'undefined' && codigoGrupo !== null) _urlParams.codigoGrupo = codigoGrupo;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} diaInicioNum 
   *
   * @param {number} diaFinalNum 
   *
   * @param {number} grupoAcaoId 
   *
   * @param {number} limiteDiaRegra 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `CotacaoIntradayAcaoResultadoValor` object.)
   * </em>
   */
  public ObtemDatasPorDataGrupoLimite(diaInicioNum: any, diaFinalNum: any, grupoAcaoId: any, limiteDiaRegra: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/CotacaoIntradayAcaoResultadoValors/obtemDatasPorDataGrupoLimite";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof diaInicioNum !== 'undefined' && diaInicioNum !== null) _urlParams.diaInicioNum = diaInicioNum;
    if (typeof diaFinalNum !== 'undefined' && diaFinalNum !== null) _urlParams.diaFinalNum = diaFinalNum;
    if (typeof grupoAcaoId !== 'undefined' && grupoAcaoId !== null) _urlParams.grupoAcaoId = grupoAcaoId;
    if (typeof limiteDiaRegra !== 'undefined' && limiteDiaRegra !== null) _urlParams.limiteDiaRegra = limiteDiaRegra;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayAcaoResultadoValor`.
   */
  public getModelName() {
    return "CotacaoIntradayAcaoResultadoValor";
  }
}
