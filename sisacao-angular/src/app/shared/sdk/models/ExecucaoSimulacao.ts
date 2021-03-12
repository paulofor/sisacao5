/* tslint:disable */
import {
  CombinacaoParametro,
  Trade
} from '../index';

declare var Object: any;
export interface ExecucaoSimulacaoInterface {
  "ticker"?: string;
  "quantidadeLucro"?: number;
  "quantidadePrejuizo"?: number;
  "target"?: number;
  "stop"?: number;
  "resultado"?: number;
  "monitorar"?: number;
  "id"?: number;
  "combinacaoParametroId"?: number;
  combinacaoParametro?: CombinacaoParametro;
  trades?: Trade[];
}

export class ExecucaoSimulacao implements ExecucaoSimulacaoInterface {
  "ticker": string;
  "quantidadeLucro": number;
  "quantidadePrejuizo": number;
  "target": number;
  "stop": number;
  "resultado": number;
  "monitorar": number;
  "id": number;
  "combinacaoParametroId": number;
  combinacaoParametro: CombinacaoParametro;
  trades: Trade[];
  constructor(data?: ExecucaoSimulacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExecucaoSimulacao`.
   */
  public static getModelName() {
    return "ExecucaoSimulacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExecucaoSimulacao for dynamic purposes.
  **/
  public static factory(data: ExecucaoSimulacaoInterface): ExecucaoSimulacao{
    return new ExecucaoSimulacao(data);
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
      name: 'ExecucaoSimulacao',
      plural: 'ExecucaoSimulacaos',
      path: 'ExecucaoSimulacaos',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "quantidadeLucro": {
          name: 'quantidadeLucro',
          type: 'number'
        },
        "quantidadePrejuizo": {
          name: 'quantidadePrejuizo',
          type: 'number'
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
        "monitorar": {
          name: 'monitorar',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "combinacaoParametroId": {
          name: 'combinacaoParametroId',
          type: 'number'
        },
      },
      relations: {
        combinacaoParametro: {
          name: 'combinacaoParametro',
          type: 'CombinacaoParametro',
          model: 'CombinacaoParametro',
          relationType: 'belongsTo',
                  keyFrom: 'combinacaoParametroId',
          keyTo: 'id'
        },
        trades: {
          name: 'trades',
          type: 'Trade[]',
          model: 'Trade',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'execucaoSimulacaoId'
        },
      }
    }
  }
}
