/* tslint:disable */
import {
  AtivoAcao
} from '../index';

declare var Object: any;
export interface ExperimentoAcaoInterface {
  "ticker"?: string;
  "experimentoSimulacaoId"?: number;
  ativoAcao?: AtivoAcao;
}

export class ExperimentoAcao implements ExperimentoAcaoInterface {
  "ticker": string;
  "experimentoSimulacaoId": number;
  ativoAcao: AtivoAcao;
  constructor(data?: ExperimentoAcaoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `ExperimentoAcao`.
   */
  public static getModelName() {
    return "ExperimentoAcao";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of ExperimentoAcao for dynamic purposes.
  **/
  public static factory(data: ExperimentoAcaoInterface): ExperimentoAcao{
    return new ExperimentoAcao(data);
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
      name: 'ExperimentoAcao',
      plural: 'ExperimentoAcaos',
      path: 'ExperimentoAcaos',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "experimentoSimulacaoId": {
          name: 'experimentoSimulacaoId',
          type: 'number'
        },
      },
      relations: {
        ativoAcao: {
          name: 'ativoAcao',
          type: 'AtivoAcao',
          model: 'AtivoAcao',
          relationType: 'belongsTo',
                  keyFrom: 'ticker',
          keyTo: 'ticker'
        },
      }
    }
  }
}
