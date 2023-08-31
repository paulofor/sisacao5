/* tslint:disable */
import {
  ValorParametro
} from '../index';

declare var Object: any;
export interface ParametroRegraInterface {
  "tipo"?: string;
  "nome"?: string;
  "descricao"?: string;
  "atributoClasse"?: string;
  "siglaDescricao"?: string;
  "id"?: number;
  "regraSimulacaoId"?: number;
  valorParametros?: ValorParametro[];
}

export class ParametroRegra implements ParametroRegraInterface {
  "tipo": string;
  "nome": string;
  "descricao": string;
  "atributoClasse": string;
  "siglaDescricao": string;
  "id": number;
  "regraSimulacaoId": number;
  valorParametros: ValorParametro[];
  constructor(data?: ParametroRegraInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ParametroRegra`.
   */
  public static getModelName() {
    return "ParametroRegra";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ParametroRegra for dynamic purposes.
  **/
  public static factory(data: ParametroRegraInterface): ParametroRegra{
    return new ParametroRegra(data);
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
      name: 'ParametroRegra',
      plural: 'ParametroRegras',
      path: 'ParametroRegras',
      idName: 'id',
      properties: {
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "descricao": {
          name: 'descricao',
          type: 'string'
        },
        "atributoClasse": {
          name: 'atributoClasse',
          type: 'string'
        },
        "siglaDescricao": {
          name: 'siglaDescricao',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "regraSimulacaoId": {
          name: 'regraSimulacaoId',
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
          keyTo: 'parametroRegraId'
        },
      }
    }
  }
}
