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
import { DataSet } from '../../models/DataSet';
import { AtributoDataSet } from '../../models/AtributoDataSet';
import { StartupFundo } from '../../models/StartupFundo';
import { StartupEmpresa } from '../../models/StartupEmpresa';
import { StartupInvestimento } from '../../models/StartupInvestimento';
import { IdeiaExperimento } from '../../models/IdeiaExperimento';
import { DiaPregao } from '../../models/DiaPregao';
import { RegraSimulacao } from '../../models/RegraSimulacao';
import { ParametroRegra } from '../../models/ParametroRegra';
import { ExperimentoSimulacao } from '../../models/ExperimentoSimulacao';
import { ExperimentoParametro } from '../../models/ExperimentoParametro';
import { ExperimentoAcao } from '../../models/ExperimentoAcao';

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
    DataSet: DataSet,
    AtributoDataSet: AtributoDataSet,
    StartupFundo: StartupFundo,
    StartupEmpresa: StartupEmpresa,
    StartupInvestimento: StartupInvestimento,
    IdeiaExperimento: IdeiaExperimento,
    DiaPregao: DiaPregao,
    RegraSimulacao: RegraSimulacao,
    ParametroRegra: ParametroRegra,
    ExperimentoSimulacao: ExperimentoSimulacao,
    ExperimentoParametro: ExperimentoParametro,
    ExperimentoAcao: ExperimentoAcao,
    
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
