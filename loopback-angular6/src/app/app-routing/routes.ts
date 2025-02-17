import { Routes } from '@angular/router';


import { HomeComponent } from '../home/home.component';
import { AtivoAcaoComponent } from '../ativo-acao/ativo-acao.component';
import { AtivoOpcaoComponent } from '../ativo-opcao/ativo-opcao.component';
import { AtivoMercadoriaComponent } from '../ativo-mercadoria/ativo-mercadoria.component';
import { AtivoImobiliarioComponent } from '../ativo-imobiliario/ativo-imobiliario.component';
import { CotacaoIntraAcaoComponent } from '../cotacao-intra-acao/cotacao-intra-acao.component';
import { CotacaoIntraOpcaoComponent } from '../cotacao-intra-opcao/cotacao-intra-opcao.component';
import { CotacaoIntraMercadoriaComponent } from '../cotacao-intra-mercadoria/cotacao-intra-mercadoria.component';
import { CotacaoIntraImobiliarioComponent } from '../cotacao-intra-imobiliario/cotacao-intra-imobiliario.component';
import { DataSetListComponent } from '../data-set-list/data-set-list.component';
import { StartupEmpresaListComponent } from '../startup-empresa-list/startup-empresa-list.component';
import { StartupFundoListComponent } from '../startup-fundo-list/startup-fundo-list.component';
import { RegraSimulacaoListComponent } from '../regra-simulacao-list/regra-simulacao-list.component';
import { ExperimentoSimulacaoListComponent } from '../experimento-simulacao-list/experimento-simulacao-list.component';
import { GrupoAcaoListComponent } from '../grupo-acao-list/grupo-acao-list.component';
import { CombinacaoListComponent } from '../combinacao-list/combinacao-list.component';
import { ExecucaoSimulacaoMelhoresResultadoComponent } from '../execucao-simulacao-melhores-resultado/execucao-simulacao-melhores-resultado.component';
import { ExecucaoSimulacaoMonitoradaComponent } from '../execucao-simulacao-monitorada/execucao-simulacao-monitorada.component';
import { ExecucaoSimulacaoPorExperimentoComponent } from '../execucao-simulacao-por-experimento/execucao-simulacao-por-experimento.component';
import { CotacaoDiarioAcaoComponent } from '../cotacao-diario-acao/cotacao-diario-acao.component';
import { AcaoDetalheDiaComponent } from '../acao-detalhe-dia/acao-detalhe-dia.component';
import { ValorMonitoriaExecucaoComponent } from '../valor-monitoria-execucao/valor-monitoria-execucao.component';
import { TradeRealListaComponent } from '../trade-real-lista/trade-real-lista.component';
import { OrdemCompraListaComponent } from '../ordem-compra-lista/ordem-compra-lista.component';
import { PeriodoExperimentoListaComponent } from '../periodo-experimento-lista/periodo-experimento-lista.component';
import { FundoImobiliarioMelhoresComponent } from '../fundo-imobiliario-melhores/fundo-imobiliario-melhores.component';
import { ValorMonitoriaPeriodoTabelaComponent } from '../valor-monitoria-periodo-tabela/valor-monitoria-periodo-tabela.component';
import { ValorMonitoriaPeriodoComponent } from '../valor-monitoria-periodo/valor-monitoria-periodo.component';
import { MelhoresExecucaoPeriodoComponent } from '../melhores-execucao-periodo/melhores-execucao-periodo.component';
import { FundoImobiliarioAluguelMelhoresComponent } from '../fundo-imobiliario-aluguel-melhores/fundo-imobiliario-aluguel-melhores.component';
import { TipoAplicacaoListComponent } from '../tipo-aplicacao-list/tipo-aplicacao-list.component';
import { MelhoresValidacaoPeriodoComponent } from '../melhores-validacao-periodo/melhores-validacao-periodo.component';
import { AtivoIndiceComponent } from '../ativo-indice/ativo-indice.component';
import { AtivoIntraIndiceComponent } from '../ativo-intra-indice/ativo-intra-indice.component';
import { AtivoAcaoResultadoFuturoComponent } from '../ativo-acao-resultado-futuro/ativo-acao-resultado-futuro.component';
import { AlocacaoMovimentacaoComponent } from '../alocacao-movimentacao/alocacao-movimentacao.component';
import { AlocacaoSaldoMesComponent } from '../alocacao-saldo-mes/alocacao-saldo-mes.component';
import { AtivoCriptomoedaComponent } from '../ativo-criptomoeda/ativo-criptomoeda.component';
import { CotacaoIntraCriptomoedaComponent } from '../cotacao-intra-criptomoeda/cotacao-intra-criptomoeda.component';
import { RegraProjecaoListComponent } from '../regra-projecao-list/regra-projecao-list.component';
import { AtivoCriptomoedaFoxbitComponent } from '../ativo-criptomoeda-foxbit/ativo-criptomoeda-foxbit.component';
import { ValorMesSaldoListComponent } from '../valor-mes-saldo-list/valor-mes-saldo-list.component';
import { CotacaoIntraMercadoBitcoinComponent } from '../cotacao-intra-mercado-bitcoin/cotacao-intra-mercado-bitcoin.component';
import { RegraProjecaoDatasComponent } from '../regra-projecao-datas/regra-projecao-datas.component';
import { TradeRealVisualComponent } from '../trade-real-visual/trade-real-visual.component';
import { PatrimonioEvolucaoMensalComponent } from '../patrimonio-evolucao-mensal/patrimonio-evolucao-mensal.component';
import { QuadroComparaStopComponent } from '../quadro-compara-stop/quadro-compara-stop.component';
import { QuadroComparaStopGeralComponent } from '../quadro-compara-stop-geral/quadro-compara-stop-geral.component';
import { CotacaoIntradayResultadoAcaoComponent } from '../cotacao-intraday-resultado-acao/cotacao-intraday-resultado-acao.component';
import { ExemploIntradayResultadoAcaoComponent } from '../exemplo-intraday-resultado-acao/exemplo-intraday-resultado-acao.component';
import { ResumoTradeRealComponent } from '../resumo-trade-real/resumo-trade-real.component';
import { PontoEntradaSimulacaoDiaComponent } from '../ponto-entrada-simulacao-dia/ponto-entrada-simulacao-dia.component';
import { FundoImobiliarioMelhorEstabilidadeComponent } from '../fundo-imobiliario-melhor-estabilidade/fundo-imobiliario-melhor-estabilidade.component';
import { PontoEntradaSimulacaoDiaVendaComponent } from '../ponto-entrada-simulacao-dia-venda/ponto-entrada-simulacao-dia-venda.component';
import { ExemploIntradayResultadoAcaoSaidaComponent } from '../exemplo-intraday-resultado-acao-saida/exemplo-intraday-resultado-acao-saida.component';
import { ExemploEntradaListaComponent } from '../exemplo-entrada-lista/exemplo-entrada-lista.component';
import { RedeNeuralListaComponent } from '../rede-neural-lista/rede-neural-lista.component';
import { ExemploSaidaResumoComponent } from '../exemplo-saida-resumo/exemplo-saida-resumo.component';
import { PrevisaoRedeListaDiaComponent } from '../previsao-rede-lista-dia/previsao-rede-lista-dia.component';
import { TreinoRedeListaComponent } from '../treino-rede-lista/treino-rede-lista.component';
import { PeriodoTreinoRedeListaComponent } from '../periodo-treino-rede-lista/periodo-treino-rede-lista.component';
import { ImobiliarioIntradayComponent } from '../imobiliario-intraday/imobiliario-intraday.component';
import { GrupoRegraListaComponent } from '../grupo-regra-lista/grupo-regra-lista.component';
import { GrupoRegraDetalheComponent } from '../grupo-regra-detalhe/grupo-regra-detalhe.component';
import { RendaFixaPrivadaMelhoresComponent } from '../renda-fixa-privada-melhores/renda-fixa-privada-melhores.component';
import { GrupoRedeListaComponent } from '../grupo-rede-lista/grupo-rede-lista.component';
import { EmprestimoP2PListaComponent } from '../emprestimo-p2-plista/emprestimo-p2-plista.component';
import { TreinoGrupoListaComponent } from '../treino-grupo-lista/treino-grupo-lista.component';
import { EmprestimoP2PDetalheComponent } from '../emprestimo-p2-pdetalhe/emprestimo-p2-pdetalhe.component';
import { TreinoGrupoDetalheComponent } from '../treino-grupo-detalhe/treino-grupo-detalhe.component';
import { EmprestimoP2PMesCorrenteComponent } from '../emprestimo-p2-pmes-corrente/emprestimo-p2-pmes-corrente.component';
import { TradeAtivoComponent } from '../trade-ativo/trade-ativo.component';
import { FechamentoRegraDia, FundoImobiliarioCarteira, TesouroDiretoCotacao } from '../shared/sdk';
import { FundoImobiliarioCarteiraComponent } from '../fundo-imobiliario-carteira/fundo-imobiliario-carteira.component';
import { MapaCalorGrupoTreinoComponent } from '../mapa-calor-grupo-treino/mapa-calor-grupo-treino.component';
import { FundoImobiliarioCarteiraSemTabelaComponent } from '../fundo-imobiliario-carteira-sem-tabela/fundo-imobiliario-carteira-sem-tabela.component';
import { TreinoRedeEvolucaoComponent } from '../treino-rede-evolucao/treino-rede-evolucao.component';
import { TesouroDiretoListaComponent } from '../tesouro-direto-lista/tesouro-direto-lista.component';
import { TesouroDiretoCotacaoComponent } from '../tesouro-direto-cotacao/tesouro-direto-cotacao.component';
import { IndicadorRedeResumoComponent } from '../indicador-rede-resumo/indicador-rede-resumo.component';
import { PlanoMensalComponent } from '../plano-mensal/plano-mensal.component';
import { PrevisaoHistoricoComponent } from '../previsao-historico/previsao-historico.component';
import { ResumoTradeReal2Component } from '../resumo-trade-real2/resumo-trade-real2.component';
import { TipoExemploTreinoListComponent } from '../tipo-exemplo-treino-list/tipo-exemplo-treino-list.component';
import { ValidadorExemploSaidaComponent } from '../validador-exemplo-saida/validador-exemplo-saida.component';
import { KerasLayerListComponent } from '../keras-layer-list/keras-layer-list.component';
import { KerasTipoListComponent } from '../keras-tipo-list/keras-tipo-list.component';
import { RegraProjecaoPorGrupoComponent } from '../regra-projecao-por-grupo/regra-projecao-por-grupo.component';
import { RegraProjecaoOrdenadaDataComponent } from '../regra-projecao-ordenada-data/regra-projecao-ordenada-data.component';
import { KerasLossListComponent } from '../keras-loss-list/keras-loss-list.component';
import { KerasOptimizerListComponent } from '../keras-optimizer-list/keras-optimizer-list.component';
import { RankingTreinoRedeComponent } from '../ranking-treino-rede/ranking-treino-rede.component';
import { RedePerformanceListComponent } from '../rede-performance-list/rede-performance-list.component';
import { PreRedeListComponent } from '../pre-rede-list/pre-rede-list.component';
import { PreRedeVersaoListComponent } from '../pre-rede-versao-list/pre-rede-versao-list.component';
import { FinanceiroAcaoAtualComponent } from '../financeiro-acao-atual/financeiro-acao-atual.component';
import { AmostraDadoSinteticoListComponent } from '../amostra-dado-sintetico-list/amostra-dado-sintetico-list.component';
import { AmostraDadoSinteticoDetalheComponent } from '../amostra-dado-sintetico-detalhe/amostra-dado-sintetico-detalhe.component';
import { FechamentoRegraDiaListComponent } from '../fechamento-regra-dia-list/fechamento-regra-dia-list.component';
import { ConsultaIntradayResultadoDataComponent } from '../consulta-intraday-resultado-data/consulta-intraday-resultado-data.component';
import { FechamentoPontoSaidaDetalheComponent } from '../fechamento-ponto-saida-detalhe/fechamento-ponto-saida-detalhe.component';
import { FechamentoRegraDiaDetalheComponent } from '../fechamento-regra-dia-detalhe/fechamento-regra-dia-detalhe.component';
import { VersaoPreRedeDetalheComponent } from '../versao-pre-rede-detalhe/versao-pre-rede-detalhe.component';



