/* tslint:disable */
import { Injectable } from '@angular/core';
import { User } from '../../models/User';
import { Ativo } from '../../models/Ativo';
import { AtivoOpcao } from '../../models/AtivoOpcao';
import { AtivoAcao } from '../../models/AtivoAcao';
import { AtivoMercadoria } from '../../models/AtivoMercadoria';
import { AtivoImobiliario } from '../../models/AtivoImobiliario';
import { CotacaoIntradayOpcao } from '../../models/CotacaoIntradayOpcao';
import { CotacaoIntradayAcao } from '../../models/CotacaoIntradayAcao';
import { CotacaoIntradayImobiliario } from '../../models/CotacaoIntradayImobiliario';
import { CotacaoIntradayMercadoria } from '../../models/CotacaoIntradayMercadoria';
import { DataSource } from '../../models/DataSource';
import { AtributoDataSource } from '../../models/AtributoDataSource';

export interface Models { [name: string]: any }

@Injectable()
export class SDKModels {

  private models: Models = {
    User: User,
    Ativo: Ativo,
    AtivoOpcao: AtivoOpcao,
    AtivoAcao: AtivoAcao,
    AtivoMercadoria: AtivoMercadoria,
    AtivoImobiliario: AtivoImobiliario,
    CotacaoIntradayOpcao: CotacaoIntradayOpcao,
    CotacaoIntradayAcao: CotacaoIntradayAcao,
    CotacaoIntradayImobiliario: CotacaoIntradayImobiliario,
    CotacaoIntradayMercadoria: CotacaoIntradayMercadoria,
    DataSource: DataSource,
    AtributoDataSource: AtributoDataSource,
    
  };

  public get(modelName: string): any {
    return this.models[modelName];
  }

  public getAll(): Models {
    return this.models;
  }

  public getModelNames(): string[] {
    return Object.keys(this.models);
  }
}
