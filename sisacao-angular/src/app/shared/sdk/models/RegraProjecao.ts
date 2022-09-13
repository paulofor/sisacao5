/* tslint:disable */
import {
  CotacaoIntradayAcaoResultadoValor,
  RegraProjecaoTotalMes,
  TreinoRede,
  GrupoRegraRel
} from '../index';

declare var Object: any;
export interface RegraProjecaoInterface {
  "tipoCompraVenda"?: string;
  "target"?: number;
  "stop"?: number;
  "diaLimite"?: number;
  "processando"?: number;
  "indiceHoraReferenciaDataset"?: number;
  "percentualEntradaDataset"?: number;
  "codigoRegraProjecao"?: string;
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
  "id"?: number;
  cotacaoIntradayAcaoResultadoValors?: CotacaoIntradayAcaoResultadoValor[];
  regraProjecaoTotalMes?: RegraProjecaoTotalMes[];
  treinoRedes?: TreinoRede[];
  grupoRegraRels?: GrupoRegraRel[];
}

export class RegraProjecao implements RegraProjecaoInterface {
  "tipoCompraVenda": string;
  "target": number;
  "stop": number;
  "diaLimite": number;
  "processando": number;
  "indiceHoraReferenciaDataset": number;
  "percentualEntradaDataset": number;
  "codigoRegraProjecao": string;
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
  "id": number;
  cotacaoIntradayAcaoResultadoValors: CotacaoIntradayAcaoResultadoValor[];
  regraProjecaoTotalMes: RegraProjecaoTotalMes[];
  treinoRedes: TreinoRede[];
  grupoRegraRels: GrupoRegraRel[];
  constructor(data?: RegraProjecaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RegraProjecao`.
   */
  public static getModelName() {
    return "RegraProjecao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RegraProjecao for dynamic purposes.
  **/
  public static factory(data: RegraProjecaoInterface): RegraProjecao{
    return new RegraProjecao(data);
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
      name: 'RegraProjecao',
      plural: 'RegraProjecaos',
      path: 'RegraProjecaos',
      idName: 'id',
      properties: {
        "tipoCompraVenda": {
          name: 'tipoCompraVenda',
          type: 'string'
        },
        "target": {
          name: 'target',
          type: 'number'
        },
        "stop": {
          name: 'stop',
          type: 'number'
        },
        "diaLimite": {
          name: 'diaLimite',
          type: 'number'
        },
        "processando": {
          name: 'processando',
          type: 'number'
        },
        "indiceHoraReferenciaDataset": {
          name: 'indiceHoraReferenciaDataset',
          type: 'number'
        },
        "percentualEntradaDataset": {
          name: 'percentualEntradaDataset',
          type: 'number'
        },
        "codigoRegraProjecao": {
          name: 'codigoRegraProjecao',
          type: 'string'
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
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        cotacaoIntradayAcaoResultadoValors: {
          name: 'cotacaoIntradayAcaoResultadoValors',
          type: 'CotacaoIntradayAcaoResultadoValor[]',
          model: 'CotacaoIntradayAcaoResultadoValor',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'regraProjecaoId'
        },
        regraProjecaoTotalMes: {
          name: 'regraProjecaoTotalMes',
          type: 'RegraProjecaoTotalMes[]',
          model: 'RegraProjecaoTotalMes',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'regraProjecaoId'
        },
        treinoRedes: {
          name: 'treinoRedes',
          type: 'TreinoRede[]',
          model: 'TreinoRede',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'regraProjecaoId'
        },
        grupoRegraRels: {
          name: 'grupoRegraRels',
          type: 'GrupoRegraRel[]',
          model: 'GrupoRegraRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'regraProjecaoId'
        },
      }
    }
  }
}
