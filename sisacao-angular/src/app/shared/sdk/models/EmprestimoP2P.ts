/* tslint:disable */
import {
  ParcelaEmprestimo
} from '../index';

declare var Object: any;
export interface EmprestimoP2PInterface {
  "nomePessoa"?: string;
  "cpf"?: string;
  "valorCota"?: number;
  "valorEmprestimo"?: number;
  "dataCompra"?: Date;
  "quantidadeCota"?: number;
  "quantidadeParcela"?: number;
  "ativo"?: number;
  "valorPresente"?: number;
  "roi"?: number;
  "dataPrimeiraParcela"?: Date;
  "rentabilidadeAnual"?: number;
  "totalRecebido"?: number;
  "valorParcela"?: number;
  "previsaoRecebimento"?: number;
  "previsaoTotal"?: number;
  "quantidadeRecebida"?: number;
  "quantidadeFutura"?: number;
  "parcelaMinima"?: number;
  "quantidadeEmAtraso"?: number;
  "dataUltimaParcela"?: Date;
  "previsaoLucroPrejuizo"?: number;
  "id"?: number;
  parcelaEmprestimos?: ParcelaEmprestimo[];
}

export class EmprestimoP2P implements EmprestimoP2PInterface {
  "nomePessoa": string;
  "cpf": string;
  "valorCota": number;
  "valorEmprestimo": number;
  "dataCompra": Date;
  "quantidadeCota": number;
  "quantidadeParcela": number;
  "ativo": number;
  "valorPresente": number;
  "roi": number;
  "dataPrimeiraParcela": Date;
  "rentabilidadeAnual": number;
  "totalRecebido": number;
  "valorParcela": number;
  "previsaoRecebimento": number;
  "previsaoTotal": number;
  "quantidadeRecebida": number;
  "quantidadeFutura": number;
  "parcelaMinima": number;
  "quantidadeEmAtraso": number;
  "dataUltimaParcela": Date;
  "previsaoLucroPrejuizo": number;
  "id": number;
  parcelaEmprestimos: ParcelaEmprestimo[];
  constructor(data?: EmprestimoP2PInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `EmprestimoP2P`.
   */
  public static getModelName() {
    return "EmprestimoP2P";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of EmprestimoP2P for dynamic purposes.
  **/
  public static factory(data: EmprestimoP2PInterface): EmprestimoP2P{
    return new EmprestimoP2P(data);
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
      name: 'EmprestimoP2P',
      plural: 'EmprestimoP2Ps',
      path: 'EmprestimoP2Ps',
      idName: 'id',
      properties: {
        "nomePessoa": {
          name: 'nomePessoa',
          type: 'string'
        },
        "cpf": {
          name: 'cpf',
          type: 'string'
        },
        "valorCota": {
          name: 'valorCota',
          type: 'number'
        },
        "valorEmprestimo": {
          name: 'valorEmprestimo',
          type: 'number'
        },
        "dataCompra": {
          name: 'dataCompra',
          type: 'Date'
        },
        "quantidadeCota": {
          name: 'quantidadeCota',
          type: 'number'
        },
        "quantidadeParcela": {
          name: 'quantidadeParcela',
          type: 'number'
        },
        "ativo": {
          name: 'ativo',
          type: 'number'
        },
        "valorPresente": {
          name: 'valorPresente',
          type: 'number'
        },
        "roi": {
          name: 'roi',
          type: 'number'
        },
        "dataPrimeiraParcela": {
          name: 'dataPrimeiraParcela',
          type: 'Date'
        },
        "rentabilidadeAnual": {
          name: 'rentabilidadeAnual',
          type: 'number'
        },
        "totalRecebido": {
          name: 'totalRecebido',
          type: 'number'
        },
        "valorParcela": {
          name: 'valorParcela',
          type: 'number'
        },
        "previsaoRecebimento": {
          name: 'previsaoRecebimento',
          type: 'number'
        },
        "previsaoTotal": {
          name: 'previsaoTotal',
          type: 'number'
        },
        "quantidadeRecebida": {
          name: 'quantidadeRecebida',
          type: 'number'
        },
        "quantidadeFutura": {
          name: 'quantidadeFutura',
          type: 'number'
        },
        "parcelaMinima": {
          name: 'parcelaMinima',
          type: 'number'
        },
        "quantidadeEmAtraso": {
          name: 'quantidadeEmAtraso',
          type: 'number'
        },
        "dataUltimaParcela": {
          name: 'dataUltimaParcela',
          type: 'Date'
        },
        "previsaoLucroPrejuizo": {
          name: 'previsaoLucroPrejuizo',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        parcelaEmprestimos: {
          name: 'parcelaEmprestimos',
          type: 'ParcelaEmprestimo[]',
          model: 'ParcelaEmprestimo',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'emprestimoP2PId'
        },
      }
    }
  }
}
