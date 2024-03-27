/* tslint:disable */

declare var Object: any;
export interface AtributoDataSetInterface {
  "nome"?: string;
  "query"?: string;
  "fonte"?: string;
  "descricao"?: string;
  "id"?: number;
  "dataSetId"?: number;
}

export class AtributoDataSet implements AtributoDataSetInterface {
  "nome": string;
  "query": string;
  "fonte": string;
  "descricao": string;
  "id": number;
  "dataSetId": number;
  constructor(data?: AtributoDataSetInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtributoDataSet`.
   */
  public static getModelName() {
    return "AtributoDataSet";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtributoDataSet for dynamic purposes.
  **/
  public static factory(data: AtributoDataSetInterface): AtributoDataSet{
    return new AtributoDataSet(data);
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
      name: 'AtributoDataSet',
      plural: 'AtributoDataSets',
      path: 'AtributoDataSets',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "query": {
          name: 'query',
          type: 'string'
        },
        "fonte": {
          name: 'fonte',
          type: 'string'
        },
        "descricao": {
          name: 'descricao',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "dataSetId": {
          name: 'dataSetId',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
