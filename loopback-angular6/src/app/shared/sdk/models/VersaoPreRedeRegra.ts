/* tslint:disable */
import {
  RegraProjecao
} from '../index';

declare var Object: any;
export interface VersaoPreRedeRegraInterface {
  "regraProjecaoId"?: number;
  "versaoPreRedeId"?: number;
  regraProjecao?: RegraProjecao;
}

export class VersaoPreRedeRegra implements VersaoPreRedeRegraInterface {
  "regraProjecaoId": number;
  "versaoPreRedeId": number;
  regraProjecao: RegraProjecao;
  constructor(data?: VersaoPreRedeRegraInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `VersaoPreRedeRegra`.
   */
  public static getModelName() {
    return "VersaoPreRedeRegra";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of VersaoPreRedeRegra for dynamic purposes.
  **/
  public static factory(data: VersaoPreRedeRegraInterface): VersaoPreRedeRegra{
    return new VersaoPreRedeRegra(data);
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
      name: 'VersaoPreRedeRegra',
      plural: 'VersaoPreRedeRegras',
      path: 'VersaoPreRedeRegras',
      idName: 'regraProjecaoId',
      properties: {
        "regraProjecaoId": {
          name: 'regraProjecaoId',
          type: 'number'
        },
        "versaoPreRedeId": {
          name: 'versaoPreRedeId',
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
