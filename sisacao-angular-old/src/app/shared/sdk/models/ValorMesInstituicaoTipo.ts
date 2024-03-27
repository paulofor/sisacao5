/* tslint:disable */
import {
  TipoAplicacao,
  InstituicaoFinanceira
} from '../index';

declare var Object: any;
export interface ValorMesInstituicaoTipoInterface {
  "dataReferenciaNum"?: number;
  "valor"?: number;
  "valorPercentual"?: number;
  "id"?: number;
  "tipoAplicacaoId"?: number;
  "instituicaoFinanceiraId"?: number;
  tipoAplicacao?: TipoAplicacao;
  instituicaoFinanceira?: InstituicaoFinanceira;
}

export class ValorMesInstituicaoTipo implements ValorMesInstituicaoTipoInterface {
  "dataReferenciaNum": number;
  "valor": number;
  "valorPercentual": number;
  "id": number;
  "tipoAplicacaoId": number;
  "instituicaoFinanceiraId": number;
  tipoAplicacao: TipoAplicacao;
  instituicaoFinanceira: InstituicaoFinanceira;
  constructor(data?: ValorMesInstituicaoTipoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ValorMesInstituicaoTipo`.
   */
  public static getModelName() {
    return "ValorMesInstituicaoTipo";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ValorMesInstituicaoTipo for dynamic purposes.
  **/
  public static factory(data: ValorMesInstituicaoTipoInterface): ValorMesInstituicaoTipo{
    return new ValorMesInstituicaoTipo(data);
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
      name: 'ValorMesInstituicaoTipo',
      plural: 'ValorMesInstituicaoTipos',
      path: 'ValorMesInstituicaoTipos',
      idName: 'id',
      properties: {
        "dataReferenciaNum": {
          name: 'dataReferenciaNum',
          type: 'number'
        },
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "valorPercentual": {
          name: 'valorPercentual',
          type: 'number'
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
