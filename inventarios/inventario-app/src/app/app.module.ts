import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { ProductoListaComponent } from './producto-lista/producto-lista.component';
import { CommonModule } from '@angular/common';
import { AgregarProductoComponent } from './agregar-producto/agregar-producto.component';
import { FormsModule } from '@angular/forms';
import { EditarProductoComponent } from './editar-producto/editar-producto.component';

@NgModule({
  declarations: [
    
    AppComponent,
          AgregarProductoComponent,
          EditarProductoComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ProductoListaComponent // Importas el componente independiente

  ],
  providers: [
    provideHttpClient(withFetch())
    //provideClientHydration(withEventReplay())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
