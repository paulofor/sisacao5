/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayMercadoriaInterface {
  "ticker"?: string;
  "valor"?: number;
  "dataHoraNegStr"?: string;
  "dataHora"?: Date;
  "dia"?: Date;
  "posicaoDia"?: number;
  "intervalo"?: number;
  "diaNum"?: number;
}

export class CotacaoIntradayMercadoria implements CotacaoIntradayMercadoriaInterface {
  "ticker": string;
  "valor": number;
  "dataHoraNegStr": string;
  "dataHora": Date;
  "dia": Date;
  "posicaoDia": number;
  "intervalo": number;
  "diaNum": number;
  constructor(data?: CotacaoIntradayMercadoriaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayMercadoria`.
   */
  public static getModelName() {
    return "CotacaoIntradayMercadoria";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayMercadoria for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayMercadoriaInterface): CotacaoIntradayMercadoria{
    return new CotacaoIntradayMercadoria(data);
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
      name: 'CotacaoIntradayMercadoria',
      plural: 'CotacaoIntradayMercadoria',
      path: 'CotacaoIntradayMercadoria',
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
        "dataHoraNegStr": {
          name: 'dataHoraNegStr',
          type: 'string'
        },
        "dataHora": {
          name: 'dataHora',
          type: 'Date'
        },
        "dia": {
          name: 'dia',
          type: 'Date'
        },
        "posicaoDia": {
          name: 'posicaoDia',
          type: 'number'
        },
        "intervalo": {
          name: 'intervalo',
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
