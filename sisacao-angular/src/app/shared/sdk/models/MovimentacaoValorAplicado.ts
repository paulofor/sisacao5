/* tslint:disable */
import {
  TipoAplicacao,
  InstituicaoFinanceira
} from '../index';

declare var Object: any;
export interface MovimentacaoValorAplicadoInterface {
  "valor"?: number;
  "data"?: string;
  "tipoMovimentacao"?: string;
  "id"?: number;
  "tipoAplicacaoId"?: number;
  "instituicaoFinanceiraId"?: number;
  tipoAplicacao?: TipoAplicacao;
  instituicaoFinanceira?: InstituicaoFinanceira;
}

export class MovimentacaoValorAplicado implements MovimentacaoValorAplicadoInterface {
  "valor": number;
  "data": string;
  "tipoMovimentacao": string;
  "id": number;
  "tipoAplicacaoId": number;
  "instituicaoFinanceiraId": number;
  tipoAplicacao: TipoAplicacao;
  instituicaoFinanceira: InstituicaoFinanceira;
  constructor(data?: MovimentacaoValorAplicadoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `MovimentacaoValorAplicado`.
   */
  public static getModelName() {
    return "MovimentacaoValorAplicado";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of MovimentacaoValorAplicado for dynamic purposes.
  **/
  public static factory(data: MovimentacaoValorAplicadoInterface): MovimentacaoValorAplicado{
    return new MovimentacaoValorAplicado(data);
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
      name: 'MovimentacaoValorAplicado',
      plural: 'MovimentacaoValorAplicados',
      path: 'MovimentacaoValorAplicados',
      idName: 'id',
      properties: {
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "data": {
          name: 'data',
          type: 'string'
        },
        "tipoMovimentacao": {
          name: 'tipoMovimentacao',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "tipoAplicacaoId": {
          name: 'tipoAplicacaoId',
          type: 'number'
        },
        "instituicaoFinanceiraId": {
          name: 'instituicaoFinanceiraId',
          type: 'number'
        },
      },
      relations: {
        tipoAplicacao: {
          name: 'tipoAplicacao',
          type: 'TipoAplicacao',
          model: 'TipoAplicacao',
          relationType: 'belongsTo',
                  keyFrom: 'tipoAplicacaoId',
          keyTo: 'id'
        },
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
