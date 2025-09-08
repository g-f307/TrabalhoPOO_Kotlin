package TrabalhoPOO.model

import java.time.LocalDate

class Data(private var dia: Int, private var mes: Int, private var ano: Int) {

    override fun toString(): String {
        return "%02d/%02d/%04d".format(dia, mes, ano)
    }

    fun setData(dia: Int, mes: Int, ano: Int) {
        this.dia = dia
        this.mes = mes
        this.ano = ano
    }

    fun antes(outraData: Data): Boolean {
        if (this.ano < outraData.ano) return true
        if (this.ano == outraData.ano && this.mes < outraData.mes) return true
        if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia < outraData.dia) return true
        return false
    }

    fun depois(outraData: Data): Boolean {
        return !antes(outraData) && !igual(outraData)
    }

    fun igual(outraData: Data): Boolean {
        return this.dia == outraData.dia && this.mes == outraData.mes && this.ano == outraData.ano
    }

    fun getDia(): Int = this.dia
    fun getMes(): Int = this.mes
    fun getAno(): Int = this.ano

    companion object {
        fun dataHoje(): Data {
            val hoje = LocalDate.now()
            return Data(hoje.dayOfMonth, hoje.monthValue, hoje.year)
        }
    }
}