/* tslint:disable */

declare var Object: any;
export interface RegraProjecaoHistInterface {
  "regraProjecaoId"?: number;
  "dataHoraAtual"?: Date;
  "dataHoraAcesso"?: Date;
  "diaNumMaisAntigo"?: number;
  "quantidadeTicker"?: number;
  "ultimaInsercao"?: Date;
  "exemploQuantidadeSaida"?: number;
  "exemploPercentualSaida"?: number;
  "exemploQuantidadeClasse0"?: number;
  "exemploPercentualClasse0"?: number;
  "exemploQuantidadeClasse1"?: number;
  "exemploPercentualClasse1"?: number;
  "exemploQuantidadeResultado"?: number;
  "exemploPercentualResultado"?: number;
  "maiorDataProcessamento"?: Date;
  "quantidadeValidada"?: number;
  "percentualValidado"?: number;
  "prioridade"?: number;
}

export class RegraProjecaoHist implements RegraProjecaoHistInterface {
  "regraProjecaoId": number;
  "dataHoraAtual": Date;
  "dataHoraAcesso": Date;
  "diaNumMaisAntigo": number;
  "quantidadeTicker": number;
  "ultimaInsercao": Date;
  "exemploQuantidadeSaida": number;
  "exemploPercentualSaida": number;
  "exemploQuantidadeClasse0": number;
  "exemploPercentualClasse0": number;
  "exemploQuantidadeClasse1": number;
  "exemploPercentualClasse1": number;
  "exemploQuantidadeResultado": number;
  "exemploPercentualResultado": number;
  "maiorDataProcessamento": Date;
  "quantidadeValidada": number;
  "percentualValidado": number;
  "prioridade": number;
  constructor(data?: RegraProjecaoHistInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RegraProjecaoHist`.
   */
  public static getModelName() {
    return "RegraProjecaoHist";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RegraProjecaoHist for dynamic purposes.
  **/
  public static factory(data: RegraProjecaoHistInterface): RegraProjecaoHist{
    return new RegraProjecaoHist(data);
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
      name: 'RegraProjecaoHist',
      plural: 'RegraProjecaoHists',
      path: 'RegraProjecaoHists',
      idName: 'regraProjecaoId',
      properties: {
        "regraProjecaoId": {
          name: 'regraProjecaoId',
          type: 'number'
        },
        "dataHoraAtual": {
          name: 'dataHoraAtual',
          type: 'Date'
        },
        "dataHoraAcesso": {
          name: 'dataHoraAcesso',
          type: 'Date'
        },
        "diaNumMaisAntigo": {
          name: 'diaNumMaisAntigo',
          type: 'number'
        },
        "quantidadeTicker": {
          name: 'quantidadeTicker',
          type: 'number'
        },
        "ultimaInsercao": {
          name: 'ultimaInsercao',
          type: 'Date'
        },
        "exemploQuantidadeSaida": {
          name: 'exemploQuantidadeSaida',
          type: 'number'
        },
        "exemploPercentualSaida": {
          name: 'exemploPercentualSaida',
          type: 'number'
        },
        "exemploQuantidadeClasse0": {
          name: 'exemploQuantidadeClasse0',
          type: 'number'
        },
        "exemploPercentualClasse0": {
          name: 'exemploPercentualClasse0',
          type: 'number'
        },
        "exemploQuantidadeClasse1": {
          name: 'exemploQuantidadeClasse1',
          type: 'number'
        },
        "exemploPercentualClasse1": {
          name: 'exemploPercentualClasse1',
          type: 'number'
        },
        "exemploQuantidadeResultado": {
          name: 'exemploQuantidadeResultado',
          type: 'number'
        },
        "exemploPercentualResultado": {
          name: 'exemploPercentualResultado',
          type: 'number'
        },
        "maiorDataProcessamento": {
          name: 'maiorDataProcessamento',
          type: 'Date'
        },
        "quantidadeValidada": {
          name: 'quantidadeValidada',
          type: 'number'
        },
        "percentualValidado": {
          name: 'percentualValidado',
          type: 'number'
        },
        "prioridade": {
          name: 'prioridade',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
