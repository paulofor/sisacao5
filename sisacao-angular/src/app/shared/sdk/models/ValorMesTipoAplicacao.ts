/* tslint:disable */
import {
  TipoAplicacao
} from '../index';

declare var Object: any;
export interface ValorMesTipoAplicacaoInterface {
  "dataReferenciaNum"?: number;
  "saldo"?: number;
  "id"?: number;
  "tipoAplicacaoId"?: number;
  tipoAplicacao?: TipoAplicacao;
}

export class ValorMesTipoAplicacao implements ValorMesTipoAplicacaoInterface {
  "dataReferenciaNum": number;
  "saldo": number;
  "id": number;
  "tipoAplicacaoId": number;
  tipoAplicacao: TipoAplicacao;
  constructor(data?: ValorMesTipoAplicacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ValorMesTipoAplicacao`.
   */
  public static getModelName() {
    return "ValorMesTipoAplicacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ValorMesTipoAplicacao for dynamic purposes.
  **/
  public static factory(data: ValorMesTipoAplicacaoInterface): ValorMesTipoAplicacao{
    return new ValorMesTipoAplicacao(data);
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
      name: 'ValorMesTipoAplicacao',
      plural: 'ValorMesTipoAplicacaos',
      path: 'ValorMesTipoAplicacaos',
      idName: 'id',
      properties: {
        "dataReferenciaNum": {
          name: 'dataReferenciaNum',
          type: 'number'
        },
        "saldo": {
          name: 'saldo',
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
      }
    }
  }
}
