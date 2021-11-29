/* tslint:disable */
import {
  GrupoAcao,
  CotacaoIntradayAcaoResultadoValor
} from '../index';

declare var Object: any;
export interface RegraProjecaoInterface {
  "tipoCompraVenda"?: string;
  "target"?: number;
  "stop"?: number;
  "diaLimite"?: number;
  "processando"?: number;
  "id"?: number;
  "grupoAcaoId"?: number;
  grupoAcao?: GrupoAcao;
  cotacaoIntradayAcaoResultadoValors?: CotacaoIntradayAcaoResultadoValor[];
}

export class RegraProjecao implements RegraProjecaoInterface {
  "tipoCompraVenda": string;
  "target": number;
  "stop": number;
  "diaLimite": number;
  "processando": number;
  "id": number;
  "grupoAcaoId": number;
  grupoAcao: GrupoAcao;
  cotacaoIntradayAcaoResultadoValors: CotacaoIntradayAcaoResultadoValor[];
  constructor(data?: RegraProjecaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RegraProjecao`.
   */
  public static getModelName() {
    return "RegraProjecao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RegraProjecao for dynamic purposes.
  **/
  public static factory(data: RegraProjecaoInterface): RegraProjecao{
    return new RegraProjecao(data);
  }
  /**
  * @method getModelDefinition
  * @author Julien Ledun
  * @license MIT
  * This method returns an object that represents some of the model
  * definitions.
  **/
  public static getModelDefinition() {
    return {
      name: 'RegraProjecao',
      plural: 'RegraProjecaos',
      path: 'RegraProjecaos',
      idName: 'id',
      properties: {
        "tipoCompraVenda": {
          name: 'tipoCompraVenda',
          type: 'string'
        },
        "target": {
          name: 'target',
          type: 'number'
        },
        "stop": {
          name: 'stop',
          type: 'number'
        },
        "diaLimite": {
          name: 'diaLimite',
          type: 'number'
        },
        "processando": {
          name: 'processando',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "grupoAcaoId": {
          name: 'grupoAcaoId',
          type: 'number'
        },
      },
      relations: {
        grupoAcao: {
          name: 'grupoAcao',
          type: 'GrupoAcao',
          model: 'GrupoAcao',
          relationType: 'belongsTo',
                  keyFrom: 'grupoAcaoId',
          keyTo: 'id'
        },
        cotacaoIntradayAcaoResultadoValors: {
          name: 'cotacaoIntradayAcaoResultadoValors',
          type: 'CotacaoIntradayAcaoResultadoValor[]',
          model: 'CotacaoIntradayAcaoResultadoValor',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'regraProjecaoId'
        },
      }
    }
  }
}
