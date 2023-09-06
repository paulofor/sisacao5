/* tslint:disable */
import {
  AmostraDadoSintetico,
  VersaoPreRede,
  ExperimentoPreRedeResultado,
  ExperimentoPreRedeTreinada
} from '../index';

declare var Object: any;
export interface ExperimentoPreRedeInterface {
  "nome"?: string;
  "nomeArquivoRede"?: string;
  "mediaY0"?: number;
  "mediaY1"?: number;
  "mediaResultadoNeutro"?: number;
  "mediaResultadoPositivo"?: number;
  "mediaResultadoNegativo"?: number;
  "mediaTotal"?: number;
  "desvioY0"?: number;
  "desvioY1"?: number;
  "desvioResultadoNeutro"?: number;
  "desvioResultadoPositivo"?: number;
  "desvioResultadoNegativo"?: number;
  "desvioTotal"?: number;
  "qtdeY0"?: number;
  "qtdeY1"?: number;
  "geraScoreTesteSintetico"?: string;
  "id"?: number;
  "amostraDadoSinteticoEntrada1Id"?: number;
  "amostraDadoSinteticoEntrada2Id"?: number;
  "amostraDadoSinteticoIndice1Id"?: number;
  "amostraDadoSinteticoIndice2Id"?: number;
  "versaoPreRedeId"?: number;
  amostraDadoSinteticoEntrada1?: AmostraDadoSintetico;
  amostraDadoSinteticoEntrada2?: AmostraDadoSintetico;
  amostraDadoSinteticoIndice1?: AmostraDadoSintetico;
  amostraDadoSinteticoIndice2?: AmostraDadoSintetico;
  versaoPreRede?: VersaoPreRede;
  experimentoPreRedeResultados?: ExperimentoPreRedeResultado[];
  experimentoPreRedeTreinadas?: ExperimentoPreRedeTreinada[];
}

