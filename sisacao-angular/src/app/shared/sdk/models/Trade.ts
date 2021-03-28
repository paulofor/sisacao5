/* tslint:disable */

declare var Object: any;
export interface TradeInterface {
  "precoEntrada"?: number;
  "dataEntradaNum"?: number;
  "dataHoraEntrada"?: string;
  "precoSaida"?: number;
  "dataSaidaNum"?: number;
  "dataHoraSaida"?: string;
  "lucroPrejuizo"?: string;
  "percentual"?: number;
  "quantidadeDia"?: number;
  "id"?: number;
  "execucaoSimulacaoId"?: number;
}

export class Trade implements TradeInterface {
  "precoEntrada": number;
  "dataEntradaNum": number;
  "dataHoraEntrada": string;
  "precoSaida": number;
  "dataSaidaNum": number;
  "dataHoraSaida": string;
  "lucroPrejuizo": string;
  "percentual": number;
  "quantidadeDia": number;
  "id": number;
  "execucaoSimulacaoId": number;
  constructor(data?: TradeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `Trade`.
   */
  public static getModelName() {
    return "Trade";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of Trade for dynamic purposes.
  **/
  public static factory(data: TradeInterface): Trade{
    return new Trade(data);
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
      name: 'Trade',
      plural: 'Trades',
      path: 'Trades',
      idName: 'id',
      properties: {
        "precoEntrada": {
          name: 'precoEntrada',
          type: 'number'
        },
        "dataEntradaNum": {
          name: 'dataEntradaNum',
          type: 'number'
        },
        "dataHoraEntrada": {
          name: 'dataHoraEntrada',
          type: 'string'
        },
        "precoSaida": {
          name: 'precoSaida',
          type: 'number'
        },
        "dataSaidaNum": {
          name: 'dataSaidaNum',
          type: 'number'
        },
        "dataHoraSaida": {
          name: 'dataHoraSaida',
          type: 'string'
        },
        "lucroPrejuizo": {
          name: 'lucroPrejuizo',
          type: 'string'
        },
        "percentual": {
          name: 'percentual',
          type: 'number'
        },
        "quantidadeDia": {
          name: 'quantidadeDia',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "execucaoSimulacaoId": {
          name: 'execucaoSimulacaoId',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
