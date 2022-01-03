/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayMercadoBitcoinInterface {
  "ticker"?: string;
  "valor"?: number;
  "diaNum"?: number;
  "dataHora"?: string;
  "maximo"?: number;
  "minimo"?: number;
  "tickerMoeda"?: string;
}

export class CotacaoIntradayMercadoBitcoin implements CotacaoIntradayMercadoBitcoinInterface {
  "ticker": string;
  "valor": number;
  "diaNum": number;
  "dataHora": string;
  "maximo": number;
  "minimo": number;
  "tickerMoeda": string;
  constructor(data?: CotacaoIntradayMercadoBitcoinInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayMercadoBitcoin`.
   */
  public static getModelName() {
    return "CotacaoIntradayMercadoBitcoin";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayMercadoBitcoin for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayMercadoBitcoinInterface): CotacaoIntradayMercadoBitcoin{
    return new CotacaoIntradayMercadoBitcoin(data);
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
      name: 'CotacaoIntradayMercadoBitcoin',
      plural: 'CotacaoIntradayMercadoBitcoins',
      path: 'CotacaoIntradayMercadoBitcoins',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "dataHora": {
          name: 'dataHora',
          type: 'string'
        },
        "maximo": {
          name: 'maximo',
          type: 'number'
        },
        "minimo": {
          name: 'minimo',
          type: 'number'
        },
        "tickerMoeda": {
          name: 'tickerMoeda',
          type: 'string'
        },
      },
      relations: {
      }
    }
  }
}
