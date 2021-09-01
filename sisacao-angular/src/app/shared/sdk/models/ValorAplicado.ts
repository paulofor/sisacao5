/* tslint:disable */

declare var Object: any;
export interface ValorAplicadoInterface {
  "valor"?: number;
  "dataInicio"?: string;
  "dataFinal"?: string;
  "id"?: number;
}

export class ValorAplicado implements ValorAplicadoInterface {
  "valor": number;
  "dataInicio": string;
  "dataFinal": string;
  "id": number;
  constructor(data?: ValorAplicadoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ValorAplicado`.
   */
  public static getModelName() {
    return "ValorAplicado";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ValorAplicado for dynamic purposes.
  **/
  public static factory(data: ValorAplicadoInterface): ValorAplicado{
    return new ValorAplicado(data);
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
      name: 'ValorAplicado',
      plural: 'ValorAplicados',
      path: 'ValorAplicados',
      idName: 'id',
      properties: {
        "valor": {
          name: 'valor',
          type: 'number'
        },
        "dataInicio": {
          name: 'dataInicio',
          type: 'string'
        },
        "dataFinal": {
          name: 'dataFinal',
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
