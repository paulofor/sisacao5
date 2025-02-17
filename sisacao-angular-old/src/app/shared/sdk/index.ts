/* tslint:disable */
/**
* @module SDKModule
* @author Jonathan Casarrubias <t:@johncasarrubias> <gh:jonathan-casarrubias>
* @license MIT 2016 Jonathan Casarrubias
* @version 2.1.0
* @description
* The SDKModule is a generated Software Development Kit automatically built by
* the LoopBack SDK Builder open source module.
*
* The SDKModule provides Angular 2 >= RC.5 support, which means that NgModules
* can import this Software Development Kit as follows:
*
*
* APP Route Module Context
* ============================================================================
* import { NgModule }       from '@angular/core';
* import { BrowserModule }  from '@angular/platform-browser';
* // App Root 
* import { AppComponent }   from './app.component';
* // Feature Modules
* import { SDK[Browser|Node|Native]Module } from './shared/sdk/sdk.module';
* // Import Routing
* import { routing }        from './app.routing';
* @NgModule({
*  imports: [
*    BrowserModule,
*    routing,
*    SDK[Browser|Node|Native]Module.forRoot()
*  ],
*  declarations: [ AppComponent ],
*  bootstrap:    [ AppComponent ]
* })
* export class AppModule { }
*
**/
import { ErrorHandler } from './services/core/error.service';
import { LoopBackAuth } from './services/core/auth.service';
import { LoggerService } from './services/custom/logger.service';
import { SDKModels } from './services/custom/SDKModels';
import { InternalStorage, SDKStorage } from './storage/storage.swaps';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { CookieBrowser } from './storage/cookie.browser';
import { StorageBrowser } from './storage/storage.browser';
import { SocketBrowser } from './sockets/socket.browser';

