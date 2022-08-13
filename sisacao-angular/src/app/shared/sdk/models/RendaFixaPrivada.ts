/* tslint:disable */

declare var Object: any;
export interface RendaFixaPrivadaInterface {
  "nome"?: string;
  "emissor"?: string;
  "distribuidor"?: string;
  "vencimento"?: string;
  "rentabilidadeAnualCalculada"?: number;
  "tipo"?: string;
  "valorMinimo"?: number;
  "dataInsercao"?: string;
  "dataAcesso"?: string;
  "id"?: number;
}

export class RendaFixaPrivada implements RendaFixaPrivadaInterface {
  "nome": string;
  "emissor": string;
  "distribuidor": string;
  "vencimento": string;
  "rentabilidadeAnualCalculada": number;
  "tipo": string;
  "valorMinimo": number;
  "dataInsercao": string;
  "dataAcesso": string;
  "id": number;
  constructor(data?: RendaFixaPrivadaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RendaFixaPrivada`.
   */
  public static getModelName() {
    return "RendaFixaPrivada";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RendaFixaPrivada for dynamic purposes.
  **/
  public static factory(data: RendaFixaPrivadaInterface): RendaFixaPrivada{
    return new RendaFixaPrivada(data);
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
      name: 'RendaFixaPrivada',
      plural: 'RendaFixaPrivadas',
      path: 'RendaFixaPrivadas',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "emissor": {
          name: 'emissor',
          type: 'string'
        },
        "distribuidor": {
          name: 'distribuidor',
          type: 'string'
        },
        "vencimento": {
          name: 'vencimento',
          type: 'string'
        },
        "rentabilidadeAnualCalculada": {
          name: 'rentabilidadeAnualCalculada',
          type: 'number'
        },
        "tipo": {
          name: 'tipo',
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
        "dataAcesso": {
          name: 'dataAcesso',
          type: 'string'
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
