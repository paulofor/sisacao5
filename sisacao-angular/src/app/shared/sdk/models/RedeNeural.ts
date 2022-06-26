/* tslint:disable */
import {
  PrevisaoRede
} from '../index';

declare var Object: any;
export interface RedeNeuralInterface {
  "estrutura"?: string;
  "compilacao"?: string;
  "fitTreinamento"?: string;
  "id"?: number;
  previsaoRedes?: PrevisaoRede[];
}

export class RedeNeural implements RedeNeuralInterface {
  "estrutura": string;
  "compilacao": string;
  "fitTreinamento": string;
  "id": number;
  previsaoRedes: PrevisaoRede[];
  constructor(data?: RedeNeuralInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RedeNeural`.
   */
  public static getModelName() {
    return "RedeNeural";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RedeNeural for dynamic purposes.
  **/
  public static factory(data: RedeNeuralInterface): RedeNeural{
    return new RedeNeural(data);
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
      name: 'RedeNeural',
      plural: 'RedeNeurals',
      path: 'RedeNeurals',
      idName: 'id',
      properties: {
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
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        previsaoRedes: {
          name: 'previsaoRedes',
          type: 'PrevisaoRede[]',
          model: 'PrevisaoRede',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'redeNeuralId'
        },
      }
    }
  }
}
