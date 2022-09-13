import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';

import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';

import { AppRoutingModule } from './app-routing/app-routing.module';
import { HomeComponent } from './home/home.component';
import { AtivoAcaoComponent } from './ativo-acao/ativo-acao.component';
import { AtivoOpcaoComponent } from './ativo-opcao/ativo-opcao.component';
import { AtivoMercadoriaComponent } from './ativo-mercadoria/ativo-mercadoria.component';
import { AtivoImobiliarioComponent } from './ativo-imobiliario/ativo-imobiliario.component';
import { AtivoAcaoEditaComponent } from './ativo-acao-edita/ativo-acao-edita.component';
import { AtivoImobiliarioEditaComponent } from './ativo-imobiliario-edita/ativo-imobiliario-edita.component';
import { AtivoMercadoriaEditaComponent } from './ativo-mercadoria-edita/ativo-mercadoria-edita.component';
import { AtivoOpcaoEditaComponent } from './ativo-opcao-edita/ativo-opcao-edita.component';
import { AtivoAcaoApi, AtivoOpcaoApi, AtivoMercadoriaApi, AtivoImobiliarioApi, SDKBrowserModule, SDKModels, LoopBackAuth, InternalStorage } from './shared/sdk';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { SocketConnection } from './shared/sdk/sockets/socket.connections';
import { SocketDriver } from './shared/sdk/sockets/socket.driver';


import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';

