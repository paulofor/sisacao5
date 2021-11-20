/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayAcaoResultadoValorInterface {
  "ticker"?: string;
  "diaNum"?: number;
  "hora"?: string;
  "resultado"?: number;
  "diaHoraNumTicker"?: string;
  "dias"?: number;
  "regraProjecaoId"?: number;
}

export class CotacaoIntradayAcaoResultadoValor implements CotacaoIntradayAcaoResultadoValorInterface {
  "ticker": string;
  "diaNum": number;
  "hora": string;
  "resultado": number;
  "diaHoraNumTicker": string;
  "dias": number;
  "regraProjecaoId": number;
  constructor(data?: CotacaoIntradayAcaoResultadoValorInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayAcaoResultadoValor`.
   */
  public static getModelName() {
    return "CotacaoIntradayAcaoResultadoValor";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayAcaoResultadoValor for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayAcaoResultadoValorInterface): CotacaoIntradayAcaoResultadoValor{
    return new CotacaoIntradayAcaoResultadoValor(data);
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
      name: 'CotacaoIntradayAcaoResultadoValor',
      plural: 'CotacaoIntradayAcaoResultadoValors',
      path: 'CotacaoIntradayAcaoResultadoValors',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "hora": {
          name: 'hora',
          type: 'string'
        },
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
        "diaHoraNumTicker": {
          name: 'diaHoraNumTicker',
          type: 'string'
        },
        "dias": {
          name: 'dias',
          type: 'number'
        },
        "regraProjecaoId": {
          name: 'regraProjecaoId',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
