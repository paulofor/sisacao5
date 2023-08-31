/* tslint:disable */
import {
  AmostraDadoSintetico
} from '../index';

declare var Object: any;
export interface TipoExemploTreinoInterface {
  "id"?: number;
  "qtdeDias"?: number;
  "posicaoReferencia"?: number;
  "diaNumInicio"?: number;
  "diaNumFinal"?: number;
  "diaNumAtualizado"?: number;
  "tamanhoEntrada"?: number;
  amostraDadoSinteticos?: AmostraDadoSintetico[];
}

export class TipoExemploTreino implements TipoExemploTreinoInterface {
  "id": number;
  "qtdeDias": number;
  "posicaoReferencia": number;
  "diaNumInicio": number;
  "diaNumFinal": number;
  "diaNumAtualizado": number;
  "tamanhoEntrada": number;
  amostraDadoSinteticos: AmostraDadoSintetico[];
  constructor(data?: TipoExemploTreinoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TipoExemploTreino`.
   */
  public static getModelName() {
    return "TipoExemploTreino";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TipoExemploTreino for dynamic purposes.
  **/
  public static factory(data: TipoExemploTreinoInterface): TipoExemploTreino{
    return new TipoExemploTreino(data);
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
      name: 'TipoExemploTreino',
      plural: 'TipoExemploTreinos',
      path: 'TipoExemploTreinos',
      idName: 'id',
      properties: {
        "id": {
          name: 'id',
          type: 'number'
        },
        "qtdeDias": {
          name: 'qtdeDias',
          type: 'number'
        },
        "posicaoReferencia": {
          name: 'posicaoReferencia',
          type: 'number'
        },
        "diaNumInicio": {
          name: 'diaNumInicio',
          type: 'number'
        },
        "diaNumFinal": {
          name: 'diaNumFinal',
          type: 'number'
        },
        "diaNumAtualizado": {
          name: 'diaNumAtualizado',
          type: 'number'
        },
        "tamanhoEntrada": {
          name: 'tamanhoEntrada',
          type: 'number'
        },
      },
      relations: {
        amostraDadoSinteticos: {
          name: 'amostraDadoSinteticos',
          type: 'AmostraDadoSintetico[]',
          model: 'AmostraDadoSintetico',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'tipoExemploTreinoId'
        },
      }
    }
  }
}
