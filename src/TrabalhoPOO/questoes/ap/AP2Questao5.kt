package TrabalhoPOO.questoes.ap

import TrabalhoPOO.model.SupermercadoWeb

class AP2Questao5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            val itensParaMover = spw.estoque.getItens().filter { it.produto.codigo % 2 != 0 }

            itensParaMover.forEach { item ->
                spw.carrinho.addItem(item, spw.estoque)
            }

            val itensCarrinho = spw.carrinho.getItens()
            println("***** CARRINHO DE COMPRAS *****")
            if (itensCarrinho.isEmpty()){
                println("Carrinho vazio.")
            } else {
                itensCarrinho.forEach {
                    println("- ${it.produto.nome} (${it.produto.marca.nome}) - R$${it.produto.preco}")
                }
            }
            println("Quantidade no carrinho: ${itensCarrinho.size} itens.")
            System.out.printf("Total a pagar: R$%.2f\n", spw.carrinho.totalAPagar())

            val itensEstoque = spw.estoque.getItens()
            println("\n***** ESTOQUE RESTANTE *****")
            println("Total de itens restantes: ${itensEstoque.size} itens.")
        }
    }
}