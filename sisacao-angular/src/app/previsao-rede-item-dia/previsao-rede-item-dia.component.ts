import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-previsao-rede-item-dia',
  templateUrl: './previsao-rede-item-dia.component.html',
  styleUrls: ['./previsao-rede-item-dia.component.css']
})
export class PrevisaoRedeItemDiaComponent implements OnInit {


  listaPrevisao: any[]
  @Input() rede: any;
  
  constructor() { }

  ngOnInit() {
    this.listaPrevisao = this.rede.previsaoRedes
  }

}
