/* tslint:disable */
import {
  TesouroDiretoCotacao
} from '../index';

declare var Object: any;
export interface TesouroDiretoInterface {
  "nome"?: string;
  "indexador"?: string;
  "vencimento"?: Date;
  "id"?: number;
  tesouroDiretoCotacaos?: TesouroDiretoCotacao[];
}

export class TesouroDireto implements TesouroDiretoInterface {
  "nome": string;
  "indexador": string;
  "vencimento": Date;
  "id": number;
  tesouroDiretoCotacaos: TesouroDiretoCotacao[];
  constructor(data?: TesouroDiretoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `TesouroDireto`.
   */
  public static getModelName() {
    return "TesouroDireto";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of TesouroDireto for dynamic purposes.
  **/
  public static factory(data: TesouroDiretoInterface): TesouroDireto{
    return new TesouroDireto(data);
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
      name: 'TesouroDireto',
      plural: 'TesouroDiretos',
      path: 'TesouroDiretos',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "indexador": {
          name: 'indexador',
          type: 'string'
        },
        "vencimento": {
          name: 'vencimento',
          type: 'Date'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
        tesouroDiretoCotacaos: {
          name: 'tesouroDiretoCotacaos',
          type: 'TesouroDiretoCotacao[]',
          model: 'TesouroDiretoCotacao',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'tesouroDiretoId'
        },
      }
    }
  }
}
