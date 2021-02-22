/* tslint:disable */
import {
  RelGrupoAcao
} from '../index';

declare var Object: any;
export interface AtivoAcaoInterface {
  "ticker"?: string;
  "nome"?: string;
  "intraday5"?: number;
  "intraday15"?: number;
  "intraday30"?: number;
  "fechamentoAtual"?: number;
  "max1Mes"?: number;
  "min1Mes"?: number;
  "spread1Mes"?: number;
  "mediaNegocio1Mes"?: number;
  "max3Mes"?: number;
  "min3Mes"?: number;
  "spread3Mes"?: number;
  "mediaNegocio3Mes"?: number;
  relGrupoAcaos?: RelGrupoAcao[];
}

export class AtivoAcao implements AtivoAcaoInterface {
  "ticker": string;
  "nome": string;
  "intraday5": number;
  "intraday15": number;
  "intraday30": number;
  "fechamentoAtual": number;
  "max1Mes": number;
  "min1Mes": number;
  "spread1Mes": number;
  "mediaNegocio1Mes": number;
  "max3Mes": number;
  "min3Mes": number;
  "spread3Mes": number;
  "mediaNegocio3Mes": number;
  relGrupoAcaos: RelGrupoAcao[];
  constructor(data?: AtivoAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtivoAcao`.
   */
  public static getModelName() {
    return "AtivoAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtivoAcao for dynamic purposes.
  **/
  public static factory(data: AtivoAcaoInterface): AtivoAcao{
    return new AtivoAcao(data);
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
      name: 'AtivoAcao',
      plural: 'AtivoAcaos',
      path: 'AtivoAcaos',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "intraday5": {
          name: 'intraday5',
          type: 'number'
        },
        "intraday15": {
          name: 'intraday15',
          type: 'number'
        },
        "intraday30": {
          name: 'intraday30',
          type: 'number'
        },
        "fechamentoAtual": {
          name: 'fechamentoAtual',
          type: 'number'
        },
        "max1Mes": {
          name: 'max1Mes',
          type: 'number'
        },
        "min1Mes": {
          name: 'min1Mes',
          type: 'number'
        },
        "spread1Mes": {
          name: 'spread1Mes',
          type: 'number'
        },
        "mediaNegocio1Mes": {
          name: 'mediaNegocio1Mes',
          type: 'number'
        },
        "max3Mes": {
          name: 'max3Mes',
          type: 'number'
        },
        "min3Mes": {
          name: 'min3Mes',
          type: 'number'
        },
        "spread3Mes": {
          name: 'spread3Mes',
          type: 'number'
        },
        "mediaNegocio3Mes": {
          name: 'mediaNegocio3Mes',
          type: 'number'
        },
      },
      relations: {
        relGrupoAcaos: {
          name: 'relGrupoAcaos',
          type: 'RelGrupoAcao[]',
          model: 'RelGrupoAcao',
          relationType: 'hasMany',
                  keyFrom: 'ticker',
          keyTo: 'ticker'
        },
      }
    }
  }
}
