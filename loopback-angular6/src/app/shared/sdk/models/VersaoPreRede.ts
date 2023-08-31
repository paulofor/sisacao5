/* tslint:disable */
import {
  PreRedeNeural,
  VersaoPreRedeRegra,
  ExperimentoPreRede
} from '../index';

declare var Object: any;
export interface VersaoPreRedeInterface {
  "numero"?: number;
  "caracteristica"?: string;
  "dataCriacao"?: Date;
  "finalizada"?: number;
  "estrutura"?: string;
  "compilacao"?: string;
  "fitTreinamento"?: string;
  "qtdeParametro"?: number;
  "redeNeuralId"?: number;
  "id"?: number;
  "preRedeNeuralId"?: number;
  preRedeNeural?: PreRedeNeural;
  versaoPreRedeRegras?: VersaoPreRedeRegra[];
  experimentoPreRedes?: ExperimentoPreRede[];
}

export class VersaoPreRede implements VersaoPreRedeInterface {
  "numero": number;
  "caracteristica": string;
  "dataCriacao": Date;
  "finalizada": number;
  "estrutura": string;
  "compilacao": string;
  "fitTreinamento": string;
  "qtdeParametro": number;
  "redeNeuralId": number;
  "id": number;
  "preRedeNeuralId": number;
  preRedeNeural: PreRedeNeural;
  versaoPreRedeRegras: VersaoPreRedeRegra[];
  experimentoPreRedes: ExperimentoPreRede[];
  constructor(data?: VersaoPreRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `VersaoPreRede`.
   */
  public static getModelName() {
    return "VersaoPreRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of VersaoPreRede for dynamic purposes.
  **/
  public static factory(data: VersaoPreRedeInterface): VersaoPreRede{
    return new VersaoPreRede(data);
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
      name: 'VersaoPreRede',
      plural: 'VersaoPreRedes',
      path: 'VersaoPreRedes',
      idName: 'id',
      properties: {
        "numero": {
          name: 'numero',
          type: 'number'
        },
        "caracteristica": {
          name: 'caracteristica',
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
        "estrutura": {
          name: 'estrutura',
          type: 'string'
        },
        "compilacao": {
          name: 'compilacao',
          type: 'string'
        },
        "fitTreinamento": {
          name: 'fitTreinamento',
          type: 'string'
        },
        "qtdeParametro": {
          name: 'qtdeParametro',
          type: 'number'
        },
        "redeNeuralId": {
          name: 'redeNeuralId',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "preRedeNeuralId": {
          name: 'preRedeNeuralId',
          type: 'number'
        },
      },
      relations: {
        preRedeNeural: {
          name: 'preRedeNeural',
          type: 'PreRedeNeural',
          model: 'PreRedeNeural',
          relationType: 'belongsTo',
                  keyFrom: 'preRedeNeuralId',
          keyTo: 'id'
        },
        versaoPreRedeRegras: {
          name: 'versaoPreRedeRegras',
          type: 'VersaoPreRedeRegra[]',
          model: 'VersaoPreRedeRegra',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'versaoPreRedeId'
        },
        experimentoPreRedes: {
          name: 'experimentoPreRedes',
          type: 'ExperimentoPreRede[]',
          model: 'ExperimentoPreRede',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'versaoPreRedeId'
        },
      }
    }
  }
}
