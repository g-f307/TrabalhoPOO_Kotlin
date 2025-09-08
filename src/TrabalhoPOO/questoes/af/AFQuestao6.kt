package TrabalhoPOO.questoes.af

import TrabalhoPOO.model.Carrinho
import TrabalhoPOO.model.SupermercadoWebModificado

class AFQuestao6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWebModificado()
            val carrinhoA = Carrinho()
            val carrinhoB = Carrinho()

            val itensEstoque = spw.estoque.getItens()

            val itensValidos = itensEstoque.filter { it.valido() }
            itensValidos.forEach { item ->
                carrinhoA.addItem(item, spw.estoque)
            }

            val itensInvalidos = spw.estoque.getItens()
            itensInvalidos.forEach { item ->
                carrinhoB.addItem(item, spw.estoque)
            }

            println("--- ESTADO FINAL ---")
            println("Itens restantes no estoque: ${spw.estoque.qtdItens()}")
            println("Itens no Carrinho A (Válidos): ${carrinhoA.getItens().size}")
            println("Itens no Carrinho B (Inválidos): ${carrinhoB.getItens().size}")
        }
    }
}