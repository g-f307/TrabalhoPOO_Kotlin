package TrabalhoPOO.questoes.ap

import TrabalhoPOO.model.SupermercadoWeb

class AP2Questao4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val todosOsItens = spw.estoque.getItens()

            val totalItens = todosOsItens.size
            val itensValidos = todosOsItens.count { it.valido() }
            val itensVencidos = todosOsItens.count { !it.valido() }

            println("***** ANÁLISE DO ESTOQUE *****")
            println("Total de itens válidos (não vencidos): $itensValidos")
            println("Total de itens vencidos: $itensVencidos")
            println("------------------------------------")

            val soma = itensValidos + itensVencidos
            println("Soma (Válidos + Vencidos): $soma")
            println("Total de itens no estoque: $totalItens")

            if (soma == totalItens) {
                println("VERIFICAÇÃO: A soma confere com o total do estoque.")
            } else {
                println("VERIFICAÇÃO: ERRO! A soma não confere com o total do estoque.")
            }
        }
    }
}