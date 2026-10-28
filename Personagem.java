import java.util.ArrayList;
import java.util.List;

public interface Personagem {
    List<String> getRacas();
    List<String> getClasses();
    int getLimiteRacas();
    int getLimiteClasses();

    default String getDescricao() {
        if (getRacas().isEmpty() && getClasses().isEmpty()) return "HUMANO SEM CLASSE";
        
        List<String> partes = new ArrayList<>();
        if (getRacas().isEmpty()) partes.add("HUMANO");
        partes.addAll(getRacas());
        partes.addAll(getClasses());
        return String.join(", ", partes);
    }
}
