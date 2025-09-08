# Sistema de Supermercado Online (SPW S/A) em Kotlin

Este repositório contém a implementação de um sistema de supermercado online, o SPW S/A, desenvolvido como projeto para a disciplina de PDM, ministrada pelo professor Emmerson Santa Rita da Silva. O projeto foi inteiramente codificado em Kotlin, aplicando conceitos fundamentais de Programação Orientada a Objetos, como encapsulamento, herança, polimorfismo e associações, conforme especificado no enunciado do trabalho.

## Sobre o Projeto

O SPW S/A é um sistema que simula a gestão de um supermercado online, controlando produtos, marcas, gêneros, estoque e um carrinho de compras virtual. O sistema foi modelado para refletir as operações do dia a dia de um e-commerce, incluindo:

* **Produtos e Marcas**: Gerenciamento de produtos com código, nome, preço, associados a uma `Marca` e a um `Genero` específico.
* **Estoque**: Controle rigoroso da entrada (`entraItem`) e saída (`saiItem`) de itens de produto (`ItemProduto`). O estoque permite a consulta de itens por múltiplos critérios, como marca, produto ou gênero.
* **Carrinho de Compras**: Um carrinho virtual (`Carrinho`) que interage diretamente com o estoque. Ao adicionar um item ao carrinho, ele é removido do estoque; ao remover, ele retorna ao estoque.
* **Controle de Validade**: Cada `ItemProduto` possui uma data de validade, e o sistema implementa uma função `valido()` para verificar se o produto está apto para venda.

## Funcionalidades Implementadas (Questões)

O projeto está dividido em duas partes (AP2 e AF), cada uma contendo uma série de questões que implementam e testam diferentes funcionalidades do sistema.

### Parte I - Avaliação AP2

* **Questão 1**: Lista todos os itens presentes no estoque, exibindo seus detalhes e o total de itens.
* **Questão 2**: Exibe o estoque agrupado por gênero, com o total de itens para cada gênero.
* **Questão 3**: Mostra todos os itens **válidos** (não vencidos) agrupados por gênero e, em seguida, por marca.
* **Questão 4**: Realiza uma análise do estoque, contando e exibindo o número de itens válidos e vencidos, e verificando se a soma bate com o total.
* **Questão 5**: Simula uma compra, movendo para o carrinho todos os itens do estoque cujo código do produto é ímpar, e exibe o estado final do carrinho e do estoque.
* **Questão 6**: Adiciona uma quantidade aleatória de itens válidos ao carrinho, demonstrando a interação aleatória com o estoque.
* **Questão 7**: Permite que o usuário final busque por todos os itens válidos de uma marca específica.

### Parte II - Avaliação AF

* **Questão 1**: Permite ao usuário buscar todos os itens do estoque pertencentes a um gênero específico informado via console.
* **Questão 2**: Busca e exibe todos os produtos cuja data de validade é anterior a uma data fornecida pelo usuário.
* **Questão 3**: Identifica e exibe o produto mais barato de cada gênero disponível no supermercado.
* **Questão 4**: Calcula o lucro potencial total, o prejuízo com itens vencidos que são descartados e o lucro real final.
* **Questão 5**: Simula um ciclo completo de compra: (1) mostra o estado inicial; (2) adiciona 10 itens aleatórios ao carrinho; (3) devolve todos os itens do carrinho ao estoque.
* **Questão 6**: Modifica a classe `SupermercadoWeb` para ter dois carrinhos (`carrinhoA` e `carrinhoB`) e os preenche com itens válidos e inválidos, respectivamente.

## Como Compilar e Executar

Cada questão das avaliações foi implementada em um arquivo `.kt` separado com uma função `main`.

### Executando via IntelliJ IDEA (Recomendado)

1.  Abra a pasta do projeto (`TrabalhoPOO_Kotlin`) no IntelliJ IDEA.
2.  No painel "Project" (geralmente à esquerda), navegue até o arquivo da questão que deseja executar (ex: `src/TrabalhoPOO/questoes/ap2/AP2Questao1.kt`).
3.  Abra o arquivo no editor. Você verá um ícone de "play" verde ao lado da declaração `fun main(args: Array<String>)`.
4.  Clique neste ícone e selecione a opção **"Run 'AP2Questao1Kt'"**.
5.  O IntelliJ IDEA irá compilar e executar o código. O resultado aparecerá na janela de ferramentas "Run" na parte inferior da IDE.
6.  Para as questões que pedem entrada de dados do usuário (como `AFQuestao1`, `AFQuestao2` e `AP2Questao7`), você deve digitar a informação diretamente no console da janela "Run" quando o programa solicitar.

### Executando via Terminal (Alternativa)

**Pré-requisitos:**
* JDK (Java Development Kit)
* Compilador Kotlin (`kotlinc`) instalado e configurado no PATH do sistema.

1.  **Navegue até a pasta `src` do projeto via terminal:**
    ```bash
    cd /caminho/para/seu/projeto/TrabalhoPOO_Kotlin/src
    ```

2.  **Compile o projeto (exemplo com a AP2, Questão 1):**
    ```bash
    kotlinc TrabalhoPOO/model/*.kt TrabalhoPOO/questoes/ap2/AP2Questao1.kt -include-runtime -d AP2Questao1.jar
    ```

3.  **Execute o arquivo `.jar` gerado:**
    ```bash
    java -jar AP2Questao1.jar
    ```