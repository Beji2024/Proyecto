import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes'; 
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor} from './interceptores/auth-interceptor.service'; 
export const providers = [
  {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }
];

export const appConfig = {
  providers: [
    provideRouter(routes),
  ]
}