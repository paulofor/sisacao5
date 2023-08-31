/* tslint:disable */
import {
  GrupoAcao,
  FechamentoRegraDiaQuantidade,
  FechamentoPontoSaida
} from '../index';

declare var Object: any;
export interface FechamentoRegraDiaInterface {
  "percentualTargetStop"?: number;
  "grupoAcaoId"?: number;
  "diaNumFechado"?: number;
  "id"?: number;
  grupoAcao?: GrupoAcao;
  fechamentoRegraDiaQuantidades?: FechamentoRegraDiaQuantidade[];
  fechamentoPontoSaidas?: FechamentoPontoSaida[];
}

export class FechamentoRegraDia implements FechamentoRegraDiaInterface {
  "percentualTargetStop": number;
  "grupoAcaoId": number;
  "diaNumFechado": number;
  "id": number;
  grupoAcao: GrupoAcao;
  fechamentoRegraDiaQuantidades: FechamentoRegraDiaQuantidade[];
  fechamentoPontoSaidas: FechamentoPontoSaida[];
  constructor(data?: FechamentoRegraDiaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `FechamentoRegraDia`.
   */
  public static getModelName() {
    return "FechamentoRegraDia";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of FechamentoRegraDia for dynamic purposes.
  **/
  public static factory(data: FechamentoRegraDiaInterface): FechamentoRegraDia{
    return new FechamentoRegraDia(data);
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
      name: 'FechamentoRegraDia',
      plural: 'FechamentoRegraDia',
      path: 'FechamentoRegraDia',
      idName: 'id',
      properties: {
        "percentualTargetStop": {
          name: 'percentualTargetStop',
          type: 'number'
        },
        "grupoAcaoId": {
          name: 'grupoAcaoId',
          type: 'number'
        },
        "diaNumFechado": {
          name: 'diaNumFechado',
          type: 'number'
        },
        "id": {
          name: 'id',
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
        fechamentoRegraDiaQuantidades: {
          name: 'fechamentoRegraDiaQuantidades',
          type: 'FechamentoRegraDiaQuantidade[]',
          model: 'FechamentoRegraDiaQuantidade',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'fechamentoRegraDiaId'
        },
        fechamentoPontoSaidas: {
          name: 'fechamentoPontoSaidas',
          type: 'FechamentoPontoSaida[]',
          model: 'FechamentoPontoSaida',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'fechamentoRegraDiaId'
        },
      }
    }
  }
}
