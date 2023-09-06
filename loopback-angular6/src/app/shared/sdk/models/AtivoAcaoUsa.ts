/* tslint:disable */

declare var Object: any;
export interface AtivoAcaoUsaInterface {
  "nome"?: string;
  "ticker"?: string;
  "id"?: number;
}

export class AtivoAcaoUsa implements AtivoAcaoUsaInterface {
  "nome": string;
  "ticker": string;
  "id": number;
  constructor(data?: AtivoAcaoUsaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtivoAcaoUsa`.
   */
  public static getModelName() {
    return "AtivoAcaoUsa";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtivoAcaoUsa for dynamic purposes.
  **/
  public static factory(data: AtivoAcaoUsaInterface): AtivoAcaoUsa{
    return new AtivoAcaoUsa(data);
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
      name: 'AtivoAcaoUsa',
      plural: 'AtivoAcaoUsas',
      path: 'AtivoAcaoUsas',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "ticker": {
          name: 'ticker',
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
