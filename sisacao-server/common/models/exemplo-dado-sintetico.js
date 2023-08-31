'use strict';

var app = require('../../server/server');

module.exports = function(Exemplodadosintetico) {


    Exemplodadosintetico.ListaPorAmostraParaTreino = function(idAmostra, callback) {
      const filtro = {
        'fields' : {'campoY' : true, 'campoX' : true},
        'where' : {'amostraDadoSinteticoId' : idAmostra}
      }
      Exemplodadosintetico.find(filtro,(err,result) => {
        if (err==null)
          callback(err,result);
        else
          callback(err,null);
      })
    }
  


    function shuffleArray(array) {
      for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
      }
      return array;
    }

    Exemplodadosintetico.GerarPorAmostra = function(idAmostra,callback) {
        //const sqlDelete = "delete from ExemploDadoSintetico where amostraDadoSinteticoId = " + idAmostra;
        //let filtro = {'include' : 'tipoExemploTreino'}
        const ds = Exemplodadosintetico.dataSource;
        //ds.connector.query(sqlDelete, (err,result) => {
          app.models.AmostraDadoSintetico.findById(idAmostra,(err,amostra) => {
            //console.log('Amostra: ' , amostra);
            app.models.TipoExemploTreino.findById(amostra.tipoExemploTreinoId, (err,tipoExemplo) => {
              console.log('Tipo Exemplo: ' , tipoExemplo);
              const qtdePontos = tipoExemplo.tamanhoEntrada;
              //let qtdePontos = 60;
              const qtdeSubida = Math.round(amostra.qtdeExemplo * amostra.percentualSubida);
              const qtdeDescida = Math.round(amostra.qtdeExemplo * amostra.percentualDescida);
              const qtdeFlat = amostra.qtdeExemplo - qtdeSubida - qtdeDescida;
              for (let i=1;i<=qtdeSubida;i++) {
                const campoXArr1 = geraSubida(amostra, qtdePontos);
                const campoXArr2 = colocaRuido(campoXArr1, amostra);
                const campoX = campoXArr2.map(num => num.toFixed(3)).join(', ');
                const campoXPonderado = fazAjuste(campoXArr2);
                const campoXFinal = campoXPonderado.map(num => num.toFixed(3)).join(', ');
                const sql = "insert into ExemploDadoSintetico (amostraDadoSinteticoId, campoXOriginal, campoY, resultado, campoX) values ( " + idAmostra + " , " +
                  " '" + campoX + "', '1' , 1, '" + campoXFinal + "')";
                ds.connector.query(sql,(err,result) => {
                  //console.log('err1' , err);
                })
              }
              for (let i=1;i<=qtdeDescida;i++) {
                  const campoXArr1 = geraDescida(amostra, qtdePontos);
                  const campoXArr2 = colocaRuido(campoXArr1, amostra);
                  const campoX = campoXArr2.map(num => num.toFixed(3)).join(', ');
                  const campoXPonderado = fazAjuste(campoXArr2);
                  const campoXFinal = campoXPonderado.map(num => num.toFixed(3)).join(', ');
                  const sql = "insert into ExemploDadoSintetico (amostraDadoSinteticoId, campoXOriginal, campoY, resultado, campoX) values ( " + idAmostra + " , " +
                    " '" + campoX + "', '0' , -1, '" + campoXFinal + "')";
                  ds.connector.query(sql,(err,result) => {
                    //console.log('err1' , err);
                  })
              }
              for (let i=1;i<=qtdeFlat;i++) {
                  const campoXArr1 = geraFlat(amostra, qtdePontos);
                  const campoXArr2 = colocaRuido(campoXArr1, amostra);
                  const campoX = campoXArr2.map(num => num.toFixed(3)).join(', ');
                  const campoXPonderado = fazAjuste(campoXArr2);
                  const campoXFinal = campoXPonderado.map(num => num.toFixed(3)).join(', ');
                  const sql = "insert into ExemploDadoSintetico (amostraDadoSinteticoId, campoXOriginal, campoY, resultado, campoX) values ( " + idAmostra + " , " +
                    " '" + campoX + "', '0' , 0, '" + campoXFinal + "')";
                  ds.connector.query(sql,(err,result) => {
                    //console.log('err1' , err);
                  })
              }
              callback(err,amostra);
            })
        //})

        })
    }

    function geraSubida(amostra, qtde) {
        //console.log('tamanho recebido: ' , qtde);
        const sequence = [];
        let previousNumber = 100;
        for (let i = 0; i < qtde ; i++) {
          const randomNumber = previousNumber + (Math.random() * amostra.magnitudeTrend);
          // Verifica se um ponto de redução deve ser incluído
          if (Math.random() < amostra.percentualContraTrend) { // % de chance de redução
            const reduction = Math.random() * amostra.magnitudeContraTrend; // Valor de redução aleatório
            sequence.push(previousNumber - reduction); // Adiciona o número reduzido
            previousNumber -= reduction; // Atualiza o número anterior
          } else {
            sequence.push(randomNumber);
            previousNumber = randomNumber;
          }
          //console.log(i , ' - ' , randomNumber);
          //console.log(sequence.length);
        }
        //console.log('Subida tamanho:' , sequence.length)
        return sequence;
    }
      

    function geraDescida(amostra, qtde) {
      const sequence = [];
      let previousNumber = 100;
      for (let i = 0; i < qtde ; i++) {
        const randomNumber = previousNumber - (Math.random() *  amostra.magnitudeTrend);
        // Verifica se um ponto de redução deve ser incluído
        if (Math.random() < amostra.percentualContraTrend) { // 10% de chance de redução
          const reduction = Math.random() * amostra.magnitudeContraTrend; // Valor de redução aleatório
          sequence.push(previousNumber - reduction); // Adiciona o número reduzido
          previousNumber += reduction; // Atualiza o número anterior
        } else {
          sequence.push(randomNumber);
          previousNumber = randomNumber;
        }
      }
      return sequence;
    }

    function geraFlat(amostra, qtde) {
      const sequence = [];
      const maxDifference = 0.90;

      //let currentValue = Math.random(); // Gera o primeiro número aleatório
      let currentValue = 100;
      sequence.push(currentValue);

      for (let i = 1; i < qtde ; i++) {
        const minValue = currentValue - maxDifference; // Valor mínimo permitido
        const maxValue = currentValue + maxDifference; // Valor máximo permitido
        const randomNumber = minValue + Math.random() * (maxValue - minValue); // Gera um número aleatório dentro do intervalo permitido
        currentValue = randomNumber;
        sequence.push(currentValue);
      }

      return sequence;
    }
      
   
    function colocaRuido(dados, amostra) {
      const noisySequence = [];
    
      for (let i = 0; i < dados.length; i++) {
        const noise = (Math.random() - 0.5) * 2 * amostra.magnitudeRuido; // Gera um valor aleatório entre -noiseMagnitude e noiseMagnitude
        const noisyNumber = dados[i] + noise;
        noisySequence.push(noisyNumber);
      }
    
      return noisySequence;
    }

    function fazAjuste(dados) {
      let inicial = dados[dados.length-1];
      let saida =  Array(dados.length).fill(0);
      for (let i=dados.length-1;i>=0;i--) {
        saida[i] = dados[i] / inicial;
      } 
      //console.log('dados:' , dados);
      //console.log('saida:' , saida);
      return saida;
    }
    
    
};
