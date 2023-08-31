/* tslint:disable */

declare var Object: any;
export interface KerasOptimizerInterface {
  "nome"?: string;
  "id"?: number;
}

export class KerasOptimizer implements KerasOptimizerInterface {
  "nome": string;
  "id": number;
  constructor(data?: KerasOptimizerInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `KerasOptimizer`.
   */
  public static getModelName() {
    return "KerasOptimizer";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of KerasOptimizer for dynamic purposes.
  **/
  public static factory(data: KerasOptimizerInterface): KerasOptimizer{
    return new KerasOptimizer(data);
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
      name: 'KerasOptimizer',
      plural: 'KerasOptimizers',
      path: 'KerasOptimizers',
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
      }
    }
  }
}