export class ExperimentoPreRede implements ExperimentoPreRedeInterface {
  "nome": string;
  "nomeArquivoRede": string;
  "mediaY0": number;
  "mediaY1": number;
  "mediaResultadoNeutro": number;
  "mediaResultadoPositivo": number;
  "mediaResultadoNegativo": number;
  "mediaTotal": number;
  "desvioY0": number;
  "desvioY1": number;
  "desvioResultadoNeutro": number;
  "desvioResultadoPositivo": number;
  "desvioResultadoNegativo": number;
  "desvioTotal": number;
  "qtdeY0": number;
  "qtdeY1": number;
  "geraScoreTesteSintetico": string;
  "id": number;
  "amostraDadoSinteticoEntrada1Id": number;
  "amostraDadoSinteticoEntrada2Id": number;
  "amostraDadoSinteticoIndice1Id": number;
  "amostraDadoSinteticoIndice2Id": number;
  "versaoPreRedeId": number;
  amostraDadoSinteticoEntrada1: AmostraDadoSintetico;
  amostraDadoSinteticoEntrada2: AmostraDadoSintetico;
  amostraDadoSinteticoIndice1: AmostraDadoSintetico;
  amostraDadoSinteticoIndice2: AmostraDadoSintetico;
  versaoPreRede: VersaoPreRede;
  experimentoPreRedeResultados: ExperimentoPreRedeResultado[];
  experimentoPreRedeTreinadas: ExperimentoPreRedeTreinada[];
  constructor(data?: ExperimentoPreRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoPreRede`.
   */
  public static getModelName() {
    return "ExperimentoPreRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoPreRede for dynamic purposes.
  **/
  public static factory(data: ExperimentoPreRedeInterface): ExperimentoPreRede{
    return new ExperimentoPreRede(data);
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
      name: 'ExperimentoPreRede',
      plural: 'ExperimentoPreRedes',
      path: 'ExperimentoPreRedes',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "nomeArquivoRede": {
          name: 'nomeArquivoRede',
          type: 'string'
        },
        "mediaY0": {
          name: 'mediaY0',
          type: 'number'
        },
        "mediaY1": {
          name: 'mediaY1',
          type: 'number'
        },
        "mediaResultadoNeutro": {
          name: 'mediaResultadoNeutro',
          type: 'number'
        },
        "mediaResultadoPositivo": {
          name: 'mediaResultadoPositivo',
          type: 'number'
        },
        "mediaResultadoNegativo": {
          name: 'mediaResultadoNegativo',
          type: 'number'
        },
        "mediaTotal": {
          name: 'mediaTotal',
          type: 'number'
        },
        "desvioY0": {
          name: 'desvioY0',
          type: 'number'
        },
        "desvioY1": {
          name: 'desvioY1',
          type: 'number'
        },
        "desvioResultadoNeutro": {
          name: 'desvioResultadoNeutro',
          type: 'number'
        },
        "desvioResultadoPositivo": {
          name: 'desvioResultadoPositivo',
          type: 'number'
        },
        "desvioResultadoNegativo": {
          name: 'desvioResultadoNegativo',
          type: 'number'
        },
        "desvioTotal": {
          name: 'desvioTotal',
          type: 'number'
        },
        "qtdeY0": {
          name: 'qtdeY0',
          type: 'number'
        },
        "qtdeY1": {
          name: 'qtdeY1',
          type: 'number'
        },
        "geraScoreTesteSintetico": {
          name: 'geraScoreTesteSintetico',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "amostraDadoSinteticoEntrada1Id": {
          name: 'amostraDadoSinteticoEntrada1Id',
          type: 'number'
        },
        "amostraDadoSinteticoEntrada2Id": {
          name: 'amostraDadoSinteticoEntrada2Id',
          type: 'number'
        },
        "amostraDadoSinteticoIndice1Id": {
          name: 'amostraDadoSinteticoIndice1Id',
          type: 'number'
        },
        "amostraDadoSinteticoIndice2Id": {
          name: 'amostraDadoSinteticoIndice2Id',
          type: 'number'
        },
        "versaoPreRedeId": {
          name: 'versaoPreRedeId',
          type: 'number'
        },
      },
      relations: {
        amostraDadoSinteticoEntrada1: {
          name: 'amostraDadoSinteticoEntrada1',
          type: 'AmostraDadoSintetico',
          model: 'AmostraDadoSintetico',
          relationType: 'belongsTo',
                  keyFrom: 'amostraDadoSinteticoEntrada1Id',
          keyTo: 'id'
        },
        amostraDadoSinteticoEntrada2: {
          name: 'amostraDadoSinteticoEntrada2',
          type: 'AmostraDadoSintetico',
          model: 'AmostraDadoSintetico',
          relationType: 'belongsTo',
                  keyFrom: 'amostraDadoSinteticoEntrada2Id',
          keyTo: 'id'
        },
        amostraDadoSinteticoIndice1: {
          name: 'amostraDadoSinteticoIndice1',
          type: 'AmostraDadoSintetico',
          model: 'AmostraDadoSintetico',
          relationType: 'belongsTo',
                  keyFrom: 'amostraDadoSinteticoIndice1Id',
          keyTo: 'id'
        },
        amostraDadoSinteticoIndice2: {
          name: 'amostraDadoSinteticoIndice2',
          type: 'AmostraDadoSintetico',
          model: 'AmostraDadoSintetico',
          relationType: 'belongsTo',
                  keyFrom: 'amostraDadoSinteticoIndice2Id',
          keyTo: 'id'
        },
        versaoPreRede: {
          name: 'versaoPreRede',
          type: 'VersaoPreRede',
          model: 'VersaoPreRede',
          relationType: 'belongsTo',
                  keyFrom: 'versaoPreRedeId',
          keyTo: 'id'
        },
        experimentoPreRedeResultados: {
          name: 'experimentoPreRedeResultados',
          type: 'ExperimentoPreRedeResultado[]',
          model: 'ExperimentoPreRedeResultado',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'experimentoPreRedeId'
        },
        experimentoPreRedeTreinadas: {
          name: 'experimentoPreRedeTreinadas',
          type: 'ExperimentoPreRedeTreinada[]',
          model: 'ExperimentoPreRedeTreinada',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'experimentoPreRedeId'
        },
      }
    }
  }
}
