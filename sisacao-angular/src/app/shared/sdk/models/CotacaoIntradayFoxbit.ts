/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayFoxbitInterface {
  "ticker"?: string;
  "valor"?: number;
  "diaNum"?: number;
  "dataHora"?: string;
  "valorCompra"?: number;
  "valorVenda"?: number;
  "tickerMoeda"?: string;
  "cambio"?: string;
}

export class CotacaoIntradayFoxbit implements CotacaoIntradayFoxbitInterface {
  "ticker": string;
  "valor": number;
  "diaNum": number;
  "dataHora": string;
  "valorCompra": number;
  "valorVenda": number;
  "tickerMoeda": string;
  "cambio": string;
  constructor(data?: CotacaoIntradayFoxbitInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayFoxbit`.
   */
  public static getModelName() {
    return "CotacaoIntradayFoxbit";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayFoxbit for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayFoxbitInterface): CotacaoIntradayFoxbit{
    return new CotacaoIntradayFoxbit(data);
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
      name: 'CotacaoIntradayFoxbit',
      plural: 'CotacaoIntradayFoxbits',
      path: 'CotacaoIntradayFoxbits',
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
        "valorCompra": {
          name: 'valorCompra',
          type: 'number'
        },
        "valorVenda": {
          name: 'valorVenda',
          type: 'number'
        },
        "tickerMoeda": {
          name: 'tickerMoeda',
          type: 'string'
        },
        "cambio": {
          name: 'cambio',
          type: 'string'
        },
      },
      relations: {
      }
    }
  }
}
