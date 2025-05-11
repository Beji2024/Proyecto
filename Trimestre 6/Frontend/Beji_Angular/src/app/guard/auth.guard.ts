import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { isPlatformBrowser } from '@angular/common';
import { Inject, PLATFORM_ID } from '@angular/core';  

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router, @Inject(PLATFORM_ID) private platformId: Object) {}

  canActivate(): boolean {
    
    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('token');

    if (!token || this.isTokenExpired(token)) {
      this.router.navigate(['/login']);
      return false;
    }
  }
   
    return true;
  }

  private isTokenExpired(token:string):boolean{
    try{
      const payload= JSON.parse(atob(token.split('.')[1]));
      const expiration = payload.exp *1000;
      return Date.now () > expiration;
    }catch(e){
      return true;
    }
  }
}