/* tslint:disable */

declare var Object: any;
export interface AluguelFundoImobiliarioInterface {
  "ticker"?: string;
  "valor"?: number;
  "dataCom"?: string;
  "dataPagamento"?: string;
  "cotacao"?: number;
  "percentual"?: number;
  "tipo"?: string;
  "id"?: number;
}

export class AluguelFundoImobiliario implements AluguelFundoImobiliarioInterface {
  "ticker": string;
  "valor": number;
  "dataCom": string;
  "dataPagamento": string;
  "cotacao": number;
  "percentual": number;
  "tipo": string;
  "id": number;
  constructor(data?: AluguelFundoImobiliarioInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AluguelFundoImobiliario`.
   */
  public static getModelName() {
    return "AluguelFundoImobiliario";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AluguelFundoImobiliario for dynamic purposes.
  **/
  public static factory(data: AluguelFundoImobiliarioInterface): AluguelFundoImobiliario{
    return new AluguelFundoImobiliario(data);
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
      name: 'AluguelFundoImobiliario',
      plural: 'AluguelFundoImobiliarios',
      path: 'AluguelFundoImobiliarios',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "dataCom": {
          name: 'dataCom',
          type: 'string'
        },
        "dataPagamento": {
          name: 'dataPagamento',
          type: 'string'
        },
        "cotacao": {
          name: 'cotacao',
          type: 'number'
        },
        "percentual": {
          name: 'percentual',
          type: 'number'
        },
        "tipo": {
          name: 'tipo',
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
