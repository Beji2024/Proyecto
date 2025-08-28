import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms'; // <-- IMPORTANTE
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from '../../../../app.component';
import { RegproveedoresComponent } from './regproveedores.component';

@NgModule({
  declarations: [
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule, // <-- IMPORTANTE
    HttpClientModule,
    RegproveedoresComponent
  ],
})
export class AppModule { }
