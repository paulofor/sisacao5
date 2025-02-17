/* tslint:disable */
import { Injectable } from '@angular/core';
import { User } from '../../models/User';
import { Ativo } from '../../models/Ativo';
import { AtivoOpcao } from '../../models/AtivoOpcao';
import { AtivoAcao } from '../../models/AtivoAcao';
import { AtivoMercadoria } from '../../models/AtivoMercadoria';
import { AtivoImobiliario } from '../../models/AtivoImobiliario';
import { CotacaoIntradayOpcao } from '../../models/CotacaoIntradayOpcao';
import { CotacaoIntradayAcao } from '../../models/CotacaoIntradayAcao';
import { CotacaoIntradayImobiliario } from '../../models/CotacaoIntradayImobiliario';
import { CotacaoIntradayMercadoria } from '../../models/CotacaoIntradayMercadoria';
import { DataSet } from '../../models/DataSet';
import { AtributoDataSet } from '../../models/AtributoDataSet';
import { StartupFundo } from '../../models/StartupFundo';
import { StartupEmpresa } from '../../models/StartupEmpresa';
import { StartupInvestimento } from '../../models/StartupInvestimento';
import { IdeiaExperimento } from '../../models/IdeiaExperimento';
import { DiaPregao } from '../../models/DiaPregao';
import { RegraSimulacao } from '../../models/RegraSimulacao';
import { ParametroRegra } from '../../models/ParametroRegra';
import { ExperimentoSimulacao } from '../../models/ExperimentoSimulacao';
import { ExperimentoParametro } from '../../models/ExperimentoParametro';
import { ExperimentoAcao } from '../../models/ExperimentoAcao';
import { GrupoAcao } from '../../models/GrupoAcao';
import { RelGrupoAcao } from '../../models/RelGrupoAcao';
import { CotacaoDiarioAcao } from '../../models/CotacaoDiarioAcao';
import { CombinacaoParametro } from '../../models/CombinacaoParametro';
import { ValorParametro } from '../../models/ValorParametro';
import { ExecucaoSimulacao } from '../../models/ExecucaoSimulacao';
import { Trade } from '../../models/Trade';
import { ValorMonitoria } from '../../models/ValorMonitoria';
import { TradeReal } from '../../models/TradeReal';
import { PeriodoExperimento } from '../../models/PeriodoExperimento';
import { OrdemCompra } from '../../models/OrdemCompra';
import { ExperimentoSimulacaoPeriodo } from '../../models/ExperimentoSimulacaoPeriodo';
import { FundoImobiliario } from '../../models/FundoImobiliario';
import { CDB } from '../../models/CDB';
import { RendaFixa } from '../../models/RendaFixa';
import { AluguelFundoImobiliario } from '../../models/AluguelFundoImobiliario';
import { TipoAplicacao } from '../../models/TipoAplicacao';
import { InstituicaoFinanceira } from '../../models/InstituicaoFinanceira';
import { AtivoIndice } from '../../models/AtivoIndice';
import { CotacaoIntradayIndice } from '../../models/CotacaoIntradayIndice';
import { ExecucaoSimulacaoValidacao } from '../../models/ExecucaoSimulacaoValidacao';
import { CotacaoIntradayAcaoResultado } from '../../models/CotacaoIntradayAcaoResultado';
import { CotacaoDiarioIndice } from '../../models/CotacaoDiarioIndice';
import { AplicacaoInstituicao } from '../../models/AplicacaoInstituicao';
import { AtivoCriptomoeda } from '../../models/AtivoCriptomoeda';
import { CotacaoIntradayMercadoBitcoin } from '../../models/CotacaoIntradayMercadoBitcoin';
import { MovimentacaoValorAplicado } from '../../models/MovimentacaoValorAplicado';
import { ValorMesInstituicaoTipo } from '../../models/ValorMesInstituicaoTipo';
import { RegraProjecao } from '../../models/RegraProjecao';
import { CotacaoIntradayAcaoResultadoValor } from '../../models/CotacaoIntradayAcaoResultadoValor';
import { ExecucaoSimulacaoMelhoresValidacao } from '../../models/ExecucaoSimulacaoMelhoresValidacao';
import { CotacaoIntradayFoxbit } from '../../models/CotacaoIntradayFoxbit';
import { DatasetAcao } from '../../models/DatasetAcao';
import { ExemploTreinoAcao } from '../../models/ExemploTreinoAcao';
import { RegraProjecaoTotalMes } from '../../models/RegraProjecaoTotalMes';
import { PontoEntradaTrade } from '../../models/PontoEntradaTrade';
import { PontoEntradaSimulacao } from '../../models/PontoEntradaSimulacao';
import { ExemploTreinoAcaoEntrada } from '../../models/ExemploTreinoAcaoEntrada';
import { ExemploTreinoAcaoSaida } from '../../models/ExemploTreinoAcaoSaida';
import { PrevisaoRede } from '../../models/PrevisaoRede';
import { RedeNeural } from '../../models/RedeNeural';
import { PeriodoTreinoRede } from '../../models/PeriodoTreinoRede';
import { TipoExemploTreino } from '../../models/TipoExemploTreino';
import { TreinoRede } from '../../models/TreinoRede';
import { RendaFixaPrivada } from '../../models/RendaFixaPrivada';
import { PrevisaoTeste } from '../../models/PrevisaoTeste';
import { GrupoRegra } from '../../models/GrupoRegra';
import { GrupoRegraRel } from '../../models/GrupoRegraRel';
import { EmprestimoP2P } from '../../models/EmprestimoP2P';
import { ParcelaEmprestimo } from '../../models/ParcelaEmprestimo';
import { GrupoRede } from '../../models/GrupoRede';
import { GrupoRedeRel } from '../../models/GrupoRedeRel';
import { TreinoGrupoRede } from '../../models/TreinoGrupoRede';
import { FundoImobiliarioCarteira } from '../../models/FundoImobiliarioCarteira';
import { TradeTreinoRede } from '../../models/TradeTreinoRede';
import { TesouroDireto } from '../../models/TesouroDireto';
import { TesouroDiretoCotacao } from '../../models/TesouroDiretoCotacao';
import { IndicadorRede } from '../../models/IndicadorRede';
import { TipoAplicacaoSaldoMes } from '../../models/TipoAplicacaoSaldoMes';
import { CotacaoIntradayCoinmarketcap } from '../../models/CotacaoIntradayCoinmarketcap';
import { KerasLayer } from '../../models/KerasLayer';
import { KerasLayerType } from '../../models/KerasLayerType';
import { RegraProjecaoHist } from '../../models/RegraProjecaoHist';
import { KerasOptimizer } from '../../models/KerasOptimizer';
import { KerasLoss } from '../../models/KerasLoss';
import { FinanceiroAcaoDia } from '../../models/FinanceiroAcaoDia';
import { PreRedeNeural } from '../../models/PreRedeNeural';
import { VersaoPreRede } from '../../models/VersaoPreRede';
import { FinanceiroAcaoFixo } from '../../models/FinanceiroAcaoFixo';
import { VersaoPreRedeRegra } from '../../models/VersaoPreRedeRegra';
import { AmostraDadoSintetico } from '../../models/AmostraDadoSintetico';
import { FechamentoRegraDia } from '../../models/FechamentoRegraDia';
import { ExemploDadoSintetico } from '../../models/ExemploDadoSintetico';
import { RegraProjecaoReversao } from '../../models/RegraProjecaoReversao';
import { FechamentoRegraDiaQuantidade } from '../../models/FechamentoRegraDiaQuantidade';
import { ExperimentoPreRede } from '../../models/ExperimentoPreRede';
import { FechamentoPontoSaida } from '../../models/FechamentoPontoSaida';
import { ExperimentoPreRedeResultado } from '../../models/ExperimentoPreRedeResultado';
import { ExemploDadoSinteticoTeste } from '../../models/ExemploDadoSinteticoTeste';
import { ExperimentoPreRedeTreinada } from '../../models/ExperimentoPreRedeTreinada';
import { ExperimentoPreRedeTreinadaScore } from '../../models/ExperimentoPreRedeTreinadaScore';
import { ExperimentoPreRedeTreinadaControle } from '../../models/ExperimentoPreRedeTreinadaControle';
import { AtivoAcaoUsa } from '../../models/AtivoAcaoUsa';
import { CotacaoDiarioAcaoUsa } from '../../models/CotacaoDiarioAcaoUsa';
import { CotacaoIntradayAcaoUsa } from '../../models/CotacaoIntradayAcaoUsa';
import { CotacaoIntradayIndiceResultado } from '../../models/CotacaoIntradayIndiceResultado';
import { ExemploTreinoIndiceAcaoEntrada } from '../../models/ExemploTreinoIndiceAcaoEntrada';
import { ExperimentoRedeNeural } from '../../models/ExperimentoRedeNeural';

