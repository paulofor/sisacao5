/* tslint:disable */
import {
  InstituicaoFinanceira,
  TipoAplicacao
} from '../index';

declare var Object: any;
export interface FinanceiroAcaoFixoInterface {
  "valorAtual"?: number;
  "dataAlteracao"?: Date;
  "tipoAplicacaoId"?: number;
  "instituicaoFinanceiraId"?: number;
  instituicaoFinanceira?: InstituicaoFinanceira;
  tipoAplicacao?: TipoAplicacao;
}

export class FinanceiroAcaoFixo implements FinanceiroAcaoFixoInterface {
  "valorAtual": number;
  "dataAlteracao": Date;
  "tipoAplicacaoId": number;
  "instituicaoFinanceiraId": number;
  instituicaoFinanceira: InstituicaoFinanceira;
  tipoAplicacao: TipoAplicacao;
  constructor(data?: FinanceiroAcaoFixoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `FinanceiroAcaoFixo`.
   */
  public static getModelName() {
    return "FinanceiroAcaoFixo";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of FinanceiroAcaoFixo for dynamic purposes.
  **/
  public static factory(data: FinanceiroAcaoFixoInterface): FinanceiroAcaoFixo{
    return new FinanceiroAcaoFixo(data);
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
      name: 'FinanceiroAcaoFixo',
      plural: 'FinanceiroAcaoFixos',
      path: 'FinanceiroAcaoFixos',
      idName: 'dataAlteracao',
      properties: {
        "valorAtual": {
          name: 'valorAtual',
          type: 'number'
        },
        "dataAlteracao": {
          name: 'dataAlteracao',
          type: 'Date'
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
        instituicaoFinanceira: {
          name: 'instituicaoFinanceira',
          type: 'InstituicaoFinanceira',
          model: 'InstituicaoFinanceira',
          relationType: 'belongsTo',
                  keyFrom: 'instituicaoFinanceiraId',
          keyTo: 'id'
        },
        tipoAplicacao: {
          name: 'tipoAplicacao',
          type: 'TipoAplicacao',
          model: 'TipoAplicacao',
          relationType: 'belongsTo',
                  keyFrom: 'tipoAplicacaoId',
          keyTo: 'id'
        },
      }
    }
  }
}
