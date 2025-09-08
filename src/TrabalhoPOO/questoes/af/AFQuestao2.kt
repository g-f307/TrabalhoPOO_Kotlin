package TrabalhoPOO.questoes.af

import TrabalhoPOO.model.Data
import TrabalhoPOO.model.SupermercadoWeb

class AFQuestao2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            try {
                println("Digite uma data para buscar itens vencidos ANTES dela.")
                print("Dia (DD): ")
                val dia = readln().toInt()
                print("Mês (MM): ")
                val mes = readln().toInt()
                print("Ano (AAAA): ")
                val ano = readln().toInt()

                val dataFornecida = Data(dia, mes, ano)

                val listaX = spw.estoque.getItens().filter { it.dataValidade.antes(dataFornecida) }

                println("\n***** ITENS COM VALIDADE ANTERIOR A $dataFornecida *****")
                if (listaX.isEmpty()) {
                    println("Nenhum item encontrado.")
                } else {
                    listaX.forEach { item ->
                        println("- ${item.produto.nome} (Validade: ${item.dataValidade})")
                    }
                }
                println("------------------------------------")
                println("Quantidade total: ${listaX.size} itens.")

            } catch (e: NumberFormatException) {
                println("Erro: Formato de data inválido. Por favor, insira apenas números.")
            }
        }
    }
}