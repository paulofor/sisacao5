/* tslint:disable */

declare var Object: any;
export interface ExemploTreinoAcaoInterface {
  "ticker"?: string;
  "campoX"?: string;
  "campoY"?: number;
  "diaNumInicio"?: number;
  "diaNumPrevisao"?: number;
}

export class ExemploTreinoAcao implements ExemploTreinoAcaoInterface {
  "ticker": string;
  "campoX": string;
  "campoY": number;
  "diaNumInicio": number;
  "diaNumPrevisao": number;
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
      },
      relations: {
      }
    }
  }
}
