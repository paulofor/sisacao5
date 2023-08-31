/* tslint:disable */

declare var Object: any;
export interface CotacaoDiarioAcaoInterface {
  "ticker"?: string;
  "data"?: string;
  "abertura"?: number;
  "maximo"?: number;
  "minimo"?: number;
  "fechamento"?: number;
  "negocios"?: number;
  "volume"?: number;
  "percentual"?: number;
  "diaNum"?: number;
}

export class CotacaoDiarioAcao implements CotacaoDiarioAcaoInterface {
  "ticker": string;
  "data": string;
  "abertura": number;
  "maximo": number;
  "minimo": number;
  "fechamento": number;
  "negocios": number;
  "volume": number;
  "percentual": number;
  "diaNum": number;
  constructor(data?: CotacaoDiarioAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoDiarioAcao`.
   */
  public static getModelName() {
    return "CotacaoDiarioAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoDiarioAcao for dynamic purposes.
  **/
  public static factory(data: CotacaoDiarioAcaoInterface): CotacaoDiarioAcao{
    return new CotacaoDiarioAcao(data);
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
      name: 'CotacaoDiarioAcao',
      plural: 'CotacaoDiarioAcaos',
      path: 'CotacaoDiarioAcaos',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "data": {
          name: 'data',
          type: 'string'
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
      },
      relations: {
      }
    }
  }
}
