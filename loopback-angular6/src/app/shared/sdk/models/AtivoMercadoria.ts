/* tslint:disable */

declare var Object: any;
export interface AtivoMercadoriaInterface {
  "ticker"?: string;
  "nome"?: string;
  "intraday5"?: number;
  "intraday15"?: number;
  "intraday30"?: number;
}

export class AtivoMercadoria implements AtivoMercadoriaInterface {
  "ticker": string;
  "nome": string;
  "intraday5": number;
  "intraday15": number;
  "intraday30": number;
  constructor(data?: AtivoMercadoriaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtivoMercadoria`.
   */
  public static getModelName() {
    return "AtivoMercadoria";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtivoMercadoria for dynamic purposes.
  **/
  public static factory(data: AtivoMercadoriaInterface): AtivoMercadoria{
    return new AtivoMercadoria(data);
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
      name: 'AtivoMercadoria',
      plural: 'AtivoMercadoria',
      path: 'AtivoMercadoria',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "intraday5": {
          name: 'intraday5',
          type: 'number'
        },
        "intraday15": {
          name: 'intraday15',
          type: 'number'
        },
        "intraday30": {
          name: 'intraday30',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
