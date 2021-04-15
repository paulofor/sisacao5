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
    EscolhePeriodoParaExperimentoComponent
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
    { provide: LOCALE_ID, useValue: 'pt-BR' } 

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
    EscolhePeriodoParaExperimentoComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
