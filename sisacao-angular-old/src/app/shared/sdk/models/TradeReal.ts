/* tslint:disable */
import {
  ExecucaoSimulacao,
  AtivoAcao,
  InstituicaoFinanceira,
  PrevisaoRede
} from '../index';

declare var Object: any;
export interface TradeRealInterface {
  "ticker"?: string;
  "precoEntrada"?: number;
  "precoSaida"?: number;
  "dataNumEntrada"?: number;
  "dataNumSaida"?: number;
  "quantidade"?: number;
  "valorEntrada"?: number;
  "valorSaida"?: number;
  "custoEntrada"?: number;
  "custoSaida"?: number;
  "fracionario"?: number;
  "precoTarget"?: number;
  "valorTarget"?: number;
  "precoStop"?: number;
  "valorStop"?: number;
  "posicaoAtual"?: number;
  "lucroPrejuizo"?: number;
  "dataEntrada"?: Date;
  "dataSaida"?: Date;
  "valorExposicao"?: number;
  "lucroAlvo"?: number;
  "percentual"?: number;
  "dias"?: number;
  "custoTotal"?: number;
  "tipo"?: string;
  "posicaoOperacao"?: number;
  "operacaoRisco"?: number;
  "operacaoAlvo"?: number;
  "menorPreco"?: number;
  "maiorPreco"?: number;
  "menorPercentual"?: number;
  "maiorPercentual"?: number;
  "menorPreco1Mes"?: number;
  "maiorPreco1Mes"?: number;
  "menorPercentual1Mes"?: number;
  "maiorPercentual1Mes"?: number;
  "id"?: number;
  "execucaoSimulacaoId"?: number;
  "instituicaoFinanceiraId"?: number;
  "previsaoRedeId"?: number;
  execucaoSimulacao?: ExecucaoSimulacao;
  ativoAcao?: AtivoAcao;
  instituicaoFinanceira?: InstituicaoFinanceira;
  previsaoRede?: PrevisaoRede;
}