export interface Models { [name: string]: any }

@Injectable()
export class SDKModels {

  private models: Models = {
    User: User,
    Ativo: Ativo,
    AtivoOpcao: AtivoOpcao,
    AtivoAcao: AtivoAcao,
    AtivoMercadoria: AtivoMercadoria,
    AtivoImobiliario: AtivoImobiliario,
    CotacaoIntradayOpcao: CotacaoIntradayOpcao,
    CotacaoIntradayAcao: CotacaoIntradayAcao,
    CotacaoIntradayImobiliario: CotacaoIntradayImobiliario,
    CotacaoIntradayMercadoria: CotacaoIntradayMercadoria,
    DataSet: DataSet,
    AtributoDataSet: AtributoDataSet,
    StartupFundo: StartupFundo,
    StartupEmpresa: StartupEmpresa,
    StartupInvestimento: StartupInvestimento,
    IdeiaExperimento: IdeiaExperimento,
    DiaPregao: DiaPregao,
    RegraSimulacao: RegraSimulacao,
    ParametroRegra: ParametroRegra,
    ExperimentoSimulacao: ExperimentoSimulacao,
    ExperimentoParametro: ExperimentoParametro,
    ExperimentoAcao: ExperimentoAcao,
    GrupoAcao: GrupoAcao,
    RelGrupoAcao: RelGrupoAcao,
    CotacaoDiarioAcao: CotacaoDiarioAcao,
    CombinacaoParametro: CombinacaoParametro,
    ValorParametro: ValorParametro,
    ExecucaoSimulacao: ExecucaoSimulacao,
    Trade: Trade,
    ValorMonitoria: ValorMonitoria,
    TradeReal: TradeReal,
    PeriodoExperimento: PeriodoExperimento,
    OrdemCompra: OrdemCompra,
    ExperimentoSimulacaoPeriodo: ExperimentoSimulacaoPeriodo,
    FundoImobiliario: FundoImobiliario,
    CDB: CDB,
    RendaFixa: RendaFixa,
    AluguelFundoImobiliario: AluguelFundoImobiliario,
    TipoAplicacao: TipoAplicacao,
    InstituicaoFinanceira: InstituicaoFinanceira,
    AtivoIndice: AtivoIndice,
    CotacaoIntradayIndice: CotacaoIntradayIndice,
    ExecucaoSimulacaoValidacao: ExecucaoSimulacaoValidacao,
    CotacaoIntradayAcaoResultado: CotacaoIntradayAcaoResultado,
    CotacaoDiarioIndice: CotacaoDiarioIndice,
    AplicacaoInstituicao: AplicacaoInstituicao,
    AtivoCriptomoeda: AtivoCriptomoeda,
    CotacaoIntradayMercadoBitcoin: CotacaoIntradayMercadoBitcoin,
    MovimentacaoValorAplicado: MovimentacaoValorAplicado,
    ValorMesInstituicaoTipo: ValorMesInstituicaoTipo,
    RegraProjecao: RegraProjecao,
    CotacaoIntradayAcaoResultadoValor: CotacaoIntradayAcaoResultadoValor,
    ExecucaoSimulacaoMelhoresValidacao: ExecucaoSimulacaoMelhoresValidacao,
    CotacaoIntradayFoxbit: CotacaoIntradayFoxbit,
    DatasetAcao: DatasetAcao,
    ExemploTreinoAcao: ExemploTreinoAcao,
    RegraProjecaoTotalMes: RegraProjecaoTotalMes,
    PontoEntradaTrade: PontoEntradaTrade,
    PontoEntradaSimulacao: PontoEntradaSimulacao,
    ExemploTreinoAcaoEntrada: ExemploTreinoAcaoEntrada,
    ExemploTreinoAcaoSaida: ExemploTreinoAcaoSaida,
    PrevisaoRede: PrevisaoRede,
    RedeNeural: RedeNeural,
    PeriodoTreinoRede: PeriodoTreinoRede,
    TipoExemploTreino: TipoExemploTreino,
    TreinoRede: TreinoRede,
    RendaFixaPrivada: RendaFixaPrivada,
    PrevisaoTeste: PrevisaoTeste,
    GrupoRegra: GrupoRegra,
    GrupoRegraRel: GrupoRegraRel,
    EmprestimoP2P: EmprestimoP2P,
    ParcelaEmprestimo: ParcelaEmprestimo,
    GrupoRede: GrupoRede,
    GrupoRedeRel: GrupoRedeRel,
    TreinoGrupoRede: TreinoGrupoRede,
    FundoImobiliarioCarteira: FundoImobiliarioCarteira,
    TradeTreinoRede: TradeTreinoRede,
    TesouroDireto: TesouroDireto,
    TesouroDiretoCotacao: TesouroDiretoCotacao,
    IndicadorRede: IndicadorRede,
    TipoAplicacaoSaldoMes: TipoAplicacaoSaldoMes,
    CotacaoIntradayCoinmarketcap: CotacaoIntradayCoinmarketcap,
    KerasLayer: KerasLayer,
    KerasLayerType: KerasLayerType,
    RegraProjecaoHist: RegraProjecaoHist,
    KerasOptimizer: KerasOptimizer,
    KerasLoss: KerasLoss,
    FinanceiroAcaoDia: FinanceiroAcaoDia,
    PreRedeNeural: PreRedeNeural,
    VersaoPreRede: VersaoPreRede,
    FinanceiroAcaoFixo: FinanceiroAcaoFixo,
    VersaoPreRedeRegra: VersaoPreRedeRegra,
    AmostraDadoSintetico: AmostraDadoSintetico,
    FechamentoRegraDia: FechamentoRegraDia,
    ExemploDadoSintetico: ExemploDadoSintetico,
    RegraProjecaoReversao: RegraProjecaoReversao,
    FechamentoRegraDiaQuantidade: FechamentoRegraDiaQuantidade,
    ExperimentoPreRede: ExperimentoPreRede,
    FechamentoPontoSaida: FechamentoPontoSaida,
    ExperimentoPreRedeResultado: ExperimentoPreRedeResultado,
    ExemploDadoSinteticoTeste: ExemploDadoSinteticoTeste,
    ExperimentoPreRedeTreinada: ExperimentoPreRedeTreinada,
    ExperimentoPreRedeTreinadaScore: ExperimentoPreRedeTreinadaScore,
    ExperimentoPreRedeTreinadaControle: ExperimentoPreRedeTreinadaControle,
    AtivoAcaoUsa: AtivoAcaoUsa,
    CotacaoDiarioAcaoUsa: CotacaoDiarioAcaoUsa,
    CotacaoIntradayAcaoUsa: CotacaoIntradayAcaoUsa,
    CotacaoIntradayIndiceResultado: CotacaoIntradayIndiceResultado,
    ExemploTreinoIndiceAcaoEntrada: ExemploTreinoIndiceAcaoEntrada,
    ExperimentoRedeNeural: ExperimentoRedeNeural,
    
  };

  public get(modelName: string): any {
    return this.models[modelName];
  }

  public getAll(): Models {
    return this.models;
  }

  public getModelNames(): string[] {
    return Object.keys(this.models);
  }
}
