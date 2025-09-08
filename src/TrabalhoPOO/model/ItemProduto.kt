package TrabalhoPOO.model

import TrabalhoPOO.model.Produto

data class ItemProduto(val codBarras: String, val dataValidade: Data, val produto: Produto)
{
    fun valido(): Boolean {
        return dataValidade.depois(Data.dataHoje()) // É válido se a data de validade vier depois da data de hoje
    }
}