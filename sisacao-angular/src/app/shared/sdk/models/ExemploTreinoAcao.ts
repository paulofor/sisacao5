/* tslint:disable */

declare var Object: any;
export interface ExemploTreinoAcaoInterface {
  "ticker"?: string;
  "campoX"?: string;
  "campoY"?: number;
  "diaNumInicio"?: number;
  "diaNumPrevisao"?: number;
  "regraProjecaoId"?: number;
  "valorEntrada"?: number;
  "valorReferencia"?: number;
  "valorSaida"?: number;
  "limiteSuperior"?: number;
  "limiteInferior"?: number;
  "diaNumSaida"?: number;
  "resultado"?: number;
}

export class ExemploTreinoAcao implements ExemploTreinoAcaoInterface {
  "ticker": string;
  "campoX": string;
  "campoY": number;
  "diaNumInicio": number;
  "diaNumPrevisao": number;
  "regraProjecaoId": number;
  "valorEntrada": number;
  "valorReferencia": number;
  "valorSaida": number;
  "limiteSuperior": number;
  "limiteInferior": number;
  "diaNumSaida": number;
  "resultado": number;
  constructor(data?: ExemploTreinoAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExemploTreinoAcao`.
   */
  public static getModelName() {
    return "ExemploTreinoAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExemploTreinoAcao for dynamic purposes.
  **/
  public static factory(data: ExemploTreinoAcaoInterface): ExemploTreinoAcao{
    return new ExemploTreinoAcao(data);
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
      name: 'ExemploTreinoAcao',
      plural: 'ExemploTreinoAcaos',
      path: 'ExemploTreinoAcaos',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "campoX": {
          name: 'campoX',
          type: 'string'
        },
        "campoY": {
          name: 'campoY',
          type: 'number'
        },
        "diaNumInicio": {
          name: 'diaNumInicio',
          type: 'number'
        },
        "diaNumPrevisao": {
          name: 'diaNumPrevisao',
          type: 'number'
        },
        "regraProjecaoId": {
          name: 'regraProjecaoId',
          type: 'number'
        },
        "valorEntrada": {
          name: 'valorEntrada',
          type: 'number'
        },
        "valorReferencia": {
          name: 'valorReferencia',
          type: 'number'
        },
        "valorSaida": {
          name: 'valorSaida',
          type: 'number'
        },
        "limiteSuperior": {
          name: 'limiteSuperior',
          type: 'number'
        },
        "limiteInferior": {
          name: 'limiteInferior',
          type: 'number'
        },
        "diaNumSaida": {
          name: 'diaNumSaida',
          type: 'number'
        },
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
