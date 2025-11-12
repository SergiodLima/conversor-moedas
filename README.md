Conversor de Moedas - Java Console App
![alt text](https://img.shields.io/badge/status-concluído-green)
Um conversor de moedas interativo via console, desenvolvido em Java como um desafio para aplicar os conceitos fundamentais da Programação Orientada a Objetos (POO). A aplicação consome a API ExchangeRate-API para obter taxas de câmbio em tempo real.
📋 Funcionalidades
Conversão em Tempo Real: Utiliza taxas de câmbio atualizadas para fornecer valores precisos.
Menu Interativo: Um menu simples e intuitivo para o usuário escolher as moedas de origem e destino.
Pares de Moedas Pré-definidos: Oferece opções de conversão para as moedas mais comuns, como Dólar (USD), Real (BRL), Euro (EUR), Peso Argentino (ARS) e Franco Suíço (CHF).
Carregamento Dinâmico: Os nomes completos das moedas (ex: "Brazilian Real") são carregados dinamicamente da API, evitando valores "hard-coded".
Entrada de Valor: Permite que o usuário insira qualquer valor numérico para a conversão.
Tratamento de Exceções: Valida a entrada do usuário e lida com possíveis falhas de comunicação com a API, garantindo que o programa não quebre inesperadamente.
🏛️ Conceitos de POO Aplicados
Este projeto foi estruturado para demonstrar os pilares da Programação Orientada a Objetos e boas práticas de desenvolvimento:
Encapsulamento: Os atributos das classes de modelo (Moeda) são privados e acessados através de métodos públicos (getters/setters), protegendo a integridade dos dados.
Abstração: A classe Conversao serve como uma abstração, definindo um contrato comum para entidades que representam uma conversão, sem se preocupar com a implementação específica.
Herança: A classe Moeda herda da classe Conversao, reutilizando seus atributos e comportamentos.
Separação de Responsabilidades: O projeto é dividido em pacotes (model, service, view) para separar claramente os dados, a lógica de negócio e a interação com o usuário, seguindo as melhores práticas de mercado.
🛠️ Tecnologias Utilizadas
Java 17: Linguagem principal do projeto.
Maven: Gerenciador de dependências do projeto.
Gson: Biblioteca do Google para fazer o parsing da resposta JSON da API.
Java HTTP Client: API nativa do Java (a partir do JDK 11) para realizar as requisições HTTP (HttpClient, HttpRequest).
🚀 Como Executar o Projeto
Siga os passos abaixo para configurar e executar o projeto em seu ambiente local.
Pré-requisitos
JDK 17 ou superior instalado.
Apache Maven instalado e configurado.
Uma IDE Java, como IntelliJ IDEA (recomendado) ou Eclipse.
Uma chave de API gratuita da ExchangeRate-API.
Instalação e Configuração
Clone o repositório:
code
Bash
git clone git@github.com:SergiodLima/conversor-moedas.git
Abra o projeto na sua IDE:
No IntelliJ IDEA, vá em File > Open... e selecione o arquivo pom.xml do projeto. A IDE irá carregar o projeto e baixar as dependências do Maven automaticamente.
Adicione sua Chave de API:
Navegue até o arquivo src/main/java/com/example/conversor/service/ApiService.java.
Encontre a variável apiKey e substitua "SUA_CHAVE_API" pela chave que você obteve no site da ExchangeRate-API.
code
Java
// Exemplo dentro de ApiService.java
String apiKey = "SUA_CHAVE_API_VAI_AQUI";
Execução
Encontre a classe Main.java no pacote com.example.conversor.
Clique com o botão direito do mouse sobre a classe e selecione Run 'Main.main()'.
O menu interativo será exibido no console da sua IDE. Siga as instruções para realizar as conversões.
✒️ Autor
Sergio de Lima - Desenvolvedor do projeto - SergiodLima


