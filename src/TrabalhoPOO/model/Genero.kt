package TrabalhoPOO.model

abstract class Genero {
    abstract val nome: String

    object Leite: Genero() {
        override val nome: String = "Lácteos"
    }

    object Presunto: Genero() {
        override val nome: String = "Frios"
    }

    object Achocolatado: Genero() {
        override val nome: String = "Achocolatados"
    }
}