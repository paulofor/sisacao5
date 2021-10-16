/* tslint:disable */

declare var Object: any;
export interface CotacaoDiarioIndiceInterface {
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

export class CotacaoDiarioIndice implements CotacaoDiarioIndiceInterface {
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
  constructor(data?: CotacaoDiarioIndiceInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoDiarioIndice`.
   */
  public static getModelName() {
    return "CotacaoDiarioIndice";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoDiarioIndice for dynamic purposes.
  **/
  public static factory(data: CotacaoDiarioIndiceInterface): CotacaoDiarioIndice{
    return new CotacaoDiarioIndice(data);
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
      name: 'CotacaoDiarioIndice',
      plural: 'CotacaoDiarioIndices',
      path: 'CotacaoDiarioIndices',
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
