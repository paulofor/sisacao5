/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayOpcaoInterface {
  "ult"?: number;
  "data"?: string;
  "hora"?: string;
  "id"?: number;
}

export class CotacaoIntradayOpcao implements CotacaoIntradayOpcaoInterface {
  "ult": number;
  "data": string;
  "hora": string;
  "id": number;
  constructor(data?: CotacaoIntradayOpcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayOpcao`.
   */
  public static getModelName() {
    return "CotacaoIntradayOpcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayOpcao for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayOpcaoInterface): CotacaoIntradayOpcao{
    return new CotacaoIntradayOpcao(data);
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
      name: 'CotacaoIntradayOpcao',
      plural: 'CotacaoIntradayOpcaos',
      path: 'CotacaoIntradayOpcaos',
      idName: 'id',
      properties: {
        "ult": {
          name: 'ult',
          type: 'number'
        },
        "data": {
          name: 'data',
          type: 'string'
        },
        "hora": {
          name: 'hora',
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
