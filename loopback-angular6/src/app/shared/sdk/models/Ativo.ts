/* tslint:disable */

declare var Object: any;
export interface AtivoInterface {
  "nome"?: string;
  "ticker"?: string;
  "id"?: number;
}

export class Ativo implements AtivoInterface {
  "nome": string;
  "ticker": string;
  "id": number;
  constructor(data?: AtivoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `Ativo`.
   */
  public static getModelName() {
    return "Ativo";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of Ativo for dynamic purposes.
  **/
  public static factory(data: AtivoInterface): Ativo{
    return new Ativo(data);
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
      name: 'Ativo',
      plural: 'Ativos',
      path: 'Ativos',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "ticker": {
          name: 'ticker',
          type: 'string'
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
