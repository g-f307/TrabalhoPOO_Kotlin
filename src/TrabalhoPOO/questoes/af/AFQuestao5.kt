package TrabalhoPOO.questoes.af

import TrabalhoPOO.model.SupermercadoWeb

class AFQuestao5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            println("--- ESTADO INICIAL ---")
            println("Itens no estoque: ${spw.estoque.qtdItens()}")
            println("Itens no carrinho: ${spw.carrinho.getItens().size}")

            val itensParaMover = spw.estoque.getItens().shuffled().take(10)
            itensParaMover.forEach { item ->
                spw.carrinho.addItem(item, spw.estoque)
            }

            println("\n--- APÓS ADICIONAR 10 ITENS AO CARRINHO ---")
            println("Itens no estoque: ${spw.estoque.qtdItens()}")
            println("Itens no carrinho: ${spw.carrinho.getItens().size}")

            val itensParaDevolver = spw.carrinho.getItens().toList()
            itensParaDevolver.forEach { item ->
                spw.carrinho.removeItem(item, spw.estoque)
            }

            println("\n--- APÓS DEVOLVER TODOS OS ITENS AO ESTOQUE ---")
            println("Itens no estoque: ${spw.estoque.qtdItens()}")
            println("Itens no carrinho: ${spw.carrinho.getItens().size}")
        }
    }
}