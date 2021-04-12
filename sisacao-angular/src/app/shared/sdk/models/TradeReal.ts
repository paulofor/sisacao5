/* tslint:disable */

declare var Object: any;
export interface TradeRealInterface {
  "ticker"?: string;
  "precoEntrada"?: number;
  "precoSaida"?: number;
  "dataNumEntrada"?: number;
  "dataNumSaida"?: number;
  "quantidade"?: number;
  "valorEntrada"?: number;
  "valorSaida"?: number;
  "custoEntrada"?: number;
  "custoSaida"?: number;
  "fracionario"?: number;
  "precoTarget"?: number;
  "valorTarget"?: number;
  "precoStop"?: number;
  "valorStop"?: number;
  "posicaoAtual"?: number;
  "lucroPrejuizo"?: number;
  "dataEntrada"?: Date;
  "dataSaida"?: Date;
  "valorExposicao"?: number;
  "lucroAlvo"?: number;
  "percentual"?: number;
  "dias"?: number;
  "custoTotal"?: number;
  "id"?: number;
  "execucaoSimulacaoId"?: number;
}

export class TradeReal implements TradeRealInterface {
  "ticker": string;
  "precoEntrada": number;
  "precoSaida": number;
  "dataNumEntrada": number;
  "dataNumSaida": number;
  "quantidade": number;
  "valorEntrada": number;
  "valorSaida": number;
  "custoEntrada": number;
  "custoSaida": number;
  "fracionario": number;
  "precoTarget": number;
  "valorTarget": number;
  "precoStop": number;
  "valorStop": number;
  "posicaoAtual": number;
  "lucroPrejuizo": number;
  "dataEntrada": Date;
  "dataSaida": Date;
  "valorExposicao": number;
  "lucroAlvo": number;
  "percentual": number;
  "dias": number;
  "custoTotal": number;
  "id": number;
  "execucaoSimulacaoId": number;
  constructor(data?: TradeRealInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TradeReal`.
   */
  public static getModelName() {
    return "TradeReal";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TradeReal for dynamic purposes.
  **/
  public static factory(data: TradeRealInterface): TradeReal{
    return new TradeReal(data);
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
      name: 'TradeReal',
      plural: 'TradeReals',
      path: 'TradeReals',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "precoEntrada": {
          name: 'precoEntrada',
          type: 'number'
        },
        "precoSaida": {
          name: 'precoSaida',
          type: 'number'
        },
        "dataNumEntrada": {
          name: 'dataNumEntrada',
          type: 'number'
        },
        "dataNumSaida": {
          name: 'dataNumSaida',
          type: 'number'
        },
        "quantidade": {
          name: 'quantidade',
          type: 'number'
        },
        "valorEntrada": {
          name: 'valorEntrada',
          type: 'number'
        },
        "valorSaida": {
          name: 'valorSaida',
          type: 'number'
        },
        "custoEntrada": {
          name: 'custoEntrada',
          type: 'number'
        },
        "custoSaida": {
          name: 'custoSaida',
          type: 'number'
        },
        "fracionario": {
          name: 'fracionario',
          type: 'number'
        },
        "precoTarget": {
          name: 'precoTarget',
          type: 'number'
        },
        "valorTarget": {
          name: 'valorTarget',
          type: 'number'
        },
        "precoStop": {
          name: 'precoStop',
          type: 'number'
        },
        "valorStop": {
          name: 'valorStop',
          type: 'number'
        },
        "posicaoAtual": {
          name: 'posicaoAtual',
          type: 'number'
        },
        "lucroPrejuizo": {
          name: 'lucroPrejuizo',
          type: 'number'
        },
        "dataEntrada": {
          name: 'dataEntrada',
          type: 'Date'
        },
        "dataSaida": {
          name: 'dataSaida',
          type: 'Date'
        },
        "valorExposicao": {
          name: 'valorExposicao',
          type: 'number'
        },
        "lucroAlvo": {
          name: 'lucroAlvo',
          type: 'number'
        },
        "percentual": {
          name: 'percentual',
          type: 'number'
        },
        "dias": {
          name: 'dias',
          type: 'number'
        },
        "custoTotal": {
          name: 'custoTotal',
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
