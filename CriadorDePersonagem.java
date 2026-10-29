import java.util.ArrayList;
import java.util.List;

public class CriadorDePersonagem {
    public static final int TOTAL_CARTAS = 4;

    public record Resultado(List<Carta> recebidas, List<Carta> aplicadas,
                            List<Carta> descartadas, Personagem personagem) {
        public void exibir() {
            System.out.println("Cartas recebidas: " + lista(recebidas));
            System.out.println("Cartas aplicadas: " + lista(aplicadas));
            System.out.println("Cartas descartadas: " + (descartadas.isEmpty() ? "Nenhuma" : lista(descartadas)));
            System.out.println("Personagem final: " + personagem.getDescricao());
        }
        private static String lista(List<Carta> cartas) {
            return String.join(", ", cartas.stream().map(Carta::name).toList());
        }
    }

    public Resultado criar(List<Carta> cartas) {
        if (cartas.size() != TOTAL_CARTAS)
            throw new IllegalArgumentException("São necessárias exatamente " + TOTAL_CARTAS + " cartas.");

        Personagem personagem = new HumanoSemClasse();
        List<Carta> aplicadas = new ArrayList<>();
        List<Carta> descartadas = new ArrayList<>();

        // 1ª passada: cartas especiais mudam os limites, não importa em que posição vieram.
        for (Carta c : cartas)
            if (c.getTipo() == TipoCarta.ESPECIAL) personagem = c.aplicar(personagem);

        // 2ª passada: raças e classes, na ordem recebida; o que não couber é descartado.
        for (Carta c : cartas) {
            if (c.getTipo() == TipoCarta.ESPECIAL) continue;
            if (c.podeAplicar(personagem)) {
                personagem = c.aplicar(personagem);
                aplicadas.add(c);
            } else {
                descartadas.add(c);
            }
        }
        return new Resultado(cartas, aplicadas, descartadas, personagem);
    }
}
