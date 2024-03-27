/* tslint:disable */

declare var Object: any;
export interface RegraProjecaoTotalMesInterface {
  "anoMesNum"?: number;
  "quantidadeLucro"?: number;
  "quantidadePrejuizo"?: number;
  "quantidade"?: number;
  "regraProjecaoId"?: number;
}

export class RegraProjecaoTotalMes implements RegraProjecaoTotalMesInterface {
  "anoMesNum": number;
  "quantidadeLucro": number;
  "quantidadePrejuizo": number;
  "quantidade": number;
  "regraProjecaoId": number;
  constructor(data?: RegraProjecaoTotalMesInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `RegraProjecaoTotalMes`.
   */
  public static getModelName() {
    return "RegraProjecaoTotalMes";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of RegraProjecaoTotalMes for dynamic purposes.
  **/
  public static factory(data: RegraProjecaoTotalMesInterface): RegraProjecaoTotalMes{
    return new RegraProjecaoTotalMes(data);
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
      name: 'RegraProjecaoTotalMes',
      plural: 'RegraProjecaoTotalMes',
      path: 'RegraProjecaoTotalMes',
      idName: 'anoMesNum',
      properties: {
        "anoMesNum": {
          name: 'anoMesNum',
          type: 'number'
        },
        "quantidadeLucro": {
          name: 'quantidadeLucro',
          type: 'number'
        },
        "quantidadePrejuizo": {
          name: 'quantidadePrejuizo',
          type: 'number'
        },
        "quantidade": {
          name: 'quantidade',
          type: 'number'
        },
        "regraProjecaoId": {
          name: 'regraProjecaoId',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
