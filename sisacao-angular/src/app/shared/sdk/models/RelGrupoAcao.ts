/* tslint:disable */
import {
  AtivoAcao
} from '../index';

declare var Object: any;
export interface RelGrupoAcaoInterface {
  "ticker"?: string;
  "grupoAcaoId"?: number;
  ativoAcao?: AtivoAcao;
}

export class RelGrupoAcao implements RelGrupoAcaoInterface {
  "ticker": string;
  "grupoAcaoId": number;
  ativoAcao: AtivoAcao;
  constructor(data?: RelGrupoAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RelGrupoAcao`.
   */
  public static getModelName() {
    return "RelGrupoAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RelGrupoAcao for dynamic purposes.
  **/
  public static factory(data: RelGrupoAcaoInterface): RelGrupoAcao{
    return new RelGrupoAcao(data);
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
      name: 'RelGrupoAcao',
      plural: 'RelGrupoAcaos',
      path: 'RelGrupoAcaos',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "grupoAcaoId": {
          name: 'grupoAcaoId',
          type: 'number'
        },
      },
      relations: {
        ativoAcao: {
          name: 'ativoAcao',
          type: 'AtivoAcao',
          model: 'AtivoAcao',
          relationType: 'belongsTo',
                  keyFrom: 'ticker',
          keyTo: 'ticker'
        },
      }
    }
  }
}
