package dojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JogoTest {

    @ParameterizedTest(name="Quando o assassino foi {0} usando a magia {2} em {1} e a teoria foi que o assassino é {3} com a magia {5} na {4} então é esperado que a Murta-que-geme diga {6}")
    @CsvSource({
            "Draco Malfoy, Hogwarts, Cruciatus, Rabicho, Plataforma 9 3/4, Imperius, 1"
    })
    @DisplayName("Testes do jogo")
    void testes_do_jogo(
            String assassino, String local, String magia,
            String assassinoTeoria, String localTeoria, String magiaTeoria,
            int resultadoEsperado)
    {
        Jogo jogo = new Jogo(assassino, local, magia);

        int resultado = jogo.jogar(assassinoTeoria, localTeoria, magiaTeoria);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void magia_errada() {

        Jogo jogo = new Jogo("Draco Malfoy", "Hogwarts", "Cruciatus");

        int resultado = jogo.jogar("Draco Malfoy", "Hogwarts", "Imperius");

        assertEquals(3, resultado);

    }
    @Test
    public void local_errada() {

        Jogo jogo = new Jogo("Draco Malfoy", "Hogwarts", "Cruciatus");

        int resultado = jogo.jogar("Draco Malfoy", "Plataforma 9 3/4", "Cruciatus");

        assertEquals(2, resultado);

    }
    @Test
    public void assassino_errada() {

        Jogo jogo = new Jogo("Draco Malfoy", "Hogwarts", "Cruciatus");

        int resultado = jogo.jogar("Voldemort", "Hogwarts", "Cruciatus");

        assertEquals(1, resultado);

    }
    @Test
    public void tudo_certo() {

        Jogo jogo = new Jogo("Draco Malfoy", "Hogwarts", "Cruciatus");

        int resultado = jogo.jogar("Draco Malfoy", "Hogwarts", "Cruciatus");

        assertEquals(0, resultado);

    }
}
