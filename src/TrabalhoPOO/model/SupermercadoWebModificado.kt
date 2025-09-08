package TrabalhoPOO.model

class SupermercadoWebModificado {
    val estoque: Estoque
    val carrinhoA: Carrinho // Carrinho A
    val carrinhoB: Carrinho // Carrinho B
    lateinit var generos: List<Genero>
    lateinit var marcas: List<Marca>
    lateinit var produtos: List<Produto>

    init {
        // Instancia os componentes principais, incluindo os dois carrinhos
        estoque = Estoque()
        carrinhoA = Carrinho()
        carrinhoB = Carrinho()
        iniciaSupermercado()
    }

    private fun iniciaSupermercado() {
        val marcaNinho = Marca("Ninho")
        val marcaItambe = Marca("Itambé")
        val marcaNestle = Marca("Nestlé")
        val marcaSadia = Marca("Sadia")
        val marcaSeara = Marca("Seara")
        val marcaDelicia = Marca("Delícia")
        val marcaOvomaltine = Marca("Duleite")
        val marcaNescau = Marca("Parmalat")
        val marcaToddy = Marca("Toddy")

        this.marcas = listOf(
            marcaNinho,
            marcaItambe,
            marcaNestle,
            marcaSadia,
            marcaSeara,
            marcaDelicia,
            marcaOvomaltine,
            marcaNescau,
            marcaToddy
        )

        this.generos = listOf(Genero.Leite, Genero.Achocolatado, Genero.Presunto)

        val produtoLeiteNinho = Produto(101, "Leite em Pó Ninho", 15.50, marcaNinho, Genero.Leite)
        val produtoLeiteItambe = Produto(102, "Leite UHT Itambe", 4.80, marcaItambe, Genero.Leite)
        val produtoNescau = Produto(201, "Achocolatado Nescau", 8.99, marcaNestle, Genero.Achocolatado)
        val produtoToddy = Produto(202, "Achocolatado Toddy", 7.50, marcaToddy, Genero.Achocolatado)
        val produtoPresuntoSadia = Produto(301, "Presunto Cozido Sadia", 12.0, marcaSadia, Genero.Presunto)
        val produtoPresuntoSeara = Produto(302, "Presunto de Peru Seara", 14.25, marcaSeara, Genero.Presunto)

        this.produtos = listOf(
            produtoLeiteNinho,
            produtoLeiteItambe,
            produtoNescau,
            produtoToddy,
            produtoPresuntoSadia,
            produtoPresuntoSeara
        )

        val hoje = Data.dataHoje()
        for (i in 1..10) {
            estoque.entraItem(
                ItemProduto(
                    "LNI$i",
                    Data(hoje.getDia(), hoje.getMes() + 2, hoje.getAno()),
                    produtoLeiteNinho
                )
            )
            estoque.entraItem(
                ItemProduto(
                    "LIT$i",
                    Data(hoje.getDia(), hoje.getMes() + 3, hoje.getAno()),
                    produtoLeiteItambe
                )
            )
            estoque.entraItem(
                ItemProduto(
                    "NES$i",
                    Data(hoje.getDia(), hoje.getMes() + 6, hoje.getAno()),
                    produtoNescau
                )
            )
            estoque.entraItem(ItemProduto("TOD$i", Data(1, 1, hoje.getAno() + 1), produtoToddy))
            estoque.entraItem(ItemProduto("PSA$i", Data(15, 8, 2026), produtoPresuntoSadia))
            estoque.entraItem(ItemProduto("PSE$i", Data(1, 12, 2026), produtoPresuntoSeara))
        }
    }
}