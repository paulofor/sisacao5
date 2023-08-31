/* tslint:disable */

declare var Object: any;
export interface KerasLossInterface {
  "nome"?: string;
  "tipo"?: string;
  "tipoObjeto"?: string;
  "link"?: string;
  "explicacao"?: string;
  "id"?: number;
}

export class KerasLoss implements KerasLossInterface {
  "nome": string;
  "tipo": string;
  "tipoObjeto": string;
  "link": string;
  "explicacao": string;
  "id": number;
  constructor(data?: KerasLossInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `KerasLoss`.
   */
  public static getModelName() {
    return "KerasLoss";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of KerasLoss for dynamic purposes.
  **/
  public static factory(data: KerasLossInterface): KerasLoss{
    return new KerasLoss(data);
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
      name: 'KerasLoss',
      plural: 'KerasLosses',
      path: 'KerasLosses',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "tipo": {
          name: 'tipo',
          type: 'string'
        },
        "tipoObjeto": {
          name: 'tipoObjeto',
          type: 'string'
        },
        "link": {
          name: 'link',
          type: 'string'
        },
        "explicacao": {
          name: 'explicacao',
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
