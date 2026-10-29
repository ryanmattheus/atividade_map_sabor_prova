import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SorteioAleatorio implements FonteDeCartas {
    private final Random random = new Random();

    @Override
    public List<Carta> obterCartas() {
        Carta[] todas = Carta.values();
        List<Carta> sorteadas = new ArrayList<>();
        for (int i = 0; i < CriadorDePersonagem.TOTAL_CARTAS; i++)
            sorteadas.add(todas[random.nextInt(todas.length)]);
        return sorteadas;
    }
}
