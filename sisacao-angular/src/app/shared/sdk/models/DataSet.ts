/* tslint:disable */
import {
  AtributoDataSet
} from '../index';

declare var Object: any;
export interface DataSetInterface {
  "nome"?: string;
  "id"?: number;
  atributoDataSets?: AtributoDataSet[];
}

export class DataSet implements DataSetInterface {
  "nome": string;
  "id": number;
  atributoDataSets: AtributoDataSet[];
  constructor(data?: DataSetInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `DataSet`.
   */
  public static getModelName() {
    return "DataSet";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of DataSet for dynamic purposes.
  **/
  public static factory(data: DataSetInterface): DataSet{
    return new DataSet(data);
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
      name: 'DataSet',
      plural: 'DataSets',
      path: 'DataSets',
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
        atributoDataSets: {
          name: 'atributoDataSets',
          type: 'AtributoDataSet[]',
          model: 'AtributoDataSet',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'dataSetId'
        },
      }
    }
  }
}
