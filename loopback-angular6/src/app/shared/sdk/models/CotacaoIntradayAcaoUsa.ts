/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayAcaoUsaInterface {
  "id"?: number;
}

export class CotacaoIntradayAcaoUsa implements CotacaoIntradayAcaoUsaInterface {
  "id": number;
  constructor(data?: CotacaoIntradayAcaoUsaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayAcaoUsa`.
   */
  public static getModelName() {
    return "CotacaoIntradayAcaoUsa";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayAcaoUsa for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayAcaoUsaInterface): CotacaoIntradayAcaoUsa{
    return new CotacaoIntradayAcaoUsa(data);
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
      name: 'CotacaoIntradayAcaoUsa',
      plural: 'CotacaoIntradayAcaoUsas',
      path: 'CotacaoIntradayAcaoUsas',
      idName: 'id',
      properties: {
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
