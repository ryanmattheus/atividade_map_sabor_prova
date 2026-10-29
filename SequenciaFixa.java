import java.util.List;

public class SequenciaFixa implements FonteDeCartas {
    private final List<Carta> cartas;

    public SequenciaFixa(Carta... cartas) { this.cartas = List.of(cartas); }

    public static SequenciaFixa deTextos(String... textos) {
        return new SequenciaFixa(java.util.Arrays.stream(textos).map(Carta::de).toArray(Carta[]::new));
    }

    @Override public List<Carta> obterCartas() { return cartas; }
}
