/* tslint:disable */

declare var Object: any;
export interface PeriodoTreinoRedeInterface {
  "diaNumInicioTreino"?: number;
  "diaNumFinalTreino"?: number;
  "diaNumInicioValidacao"?: number;
  "diaNumFinalValidacao"?: number;
  "diaNumInicioTeste"?: number;
  "diaNumFinalTeste"?: number;
  "maximoTradeTeste"?: number;
  "minimoTradeTeste"?: number;
  "simultaneoTradeTeste"?: number;
  "diaNumInicioExecucao"?: number;
  "diaNumFinalExecucao"?: number;
  "id"?: number;
}

export class PeriodoTreinoRede implements PeriodoTreinoRedeInterface {
  "diaNumInicioTreino": number;
  "diaNumFinalTreino": number;
  "diaNumInicioValidacao": number;
  "diaNumFinalValidacao": number;
  "diaNumInicioTeste": number;
  "diaNumFinalTeste": number;
  "maximoTradeTeste": number;
  "minimoTradeTeste": number;
  "simultaneoTradeTeste": number;
  "diaNumInicioExecucao": number;
  "diaNumFinalExecucao": number;
  "id": number;
  constructor(data?: PeriodoTreinoRedeInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `PeriodoTreinoRede`.
   */
  public static getModelName() {
    return "PeriodoTreinoRede";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of PeriodoTreinoRede for dynamic purposes.
  **/
  public static factory(data: PeriodoTreinoRedeInterface): PeriodoTreinoRede{
    return new PeriodoTreinoRede(data);
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
      name: 'PeriodoTreinoRede',
      plural: 'PeriodoTreinoRedes',
      path: 'PeriodoTreinoRedes',
      idName: 'id',
      properties: {
        "diaNumInicioTreino": {
          name: 'diaNumInicioTreino',
          type: 'number'
        },
        "diaNumFinalTreino": {
          name: 'diaNumFinalTreino',
          type: 'number'
        },
        "diaNumInicioValidacao": {
          name: 'diaNumInicioValidacao',
          type: 'number'
        },
        "diaNumFinalValidacao": {
          name: 'diaNumFinalValidacao',
          type: 'number'
        },
        "diaNumInicioTeste": {
          name: 'diaNumInicioTeste',
          type: 'number'
        },
        "diaNumFinalTeste": {
          name: 'diaNumFinalTeste',
          type: 'number'
        },
        "maximoTradeTeste": {
          name: 'maximoTradeTeste',
          type: 'number'
        },
        "minimoTradeTeste": {
          name: 'minimoTradeTeste',
          type: 'number'
        },
        "simultaneoTradeTeste": {
          name: 'simultaneoTradeTeste',
          type: 'number'
        },
        "diaNumInicioExecucao": {
          name: 'diaNumInicioExecucao',
          type: 'number'
        },
        "diaNumFinalExecucao": {
          name: 'diaNumFinalExecucao',
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
