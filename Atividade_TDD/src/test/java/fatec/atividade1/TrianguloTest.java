package fatec.atividade1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TrianguloTest {
    @ParameterizedTest
    @CsvSource({
//            1. Triângulo escaleno válido
            "4, 5, 6, ESCALENO",
//            2. Triângulo isósceles válido
            "5, 5, 3, ISOSCELES",
//            3. Triângulo equilátero válido
            "4, 4, 4, EQUILATERO",
//            4. Casos de teste isósceles válidos
            "7, 7, 4, ISOSCELES",
            "7, 4, 7, ISOSCELES",
            "4, 7, 7, ISOSCELES",
//            5. Um valor zero (não deve ser equilátero)
            "0, 4, 4, INVALIDO",
//            6. Um valor negativo
            "5, 5, -3, INVALIDO",
//            7. A soma de 2 lados é igual ao terceiro lado
            "5, 5, 10, INVALIDO",
//            8. Permutações do caso acima
            "5, 10, 5, INVALIDO",
            "10, 5, 5, INVALIDO",
//            9. A soma de 2 lados é menor que o terceiro lado
            "3, 4, 8, INVALIDO",
//            10. Permutações do caso acima
            "3, 8, 4, INVALIDO",
            "8, 3, 4, INVALIDO",
//            11. Todos os lados iguais a zero
            "0, 0, 0, INVALIDO"
    })
    public void testTriangulo(int ladoA, int ladoB, int ladoC, String tipoEsperado) {
        Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);
        assertEquals(TrianguloTipos.valueOf(tipoEsperado), triangulo.pegarTipo());
    }
}