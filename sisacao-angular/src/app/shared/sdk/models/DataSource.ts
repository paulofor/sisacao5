/* tslint:disable */
import {
  AtributoDataSource
} from '../index';

declare var Object: any;
export interface DataSourceInterface {
  "nome"?: string;
  "id"?: number;
  atributoDataSources?: AtributoDataSource[];
}

export class DataSource implements DataSourceInterface {
  "nome": string;
  "id": number;
  atributoDataSources: AtributoDataSource[];
  constructor(data?: DataSourceInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `DataSource`.
   */
  public static getModelName() {
    return "DataSource";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of DataSource for dynamic purposes.
  **/
  public static factory(data: DataSourceInterface): DataSource{
    return new DataSource(data);
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
      name: 'DataSource',
      plural: 'DataSources',
      path: 'DataSources',
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
        atributoDataSources: {
          name: 'atributoDataSources',
          type: 'AtributoDataSource[]',
          model: 'AtributoDataSource',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'dataSourceId'
        },
      }
    }
  }
}
