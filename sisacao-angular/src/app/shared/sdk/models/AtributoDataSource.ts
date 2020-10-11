/* tslint:disable */

declare var Object: any;
export interface AtributoDataSourceInterface {
  "nome"?: string;
  "query"?: string;
  "fonte"?: string;
  "id"?: number;
  "dataSourceId"?: number;
}

export class AtributoDataSource implements AtributoDataSourceInterface {
  "nome": string;
  "query": string;
  "fonte": string;
  "id": number;
  "dataSourceId": number;
  constructor(data?: AtributoDataSourceInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AtributoDataSource`.
   */
  public static getModelName() {
    return "AtributoDataSource";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AtributoDataSource for dynamic purposes.
  **/
  public static factory(data: AtributoDataSourceInterface): AtributoDataSource{
    return new AtributoDataSource(data);
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
      name: 'AtributoDataSource',
      plural: 'AtributoDataSources',
      path: 'AtributoDataSources',
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
        "id": {
          name: 'id',
          type: 'number'
        },
        "dataSourceId": {
          name: 'dataSourceId',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
