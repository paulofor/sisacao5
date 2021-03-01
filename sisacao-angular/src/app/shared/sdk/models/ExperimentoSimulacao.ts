/* tslint:disable */
import {
  RegraSimulacao,
  ExperimentoParametro,
  ExperimentoAcao,
  GrupoAcao,
  CombinacaoParametro
} from '../index';

declare var Object: any;
export interface ExperimentoSimulacaoInterface {
  "codigo"?: string;
  "dataInicial"?: string;
  "dataFinal"?: string;
  "dataCriacao"?: string;
  "dataExecucao"?: string;
  "quantidadeCombinacao"?: number;
  "posicaoExecucao"?: number;
  "id"?: number;
  "regraSimulacaoId"?: number;
  "grupoAcaoId"?: number;
  regraSimulacao?: RegraSimulacao;
  experimentoParametros?: ExperimentoParametro[];
  experimentoAcaos?: ExperimentoAcao[];
  grupoAcao?: GrupoAcao;
  combinacaoParametros?: CombinacaoParametro[];
}

export class ExperimentoSimulacao implements ExperimentoSimulacaoInterface {
  "codigo": string;
  "dataInicial": string;
  "dataFinal": string;
  "dataCriacao": string;
  "dataExecucao": string;
  "quantidadeCombinacao": number;
  "posicaoExecucao": number;
  "id": number;
  "regraSimulacaoId": number;
  "grupoAcaoId": number;
  regraSimulacao: RegraSimulacao;
  experimentoParametros: ExperimentoParametro[];
  experimentoAcaos: ExperimentoAcao[];
  grupoAcao: GrupoAcao;
  combinacaoParametros: CombinacaoParametro[];
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
        "dataInicial": {
          name: 'dataInicial',
          type: 'string'
        },
        "dataFinal": {
          name: 'dataFinal',
          type: 'string'
        },
        "dataCriacao": {
          name: 'dataCriacao',
          type: 'string'
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
      }
    }
  }
}
