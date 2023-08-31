/* tslint:disable */
import {
  GrupoAcao
} from '../index';

declare var Object: any;
export interface RegraProjecaoReversaoInterface {
  "targetStop"?: number;
  "ativa"?: number;
  "id"?: number;
  "grupoAcaoId"?: number;
  grupoAcao?: GrupoAcao;
}

export class RegraProjecaoReversao implements RegraProjecaoReversaoInterface {
  "targetStop": number;
  "ativa": number;
  "id": number;
  "grupoAcaoId": number;
  grupoAcao: GrupoAcao;
  constructor(data?: RegraProjecaoReversaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RegraProjecaoReversao`.
   */
  public static getModelName() {
    return "RegraProjecaoReversao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RegraProjecaoReversao for dynamic purposes.
  **/
  public static factory(data: RegraProjecaoReversaoInterface): RegraProjecaoReversao{
    return new RegraProjecaoReversao(data);
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
      name: 'RegraProjecaoReversao',
      plural: 'RegraProjecaoReversaos',
      path: 'RegraProjecaoReversaos',
      idName: 'id',
      properties: {
        "targetStop": {
          name: 'targetStop',
          type: 'number'
        },
        "ativa": {
          name: 'ativa',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "grupoAcaoId": {
          name: 'grupoAcaoId',
          type: 'number'
        },
      },
      relations: {
        grupoAcao: {
          name: 'grupoAcao',
          type: 'GrupoAcao',
          model: 'GrupoAcao',
          relationType: 'belongsTo',
                  keyFrom: 'grupoAcaoId',
          keyTo: 'id'
        },
      }
    }
  }
}
