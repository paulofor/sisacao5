/* tslint:disable */

declare var Object: any;
export interface DatasetAcaoInterface {
  "tempoDias"?: number;
  "nome"?: string;
  "target"?: number;
  "stop"?: number;
  "tipoCompraVenda"?: string;
  "id"?: number;
}

export class DatasetAcao implements DatasetAcaoInterface {
  "tempoDias": number;
  "nome": string;
  "target": number;
  "stop": number;
  "tipoCompraVenda": string;
  "id": number;
  constructor(data?: DatasetAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `DatasetAcao`.
   */
  public static getModelName() {
    return "DatasetAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of DatasetAcao for dynamic purposes.
  **/
  public static factory(data: DatasetAcaoInterface): DatasetAcao{
    return new DatasetAcao(data);
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
      name: 'DatasetAcao',
      plural: 'DatasetAcaos',
      path: 'DatasetAcaos',
      idName: 'id',
      properties: {
        "tempoDias": {
          name: 'tempoDias',
          type: 'number'
        },
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "target": {
          name: 'target',
          type: 'number'
        },
        "stop": {
          name: 'stop',
          type: 'number'
        },
        "tipoCompraVenda": {
          name: 'tipoCompraVenda',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
