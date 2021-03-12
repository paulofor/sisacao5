/* tslint:disable */
import {
  RegraSimulacao,
  ValorParametro,
  ExecucaoSimulacao
} from '../index';

declare var Object: any;
export interface CombinacaoParametroInterface {
  "posicaoCombinacao"?: number;
  "dataExecucao"?: string;
  "mediaLucro"?: number;
  "mediaPrejuizo"?: number;
  "descricao"?: string;
  "id"?: number;
  "regraSimulacaoId"?: number;
  "experimentoSimulacaoId"?: number;
  regraSimulacao?: RegraSimulacao;
  valorParametros?: ValorParametro[];
  execucaoSimulacaos?: ExecucaoSimulacao[];
}

export class CombinacaoParametro implements CombinacaoParametroInterface {
  "posicaoCombinacao": number;
  "dataExecucao": string;
  "mediaLucro": number;
  "mediaPrejuizo": number;
  "descricao": string;
  "id": number;
  "regraSimulacaoId": number;
  "experimentoSimulacaoId": number;
  regraSimulacao: RegraSimulacao;
  valorParametros: ValorParametro[];
  execucaoSimulacaos: ExecucaoSimulacao[];
  constructor(data?: CombinacaoParametroInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CombinacaoParametro`.
   */
  public static getModelName() {
    return "CombinacaoParametro";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CombinacaoParametro for dynamic purposes.
  **/
  public static factory(data: CombinacaoParametroInterface): CombinacaoParametro{
    return new CombinacaoParametro(data);
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
      name: 'CombinacaoParametro',
      plural: 'CombinacaoParametros',
      path: 'CombinacaoParametros',
      idName: 'id',
      properties: {
        "posicaoCombinacao": {
          name: 'posicaoCombinacao',
          type: 'number'
        },
        "dataExecucao": {
          name: 'dataExecucao',
          type: 'string'
        },
        "mediaLucro": {
          name: 'mediaLucro',
          type: 'number'
        },
        "mediaPrejuizo": {
          name: 'mediaPrejuizo',
          type: 'number'
        },
        "descricao": {
          name: 'descricao',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "regraSimulacaoId": {
          name: 'regraSimulacaoId',
          type: 'number'
        },
        "experimentoSimulacaoId": {
          name: 'experimentoSimulacaoId',
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
        valorParametros: {
          name: 'valorParametros',
          type: 'ValorParametro[]',
          model: 'ValorParametro',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'combinacaoParametroId'
        },
        execucaoSimulacaos: {
          name: 'execucaoSimulacaos',
          type: 'ExecucaoSimulacao[]',
          model: 'ExecucaoSimulacao',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'combinacaoParametroId'
        },
      }
    }
  }
}
