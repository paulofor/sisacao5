/* tslint:disable */
import {
  StartupInvestimento
} from '../index';

declare var Object: any;
export interface StartupFundoInterface {
  "nome"?: string;
  "tipo"?: string;
  "url"?: string;
  "id"?: number;
  startupInvestimentos?: StartupInvestimento[];
}

export class StartupFundo implements StartupFundoInterface {
  "nome": string;
  "tipo": string;
  "url": string;
  "id": number;
  startupInvestimentos: StartupInvestimento[];
  constructor(data?: StartupFundoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `StartupFundo`.
   */
  public static getModelName() {
    return "StartupFundo";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of StartupFundo for dynamic purposes.
  **/
  public static factory(data: StartupFundoInterface): StartupFundo{
    return new StartupFundo(data);
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
      name: 'StartupFundo',
      plural: 'StartupFundos',
      path: 'StartupFundos',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "url": {
          name: 'url',
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
          keyTo: 'startupFundoId'
        },
      }
    }
  }
}
