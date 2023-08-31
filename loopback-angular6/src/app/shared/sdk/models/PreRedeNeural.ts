/* tslint:disable */
import {
  TipoExemploTreino,
  PeriodoTreinoRede,
  GrupoAcao,
  RegraProjecao,
  VersaoPreRede
} from '../index';

declare var Object: any;
export interface PreRedeNeuralInterface {
  "nome"?: string;
  "conceito"?: string;
  "dataCriacao"?: Date;
  "finalizada"?: number;
  "comIbovespa"?: number;
  "geraScriptTreino"?: number;
  "id"?: number;
  "tipoExemploTreino1Id"?: number;
  "tipoExemploTreino2Id"?: number;
  "periodoTreinoRedeId"?: number;
  "grupoAcaoId"?: number;
  "regraProjecaoVenda1Id"?: number;
  "regraProjecaoVenda2Id"?: number;
  "regraProjecaoVenda3Id"?: number;
  "regraProjecaoCompra1Id"?: number;
  "regraProjecaoCompra2Id"?: number;
  "regraProjecaoCompra3Id"?: number;
  tipoExemploTreino1?: TipoExemploTreino;
  tipoExemploTreino2?: TipoExemploTreino;
  periodoTreinoRede?: PeriodoTreinoRede;
  grupoAcao?: GrupoAcao;
  regraProjecaoVenda1?: RegraProjecao;
  regraProjecaoVenda2?: RegraProjecao;
  regraProjecaoVenda3?: RegraProjecao;
  regraProjecaoCompra1?: RegraProjecao;
  regraProjecaoCompra2?: RegraProjecao;
  regraProjecaoCompra3?: RegraProjecao;
  versaoPreRedes?: VersaoPreRede[];
}

