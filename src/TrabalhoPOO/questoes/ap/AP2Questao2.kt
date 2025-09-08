package TrabalhoPOO.questoes.ap

import TrabalhoPOO.model.SupermercadoWeb

class AP2Questao2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val itensEstoque = spw.estoque.getItens()
            val itensPorGenero = itensEstoque.groupBy { it.produto.genero.nome }

            println("*****ESTOQUE POR GÊNERO *****")

            itensPorGenero.forEach { (genero, itensDoGenero) ->
                println("CÓD     |    NOME    |    GENERO    |    MARCA    |    PREÇO    |    VALIDADE    |    VÁLIDO?    ")
                println("-----------------------------------------------------------------------------------------------")

                itensDoGenero.forEach { item ->
                    val validoStr = if (item.valido()) "sim" else "não"
                    System.out.printf(
                        "%-8d %-16s %-16s R$%-6.2f %-10s %s\n",
                        item.produto.codigo,
                        item.produto.nome,
                        item.produto.marca.nome,
                        item.produto.preco,
                        item.dataValidade.toString(),
                        validoStr
                    )
                }
                println("TOTAL GÊNERO: ${itensDoGenero.size} itens.")
            }
            println("\n********************************")
            println("TOTAL GERAL: ${itensEstoque.size} itens.")
        }
    }
}