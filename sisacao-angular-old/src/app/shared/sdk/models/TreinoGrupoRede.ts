/* tslint:disable */
import {
  GrupoRede,
  GrupoAcao,
  PeriodoTreinoRede,
  GrupoRegra,
  TreinoRede
} from '../index';

declare var Object: any;
export interface TreinoGrupoRedeInterface {
  "id"?: number;
  "grupoRedeId"?: number;
  "grupoAcaoId"?: number;
  "periodoTreinoRedeId"?: number;
  "grupoRegraId"?: number;
  grupoRede?: GrupoRede;
  grupoAcao?: GrupoAcao;
  periodoTreinoRede?: PeriodoTreinoRede;
  grupoRegra?: GrupoRegra;
  treinoRedes?: TreinoRede[];
}

export class TreinoGrupoRede implements TreinoGrupoRedeInterface {
  "id": number;
  "grupoRedeId": number;
  "grupoAcaoId": number;
  "periodoTreinoRedeId": number;
  "grupoRegraId": number;
  grupoRede: GrupoRede;
  grupoAcao: GrupoAcao;
  periodoTreinoRede: PeriodoTreinoRede;
  grupoRegra: GrupoRegra;
  treinoRedes: TreinoRede[];
  constructor(data?: TreinoGrupoRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TreinoGrupoRede`.
   */
  public static getModelName() {
    return "TreinoGrupoRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TreinoGrupoRede for dynamic purposes.
  **/
  public static factory(data: TreinoGrupoRedeInterface): TreinoGrupoRede{
    return new TreinoGrupoRede(data);
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
      name: 'TreinoGrupoRede',
      plural: 'TreinoGrupoRedes',
      path: 'TreinoGrupoRedes',
      idName: 'id',
      properties: {
        "id": {
          name: 'id',
          type: 'number'
        },
        "grupoRedeId": {
          name: 'grupoRedeId',
          type: 'number'
        },
        "grupoAcaoId": {
          name: 'grupoAcaoId',
          type: 'number'
        },
        "periodoTreinoRedeId": {
          name: 'periodoTreinoRedeId',
          type: 'number'
        },
        "grupoRegraId": {
          name: 'grupoRegraId',
          type: 'number'
        },
      },
      relations: {
        grupoRede: {
          name: 'grupoRede',
          type: 'GrupoRede',
          model: 'GrupoRede',
          relationType: 'belongsTo',
                  keyFrom: 'grupoRedeId',
          keyTo: 'id'
        },
        grupoAcao: {
          name: 'grupoAcao',
          type: 'GrupoAcao',
          model: 'GrupoAcao',
          relationType: 'belongsTo',
                  keyFrom: 'grupoAcaoId',
          keyTo: 'id'
        },
        periodoTreinoRede: {
          name: 'periodoTreinoRede',
          type: 'PeriodoTreinoRede',
          model: 'PeriodoTreinoRede',
          relationType: 'belongsTo',
                  keyFrom: 'periodoTreinoRedeId',
          keyTo: 'id'
        },
        grupoRegra: {
          name: 'grupoRegra',
          type: 'GrupoRegra',
          model: 'GrupoRegra',
          relationType: 'belongsTo',
                  keyFrom: 'grupoRegraId',
          keyTo: 'id'
        },
        treinoRedes: {
          name: 'treinoRedes',
          type: 'TreinoRede[]',
          model: 'TreinoRede',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'treinoGrupoRedeId'
        },
      }
    }
  }
}