export const routes : Routes = [
    { path: 'home' , component: HomeComponent },

    { path: 'ativoAcao' , component: AtivoAcaoComponent},
    { path: 'ativoOpcao' , component: AtivoOpcaoComponent},
    { path: 'ativoMercadoria' , component: AtivoMercadoriaComponent},
    { path: 'ativoImobiliario' , component: AtivoImobiliarioComponent},
    { path: 'ativoIndice' , component: AtivoIndiceComponent},
    { path: 'ativoCriptomoeda' , component: AtivoCriptomoedaComponent},
    { path: 'ativoCriptomoedaFoxbit' , component: AtivoCriptomoedaFoxbitComponent},
 

    { path: 'ativoAcaoResultadoFuturo' , component: AtivoAcaoResultadoFuturoComponent },

    { path: 'cotacaoIntraAcao/:id' , component: CotacaoIntraAcaoComponent},
    { path: 'cotacaoIntraOpcao/:id' , component: CotacaoIntraOpcaoComponent},
    { path: 'cotacaoIntraMercadoria/:id' , component: CotacaoIntraMercadoriaComponent},
    { path: 'cotacaoIntraImobiliario/:id' , component: CotacaoIntraImobiliarioComponent},
    { path: 'cotacaoIntraIndice/:id' , component: AtivoIntraIndiceComponent},
    { path: 'cotacaoIntraCriptomoeda/:id' , component: CotacaoIntraCriptomoedaComponent},
    { path: 'cotacaoIntraCriptomoedaFoxbit/:id' , component: CotacaoIntraCriptomoedaComponent},
    { path: 'cotacaoIntraCriptomoedaMercadoBitcoin/:id' , component: CotacaoIntraMercadoBitcoinComponent },

    { path: 'cotacaoDiarioAcao/:id' , component : CotacaoDiarioAcaoComponent },
    { path: 'acaoDetalheDia/:ticker/:diaNum' , component: AcaoDetalheDiaComponent },
    { path: 'valorMonitoriaExecucao/:id' , component: ValorMonitoriaExecucaoComponent },

    { path: 'dataSet' , component: DataSetListComponent},

    { path : 'startupEmpresa' , component: StartupEmpresaListComponent },
    { path : 'startupFundo' , component: StartupFundoListComponent },

    { path : 'regraSimulacao' , component: RegraSimulacaoListComponent },
    { path : 'experimentoSimulacao' , component: ExperimentoSimulacaoListComponent },
    { path : 'grupoAcao' , component: GrupoAcaoListComponent },
    { path : 'combinacaoExperimento/:id' , component: CombinacaoListComponent },

    { path : 'execucaoSimulacaoMelhores' , component: ExecucaoSimulacaoMelhoresResultadoComponent },
    { path : 'execucaoSimulacaoMonitorada' , component: ExecucaoSimulacaoMonitoradaComponent },
    { path : 'execucaoSimulacaoPorExperimento/:id' , component: ExecucaoSimulacaoPorExperimentoComponent },

    { path : 'tradeReal' , component: TradeRealListaComponent },
    { path : 'tradeRealVisual' , component: TradeRealVisualComponent },

    { path : 'ordemCompra' , component: OrdemCompraListaComponent },
    { path : 'periodoExperimento' , component: PeriodoExperimentoListaComponent },
    { path : 'fundoImobiliarioMelhores' , component: FundoImobiliarioMelhoresComponent},
    { path : 'fundoImobiliarioAluguelMelhores' , component: FundoImobiliarioAluguelMelhoresComponent},
    { path : 'fundoImobiliarioMelhorEstabilidade' , component: FundoImobiliarioMelhorEstabilidadeComponent },
    { path : 'imobiliarioIntraday' , component: ImobiliarioIntradayComponent },

    { path : 'valorMonitoriaPeriodo/:id' , component : ValorMonitoriaPeriodoComponent },
    { path : 'valorMonitoriaPeriodoTabela/:id' , component: ValorMonitoriaPeriodoTabelaComponent },

    { path : 'melhoresExecucaoPeriodo/:id' , component: MelhoresExecucaoPeriodoComponent },
    { path : 'melhoresValidacaoPeriodo/:id' , component: MelhoresValidacaoPeriodoComponent },

    { path : 'regraProjecao' , component: RegraProjecaoListComponent },
    { path : 'regraProjecaoData' , component: RegraProjecaoDatasComponent },

    { path : 'tipoAplicacao' , component: TipoAplicacaoListComponent },
    
    { path : 'alocacaoSaldoMes' , component: AlocacaoSaldoMesComponent },
    { path : 'alocacaoMovimentacao' , component: AlocacaoMovimentacaoComponent } ,
    { path : 'valorMesSaldo' , component: ValorMesSaldoListComponent },
    { path : 'patrimonioEvolucaoMensal' , component : PatrimonioEvolucaoMensalComponent },

    { path : 'quadroComparaStop/:target/:tipo' , component : QuadroComparaStopComponent },
    { path : 'quadroComparaStopGeral/:tipo' , component: QuadroComparaStopComponent },

    { path : 'cotacaoIntradayResultadoAcao' , component: CotacaoIntradayResultadoAcaoComponent },
    { path : 'exemploIntradayResultadoAcao' , component: ExemploIntradayResultadoAcaoComponent },
    { path : 'exemploIntradayResultadoAcaoSaida' , component: ExemploIntradayResultadoAcaoSaidaComponent },

    { path : 'resumoTradeReal' , component: ResumoTradeRealComponent },
    { path : 'pontoEntradaSimulacaoDia' , component: PontoEntradaSimulacaoDiaComponent },
    { path : 'pontoEntradaSimulacaoDiaVenda' , component: PontoEntradaSimulacaoDiaVendaComponent },
    { path : 'exemploEntradaLista' , component: ExemploEntradaListaComponent },
    { path : 'redeNeuralLista' , component: RedeNeuralListaComponent },

    { path : 'exemploSaidaResumo' , component: ExemploSaidaResumoComponent },

    { path : 'previsaoRedeListaDia' , component: PrevisaoRedeListaDiaComponent },
    { path : 'treinoRedeLista' , component: TreinoRedeListaComponent },
    { path : 'periodoTreinoRedeLista' , component: PeriodoTreinoRedeListaComponent },

    { path: 'grupoRegraLista' , component: GrupoRegraListaComponent },
    { path: 'grupoRegraDetalhe/:id' , component: GrupoRegraDetalheComponent },

    { path: 'grupoRedeLista' , component: GrupoRedeListaComponent },

    { path: 'rendaPrivadaMelhores' , component: RendaFixaPrivadaMelhoresComponent },
    { path: 'emprestimoP2PLista' , component: EmprestimoP2PListaComponent },

    { path: 'emprestimoP2PDetalhe/:id' , component: EmprestimoP2PDetalheComponent },

    { path : 'treinoGrupoLista' , component: TreinoGrupoListaComponent },
    { path : 'treinoGrupoDetalhe/:id' , component: TreinoGrupoDetalheComponent },

    { path : 'emprestimoP2PMesCorrente' , component : EmprestimoP2PMesCorrenteComponent },

    { path : 'tradeAtivo' , component : TradeAtivoComponent },
    { path : 'fundoImobiliarioCarteira' , component: FundoImobiliarioCarteiraComponent },

    { path: 'mapaCalorGrupoTreino/:id' , component: MapaCalorGrupoTreinoComponent },
    { path: 'fundoImobiliarioCarteiraSemCarteira' , component: FundoImobiliarioCarteiraSemTabelaComponent },

    { path: 'treinoRedeEvolucao' , component: TreinoRedeEvolucaoComponent },

    { path: 'tesouroDiretoLista' , component: TesouroDiretoListaComponent },
    { path: 'tesouroDiretoCotacao/:id' , component: TesouroDiretoCotacaoComponent },
    { path: 'indicadorRedeResumo' , component: IndicadorRedeResumoComponent },

    { path: 'planoMensal' , component: PlanoMensalComponent },
    { path: 'previsaoHistorico' , component: PrevisaoHistoricoComponent },

    { path: 'resumoTradeReal2' , component: ResumoTradeReal2Component },

    { path: 'tipoExemploTreino' , component: TipoExemploTreinoListComponent },

    { path: 'validacaoExemploSaida' , component: ValidadorExemploSaidaComponent },
    { path: 'kerasTipo' , component: KerasTipoListComponent },
    { path: 'kerasLayer/:id' , component: KerasLayerListComponent },

    { path: 'regraProjecaoPorGrupo/:id' , component: RegraProjecaoPorGrupoComponent },
    { path: 'regraProjecaoOrdenadaData' , component: RegraProjecaoOrdenadaDataComponent },

    { path: 'kerasLoss' , component: KerasLossListComponent },
    { path: 'kerasOptimizer' , component: KerasOptimizerListComponent },

    { path: 'rankingTreinoRede' , component: RankingTreinoRedeComponent },
    { path: 'redePerformance' , component : RedePerformanceListComponent },

    { path: 'preRede' , component: PreRedeListComponent },
    { path: 'preRedeVersao/:id' , component: PreRedeVersaoListComponent },
    { path: 'versaoPreRedeDetalhe/:id' , component: VersaoPreRedeDetalheComponent },

    { path: 'financeiroAcaoAtual' , component: FinanceiroAcaoAtualComponent },
    { path: 'amostraDadoSintetico' , component: AmostraDadoSinteticoListComponent },
    { path: 'amostraDadoSinteticoDetalhe/:id' , component: AmostraDadoSinteticoDetalheComponent },

    { path: 'fechamentoRegraDia' , component: FechamentoRegraDiaListComponent },
    { path: 'consultaIntradayResultadoData' , component: ConsultaIntradayResultadoDataComponent },

    { path: 'fechamentoPontoSaidaDetalhe/:id' , component: FechamentoPontoSaidaDetalheComponent },
    { path: 'fechamentoRegraDiaDetalhe/:id' , component: FechamentoRegraDiaDetalheComponent },

    { path: 'tipoExemploTreinoList' , component: TipoExemploTreinoListComponent },

    { path: '',  component: HomeComponent  }
    //{ path: '',          redirectTo: 'home', pathMatch: 'full' }
]