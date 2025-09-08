package TrabalhoPOO.questoes.ap

import TrabalhoPOO.model.SupermercadoWeb

class AP2Questao7 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            print("Digite o nome de uma marca para buscar (Ex: Nestlé, Sadia, Duleite): ")
            val nomeMarca = readlnOrNull() ?: ""

            val marcaBuscada = spw.marcas.find { it.nome.equals(nomeMarca, ignoreCase = true) }

            if (marcaBuscada == null) {
                println("Marca '$nomeMarca' não encontrada.")
            } else {
                val itensEncontrados = spw.estoque.getItens(marcaBuscada).filter { it.valido() }

                println("\n***** ITENS VÁLIDOS DA MARCA '${marcaBuscada.nome}' *****")
                if (itensEncontrados.isEmpty()) {
                    println("Nenhum item válido encontrado para esta marca.")
                } else {
                    itensEncontrados.forEach { item ->
                        System.out.printf(
                            "- %-16s | Gênero: %-12s | Preço: R$%-6.2f | Validade: %s\n",
                            item.produto.nome,
                            item.produto.genero.nome,
                            item.produto.preco,
                            item.dataValidade.toString()
                        )
                    }
                }
                println("---------------------------------------------------------")
                println("Total de itens encontrados: ${itensEncontrados.size}") // [cite: 182]
            }
        }
    }
}