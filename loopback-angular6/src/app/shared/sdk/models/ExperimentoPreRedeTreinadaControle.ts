/* tslint:disable */

declare var Object: any;
export interface ExperimentoPreRedeTreinadaControleInterface {
  "diaNum"?: number;
  "ticker"?: string;
  "experimentoPreRedeTreinadaId"?: number;
  "valorEntrada"?: number;
  "valorSaida"?: number;
  "resultado"?: number;
  "diaNumEntrada"?: number;
  "diaNumSaida"?: number;
}

export class ExperimentoPreRedeTreinadaControle implements ExperimentoPreRedeTreinadaControleInterface {
  "diaNum": number;
  "ticker": string;
  "experimentoPreRedeTreinadaId": number;
  "valorEntrada": number;
  "valorSaida": number;
  "resultado": number;
  "diaNumEntrada": number;
  "diaNumSaida": number;
  constructor(data?: ExperimentoPreRedeTreinadaControleInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoPreRedeTreinadaControle`.
   */
  public static getModelName() {
    return "ExperimentoPreRedeTreinadaControle";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoPreRedeTreinadaControle for dynamic purposes.
  **/
  public static factory(data: ExperimentoPreRedeTreinadaControleInterface): ExperimentoPreRedeTreinadaControle{
    return new ExperimentoPreRedeTreinadaControle(data);
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
      name: 'ExperimentoPreRedeTreinadaControle',
      plural: 'ExperimentoPreRedeTreinadaControles',
      path: 'ExperimentoPreRedeTreinadaControles',
      idName: 'diaNum',
      properties: {
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "experimentoPreRedeTreinadaId": {
          name: 'experimentoPreRedeTreinadaId',
          type: 'number'
        },
        "valorEntrada": {
          name: 'valorEntrada',
          type: 'number'
        },
        "valorSaida": {
          name: 'valorSaida',
          type: 'number'
        },
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
        "diaNumEntrada": {
          name: 'diaNumEntrada',
          type: 'number'
        },
        "diaNumSaida": {
          name: 'diaNumSaida',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
