/* tslint:disable */

declare var Object: any;
export interface PrevisaoTesteInterface {
  "ticker"?: string;
  "diaNumPrevisao"?: number;
  "valorPrevisao"?: number;
  "precoEntrada"?: number;
  "precoReferencia"?: number;
  "treinoRedeId"?: number;
  "tipoCompraVenda"?: string;
  "precoSaida"?: number;
  "resultado"?: number;
  "diaNumSaida"?: number;
  "pontuacao"?: number;
  "id"?: number;
}

export class PrevisaoTeste implements PrevisaoTesteInterface {
  "ticker": string;
  "diaNumPrevisao": number;
  "valorPrevisao": number;
  "precoEntrada": number;
  "precoReferencia": number;
  "treinoRedeId": number;
  "tipoCompraVenda": string;
  "precoSaida": number;
  "resultado": number;
  "diaNumSaida": number;
  "pontuacao": number;
  "id": number;
  constructor(data?: PrevisaoTesteInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PrevisaoTeste`.
   */
  public static getModelName() {
    return "PrevisaoTeste";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PrevisaoTeste for dynamic purposes.
  **/
  public static factory(data: PrevisaoTesteInterface): PrevisaoTeste{
    return new PrevisaoTeste(data);
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
      name: 'PrevisaoTeste',
      plural: 'PrevisaoTestes',
      path: 'PrevisaoTestes',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "diaNumPrevisao": {
          name: 'diaNumPrevisao',
          type: 'number'
        },
        "valorPrevisao": {
          name: 'valorPrevisao',
          type: 'number'
        },
        "precoEntrada": {
          name: 'precoEntrada',
          type: 'number'
        },
        "precoReferencia": {
          name: 'precoReferencia',
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
        "precoSaida": {
          name: 'precoSaida',
          type: 'number'
        },
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
        "diaNumSaida": {
          name: 'diaNumSaida',
          type: 'number'
        },
        "pontuacao": {
          name: 'pontuacao',
          type: 'number'
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
