/* tslint:disable */
import {
  EmprestimoP2P
} from '../index';

declare var Object: any;
export interface ParcelaEmprestimoInterface {
  "numeroParcela"?: number;
  "dataVencimento"?: Date;
  "dataRecebimento"?: Date;
  "valor"?: number;
  "valorPresente"?: number;
  "valorRecebido"?: number;
  "valorPrevisto"?: number;
  "pago"?: number;
  "id"?: number;
  "emprestimoP2PId"?: number;
  emprestimoP2P?: EmprestimoP2P;
}

export class ParcelaEmprestimo implements ParcelaEmprestimoInterface {
  "numeroParcela": number;
  "dataVencimento": Date;
  "dataRecebimento": Date;
  "valor": number;
  "valorPresente": number;
  "valorRecebido": number;
  "valorPrevisto": number;
  "pago": number;
  "id": number;
  "emprestimoP2PId": number;
  emprestimoP2P: EmprestimoP2P;
  constructor(data?: ParcelaEmprestimoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ParcelaEmprestimo`.
   */
  public static getModelName() {
    return "ParcelaEmprestimo";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ParcelaEmprestimo for dynamic purposes.
  **/
  public static factory(data: ParcelaEmprestimoInterface): ParcelaEmprestimo{
    return new ParcelaEmprestimo(data);
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
      name: 'ParcelaEmprestimo',
      plural: 'ParcelaEmprestimos',
      path: 'ParcelaEmprestimos',
      idName: 'id',
      properties: {
        "numeroParcela": {
          name: 'numeroParcela',
          type: 'number'
        },
        "dataVencimento": {
          name: 'dataVencimento',
          type: 'Date'
        },
        "dataRecebimento": {
          name: 'dataRecebimento',
          type: 'Date'
        },
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "valorPresente": {
          name: 'valorPresente',
          type: 'number'
        },
        "valorRecebido": {
          name: 'valorRecebido',
          type: 'number'
        },
        "valorPrevisto": {
          name: 'valorPrevisto',
          type: 'number'
        },
        "pago": {
          name: 'pago',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "emprestimoP2PId": {
          name: 'emprestimoP2PId',
          type: 'number'
        },
      },
      relations: {
        emprestimoP2P: {
          name: 'emprestimoP2P',
          type: 'EmprestimoP2P',
          model: 'EmprestimoP2P',
          relationType: 'belongsTo',
                  keyFrom: 'emprestimoP2PId',
          keyTo: 'id'
        },
      }
    }
  }
}
