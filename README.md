# Descrição dos desafios

# Primeiro Modulo:

Java-0 -> Fibonacci
Faça um método @Desafio("Fibonacci") que retorne uma lista java.util.List com os primeiros números Integer da série de Fibonacci até 350.
Faça um segundo método @Desafio("isFibonnaci") que recebe um Integer como parâmetro e retorne Boolean. Caso o número recebido por parâmetro esteja entre os números da sequência de Fibonnaci do @Desafio("Fibonnaci") retorne true, senão, false.

Java-6 -> Criptografia de Júlio César
Automatize a criptografia e descriptografia de menagens utilizando a criptografia de Julio César.

Regras:
- As mensagens serão convertidas para minúsculas tanto para a criptografia quanto para descriptografia.
- Os números serão mantidos

Java-13 -> Calculadora de Salário Líquido
Implemente um algoritmo que será responsável por receber como parâmetro o salário bruto e retornar o salário líquido, já com todos os descontos de INSS e IRRF. (Utilize o método Math.round() para arredondar o resultado final).

# Segundo Módulo:

Java-1 -> Gerenciador de Times de Futebol
Nesse desafio deve-se construir o backend de um novo gerenciador de times de futebol.
Deverá ser implementada a interface MeuTimeInterface.
- incluirTime: Realiza a inclusão de um novo time
- incluirJogador: Realiza a inclusão de um novo jogador
- definirCapitao: Define um jogador como capitão do seu time. Um time deve ter apenas um capitão, por tanto o capitão anterior voltará a ser apenas jogador.
- buscarCapitaoDoTime: Mostra o identificador do capitão do time.
- buscarNomeJogador: Retorna o nome do jogador.
- buscarNomeTime: Retorna o nome do time.
- busarJogadoresDoTime: Retorna a lista com o identificador de todos os jogadores do time, ordenada pelo id.
- buscarMelhorJogadorDoTime: Retorna o identificador do melhor jogador do time.
- buscarJogadorMaisVelho: Retorna o identificador do jogador mais velho do time. Usar o menor identificador como critério de desempate.
- buscarTimes: Retorna uma lista com o identificador de todos os times cadastrado, ordenada pelo identificador. Retornar uma lista vazia caso não encontre times cadastrados.
- buscarJogadorMaiorSalario: Retorna o identificador do jogador com maior salário do time. Usar o menor identificador como critério de desempate.
- buscarSalarioJogador: Retorna o salário do jogador.
- buscarTopJogadores: Retorna uma lista com o identificador dos top melhores jogadores, utilizar o menor identificador como critério de desempate.
- buscarCorCamisaTimeDeFora: Retorna a cor da camisa do time adversário. Caso a cor principal do time da casa seja igual a cor principal do time de fora, retornar cor secundária do time de fora. Caso a cor principal do time da casa seja diferente da cor principal do time de fora, retornar cor principal do time de fora.

Java-7 -> Controle de estacionamento
Objetivo desse sistema é auxiliar na gestão de um estacionamento. Esse estacionamento é formato por um número limitado de vagas, assim, as regras são:
- O número de vagas do estacionamento são de dez carros.
- Para cada carro que entra no sistema é necessário informar a sua placa, cor além das informações do motorista.
- Para entrar no estacionamento, é necessário que exista um motorista, ou seja, nada de carro autônomo.
- O motorista precisa ter idade suficiente para dirigir e possuir uma habilitação.
- A habilitação não deverá está suspensa, ou seja, a pontuação da carteira de motorista não deverá ser superior a vinte pontos.
- O estacionamento não deverá comportar o número superior de vagas.
- Caso o estacionamento esteja lotado: * Chegue mais um novo carro, o primeiro que estacionou deverá sair * Caso o motorista do primeiro carro estacionado tenha uma idade superior a 55 anos, será escolhido o próximo motorista abaixo dos 55 anos. * Caso todos os motoristas, dentro do estacionamento, tenham mais de 55 anos e chegue um motorista, ele não conseguirá estacionar.

Java-14 -> Calcular Media, Moda e Mediana
- O método que terá o nome average deve receber um array de inteiros e retornar a média de seus valores. A média pode ser obtida através da soma de todos os valores do conjunto, dividida pela quantidade de elementos do conjunto.
- O método que terá o nome mode deve receber um array de inteiros e retornar um inteiro contendo o valor da moda do conjunto. A moda é representada pelo valor que mais se repete no conjunto.
- O método que terá o nome median deve receber um array de inteiros e retornar um valor inteiro contendo a mediana do conjunto. A mediana pode ser obtida ordenando os valores no array e pegando o valor que se encontra no meio do mesmo. Para arrays com quantidade par de elementos, não haverá um único valor no meio, nesse caso a mediana será definida como a média entre os dois valores do meio do array.

