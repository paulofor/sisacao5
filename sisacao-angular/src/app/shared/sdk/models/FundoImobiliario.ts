/* tslint:disable */
import {
  AluguelFundoImobiliario
} from '../index';

declare var Object: any;
export interface FundoImobiliarioInterface {
  "ticker"?: string;
  "nome"?: string;
  "segmento"?: string;
  "administrador"?: string;
  "descricao"?: string;
  "percentual12"?: number;
  "percentual6"?: number;
  "mediaNegocio1"?: number;
  "mediaNegocio3"?: number;
  "mediaNegocio4"?: number;
  "precoAtual"?: number;
  "preco6"?: number;
  "preco12"?: number;
  "dataInsercao"?: Date;
  "maximo3"?: number;
  "maximo1"?: number;
  "minimo3"?: number;
  "minimo1"?: number;
  "totalAluguel3"?: number;
  "totalAluguel6"?: number;
  "mediaPercentualAluguel3"?: number;
  "mediaPercentualAluguel6"?: number;
  "maximo12m"?: number;
  "maximo24m"?: number;
  "minimo12m"?: number;
  "minimo24m"?: number;
  "variacao12m"?: number;
  "variacao24m"?: number;
  aluguelFundoImobiliarios?: AluguelFundoImobiliario[];
}

export class FundoImobiliario implements FundoImobiliarioInterface {
  "ticker": string;
  "nome": string;
  "segmento": string;
  "administrador": string;
  "descricao": string;
  "percentual12": number;
  "percentual6": number;
  "mediaNegocio1": number;
  "mediaNegocio3": number;
  "mediaNegocio4": number;
  "precoAtual": number;
  "preco6": number;
  "preco12": number;
  "dataInsercao": Date;
  "maximo3": number;
  "maximo1": number;
  "minimo3": number;
  "minimo1": number;
  "totalAluguel3": number;
  "totalAluguel6": number;
  "mediaPercentualAluguel3": number;
  "mediaPercentualAluguel6": number;
  "maximo12m": number;
  "maximo24m": number;
  "minimo12m": number;
  "minimo24m": number;
  "variacao12m": number;
  "variacao24m": number;
  aluguelFundoImobiliarios: AluguelFundoImobiliario[];
  constructor(data?: FundoImobiliarioInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `FundoImobiliario`.
   */
  public static getModelName() {
    return "FundoImobiliario";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of FundoImobiliario for dynamic purposes.
  **/
  public static factory(data: FundoImobiliarioInterface): FundoImobiliario{
    return new FundoImobiliario(data);
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
      name: 'FundoImobiliario',
      plural: 'FundoImobiliarios',
      path: 'FundoImobiliarios',
      idName: 'ticker',
      properties: {
        "ticker": {
          name: 'ticker',
          type: 'string'
        },
        "nome": {
          name: 'nome',
          type: 'string'
        },
        "segmento": {
          name: 'segmento',
          type: 'string'
        },
        "administrador": {
          name: 'administrador',
          type: 'string'
        },
        "descricao": {
          name: 'descricao',
          type: 'string'
        },
        "percentual12": {
          name: 'percentual12',
          type: 'number'
        },
        "percentual6": {
          name: 'percentual6',
          type: 'number'
        },
        "mediaNegocio1": {
          name: 'mediaNegocio1',
          type: 'number'
        },
        "mediaNegocio3": {
          name: 'mediaNegocio3',
          type: 'number'
        },
        "mediaNegocio4": {
          name: 'mediaNegocio4',
          type: 'number'
        },
        "precoAtual": {
          name: 'precoAtual',
          type: 'number'
        },
        "preco6": {
          name: 'preco6',
          type: 'number'
        },
        "preco12": {
          name: 'preco12',
          type: 'number'
        },
        "dataInsercao": {
          name: 'dataInsercao',
          type: 'Date'
        },
        "maximo3": {
          name: 'maximo3',
          type: 'number'
        },
        "maximo1": {
          name: 'maximo1',
          type: 'number'
        },
        "minimo3": {
          name: 'minimo3',
          type: 'number'
        },
        "minimo1": {
          name: 'minimo1',
          type: 'number'
        },
        "totalAluguel3": {
          name: 'totalAluguel3',
          type: 'number'
        },
        "totalAluguel6": {
          name: 'totalAluguel6',
          type: 'number'
        },
        "mediaPercentualAluguel3": {
          name: 'mediaPercentualAluguel3',
          type: 'number'
        },
        "mediaPercentualAluguel6": {
          name: 'mediaPercentualAluguel6',
          type: 'number'
        },
        "maximo12m": {
          name: 'maximo12m',
          type: 'number'
        },
        "maximo24m": {
          name: 'maximo24m',
          type: 'number'
        },
        "minimo12m": {
          name: 'minimo12m',
          type: 'number'
        },
        "minimo24m": {
          name: 'minimo24m',
          type: 'number'
        },
        "variacao12m": {
          name: 'variacao12m',
          type: 'number'
        },
        "variacao24m": {
          name: 'variacao24m',
          type: 'number'
        },
      },
      relations: {
        aluguelFundoImobiliarios: {
          name: 'aluguelFundoImobiliarios',
          type: 'AluguelFundoImobiliario[]',
          model: 'AluguelFundoImobiliario',
          relationType: 'hasMany',
                  keyFrom: 'ticker',
          keyTo: 'ticker'
        },
      }
    }
  }
}
