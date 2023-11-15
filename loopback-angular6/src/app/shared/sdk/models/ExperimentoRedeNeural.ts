/* tslint:disable */

declare var Object: any;
export interface ExperimentoRedeNeuralInterface {
  "possuiCache"?: number;
  "id"?: number;
}

export class ExperimentoRedeNeural implements ExperimentoRedeNeuralInterface {
  "possuiCache": number;
  "id": number;
  constructor(data?: ExperimentoRedeNeuralInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoRedeNeural`.
   */
  public static getModelName() {
    return "ExperimentoRedeNeural";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoRedeNeural for dynamic purposes.
  **/
  public static factory(data: ExperimentoRedeNeuralInterface): ExperimentoRedeNeural{
    return new ExperimentoRedeNeural(data);
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
      name: 'ExperimentoRedeNeural',
      plural: 'ExperimentoRedeNeurals',
      path: 'ExperimentoRedeNeurals',
      idName: 'id',
      properties: {
        "possuiCache": {
          name: 'possuiCache',
          type: 'number'
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
