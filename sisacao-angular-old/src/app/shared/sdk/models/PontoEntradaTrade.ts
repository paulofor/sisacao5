/* tslint:disable */

declare var Object: any;
export interface PontoEntradaTradeInterface {
  "ticker"?: string;
  "diaNum"?: number;
  "valorLimite"?: number;
  "dataHoraGeracao"?: string;
  "executado"?: number;
  "tipo"?: string;
  "id"?: number;
}

export class PontoEntradaTrade implements PontoEntradaTradeInterface {
  "ticker": string;
  "diaNum": number;
  "valorLimite": number;
  "dataHoraGeracao": string;
  "executado": number;
  "tipo": string;
  "id": number;
  constructor(data?: PontoEntradaTradeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PontoEntradaTrade`.
   */
  public static getModelName() {
    return "PontoEntradaTrade";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PontoEntradaTrade for dynamic purposes.
  **/
  public static factory(data: PontoEntradaTradeInterface): PontoEntradaTrade{
    return new PontoEntradaTrade(data);
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
      name: 'PontoEntradaTrade',
      plural: 'PontoEntradaTrades',
      path: 'PontoEntradaTrades',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "valorLimite": {
          name: 'valorLimite',
          type: 'number'
        },
        "dataHoraGeracao": {
          name: 'dataHoraGeracao',
          type: 'string'
        },
        "executado": {
          name: 'executado',
          type: 'number'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
