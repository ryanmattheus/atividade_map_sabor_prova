/** Carta especial: eleva o limite para 2 classes (idempotente). */
public class SuperMunchkin extends PersonagemDecorator {
    public SuperMunchkin(Personagem personagem) { super(personagem); }

    @Override
    public int getLimiteClasses() { return Math.max(2, super.getLimiteClasses()); }
}
