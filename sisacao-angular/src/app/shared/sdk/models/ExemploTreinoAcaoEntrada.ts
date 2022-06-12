/* tslint:disable */

declare var Object: any;
export interface ExemploTreinoAcaoEntradaInterface {
  "ticker"?: string;
  "campoX"?: string;
  "diaNumInicio"?: number;
  "diaNumPrevisao"?: number;
  "campoXOriginal"?: string;
  "valorReferencia"?: number;
  "qtdeDias"?: number;
  "posicaoReferencia"?: number;
}

export class ExemploTreinoAcaoEntrada implements ExemploTreinoAcaoEntradaInterface {
  "ticker": string;
  "campoX": string;
  "diaNumInicio": number;
  "diaNumPrevisao": number;
  "campoXOriginal": string;
  "valorReferencia": number;
  "qtdeDias": number;
  "posicaoReferencia": number;
  constructor(data?: ExemploTreinoAcaoEntradaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExemploTreinoAcaoEntrada`.
   */
  public static getModelName() {
    return "ExemploTreinoAcaoEntrada";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExemploTreinoAcaoEntrada for dynamic purposes.
  **/
  public static factory(data: ExemploTreinoAcaoEntradaInterface): ExemploTreinoAcaoEntrada{
    return new ExemploTreinoAcaoEntrada(data);
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
      name: 'ExemploTreinoAcaoEntrada',
      plural: 'ExemploTreinoAcaoEntradas',
      path: 'ExemploTreinoAcaoEntradas',
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
        "diaNumInicio": {
          name: 'diaNumInicio',
          type: 'number'
        },
        "diaNumPrevisao": {
          name: 'diaNumPrevisao',
          type: 'number'
        },
        "campoXOriginal": {
          name: 'campoXOriginal',
          type: 'string'
        },
        "valorReferencia": {
          name: 'valorReferencia',
          type: 'number'
        },
        "qtdeDias": {
          name: 'qtdeDias',
          type: 'number'
        },
        "posicaoReferencia": {
          name: 'posicaoReferencia',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
