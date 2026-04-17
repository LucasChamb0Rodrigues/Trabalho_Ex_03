# Planejamento: Controle de Pedidos de Lanchonete

Sistema desenvolvido para organizar os pedidos de uma lanchonete, evitando erros de anotação e facilitando o fechamento do caixa.

### Tabelas (Entidades) Identificadas
* **Produto:** Armazena `nome`, `descrição` e `preço`.
* **Pedido:** Armazena a `data`, uma `lista de produtos` e o `valor total`.

### Regras de Negócio Implementadas
* **Validação de Preço:** O sistema impede o cadastro de produtos com valor negativo ou sem nome.
* **Integridade do Pedido:** Um pedido só pode ser finalizado e registrado se contiver pelo menos um produto adicionado.
* **Cálculo Automático:** O sistema soma o preço de todos os itens inseridos no pedido para gerar o total da conta.
* **Relatório Financeiro:** Permite consultar os pedidos de um dia específico e calcula o faturamento total do período.