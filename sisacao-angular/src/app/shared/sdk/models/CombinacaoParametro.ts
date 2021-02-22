/* tslint:disable */
import {
  ValorParametro
} from '../index';

declare var Object: any;
export interface CombinacaoParametroInterface {
  "posicaoCombinacao"?: number;
  "dataExecucao"?: string;
  "id"?: number;
  "experimentoSimulacaoId"?: number;
  valorParametros?: ValorParametro[];
}

export class CombinacaoParametro implements CombinacaoParametroInterface {
  "posicaoCombinacao": number;
  "dataExecucao": string;
  "id": number;
  "experimentoSimulacaoId": number;
  valorParametros: ValorParametro[];
  constructor(data?: CombinacaoParametroInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CombinacaoParametro`.
   */
  public static getModelName() {
    return "CombinacaoParametro";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CombinacaoParametro for dynamic purposes.
  **/
  public static factory(data: CombinacaoParametroInterface): CombinacaoParametro{
    return new CombinacaoParametro(data);
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
      name: 'CombinacaoParametro',
      plural: 'CombinacaoParametros',
      path: 'CombinacaoParametros',
      idName: 'id',
      properties: {
        "posicaoCombinacao": {
          name: 'posicaoCombinacao',
          type: 'number'
        },
        "dataExecucao": {
          name: 'dataExecucao',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "experimentoSimulacaoId": {
          name: 'experimentoSimulacaoId',
          type: 'number'
        },
      },
      relations: {
        valorParametros: {
          name: 'valorParametros',
          type: 'ValorParametro[]',
          model: 'ValorParametro',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'combinacaoParametroId'
        },
      }
    }
  }
}
