/* tslint:disable */

declare var Object: any;
export interface ExemploTreinoInterface {
  "ticker"?: string;
  "campoX"?: number;
  "campoY"?: string;
  "diaNumInicio"?: number;
  "diaNumPrevisao"?: number;
  "id"?: number;
}

export class ExemploTreino implements ExemploTreinoInterface {
  "ticker": string;
  "campoX": number;
  "campoY": string;
  "diaNumInicio": number;
  "diaNumPrevisao": number;
  "id": number;
  constructor(data?: ExemploTreinoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExemploTreino`.
   */
  public static getModelName() {
    return "ExemploTreino";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExemploTreino for dynamic purposes.
  **/
  public static factory(data: ExemploTreinoInterface): ExemploTreino{
    return new ExemploTreino(data);
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
      name: 'ExemploTreino',
      plural: 'ExemploTreinos',
      path: 'ExemploTreinos',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "campoX": {
          name: 'campoX',
          type: 'number'
        },
        "campoY": {
          name: 'campoY',
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
