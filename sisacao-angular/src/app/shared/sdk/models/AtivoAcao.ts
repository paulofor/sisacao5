/* tslint:disable */

declare var Object: any;
export interface AtivoAcaoInterface {
  "ticker"?: string;
  "nome"?: string;
  "intraday5"?: number;
  "intraday15"?: number;
  "intraday30"?: number;
}

export class AtivoAcao implements AtivoAcaoInterface {
  "ticker": string;
  "nome": string;
  "intraday5": number;
  "intraday15": number;
  "intraday30": number;
  constructor(data?: AtivoAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtivoAcao`.
   */
  public static getModelName() {
    return "AtivoAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtivoAcao for dynamic purposes.
  **/
  public static factory(data: AtivoAcaoInterface): AtivoAcao{
    return new AtivoAcao(data);
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
      name: 'AtivoAcao',
      plural: 'AtivoAcaos',
      path: 'AtivoAcaos',
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
