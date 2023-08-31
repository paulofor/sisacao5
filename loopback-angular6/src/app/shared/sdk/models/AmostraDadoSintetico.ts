/* tslint:disable */
import {
  TipoExemploTreino,
  ExemploDadoSintetico
} from '../index';

declare var Object: any;
export interface AmostraDadoSinteticoInterface {
  "nome"?: string;
  "qtdeExemplo"?: number;
  "qtdeExemploTeste"?: number;
  "percentualSubida"?: number;
  "percentualDescida"?: number;
  "percentualFlat"?: number;
  "magnitudeTrend"?: number;
  "percentualContraTrend"?: number;
  "magnitudeContraTrend"?: number;
  "magnitudeRuido"?: number;
  "qtdeAtivo"?: number;
  "qtdeDiaColetado"?: number;
  "id"?: number;
  "tipoExemploTreinoId"?: number;
  tipoExemploTreino?: TipoExemploTreino;
  exemploDadoSinteticos?: ExemploDadoSintetico[];
}

export class AmostraDadoSintetico implements AmostraDadoSinteticoInterface {
  "nome": string;
  "qtdeExemplo": number;
  "qtdeExemploTeste": number;
  "percentualSubida": number;
  "percentualDescida": number;
  "percentualFlat": number;
  "magnitudeTrend": number;
  "percentualContraTrend": number;
  "magnitudeContraTrend": number;
  "magnitudeRuido": number;
  "qtdeAtivo": number;
  "qtdeDiaColetado": number;
  "id": number;
  "tipoExemploTreinoId": number;
  tipoExemploTreino: TipoExemploTreino;
  exemploDadoSinteticos: ExemploDadoSintetico[];
  constructor(data?: AmostraDadoSinteticoInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `AmostraDadoSintetico`.
   */
  public static getModelName() {
    return "AmostraDadoSintetico";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of AmostraDadoSintetico for dynamic purposes.
  **/
  public static factory(data: AmostraDadoSinteticoInterface): AmostraDadoSintetico{
    return new AmostraDadoSintetico(data);
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
      name: 'AmostraDadoSintetico',
      plural: 'AmostraDadoSinteticos',
      path: 'AmostraDadoSinteticos',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "qtdeExemplo": {
          name: 'qtdeExemplo',
          type: 'number'
        },
        "qtdeExemploTeste": {
          name: 'qtdeExemploTeste',
          type: 'number'
        },
        "percentualSubida": {
          name: 'percentualSubida',
          type: 'number'
        },
        "percentualDescida": {
          name: 'percentualDescida',
          type: 'number'
        },
        "percentualFlat": {
          name: 'percentualFlat',
          type: 'number'
        },
        "magnitudeTrend": {
          name: 'magnitudeTrend',
          type: 'number'
        },
        "percentualContraTrend": {
          name: 'percentualContraTrend',
          type: 'number'
        },
        "magnitudeContraTrend": {
          name: 'magnitudeContraTrend',
          type: 'number'
        },
        "magnitudeRuido": {
          name: 'magnitudeRuido',
          type: 'number'
        },
        "qtdeAtivo": {
          name: 'qtdeAtivo',
          type: 'number'
        },
        "qtdeDiaColetado": {
          name: 'qtdeDiaColetado',
          type: 'number'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "tipoExemploTreinoId": {
          name: 'tipoExemploTreinoId',
          type: 'number'
        },
      },
      relations: {
        tipoExemploTreino: {
          name: 'tipoExemploTreino',
          type: 'TipoExemploTreino',
          model: 'TipoExemploTreino',
          relationType: 'belongsTo',
                  keyFrom: 'tipoExemploTreinoId',
          keyTo: 'id'
        },
        exemploDadoSinteticos: {
          name: 'exemploDadoSinteticos',
          type: 'ExemploDadoSintetico[]',
          model: 'ExemploDadoSintetico',
          relationType: 'hasMany',
                  keyFrom: 'id',
          keyTo: 'amostraDadoSinteticoId'
        },
      }
    }
  }
}
