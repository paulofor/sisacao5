/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayAcaoResultadoInterface {
  "ticker"?: string;
  "valor"?: number;
  "hora"?: string;
  "dia"?: Date;
  "dataHora"?: Date;
  "diaNum"?: number;
  "tg15St15"?: number;
  "compraTg15St10"?: number;
  "vendaTg15St10"?: number;
  "diasTg15St15"?: number;
  "diasCompraTg15St10"?: number;
  "diasVendaTg15St10"?: number;
}

export class CotacaoIntradayAcaoResultado implements CotacaoIntradayAcaoResultadoInterface {
  "ticker": string;
  "valor": number;
  "hora": string;
  "dia": Date;
  "dataHora": Date;
  "diaNum": number;
  "tg15St15": number;
  "compraTg15St10": number;
  "vendaTg15St10": number;
  "diasTg15St15": number;
  "diasCompraTg15St10": number;
  "diasVendaTg15St10": number;
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
        "tg15St15": {
          name: 'tg15St15',
          type: 'number'
        },
        "compraTg15St10": {
          name: 'compraTg15St10',
          type: 'number'
        },
        "vendaTg15St10": {
          name: 'vendaTg15St10',
          type: 'number'
        },
        "diasTg15St15": {
          name: 'diasTg15St15',
          type: 'number'
        },
        "diasCompraTg15St10": {
          name: 'diasCompraTg15St10',
          type: 'number'
        },
        "diasVendaTg15St10": {
          name: 'diasVendaTg15St10',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
