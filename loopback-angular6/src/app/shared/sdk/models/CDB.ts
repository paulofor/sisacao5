/* tslint:disable */

declare var Object: any;
export interface CDBInterface {
  "nome"?: string;
  "dataVencimento"?: string;
  "percentualCDI"?: number;
  "percentualFixo"?: number;
  "percentualIPCA"?: number;
  "valorMinimo"?: number;
  "dataInsercao"?: string;
  "id"?: number;
}

export class CDB implements CDBInterface {
  "nome": string;
  "dataVencimento": string;
  "percentualCDI": number;
  "percentualFixo": number;
  "percentualIPCA": number;
  "valorMinimo": number;
  "dataInsercao": string;
  "id": number;
  constructor(data?: CDBInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `CDB`.
   */
  public static getModelName() {
    return "CDB";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of CDB for dynamic purposes.
  **/
  public static factory(data: CDBInterface): CDB{
    return new CDB(data);
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
      name: 'CDB',
      plural: 'CDBs',
      path: 'CDBs',
      idName: 'id',
      properties: {
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "dataVencimento": {
          name: 'dataVencimento',
          type: 'string'
        },
        "percentualCDI": {
          name: 'percentualCDI',
          type: 'number'
        },
        "percentualFixo": {
          name: 'percentualFixo',
          type: 'number'
        },
        "percentualIPCA": {
          name: 'percentualIPCA',
          type: 'number'
        },
        "valorMinimo": {
          name: 'valorMinimo',
          type: 'number'
        },
        "dataInsercao": {
          name: 'dataInsercao',
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
