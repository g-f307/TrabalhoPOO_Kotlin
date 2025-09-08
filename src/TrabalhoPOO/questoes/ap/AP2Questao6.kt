package TrabalhoPOO.questoes.ap

import TrabalhoPOO.model.SupermercadoWeb

class AP2Questao6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            val itensValidosEstoque = spw.estoque.getItens().filter { it.valido() }

            val quantidadeParaAdicionar = (1..5).random().coerceAtMost(itensValidosEstoque.size)

            val itensParaMover = itensValidosEstoque.shuffled().take(quantidadeParaAdicionar)

            println("Adicionando $quantidadeParaAdicionar itens aleatórios ao carrinho...")
            itensParaMover.forEach { item ->
                spw.carrinho.addItem(item, spw.estoque)
            }

            println("\n***** CARRINHO DE COMPRAS *****")
            spw.carrinho.getItens().forEach {
                println("- ${it.produto.nome} (${it.produto.marca.nome})")
            }
            println("Quantidade no carrinho: ${spw.carrinho.getItens().size} itens.")
            
            println("\n***** ESTOQUE RESTANTE ******")
            println("Total de itens restantes: ${spw.estoque.qtdItens()} itens.")
        }
    }
}