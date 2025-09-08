package TrabalhoPOO.questoes.af

import TrabalhoPOO.model.Genero
import TrabalhoPOO.model.SupermercadoWeb

class AFQuestao1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            print("Digite o nome de um gênero (Leite, Presunto, Achocolatado): ")
            val nomeGenero = readlnOrNull() ?: ""

            val generoBuscado = when (nomeGenero.lowercase()) {
                "leite" -> Genero.Leite
                "presunto" -> Genero.Presunto
                "achocolatado" -> Genero.Achocolatado
                else -> null
            }

            if (generoBuscado == null) {
                println("Gênero '$nomeGenero' inválido.")
            } else {
                val itensEncontrados = spw.estoque.getItens(generoBuscado)

                println("\n***** ESTOQUE DO GÊNERO '${generoBuscado.nome}' *****")
                if (itensEncontrados.isEmpty()) {
                    println("Nenhum item encontrado para este gênero.")
                } else {
                    println("CÓD     |    NOME    |    GENERO    |    MARCA    |    PREÇO    |    VALIDADE    |    VÁLIDO?    ")
                    println("-----------------------------------------------------------------------------------------------")
                    itensEncontrados.forEach { item ->
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
                }
                println("-----------------------------------------------------------------")
                println("TOTAL: ${itensEncontrados.size} itens.") // [cite: 191]
            }
        }
    }
}