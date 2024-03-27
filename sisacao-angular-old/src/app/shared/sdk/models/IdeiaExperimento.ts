/* tslint:disable */

declare var Object: any;
export interface IdeiaExperimentoInterface {
  "nome"?: string;
  "descricao"?: string;
  "id"?: number;
}

export class IdeiaExperimento implements IdeiaExperimentoInterface {
  "nome": string;
  "descricao": string;
  "id": number;
  constructor(data?: IdeiaExperimentoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `IdeiaExperimento`.
   */
  public static getModelName() {
    return "IdeiaExperimento";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of IdeiaExperimento for dynamic purposes.
  **/
  public static factory(data: IdeiaExperimentoInterface): IdeiaExperimento{
    return new IdeiaExperimento(data);
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
      name: 'IdeiaExperimento',
      plural: 'IdeiaExperimentos',
      path: 'IdeiaExperimentos',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
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
      },
      relations: {
      }
    }
  }
}
