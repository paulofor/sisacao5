/* tslint:disable */
import {
  StartupInvestimento
} from '../index';

declare var Object: any;
export interface StartupEmpresaInterface {
  "nome"?: string;
  "url"?: string;
  "descricao"?: string;
  "id"?: number;
  startupInvestimentos?: StartupInvestimento[];
}

export class StartupEmpresa implements StartupEmpresaInterface {
  "nome": string;
  "url": string;
  "descricao": string;
  "id": number;
  startupInvestimentos: StartupInvestimento[];
  constructor(data?: StartupEmpresaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `StartupEmpresa`.
   */
  public static getModelName() {
    return "StartupEmpresa";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of StartupEmpresa for dynamic purposes.
  **/
  public static factory(data: StartupEmpresaInterface): StartupEmpresa{
    return new StartupEmpresa(data);
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
      name: 'StartupEmpresa',
      plural: 'StartupEmpresas',
      path: 'StartupEmpresas',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "url": {
          name: 'url',
          type: 'string'
        },
        "descricao": {
          name: 'descricao',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        startupInvestimentos: {
          name: 'startupInvestimentos',
          type: 'StartupInvestimento[]',
          model: 'StartupInvestimento',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'startupEmpresaId'
        },
      }
    }
  }
}
