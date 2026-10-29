public class Main {
    public static void main(String[] args) {
        CriadorDePersonagem criador = new CriadorDePersonagem();

        if (args.length > 0) { // entrada do usuário: java Main ELFO MAGO ANAO MESTICO
            criador.criar(SequenciaFixa.deTextos(args).obterCartas()).exibir();
            return;
        }

        System.out.println("=== Exemplo 1 ===");
        criador.criar(new SequenciaFixa(Carta.ELFO, Carta.GUERREIRO, Carta.MAGO, Carta.SUPER_MUNCHKIN).obterCartas()).exibir();
        System.out.println("\n=== Exemplo 2 ===");
        criador.criar(new SequenciaFixa(Carta.ELFO, Carta.ANAO, Carta.HALFLING, Carta.MESTICO).obterCartas()).exibir();
        System.out.println("\n=== Exemplo 3 ===");
        criador.criar(new SequenciaFixa(Carta.ELFO, Carta.ANAO, Carta.GUERREIRO, Carta.MAGO).obterCartas()).exibir();
        System.out.println("\n=== Sorteio aleatório ===");
        criador.criar(new SorteioAleatorio().obterCartas()).exibir();
    }
}
