/* tslint:disable */
import {
  ExperimentoPreRede,
  GrupoAcao,
  RegraProjecao,
  PeriodoTreinoRede
} from '../index';

declare var Object: any;
export interface ExperimentoPreRedeTreinadaInterface {
  "nome"?: string;
  "geraScore"?: string;
  "totalResultadoPositivo"?: number;
  "totalResultadoNegativo"?: number;
  "totalResultadoNeutro"?: number;
  "totalResultadoPositivoCtrl1"?: number;
  "totalResultadoPositivoCtrl2"?: number;
  "totalResultadoPositivoCtrl3"?: number;
  "totalResultadoNegativoCtrl1"?: number;
  "totalResultadoNegativoCtrl2"?: number;
  "totalResultadoNegativoCtrl3"?: number;
  "totalResultadoNeutroCtrl1"?: number;
  "totalResultadoNeutroCtrl2"?: number;
  "totalResultadoNeutroCtrl3"?: number;
  "percentualResultadoPositivo"?: number;
  "percentualResultadoNegativo"?: number;
  "percentualResultadoNeutro"?: number;
  "percentualPositivoCtrl1"?: number;
  "percentualPositivoCtrl2"?: number;
  "percentualPositivoCtrl3"?: number;
  "percentualNegativoCtrl1"?: number;
  "percentualNegativoCtrl2"?: number;
  "percentualNegativoCtrl3"?: number;
  "percentualNeutroCtrl1"?: number;
  "percentualNeutroCtrl2"?: number;
  "percentualNeutroCtrl3"?: number;
  "posicaoCtrl"?: number;
  "id"?: number;
  "experimentoPreRedeId"?: number;
  "grupoAcaoId"?: number;
  "regraProjecaoId"?: number;
  "periodoTreinoRedeId"?: number;
  experimentoPreRede?: ExperimentoPreRede;
  grupoAcao?: GrupoAcao;
  regraProjecao?: RegraProjecao;
  periodoTreinoRede?: PeriodoTreinoRede;
}

