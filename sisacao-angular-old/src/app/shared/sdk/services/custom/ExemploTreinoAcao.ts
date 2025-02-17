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
import { ExemploTreinoAcao } from '../../models/ExemploTreinoAcao';
import { SocketConnection } from '../../sockets/socket.connections';


/**
 * Api services for the `ExemploTreinoAcao` model.
 */
@Injectable()
export class ExemploTreinoAcaoApi extends BaseLoopBackApi {

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
   * This usually means the response is a `ExemploTreinoAcao` object.)
   * </em>
   */
  public patchOrCreate(data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaos";
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
   * @param {any} id ExemploTreinoAcao id
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
   * This usually means the response is a `ExemploTreinoAcao` object.)
   * </em>
   */
  public patchAttributes(id: any, data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaos/:id";
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
   * @param {number} diaNum 
   *
   * @param {string} codigoGrupoAcao 
   *
   * @param {string} codigoRegraProjecao 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcao` object.)
   * </em>
   */
  public ObtemPorDia(diaNum: any, codigoGrupoAcao: any, codigoRegraProjecao: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaos/obtemPorDia";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof diaNum !== 'undefined' && diaNum !== null) _urlParams.diaNum = diaNum;
    if (typeof codigoGrupoAcao !== 'undefined' && codigoGrupoAcao !== null) _urlParams.codigoGrupoAcao = codigoGrupoAcao;
    if (typeof codigoRegraProjecao !== 'undefined' && codigoRegraProjecao !== null) _urlParams.codigoRegraProjecao = codigoRegraProjecao;
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
   * This usually means the response is a `ExemploTreinoAcao` object.)
   * </em>
   */
  public InsereExemplo(exemplo: any, customHeaders?: Function): Observable<any> {
    let _method: string = "POST";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaos/insereExemplo";
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
   * @param {number} idPeriodo 
   *
   * @param {string} codigoGrupoAcao 
   *
   * @param {string} codigoRegraProjecao 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcao` object.)
   * </em>
   */
  public ObtemConjuntoTreino(idPeriodo: any, codigoGrupoAcao: any, codigoRegraProjecao: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaos/obtemConjuntoTreino";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof idPeriodo !== 'undefined' && idPeriodo !== null) _urlParams.idPeriodo = idPeriodo;
    if (typeof codigoGrupoAcao !== 'undefined' && codigoGrupoAcao !== null) _urlParams.codigoGrupoAcao = codigoGrupoAcao;
    if (typeof codigoRegraProjecao !== 'undefined' && codigoRegraProjecao !== null) _urlParams.codigoRegraProjecao = codigoRegraProjecao;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * <em>
         * (The remote method definition does not provide any description.)
         * </em>
   *
   * @param {number} idPeriodo 
   *
   * @param {string} codigoGrupoAcao 
   *
   * @param {string} codigoRegraProjecao 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExemploTreinoAcao` object.)
   * </em>
   */
  public ObtemConjuntoDesenvolvimento(idPeriodo: any, codigoGrupoAcao: any, codigoRegraProjecao: any, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaos/obtemConjuntoDesenvolvimento";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof idPeriodo !== 'undefined' && idPeriodo !== null) _urlParams.idPeriodo = idPeriodo;
    if (typeof codigoGrupoAcao !== 'undefined' && codigoGrupoAcao !== null) _urlParams.codigoGrupoAcao = codigoGrupoAcao;
    if (typeof codigoRegraProjecao !== 'undefined' && codigoRegraProjecao !== null) _urlParams.codigoRegraProjecao = codigoRegraProjecao;
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
   * This usually means the response is a `ExemploTreinoAcao` object.)
   * </em>
   */
  public ObtemParaTeste(customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExemploTreinoAcaos/obtemParaTeste";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * The name of the model represented by this $resource,
   * i.e. `ExemploTreinoAcao`.
   */
  public getModelName() {
    return "ExemploTreinoAcao";
  }
}
