package TrabalhoPOO.questoes.af

import TrabalhoPOO.model.SupermercadoWeb

class AFQuestao4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()

            val estoqueInicial = spw.estoque.getItens()
            val lucroPotencial = estoqueInicial.sumOf { it.produto.preco }
            println("****** SITUAÇÃO INICIAL DO ESTOQUE *****")
            println("Total de itens: ${estoqueInicial.size}")
            System.out.printf("Lucro potencial total (se tudo for vendido): R$%.2f\n", lucroPotencial)

            val itensVencidos = estoqueInicial.filter { !it.valido() }
            val prejuizo = itensVencidos.sumOf { it.produto.preco }

            itensVencidos.forEach { itemVencido ->
                spw.estoque.saiItem(itemVencido)
            }

            val estoqueFinal = spw.estoque.getItens()
            println("\n***** SITUAÇÃO APÓS RETIRADA DOS VENCIDOS *****")
            println("Total de itens restantes: ${estoqueFinal.size}")
            System.out.printf("Prejuízo com itens vencidos: R$%.2f\n", prejuizo)

            val lucroReal = lucroPotencial - prejuizo
            System.out.printf("Lucro real (Potencial - Prejuízo): R$%.2f\n", lucroReal)
        }
    }
}