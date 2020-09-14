import { Routes } from '@angular/router';


import { HomeComponent } from '../home/home.component';
import { AtivoAcaoComponent } from '../ativo-acao/ativo-acao.component';
import { AtivoOpcaoComponent } from '../ativo-opcao/ativo-opcao.component';
import { AtivoMercadoriaComponent } from '../ativo-mercadoria/ativo-mercadoria.component';
import { AtivoImobiliarioComponent } from '../ativo-imobiliario/ativo-imobiliario.component';

export const routes : Routes = [
    { path: 'home' , component: HomeComponent },

    { path: 'ativoAcao' , component: AtivoAcaoComponent},
    { path: 'ativoOpcao' , component: AtivoOpcaoComponent},
    { path: 'ativoMercadoria' , component: AtivoMercadoriaComponent},
    { path: 'ativoImobiliario' , component: AtivoImobiliarioComponent},

    { path: '',          redirectTo: 'home', pathMatch: 'full' }
]