/* tslint:disable */
import {
  RedeNeural,
  GrupoRede
} from '../index';

declare var Object: any;
export interface GrupoRedeRelInterface {
  "redeNeuralId"?: number;
  "grupoRedeId"?: number;
  redeNeural?: RedeNeural;
  grupoRede?: GrupoRede;
}

export class GrupoRedeRel implements GrupoRedeRelInterface {
  "redeNeuralId": number;
  "grupoRedeId": number;
  redeNeural: RedeNeural;
  grupoRede: GrupoRede;
  constructor(data?: GrupoRedeRelInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `GrupoRedeRel`.
   */
  public static getModelName() {
    return "GrupoRedeRel";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of GrupoRedeRel for dynamic purposes.
  **/
  public static factory(data: GrupoRedeRelInterface): GrupoRedeRel{
    return new GrupoRedeRel(data);
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
      name: 'GrupoRedeRel',
      plural: 'GrupoRedeRels',
      path: 'GrupoRedeRels',
      idName: 'redeNeuralId',
      properties: {
        "redeNeuralId": {
          name: 'redeNeuralId',
          type: 'number'
        },
        "grupoRedeId": {
          name: 'grupoRedeId',
          type: 'number'
        },
      },
      relations: {
        redeNeural: {
          name: 'redeNeural',
          type: 'RedeNeural',
          model: 'RedeNeural',
          relationType: 'belongsTo',
                  keyFrom: 'redeNeuralId',
          keyTo: 'id'
        },
        grupoRede: {
          name: 'grupoRede',
          type: 'GrupoRede',
          model: 'GrupoRede',
          relationType: 'belongsTo',
                  keyFrom: 'grupoRedeId',
          keyTo: 'id'
        },
      }
    }
  }
}
