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
import { DataSourceListComponent } from '../data-source-list/data-source-list.component';

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

    { path: 'dataSource' , component: DataSourceListComponent},

    { path: '',          redirectTo: 'home', pathMatch: 'full' }
]