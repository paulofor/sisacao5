/* tslint:disable */
import {
  ParametroRegra
} from '../index';

declare var Object: any;
export interface ExperimentoParametroInterface {
  "experimentoSimulacaoId"?: number;
  "parametroRegraId"?: number;
  "inicial"?: number;
  "final"?: number;
  "passo"?: number;
  parametroRegra?: ParametroRegra;
}

export class ExperimentoParametro implements ExperimentoParametroInterface {
  "experimentoSimulacaoId": number;
  "parametroRegraId": number;
  "inicial": number;
  "final": number;
  "passo": number;
  parametroRegra: ParametroRegra;
  constructor(data?: ExperimentoParametroInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoParametro`.
   */
  public static getModelName() {
    return "ExperimentoParametro";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoParametro for dynamic purposes.
  **/
  public static factory(data: ExperimentoParametroInterface): ExperimentoParametro{
    return new ExperimentoParametro(data);
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
      name: 'ExperimentoParametro',
      plural: 'ExperimentoParametros',
      path: 'ExperimentoParametros',
      idName: 'experimentoSimulacaoId',
      properties: {
        "experimentoSimulacaoId": {
          name: 'experimentoSimulacaoId',
          type: 'number'
        },
        "parametroRegraId": {
          name: 'parametroRegraId',
          type: 'number'
        },
        "inicial": {
          name: 'inicial',
          type: 'number'
        },
        "final": {
          name: 'final',
          type: 'number'
        },
        "passo": {
          name: 'passo',
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
