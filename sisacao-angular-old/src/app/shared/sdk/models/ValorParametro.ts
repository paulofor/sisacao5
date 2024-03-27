/* tslint:disable */
import {
  ParametroRegra
} from '../index';

declare var Object: any;
export interface ValorParametroInterface {
  "parametroRegraId"?: number;
  "valorParametro"?: number;
  "combinacaoParametroId"?: number;
  "experimentoSimulacaoId"?: number;
  parametroRegra?: ParametroRegra;
}

export class ValorParametro implements ValorParametroInterface {
  "parametroRegraId": number;
  "valorParametro": number;
  "combinacaoParametroId": number;
  "experimentoSimulacaoId": number;
  parametroRegra: ParametroRegra;
  constructor(data?: ValorParametroInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ValorParametro`.
   */
  public static getModelName() {
    return "ValorParametro";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ValorParametro for dynamic purposes.
  **/
  public static factory(data: ValorParametroInterface): ValorParametro{
    return new ValorParametro(data);
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
      name: 'ValorParametro',
      plural: 'ValorParametros',
      path: 'ValorParametros',
      idName: 'parametroRegraId',
      properties: {
        "parametroRegraId": {
          name: 'parametroRegraId',
          type: 'number'
        },
        "valorParametro": {
          name: 'valorParametro',
          type: 'number'
        },
        "combinacaoParametroId": {
          name: 'combinacaoParametroId',
          type: 'number'
        },
        "experimentoSimulacaoId": {
          name: 'experimentoSimulacaoId',
          type: 'number'
        },
      },
      relations: {
        parametroRegra: {
          name: 'parametroRegra',
          type: 'ParametroRegra',
          model: 'ParametroRegra',
          relationType: 'belongsTo',
                  keyFrom: 'parametroRegraId',
          keyTo: 'id'
        },
      }
    }
  }
}
