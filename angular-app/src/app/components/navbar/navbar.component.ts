import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  public online = false;

  handleMenu() {
    const menu = document.querySelector('#menu') as HTMLDivElement;
    const right = !!menu.style.right ? menu.style.right : '-20rem';

    menu.style.right = right === '0px' || right === '' ? '-20rem' : '0px';
  }
}
