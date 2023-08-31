/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayIndiceInterface {
  "ticker"?: string;
  "valor"?: number;
  "dataHoraNegStr"?: string;
  "dataHora"?: Date;
  "dia"?: Date;
}

export class CotacaoIntradayIndice implements CotacaoIntradayIndiceInterface {
  "ticker": string;
  "valor": number;
  "dataHoraNegStr": string;
  "dataHora": Date;
  "dia": Date;
  constructor(data?: CotacaoIntradayIndiceInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayIndice`.
   */
  public static getModelName() {
    return "CotacaoIntradayIndice";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayIndice for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayIndiceInterface): CotacaoIntradayIndice{
    return new CotacaoIntradayIndice(data);
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
      name: 'CotacaoIntradayIndice',
      plural: 'CotacaoIntradayIndices',
      path: 'CotacaoIntradayIndices',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "dataHoraNegStr": {
          name: 'dataHoraNegStr',
          type: 'string'
        },
        "dataHora": {
          name: 'dataHora',
          type: 'Date'
        },
        "dia": {
          name: 'dia',
          type: 'Date'
        },
      },
      relations: {
      }
    }
  }
}
