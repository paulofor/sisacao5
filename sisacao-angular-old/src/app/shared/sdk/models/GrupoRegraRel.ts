/* tslint:disable */
import {
  RegraProjecao
} from '../index';

declare var Object: any;
export interface GrupoRegraRelInterface {
  "regraProjecaoId"?: number;
  "grupoRegraId"?: number;
  regraProjecao?: RegraProjecao;
}

export class GrupoRegraRel implements GrupoRegraRelInterface {
  "regraProjecaoId": number;
  "grupoRegraId": number;
  regraProjecao: RegraProjecao;
  constructor(data?: GrupoRegraRelInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `GrupoRegraRel`.
   */
  public static getModelName() {
    return "GrupoRegraRel";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of GrupoRegraRel for dynamic purposes.
  **/
  public static factory(data: GrupoRegraRelInterface): GrupoRegraRel{
    return new GrupoRegraRel(data);
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
      name: 'GrupoRegraRel',
      plural: 'GrupoRegraRels',
      path: 'GrupoRegraRels',
      idName: 'regraProjecaoId',
      properties: {
        "regraProjecaoId": {
          name: 'regraProjecaoId',
          type: 'number'
        },
        "grupoRegraId": {
          name: 'grupoRegraId',
          type: 'number'
        },
      },
      relations: {
        regraProjecao: {
          name: 'regraProjecao',
          type: 'RegraProjecao',
          model: 'RegraProjecao',
          relationType: 'belongsTo',
                  keyFrom: 'regraProjecaoId',
          keyTo: 'id'
        },
      }
    }
  }
}
