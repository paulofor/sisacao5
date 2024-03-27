/* tslint:disable */
import {
  InstituicaoFinanceira
} from '../index';

declare var Object: any;
export interface AplicacaoInstituicaoInterface {
  "saldoAtual"?: number;
  "id"?: number;
  "instituicaoFinanceiraId"?: number;
  "tipoAplicacaoId"?: number;
  instituicaoFinanceira?: InstituicaoFinanceira;
}

export class AplicacaoInstituicao implements AplicacaoInstituicaoInterface {
  "saldoAtual": number;
  "id": number;
  "instituicaoFinanceiraId": number;
  "tipoAplicacaoId": number;
  instituicaoFinanceira: InstituicaoFinanceira;
  constructor(data?: AplicacaoInstituicaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AplicacaoInstituicao`.
   */
  public static getModelName() {
    return "AplicacaoInstituicao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AplicacaoInstituicao for dynamic purposes.
  **/
  public static factory(data: AplicacaoInstituicaoInterface): AplicacaoInstituicao{
    return new AplicacaoInstituicao(data);
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
      name: 'AplicacaoInstituicao',
      plural: 'AplicacaoInstituicaos',
      path: 'AplicacaoInstituicaos',
      idName: 'id',
      properties: {
        "saldoAtual": {
          name: 'saldoAtual',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "instituicaoFinanceiraId": {
          name: 'instituicaoFinanceiraId',
          type: 'number'
        },
        "tipoAplicacaoId": {
          name: 'tipoAplicacaoId',
          type: 'number'
        },
      },
      relations: {
        instituicaoFinanceira: {
          name: 'instituicaoFinanceira',
          type: 'InstituicaoFinanceira',
          model: 'InstituicaoFinanceira',
          relationType: 'belongsTo',
                  keyFrom: 'instituicaoFinanceiraId',
          keyTo: 'id'
        },
      }
    }
  }
}
