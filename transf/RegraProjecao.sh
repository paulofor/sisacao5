cd /root/aplicativos/
echo $1
echo $2
java -Xms128m -Xmx1024m -jar CotacaoRegraProjecaoValor.jar $1 $2 > /root/RegraProjecao_$1_$2.log 
