/* tslint:disable */

declare var Object: any;
export interface IndiceAcaoInterface {
  "ticker"?: string;
  "nome"?: string;
  "id"?: number;
}

export class IndiceAcao implements IndiceAcaoInterface {
  "ticker": string;
  "nome": string;
  "id": number;
  constructor(data?: IndiceAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `IndiceAcao`.
   */
  public static getModelName() {
    return "IndiceAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of IndiceAcao for dynamic purposes.
  **/
  public static factory(data: IndiceAcaoInterface): IndiceAcao{
    return new IndiceAcao(data);
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
      name: 'IndiceAcao',
      plural: 'IndiceAcaos',
      path: 'IndiceAcaos',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "nome": {
          name: 'nome',
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
