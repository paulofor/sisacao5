import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CotacaoIntradayOpcao, ExecucaoSimulacao, ExecucaoSimulacaoApi, ValorMonitoria, ValorMonitoriaApi } from '../shared/sdk';

@Component({
  selector: 'app-valor-monitoria-execucao',
  templateUrl: './valor-monitoria-execucao.component.html',
  styleUrls: ['./valor-monitoria-execucao.component.css']
})
export class ValorMonitoriaExecucaoComponent implements OnInit {

  listaBase: ValorMonitoria[];
  execucao: ExecucaoSimulacao;

  constructor(private router: ActivatedRoute, private srvExecucao:ExecucaoSimulacaoApi, 
      private srv:ValorMonitoriaApi) { }

  ngOnInit() {
    this.carregaDados();
  }

  carregaDados() {
    this.router.params.subscribe((params) => {
      let idExecuao = params['id'];
      this.srvExecucao.findById(idExecuao)
        .subscribe((result:ExecucaoSimulacao) => {
          this.execucao = result;
          this.srv.TrataSituacao(idExecuao)
            .subscribe((result:any) => {
              this.listaBase = result;
              console.log('ListaBase: ' , this.listaBase)
            })
        })
    })
  }

  classeAlerta(item) {
    let saida = ''
    if (item.valorEntrada >= item.minimo && item.valorEntrada <= item.maximo) {
      saida = 'dgc-alerta'
    } 
    return saida;
  }

  complementoPreco(item) {
    let saida = '';
    if (item.valorEntrada >= item.minimo && item.valorEntrada <= item.maximo) {
      let target =  item.valorEntrada * (1+this.execucao.target)
      let stop = item.valorEntrada * (1-this.execucao.stop)
      saida = '   t=' + target.toFixed(2) + '  s=' + stop.toFixed(2) ;
    } 
    return saida;
  }

}
