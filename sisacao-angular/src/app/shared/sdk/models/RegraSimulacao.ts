/* tslint:disable */
import {
  ParametroRegra
} from '../index';

declare var Object: any;
export interface RegraSimulacaoInterface {
  "nome"?: string;
  "nomeClasse"?: string;
  "descricao"?: string;
  "dataCriacao"?: string;
  "usada"?: number;
  "id"?: number;
  parametroRegras?: ParametroRegra[];
}

export class RegraSimulacao implements RegraSimulacaoInterface {
  "nome": string;
  "nomeClasse": string;
  "descricao": string;
  "dataCriacao": string;
  "usada": number;
  "id": number;
  parametroRegras: ParametroRegra[];
  constructor(data?: RegraSimulacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RegraSimulacao`.
   */
  public static getModelName() {
    return "RegraSimulacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RegraSimulacao for dynamic purposes.
  **/
  public static factory(data: RegraSimulacaoInterface): RegraSimulacao{
    return new RegraSimulacao(data);
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
      name: 'RegraSimulacao',
      plural: 'RegraSimulacaos',
      path: 'RegraSimulacaos',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "nomeClasse": {
          name: 'nomeClasse',
          type: 'string'
        },
        "descricao": {
          name: 'descricao',
          type: 'string'
        },
        "dataCriacao": {
          name: 'dataCriacao',
          type: 'string'
        },
        "usada": {
          name: 'usada',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        parametroRegras: {
          name: 'parametroRegras',
          type: 'ParametroRegra[]',
          model: 'ParametroRegra',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'regraSimulacaoId'
        },
      }
    }
  }
}
