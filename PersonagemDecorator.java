import java.util.List;

public abstract class PersonagemDecorator implements Personagem {
    protected final Personagem personagem;

    protected PersonagemDecorator(Personagem personagem) {
        this.personagem = personagem;
    }

    @Override public List<String> getRacas() { return personagem.getRacas(); }
    @Override public List<String> getClasses() { return personagem.getClasses(); }
    @Override public int getLimiteRacas() { return personagem.getLimiteRacas(); }
    @Override public int getLimiteClasses() { return personagem.getLimiteClasses(); }
}