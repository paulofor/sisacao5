/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayImobiliarioInterface {
  "ticker"?: string;
  "valor"?: number;
  "dataHoraNegStr"?: string;
  "dataHora"?: Date;
  "dia"?: Date;
  "posicaoDia"?: number;
  "intervalo"?: number;
}

export class CotacaoIntradayImobiliario implements CotacaoIntradayImobiliarioInterface {
  "ticker": string;
  "valor": number;
  "dataHoraNegStr": string;
  "dataHora": Date;
  "dia": Date;
  "posicaoDia": number;
  "intervalo": number;
  constructor(data?: CotacaoIntradayImobiliarioInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayImobiliario`.
   */
  public static getModelName() {
    return "CotacaoIntradayImobiliario";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayImobiliario for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayImobiliarioInterface): CotacaoIntradayImobiliario{
    return new CotacaoIntradayImobiliario(data);
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
      name: 'CotacaoIntradayImobiliario',
      plural: 'CotacaoIntradayImobiliarios',
      path: 'CotacaoIntradayImobiliarios',
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
      },
      relations: {
      }
    }
  }
}
