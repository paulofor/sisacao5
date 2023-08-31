/* tslint:disable */
import {
  Trade,
  CombinacaoParametro,
  RegraSimulacao,
  AtivoAcao,
  PeriodoExperimento,
  ExecucaoSimulacao
} from '../index';

declare var Object: any;
export interface ExecucaoSimulacaoValidacaoInterface {
  "ticker"?: string;
  "quantidadeLucro"?: number;
  "quantidadePrejuizo"?: number;
  "target"?: number;
  "stop"?: number;
  "tipo"?: string;
  "id"?: number;
  "combinacaoParametroId"?: number;
  "regraSimulacaoId"?: number;
  "periodoExperimentoId"?: number;
  "execucaoSimulacaoId"?: number;
  trades?: Trade[];
  combinacaoParametro?: CombinacaoParametro;
  regraSimulacao?: RegraSimulacao;
  ativoAcao?: AtivoAcao;
  periodoExperimento?: PeriodoExperimento;
  execucaoSimulacao?: ExecucaoSimulacao;
}

export class ExecucaoSimulacaoValidacao implements ExecucaoSimulacaoValidacaoInterface {
  "ticker": string;
  "quantidadeLucro": number;
  "quantidadePrejuizo": number;
  "target": number;
  "stop": number;
  "tipo": string;
  "id": number;
  "combinacaoParametroId": number;
  "regraSimulacaoId": number;
  "periodoExperimentoId": number;
  "execucaoSimulacaoId": number;
  trades: Trade[];
  combinacaoParametro: CombinacaoParametro;
  regraSimulacao: RegraSimulacao;
  ativoAcao: AtivoAcao;
  periodoExperimento: PeriodoExperimento;
  execucaoSimulacao: ExecucaoSimulacao;
  constructor(data?: ExecucaoSimulacaoValidacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExecucaoSimulacaoValidacao`.
   */
  public static getModelName() {
    return "ExecucaoSimulacaoValidacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExecucaoSimulacaoValidacao for dynamic purposes.
  **/
  public static factory(data: ExecucaoSimulacaoValidacaoInterface): ExecucaoSimulacaoValidacao{
    return new ExecucaoSimulacaoValidacao(data);
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
      name: 'ExecucaoSimulacaoValidacao',
      plural: 'ExecucaoSimulacaoValidacaos',
      path: 'ExecucaoSimulacaoValidacaos',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "quantidadeLucro": {
          name: 'quantidadeLucro',
          type: 'number'
        },
        "quantidadePrejuizo": {
          name: 'quantidadePrejuizo',
          type: 'number'
        },
        "target": {
          name: 'target',
          type: 'number'
        },
        "stop": {
          name: 'stop',
          type: 'number'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "combinacaoParametroId": {
          name: 'combinacaoParametroId',
          type: 'number'
        },
        "regraSimulacaoId": {
          name: 'regraSimulacaoId',
          type: 'number'
        },
        "periodoExperimentoId": {
          name: 'periodoExperimentoId',
          type: 'number'
        },
        "execucaoSimulacaoId": {
          name: 'execucaoSimulacaoId',
          type: 'number'
        },
      },
      relations: {
        trades: {
          name: 'trades',
          type: 'Trade[]',
          model: 'Trade',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'execucaoSimulacaoValidacaoId'
        },
        combinacaoParametro: {
          name: 'combinacaoParametro',
          type: 'CombinacaoParametro',
          model: 'CombinacaoParametro',
          relationType: 'belongsTo',
                  keyFrom: 'combinacaoParametroId',
          keyTo: 'id'
        },
        regraSimulacao: {
          name: 'regraSimulacao',
          type: 'RegraSimulacao',
          model: 'RegraSimulacao',
          relationType: 'belongsTo',
                  keyFrom: 'regraSimulacaoId',
          keyTo: 'id'
        },
        ativoAcao: {
          name: 'ativoAcao',
          type: 'AtivoAcao',
          model: 'AtivoAcao',
          relationType: 'belongsTo',
                  keyFrom: 'ticker',
          keyTo: 'ticker'
        },
        periodoExperimento: {
          name: 'periodoExperimento',
          type: 'PeriodoExperimento',
          model: 'PeriodoExperimento',
          relationType: 'belongsTo',
                  keyFrom: 'periodoExperimentoId',
          keyTo: 'id'
        },
        execucaoSimulacao: {
          name: 'execucaoSimulacao',
          type: 'ExecucaoSimulacao',
          model: 'ExecucaoSimulacao',
          relationType: 'belongsTo',
                  keyFrom: 'execucaoSimulacaoId',
          keyTo: 'id'
        },
      }
    }
  }
}
