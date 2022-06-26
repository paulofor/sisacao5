/* tslint:disable */
import {
  RedeNeural
} from '../index';

declare var Object: any;
export interface PrevisaoRedeInterface {
  "ticker"?: string;
  "diaNumPrevisao"?: number;
  "valorPrevisao"?: number;
  "redeNeuralId"?: number;
  "id"?: number;
  redeNeural?: RedeNeural;
}

export class PrevisaoRede implements PrevisaoRedeInterface {
  "ticker": string;
  "diaNumPrevisao": number;
  "valorPrevisao": number;
  "redeNeuralId": number;
  "id": number;
  redeNeural: RedeNeural;
  constructor(data?: PrevisaoRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PrevisaoRede`.
   */
  public static getModelName() {
    return "PrevisaoRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PrevisaoRede for dynamic purposes.
  **/
  public static factory(data: PrevisaoRedeInterface): PrevisaoRede{
    return new PrevisaoRede(data);
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
      name: 'PrevisaoRede',
      plural: 'PrevisaoRedes',
      path: 'PrevisaoRedes',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "diaNumPrevisao": {
          name: 'diaNumPrevisao',
          type: 'number'
        },
        "valorPrevisao": {
          name: 'valorPrevisao',
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
      },
      relations: {
        redeNeural: {
          name: 'redeNeural',
          type: 'RedeNeural',
          model: 'RedeNeural',
          relationType: 'belongsTo',
                  keyFrom: 'redeNeuralId',
          keyTo: 'id'
        },
      }
    }
  }
}
