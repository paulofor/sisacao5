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
import { ExperimentoPreRedeTreinadaScore } from '../../models/ExperimentoPreRedeTreinadaScore';
import { SocketConnection } from '../../sockets/socket.connections';


/**
 * Api services for the `ExperimentoPreRedeTreinadaScore` model.
 */
@Injectable()
export class ExperimentoPreRedeTreinadaScoreApi extends BaseLoopBackApi {

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
   * This usually means the response is a `ExperimentoPreRedeTreinadaScore` object.)
   * </em>
   */
  public patchOrCreate(data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExperimentoPreRedeTreinadaScores";
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
   * @param {any} id ExperimentoPreRedeTreinadaScore id
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
   * This usually means the response is a `ExperimentoPreRedeTreinadaScore` object.)
   * </em>
   */
  public patchAttributes(id: any, data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExperimentoPreRedeTreinadaScores/:id";
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
   * @param {number} experimentoId 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExperimentoPreRedeTreinadaScore` object.)
   * </em>
   */
  public ObtemMelhoresPorDia(diaNum: any = {}, experimentoId: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExperimentoPreRedeTreinadaScores/obtemMelhoresPorDia";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof diaNum !== 'undefined' && diaNum !== null) _urlParams.diaNum = diaNum;
    if (typeof experimentoId !== 'undefined' && experimentoId !== null) _urlParams.experimentoId = experimentoId;
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
   *  - `resultado` – `{object}` - 
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExperimentoPreRedeTreinadaScore` object.)
   * </em>
   */
  public AtualizaResultadoTrade(resultado: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "POST";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExperimentoPreRedeTreinadaScores/atualizaResultadoTrade";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof resultado !== 'undefined' && resultado !== null) _urlParams.resultado = resultado;
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
   * @param {number} experimentoId 
   *
   * @returns {object[]} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExperimentoPreRedeTreinadaScore` object.)
   * </em>
   */
  public ObtemAleatoriaBaseadaEmMelhores(diaNum: any = {}, experimentoId: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "GET";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExperimentoPreRedeTreinadaScores/obtemAleatoriaBaseadaEmMelhores";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof diaNum !== 'undefined' && diaNum !== null) _urlParams.diaNum = diaNum;
    if (typeof experimentoId !== 'undefined' && experimentoId !== null) _urlParams.experimentoId = experimentoId;
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
   *  - `score` – `{any}` - 
   *
   *  - `experimentoPreRedeTreinadaId` – `{any}` - 
   *
   *  - `diaNum` – `{any}` - 
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `ExperimentoPreRedeTreinadaScore` object.)
   * </em>
   */
  public RecebePrevisaoPreRedeTreinada(ticker: any = {}, score: any = {}, experimentoPreRedeTreinadaId: any = {}, diaNum: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "POST";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/ExperimentoPreRedeTreinadaScores/recebePrevisaoPreRedeTreinada";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof ticker !== 'undefined' && ticker !== null) _urlParams.ticker = ticker;
    if (typeof score !== 'undefined' && score !== null) _urlParams.score = score;
    if (typeof experimentoPreRedeTreinadaId !== 'undefined' && experimentoPreRedeTreinadaId !== null) _urlParams.experimentoPreRedeTreinadaId = experimentoPreRedeTreinadaId;
    if (typeof diaNum !== 'undefined' && diaNum !== null) _urlParams.diaNum = diaNum;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoPreRedeTreinadaScore`.
   */
  public getModelName() {
    return "ExperimentoPreRedeTreinadaScore";
  }
}