export class ExperimentoPreRedeTreinada implements ExperimentoPreRedeTreinadaInterface {
  "nome": string;
  "geraScore": string;
  "totalResultadoPositivo": number;
  "totalResultadoNegativo": number;
  "totalResultadoNeutro": number;
  "totalResultadoPositivoCtrl1": number;
  "totalResultadoPositivoCtrl2": number;
  "totalResultadoPositivoCtrl3": number;
  "totalResultadoNegativoCtrl1": number;
  "totalResultadoNegativoCtrl2": number;
  "totalResultadoNegativoCtrl3": number;
  "totalResultadoNeutroCtrl1": number;
  "totalResultadoNeutroCtrl2": number;
  "totalResultadoNeutroCtrl3": number;
  "percentualResultadoPositivo": number;
  "percentualResultadoNegativo": number;
  "percentualResultadoNeutro": number;
  "percentualPositivoCtrl1": number;
  "percentualPositivoCtrl2": number;
  "percentualPositivoCtrl3": number;
  "percentualNegativoCtrl1": number;
  "percentualNegativoCtrl2": number;
  "percentualNegativoCtrl3": number;
  "percentualNeutroCtrl1": number;
  "percentualNeutroCtrl2": number;
  "percentualNeutroCtrl3": number;
  "posicaoCtrl": number;
  "id": number;
  "experimentoPreRedeId": number;
  "grupoAcaoId": number;
  "regraProjecaoId": number;
  "periodoTreinoRedeId": number;
  experimentoPreRede: ExperimentoPreRede;
  grupoAcao: GrupoAcao;
  regraProjecao: RegraProjecao;
  periodoTreinoRede: PeriodoTreinoRede;
  constructor(data?: ExperimentoPreRedeTreinadaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoPreRedeTreinada`.
   */
  public static getModelName() {
    return "ExperimentoPreRedeTreinada";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoPreRedeTreinada for dynamic purposes.
  **/
  public static factory(data: ExperimentoPreRedeTreinadaInterface): ExperimentoPreRedeTreinada{
    return new ExperimentoPreRedeTreinada(data);
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
      name: 'ExperimentoPreRedeTreinada',
      plural: 'ExperimentoPreRedeTreinadas',
      path: 'ExperimentoPreRedeTreinadas',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "geraScore": {
          name: 'geraScore',
          type: 'string'
        },
        "totalResultadoPositivo": {
          name: 'totalResultadoPositivo',
          type: 'number'
        },
        "totalResultadoNegativo": {
          name: 'totalResultadoNegativo',
          type: 'number'
        },
        "totalResultadoNeutro": {
          name: 'totalResultadoNeutro',
          type: 'number'
        },
        "totalResultadoPositivoCtrl1": {
          name: 'totalResultadoPositivoCtrl1',
          type: 'number'
        },
        "totalResultadoPositivoCtrl2": {
          name: 'totalResultadoPositivoCtrl2',
          type: 'number'
        },
        "totalResultadoPositivoCtrl3": {
          name: 'totalResultadoPositivoCtrl3',
          type: 'number'
        },
        "totalResultadoNegativoCtrl1": {
          name: 'totalResultadoNegativoCtrl1',
          type: 'number'
        },
        "totalResultadoNegativoCtrl2": {
          name: 'totalResultadoNegativoCtrl2',
          type: 'number'
        },
        "totalResultadoNegativoCtrl3": {
          name: 'totalResultadoNegativoCtrl3',
          type: 'number'
        },
        "totalResultadoNeutroCtrl1": {
          name: 'totalResultadoNeutroCtrl1',
          type: 'number'
        },
        "totalResultadoNeutroCtrl2": {
          name: 'totalResultadoNeutroCtrl2',
          type: 'number'
        },
        "totalResultadoNeutroCtrl3": {
          name: 'totalResultadoNeutroCtrl3',
          type: 'number'
        },
        "percentualResultadoPositivo": {
          name: 'percentualResultadoPositivo',
          type: 'number'
        },
        "percentualResultadoNegativo": {
          name: 'percentualResultadoNegativo',
          type: 'number'
        },
        "percentualResultadoNeutro": {
          name: 'percentualResultadoNeutro',
          type: 'number'
        },
        "percentualPositivoCtrl1": {
          name: 'percentualPositivoCtrl1',
          type: 'number'
        },
        "percentualPositivoCtrl2": {
          name: 'percentualPositivoCtrl2',
          type: 'number'
        },
        "percentualPositivoCtrl3": {
          name: 'percentualPositivoCtrl3',
          type: 'number'
        },
        "percentualNegativoCtrl1": {
          name: 'percentualNegativoCtrl1',
          type: 'number'
        },
        "percentualNegativoCtrl2": {
          name: 'percentualNegativoCtrl2',
          type: 'number'
        },
        "percentualNegativoCtrl3": {
          name: 'percentualNegativoCtrl3',
          type: 'number'
        },
        "percentualNeutroCtrl1": {
          name: 'percentualNeutroCtrl1',
          type: 'number'
        },
        "percentualNeutroCtrl2": {
          name: 'percentualNeutroCtrl2',
          type: 'number'
        },
        "percentualNeutroCtrl3": {
          name: 'percentualNeutroCtrl3',
          type: 'number'
        },
        "posicaoCtrl": {
          name: 'posicaoCtrl',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "experimentoPreRedeId": {
          name: 'experimentoPreRedeId',
          type: 'number'
        },
        "grupoAcaoId": {
          name: 'grupoAcaoId',
          type: 'number'
        },
        "regraProjecaoId": {
          name: 'regraProjecaoId',
          type: 'number'
        },
        "periodoTreinoRedeId": {
          name: 'periodoTreinoRedeId',
          type: 'number'
        },
      },
      relations: {
        experimentoPreRede: {
          name: 'experimentoPreRede',
          type: 'ExperimentoPreRede',
          model: 'ExperimentoPreRede',
          relationType: 'belongsTo',
                  keyFrom: 'experimentoPreRedeId',
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
        regraProjecao: {
          name: 'regraProjecao',
          type: 'RegraProjecao',
          model: 'RegraProjecao',
          relationType: 'belongsTo',
                  keyFrom: 'regraProjecaoId',
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
      }
    }
  }
}
