/* tslint:disable */
import {
  TesouroDireto
} from '../index';

declare var Object: any;
export interface TesouroDiretoCotacaoInterface {
  "diaNum"?: number;
  "taxaMercado"?: number;
  "dataHoraStr"?: string;
  "dataHora"?: Date;
  "id"?: number;
  "tesouroDiretoId"?: number;
  tesouroDireto?: TesouroDireto;
}

export class TesouroDiretoCotacao implements TesouroDiretoCotacaoInterface {
  "diaNum": number;
  "taxaMercado": number;
  "dataHoraStr": string;
  "dataHora": Date;
  "id": number;
  "tesouroDiretoId": number;
  tesouroDireto: TesouroDireto;
  constructor(data?: TesouroDiretoCotacaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TesouroDiretoCotacao`.
   */
  public static getModelName() {
    return "TesouroDiretoCotacao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TesouroDiretoCotacao for dynamic purposes.
  **/
  public static factory(data: TesouroDiretoCotacaoInterface): TesouroDiretoCotacao{
    return new TesouroDiretoCotacao(data);
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
      name: 'TesouroDiretoCotacao',
      plural: 'TesouroDiretoCotacaos',
      path: 'TesouroDiretoCotacaos',
      idName: 'id',
      properties: {
        "diaNum": {
          name: 'diaNum',
          type: 'number'
        },
        "taxaMercado": {
          name: 'taxaMercado',
          type: 'number'
        },
        "dataHoraStr": {
          name: 'dataHoraStr',
          type: 'string'
        },
        "dataHora": {
          name: 'dataHora',
          type: 'Date'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "tesouroDiretoId": {
          name: 'tesouroDiretoId',
          type: 'number'
        },
      },
      relations: {
        tesouroDireto: {
          name: 'tesouroDireto',
          type: 'TesouroDireto',
          model: 'TesouroDireto',
          relationType: 'belongsTo',
                  keyFrom: 'tesouroDiretoId',
          keyTo: 'id'
        },
      }
    }
  }
}
