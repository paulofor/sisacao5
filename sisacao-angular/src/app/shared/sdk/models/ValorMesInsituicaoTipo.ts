/* tslint:disable */

declare var Object: any;
export interface ValorMesInsituicaoTipoInterface {
  "id"?: number;
}

export class ValorMesInsituicaoTipo implements ValorMesInsituicaoTipoInterface {
  "id": number;
  constructor(data?: ValorMesInsituicaoTipoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ValorMesInsituicaoTipo`.
   */
  public static getModelName() {
    return "ValorMesInsituicaoTipo";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ValorMesInsituicaoTipo for dynamic purposes.
  **/
  public static factory(data: ValorMesInsituicaoTipoInterface): ValorMesInsituicaoTipo{
    return new ValorMesInsituicaoTipo(data);
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
      name: 'ValorMesInsituicaoTipo',
      plural: 'ValorMesInsituicaoTipos',
      path: 'ValorMesInsituicaoTipos',
      idName: 'id',
      properties: {
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
