/* tslint:disable */
import {
  PeriodoExperimento
} from '../index';

declare var Object: any;
export interface ExperimentoSimulacaoPeriodoInterface {
  "concluido"?: number;
  "id"?: number;
  "periodoExperimentoId"?: number;
  "experimentoSimulacaoId"?: number;
  periodoExperimento?: PeriodoExperimento;
}

export class ExperimentoSimulacaoPeriodo implements ExperimentoSimulacaoPeriodoInterface {
  "concluido": number;
  "id": number;
  "periodoExperimentoId": number;
  "experimentoSimulacaoId": number;
  periodoExperimento: PeriodoExperimento;
  constructor(data?: ExperimentoSimulacaoPeriodoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoSimulacaoPeriodo`.
   */
  public static getModelName() {
    return "ExperimentoSimulacaoPeriodo";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoSimulacaoPeriodo for dynamic purposes.
  **/
  public static factory(data: ExperimentoSimulacaoPeriodoInterface): ExperimentoSimulacaoPeriodo{
    return new ExperimentoSimulacaoPeriodo(data);
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
      name: 'ExperimentoSimulacaoPeriodo',
      plural: 'ExperimentoSimulacaoPeriodos',
      path: 'ExperimentoSimulacaoPeriodos',
      idName: 'id',
      properties: {
        "concluido": {
          name: 'concluido',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "periodoExperimentoId": {
          name: 'periodoExperimentoId',
          type: 'number'
        },
        "experimentoSimulacaoId": {
          name: 'experimentoSimulacaoId',
          type: 'number'
        },
      },
      relations: {
        periodoExperimento: {
          name: 'periodoExperimento',
          type: 'PeriodoExperimento',
          model: 'PeriodoExperimento',
          relationType: 'belongsTo',
                  keyFrom: 'periodoExperimentoId',
          keyTo: 'id'
        },
      }
    }
  }
}
