/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayOpcaoInterface {
  "ticker"?: string;
  "valor"?: number;
  "dataHoraNegStr"?: string;
  "dataHora"?: Date;
  "dia"?: Date;
  "posicaoDia"?: number;
  "intervalo"?: number;
}

export class CotacaoIntradayOpcao implements CotacaoIntradayOpcaoInterface {
  "ticker": string;
  "valor": number;
  "dataHoraNegStr": string;
  "dataHora": Date;
  "dia": Date;
  "posicaoDia": number;
  "intervalo": number;
  constructor(data?: CotacaoIntradayOpcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayOpcao`.
   */
  public static getModelName() {
    return "CotacaoIntradayOpcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayOpcao for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayOpcaoInterface): CotacaoIntradayOpcao{
    return new CotacaoIntradayOpcao(data);
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
      name: 'CotacaoIntradayOpcao',
      plural: 'CotacaoIntradayOpcaos',
      path: 'CotacaoIntradayOpcaos',
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
