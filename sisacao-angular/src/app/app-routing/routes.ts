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

export const routes : Routes = [
    { path: 'home' , component: HomeComponent },

    { path: 'ativoAcao' , component: AtivoAcaoComponent},
    { path: 'ativoOpcao' , component: AtivoOpcaoComponent},
    { path: 'ativoMercadoria' , component: AtivoMercadoriaComponent},
    { path: 'ativoImobiliario' , component: AtivoImobiliarioComponent},

    { path: 'cotacaoIntraAcao/:id' , component: CotacaoIntraAcaoComponent},
    { path: 'cotacaoIntraOpcao/:id' , component: CotacaoIntraOpcaoComponent},
    { path: 'cotacaoIntraMercadoria/:id' , component: CotacaoIntraMercadoriaComponent},
    { path: 'cotacaoIntraImobiliario/:id' , component: CotacaoIntraImobiliarioComponent},

    { path: 'dataSet' , component: DataSetListComponent},

    { path : 'startupEmpresa' , component: StartupEmpresaListComponent },
    { path : 'startupFundo' , component: StartupFundoListComponent },

    { path : 'regraSimulacao' , component: RegraSimulacaoListComponent },
    { path : 'experimentoSimulacao' , component: ExperimentoSimulacaoListComponent },

    { path: '',          redirectTo: 'home', pathMatch: 'full' }
]