/* tslint:disable */
import {
  GrupoRedeRel
} from '../index';

declare var Object: any;
export interface GrupoRedeInterface {
  "nome"?: string;
  "quantidade"?: number;
  "id"?: number;
  grupoRedeRels?: GrupoRedeRel[];
}

export class GrupoRede implements GrupoRedeInterface {
  "nome": string;
  "quantidade": number;
  "id": number;
  grupoRedeRels: GrupoRedeRel[];
  constructor(data?: GrupoRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `GrupoRede`.
   */
  public static getModelName() {
    return "GrupoRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of GrupoRede for dynamic purposes.
  **/
  public static factory(data: GrupoRedeInterface): GrupoRede{
    return new GrupoRede(data);
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
      name: 'GrupoRede',
      plural: 'GrupoRedes',
      path: 'GrupoRedes',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "quantidade": {
          name: 'quantidade',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        grupoRedeRels: {
          name: 'grupoRedeRels',
          type: 'GrupoRedeRel[]',
          model: 'GrupoRedeRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'grupoRedeId'
        },
      }
    }
  }
}
