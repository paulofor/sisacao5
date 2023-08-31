/* tslint:disable */
import {
  TreinoGrupoRede,
  PreRedeNeural,
  ExperimentoPreRedeTreinada
} from '../index';

declare var Object: any;
export interface PeriodoTreinoRedeInterface {
  "nome"?: string;
  "diaNumInicioTreino"?: number;
  "diaNumFinalTreino"?: number;
  "diaNumInicioValidacao"?: number;
  "diaNumFinalValidacao"?: number;
  "diaNumInicioTeste"?: number;
  "diaNumFinalTeste"?: number;
  "maximoTradeTeste"?: number;
  "minimoTradeTeste"?: number;
  "simultaneoTradeTeste"?: number;
  "diaNumInicioExecucao"?: number;
  "diaNumFinalExecucao"?: number;
  "quantidadeDiaTreino"?: number;
  "quantidadeDiaTeste"?: number;
  "id"?: number;
  treinoGrupoRedes?: TreinoGrupoRede[];
  preRedeNeurals?: PreRedeNeural[];
  experimentoPreRedeTreinadas?: ExperimentoPreRedeTreinada[];
}

export class PeriodoTreinoRede implements PeriodoTreinoRedeInterface {
  "nome": string;
  "diaNumInicioTreino": number;
  "diaNumFinalTreino": number;
  "diaNumInicioValidacao": number;
  "diaNumFinalValidacao": number;
  "diaNumInicioTeste": number;
  "diaNumFinalTeste": number;
  "maximoTradeTeste": number;
  "minimoTradeTeste": number;
  "simultaneoTradeTeste": number;
  "diaNumInicioExecucao": number;
  "diaNumFinalExecucao": number;
  "quantidadeDiaTreino": number;
  "quantidadeDiaTeste": number;
  "id": number;
  treinoGrupoRedes: TreinoGrupoRede[];
  preRedeNeurals: PreRedeNeural[];
  experimentoPreRedeTreinadas: ExperimentoPreRedeTreinada[];
  constructor(data?: PeriodoTreinoRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PeriodoTreinoRede`.
   */
  public static getModelName() {
    return "PeriodoTreinoRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PeriodoTreinoRede for dynamic purposes.
  **/
  public static factory(data: PeriodoTreinoRedeInterface): PeriodoTreinoRede{
    return new PeriodoTreinoRede(data);
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
      name: 'PeriodoTreinoRede',
      plural: 'PeriodoTreinoRedes',
      path: 'PeriodoTreinoRedes',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "diaNumInicioTreino": {
          name: 'diaNumInicioTreino',
          type: 'number'
        },
        "diaNumFinalTreino": {
          name: 'diaNumFinalTreino',
          type: 'number'
        },
        "diaNumInicioValidacao": {
          name: 'diaNumInicioValidacao',
          type: 'number'
        },
        "diaNumFinalValidacao": {
          name: 'diaNumFinalValidacao',
          type: 'number'
        },
        "diaNumInicioTeste": {
          name: 'diaNumInicioTeste',
          type: 'number'
        },
        "diaNumFinalTeste": {
          name: 'diaNumFinalTeste',
          type: 'number'
        },
        "maximoTradeTeste": {
          name: 'maximoTradeTeste',
          type: 'number'
        },
        "minimoTradeTeste": {
          name: 'minimoTradeTeste',
          type: 'number'
        },
        "simultaneoTradeTeste": {
          name: 'simultaneoTradeTeste',
          type: 'number'
        },
        "diaNumInicioExecucao": {
          name: 'diaNumInicioExecucao',
          type: 'number'
        },
        "diaNumFinalExecucao": {
          name: 'diaNumFinalExecucao',
          type: 'number'
        },
        "quantidadeDiaTreino": {
          name: 'quantidadeDiaTreino',
          type: 'number'
        },
        "quantidadeDiaTeste": {
          name: 'quantidadeDiaTeste',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        treinoGrupoRedes: {
          name: 'treinoGrupoRedes',
          type: 'TreinoGrupoRede[]',
          model: 'TreinoGrupoRede',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'periodoTreinoRedeId'
        },
        preRedeNeurals: {
          name: 'preRedeNeurals',
          type: 'PreRedeNeural[]',
          model: 'PreRedeNeural',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'periodoTreinoRedeId'
        },
        experimentoPreRedeTreinadas: {
          name: 'experimentoPreRedeTreinadas',
          type: 'ExperimentoPreRedeTreinada[]',
          model: 'ExperimentoPreRedeTreinada',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'periodoTreinoRedeId'
        },
      }
    }
  }
}
