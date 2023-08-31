/* tslint:disable */

declare var Object: any;
export interface FundoImobiliarioCarteiraInterface {
  "ticker"?: string;
  "quantidade"?: number;
  "dataReferencia"?: Date;
  "cotacaoDataReferencia"?: number;
  "cotacaoAtual"?: number;
  "valorizacaoAtual"?: number;
  "valorTotalDataReferencia"?: number;
  "valorTotalAtual"?: number;
  "proventoPorUnidade"?: number;
  "proventoPercentual"?: number;
  "proventoTotal"?: number;
  "dataCotacaoAtual"?: Date;
  "percentualValorizacao"?: number;
  "saldoMes"?: number;
  "percentualSaldoMes"?: number;
  "percentualValorTotal"?: number;
  "percentualValorDataReferencia"?: number;
}

export class FundoImobiliarioCarteira implements FundoImobiliarioCarteiraInterface {
  "ticker": string;
  "quantidade": number;
  "dataReferencia": Date;
  "cotacaoDataReferencia": number;
  "cotacaoAtual": number;
  "valorizacaoAtual": number;
  "valorTotalDataReferencia": number;
  "valorTotalAtual": number;
  "proventoPorUnidade": number;
  "proventoPercentual": number;
  "proventoTotal": number;
  "dataCotacaoAtual": Date;
  "percentualValorizacao": number;
  "saldoMes": number;
  "percentualSaldoMes": number;
  "percentualValorTotal": number;
  "percentualValorDataReferencia": number;
  constructor(data?: FundoImobiliarioCarteiraInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `FundoImobiliarioCarteira`.
   */
  public static getModelName() {
    return "FundoImobiliarioCarteira";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of FundoImobiliarioCarteira for dynamic purposes.
  **/
  public static factory(data: FundoImobiliarioCarteiraInterface): FundoImobiliarioCarteira{
    return new FundoImobiliarioCarteira(data);
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
      name: 'FundoImobiliarioCarteira',
      plural: 'FundoImobiliarioCarteiras',
      path: 'FundoImobiliarioCarteiras',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "quantidade": {
          name: 'quantidade',
          type: 'number'
        },
        "dataReferencia": {
          name: 'dataReferencia',
          type: 'Date'
        },
        "cotacaoDataReferencia": {
          name: 'cotacaoDataReferencia',
          type: 'number'
        },
        "cotacaoAtual": {
          name: 'cotacaoAtual',
          type: 'number'
        },
        "valorizacaoAtual": {
          name: 'valorizacaoAtual',
          type: 'number'
        },
        "valorTotalDataReferencia": {
          name: 'valorTotalDataReferencia',
          type: 'number'
        },
        "valorTotalAtual": {
          name: 'valorTotalAtual',
          type: 'number'
        },
        "proventoPorUnidade": {
          name: 'proventoPorUnidade',
          type: 'number'
        },
        "proventoPercentual": {
          name: 'proventoPercentual',
          type: 'number'
        },
        "proventoTotal": {
          name: 'proventoTotal',
          type: 'number'
        },
        "dataCotacaoAtual": {
          name: 'dataCotacaoAtual',
          type: 'Date'
        },
        "percentualValorizacao": {
          name: 'percentualValorizacao',
          type: 'number'
        },
        "saldoMes": {
          name: 'saldoMes',
          type: 'number'
        },
        "percentualSaldoMes": {
          name: 'percentualSaldoMes',
          type: 'number'
        },
        "percentualValorTotal": {
          name: 'percentualValorTotal',
          type: 'number'
        },
        "percentualValorDataReferencia": {
          name: 'percentualValorDataReferencia',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
