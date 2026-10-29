import java.text.Normalizer;
import java.util.function.UnaryOperator;

/** Catálogo de cartas */
public enum Carta {
    ELFO("ELFO", TipoCarta.RACA, Elfo::new),
    ANAO("ANÃO", TipoCarta.RACA, Anao::new),
    HALFLING("HALFLING", TipoCarta.RACA, Halfling::new),
    ORC("ORC", TipoCarta.RACA, Orc::new),
    MESTICO("MESTIÇO", TipoCarta.ESPECIAL, Mestico::new),

    GUERREIRO("GUERREIRO", TipoCarta.CLASSE, Guerreiro::new),
    MAGO("MAGO", TipoCarta.CLASSE, Mago::new),
    CLERIGO("CLÉRIGO", TipoCarta.CLASSE, Clerigo::new),
    LADRAO("LADRÃO", TipoCarta.CLASSE, Ladrao::new),
    SUPER_MUNCHKIN("SUPER MUNCHKIN", TipoCarta.ESPECIAL, SuperMunchkin::new);

    private final String nome;
    private final TipoCarta tipo;
    private final UnaryOperator<Personagem> efeito;

    Carta(String nome, TipoCarta tipo, UnaryOperator<Personagem> efeito) {
        this.nome = nome;
        this.tipo = tipo;
        this.efeito = efeito;
    }

    public TipoCarta getTipo() { return tipo; }

    /** A carta cabe no personagem? Respeita os limites e evita repetição. */
    public boolean podeAplicar(Personagem p) {
        return switch (tipo) {
            case RACA -> p.getRacas().size() < p.getLimiteRacas() && !p.getRacas().contains(nome);
            case CLASSE -> p.getClasses().size() < p.getLimiteClasses() && !p.getClasses().contains(nome);
            case ESPECIAL -> true;
        };
    }

    /** Embrulho do personagem com o seu decorator  */
    public Personagem aplicar(Personagem p) { return efeito.apply(p); }

    /** Aceita diversas formas de escrever o nome da carta: "anão" */
    public static Carta de(String texto) {
        String t = Normalizer.normalize(texto.trim(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "").toUpperCase().replace(' ', '_');
        return valueOf(t);
    }
}
