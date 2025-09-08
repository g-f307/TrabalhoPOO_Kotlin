package TrabalhoPOO.questoes.ap

import TrabalhoPOO.model.SupermercadoWeb

class AP2Questao3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val itensValidos = spw.estoque.getItens().filter { it.valido() }

            println("***** ESTOQUE VÁLIDO POR GÊNERO E MARCA *****")

            val porGenero = itensValidos.groupBy { it.produto.genero.nome }

            porGenero.forEach { (genero, itensDoGenero) ->
                println("\n--- GÊNERO: $genero ---")
                val porMarca = itensDoGenero.groupBy { it.produto.marca.nome }

                porMarca.forEach { (marca, itensDaMarca) ->
                    println("  MARCA: $marca")
                    itensDaMarca.forEach { item ->
                        System.out.printf(
                            "    CÓD: %-4d NOME: %-16s PREÇO: R$%-6.2f VALIDADE: %s\n",
                            item.produto.codigo,
                            item.produto.nome,
                            item.produto.preco,
                            item.dataValidade.toString()
                        )
                    }
                }
            }
            println("\n***************************************")
            println("Total de itens válidos: ${itensValidos.size} itens.")
        }
    }
}