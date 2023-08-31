/* tslint:disable */

declare var Object: any;
export interface ExperimentoPreRedeTreinadaScoreInterface {
  "diaNum"?: number;
  "score"?: number;
  "ticker"?: string;
  "experimentoPreRedeTreinadaId"?: number;
  "valorEntrada"?: number;
  "valorSaida"?: number;
  "diaNumEntrada"?: number;
  "diaNumSaida"?: number;
  "resultado"?: number;
}

export class ExperimentoPreRedeTreinadaScore implements ExperimentoPreRedeTreinadaScoreInterface {
  "diaNum": number;
  "score": number;
  "ticker": string;
  "experimentoPreRedeTreinadaId": number;
  "valorEntrada": number;
  "valorSaida": number;
  "diaNumEntrada": number;
  "diaNumSaida": number;
  "resultado": number;
  constructor(data?: ExperimentoPreRedeTreinadaScoreInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoPreRedeTreinadaScore`.
   */
  public static getModelName() {
    return "ExperimentoPreRedeTreinadaScore";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoPreRedeTreinadaScore for dynamic purposes.
  **/
  public static factory(data: ExperimentoPreRedeTreinadaScoreInterface): ExperimentoPreRedeTreinadaScore{
    return new ExperimentoPreRedeTreinadaScore(data);
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
      name: 'ExperimentoPreRedeTreinadaScore',
      plural: 'ExperimentoPreRedeTreinadaScores',
      path: 'ExperimentoPreRedeTreinadaScores',
      idName: 'diaNum',
      properties: {
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "score": {
          name: 'score',
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
        "diaNumEntrada": {
          name: 'diaNumEntrada',
          type: 'number'
        },
        "diaNumSaida": {
          name: 'diaNumSaida',
          type: 'number'
        },
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
