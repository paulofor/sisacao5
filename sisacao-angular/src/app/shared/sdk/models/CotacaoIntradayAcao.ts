/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayAcaoInterface {
  "ticker"?: string;
  "valor"?: number;
  "dataHoraNegStr"?: string;
  "dataHora"?: Date;
  "dia"?: Date;
  "posicaoDia"?: number;
  "intervalo"?: number;
}

export class CotacaoIntradayAcao implements CotacaoIntradayAcaoInterface {
  "ticker": string;
  "valor": number;
  "dataHoraNegStr": string;
  "dataHora": Date;
  "dia": Date;
  "posicaoDia": number;
  "intervalo": number;
  constructor(data?: CotacaoIntradayAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayAcao`.
   */
  public static getModelName() {
    return "CotacaoIntradayAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayAcao for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayAcaoInterface): CotacaoIntradayAcao{
    return new CotacaoIntradayAcao(data);
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
      name: 'CotacaoIntradayAcao',
      plural: 'CotacaoIntradayAcaos',
      path: 'CotacaoIntradayAcaos',
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
