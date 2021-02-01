/* tslint:disable */
import {
  CotacaoIntradayAcao,
  CotacaoIntradayMercadoria
} from '../index';

declare var Object: any;
export interface DiaPregaoInterface {
  "diaNum"?: number;
  "mes"?: number;
  "ano"?: number;
  "dataStr"?: string;
  cotacaoIntradayAcaos?: CotacaoIntradayAcao[];
  cotacaoIntradayMercadorias?: CotacaoIntradayMercadoria[];
}

export class DiaPregao implements DiaPregaoInterface {
  "diaNum": number;
  "mes": number;
  "ano": number;
  "dataStr": string;
  cotacaoIntradayAcaos: CotacaoIntradayAcao[];
  cotacaoIntradayMercadorias: CotacaoIntradayMercadoria[];
  constructor(data?: DiaPregaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `DiaPregao`.
   */
  public static getModelName() {
    return "DiaPregao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of DiaPregao for dynamic purposes.
  **/
  public static factory(data: DiaPregaoInterface): DiaPregao{
    return new DiaPregao(data);
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
      name: 'DiaPregao',
      plural: 'DiaPregaos',
      path: 'DiaPregaos',
      idName: 'diaNum',
      properties: {
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "mes": {
          name: 'mes',
          type: 'number'
        },
        "ano": {
          name: 'ano',
          type: 'number'
        },
        "dataStr": {
          name: 'dataStr',
          type: 'string'
        },
      },
      relations: {
        cotacaoIntradayAcaos: {
          name: 'cotacaoIntradayAcaos',
          type: 'CotacaoIntradayAcao[]',
          model: 'CotacaoIntradayAcao',
          relationType: 'hasMany',
                  keyFrom: 'diaNum',
          keyTo: 'diaNum'
        },
        cotacaoIntradayMercadorias: {
          name: 'cotacaoIntradayMercadorias',
          type: 'CotacaoIntradayMercadoria[]',
          model: 'CotacaoIntradayMercadoria',
          relationType: 'hasMany',
                  keyFrom: 'diaNum',
          keyTo: 'diaNum'
        },
      }
    }
  }
}
