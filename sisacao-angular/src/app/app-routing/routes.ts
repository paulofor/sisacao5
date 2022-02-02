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
    { path: '',  component: HomeComponent  }
    //{ path: '',          redirectTo: 'home', pathMatch: 'full' }
]