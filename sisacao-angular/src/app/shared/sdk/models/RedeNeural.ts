/* tslint:disable */
import {
  PrevisaoRede,
  TipoExemploTreino,
  GrupoRedeRel
} from '../index';

declare var Object: any;
export interface RedeNeuralInterface {
  "estrutura"?: string;
  "compilacao"?: string;
  "fitTreinamento"?: string;
  "nome"?: string;
  "entrada1"?: number;
  "entrada2"?: number;
  "qtdeTradeReal"?: number;
  "resultadoTradeReal"?: number;
  "id"?: number;
  "tipoExemploTreino1Id"?: number;
  "tipoExemploTreino2Id"?: number;
  previsaoRedes?: PrevisaoRede[];
  tipoExemploTreino1?: TipoExemploTreino;
  tipoExemploTreino2?: TipoExemploTreino;
  grupoRedeRels?: GrupoRedeRel[];
}

export class RedeNeural implements RedeNeuralInterface {
  "estrutura": string;
  "compilacao": string;
  "fitTreinamento": string;
  "nome": string;
  "entrada1": number;
  "entrada2": number;
  "qtdeTradeReal": number;
  "resultadoTradeReal": number;
  "id": number;
  "tipoExemploTreino1Id": number;
  "tipoExemploTreino2Id": number;
  previsaoRedes: PrevisaoRede[];
  tipoExemploTreino1: TipoExemploTreino;
  tipoExemploTreino2: TipoExemploTreino;
  grupoRedeRels: GrupoRedeRel[];
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
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "entrada1": {
          name: 'entrada1',
          type: 'number'
        },
        "entrada2": {
          name: 'entrada2',
          type: 'number'
        },
        "qtdeTradeReal": {
          name: 'qtdeTradeReal',
          type: 'number'
        },
        "resultadoTradeReal": {
          name: 'resultadoTradeReal',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "tipoExemploTreino1Id": {
          name: 'tipoExemploTreino1Id',
          type: 'number'
        },
        "tipoExemploTreino2Id": {
          name: 'tipoExemploTreino2Id',
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
        tipoExemploTreino1: {
          name: 'tipoExemploTreino1',
          type: 'TipoExemploTreino',
          model: 'TipoExemploTreino',
          relationType: 'belongsTo',
                  keyFrom: 'tipoExemploTreino1Id',
          keyTo: 'id'
        },
        tipoExemploTreino2: {
          name: 'tipoExemploTreino2',
          type: 'TipoExemploTreino',
          model: 'TipoExemploTreino',
          relationType: 'belongsTo',
                  keyFrom: 'tipoExemploTreino2Id',
          keyTo: 'id'
        },
        grupoRedeRels: {
          name: 'grupoRedeRels',
          type: 'GrupoRedeRel[]',
          model: 'GrupoRedeRel',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'redeNeuralId'
        },
      }
    }
  }
}
