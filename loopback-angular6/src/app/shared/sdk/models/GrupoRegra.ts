/* tslint:disable */
import {
  GrupoRegraRel
} from '../index';

declare var Object: any;
export interface GrupoRegraInterface {
  "targetInicial"?: number;
  "targetFinal"?: number;
  "targetPasso"?: number;
  "stopInicial"?: number;
  "stopFinal"?: number;
  "stopPasso"?: number;
  "diaLimiteInicial"?: number;
  "diaLimiteFinal"?: number;
  "diaLimitePasso"?: number;
  "nome"?: string;
  "quantidade"?: number;
  "quantidadeDia"?: number;
  "id"?: number;
  grupoRegraRels?: GrupoRegraRel[];
}

export class GrupoRegra implements GrupoRegraInterface {
  "targetInicial": number;
  "targetFinal": number;
  "targetPasso": number;
  "stopInicial": number;
  "stopFinal": number;
  "stopPasso": number;
  "diaLimiteInicial": number;
  "diaLimiteFinal": number;
  "diaLimitePasso": number;
  "nome": string;
  "quantidade": number;
  "quantidadeDia": number;
  "id": number;
  grupoRegraRels: GrupoRegraRel[];
  constructor(data?: GrupoRegraInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `GrupoRegra`.
   */
  public static getModelName() {
    return "GrupoRegra";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of GrupoRegra for dynamic purposes.
  **/
  public static factory(data: GrupoRegraInterface): GrupoRegra{
    return new GrupoRegra(data);
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
      name: 'GrupoRegra',
      plural: 'GrupoRegras',
      path: 'GrupoRegras',
      idName: 'id',
      properties: {
        "targetInicial": {
          name: 'targetInicial',
          type: 'number'
        },
        "targetFinal": {
          name: 'targetFinal',
          type: 'number'
        },
        "targetPasso": {
          name: 'targetPasso',
          type: 'number'
        },
        "stopInicial": {
          name: 'stopInicial',
          type: 'number'
        },
        "stopFinal": {
          name: 'stopFinal',
          type: 'number'
        },
        "stopPasso": {
          name: 'stopPasso',
          type: 'number'
        },
        "diaLimiteInicial": {
          name: 'diaLimiteInicial',
          type: 'number'
        },
        "diaLimiteFinal": {
          name: 'diaLimiteFinal',
          type: 'number'
        },
        "diaLimitePasso": {
          name: 'diaLimitePasso',
          type: 'number'
        },
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "quantidade": {
          name: 'quantidade',
          type: 'number'
        },
        "quantidadeDia": {
          name: 'quantidadeDia',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        grupoRegraRels: {
          name: 'grupoRegraRels',
          type: 'GrupoRegraRel[]',
          model: 'GrupoRegraRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'grupoRegraId'
        },
      }
    }
  }
}
