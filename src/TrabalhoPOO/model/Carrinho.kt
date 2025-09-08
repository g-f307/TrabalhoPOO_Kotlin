package TrabalhoPOO.model

import TrabalhoPOO.model.Estoque
import TrabalhoPOO.model.ItemProduto

class Carrinho {
    private val itensCarrinho: MutableList<ItemProduto> = mutableListOf()

    fun addItem(item: ItemProduto, estoque: Estoque) {
        val itemRetirado = estoque.saiItem(item)
        if (itemRetirado != null) {
            itensCarrinho.add(itemRetirado)
            println("Item '${item.produto.nome}' adicionado ao carrinho.")
        } else {
            println("Item '${item.produto.nome}' não encontrado no estoque.")
        }
    }

    fun removeItem(item: ItemProduto, estoque: Estoque) {
        if (itensCarrinho.remove(item)) {
            estoque.entraItem(item)
            println("Item '${item.produto.nome}' removido do carrinho e devolvido ao estoque.")
        } else {
            println("Item '${item.produto.nome}' não encontrado no carrinho.")
        }
    }

    fun totalAPagar(): Double {
        return itensCarrinho.sumOf { it.produto.preco }
    }

    fun getItens(): List<ItemProduto> {
        return itensCarrinho.toList()
    }
}