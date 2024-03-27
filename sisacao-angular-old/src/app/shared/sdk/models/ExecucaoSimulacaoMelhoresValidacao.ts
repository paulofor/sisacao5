/* tslint:disable */

declare var Object: any;
export interface ExecucaoSimulacaoMelhoresValidacaoInterface {
  "execucaoSimulacaoId"?: number;
  "simulacaoQtdeLucro"?: number;
  "simulacaoQtdePrejuizo"?: number;
  "ticker"?: string;
  "target"?: number;
  "stop"?: number;
  "resultado"?: number;
  "experimentoSimulacaoId"?: number;
  "periodoExperimentoId"?: number;
  "tipo"?: string;
  "validacaoQtdeLucro"?: number;
  "validacaoQtdePrejuizo"?: number;
  "validacaoDiferenca"?: number;
  "id"?: number;
}

export class ExecucaoSimulacaoMelhoresValidacao implements ExecucaoSimulacaoMelhoresValidacaoInterface {
  "execucaoSimulacaoId": number;
  "simulacaoQtdeLucro": number;
  "simulacaoQtdePrejuizo": number;
  "ticker": string;
  "target": number;
  "stop": number;
  "resultado": number;
  "experimentoSimulacaoId": number;
  "periodoExperimentoId": number;
  "tipo": string;
  "validacaoQtdeLucro": number;
  "validacaoQtdePrejuizo": number;
  "validacaoDiferenca": number;
  "id": number;
  constructor(data?: ExecucaoSimulacaoMelhoresValidacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExecucaoSimulacaoMelhoresValidacao`.
   */
  public static getModelName() {
    return "ExecucaoSimulacaoMelhoresValidacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExecucaoSimulacaoMelhoresValidacao for dynamic purposes.
  **/
  public static factory(data: ExecucaoSimulacaoMelhoresValidacaoInterface): ExecucaoSimulacaoMelhoresValidacao{
    return new ExecucaoSimulacaoMelhoresValidacao(data);
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
      name: 'ExecucaoSimulacaoMelhoresValidacao',
      plural: 'ExecucaoSimulacaoMelhoresValidacaos',
      path: 'ExecucaoSimulacaoMelhoresValidacaos',
      idName: 'id',
      properties: {
        "execucaoSimulacaoId": {
          name: 'execucaoSimulacaoId',
          type: 'number'
        },
        "simulacaoQtdeLucro": {
          name: 'simulacaoQtdeLucro',
          type: 'number'
        },
        "simulacaoQtdePrejuizo": {
          name: 'simulacaoQtdePrejuizo',
          type: 'number'
        },
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "target": {
          name: 'target',
          type: 'number'
        },
        "stop": {
          name: 'stop',
          type: 'number'
        },
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
        "experimentoSimulacaoId": {
          name: 'experimentoSimulacaoId',
          type: 'number'
        },
        "periodoExperimentoId": {
          name: 'periodoExperimentoId',
          type: 'number'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "validacaoQtdeLucro": {
          name: 'validacaoQtdeLucro',
          type: 'number'
        },
        "validacaoQtdePrejuizo": {
          name: 'validacaoQtdePrejuizo',
          type: 'number'
        },
        "validacaoDiferenca": {
          name: 'validacaoDiferenca',
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
