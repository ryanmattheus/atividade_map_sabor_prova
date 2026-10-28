public class Mestico extends PersonagemDecorator {
    public Mestico(Personagem personagem) { super(personagem); }

    @Override
    public int getLimiteRacas() { return Math.max(2, super.getLimiteRacas()); }
}
