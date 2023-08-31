/* tslint:disable */

declare var Object: any;
export interface ExemploDadoSinteticoInterface {
  "campoX"?: string;
  "campoXOriginal"?: string;
  "campoY"?: string;
  "resultado"?: number;
  "id"?: number;
  "amostraDadoSinteticoId"?: number;
}

export class ExemploDadoSintetico implements ExemploDadoSinteticoInterface {
  "campoX": string;
  "campoXOriginal": string;
  "campoY": string;
  "resultado": number;
  "id": number;
  "amostraDadoSinteticoId": number;
  constructor(data?: ExemploDadoSinteticoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExemploDadoSintetico`.
   */
  public static getModelName() {
    return "ExemploDadoSintetico";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExemploDadoSintetico for dynamic purposes.
  **/
  public static factory(data: ExemploDadoSinteticoInterface): ExemploDadoSintetico{
    return new ExemploDadoSintetico(data);
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
      name: 'ExemploDadoSintetico',
      plural: 'ExemploDadoSinteticos',
      path: 'ExemploDadoSinteticos',
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
        "amostraDadoSinteticoId": {
          name: 'amostraDadoSinteticoId',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