import {MatDialogModule} from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatListModule} from '@angular/material/list';
import {MatTabsModule} from '@angular/material/tabs';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatTableModule} from '@angular/material/table';
import { MatFormFieldModule, MatInputModule, MatButtonModule, MatAutocompleteModule, MatCheckbox, MatCheckboxModule, MatDatepickerModule, MatNativeDateModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
//import { MatMomentDateModule } from "@angular/material-moment-adapter";
//import { NgxImgModule } from 'ngx-img';
import { FileDropModule } from 'ngx-file-drop';
//import { UploadModule } from './upload/upload.module';
import { ImageUploadModule } from "angular2-image-upload";
import { ReactiveFormsModule } from '@angular/forms';
import { NgDragDropModule } from 'ng-drag-drop';
import { CotacaoIntraAcaoComponent } from './cotacao-intra-acao/cotacao-intra-acao.component';
import { CotacaoIntraOpcaoComponent } from './cotacao-intra-opcao/cotacao-intra-opcao.component';
import { CotacaoIntraMercadoriaComponent } from './cotacao-intra-mercadoria/cotacao-intra-mercadoria.component';
import { CotacaoIntraImobiliarioComponent } from './cotacao-intra-imobiliario/cotacao-intra-imobiliario.component';
import { TransformacaoListComponent } from './transformacao-list/transformacao-list.component';
import { TransformacaoEditComponent } from './transformacao-edit/transformacao-edit.component';
import { StartupEmpresaListComponent } from './startup-empresa-list/startup-empresa-list.component';
import { StartupFundoListComponent } from './startup-fundo-list/startup-fundo-list.component';
import { DataSetEditComponent } from './data-set-edit/data-set-edit.component';
import { DataSetListComponent } from './data-set-list/data-set-list.component';
import { DataSetAtributoEditComponent } from './data-set-atributo-edit/data-set-atributo-edit.component';
import { DataSetAtributoListComponent } from './data-set-atributo-list/data-set-atributo-list.component';
import { IdeiaExperimentoListComponent } from './ideia-experimento-list/ideia-experimento-list.component';
import { IdeiaExperimentoEditComponent } from './ideia-experimento-edit/ideia-experimento-edit.component';
import { StartupEmpresaEditComponent } from './startup-empresa-edit/startup-empresa-edit.component';
import { StartupFundoEditComponent } from './startup-fundo-edit/startup-fundo-edit.component';
import { StartupInvestimentoEditComponent } from './startup-investimento-edit/startup-investimento-edit.component';
import { AtributoDataSetEditComponent } from './atributo-data-set-edit/atributo-data-set-edit.component';
import { DataSetCreateSqlComponent } from './data-set-create-sql/data-set-create-sql.component';
import { RegraSimulacaoListComponent } from './regra-simulacao-list/regra-simulacao-list.component';
import { RegraSimulacaoEditComponent } from './regra-simulacao-edit/regra-simulacao-edit.component';
import { ParametroRegraEditComponent } from './parametro-regra-edit/parametro-regra-edit.component';
import { ExperimentoSimulacaoListComponent } from './experimento-simulacao-list/experimento-simulacao-list.component';
import { ExperimentoSimulacaoEditComponent } from './experimento-simulacao-edit/experimento-simulacao-edit.component';
import { ExperimentoParametroEditComponent } from './experimento-parametro-edit/experimento-parametro-edit.component';
import { GrupoAcaoListComponent } from './grupo-acao-list/grupo-acao-list.component';
import { GrupoAcaoEditComponent } from './grupo-acao-edit/grupo-acao-edit.component';
import { EscolheAcaoGrupoEditComponent } from './escolhe-acao-grupo-edit/escolhe-acao-grupo-edit.component';
import { CombinacaoListComponent } from './combinacao-list/combinacao-list.component';
import { CotacaoIntradayAcaoMaisRecenteComponent } from './cotacao-intraday-acao-mais-recente/cotacao-intraday-acao-mais-recente.component';
import { ExecucaoSimulacaoMelhoresResultadoComponent } from './execucao-simulacao-melhores-resultado/execucao-simulacao-melhores-resultado.component';
import { TradeExecucaoSimulacaoComponent } from './trade-execucao-simulacao/trade-execucao-simulacao.component';
import { ExecucaoSimulacaoMonitoradaComponent } from './execucao-simulacao-monitorada/execucao-simulacao-monitorada.component';
import { ExecucaoSimulacaoDisplayComponent } from './execucao-simulacao-display/execucao-simulacao-display.component';
import { ExecucaoSimulacaoPorExperimentoComponent } from './execucao-simulacao-por-experimento/execucao-simulacao-por-experimento.component';
import { CotacaoDiarioAcaoComponent } from './cotacao-diario-acao/cotacao-diario-acao.component';
import { CotacaoIntradayRecenteComponent } from './cotacao-intraday-recente/cotacao-intraday-recente.component';
import { AcaoDetalheDiaComponent } from './acao-detalhe-dia/acao-detalhe-dia.component';
import { ValorMonitoriaExecucaoComponent } from './valor-monitoria-execucao/valor-monitoria-execucao.component';
import { TradeRealEditaComponent } from './trade-real-edita/trade-real-edita.component';
import { TradeRealListaComponent } from './trade-real-lista/trade-real-lista.component';
import { TradeRealListaEditComponent } from './trade-real-lista-edit/trade-real-lista-edit.component';
import { OrdemCompraEditaComponent } from './ordem-compra-edita/ordem-compra-edita.component';
import { OrdemCompraListaComponent } from './ordem-compra-lista/ordem-compra-lista.component';
import { OrdemCompraListaEditaComponent } from './ordem-compra-lista-edita/ordem-compra-lista-edita.component';
import { PeriodoExperimentoListaComponent } from './periodo-experimento-lista/periodo-experimento-lista.component';

import { PeriodoExperimentoEditaComponent } from './periodo-experimento-edita/periodo-experimento-edita.component';
import { EscolhePeriodoParaExperimentoComponent } from './escolhe-periodo-para-experimento/escolhe-periodo-para-experimento.component';
import { FundoImobiliarioMelhoresComponent } from './fundo-imobiliario-melhores/fundo-imobiliario-melhores.component';
import { ValorMonitoriaPeriodoTabelaComponent } from './valor-monitoria-periodo-tabela/valor-monitoria-periodo-tabela.component';
import { ValorMonitoriaPeriodoComponent } from './valor-monitoria-periodo/valor-monitoria-periodo.component';
import { ExecucaoSimulacaoMelhoresPeriodoComponent } from './execucao-simulacao-melhores-periodo/execucao-simulacao-melhores-periodo.component';
import { MelhoresExecucaoPeriodoComponent } from './melhores-execucao-periodo/melhores-execucao-periodo.component';
import { DescricaoFundoImobiliarioComponent } from './descricao-fundo-imobiliario/descricao-fundo-imobiliario.component';
import { FundoImobiliarioAluguelMelhoresComponent } from './fundo-imobiliario-aluguel-melhores/fundo-imobiliario-aluguel-melhores.component';

import { EscolhePeriodoCorrenteExperimentoComponent } from './escolhe-periodo-corrente-experimento/escolhe-periodo-corrente-experimento.component';
import { TipoAplicacaoListComponent } from './tipo-aplicacao-list/tipo-aplicacao-list.component';
import { TipoAplicacaoEditComponent } from './tipo-aplicacao-edit/tipo-aplicacao-edit.component';

import { MelhoresValidacaoPeriodoComponent } from './melhores-validacao-periodo/melhores-validacao-periodo.component';
import { AtivoIndiceComponent } from './ativo-indice/ativo-indice.component';
import { AtivoIndiceEditaComponent } from './ativo-indice-edita/ativo-indice-edita.component';
import { AtivoIntraIndiceComponent } from './ativo-intra-indice/ativo-intra-indice.component';
import { AtivoAcaoResultadoFuturoComponent } from './ativo-acao-resultado-futuro/ativo-acao-resultado-futuro.component';
import { PainelPeriodoValidacaoComponent } from './painel-periodo-validacao/painel-periodo-validacao.component';
import { AlocacaoSaldoMesComponent } from './alocacao-saldo-mes/alocacao-saldo-mes.component';
import { AlocacaoMovimentacaoComponent } from './alocacao-movimentacao/alocacao-movimentacao.component';
import { AlocacaoSaldoMesEdicaoComponent } from './alocacao-saldo-mes-edicao/alocacao-saldo-mes-edicao.component';
import { MovimentacaoEditaComponent } from './movimentacao-edita/movimentacao-edita.component';
import { DetalheAluguelFundoImobiliarioComponent } from './detalhe-aluguel-fundo-imobiliario/detalhe-aluguel-fundo-imobiliario.component';
import { AtivoCriptomoedaComponent } from './ativo-criptomoeda/ativo-criptomoeda.component';
import { CotacaoIntraCriptomoedaComponent } from './cotacao-intra-criptomoeda/cotacao-intra-criptomoeda.component';
import { RegraProjecaoListComponent } from './regra-projecao-list/regra-projecao-list.component';
import { RegraProjecaoEditComponent } from './regra-projecao-edit/regra-projecao-edit.component';
import { AtivoCriptomoedaFoxbitComponent } from './ativo-criptomoeda-foxbit/ativo-criptomoeda-foxbit.component';
import { ValorMesSaldoListComponent } from './valor-mes-saldo-list/valor-mes-saldo-list.component';
import { ValorMesSaldoEditComponent } from './valor-mes-saldo-edit/valor-mes-saldo-edit.component';
import { AtivoCriptomoedaEditComponent } from './ativo-criptomoeda-edit/ativo-criptomoeda-edit.component';
import { CotacaoIntraMercadoBitcoinComponent } from './cotacao-intra-mercado-bitcoin/cotacao-intra-mercado-bitcoin.component';
import { PainelPatrimonioMesComponent } from './painel-patrimonio-mes/painel-patrimonio-mes.component';
import { GraficoAlocacaoComponent } from './grafico-alocacao/grafico-alocacao.component';

import { GraficoAlocacaoAporteComponent } from './grafico-alocacao-aporte/grafico-alocacao-aporte.component';
import { RegraProjecaoDatasComponent } from './regra-projecao-datas/regra-projecao-datas.component';
import { GrupoParaAcaoComponent } from './grupo-para-acao/grupo-para-acao.component';
import { TradeRealVisualComponent } from './trade-real-visual/trade-real-visual.component';
import { ItemTradeRealVisualComponent } from './item-trade-real-visual/item-trade-real-visual.component';
import { PatrimonioEvolucaoMensalComponent } from './patrimonio-evolucao-mensal/patrimonio-evolucao-mensal.component';
import { QuadroComparaStopComponent } from './quadro-compara-stop/quadro-compara-stop.component';
import { ItemVisualIndiceComponent } from './item-visual-indice/item-visual-indice.component';
import { QuadroComparaStopGeralComponent } from './quadro-compara-stop-geral/quadro-compara-stop-geral.component';
import { QuadroComparaStopItemComponent } from './quadro-compara-stop-item/quadro-compara-stop-item.component';
import { CotacaoIntradayResultadoAcaoComponent } from './cotacao-intraday-resultado-acao/cotacao-intraday-resultado-acao.component';
import { ImobiliarioGeralComponent } from './imobiliario-geral/imobiliario-geral.component';
import { ExemploIntradayResultadoAcaoComponent } from './exemplo-intraday-resultado-acao/exemplo-intraday-resultado-acao.component';
import { ResumoTradeRealComponent } from './resumo-trade-real/resumo-trade-real.component';
import { GraficoTradeMensalComponent } from './grafico-trade-mensal/grafico-trade-mensal.component';
import { PontoEntradaSimulacaoDiaComponent } from './ponto-entrada-simulacao-dia/ponto-entrada-simulacao-dia.component';
import { FundoImobiliarioMelhoresValorizacaoComponent } from './fundo-imobiliario-melhores-valorizacao/fundo-imobiliario-melhores-valorizacao.component';
import { FundoImobiliarioMelhoresRendimentoComponent } from './fundo-imobiliario-melhores-rendimento/fundo-imobiliario-melhores-rendimento.component';
import { TradeNovoSimulacaoComponent } from './trade-novo-simulacao/trade-novo-simulacao.component';
import { FundoImobiliarioMelhorEstabilidadeComponent } from './fundo-imobiliario-melhor-estabilidade/fundo-imobiliario-melhor-estabilidade.component';
import { PontoEntradaSimulacaoDiaVendaComponent } from './ponto-entrada-simulacao-dia-venda/ponto-entrada-simulacao-dia-venda.component';
import { ExemploIntradayResultadoAcaoSaidaComponent } from './exemplo-intraday-resultado-acao-saida/exemplo-intraday-resultado-acao-saida.component';
import { ExemploEntradaListaComponent } from './exemplo-entrada-lista/exemplo-entrada-lista.component';
import { RedeNeuralListaComponent } from './rede-neural-lista/rede-neural-lista.component';
import { RedeNeuralEditaComponent } from './rede-neural-edita/rede-neural-edita.component';
import { ExemploSaidaResumoComponent } from './exemplo-saida-resumo/exemplo-saida-resumo.component';
import { PrevisaoRedeListaDiaComponent } from './previsao-rede-lista-dia/previsao-rede-lista-dia.component';
import { PrevisaoRedeItemDiaComponent } from './previsao-rede-item-dia/previsao-rede-item-dia.component';
import { PeriodoTreinoRedeListaComponent } from './periodo-treino-rede-lista/periodo-treino-rede-lista.component';
import { PeriodoTreinoRedeEditaComponent } from './periodo-treino-rede-edita/periodo-treino-rede-edita.component';
import { TreinoRedeListaComponent } from './treino-rede-lista/treino-rede-lista.component';
import { TreinoRedeEditaComponent } from './treino-rede-edita/treino-rede-edita.component';
import { PrevisaoTreinoRedeItemDiaComponent } from './previsao-treino-rede-item-dia/previsao-treino-rede-item-dia.component';
import { ImobiliarioIntradayComponent } from './imobiliario-intraday/imobiliario-intraday.component';
import { GrupoRegraListaComponent } from './grupo-regra-lista/grupo-regra-lista.component';
import { GrupoRegraDetalheComponent } from './grupo-regra-detalhe/grupo-regra-detalhe.component';
import { GrupoRegraEditaComponent } from './grupo-regra-edita/grupo-regra-edita.component';
import { RendaFixaPrivadaMelhoresComponent } from './renda-fixa-privada-melhores/renda-fixa-privada-melhores.component';
import { EscolheRegraGrupoEditComponent } from './escolhe-regra-grupo-edit/escolhe-regra-grupo-edit.component';
import { GrupoRedeListaComponent } from './grupo-rede-lista/grupo-rede-lista.component';
import { GrupoRedeEditaComponent } from './grupo-rede-edita/grupo-rede-edita.component';
import { EscolheRedeGrupoEditComponent } from './escolhe-rede-grupo-edit/escolhe-rede-grupo-edit.component';
import { EmprestimoP2PListaComponent } from './emprestimo-p2-plista/emprestimo-p2-plista.component';
import { EmprestimoP2PEditaComponent } from './emprestimo-p2-pedita/emprestimo-p2-pedita.component';
import { TreinoGrupoListaComponent } from './treino-grupo-lista/treino-grupo-lista.component';
import { TreinoGrupoEditaComponent } from './treino-grupo-edita/treino-grupo-edita.component';
import { EmprestimoP2PDetalheComponent } from './emprestimo-p2-pdetalhe/emprestimo-p2-pdetalhe.component';
import { TreinoGrupoDetalheComponent } from './treino-grupo-detalhe/treino-grupo-detalhe.component';
import { ParcelaEmprestimoEditComponent } from './parcela-emprestimo-edit/parcela-emprestimo-edit.component';
import { EmprestimoP2PMesCorrenteComponent } from './emprestimo-p2-pmes-corrente/emprestimo-p2-pmes-corrente.component';
import { TradeAtivoComponent } from './trade-ativo/trade-ativo.component';
import { TreinoRedeGrupoEditaComponent } from './treino-rede-grupo-edita/treino-rede-grupo-edita.component';
import { TargetStopEditaComponent } from './target-stop-edita/target-stop-edita.component';
import { FundoImobiliarioCarteiraComponent } from './fundo-imobiliario-carteira/fundo-imobiliario-carteira.component';
import { FundoImobilarioCarteiraEditComponent } from './fundo-imobilario-carteira-edit/fundo-imobilario-carteira-edit.component';
import { MapaCalorGrupoTreinoComponent } from './mapa-calor-grupo-treino/mapa-calor-grupo-treino.component';


import { NgApexchartsModule } from 'ng-apexcharts';
//import { MatMomentDateModule, MAT_MOMENT_DATE_ADAPTER_OPTIONS } from '@angular/material-moment-adapter';


registerLocaleData(localePt, 'pt-BR');

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    HomeComponent,
    AtivoAcaoComponent,
    AtivoOpcaoComponent,
    AtivoMercadoriaComponent,
    AtivoImobiliarioComponent,
    AtivoAcaoEditaComponent,
    AtivoImobiliarioEditaComponent,
    AtivoMercadoriaEditaComponent,
    AtivoOpcaoEditaComponent,
    CotacaoIntraAcaoComponent,
    CotacaoIntraOpcaoComponent,
    CotacaoIntraMercadoriaComponent,
    CotacaoIntraImobiliarioComponent,
    TransformacaoListComponent,
    TransformacaoEditComponent,
    StartupEmpresaListComponent,
    StartupFundoListComponent,
    DataSetEditComponent,
    DataSetListComponent,
    DataSetAtributoEditComponent,
    DataSetAtributoListComponent,
    IdeiaExperimentoListComponent,
    IdeiaExperimentoEditComponent,
    StartupEmpresaEditComponent,
    StartupFundoEditComponent,
    StartupInvestimentoEditComponent,
    AtributoDataSetEditComponent,
    DataSetCreateSqlComponent,
    RegraSimulacaoListComponent,
    RegraSimulacaoEditComponent,
    ParametroRegraEditComponent,
    ExperimentoSimulacaoListComponent,
    ExperimentoSimulacaoEditComponent,
    ExperimentoParametroEditComponent,
    GrupoAcaoListComponent,
    GrupoAcaoEditComponent,
    EscolheAcaoGrupoEditComponent,
    CombinacaoListComponent,
    CotacaoIntradayAcaoMaisRecenteComponent,
    ExecucaoSimulacaoMelhoresResultadoComponent,
    TradeExecucaoSimulacaoComponent,
    ExecucaoSimulacaoMonitoradaComponent,
    ExecucaoSimulacaoDisplayComponent,
    ExecucaoSimulacaoPorExperimentoComponent,
    CotacaoDiarioAcaoComponent,
    CotacaoIntradayRecenteComponent,
    AcaoDetalheDiaComponent,
    ValorMonitoriaExecucaoComponent,
    TradeRealEditaComponent,
    TradeRealListaComponent,
    TradeRealListaEditComponent,
    OrdemCompraEditaComponent,
    OrdemCompraListaComponent,
    OrdemCompraListaEditaComponent,
    PeriodoExperimentoListaComponent,
    PeriodoExperimentoEditaComponent,
    EscolhePeriodoParaExperimentoComponent,
    FundoImobiliarioMelhoresComponent,
    ValorMonitoriaPeriodoTabelaComponent,
    ValorMonitoriaPeriodoComponent,
    ExecucaoSimulacaoMelhoresPeriodoComponent,
    MelhoresExecucaoPeriodoComponent,
    DescricaoFundoImobiliarioComponent,
    FundoImobiliarioAluguelMelhoresComponent,
    EscolhePeriodoCorrenteExperimentoComponent,
    TipoAplicacaoListComponent,
    TipoAplicacaoEditComponent,
    MelhoresValidacaoPeriodoComponent,
    AtivoIndiceComponent,
    AtivoIndiceEditaComponent,
    AtivoIntraIndiceComponent,
    AtivoAcaoResultadoFuturoComponent,
    PainelPeriodoValidacaoComponent,
    AlocacaoSaldoMesComponent,
    AlocacaoMovimentacaoComponent,
    AlocacaoSaldoMesEdicaoComponent,
    MovimentacaoEditaComponent,
    DetalheAluguelFundoImobiliarioComponent,
    AtivoCriptomoedaComponent,
    CotacaoIntraCriptomoedaComponent,
    RegraProjecaoListComponent,
    RegraProjecaoEditComponent,
    AtivoCriptomoedaFoxbitComponent,
    ValorMesSaldoListComponent,
    ValorMesSaldoEditComponent,
    AtivoCriptomoedaEditComponent,
    CotacaoIntraMercadoBitcoinComponent,
    PainelPatrimonioMesComponent,
    GraficoAlocacaoComponent,
    GraficoAlocacaoAporteComponent,
    RegraProjecaoDatasComponent,
    GrupoParaAcaoComponent,
    TradeRealVisualComponent,
    ItemTradeRealVisualComponent,
    PatrimonioEvolucaoMensalComponent,
    QuadroComparaStopComponent,
    ItemVisualIndiceComponent,
    QuadroComparaStopGeralComponent,
    QuadroComparaStopItemComponent,
    CotacaoIntradayResultadoAcaoComponent,
    ImobiliarioGeralComponent,
    ExemploIntradayResultadoAcaoComponent,
    ResumoTradeRealComponent,
    GraficoTradeMensalComponent,
    PontoEntradaSimulacaoDiaComponent,
    FundoImobiliarioMelhoresValorizacaoComponent,
    FundoImobiliarioMelhoresRendimentoComponent,
    TradeNovoSimulacaoComponent,
    FundoImobiliarioMelhorEstabilidadeComponent,
    PontoEntradaSimulacaoDiaVendaComponent,
    ExemploIntradayResultadoAcaoSaidaComponent,
    ExemploEntradaListaComponent,
    RedeNeuralListaComponent,
    RedeNeuralEditaComponent,
    ExemploSaidaResumoComponent,
    PrevisaoRedeListaDiaComponent,
    PrevisaoRedeItemDiaComponent,
    PeriodoTreinoRedeListaComponent,
    PeriodoTreinoRedeEditaComponent,
    TreinoRedeListaComponent,
    TreinoRedeEditaComponent,
    PrevisaoTreinoRedeItemDiaComponent,
    ImobiliarioIntradayComponent,
    GrupoRegraListaComponent,
    GrupoRegraDetalheComponent,
    GrupoRegraEditaComponent,
    RendaFixaPrivadaMelhoresComponent,
    EscolheRegraGrupoEditComponent,
    GrupoRedeListaComponent,
    GrupoRedeEditaComponent,
    EscolheRedeGrupoEditComponent,
    EmprestimoP2PListaComponent,
    EmprestimoP2PEditaComponent,
    TreinoGrupoListaComponent,
    TreinoGrupoEditaComponent,
    EmprestimoP2PDetalheComponent,
    TreinoGrupoDetalheComponent,
    ParcelaEmprestimoEditComponent,
    EmprestimoP2PMesCorrenteComponent,
    TradeAtivoComponent,
    TreinoRedeGrupoEditaComponent,
    TargetStopEditaComponent,
    FundoImobiliarioCarteiraComponent,
    FundoImobilarioCarteiraEditComponent,
    MapaCalorGrupoTreinoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule ,
    MatDialogModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    //NgxImgModule.forRoot(),
    FileDropModule,
    //UploadModule,
    ImageUploadModule.forRoot(),
    NgDragDropModule.forRoot(),
    SDKBrowserModule.forRoot(),
    MatExpansionModule,
    MatListModule,
    MatTabsModule,
    MatCardModule,
    MatIconModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatTableModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    FormsModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,

    //MatMomentDateModule,

    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    NgApexchartsModule
  ],
  providers: [
    AtivoAcaoApi,
    AtivoOpcaoApi,
    AtivoMercadoriaApi,
    AtivoImobiliarioApi,
    HttpClient, 
    SocketConnection  , 
    SocketDriver,
    SDKModels,
    LoopBackAuth,
    InternalStorage,
    MatNativeDateModule,
    //MatMomentDateModule,
    { provide: LOCALE_ID, useValue: 'pt-BR' } ,
    //{ provide: MAT_MOMENT_DATE_ADAPTER_OPTIONS, useValue: { useUtc: true } }
  ],
  entryComponents : [
    AtivoAcaoEditaComponent,
    AtivoOpcaoEditaComponent,
    AtivoMercadoriaEditaComponent,
    AtivoImobiliarioEditaComponent,
    DataSetEditComponent,
    StartupEmpresaEditComponent,
    StartupFundoEditComponent,
    AtributoDataSetEditComponent,
    StartupInvestimentoEditComponent,
    DataSetCreateSqlComponent,
    RegraSimulacaoEditComponent,
    ParametroRegraEditComponent,
    ExperimentoSimulacaoEditComponent,
    ExperimentoParametroEditComponent,
    GrupoAcaoEditComponent,
    EscolheAcaoGrupoEditComponent,
    TradeExecucaoSimulacaoComponent,
    TradeRealEditaComponent,
    TradeRealListaEditComponent,
    OrdemCompraEditaComponent,
    PeriodoExperimentoEditaComponent,
    OrdemCompraListaEditaComponent,
    EscolhePeriodoParaExperimentoComponent,
    DescricaoFundoImobiliarioComponent,
    EscolhePeriodoCorrenteExperimentoComponent,
    TipoAplicacaoEditComponent,
    AtivoIndiceEditaComponent,
    MovimentacaoEditaComponent,
    RegraProjecaoEditComponent,
    ValorMesSaldoEditComponent,
    GrupoParaAcaoComponent,
    DetalheAluguelFundoImobiliarioComponent,
    TradeNovoSimulacaoComponent,
    RedeNeuralEditaComponent,
    PeriodoTreinoRedeEditaComponent,
    TreinoRedeEditaComponent,
    GrupoRegraEditaComponent,
    EscolheRegraGrupoEditComponent,
    EmprestimoP2PEditaComponent,
    GrupoRedeEditaComponent,
    EscolheRedeGrupoEditComponent,
    TreinoGrupoEditaComponent,
    ParcelaEmprestimoEditComponent,
    TreinoRedeGrupoEditaComponent,
    TargetStopEditaComponent,
    FundoImobilarioCarteiraEditComponent,
    FundoImobiliarioCarteiraComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
