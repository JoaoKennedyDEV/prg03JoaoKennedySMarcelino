**Documento de Especificação de Requisitos** 

| *Projeto: Sistema de Caixa para pequenos comércios Data de Criação: Agosto 2026 Autor: João Kennedy Santos Marcelino Cargo:* |
| :---- |

**Conteúdo** 

1 Introdução 

	1.1 Objetivo

2 Descrição geral 

2.1 Modo de Operação 

2.2 Funções do produto 

2.3 Requisitos Adiados 

3 Requisitos específicos 

3.1 Requisitos Funcionais 

3.2 Requisitos Não-Funcionais 

**1 Introdução** 

O sistema tem como objetivo ajudar pequenos comércios a se modernizar e utilizar tecnologias para organizar melhor suas vendas. A ideia surgiu a partir da observação da necessidade de um sistema em pequenos comércios, então buscamos desenvolver um sistema que ajude a registrar os produtos vendidos, calcular os valores e finalizar a compra de maneira mais prática. 

Público-alvo: pequenos comércios que ainda fazem o controle de vendas de forma manual. 

**1.1 Objetivo**

 O objetivo deste documento é apresentar, de maneira simples e organizada, as principais necessidades do Sistema de Caixa para Pequenos Comércios. Ele servirá como base para orientar o desenvolvimento do projeto durante o semestre, definindo inicialmente o que o sistema deverá fazer e algumas características esperadas. 

**2 Descrição geral** 

**2.1 Modo de Operação** 

O sistema funcionará como um caixa básico. O operador terá acesso às opções de cadastro e consulta de produtos e poderá iniciar uma venda. Durante a venda, os produtos serão adicionados com suas respectivas quantidades, e o sistema fará os cálculos automaticamente. Depois de adicionar todos os itens, o total da compra será apresentado, a forma de pagamento será informada e a venda será finalizada.

 Funcionamento básico: Cadastrar produtos → Iniciar venda → Selecionar produto → Informar quantidade → Adicionar outros produtos → Calcular total → Informar pagamento → Finalizar venda 

**2.2 Funções do produto** 

| Nº  | Função  | Descrição |
| :---- | :---- | :---- |
| 01  | Cadastrar produto | permitir o cadastro dos produtos que serão vendidos.  |
| 02  | Consultar produto | permite visualizar produtos cadastrados. |
| 03  | Iniciar venda | permitir iniciar uma nova venda.  |
| 04  | Adicionar produto | permitir adicionar produtos e suas respectivas quantidades à venda.  |
| 05 | Calcular total | Permitir calcular o valor total da venda.  |
| 06 | pagamento | permite informar o meio de pagamento, e calcular o troco se necessário. |
| 07 | Finalizar venda | Encerra a venda e salva e registra no histórico de vendas. |
| 08 | Histórico de vendas | Permite acessar todas as vendas que já foram realizadas. |

**2.3 Requisitos Adiados**

| Nº  | Referência  | Detalhes |
| :---- | :---- | :---- |
| 01 | Cadastro de funcionários | Cada funcionário terá um login e senha, permitindo assim gerenciar as permissões para cada funcionário e saber qual funcionário realizou cada venda. |
| 02 | Cadastro de fornecedor | Permite cadastrar o fornecedor e os produtos que ele vende, facilitando na hora de fazer novos pedidos. |

**3 Requisitos específicos** 

**3.1 Requisitos Funcionais**

| Código | Nome | Descrição |
| :---- | :---- | :---- |
| RF01  | Cadastrar produto | O sistema deverá permitir o cadastro de produtos, informando código, nome e preço.  |
| RF02  | Consultar produto | O sistema deverá permitir consultar os produtos cadastrados, apresentando suas informações.  |
| RF03  | Iniciar venda | O sistema deverá permitir iniciar uma nova venda.  |
| RF04  | Adicionar produto | O sistema deverá permitir adicionar um produto à venda, informando a quantidade desejada. |
| RF05 | Calcular total | O sistema deverá calcular automaticamente o valor total da venda com base nos produtos e quantidades adicionados.  |
| RF06 | Pagamento | O sistema deverá permitir informar a forma de pagamento e, quando necessário, calcular o valor do troco.  |
| RF07 | Finalizar venda | O sistema deverá permitir finalizar a venda e registrar os dados no histórico.  |
| RF08 | Histórico de vendas | Permite acessar todas as vendas que já foram realizadas. |

 

**3.2 Requisitos Não-Funcionais** 

| Código | Nome | Descrição |
| :---- | :---- | :---- |
| RNF01  | Facilidade no Uso | O sistema deverá ter uma interface simples, organizada e intuitiva permitindo que o operador entenda as opções mesmo sem entender muito sobre essa tecnologia. |
| RNF02 | Expansividade | A estrutura do projeto deverá permitir que novas funcionalidades sejam incluídas no futuro. |
| RNF03 | Desempenho | Os cálculos e consultas deverão ser realizadas de forma rápida. |

