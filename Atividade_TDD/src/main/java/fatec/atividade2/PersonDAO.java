package fatec.atividade2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonDAO {
    public boolean save(Person person) {
        return isValidToInclude(person).isEmpty();
    }

    public List<String> isValidToInclude(Person person) {
        List<String> errors = new ArrayList<>();

        if (!isValidName(person.getName())) {
            errors.add("O nome deve ser composto por pelo menos 2 partes e apenas letras.");
        }

        if (person.getAge() < 1 || person.getAge() > 200) {
            errors.add("A idade deve estar no intervalo [1, 200].");
        }

        List<Email> emails = person.getEmails();
        if (emails.isEmpty()) {
            errors.add("O objeto Person deve ter pelo menos um objeto da classe Email associado.");
        } else {
            for (Email email : emails) {
                if (!isValidEmail(email.getName())) {
                    errors.add("O email '" + email.getName() + "' não está no formato correto '_____@____.___'.");
                }
            }
        }

        return errors;
    }

    private boolean isValidName(String name) {
        String[] parts = name.trim().split("\\s+");
        if (parts.length < 2) return false;
        for (String part : parts) {
            if (!part.matches("[A-Za-z]+")) return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }
}
