/* tslint:disable */
import {
  TipoAplicacao
} from '../index';

declare var Object: any;
export interface TipoAplicacaoSaldoMesInterface {
  "diaNumReferencia"?: number;
  "tipoAplicacaoId"?: number;
  "saldoAtual"?: number;
  "saldoAnterior"?: number;
  "percentual"?: number;
  "saldoProjetado"?: number;
  "movimentacaoMes"?: number;
  "percentualProjetado"?: number;
  "dataReferencia"?: string;
  "lucroPrejuizoMes"?: number;
  tipoAplicacao?: TipoAplicacao;
}

export class TipoAplicacaoSaldoMes implements TipoAplicacaoSaldoMesInterface {
  "diaNumReferencia": number;
  "tipoAplicacaoId": number;
  "saldoAtual": number;
  "saldoAnterior": number;
  "percentual": number;
  "saldoProjetado": number;
  "movimentacaoMes": number;
  "percentualProjetado": number;
  "dataReferencia": string;
  "lucroPrejuizoMes": number;
  tipoAplicacao: TipoAplicacao;
  constructor(data?: TipoAplicacaoSaldoMesInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TipoAplicacaoSaldoMes`.
   */
  public static getModelName() {
    return "TipoAplicacaoSaldoMes";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TipoAplicacaoSaldoMes for dynamic purposes.
  **/
  public static factory(data: TipoAplicacaoSaldoMesInterface): TipoAplicacaoSaldoMes{
    return new TipoAplicacaoSaldoMes(data);
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
      name: 'TipoAplicacaoSaldoMes',
      plural: 'TipoAplicacaoSaldoMes',
      path: 'TipoAplicacaoSaldoMes',
      idName: 'diaNumReferencia',
      properties: {
        "diaNumReferencia": {
          name: 'diaNumReferencia',
          type: 'number'
        },
        "tipoAplicacaoId": {
          name: 'tipoAplicacaoId',
          type: 'number'
        },
        "saldoAtual": {
          name: 'saldoAtual',
          type: 'number'
        },
        "saldoAnterior": {
          name: 'saldoAnterior',
          type: 'number'
        },
        "percentual": {
          name: 'percentual',
          type: 'number'
        },
        "saldoProjetado": {
          name: 'saldoProjetado',
          type: 'number'
        },
        "movimentacaoMes": {
          name: 'movimentacaoMes',
          type: 'number'
        },
        "percentualProjetado": {
          name: 'percentualProjetado',
          type: 'number'
        },
        "dataReferencia": {
          name: 'dataReferencia',
          type: 'string'
        },
        "lucroPrejuizoMes": {
          name: 'lucroPrejuizoMes',
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
      }
    }
  }
}
