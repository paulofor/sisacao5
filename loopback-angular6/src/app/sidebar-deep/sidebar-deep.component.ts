import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar-deep',
  templateUrl: './sidebar-deep.component.html',
  styleUrls: ['./sidebar-deep.component.scss']
})
export class SidebarDeepComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  // Variável para controlar o estado dos subitens
  submenuOpenStates: { [key: string]: boolean } = {};

  // Função para alternar a visibilidade do submenu
  toggleSubmenu(key: string) {
    this.submenuOpenStates[key] = !this.submenuOpenStates[key];
  }

  isSubmenuOpen(key: string) {
    return this.submenuOpenStates[key];
  }
}
