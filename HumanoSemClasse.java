import java.util.List;

/** Componente concreto geral de todos os personagens */
public class HumanoSemClasse implements Personagem {
    @Override public List<String> getRacas() { return List.of(); }
    @Override public List<String> getClasses() { return List.of(); }
    @Override public int getLimiteRacas() { return 1; }
    @Override public int getLimiteClasses() { return 1; }
}
