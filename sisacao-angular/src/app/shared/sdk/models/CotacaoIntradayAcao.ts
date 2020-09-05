/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayAcaoInterface {
  "valor"?: number;
  "data"?: string;
  "hora"?: string;
  "id"?: number;
}

export class CotacaoIntradayAcao implements CotacaoIntradayAcaoInterface {
  "valor": number;
  "data": string;
  "hora": string;
  "id": number;
  constructor(data?: CotacaoIntradayAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayAcao`.
   */
  public static getModelName() {
    return "CotacaoIntradayAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayAcao for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayAcaoInterface): CotacaoIntradayAcao{
    return new CotacaoIntradayAcao(data);
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
      name: 'CotacaoIntradayAcao',
      plural: 'CotacaoIntradayAcaos',
      path: 'CotacaoIntradayAcaos',
      idName: 'id',
      properties: {
        "valor": {
          name: 'valor',
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
