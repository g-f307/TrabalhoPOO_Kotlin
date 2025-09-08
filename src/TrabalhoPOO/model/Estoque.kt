package TrabalhoPOO.model

import TrabalhoPOO.model.Genero
import TrabalhoPOO.model.ItemProduto
import TrabalhoPOO.model.Marca
import TrabalhoPOO.model.Produto

class Estoque {
    private val itensEstoque: MutableList<ItemProduto> = mutableListOf()

    fun entraItem(item: ItemProduto) {
        itensEstoque.add(item)
    }

    fun saiItem(item: ItemProduto): ItemProduto? {
        return if (itensEstoque.remove(item)) {
            item
        } else {
            null
        }
    }

    fun qtdItens(): Int = itensEstoque.size

    fun getItens(): List<ItemProduto> {
        return itensEstoque.toList()
    }

    fun getItens(marca: Marca): List<ItemProduto> {
        return itensEstoque.filter { it.produto.marca == marca }
    }

    fun getItens(produto: Produto): List<ItemProduto> {
        return itensEstoque.filter { it.produto == produto }
    }

    fun getItens(genero: Genero): List<ItemProduto> {
        return itensEstoque.filter { it.produto.genero == genero }
    }
}