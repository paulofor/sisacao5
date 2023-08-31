/* tslint:disable */
import {
  ExecucaoSimulacao
} from '../index';

declare var Object: any;
export interface OrdemCompraInterface {
  "ticker"?: string;
  "precoCompra"?: number;
  "valorExposicao"?: number;
  "quantidade"?: number;
  "fracionario"?: number;
  "lucroAlvo"?: number;
  "aberta"?: number;
  "id"?: number;
  "execucaoSimulacaoId"?: number;
  execucaoSimulacao?: ExecucaoSimulacao;
}

export class OrdemCompra implements OrdemCompraInterface {
  "ticker": string;
  "precoCompra": number;
  "valorExposicao": number;
  "quantidade": number;
  "fracionario": number;
  "lucroAlvo": number;
  "aberta": number;
  "id": number;
  "execucaoSimulacaoId": number;
  execucaoSimulacao: ExecucaoSimulacao;
  constructor(data?: OrdemCompraInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `OrdemCompra`.
   */
  public static getModelName() {
    return "OrdemCompra";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of OrdemCompra for dynamic purposes.
  **/
  public static factory(data: OrdemCompraInterface): OrdemCompra{
    return new OrdemCompra(data);
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
      name: 'OrdemCompra',
      plural: 'OrdemCompras',
      path: 'OrdemCompras',
      idName: 'id',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "precoCompra": {
          name: 'precoCompra',
          type: 'number'
        },
        "valorExposicao": {
          name: 'valorExposicao',
          type: 'number'
        },
        "quantidade": {
          name: 'quantidade',
          type: 'number'
        },
        "fracionario": {
          name: 'fracionario',
          type: 'number'
        },
        "lucroAlvo": {
          name: 'lucroAlvo',
          type: 'number'
        },
        "aberta": {
          name: 'aberta',
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
