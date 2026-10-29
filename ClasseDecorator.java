import java.util.ArrayList;
import java.util.List;

/** Decorator que acrescenta uma classe ao personagem. */
public abstract class ClasseDecorator extends PersonagemDecorator {
    private final String nome;

    protected ClasseDecorator(Personagem personagem, String nome) {
        super(personagem);
        this.nome = nome;
    }

    @Override
    public List<String> getClasses() {
        List<String> classes = new ArrayList<>(super.getClasses());
        classes.add(nome);
        return classes;
    }
}