export class TradeReal implements TradeRealInterface {
  "ticker": string;
  "precoEntrada": number;
  "precoSaida": number;
  "dataNumEntrada": number;
  "dataNumSaida": number;
  "quantidade": number;
  "valorEntrada": number;
  "valorSaida": number;
  "custoEntrada": number;
  "custoSaida": number;
  "fracionario": number;
  "precoTarget": number;
  "valorTarget": number;
  "precoStop": number;
  "valorStop": number;
  "posicaoAtual": number;
  "lucroPrejuizo": number;
  "dataEntrada": Date;
  "dataSaida": Date;
  "valorExposicao": number;
  "lucroAlvo": number;
  "percentual": number;
  "dias": number;
  "custoTotal": number;
  "tipo": string;
  "posicaoOperacao": number;
  "operacaoRisco": number;
  "operacaoAlvo": number;
  "menorPreco": number;
  "maiorPreco": number;
  "menorPercentual": number;
  "maiorPercentual": number;
  "menorPreco1Mes": number;
  "maiorPreco1Mes": number;
  "menorPercentual1Mes": number;
  "maiorPercentual1Mes": number;
  "id": number;
  "execucaoSimulacaoId": number;
  "instituicaoFinanceiraId": number;
  "previsaoRedeId": number;
  execucaoSimulacao: ExecucaoSimulacao;
  ativoAcao: AtivoAcao;
  instituicaoFinanceira: InstituicaoFinanceira;
  previsaoRede: PrevisaoRede;
  constructor(data?: TradeRealInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TradeReal`.
   */
  public static getModelName() {
    return "TradeReal";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TradeReal for dynamic purposes.
  **/
  public static factory(data: TradeRealInterface): TradeReal{
    return new TradeReal(data);
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
      name: 'TradeReal',
      plural: 'TradeReals',
      path: 'TradeReals',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "precoEntrada": {
          name: 'precoEntrada',
          type: 'number'
        },
        "precoSaida": {
          name: 'precoSaida',
          type: 'number'
        },
        "dataNumEntrada": {
          name: 'dataNumEntrada',
          type: 'number'
        },
        "dataNumSaida": {
          name: 'dataNumSaida',
          type: 'number'
        },
        "quantidade": {
          name: 'quantidade',
          type: 'number'
        },
        "valorEntrada": {
          name: 'valorEntrada',
          type: 'number'
        },
        "valorSaida": {
          name: 'valorSaida',
          type: 'number'
        },
        "custoEntrada": {
          name: 'custoEntrada',
          type: 'number'
        },
        "custoSaida": {
          name: 'custoSaida',
          type: 'number'
        },
        "fracionario": {
          name: 'fracionario',
          type: 'number'
        },
        "precoTarget": {
          name: 'precoTarget',
          type: 'number'
        },
        "valorTarget": {
          name: 'valorTarget',
          type: 'number'
        },
        "precoStop": {
          name: 'precoStop',
          type: 'number'
        },
        "valorStop": {
          name: 'valorStop',
          type: 'number'
        },
        "posicaoAtual": {
          name: 'posicaoAtual',
          type: 'number'
        },
        "lucroPrejuizo": {
          name: 'lucroPrejuizo',
          type: 'number'
        },
        "dataEntrada": {
          name: 'dataEntrada',
          type: 'Date'
        },
        "dataSaida": {
          name: 'dataSaida',
          type: 'Date'
        },
        "valorExposicao": {
          name: 'valorExposicao',
          type: 'number'
        },
        "lucroAlvo": {
          name: 'lucroAlvo',
          type: 'number'
        },
        "percentual": {
          name: 'percentual',
          type: 'number'
        },
        "dias": {
          name: 'dias',
          type: 'number'
        },
        "custoTotal": {
          name: 'custoTotal',
          type: 'number'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "posicaoOperacao": {
          name: 'posicaoOperacao',
          type: 'number'
        },
        "operacaoRisco": {
          name: 'operacaoRisco',
          type: 'number'
        },
        "operacaoAlvo": {
          name: 'operacaoAlvo',
          type: 'number'
        },
        "menorPreco": {
          name: 'menorPreco',
          type: 'number'
        },
        "maiorPreco": {
          name: 'maiorPreco',
          type: 'number'
        },
        "menorPercentual": {
          name: 'menorPercentual',
          type: 'number'
        },
        "maiorPercentual": {
          name: 'maiorPercentual',
          type: 'number'
        },
        "menorPreco1Mes": {
          name: 'menorPreco1Mes',
          type: 'number'
        },
        "maiorPreco1Mes": {
          name: 'maiorPreco1Mes',
          type: 'number'
        },
        "menorPercentual1Mes": {
          name: 'menorPercentual1Mes',
          type: 'number'
        },
        "maiorPercentual1Mes": {
          name: 'maiorPercentual1Mes',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "execucaoSimulacaoId": {
          name: 'execucaoSimulacaoId',
          type: 'number'
        },
        "instituicaoFinanceiraId": {
          name: 'instituicaoFinanceiraId',
          type: 'number'
        },
        "previsaoRedeId": {
          name: 'previsaoRedeId',
          type: 'number'
        },
      },
      relations: {
        execucaoSimulacao: {
          name: 'execucaoSimulacao',
          type: 'ExecucaoSimulacao',
          model: 'ExecucaoSimulacao',
          relationType: 'belongsTo',
                  keyFrom: 'execucaoSimulacaoId',
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
        instituicaoFinanceira: {
          name: 'instituicaoFinanceira',
          type: 'InstituicaoFinanceira',
          model: 'InstituicaoFinanceira',
          relationType: 'belongsTo',
                  keyFrom: 'instituicaoFinanceiraId',
          keyTo: 'id'
        },
        previsaoRede: {
          name: 'previsaoRede',
          type: 'PrevisaoRede',
          model: 'PrevisaoRede',
          relationType: 'belongsTo',
                  keyFrom: 'previsaoRedeId',
          keyTo: 'id'
        },
      }
    }
  }
}
