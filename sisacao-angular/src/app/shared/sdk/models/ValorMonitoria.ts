/* tslint:disable */
import {
  ExecucaoSimulacao
} from '../index';

declare var Object: any;
export interface ValorMonitoriaInterface {
  "valorEntrada"?: number;
  "ticker"?: string;
  "diaNumEntrada"?: number;
  "situacao"?: string;
  "valorTarget"?: number;
  "valorStop"?: number;
  "posicao"?: number;
  "pontoEntrada"?: number;
  "quantidadeDiaTrade"?: number;
  "contaTrade"?: number;
  "id"?: number;
  "execucaoSimulacaoId"?: number;
  execucaoSimulacao?: ExecucaoSimulacao;
}

export class ValorMonitoria implements ValorMonitoriaInterface {
  "valorEntrada": number;
  "ticker": string;
  "diaNumEntrada": number;
  "situacao": string;
  "valorTarget": number;
  "valorStop": number;
  "posicao": number;
  "pontoEntrada": number;
  "quantidadeDiaTrade": number;
  "contaTrade": number;
  "id": number;
  "execucaoSimulacaoId": number;
  execucaoSimulacao: ExecucaoSimulacao;
  constructor(data?: ValorMonitoriaInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ValorMonitoria`.
   */
  public static getModelName() {
    return "ValorMonitoria";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ValorMonitoria for dynamic purposes.
  **/
  public static factory(data: ValorMonitoriaInterface): ValorMonitoria{
    return new ValorMonitoria(data);
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
      name: 'ValorMonitoria',
      plural: 'ValorMonitoria',
      path: 'ValorMonitoria',
      idName: 'id',
      properties: {
        "valorEntrada": {
          name: 'valorEntrada',
          type: 'number'
        },
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "diaNumEntrada": {
          name: 'diaNumEntrada',
          type: 'number'
        },
        "situacao": {
          name: 'situacao',
          type: 'string'
        },
        "valorTarget": {
          name: 'valorTarget',
          type: 'number'
        },
        "valorStop": {
          name: 'valorStop',
          type: 'number'
        },
        "posicao": {
          name: 'posicao',
          type: 'number'
        },
        "pontoEntrada": {
          name: 'pontoEntrada',
          type: 'number'
        },
        "quantidadeDiaTrade": {
          name: 'quantidadeDiaTrade',
          type: 'number'
        },
        "contaTrade": {
          name: 'contaTrade',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "execucaoSimulacaoId": {
          name: 'execucaoSimulacaoId',
          type: 'number'
        },
      },
      relations: {
        execucaoSimulacao: {
          name: 'execucaoSimulacao',
          type: 'ExecucaoSimulacao',
          model: 'ExecucaoSimulacao',
          relationType: 'belongsTo',
                  keyFrom: 'execucaoSimulacaoId',
          keyTo: 'id'
        },
      }
    }
  }
}
