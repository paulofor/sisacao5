/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayIndiceResultadoInterface {
  "ticker"?: string;
  "hora"?: string;
  "valor"?: number;
  "dia"?: Date;
  "diaNum"?: number;
  "dataHora"?: Date;
  "diaHoraNumTicker"?: string;
  "posicaoDia"?: number;
}

export class CotacaoIntradayIndiceResultado implements CotacaoIntradayIndiceResultadoInterface {
  "ticker": string;
  "hora": string;
  "valor": number;
  "dia": Date;
  "diaNum": number;
  "dataHora": Date;
  "diaHoraNumTicker": string;
  "posicaoDia": number;
  constructor(data?: CotacaoIntradayIndiceResultadoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayIndiceResultado`.
   */
  public static getModelName() {
    return "CotacaoIntradayIndiceResultado";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayIndiceResultado for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayIndiceResultadoInterface): CotacaoIntradayIndiceResultado{
    return new CotacaoIntradayIndiceResultado(data);
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
      name: 'CotacaoIntradayIndiceResultado',
      plural: 'CotacaoIntradayIndiceResultados',
      path: 'CotacaoIntradayIndiceResultados',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "hora": {
          name: 'hora',
          type: 'string'
        },
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "dia": {
          name: 'dia',
          type: 'Date'
        },
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "dataHora": {
          name: 'dataHora',
          type: 'Date'
        },
        "diaHoraNumTicker": {
          name: 'diaHoraNumTicker',
          type: 'string'
        },
        "posicaoDia": {
          name: 'posicaoDia',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
