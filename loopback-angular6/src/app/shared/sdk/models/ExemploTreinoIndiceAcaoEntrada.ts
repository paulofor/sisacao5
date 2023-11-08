/* tslint:disable */

declare var Object: any;
export interface ExemploTreinoIndiceAcaoEntradaInterface {
  "ticker"?: string;
  "campoX"?: string;
  "diaNumPrevisao"?: number;
  "campoXOriginal"?: string;
  "valorReferencia"?: number;
  "diaNumInicio"?: number;
  "tipoExemploTreinoId"?: number;
}

export class ExemploTreinoIndiceAcaoEntrada implements ExemploTreinoIndiceAcaoEntradaInterface {
  "ticker": string;
  "campoX": string;
  "diaNumPrevisao": number;
  "campoXOriginal": string;
  "valorReferencia": number;
  "diaNumInicio": number;
  "tipoExemploTreinoId": number;
  constructor(data?: ExemploTreinoIndiceAcaoEntradaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExemploTreinoIndiceAcaoEntrada`.
   */
  public static getModelName() {
    return "ExemploTreinoIndiceAcaoEntrada";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExemploTreinoIndiceAcaoEntrada for dynamic purposes.
  **/
  public static factory(data: ExemploTreinoIndiceAcaoEntradaInterface): ExemploTreinoIndiceAcaoEntrada{
    return new ExemploTreinoIndiceAcaoEntrada(data);
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
      name: 'ExemploTreinoIndiceAcaoEntrada',
      plural: 'ExemploTreinoIndiceAcaoEntradas',
      path: 'ExemploTreinoIndiceAcaoEntradas',
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
        "diaNumInicio": {
          name: 'diaNumInicio',
          type: 'number'
        },
        "tipoExemploTreinoId": {
          name: 'tipoExemploTreinoId',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
