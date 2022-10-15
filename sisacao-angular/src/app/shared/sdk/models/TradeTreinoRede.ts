/* tslint:disable */

declare var Object: any;
export interface TradeTreinoRedeInterface {
  "ticker"?: string;
  "precoEntrada"?: number;
  "diaNumEntrada"?: number;
  "precoSaida"?: number;
  "diaNumSaida"?: number;
  "treinoRedeId"?: number;
  "tipoCompraVenda"?: string;
  "resultado"?: number;
  "pontuacao"?: number;
  "percentualAtual"?: number;
  "precoAtual"?: number;
  "diaNumAtual"?: number;
}

export class TradeTreinoRede implements TradeTreinoRedeInterface {
  "ticker": string;
  "precoEntrada": number;
  "diaNumEntrada": number;
  "precoSaida": number;
  "diaNumSaida": number;
  "treinoRedeId": number;
  "tipoCompraVenda": string;
  "resultado": number;
  "pontuacao": number;
  "percentualAtual": number;
  "precoAtual": number;
  "diaNumAtual": number;
  constructor(data?: TradeTreinoRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TradeTreinoRede`.
   */
  public static getModelName() {
    return "TradeTreinoRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TradeTreinoRede for dynamic purposes.
  **/
  public static factory(data: TradeTreinoRedeInterface): TradeTreinoRede{
    return new TradeTreinoRede(data);
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
      name: 'TradeTreinoRede',
      plural: 'TradeTreinoRedes',
      path: 'TradeTreinoRedes',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "precoEntrada": {
          name: 'precoEntrada',
          type: 'number'
        },
        "diaNumEntrada": {
          name: 'diaNumEntrada',
          type: 'number'
        },
        "precoSaida": {
          name: 'precoSaida',
          type: 'number'
        },
        "diaNumSaida": {
          name: 'diaNumSaida',
          type: 'number'
        },
        "treinoRedeId": {
          name: 'treinoRedeId',
          type: 'number'
        },
        "tipoCompraVenda": {
          name: 'tipoCompraVenda',
          type: 'string'
        },
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
        "pontuacao": {
          name: 'pontuacao',
          type: 'number'
        },
        "percentualAtual": {
          name: 'percentualAtual',
          type: 'number'
        },
        "precoAtual": {
          name: 'precoAtual',
          type: 'number'
        },
        "diaNumAtual": {
          name: 'diaNumAtual',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
