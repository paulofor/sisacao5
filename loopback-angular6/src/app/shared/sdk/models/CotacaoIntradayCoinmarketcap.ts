/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayCoinmarketcapInterface {
  "ticker"?: string;
  "dataHora"?: Date;
  "diaNum"?: number;
  "numMarketPair"?: number;
  "circulationSupply"?: number;
  "totalSupply"?: number;
  "cmcRank"?: number;
  "price"?: number;
  "volume24h"?: number;
  "marketCap"?: number;
  "marketCapDominance"?: number;
  "fullyDilutedMarketCap"?: number;
}

export class CotacaoIntradayCoinmarketcap implements CotacaoIntradayCoinmarketcapInterface {
  "ticker": string;
  "dataHora": Date;
  "diaNum": number;
  "numMarketPair": number;
  "circulationSupply": number;
  "totalSupply": number;
  "cmcRank": number;
  "price": number;
  "volume24h": number;
  "marketCap": number;
  "marketCapDominance": number;
  "fullyDilutedMarketCap": number;
  constructor(data?: CotacaoIntradayCoinmarketcapInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayCoinmarketcap`.
   */
  public static getModelName() {
    return "CotacaoIntradayCoinmarketcap";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayCoinmarketcap for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayCoinmarketcapInterface): CotacaoIntradayCoinmarketcap{
    return new CotacaoIntradayCoinmarketcap(data);
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
      name: 'CotacaoIntradayCoinmarketcap',
      plural: 'CotacaoIntradayCoinmarketcaps',
      path: 'CotacaoIntradayCoinmarketcaps',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "dataHora": {
          name: 'dataHora',
          type: 'Date'
        },
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "numMarketPair": {
          name: 'numMarketPair',
          type: 'number'
        },
        "circulationSupply": {
          name: 'circulationSupply',
          type: 'number'
        },
        "totalSupply": {
          name: 'totalSupply',
          type: 'number'
        },
        "cmcRank": {
          name: 'cmcRank',
          type: 'number'
        },
        "price": {
          name: 'price',
          type: 'number'
        },
        "volume24h": {
          name: 'volume24h',
          type: 'number'
        },
        "marketCap": {
          name: 'marketCap',
          type: 'number'
        },
        "marketCapDominance": {
          name: 'marketCapDominance',
          type: 'number'
        },
        "fullyDilutedMarketCap": {
          name: 'fullyDilutedMarketCap',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
