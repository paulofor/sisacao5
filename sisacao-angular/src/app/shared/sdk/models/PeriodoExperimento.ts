/* tslint:disable */
import {
  ExperimentoSimulacaoPeriodo
} from '../index';

declare var Object: any;
export interface PeriodoExperimentoInterface {
  "dataStrInicial"?: string;
  "dataStrFinal"?: string;
  "quantidadeMes"?: number;
  "titulo"?: string;
  "permiteEditar"?: number;
  "dataNumInicial"?: number;
  "dataNumFinal"?: number;
  "dataNumInicioColeta"?: number;
  "id"?: number;
  experimentoSimulacaoPeriodos?: ExperimentoSimulacaoPeriodo[];
}

export class PeriodoExperimento implements PeriodoExperimentoInterface {
  "dataStrInicial": string;
  "dataStrFinal": string;
  "quantidadeMes": number;
  "titulo": string;
  "permiteEditar": number;
  "dataNumInicial": number;
  "dataNumFinal": number;
  "dataNumInicioColeta": number;
  "id": number;
  experimentoSimulacaoPeriodos: ExperimentoSimulacaoPeriodo[];
  constructor(data?: PeriodoExperimentoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PeriodoExperimento`.
   */
  public static getModelName() {
    return "PeriodoExperimento";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PeriodoExperimento for dynamic purposes.
  **/
  public static factory(data: PeriodoExperimentoInterface): PeriodoExperimento{
    return new PeriodoExperimento(data);
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
      name: 'PeriodoExperimento',
      plural: 'PeriodoExperimentos',
      path: 'PeriodoExperimentos',
      idName: 'id',
      properties: {
        "dataStrInicial": {
          name: 'dataStrInicial',
          type: 'string'
        },
        "dataStrFinal": {
          name: 'dataStrFinal',
          type: 'string'
        },
        "quantidadeMes": {
          name: 'quantidadeMes',
          type: 'number'
        },
        "titulo": {
          name: 'titulo',
          type: 'string'
        },
        "permiteEditar": {
          name: 'permiteEditar',
          type: 'number'
        },
        "dataNumInicial": {
          name: 'dataNumInicial',
          type: 'number'
        },
        "dataNumFinal": {
          name: 'dataNumFinal',
          type: 'number'
        },
        "dataNumInicioColeta": {
          name: 'dataNumInicioColeta',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        experimentoSimulacaoPeriodos: {
          name: 'experimentoSimulacaoPeriodos',
          type: 'ExperimentoSimulacaoPeriodo[]',
          model: 'ExperimentoSimulacaoPeriodo',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'periodoExperimentoId'
        },
      }
    }
  }
}
