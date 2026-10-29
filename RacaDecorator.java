import java.util.ArrayList;
import java.util.List;

/** Decorator que acrescenta uma raça ao personagem. */
public abstract class RacaDecorator extends PersonagemDecorator {
    private final String nome;

    protected RacaDecorator(Personagem personagem, String nome) {
        super(personagem);
        this.nome = nome;
    }

    @Override
    public List<String> getRacas() {
        List<String> racas = new ArrayList<>(super.getRacas());
        racas.add(nome);
        return racas;
    }
}
