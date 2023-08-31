/* tslint:disable */
import {
  KerasLayerType
} from '../index';

declare var Object: any;
export interface KerasLayerInterface {
  "nome"?: string;
  "tipoObjeto"?: string;
  "id"?: number;
  "kerasLayerTypeId"?: number;
  kerasLayerType?: KerasLayerType;
}

export class KerasLayer implements KerasLayerInterface {
  "nome": string;
  "tipoObjeto": string;
  "id": number;
  "kerasLayerTypeId": number;
  kerasLayerType: KerasLayerType;
  constructor(data?: KerasLayerInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `KerasLayer`.
   */
  public static getModelName() {
    return "KerasLayer";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of KerasLayer for dynamic purposes.
  **/
  public static factory(data: KerasLayerInterface): KerasLayer{
    return new KerasLayer(data);
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
      name: 'KerasLayer',
      plural: 'KerasLayers',
      path: 'KerasLayers',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "tipoObjeto": {
          name: 'tipoObjeto',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "kerasLayerTypeId": {
          name: 'kerasLayerTypeId',
          type: 'number'
        },
      },
      relations: {
        kerasLayerType: {
          name: 'kerasLayerType',
          type: 'KerasLayerType',
          model: 'KerasLayerType',
          relationType: 'belongsTo',
                  keyFrom: 'kerasLayerTypeId',
          keyTo: 'id'
        },
      }
    }
  }
}
