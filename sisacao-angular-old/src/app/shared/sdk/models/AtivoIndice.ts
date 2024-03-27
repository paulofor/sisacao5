/* tslint:disable */

declare var Object: any;
export interface AtivoIndiceInterface {
  "ticker"?: string;
  "nome"?: string;
  "intraday5"?: number;
  "intraday15"?: number;
  "intraday30"?: number;
  "intraday10"?: number;
}

export class AtivoIndice implements AtivoIndiceInterface {
  "ticker": string;
  "nome": string;
  "intraday5": number;
  "intraday15": number;
  "intraday30": number;
  "intraday10": number;
  constructor(data?: AtivoIndiceInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtivoIndice`.
   */
  public static getModelName() {
    return "AtivoIndice";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtivoIndice for dynamic purposes.
  **/
  public static factory(data: AtivoIndiceInterface): AtivoIndice{
    return new AtivoIndice(data);
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
      name: 'AtivoIndice',
      plural: 'AtivoIndices',
      path: 'AtivoIndices',
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
        "intraday10": {
          name: 'intraday10',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
