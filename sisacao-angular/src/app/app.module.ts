import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

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
    AtivoOpcaoEditaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
