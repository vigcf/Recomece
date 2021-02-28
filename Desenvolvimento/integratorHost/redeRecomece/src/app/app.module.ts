import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule } from '@angular/common/http'// importe feito na mão
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HashLocationStrategy, LocationStrategy} from '@angular/common'

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { EquipeComponent } from './equipe/equipe.component';
import { TemaComponent } from './tema/tema.component';
import { TemaEditComponent } from './edit/tema-edit/tema-edit.component';
import { TemaDeleteComponent } from './delete/tema-delete/tema-delete.component';
import { PostagemComponent } from './postagem/postagem.component';
import { TopbarComponent } from './topbar/topbar.component';
import { CarreiraComponent } from './carreira/carreira.component';
import { PostagemEditComponent } from './edit/postagem-edit/postagem-edit.component';
import { FooterComponent } from './footer/footer.component';
import { PostagemDeleteComponent } from './delete/postagem-delete/postagem-delete.component';
import { OngsComponent } from './ongs/ongs.component';
import { PerfilComponent } from './perfil/perfil.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    RodapeComponent,
    EquipeComponent,
    PostagemComponent,
    TemaComponent,
    TemaEditComponent,
    TemaDeleteComponent,
    PostagemComponent,
    TopbarComponent,
    CarreiraComponent,
    PostagemEditComponent,
    FooterComponent,
    PostagemDeleteComponent,
    OngsComponent,
    PerfilComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{
    provide: LocationStrategy,
    useClass: HashLocationStrategy
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
