/* tslint:disable */

declare var Object: any;
export interface IndicadorRedeInterface {
  "diaNumReferencia"?: number;
  "mesReferencia"?: number;
  "anoReferencia"?: number;
  "qtdeTreinoRede"?: number;
  "qtdeSaidaTargetStop"?: number;
}

export class IndicadorRede implements IndicadorRedeInterface {
  "diaNumReferencia": number;
  "mesReferencia": number;
  "anoReferencia": number;
  "qtdeTreinoRede": number;
  "qtdeSaidaTargetStop": number;
  constructor(data?: IndicadorRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `IndicadorRede`.
   */
  public static getModelName() {
    return "IndicadorRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of IndicadorRede for dynamic purposes.
  **/
  public static factory(data: IndicadorRedeInterface): IndicadorRede{
    return new IndicadorRede(data);
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
      name: 'IndicadorRede',
      plural: 'IndicadorRedes',
      path: 'IndicadorRedes',
      idName: 'diaNumReferencia',
      properties: {
        "diaNumReferencia": {
          name: 'diaNumReferencia',
          type: 'number'
        },
        "mesReferencia": {
          name: 'mesReferencia',
          type: 'number'
        },
        "anoReferencia": {
          name: 'anoReferencia',
          type: 'number'
        },
        "qtdeTreinoRede": {
          name: 'qtdeTreinoRede',
          type: 'number'
        },
        "qtdeSaidaTargetStop": {
          name: 'qtdeSaidaTargetStop',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
