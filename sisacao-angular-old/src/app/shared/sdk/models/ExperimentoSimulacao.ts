/* tslint:disable */
import {
  RegraSimulacao,
  ExperimentoParametro,
  ExperimentoAcao,
  GrupoAcao,
  CombinacaoParametro,
  ValorParametro,
  ExecucaoSimulacao,
  PeriodoExperimento,
  ExperimentoSimulacaoPeriodo
} from '../index';

declare var Object: any;
export interface ExperimentoSimulacaoInterface {
  "codigo"?: string;
  "dataCriacao"?: Date;
  "dataExecucao"?: string;
  "quantidadeCombinacao"?: number;
  "posicaoExecucao"?: number;
  "permiteEdicao"?: number;
  "emExecucao"?: number;
  "emValidacao"?: number;
  "id"?: number;
  "regraSimulacaoId"?: number;
  "grupoAcaoId"?: number;
  "periodoExperimentoId"?: number;
  regraSimulacao?: RegraSimulacao;
  experimentoParametros?: ExperimentoParametro[];
  experimentoAcaos?: ExperimentoAcao[];
  grupoAcao?: GrupoAcao;
  combinacaoParametros?: CombinacaoParametro[];
  valorParametros?: ValorParametro[];
  execucaoSimulacaos?: ExecucaoSimulacao[];
  periodoExperimento?: PeriodoExperimento;
  experimentoSimulacaoPeriodos?: ExperimentoSimulacaoPeriodo[];
}

export class ExperimentoSimulacao implements ExperimentoSimulacaoInterface {
  "codigo": string;
  "dataCriacao": Date;
  "dataExecucao": string;
  "quantidadeCombinacao": number;
  "posicaoExecucao": number;
  "permiteEdicao": number;
  "emExecucao": number;
  "emValidacao": number;
  "id": number;
  "regraSimulacaoId": number;
  "grupoAcaoId": number;
  "periodoExperimentoId": number;
  regraSimulacao: RegraSimulacao;
  experimentoParametros: ExperimentoParametro[];
  experimentoAcaos: ExperimentoAcao[];
  grupoAcao: GrupoAcao;
  combinacaoParametros: CombinacaoParametro[];
  valorParametros: ValorParametro[];
  execucaoSimulacaos: ExecucaoSimulacao[];
  periodoExperimento: PeriodoExperimento;
  experimentoSimulacaoPeriodos: ExperimentoSimulacaoPeriodo[];
  constructor(data?: ExperimentoSimulacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoSimulacao`.
   */
  public static getModelName() {
    return "ExperimentoSimulacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoSimulacao for dynamic purposes.
  **/
  public static factory(data: ExperimentoSimulacaoInterface): ExperimentoSimulacao{
    return new ExperimentoSimulacao(data);
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
      name: 'ExperimentoSimulacao',
      plural: 'ExperimentoSimulacaos',
      path: 'ExperimentoSimulacaos',
      idName: 'id',
      properties: {
        "codigo": {
          name: 'codigo',
          type: 'string'
        },
        "dataCriacao": {
          name: 'dataCriacao',
          type: 'Date'
        },
        "dataExecucao": {
          name: 'dataExecucao',
          type: 'string'
        },
        "quantidadeCombinacao": {
          name: 'quantidadeCombinacao',
          type: 'number'
        },
        "posicaoExecucao": {
          name: 'posicaoExecucao',
          type: 'number'
        },
        "permiteEdicao": {
          name: 'permiteEdicao',
          type: 'number'
        },
        "emExecucao": {
          name: 'emExecucao',
          type: 'number'
        },
        "emValidacao": {
          name: 'emValidacao',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "regraSimulacaoId": {
          name: 'regraSimulacaoId',
          type: 'number'
        },
        "grupoAcaoId": {
          name: 'grupoAcaoId',
          type: 'number'
        },
        "periodoExperimentoId": {
          name: 'periodoExperimentoId',
          type: 'number'
        },
      },
      relations: {
        regraSimulacao: {
          name: 'regraSimulacao',
          type: 'RegraSimulacao',
          model: 'RegraSimulacao',
          relationType: 'belongsTo',
                  keyFrom: 'regraSimulacaoId',
          keyTo: 'id'
        },
        experimentoParametros: {
          name: 'experimentoParametros',
          type: 'ExperimentoParametro[]',
          model: 'ExperimentoParametro',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'experimentoSimulacaoId'
        },
        experimentoAcaos: {
          name: 'experimentoAcaos',
          type: 'ExperimentoAcao[]',
          model: 'ExperimentoAcao',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'experimentoSimulacaoId'
        },
        grupoAcao: {
          name: 'grupoAcao',
          type: 'GrupoAcao',
          model: 'GrupoAcao',
          relationType: 'belongsTo',
                  keyFrom: 'grupoAcaoId',
          keyTo: 'id'
        },
        combinacaoParametros: {
          name: 'combinacaoParametros',
          type: 'CombinacaoParametro[]',
          model: 'CombinacaoParametro',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'experimentoSimulacaoId'
        },
        valorParametros: {
          name: 'valorParametros',
          type: 'ValorParametro[]',
          model: 'ValorParametro',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'experimentoSimulacaoId'
        },
        execucaoSimulacaos: {
          name: 'execucaoSimulacaos',
          type: 'ExecucaoSimulacao[]',
          model: 'ExecucaoSimulacao',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'experimentoSimulacaoId'
        },
        periodoExperimento: {
          name: 'periodoExperimento',
          type: 'PeriodoExperimento',
          model: 'PeriodoExperimento',
          relationType: 'belongsTo',
                  keyFrom: 'periodoExperimentoId',
          keyTo: 'id'
        },
        experimentoSimulacaoPeriodos: {
          name: 'experimentoSimulacaoPeriodos',
          type: 'ExperimentoSimulacaoPeriodo[]',
          model: 'ExperimentoSimulacaoPeriodo',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'experimentoSimulacaoId'
        },
      }
    }
  }
}
