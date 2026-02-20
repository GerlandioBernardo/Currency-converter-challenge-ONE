# 💱 Conversor de Moedas


## 📋 Sobre o Projeto

Este projeto é parte do **Tech Foundation - Fase de Especialização em Java** do programa **Oracle Next Education (ONE)** em parceria com a **Alura**. O desafio consiste em desenvolver um conversor de moedas utilizando conceitos de **Programação Orientada a Objetos (POO)** em Java.


## 🎯 Funcionalidades

O sistema oferece as seguintes conversões:

- 💵 Dólar (USD) ⇄ Peso Argentino (ARS)
- 💵 Dólar (USD) ⇄ Real Brasileiro (BRL)
- 💵 Dólar (USD) ⇄ Peso Colombiano (COP)

## 🏗️ Estrutura do Projeto

O projeto está organizado seguindo os princípios de POO:

```
src/
├── Main.java                 # Classe principal com interface do usuário
├── ExchangeRateService.java  # Serviço de consumo da API de câmbio
├── ExchangeResponse.java     # Modelo de dados da resposta da API
└── Env.java                  # Gerenciador de variáveis de ambiente
```

### 📦 Descrição das Classes

- **Main**: Contém o menu interativo e a lógica de controle do fluxo da aplicação
- **ExchangeRateService**: Responsável por fazer requisições HTTP à API e processar as respostas
- **ExchangeResponse**: Classe modelo que representa a estrutura dos dados retornados pela API
- **Env**: Classe utilitária para carregar variáveis de ambiente do arquivo `.env`

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 17 ou superior
- IDE Java (recomendado: IntelliJ IDEA, Eclipse ou VS Code)
- Biblioteca Gson (para manipulação de JSON)
- Chave de API do [ExchangeRate-API](https://www.exchangerate-api.com/)

### Configuração

1. Clone o repositório:
```bash
git clone git@github.com:GerlandioBernardo/Currency-converter-challenge-ONE.git
cd Currency-converter-challenge-ONE
```

2. Crie um arquivo `.env` na raiz do projeto com sua chave de API:
```env
API_KEY=sua_chave_api_aqui
API_URL=https://v6.exchangerate-api.com/v6
```

3. Abra o projeto no IntelliJ IDEA

4. Execute a aplicação clicando no botão **Play** (▶️)

## 💻 Exemplo de Uso

```
**************************************************************
Seja bem-vindo/a ao Conversor de Moeda =]

1) Dólar => Peso argentino
2) Peso argentino => Dólar
3) Dólar => Real brasileiro
4) Real brasileiro => Dólar
5) Dólar => Peso colombiano
6) Peso colombiano => Dólar
7) Sair
Escolha uma opção válida:
**************************************************************
```

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal
- **Gson**: Biblioteca para serialização/deserialização JSON
- **ExchangeRate-API**: API para obtenção de taxas de câmbio em tempo real
- **HttpURLConnection**: Para requisições HTTP


⭐ **Oracle Next Education + Alura** | Tech Foundation - Especialização em Java
