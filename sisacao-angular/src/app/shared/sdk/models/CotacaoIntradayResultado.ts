/* tslint:disable */

declare var Object: any;
export interface CotacaoIntradayResultadoInterface {
  "ticker"?: string;
  "valor"?: number;
  "dataHoraNegStr"?: string;
  "dataHora"?: Date;
  "dia"?: Date;
  "tg12St12"?: number;
  "tg13St13"?: number;
}

export class CotacaoIntradayResultado implements CotacaoIntradayResultadoInterface {
  "ticker": string;
  "valor": number;
  "dataHoraNegStr": string;
  "dataHora": Date;
  "dia": Date;
  "tg12St12": number;
  "tg13St13": number;
  constructor(data?: CotacaoIntradayResultadoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CotacaoIntradayResultado`.
   */
  public static getModelName() {
    return "CotacaoIntradayResultado";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CotacaoIntradayResultado for dynamic purposes.
  **/
  public static factory(data: CotacaoIntradayResultadoInterface): CotacaoIntradayResultado{
    return new CotacaoIntradayResultado(data);
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
      name: 'CotacaoIntradayResultado',
      plural: 'CotacaoIntradayResultados',
      path: 'CotacaoIntradayResultados',
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
        "tg12St12": {
          name: 'tg12St12',
          type: 'number'
        },
        "tg13St13": {
          name: 'tg13St13',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