export class PreRedeNeural implements PreRedeNeuralInterface {
  "nome": string;
  "conceito": string;
  "dataCriacao": Date;
  "finalizada": number;
  "comIbovespa": number;
  "geraScriptTreino": number;
  "id": number;
  "tipoExemploTreino1Id": number;
  "tipoExemploTreino2Id": number;
  "periodoTreinoRedeId": number;
  "grupoAcaoId": number;
  "regraProjecaoVenda1Id": number;
  "regraProjecaoVenda2Id": number;
  "regraProjecaoVenda3Id": number;
  "regraProjecaoCompra1Id": number;
  "regraProjecaoCompra2Id": number;
  "regraProjecaoCompra3Id": number;
  tipoExemploTreino1: TipoExemploTreino;
  tipoExemploTreino2: TipoExemploTreino;
  periodoTreinoRede: PeriodoTreinoRede;
  grupoAcao: GrupoAcao;
  regraProjecaoVenda1: RegraProjecao;
  regraProjecaoVenda2: RegraProjecao;
  regraProjecaoVenda3: RegraProjecao;
  regraProjecaoCompra1: RegraProjecao;
  regraProjecaoCompra2: RegraProjecao;
  regraProjecaoCompra3: RegraProjecao;
  versaoPreRedes: VersaoPreRede[];
  constructor(data?: PreRedeNeuralInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PreRedeNeural`.
   */
  public static getModelName() {
    return "PreRedeNeural";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PreRedeNeural for dynamic purposes.
  **/
  public static factory(data: PreRedeNeuralInterface): PreRedeNeural{
    return new PreRedeNeural(data);
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
      name: 'PreRedeNeural',
      plural: 'PreRedeNeurals',
      path: 'PreRedeNeurals',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "conceito": {
          name: 'conceito',
          type: 'string'
        },
        "dataCriacao": {
          name: 'dataCriacao',
          type: 'Date'
        },
        "finalizada": {
          name: 'finalizada',
          type: 'number'
        },
        "comIbovespa": {
          name: 'comIbovespa',
          type: 'number'
        },
        "geraScriptTreino": {
          name: 'geraScriptTreino',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "tipoExemploTreino1Id": {
          name: 'tipoExemploTreino1Id',
          type: 'number'
        },
        "tipoExemploTreino2Id": {
          name: 'tipoExemploTreino2Id',
          type: 'number'
        },
        "periodoTreinoRedeId": {
          name: 'periodoTreinoRedeId',
          type: 'number'
        },
        "grupoAcaoId": {
          name: 'grupoAcaoId',
          type: 'number'
        },
        "regraProjecaoVenda1Id": {
          name: 'regraProjecaoVenda1Id',
          type: 'number'
        },
        "regraProjecaoVenda2Id": {
          name: 'regraProjecaoVenda2Id',
          type: 'number'
        },
        "regraProjecaoVenda3Id": {
          name: 'regraProjecaoVenda3Id',
          type: 'number'
        },
        "regraProjecaoCompra1Id": {
          name: 'regraProjecaoCompra1Id',
          type: 'number'
        },
        "regraProjecaoCompra2Id": {
          name: 'regraProjecaoCompra2Id',
          type: 'number'
        },
        "regraProjecaoCompra3Id": {
          name: 'regraProjecaoCompra3Id',
          type: 'number'
        },
      },
      relations: {
        tipoExemploTreino1: {
          name: 'tipoExemploTreino1',
          type: 'TipoExemploTreino',
          model: 'TipoExemploTreino',
          relationType: 'belongsTo',
                  keyFrom: 'tipoExemploTreino1Id',
          keyTo: 'id'
        },
        tipoExemploTreino2: {
          name: 'tipoExemploTreino2',
          type: 'TipoExemploTreino',
          model: 'TipoExemploTreino',
          relationType: 'belongsTo',
                  keyFrom: 'tipoExemploTreino2Id',
          keyTo: 'id'
        },
        periodoTreinoRede: {
          name: 'periodoTreinoRede',
          type: 'PeriodoTreinoRede',
          model: 'PeriodoTreinoRede',
          relationType: 'belongsTo',
                  keyFrom: 'periodoTreinoRedeId',
          keyTo: 'id'
        },
        grupoAcao: {
          name: 'grupoAcao',
          type: 'GrupoAcao',
          model: 'GrupoAcao',
          relationType: 'belongsTo',
                  keyFrom: 'grupoAcaoId',
          keyTo: 'id'
        },
        regraProjecaoVenda1: {
          name: 'regraProjecaoVenda1',
          type: 'RegraProjecao',
          model: 'RegraProjecao',
          relationType: 'belongsTo',
                  keyFrom: 'regraProjecaoVenda1Id',
          keyTo: 'id'
        },
        regraProjecaoVenda2: {
          name: 'regraProjecaoVenda2',
          type: 'RegraProjecao',
          model: 'RegraProjecao',
          relationType: 'belongsTo',
                  keyFrom: 'regraProjecaoVenda2Id',
          keyTo: 'id'
        },
        regraProjecaoVenda3: {
          name: 'regraProjecaoVenda3',
          type: 'RegraProjecao',
          model: 'RegraProjecao',
          relationType: 'belongsTo',
                  keyFrom: 'regraProjecaoVenda3Id',
          keyTo: 'id'
        },
        regraProjecaoCompra1: {
          name: 'regraProjecaoCompra1',
          type: 'RegraProjecao',
          model: 'RegraProjecao',
          relationType: 'belongsTo',
                  keyFrom: 'regraProjecaoCompra1Id',
          keyTo: 'id'
        },
        regraProjecaoCompra2: {
          name: 'regraProjecaoCompra2',
          type: 'RegraProjecao',
          model: 'RegraProjecao',
          relationType: 'belongsTo',
                  keyFrom: 'regraProjecaoCompra2Id',
          keyTo: 'id'
        },
        regraProjecaoCompra3: {
          name: 'regraProjecaoCompra3',
          type: 'RegraProjecao',
          model: 'RegraProjecao',
          relationType: 'belongsTo',
                  keyFrom: 'regraProjecaoCompra3Id',
          keyTo: 'id'
        },
        versaoPreRedes: {
          name: 'versaoPreRedes',
          type: 'VersaoPreRede[]',
          model: 'VersaoPreRede',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'preRedeNeuralId'
        },
      }
    }
  }
}
