/* tslint:disable */
import {
  FechamentoRegraDia
} from '../index';

declare var Object: any;
export interface FechamentoRegraDiaQuantidadeInterface {
  "diaNum"?: number;
  "quantidadeCompra"?: number;
  "quantidadeVenda"?: number;
  "fechamentoRegraDiaId"?: number;
  fechamentoRegraDia?: FechamentoRegraDia;
}

export class FechamentoRegraDiaQuantidade implements FechamentoRegraDiaQuantidadeInterface {
  "diaNum": number;
  "quantidadeCompra": number;
  "quantidadeVenda": number;
  "fechamentoRegraDiaId": number;
  fechamentoRegraDia: FechamentoRegraDia;
  constructor(data?: FechamentoRegraDiaQuantidadeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `FechamentoRegraDiaQuantidade`.
   */
  public static getModelName() {
    return "FechamentoRegraDiaQuantidade";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of FechamentoRegraDiaQuantidade for dynamic purposes.
  **/
  public static factory(data: FechamentoRegraDiaQuantidadeInterface): FechamentoRegraDiaQuantidade{
    return new FechamentoRegraDiaQuantidade(data);
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
      name: 'FechamentoRegraDiaQuantidade',
      plural: 'FechamentoRegraDiaQuantidades',
      path: 'FechamentoRegraDiaQuantidades',
      idName: 'diaNum',
      properties: {
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "quantidadeCompra": {
          name: 'quantidadeCompra',
          type: 'number'
        },
        "quantidadeVenda": {
          name: 'quantidadeVenda',
          type: 'number'
        },
        "fechamentoRegraDiaId": {
          name: 'fechamentoRegraDiaId',
          type: 'number'
        },
      },
      relations: {
        fechamentoRegraDia: {
          name: 'fechamentoRegraDia',
          type: 'FechamentoRegraDia',
          model: 'FechamentoRegraDia',
          relationType: 'belongsTo',
                  keyFrom: 'fechamentoRegraDiaId',
          keyTo: 'id'
        },
      }
    }
  }
}
