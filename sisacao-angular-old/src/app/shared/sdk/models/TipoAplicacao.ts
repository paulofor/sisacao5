/* tslint:disable */
import {
  AplicacaoInstituicao,
  ValorMesInstituicaoTipo,
  TipoAplicacaoSaldoMes
} from '../index';

declare var Object: any;
export interface TipoAplicacaoInterface {
  "nome"?: string;
  "saldoAtual"?: number;
  "id"?: number;
  aplicacaoInstituicaos?: AplicacaoInstituicao[];
  valorMesInstituicaoTipos?: ValorMesInstituicaoTipo[];
  tipoAplicacaoSaldoMes?: TipoAplicacaoSaldoMes[];
}

export class TipoAplicacao implements TipoAplicacaoInterface {
  "nome": string;
  "saldoAtual": number;
  "id": number;
  aplicacaoInstituicaos: AplicacaoInstituicao[];
  valorMesInstituicaoTipos: ValorMesInstituicaoTipo[];
  tipoAplicacaoSaldoMes: TipoAplicacaoSaldoMes[];
  constructor(data?: TipoAplicacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TipoAplicacao`.
   */
  public static getModelName() {
    return "TipoAplicacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TipoAplicacao for dynamic purposes.
  **/
  public static factory(data: TipoAplicacaoInterface): TipoAplicacao{
    return new TipoAplicacao(data);
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
      name: 'TipoAplicacao',
      plural: 'TipoAplicacaos',
      path: 'TipoAplicacaos',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "saldoAtual": {
          name: 'saldoAtual',
          type: 'number'
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
          keyTo: 'tipoAplicacaoId'
        },
        valorMesInstituicaoTipos: {
          name: 'valorMesInstituicaoTipos',
          type: 'ValorMesInstituicaoTipo[]',
          model: 'ValorMesInstituicaoTipo',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'tipoAplicacaoId'
        },
        tipoAplicacaoSaldoMes: {
          name: 'tipoAplicacaoSaldoMes',
          type: 'TipoAplicacaoSaldoMes[]',
          model: 'TipoAplicacaoSaldoMes',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'tipoAplicacaoId'
        },
      }
    }
  }
}
