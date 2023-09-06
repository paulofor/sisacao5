/* tslint:disable */
import {
  DiaPregao
} from '../index';

declare var Object: any;
export interface CotacaoDiarioAcaoUsaInterface {
  "ticker"?: string;
  "data"?: Date;
  "abertura"?: number;
  "maximo"?: number;
  "minimo"?: number;
  "fechamento"?: number;
  "negocios"?: number;
  "volume"?: number;
  "percentual"?: number;
  "diaNum"?: number;
  "diaPregaoId"?: number;
  diaPregao?: DiaPregao;
}

export class CotacaoDiarioAcaoUsa implements CotacaoDiarioAcaoUsaInterface {
  "ticker": string;
  "data": Date;
  "abertura": number;
  "maximo": number;
  "minimo": number;
  "fechamento": number;
  "negocios": number;
  "volume": number;
  "percentual": number;
  "diaNum": number;
  "diaPregaoId": number;
  diaPregao: DiaPregao;
  constructor(data?: CotacaoDiarioAcaoUsaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoDiarioAcaoUsa`.
   */
  public static getModelName() {
    return "CotacaoDiarioAcaoUsa";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoDiarioAcaoUsa for dynamic purposes.
  **/
  public static factory(data: CotacaoDiarioAcaoUsaInterface): CotacaoDiarioAcaoUsa{
    return new CotacaoDiarioAcaoUsa(data);
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
      name: 'CotacaoDiarioAcaoUsa',
      plural: 'CotacaoDiarioAcaoUsas',
      path: 'CotacaoDiarioAcaoUsas',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "data": {
          name: 'data',
          type: 'Date'
        },
        "abertura": {
          name: 'abertura',
          type: 'number'
        },
        "maximo": {
          name: 'maximo',
          type: 'number'
        },
        "minimo": {
          name: 'minimo',
          type: 'number'
        },
        "fechamento": {
          name: 'fechamento',
          type: 'number'
        },
        "negocios": {
          name: 'negocios',
          type: 'number'
        },
        "volume": {
          name: 'volume',
          type: 'number'
        },
        "percentual": {
          name: 'percentual',
          type: 'number'
        },
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "diaPregaoId": {
          name: 'diaPregaoId',
          type: 'number'
        },
      },
      relations: {
        diaPregao: {
          name: 'diaPregao',
          type: 'DiaPregao',
          model: 'DiaPregao',
          relationType: 'belongsTo',
                  keyFrom: 'diaPregaoId',
          keyTo: 'diaNum'
        },
      }
    }
  }
}
