/* tslint:disable */
import {
  RelGrupoAcao
} from '../index';

declare var Object: any;
export interface GrupoAcaoInterface {
  "nome"?: string;
  "descricao"?: string;
  "quantidade"?: number;
  "id"?: number;
  relGrupoAcaos?: RelGrupoAcao[];
}

export class GrupoAcao implements GrupoAcaoInterface {
  "nome": string;
  "descricao": string;
  "quantidade": number;
  "id": number;
  relGrupoAcaos: RelGrupoAcao[];
  constructor(data?: GrupoAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `GrupoAcao`.
   */
  public static getModelName() {
    return "GrupoAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of GrupoAcao for dynamic purposes.
  **/
  public static factory(data: GrupoAcaoInterface): GrupoAcao{
    return new GrupoAcao(data);
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
      name: 'GrupoAcao',
      plural: 'GrupoAcaos',
      path: 'GrupoAcaos',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "descricao": {
          name: 'descricao',
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
        relGrupoAcaos: {
          name: 'relGrupoAcaos',
          type: 'RelGrupoAcao[]',
          model: 'RelGrupoAcao',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'grupoAcaoId'
        },
      }
    }
  }
}
