/* tslint:disable */

declare var Object: any;
export interface ExperimentoPreRedeResultadoInterface {
  "campoY"?: string;
  "resultado"?: number;
  "score"?: number;
  "experimentoPreRedeId"?: number;
  "exemploDadoSinteticoTesteId"?: number;
  "id"?: number;
}

export class ExperimentoPreRedeResultado implements ExperimentoPreRedeResultadoInterface {
  "campoY": string;
  "resultado": number;
  "score": number;
  "experimentoPreRedeId": number;
  "exemploDadoSinteticoTesteId": number;
  "id": number;
  constructor(data?: ExperimentoPreRedeResultadoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoPreRedeResultado`.
   */
  public static getModelName() {
    return "ExperimentoPreRedeResultado";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoPreRedeResultado for dynamic purposes.
  **/
  public static factory(data: ExperimentoPreRedeResultadoInterface): ExperimentoPreRedeResultado{
    return new ExperimentoPreRedeResultado(data);
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
      name: 'ExperimentoPreRedeResultado',
      plural: 'ExperimentoPreRedeResultados',
      path: 'ExperimentoPreRedeResultados',
      idName: 'id',
      properties: {
        "campoY": {
          name: 'campoY',
          type: 'string'
        },
        "resultado": {
          name: 'resultado',
          type: 'number'
        },
        "score": {
          name: 'score',
          type: 'number'
        },
        "experimentoPreRedeId": {
          name: 'experimentoPreRedeId',
          type: 'number'
        },
        "exemploDadoSinteticoTesteId": {
          name: 'exemploDadoSinteticoTesteId',
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
