/* tslint:disable */
import {
  FechamentoRegraDia
} from '../index';

declare var Object: any;
export interface FechamentoPontoSaidaInterface {
  "diaHoraNumTickerEntrada"?: string;
  "diaNumSaida"?: number;
  "fechamentoRegraDiaId"?: number;
  "passo"?: number;
  "resultado"?: number;
  "ticker"?: string;
  "dataHoraEntrada"?: Date;
  "dataHoraSaida"?: Date;
  "valorEntrada"?: number;
  "valorSaida"?: number;
  fechamentoRegraDia?: FechamentoRegraDia;
}

export class FechamentoPontoSaida implements FechamentoPontoSaidaInterface {
  "diaHoraNumTickerEntrada": string;
  "diaNumSaida": number;
  "fechamentoRegraDiaId": number;
  "passo": number;
  "resultado": number;
  "ticker": string;
  "dataHoraEntrada": Date;
  "dataHoraSaida": Date;
  "valorEntrada": number;
  "valorSaida": number;
  fechamentoRegraDia: FechamentoRegraDia;
  constructor(data?: FechamentoPontoSaidaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `FechamentoPontoSaida`.
   */
  public static getModelName() {
    return "FechamentoPontoSaida";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of FechamentoPontoSaida for dynamic purposes.
  **/
  public static factory(data: FechamentoPontoSaidaInterface): FechamentoPontoSaida{
    return new FechamentoPontoSaida(data);
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
      name: 'FechamentoPontoSaida',
      plural: 'FechamentoPontoSaidas',
      path: 'FechamentoPontoSaidas',
      idName: 'diaHoraNumTickerEntrada',
      properties: {
        "diaHoraNumTickerEntrada": {
          name: 'diaHoraNumTickerEntrada',
          type: 'string'
        },
        "diaNumSaida": {
          name: 'diaNumSaida',
          type: 'number'
        },
        "fechamentoRegraDiaId": {
          name: 'fechamentoRegraDiaId',
          type: 'number'
        },
        "passo": {
          name: 'passo',
          type: 'number'
        },
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "dataHoraEntrada": {
          name: 'dataHoraEntrada',
          type: 'Date'
        },
        "dataHoraSaida": {
          name: 'dataHoraSaida',
          type: 'Date'
        },
        "valorEntrada": {
          name: 'valorEntrada',
          type: 'number'
        },
        "valorSaida": {
          name: 'valorSaida',
          type: 'number'
        },
      },
      relations: {
        fechamentoRegraDia: {
          name: 'fechamentoRegraDia',
          type: 'FechamentoRegraDia',
          model: 'FechamentoRegraDia',
          relationType: 'belongsTo',
                  keyFrom: 'fechamentoRegraDiaId',
          keyTo: 'id'
        },
      }
    }
  }
}
