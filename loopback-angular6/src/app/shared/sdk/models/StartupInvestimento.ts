/* tslint:disable */
import {
  StartupEmpresa,
  StartupFundo
} from '../index';

declare var Object: any;
export interface StartupInvestimentoInterface {
  "valor"?: number;
  "data"?: string;
  "valorReal"?: number;
  "moeda"?: string;
  "tipo"?: string;
  "id"?: number;
  "startupEmpresaId"?: number;
  "startupFundoId"?: number;
  startupEmpresa?: StartupEmpresa;
  startupFundo?: StartupFundo;
}

export class StartupInvestimento implements StartupInvestimentoInterface {
  "valor": number;
  "data": string;
  "valorReal": number;
  "moeda": string;
  "tipo": string;
  "id": number;
  "startupEmpresaId": number;
  "startupFundoId": number;
  startupEmpresa: StartupEmpresa;
  startupFundo: StartupFundo;
  constructor(data?: StartupInvestimentoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `StartupInvestimento`.
   */
  public static getModelName() {
    return "StartupInvestimento";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of StartupInvestimento for dynamic purposes.
  **/
  public static factory(data: StartupInvestimentoInterface): StartupInvestimento{
    return new StartupInvestimento(data);
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
      name: 'StartupInvestimento',
      plural: 'StartupInvestimentos',
      path: 'StartupInvestimentos',
      idName: 'id',
      properties: {
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "data": {
          name: 'data',
          type: 'string'
        },
        "valorReal": {
          name: 'valorReal',
          type: 'number'
        },
        "moeda": {
          name: 'moeda',
          type: 'string'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "startupEmpresaId": {
          name: 'startupEmpresaId',
          type: 'number'
        },
        "startupFundoId": {
          name: 'startupFundoId',
          type: 'number'
        },
      },
      relations: {
        startupEmpresa: {
          name: 'startupEmpresa',
          type: 'StartupEmpresa',
          model: 'StartupEmpresa',
          relationType: 'belongsTo',
                  keyFrom: 'startupEmpresaId',
          keyTo: 'id'
        },
        startupFundo: {
          name: 'startupFundo',
          type: 'StartupFundo',
          model: 'StartupFundo',
          relationType: 'belongsTo',
                  keyFrom: 'startupFundoId',
          keyTo: 'id'
        },
      }
    }
  }
}
