package TrabalhoPOO.questoes.ap

import TrabalhoPOO.model.SupermercadoWeb
import java.util.Locale

class AP2Questao1 {
companion object {
    @JvmStatic
    fun main(args: Array<String>) {
        Locale.setDefault(Locale("pt", "BR"))

        println("Inicializando o sistema SupermercadoWeb e populando o estoque...")
        val spw = SupermercadoWeb()
        val estoque = spw.estoque
        val todosOsItens = estoque.getItens()

        println()
        println("***** ESTOQUE *****")
            println("CÓD     |    NOME    |    GENERO    |    MARCA    |    PREÇO    |    VALIDADE    |    VÁLIDO?    ")
        println("-----------------------------------------------------------------------------------------------")

        for (item in todosOsItens) {
            val produto = item.produto

            val ehValido = if (item.valido()) "sim" else "não"
            
            val precoFormatado = "R$%.2f".format(produto.preco)

            println("%-4s %-20s %-15s %-15s %-10s %-10s %-7s".format(
                produto.codigo,
                produto.nome,
                produto.genero.nome,
                produto.marca.nome,
                precoFormatado,
                item.dataValidade.toString(),
                ehValido
            ))
        }

        println("...")
        println("TOTAL: ${estoque.qtdItens()} itens.")
    }
}
}