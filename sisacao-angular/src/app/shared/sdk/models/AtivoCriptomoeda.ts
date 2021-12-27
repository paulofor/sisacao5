/* tslint:disable */

declare var Object: any;
export interface AtivoCriptomoedaInterface {
  "ticker"?: string;
  "nome"?: string;
  "dataInicial"?: string;
  "tipo"?: string;
  "intervaloMercadoBitcoin"?: number;
  "valorMercado"?: number;
  "posicao"?: number;
  "foxbit"?: number;
}

export class AtivoCriptomoeda implements AtivoCriptomoedaInterface {
  "ticker": string;
  "nome": string;
  "dataInicial": string;
  "tipo": string;
  "intervaloMercadoBitcoin": number;
  "valorMercado": number;
  "posicao": number;
  "foxbit": number;
  constructor(data?: AtivoCriptomoedaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtivoCriptomoeda`.
   */
  public static getModelName() {
    return "AtivoCriptomoeda";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtivoCriptomoeda for dynamic purposes.
  **/
  public static factory(data: AtivoCriptomoedaInterface): AtivoCriptomoeda{
    return new AtivoCriptomoeda(data);
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
      name: 'AtivoCriptomoeda',
      plural: 'AtivoCriptomoedas',
      path: 'AtivoCriptomoedas',
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
        "dataInicial": {
          name: 'dataInicial',
          type: 'string'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "intervaloMercadoBitcoin": {
          name: 'intervaloMercadoBitcoin',
          type: 'number'
        },
        "valorMercado": {
          name: 'valorMercado',
          type: 'number'
        },
        "posicao": {
          name: 'posicao',
          type: 'number'
        },
        "foxbit": {
          name: 'foxbit',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
