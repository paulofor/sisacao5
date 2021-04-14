/* tslint:disable */
import {
  CombinacaoParametro,
  RegraSimulacao,
  AtivoAcao,
  Trade,
  ValorMonitoria,
  TradeReal,
  PeriodoExperimento,
  OrdemCompra
} from '../index';

declare var Object: any;
export interface ExecucaoSimulacaoInterface {
  "ticker"?: string;
  "quantidadeLucro"?: number;
  "quantidadePrejuizo"?: number;
  "target"?: number;
  "stop"?: number;
  "resultado"?: number;
  "monitorar"?: number;
  "precoEntrada"?: number;
  "dataNumEntrada"?: number;
  "mediaDiaTrade"?: number;
  "maximoDiaTrade"?: number;
  "favorito"?: number;
  "id"?: number;
  "combinacaoParametroId"?: number;
  "regraSimulacaoId"?: number;
  "experimentoSimulacaoId"?: number;
  "periodoExperimentoId"?: number;
  combinacaoParametro?: CombinacaoParametro;
  regraSimulacao?: RegraSimulacao;
  ativoAcao?: AtivoAcao;
  trades?: Trade[];
  valorMonitorias?: ValorMonitoria[];
  tradeReals?: TradeReal[];
  periodoExperimento?: PeriodoExperimento;
  ordemCompras?: OrdemCompra[];
}

export class ExecucaoSimulacao implements ExecucaoSimulacaoInterface {
  "ticker": string;
  "quantidadeLucro": number;
  "quantidadePrejuizo": number;
  "target": number;
  "stop": number;
  "resultado": number;
  "monitorar": number;
  "precoEntrada": number;
  "dataNumEntrada": number;
  "mediaDiaTrade": number;
  "maximoDiaTrade": number;
  "favorito": number;
  "id": number;
  "combinacaoParametroId": number;
  "regraSimulacaoId": number;
  "experimentoSimulacaoId": number;
  "periodoExperimentoId": number;
  combinacaoParametro: CombinacaoParametro;
  regraSimulacao: RegraSimulacao;
  ativoAcao: AtivoAcao;
  trades: Trade[];
  valorMonitorias: ValorMonitoria[];
  tradeReals: TradeReal[];
  periodoExperimento: PeriodoExperimento;
  ordemCompras: OrdemCompra[];
  constructor(data?: ExecucaoSimulacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExecucaoSimulacao`.
   */
  public static getModelName() {
    return "ExecucaoSimulacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExecucaoSimulacao for dynamic purposes.
  **/
  public static factory(data: ExecucaoSimulacaoInterface): ExecucaoSimulacao{
    return new ExecucaoSimulacao(data);
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
      name: 'ExecucaoSimulacao',
      plural: 'ExecucaoSimulacaos',
      path: 'ExecucaoSimulacaos',
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
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
        "monitorar": {
          name: 'monitorar',
          type: 'number'
        },
        "precoEntrada": {
          name: 'precoEntrada',
          type: 'number'
        },
        "dataNumEntrada": {
          name: 'dataNumEntrada',
          type: 'number'
        },
        "mediaDiaTrade": {
          name: 'mediaDiaTrade',
          type: 'number'
        },
        "maximoDiaTrade": {
          name: 'maximoDiaTrade',
          type: 'number'
        },
        "favorito": {
          name: 'favorito',
          type: 'number'
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
        "experimentoSimulacaoId": {
          name: 'experimentoSimulacaoId',
          type: 'number'
        },
        "periodoExperimentoId": {
          name: 'periodoExperimentoId',
          type: 'number'
        },
      },
      relations: {
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
        trades: {
          name: 'trades',
          type: 'Trade[]',
          model: 'Trade',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'execucaoSimulacaoId'
        },
        valorMonitorias: {
          name: 'valorMonitorias',
          type: 'ValorMonitoria[]',
          model: 'ValorMonitoria',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'execucaoSimulacaoId'
        },
        tradeReals: {
          name: 'tradeReals',
          type: 'TradeReal[]',
          model: 'TradeReal',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'execucaoSimulacaoId'
        },
        periodoExperimento: {
          name: 'periodoExperimento',
          type: 'PeriodoExperimento',
          model: 'PeriodoExperimento',
          relationType: 'belongsTo',
                  keyFrom: 'periodoExperimentoId',
          keyTo: 'id'
        },
        ordemCompras: {
          name: 'ordemCompras',
          type: 'OrdemCompra[]',
          model: 'OrdemCompra',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'execucaoSimulacaoId'
        },
      }
    }
  }
}
