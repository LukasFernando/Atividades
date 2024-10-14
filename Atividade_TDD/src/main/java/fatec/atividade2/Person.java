package fatec.atividade2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id;
    private String name;
    private int age;
    private List<Email> emails; // Agora armazena objetos Email

    public Person(int id, String name, int age, List<Email> emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emails = emails != null ? new ArrayList<>(emails) : new ArrayList<>(); // Inicializa a lista
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Email> getEmails() {
        return new ArrayList<>(emails); // Retorna uma cópia da lista de emails
    }
}
