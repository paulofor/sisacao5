/* tslint:disable */

declare var Object: any;
export interface RendaFixaInterface {
  "nome"?: string;
  "dataVencimento"?: string;
  "valorMinimo"?: number;
  "dataInsercao"?: string;
  "rentabilidadeAnual"?: number;
  "emissor"?: string;
  "distribuidor"?: string;
  "tipo"?: string;
  "ativo"?: string;
  "percentual"?: number;
  "id"?: number;
}

export class RendaFixa implements RendaFixaInterface {
  "nome": string;
  "dataVencimento": string;
  "valorMinimo": number;
  "dataInsercao": string;
  "rentabilidadeAnual": number;
  "emissor": string;
  "distribuidor": string;
  "tipo": string;
  "ativo": string;
  "percentual": number;
  "id": number;
  constructor(data?: RendaFixaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RendaFixa`.
   */
  public static getModelName() {
    return "RendaFixa";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RendaFixa for dynamic purposes.
  **/
  public static factory(data: RendaFixaInterface): RendaFixa{
    return new RendaFixa(data);
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
      name: 'RendaFixa',
      plural: 'RendaFixas',
      path: 'RendaFixas',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "dataVencimento": {
          name: 'dataVencimento',
          type: 'string'
        },
        "valorMinimo": {
          name: 'valorMinimo',
          type: 'number'
        },
        "dataInsercao": {
          name: 'dataInsercao',
          type: 'string'
        },
        "rentabilidadeAnual": {
          name: 'rentabilidadeAnual',
          type: 'number'
        },
        "emissor": {
          name: 'emissor',
          type: 'string'
        },
        "distribuidor": {
          name: 'distribuidor',
          type: 'string'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "ativo": {
          name: 'ativo',
          type: 'string'
        },
        "percentual": {
          name: 'percentual',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
