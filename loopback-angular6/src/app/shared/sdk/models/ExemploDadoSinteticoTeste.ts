/* tslint:disable */

declare var Object: any;
export interface ExemploDadoSinteticoTesteInterface {
  "campoX"?: string;
  "campoXOriginal"?: string;
  "campoY"?: string;
  "resultado"?: number;
  "id"?: number;
}

export class ExemploDadoSinteticoTeste implements ExemploDadoSinteticoTesteInterface {
  "campoX": string;
  "campoXOriginal": string;
  "campoY": string;
  "resultado": number;
  "id": number;
  constructor(data?: ExemploDadoSinteticoTesteInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExemploDadoSinteticoTeste`.
   */
  public static getModelName() {
    return "ExemploDadoSinteticoTeste";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExemploDadoSinteticoTeste for dynamic purposes.
  **/
  public static factory(data: ExemploDadoSinteticoTesteInterface): ExemploDadoSinteticoTeste{
    return new ExemploDadoSinteticoTeste(data);
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
      name: 'ExemploDadoSinteticoTeste',
      plural: 'ExemploDadoSinteticoTestes',
      path: 'ExemploDadoSinteticoTestes',
      idName: 'id',
      properties: {
        "campoX": {
          name: 'campoX',
          type: 'string'
        },
        "campoXOriginal": {
          name: 'campoXOriginal',
          type: 'string'
        },
        "campoY": {
          name: 'campoY',
          type: 'string'
        },
        "resultado": {
          name: 'resultado',
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
