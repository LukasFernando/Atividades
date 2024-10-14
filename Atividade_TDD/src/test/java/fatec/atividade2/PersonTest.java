package fatec.atividade2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

class PersonTest {
    @ParameterizedTest
    @CsvSource({
//            Testes válidos
            "1, 'Nome Teste', 30, 'naometeste@example.com', true",
            "2, 'Nome Teste', 25, 'nome.teste@domain.com', true",

//            Testes inválidos
            "3, 'J', 30, 'teste@example.com', false", // Nome inválido
            "4, 'Nome Teste', 201, 'teste@example.com', false", // Idade inválida
            "5, 'Nome Teste', 0, 'teste@example.com', false", // Idade inválida
            "6, 'Nome Teste', 30, '', false", // Email inválido
            "7, 'Nome Teste', 30, 'teste@', false", // Email inválido
            "8, 'Nome Teste', 30, 'teste@example.', false", // Email inválido
            "9, 'Nome Teste', 30, 'teste@example.com', true", // Email inválido
            "10, 'Teste', 30, 'teste@domain.com;teste@domain.com', false" // Email duplicado
    })
    public void testSave(int id, String name, int age, String email, boolean expected) {
        PersonDAO personDAO = new PersonDAO();

        List<Email> emails = new ArrayList<>();
        if (!email.isEmpty()) {
            emails.add(new Email(1, email));
        }

        Person person = new Person(id, name, age, emails);
        assertEquals(expected, personDAO.save(person));
    }
}