import { SocketConnection } from './sockets/socket.connections';
import { RealTime } from './services/core/real.time';
import { UserApi } from './services/custom/User';
import { AtivoApi } from './services/custom/Ativo';
import { AtivoOpcaoApi } from './services/custom/AtivoOpcao';
import { AtivoAcaoApi } from './services/custom/AtivoAcao';
import { AtivoMercadoriaApi } from './services/custom/AtivoMercadoria';
import { AtivoImobiliarioApi } from './services/custom/AtivoImobiliario';
import { CotacaoIntradayOpcaoApi } from './services/custom/CotacaoIntradayOpcao';
import { CotacaoIntradayAcaoApi } from './services/custom/CotacaoIntradayAcao';
import { CotacaoIntradayImobiliarioApi } from './services/custom/CotacaoIntradayImobiliario';
import { CotacaoIntradayMercadoriaApi } from './services/custom/CotacaoIntradayMercadoria';
import { DataSetApi } from './services/custom/DataSet';
import { AtributoDataSetApi } from './services/custom/AtributoDataSet';
import { StartupFundoApi } from './services/custom/StartupFundo';
import { StartupEmpresaApi } from './services/custom/StartupEmpresa';
import { StartupInvestimentoApi } from './services/custom/StartupInvestimento';
import { IdeiaExperimentoApi } from './services/custom/IdeiaExperimento';
import { DiaPregaoApi } from './services/custom/DiaPregao';
import { RegraSimulacaoApi } from './services/custom/RegraSimulacao';
import { ParametroRegraApi } from './services/custom/ParametroRegra';
import { ExperimentoSimulacaoApi } from './services/custom/ExperimentoSimulacao';
import { ExperimentoParametroApi } from './services/custom/ExperimentoParametro';
import { ExperimentoAcaoApi } from './services/custom/ExperimentoAcao';
import { GrupoAcaoApi } from './services/custom/GrupoAcao';
import { RelGrupoAcaoApi } from './services/custom/RelGrupoAcao';
import { CotacaoDiarioAcaoApi } from './services/custom/CotacaoDiarioAcao';
import { CombinacaoParametroApi } from './services/custom/CombinacaoParametro';
import { ValorParametroApi } from './services/custom/ValorParametro';
import { ExecucaoSimulacaoApi } from './services/custom/ExecucaoSimulacao';
import { TradeApi } from './services/custom/Trade';
import { ValorMonitoriaApi } from './services/custom/ValorMonitoria';
import { TradeRealApi } from './services/custom/TradeReal';
import { PeriodoExperimentoApi } from './services/custom/PeriodoExperimento';
import { OrdemCompraApi } from './services/custom/OrdemCompra';
import { ExperimentoSimulacaoPeriodoApi } from './services/custom/ExperimentoSimulacaoPeriodo';
import { FundoImobiliarioApi } from './services/custom/FundoImobiliario';
import { CDBApi } from './services/custom/CDB';
import { RendaFixaApi } from './services/custom/RendaFixa';
import { AluguelFundoImobiliarioApi } from './services/custom/AluguelFundoImobiliario';
import { TipoAplicacaoApi } from './services/custom/TipoAplicacao';
import { InstituicaoFinanceiraApi } from './services/custom/InstituicaoFinanceira';
import { AtivoIndiceApi } from './services/custom/AtivoIndice';
import { CotacaoIntradayIndiceApi } from './services/custom/CotacaoIntradayIndice';
import { ExecucaoSimulacaoValidacaoApi } from './services/custom/ExecucaoSimulacaoValidacao';
import { CotacaoIntradayAcaoResultadoApi } from './services/custom/CotacaoIntradayAcaoResultado';
import { CotacaoDiarioIndiceApi } from './services/custom/CotacaoDiarioIndice';
import { AplicacaoInstituicaoApi } from './services/custom/AplicacaoInstituicao';
import { AtivoCriptomoedaApi } from './services/custom/AtivoCriptomoeda';
import { CotacaoIntradayMercadoBitcoinApi } from './services/custom/CotacaoIntradayMercadoBitcoin';
import { MovimentacaoValorAplicadoApi } from './services/custom/MovimentacaoValorAplicado';
import { ValorMesInstituicaoTipoApi } from './services/custom/ValorMesInstituicaoTipo';
import { RegraProjecaoApi } from './services/custom/RegraProjecao';
import { CotacaoIntradayAcaoResultadoValorApi } from './services/custom/CotacaoIntradayAcaoResultadoValor';
import { ExecucaoSimulacaoMelhoresValidacaoApi } from './services/custom/ExecucaoSimulacaoMelhoresValidacao';
import { CotacaoIntradayFoxbitApi } from './services/custom/CotacaoIntradayFoxbit';
import { DatasetAcaoApi } from './services/custom/DatasetAcao';
import { ExemploTreinoAcaoApi } from './services/custom/ExemploTreinoAcao';
import { RegraProjecaoTotalMesApi } from './services/custom/RegraProjecaoTotalMes';
import { PontoEntradaTradeApi } from './services/custom/PontoEntradaTrade';
import { PontoEntradaSimulacaoApi } from './services/custom/PontoEntradaSimulacao';
import { ExemploTreinoAcaoEntradaApi } from './services/custom/ExemploTreinoAcaoEntrada';
import { ExemploTreinoAcaoSaidaApi } from './services/custom/ExemploTreinoAcaoSaida';
import { PrevisaoRedeApi } from './services/custom/PrevisaoRede';
import { RedeNeuralApi } from './services/custom/RedeNeural';
import { PeriodoTreinoRedeApi } from './services/custom/PeriodoTreinoRede';
import { TipoExemploTreinoApi } from './services/custom/TipoExemploTreino';
import { TreinoRedeApi } from './services/custom/TreinoRede';
import { RendaFixaPrivadaApi } from './services/custom/RendaFixaPrivada';
import { PrevisaoTesteApi } from './services/custom/PrevisaoTeste';
import { GrupoRegraApi } from './services/custom/GrupoRegra';
import { GrupoRegraRelApi } from './services/custom/GrupoRegraRel';
import { EmprestimoP2PApi } from './services/custom/EmprestimoP2P';
import { ParcelaEmprestimoApi } from './services/custom/ParcelaEmprestimo';
import { GrupoRedeApi } from './services/custom/GrupoRede';
import { GrupoRedeRelApi } from './services/custom/GrupoRedeRel';
import { TreinoGrupoRedeApi } from './services/custom/TreinoGrupoRede';
import { FundoImobiliarioCarteiraApi } from './services/custom/FundoImobiliarioCarteira';
import { TradeTreinoRedeApi } from './services/custom/TradeTreinoRede';
import { TesouroDiretoApi } from './services/custom/TesouroDireto';
import { TesouroDiretoCotacaoApi } from './services/custom/TesouroDiretoCotacao';
import { IndicadorRedeApi } from './services/custom/IndicadorRede';
import { TipoAplicacaoSaldoMesApi } from './services/custom/TipoAplicacaoSaldoMes';
/**
* @module SDKBrowserModule
* @description
* This module should be imported when building a Web Application in the following scenarios:
*
*  1.- Regular web application
*  2.- Angular universal application (Browser Portion)
*  3.- Progressive applications (Angular Mobile, Ionic, WebViews, etc)
**/
@NgModule({
  imports:      [ CommonModule, HttpClientModule ],
  declarations: [ ],
  exports:      [ ],
  providers:    [
    ErrorHandler,
    SocketConnection
  ]
})
export class SDKBrowserModule {
  static forRoot(internalStorageProvider: any = {
    provide: InternalStorage,
    useClass: CookieBrowser
  }): ModuleWithProviders {
    return {
      ngModule  : SDKBrowserModule,
      providers : [
        LoopBackAuth,
        LoggerService,
        SDKModels,
        RealTime,
        UserApi,
        AtivoApi,
        AtivoOpcaoApi,
        AtivoAcaoApi,
        AtivoMercadoriaApi,
        AtivoImobiliarioApi,
        CotacaoIntradayOpcaoApi,
        CotacaoIntradayAcaoApi,
        CotacaoIntradayImobiliarioApi,
        CotacaoIntradayMercadoriaApi,
        DataSetApi,
        AtributoDataSetApi,
        StartupFundoApi,
        StartupEmpresaApi,
        StartupInvestimentoApi,
        IdeiaExperimentoApi,
        DiaPregaoApi,
        RegraSimulacaoApi,
        ParametroRegraApi,
        ExperimentoSimulacaoApi,
        ExperimentoParametroApi,
        ExperimentoAcaoApi,
        GrupoAcaoApi,
        RelGrupoAcaoApi,
        CotacaoDiarioAcaoApi,
        CombinacaoParametroApi,
        ValorParametroApi,
        ExecucaoSimulacaoApi,
        TradeApi,
        ValorMonitoriaApi,
        TradeRealApi,
        PeriodoExperimentoApi,
        OrdemCompraApi,
        ExperimentoSimulacaoPeriodoApi,
        FundoImobiliarioApi,
        CDBApi,
        RendaFixaApi,
        AluguelFundoImobiliarioApi,
        TipoAplicacaoApi,
        InstituicaoFinanceiraApi,
        AtivoIndiceApi,
        CotacaoIntradayIndiceApi,
        ExecucaoSimulacaoValidacaoApi,
        CotacaoIntradayAcaoResultadoApi,
        CotacaoDiarioIndiceApi,
        AplicacaoInstituicaoApi,
        AtivoCriptomoedaApi,
        CotacaoIntradayMercadoBitcoinApi,
        MovimentacaoValorAplicadoApi,
        ValorMesInstituicaoTipoApi,
        RegraProjecaoApi,
        CotacaoIntradayAcaoResultadoValorApi,
        ExecucaoSimulacaoMelhoresValidacaoApi,
        CotacaoIntradayFoxbitApi,
        DatasetAcaoApi,
        ExemploTreinoAcaoApi,
        RegraProjecaoTotalMesApi,
        PontoEntradaTradeApi,
        PontoEntradaSimulacaoApi,
        ExemploTreinoAcaoEntradaApi,
        ExemploTreinoAcaoSaidaApi,
        PrevisaoRedeApi,
        RedeNeuralApi,
        PeriodoTreinoRedeApi,
        TipoExemploTreinoApi,
        TreinoRedeApi,
        RendaFixaPrivadaApi,
        PrevisaoTesteApi,
        GrupoRegraApi,
        GrupoRegraRelApi,
        EmprestimoP2PApi,
        ParcelaEmprestimoApi,
        GrupoRedeApi,
        GrupoRedeRelApi,
        TreinoGrupoRedeApi,
        FundoImobiliarioCarteiraApi,
        TradeTreinoRedeApi,
        TesouroDiretoApi,
        TesouroDiretoCotacaoApi,
        IndicadorRedeApi,
        TipoAplicacaoSaldoMesApi,
        internalStorageProvider,
        { provide: SDKStorage, useClass: StorageBrowser }
      ]
    };
  }
}
/**
* Have Fun!!!
* - Jon
**/
export * from './models/index';
export * from './services/index';
export * from './lb.config';
export * from './storage/storage.swaps';
export { CookieBrowser } from './storage/cookie.browser';
export { StorageBrowser } from './storage/storage.browser';

