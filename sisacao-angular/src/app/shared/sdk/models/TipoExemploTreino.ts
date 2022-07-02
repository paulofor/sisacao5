/* tslint:disable */

declare var Object: any;
export interface TipoExemploTreinoInterface {
  "qtdeDias"?: number;
  "posicaoReferencia"?: number;
  "id"?: number;
}

export class TipoExemploTreino implements TipoExemploTreinoInterface {
  "qtdeDias": number;
  "posicaoReferencia": number;
  "id": number;
  constructor(data?: TipoExemploTreinoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TipoExemploTreino`.
   */
  public static getModelName() {
    return "TipoExemploTreino";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TipoExemploTreino for dynamic purposes.
  **/
  public static factory(data: TipoExemploTreinoInterface): TipoExemploTreino{
    return new TipoExemploTreino(data);
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
      name: 'TipoExemploTreino',
      plural: 'TipoExemploTreinos',
      path: 'TipoExemploTreinos',
      idName: 'id',
      properties: {
        "qtdeDias": {
          name: 'qtdeDias',
          type: 'number'
        },
        "posicaoReferencia": {
          name: 'posicaoReferencia',
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
