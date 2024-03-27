/* tslint:disable */
import {
  CotacaoIntradayAcaoResultadoValor
} from '../index';

declare var Object: any;
export interface CotacaoIntradayAcaoResultadoInterface {
  "ticker"?: string;
  "valor"?: number;
  "hora"?: string;
  "dia"?: Date;
  "dataHora"?: Date;
  "diaNum"?: number;
  "diaHoraNumTicker"?: string;
  cotacaoIntradayAcaoResultadoValors?: CotacaoIntradayAcaoResultadoValor[];
}

export class CotacaoIntradayAcaoResultado implements CotacaoIntradayAcaoResultadoInterface {
  "ticker": string;
  "valor": number;
  "hora": string;
  "dia": Date;
  "dataHora": Date;
  "diaNum": number;
  "diaHoraNumTicker": string;
  cotacaoIntradayAcaoResultadoValors: CotacaoIntradayAcaoResultadoValor[];
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
      idName: 'diaHoraNumTicker',
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
        "diaHoraNumTicker": {
          name: 'diaHoraNumTicker',
          type: 'string'
        },
      },
      relations: {
        cotacaoIntradayAcaoResultadoValors: {
          name: 'cotacaoIntradayAcaoResultadoValors',
          type: 'CotacaoIntradayAcaoResultadoValor[]',
          model: 'CotacaoIntradayAcaoResultadoValor',
          relationType: 'hasMany',
                  keyFrom: 'diaHoraNumTicker',
          keyTo: 'diaHoraNumTicker'
        },
      }
    }
  }
}
