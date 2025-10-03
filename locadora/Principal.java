package locadora;

public class Principal {
    public static void main(String[] args) {
        System.out.println(" INICIANDO SISTEMA DE LOCADORA\n");
        
        // criar catálogo (pelo menos 10 filmes)
        Filme[] catalogo = new Filme[] {
            new Filme("Invocaçao do mal", 7.0),
            new Filme("Heroes", 5.0),
            new Filme("X-Men: First Class", 5.0),
            new Filme("Matrix", 6.0),
            new Filme("Velozes e Furiosos", 6.0),
            new Filme("Shrek", 4.0),
            new Filme("Toy Story", 4.0),
            new Filme("Vingadores", 8.0),
            new Filme("Interstellar", 8.0),
            new Filme("Gladiador", 6.0)
        };

        // exibir catálogo
        System.out.println("CATÁLOGO DE FILMES DISPONÍVEIS:");
        System.out.println("─".repeat(40));
        for (int i = 0; i < catalogo.length; i++) {
            System.out.printf("%2d. %-25s R$ %.2f\n", 
                i + 1, catalogo[i].getTitulo(), catalogo[i].getValorLocacao());
        }
        System.out.println();

        // criar clientes e contas
        Cliente c1 = new Cliente("Danilo Farias");
        Conta conta1 = new Conta(1, c1);

        Cliente c2 = new Cliente("Joao Silva");
        Conta conta2 = new Conta(2, c2);

        Cliente c3 = new Cliente("Maria Santos");
        Conta conta3 = new Conta(3, c3);

        System.out.println(" REALIZANDO LOCAÇÕES...\n");

        // locações (cada chamada equivale a 1 locação com 1..5 filmes)
        conta1.locarFilmes(new Filme[] { catalogo[0], catalogo[1] });
        conta1.locarFilmes(new Filme[] { catalogo[2] });
        conta1.locarFilmes(new Filme[] { catalogo[3], catalogo[4], catalogo[5] });
        conta1.locarFilmes(new Filme[] { catalogo[6] });

        conta2.locarFilmes(new Filme[] { catalogo[1], catalogo[7] });
        conta2.locarFilmes(new Filme[] { catalogo[2], catalogo[3] });
        conta2.locarFilmes(new Filme[] { catalogo[8] });

        conta3.locarFilmes(new Filme[] { catalogo[9] });
        conta3.locarFilmes(new Filme[] { catalogo[5], catalogo[6] });
        conta3.locarFilmes(new Filme[] { catalogo[0], catalogo[4], catalogo[7] });

        // imprimir extratos
        System.out.println(conta1.extratoHistorico());
        System.out.println(conta2.extratoHistorico());
        System.out.println(conta3.extratoHistorico());

        // simular pagamento
        System.out.println(" SIMULANDO PAGAMENTO...");
        conta1.pagarDebito(5.0);
        System.out.println("Após pagamento de R$ 5,00 por " + c1.getNome() + ":");
        System.out.println("Novo saldo: R$ " + String.format("%.2f", conta1.getSaldoDevedor()));
        
        System.out.println("\n✅ SISTEMA FINALIZADO COM SUCESSO!");
    }
}