/* tslint:disable */
import {
  TipoAplicacao,
  InstituicaoFinanceira,
  DiaPregao
} from '../index';

declare var Object: any;
export interface FinanceiroAcaoDiaInterface {
  "diaNum"?: number;
  "tipoAplicacaoId"?: number;
  "instituicaoFinanceiraId"?: number;
  "valorTotalAtual"?: number;
  "valorFixoDia"?: number;
  "valorVariavelDia"?: number;
  "qtdeTradeAbertoCompra"?: number;
  "qtdeTradeAbertoVenda"?: number;
  "targetDia"?: number;
  "stopDia"?: number;
  "menorDistanciaTarget"?: number;
  "menorDistanciaStop"?: number;
  "qtdeDiaFaltandoMes"?: number;
  "qtdeDiaCorridoMes"?: number;
  "valorMetaMes1"?: number;
  "valorMetaMes2"?: number;
  "valorMetaMes3"?: number;
  "lucroMetaMes1"?: number;
  "lucroMetaMes2"?: number;
  "lucroMetaMes3"?: number;
  "lucroAtual"?: number;
  tipoAplicacao?: TipoAplicacao;
  instituicaoFinanceira?: InstituicaoFinanceira;
  diaPregao?: DiaPregao;
}

export class FinanceiroAcaoDia implements FinanceiroAcaoDiaInterface {
  "diaNum": number;
  "tipoAplicacaoId": number;
  "instituicaoFinanceiraId": number;
  "valorTotalAtual": number;
  "valorFixoDia": number;
  "valorVariavelDia": number;
  "qtdeTradeAbertoCompra": number;
  "qtdeTradeAbertoVenda": number;
  "targetDia": number;
  "stopDia": number;
  "menorDistanciaTarget": number;
  "menorDistanciaStop": number;
  "qtdeDiaFaltandoMes": number;
  "qtdeDiaCorridoMes": number;
  "valorMetaMes1": number;
  "valorMetaMes2": number;
  "valorMetaMes3": number;
  "lucroMetaMes1": number;
  "lucroMetaMes2": number;
  "lucroMetaMes3": number;
  "lucroAtual": number;
  tipoAplicacao: TipoAplicacao;
  instituicaoFinanceira: InstituicaoFinanceira;
  diaPregao: DiaPregao;
  constructor(data?: FinanceiroAcaoDiaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `FinanceiroAcaoDia`.
   */
  public static getModelName() {
    return "FinanceiroAcaoDia";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of FinanceiroAcaoDia for dynamic purposes.
  **/
  public static factory(data: FinanceiroAcaoDiaInterface): FinanceiroAcaoDia{
    return new FinanceiroAcaoDia(data);
  }
  /**
  * @method getModelDefinition
  * @author Julien Ledun
  * @license MIT
  * This method returns an object that represents some of the model
  * definitions.
  **/
  public static getModelDefinition() {
    return {
      name: 'FinanceiroAcaoDia',
      plural: 'FinanceiroAcaoDia',
      path: 'FinanceiroAcaoDia',
      idName: 'diaNum',
      properties: {
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "tipoAplicacaoId": {
          name: 'tipoAplicacaoId',
          type: 'number'
        },
        "instituicaoFinanceiraId": {
          name: 'instituicaoFinanceiraId',
          type: 'number'
        },
        "valorTotalAtual": {
          name: 'valorTotalAtual',
          type: 'number'
        },
        "valorFixoDia": {
          name: 'valorFixoDia',
          type: 'number'
        },
        "valorVariavelDia": {
          name: 'valorVariavelDia',
          type: 'number'
        },
        "qtdeTradeAbertoCompra": {
          name: 'qtdeTradeAbertoCompra',
          type: 'number'
        },
        "qtdeTradeAbertoVenda": {
          name: 'qtdeTradeAbertoVenda',
          type: 'number'
        },
        "targetDia": {
          name: 'targetDia',
          type: 'number'
        },
        "stopDia": {
          name: 'stopDia',
          type: 'number'
        },
        "menorDistanciaTarget": {
          name: 'menorDistanciaTarget',
          type: 'number'
        },
        "menorDistanciaStop": {
          name: 'menorDistanciaStop',
          type: 'number'
        },
        "qtdeDiaFaltandoMes": {
          name: 'qtdeDiaFaltandoMes',
          type: 'number'
        },
        "qtdeDiaCorridoMes": {
          name: 'qtdeDiaCorridoMes',
          type: 'number'
        },
        "valorMetaMes1": {
          name: 'valorMetaMes1',
          type: 'number'
        },
        "valorMetaMes2": {
          name: 'valorMetaMes2',
          type: 'number'
        },
        "valorMetaMes3": {
          name: 'valorMetaMes3',
          type: 'number'
        },
        "lucroMetaMes1": {
          name: 'lucroMetaMes1',
          type: 'number'
        },
        "lucroMetaMes2": {
          name: 'lucroMetaMes2',
          type: 'number'
        },
        "lucroMetaMes3": {
          name: 'lucroMetaMes3',
          type: 'number'
        },
        "lucroAtual": {
          name: 'lucroAtual',
          type: 'number'
        },
      },
      relations: {
        tipoAplicacao: {
          name: 'tipoAplicacao',
          type: 'TipoAplicacao',
          model: 'TipoAplicacao',
          relationType: 'belongsTo',
                  keyFrom: 'tipoAplicacaoId',
          keyTo: 'id'
        },
        instituicaoFinanceira: {
          name: 'instituicaoFinanceira',
          type: 'InstituicaoFinanceira',
          model: 'InstituicaoFinanceira',
          relationType: 'belongsTo',
                  keyFrom: 'instituicaoFinanceiraId',
          keyTo: 'id'
        },
        diaPregao: {
          name: 'diaPregao',
          type: 'DiaPregao',
          model: 'DiaPregao',
          relationType: 'belongsTo',
                  keyFrom: 'diaNum',
          keyTo: 'diaNum'
        },
      }
    }
  }
}
