package fatec.atividade3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraSalarioTest {
    @ParameterizedTest
    @CsvSource({
            // Testes válidos
            "1, 'Desenvolvedor', 3000, 2400.0", // 20% de desconto
            "2, 'Desenvolvedor', 2500, 2250.0", // 10% de desconto
            "3, 'DBA', 2000, 1500.0",           // 25% de desconto
            "4, 'DBA', 1500, 1275.0",           // 15% de desconto
            "5, 'Testador', 2000, 1500.0",      // 25% de desconto
            "6, 'Testador', 1500, 1275.0",      // 15% de desconto
            "7, 'Gerente', 5000, 3500.0",       // 30% de desconto
            "8, 'Gerente', 4000, 3200.0",       // 20% de desconto
            "9, '', 1000, 1000.0",              // Sem desconto
            "10, 'Cargo Desconhecido', 3000, 3000.0" // Sem desconto
    })
    public void testCalcularSalarioLiquido(int id, String cargo, double salarioBase, double salarioLiquidoEsperado) {
        Funcionario funcionario = new Funcionario("Funcionario " + id, "funcionario" + id + "@example.com", salarioBase, cargo);
        CalculadoraSalario calculadora = new CalculadoraSalario();

        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);
        assertEquals(salarioLiquidoEsperado, salarioLiquido, 0.01);
    }
}
