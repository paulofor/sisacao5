/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayAcaoResultadoInterface {
  "ticker"?: string;
  "valor"?: number;
  "hora"?: string;
  "dia"?: Date;
  "dataHora"?: Date;
  "diaNum"?: number;
  "tg12St12"?: number;
  "tg13St13"?: number;
  "ativoAcaoId"?: string;
}

export class CotacaoIntradayAcaoResultado implements CotacaoIntradayAcaoResultadoInterface {
  "ticker": string;
  "valor": number;
  "hora": string;
  "dia": Date;
  "dataHora": Date;
  "diaNum": number;
  "tg12St12": number;
  "tg13St13": number;
  "ativoAcaoId": string;
  constructor(data?: CotacaoIntradayAcaoResultadoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayAcaoResultado`.
   */
  public static getModelName() {
    return "CotacaoIntradayAcaoResultado";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayAcaoResultado for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayAcaoResultadoInterface): CotacaoIntradayAcaoResultado{
    return new CotacaoIntradayAcaoResultado(data);
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
      name: 'CotacaoIntradayAcaoResultado',
      plural: 'CotacaoIntradayAcaoResultados',
      path: 'CotacaoIntradayAcaoResultados',
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
        "hora": {
          name: 'hora',
          type: 'string'
        },
        "dia": {
          name: 'dia',
          type: 'Date'
        },
        "dataHora": {
          name: 'dataHora',
          type: 'Date'
        },
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "tg12St12": {
          name: 'tg12St12',
          type: 'number'
        },
        "tg13St13": {
          name: 'tg13St13',
          type: 'number'
        },
        "ativoAcaoId": {
          name: 'ativoAcaoId',
          type: 'string'
        },
      },
      relations: {
      }
    }
  }
}
