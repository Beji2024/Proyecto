
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
<<<<<<< HEAD
import { AuthInterceptor } from './app/services/auth.interceptor';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
=======
import { AuthInterceptor} from './app/interceptores/auth-interceptor.service';
>>>>>>> 930e891ef29530aad4274fcaf5e8daaf494d8fce

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(withInterceptorsFromDi()),
    provideRouter(routes),
    importProvidersFrom(HttpClientModule),
    {provide: HTTP_INTERCEPTORS,useClass: AuthInterceptor,multi:true}
  ]
});