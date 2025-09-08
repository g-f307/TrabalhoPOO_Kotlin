package TrabalhoPOO.questoes.af

import TrabalhoPOO.model.SupermercadoWeb

class AFQuestao3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            println("***** PRODUTOS MAIS BARATOS POR GÊNERO *****")

            val produtosPorGenero = spw.produtos.groupBy { it.genero }

            produtosPorGenero.forEach { (genero, produtosDoGenero) ->
                val maisBarato = produtosDoGenero.minByOrNull { it.preco }

                if (maisBarato != null) {
                    System.out.printf(
                        "Gênero: %-14s -> Produto: %-16s (Marca: %-10s) | Preço: R$%.2f\n",
                        genero.nome,
                        maisBarato.nome,
                        maisBarato.marca.nome,
                        maisBarato.preco
                    )
                }
            }
        }
    }
}