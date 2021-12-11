/* tslint:disable */
import {
  AplicacaoInstituicao
} from '../index';

declare var Object: any;
export interface InstituicaoFinanceiraInterface {
  "nome"?: string;
  "id"?: number;
  aplicacaoInstituicaos?: AplicacaoInstituicao[];
}

export class InstituicaoFinanceira implements InstituicaoFinanceiraInterface {
  "nome": string;
  "id": number;
  aplicacaoInstituicaos: AplicacaoInstituicao[];
  constructor(data?: InstituicaoFinanceiraInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `InstituicaoFinanceira`.
   */
  public static getModelName() {
    return "InstituicaoFinanceira";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of InstituicaoFinanceira for dynamic purposes.
  **/
  public static factory(data: InstituicaoFinanceiraInterface): InstituicaoFinanceira{
    return new InstituicaoFinanceira(data);
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
      name: 'InstituicaoFinanceira',
      plural: 'InstituicaoFinanceiras',
      path: 'InstituicaoFinanceiras',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        aplicacaoInstituicaos: {
          name: 'aplicacaoInstituicaos',
          type: 'AplicacaoInstituicao[]',
          model: 'AplicacaoInstituicao',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'instituicaoFinanceiraId'
        },
      }
    }
  }
}
