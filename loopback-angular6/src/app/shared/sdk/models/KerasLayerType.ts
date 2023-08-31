/* tslint:disable */
import {
  KerasLayer
} from '../index';

declare var Object: any;
export interface KerasLayerTypeInterface {
  "nome"?: string;
  "id"?: number;
  kerasLayers?: KerasLayer[];
}

export class KerasLayerType implements KerasLayerTypeInterface {
  "nome": string;
  "id": number;
  kerasLayers: KerasLayer[];
  constructor(data?: KerasLayerTypeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `KerasLayerType`.
   */
  public static getModelName() {
    return "KerasLayerType";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of KerasLayerType for dynamic purposes.
  **/
  public static factory(data: KerasLayerTypeInterface): KerasLayerType{
    return new KerasLayerType(data);
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
      name: 'KerasLayerType',
      plural: 'KerasLayerTypes',
      path: 'KerasLayerTypes',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        kerasLayers: {
          name: 'kerasLayers',
          type: 'KerasLayer[]',
          model: 'KerasLayer',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'kerasLayerTypeId'
        },
      }
    }
  }
}
