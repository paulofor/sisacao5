/* tslint:disable */

declare var Object: any;
export interface PontoEntradaSimulacaoInterface {
  "ticker"?: string;
  "periodoExperimentoId"?: number;
  "diaNum"?: number;
  "tipo"?: string;
  "valor"?: number;
  "valorLimite"?: number;
  "id"?: number;
}

export class PontoEntradaSimulacao implements PontoEntradaSimulacaoInterface {
  "ticker": string;
  "periodoExperimentoId": number;
  "diaNum": number;
  "tipo": string;
  "valor": number;
  "valorLimite": number;
  "id": number;
  constructor(data?: PontoEntradaSimulacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PontoEntradaSimulacao`.
   */
  public static getModelName() {
    return "PontoEntradaSimulacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PontoEntradaSimulacao for dynamic purposes.
  **/
  public static factory(data: PontoEntradaSimulacaoInterface): PontoEntradaSimulacao{
    return new PontoEntradaSimulacao(data);
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
      name: 'PontoEntradaSimulacao',
      plural: 'PontoEntradaSimulacaos',
      path: 'PontoEntradaSimulacaos',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "periodoExperimentoId": {
          name: 'periodoExperimentoId',
          type: 'number'
        },
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "valorLimite": {
          name: 'valorLimite',
          type: 'number'
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
