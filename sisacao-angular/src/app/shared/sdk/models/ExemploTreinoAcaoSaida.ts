/* tslint:disable */

declare var Object: any;
export interface ExemploTreinoAcaoSaidaInterface {
  "ticker"?: string;
  "campoY"?: string;
  "diaNumSaida"?: number;
  "valorSaida"?: number;
  "valorEntrada"?: number;
  "diaNumPrevisao"?: number;
  "limiteSuperior"?: number;
  "limiteInferior"?: number;
  "resultado"?: number;
  "regraProjecaoId"?: number;
  "id"?: number;
}

export class ExemploTreinoAcaoSaida implements ExemploTreinoAcaoSaidaInterface {
  "ticker": string;
  "campoY": string;
  "diaNumSaida": number;
  "valorSaida": number;
  "valorEntrada": number;
  "diaNumPrevisao": number;
  "limiteSuperior": number;
  "limiteInferior": number;
  "resultado": number;
  "regraProjecaoId": number;
  "id": number;
  constructor(data?: ExemploTreinoAcaoSaidaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExemploTreinoAcaoSaida`.
   */
  public static getModelName() {
    return "ExemploTreinoAcaoSaida";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExemploTreinoAcaoSaida for dynamic purposes.
  **/
  public static factory(data: ExemploTreinoAcaoSaidaInterface): ExemploTreinoAcaoSaida{
    return new ExemploTreinoAcaoSaida(data);
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
      name: 'ExemploTreinoAcaoSaida',
      plural: 'ExemploTreinoAcaoSaidas',
      path: 'ExemploTreinoAcaoSaidas',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "campoY": {
          name: 'campoY',
          type: 'string'
        },
        "diaNumSaida": {
          name: 'diaNumSaida',
          type: 'number'
        },
        "valorSaida": {
          name: 'valorSaida',
          type: 'number'
        },
        "valorEntrada": {
          name: 'valorEntrada',
          type: 'number'
        },
        "diaNumPrevisao": {
          name: 'diaNumPrevisao',
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
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
        "regraProjecaoId": {
          name: 'regraProjecaoId',
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
