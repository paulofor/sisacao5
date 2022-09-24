/* tslint:disable */
import {
  GrupoAcao,
  PeriodoTreinoRede,
  TipoExemploTreino,
  RegraProjecao,
  RedeNeural,
  PrevisaoRede,
  TradeTreinoRede
} from '../index';

declare var Object: any;
export interface TreinoRedeInterface {
  "ativoPrevisao"?: number;
  "ativoTeste"?: number;
  "limiteParaEntrada"?: number;
  "qtdeLucroTeste"?: number;
  "qtdePrejuizoTeste"?: number;
  "pontuacaoTeste"?: number;
  "dataCriacaoGmt"?: Date;
  "treinoGrupoRedeId"?: number;
  "dataTreinamento"?: Date;
  "dataTeste"?: Date;
  "ativoPrevisaoTeste"?: number;
  "dataPrevisaoTeste"?: Date;
  "desvioValorTeste"?: number;
  "mediaValorTeste"?: number;
  "qtdeTradeTeste"?: number;
  "id"?: number;
  "grupoAcaoId"?: number;
  "periodoTreinoRedeId"?: number;
  "tipoExemploTreinoId"?: number;
  "regraProjecaoId"?: number;
  "redeNeuralId"?: number;
  grupoAcao?: GrupoAcao;
  periodoTreinoRede?: PeriodoTreinoRede;
  tipoExemploTreino?: TipoExemploTreino;
  regraProjecao?: RegraProjecao;
  redeNeural?: RedeNeural;
  previsaoRedes?: PrevisaoRede[];
  tradeTreinoRedes?: TradeTreinoRede[];
}

export class TreinoRede implements TreinoRedeInterface {
  "ativoPrevisao": number;
  "ativoTeste": number;
  "limiteParaEntrada": number;
  "qtdeLucroTeste": number;
  "qtdePrejuizoTeste": number;
  "pontuacaoTeste": number;
  "dataCriacaoGmt": Date;
  "treinoGrupoRedeId": number;
  "dataTreinamento": Date;
  "dataTeste": Date;
  "ativoPrevisaoTeste": number;
  "dataPrevisaoTeste": Date;
  "desvioValorTeste": number;
  "mediaValorTeste": number;
  "qtdeTradeTeste": number;
  "id": number;
  "grupoAcaoId": number;
  "periodoTreinoRedeId": number;
  "tipoExemploTreinoId": number;
  "regraProjecaoId": number;
  "redeNeuralId": number;
  grupoAcao: GrupoAcao;
  periodoTreinoRede: PeriodoTreinoRede;
  tipoExemploTreino: TipoExemploTreino;
  regraProjecao: RegraProjecao;
  redeNeural: RedeNeural;
  previsaoRedes: PrevisaoRede[];
  tradeTreinoRedes: TradeTreinoRede[];
  constructor(data?: TreinoRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TreinoRede`.
   */
  public static getModelName() {
    return "TreinoRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TreinoRede for dynamic purposes.
  **/
  public static factory(data: TreinoRedeInterface): TreinoRede{
    return new TreinoRede(data);
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
      name: 'TreinoRede',
      plural: 'TreinoRedes',
      path: 'TreinoRedes',
      idName: 'id',
      properties: {
        "ativoPrevisao": {
          name: 'ativoPrevisao',
          type: 'number'
        },
        "ativoTeste": {
          name: 'ativoTeste',
          type: 'number'
        },
        "limiteParaEntrada": {
          name: 'limiteParaEntrada',
          type: 'number'
        },
        "qtdeLucroTeste": {
          name: 'qtdeLucroTeste',
          type: 'number'
        },
        "qtdePrejuizoTeste": {
          name: 'qtdePrejuizoTeste',
          type: 'number'
        },
        "pontuacaoTeste": {
          name: 'pontuacaoTeste',
          type: 'number'
        },
        "dataCriacaoGmt": {
          name: 'dataCriacaoGmt',
          type: 'Date'
        },
        "treinoGrupoRedeId": {
          name: 'treinoGrupoRedeId',
          type: 'number'
        },
        "dataTreinamento": {
          name: 'dataTreinamento',
          type: 'Date'
        },
        "dataTeste": {
          name: 'dataTeste',
          type: 'Date'
        },
        "ativoPrevisaoTeste": {
          name: 'ativoPrevisaoTeste',
          type: 'number'
        },
        "dataPrevisaoTeste": {
          name: 'dataPrevisaoTeste',
          type: 'Date'
        },
        "desvioValorTeste": {
          name: 'desvioValorTeste',
          type: 'number'
        },
        "mediaValorTeste": {
          name: 'mediaValorTeste',
          type: 'number'
        },
        "qtdeTradeTeste": {
          name: 'qtdeTradeTeste',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "grupoAcaoId": {
          name: 'grupoAcaoId',
          type: 'number'
        },
        "periodoTreinoRedeId": {
          name: 'periodoTreinoRedeId',
          type: 'number'
        },
        "tipoExemploTreinoId": {
          name: 'tipoExemploTreinoId',
          type: 'number'
        },
        "regraProjecaoId": {
          name: 'regraProjecaoId',
          type: 'number'
        },
        "redeNeuralId": {
          name: 'redeNeuralId',
          type: 'number'
        },
      },
      relations: {
        grupoAcao: {
          name: 'grupoAcao',
          type: 'GrupoAcao',
          model: 'GrupoAcao',
          relationType: 'belongsTo',
                  keyFrom: 'grupoAcaoId',
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
        tipoExemploTreino: {
          name: 'tipoExemploTreino',
          type: 'TipoExemploTreino',
          model: 'TipoExemploTreino',
          relationType: 'belongsTo',
                  keyFrom: 'tipoExemploTreinoId',
          keyTo: 'id'
        },
        regraProjecao: {
          name: 'regraProjecao',
          type: 'RegraProjecao',
          model: 'RegraProjecao',
          relationType: 'belongsTo',
                  keyFrom: 'regraProjecaoId',
          keyTo: 'id'
        },
        redeNeural: {
          name: 'redeNeural',
          type: 'RedeNeural',
          model: 'RedeNeural',
          relationType: 'belongsTo',
                  keyFrom: 'redeNeuralId',
          keyTo: 'id'
        },
        previsaoRedes: {
          name: 'previsaoRedes',
          type: 'PrevisaoRede[]',
          model: 'PrevisaoRede',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'treinoRedeId'
        },
        tradeTreinoRedes: {
          name: 'tradeTreinoRedes',
          type: 'TradeTreinoRede[]',
          model: 'TradeTreinoRede',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'treinoRedeId'
        },
      }
    }
  }
}
