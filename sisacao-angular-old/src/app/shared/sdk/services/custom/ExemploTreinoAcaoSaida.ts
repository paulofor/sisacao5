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
import { ExemploTreinoAcaoSaida } from '../../models/ExemploTreinoAcaoSaida';
import { SocketConnection } from '../../sockets/socket.connections';


/**
 * Api services for the `ExemploTreinoAcaoSaida` model.
 */
@Injectable()
export class ExemploTreinoAcaoSaidaApi extends BaseLoopBackApi {

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
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public patchOrCreate(data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas";
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
   * @param {any} id ExemploTreinoAcaoSaida id
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
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public patchAttributes(id: any, data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas/:id";
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
   *  - `exemplo` – `{object}` - 
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public InsereExemploSaida(exemplo: any, customHeaders?: Function): Observable<any> {
    let _method: string = "POST";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas/insereExemploSaida";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof exemplo !== 'undefined' && exemplo !== null) _urlParams.exemplo = exemplo;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} idGrupo 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public ResumoPorRegraGrupo(idGrupo: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas/resumoPorRegraGrupo";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof idGrupo !== 'undefined' && idGrupo !== null) _urlParams.idGrupo = idGrupo;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public ResumoPorRegra(customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas/resumoPorRegra";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
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
   * @param {number} diaNumPrevisao 
   *
   * @param {number} regraProjecaoId 
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public ObtemComEntrada(ticker: any, diaNumPrevisao: any, regraProjecaoId: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas/obtemComEntrada";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof ticker !== 'undefined' && ticker !== null) _urlParams.ticker = ticker;
    if (typeof diaNumPrevisao !== 'undefined' && diaNumPrevisao !== null) _urlParams.diaNumPrevisao = diaNumPrevisao;
    if (typeof regraProjecaoId !== 'undefined' && regraProjecaoId !== null) _urlParams.regraProjecaoId = regraProjecaoId;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} diaNumInicio 
   *
   * @param {number} diaNumFinal 
   *
   * @param {number} idGrupoAcao 
   *
   * @param {number} idRegraProjecao 
   *
   * @param {number} idTipoExemplo 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public ListaParaTreino(diaNumInicio: any, diaNumFinal: any, idGrupoAcao: any, idRegraProjecao: any, idTipoExemplo: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas/listaParaTreino";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof diaNumInicio !== 'undefined' && diaNumInicio !== null) _urlParams.diaNumInicio = diaNumInicio;
    if (typeof diaNumFinal !== 'undefined' && diaNumFinal !== null) _urlParams.diaNumFinal = diaNumFinal;
    if (typeof idGrupoAcao !== 'undefined' && idGrupoAcao !== null) _urlParams.idGrupoAcao = idGrupoAcao;
    if (typeof idRegraProjecao !== 'undefined' && idRegraProjecao !== null) _urlParams.idRegraProjecao = idRegraProjecao;
    if (typeof idTipoExemplo !== 'undefined' && idTipoExemplo !== null) _urlParams.idTipoExemplo = idTipoExemplo;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} diaNumInicio 
   *
   * @param {number} diaNumFinal 
   *
   * @param {number} idGrupoAcao 
   *
   * @param {number} idRegraProjecao 
   *
   * @param {number} idTipoExemplo 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public ListaParaExperiencia(diaNumInicio: any, diaNumFinal: any, idGrupoAcao: any, idRegraProjecao: any, idTipoExemplo: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas/listaParaExperiencia";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof diaNumInicio !== 'undefined' && diaNumInicio !== null) _urlParams.diaNumInicio = diaNumInicio;
    if (typeof diaNumFinal !== 'undefined' && diaNumFinal !== null) _urlParams.diaNumFinal = diaNumFinal;
    if (typeof idGrupoAcao !== 'undefined' && idGrupoAcao !== null) _urlParams.idGrupoAcao = idGrupoAcao;
    if (typeof idRegraProjecao !== 'undefined' && idRegraProjecao !== null) _urlParams.idRegraProjecao = idRegraProjecao;
    if (typeof idTipoExemplo !== 'undefined' && idTipoExemplo !== null) _urlParams.idTipoExemplo = idTipoExemplo;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} diaNumInicio 
   *
   * @param {number} diaNumFinal 
   *
   * @param {number} idGrupoAcao 
   *
   * @param {number} idRegraProjecao 
   *
   * @param {number} idTipoExemplo 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public ListaParaExperienciaValidacao(diaNumInicio: any, diaNumFinal: any, idGrupoAcao: any, idRegraProjecao: any, idTipoExemplo: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas/listaParaExperienciaValidacao";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof diaNumInicio !== 'undefined' && diaNumInicio !== null) _urlParams.diaNumInicio = diaNumInicio;
    if (typeof diaNumFinal !== 'undefined' && diaNumFinal !== null) _urlParams.diaNumFinal = diaNumFinal;
    if (typeof idGrupoAcao !== 'undefined' && idGrupoAcao !== null) _urlParams.idGrupoAcao = idGrupoAcao;
    if (typeof idRegraProjecao !== 'undefined' && idRegraProjecao !== null) _urlParams.idRegraProjecao = idRegraProjecao;
    if (typeof idTipoExemplo !== 'undefined' && idTipoExemplo !== null) _urlParams.idTipoExemplo = idTipoExemplo;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} diaNumInicio 
   *
   * @param {number} diaNumFinal 
   *
   * @param {number} idGrupoAcao 
   *
   * @param {number} idRegraProjecao 
   *
   * @param {number} idTipoExemplo 
   *
   * @param {number} quantidade 
   *
   * @param {number} classeSaida 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcaoSaida` object.)
   * </em>
   */
  public ListaParaAnalise(diaNumInicio: any, diaNumFinal: any, idGrupoAcao: any, idRegraProjecao: any, idTipoExemplo: any, quantidade: any, classeSaida: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaoSaidas/listaParaAnalise";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof diaNumInicio !== 'undefined' && diaNumInicio !== null) _urlParams.diaNumInicio = diaNumInicio;
    if (typeof diaNumFinal !== 'undefined' && diaNumFinal !== null) _urlParams.diaNumFinal = diaNumFinal;
    if (typeof idGrupoAcao !== 'undefined' && idGrupoAcao !== null) _urlParams.idGrupoAcao = idGrupoAcao;
    if (typeof idRegraProjecao !== 'undefined' && idRegraProjecao !== null) _urlParams.idRegraProjecao = idRegraProjecao;
    if (typeof idTipoExemplo !== 'undefined' && idTipoExemplo !== null) _urlParams.idTipoExemplo = idTipoExemplo;
    if (typeof quantidade !== 'undefined' && quantidade !== null) _urlParams.quantidade = quantidade;
    if (typeof classeSaida !== 'undefined' && classeSaida !== null) _urlParams.classeSaida = classeSaida;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * The name of the model represented by this $resource,
   * i.e. `ExemploTreinoAcaoSaida`.
   */
  public getModelName() {
    return "ExemploTreinoAcaoSaida";
  }
}
