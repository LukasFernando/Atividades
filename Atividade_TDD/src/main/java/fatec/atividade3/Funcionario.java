package fatec.atividade3;

public class Funcionario {
    private String nome;
    private String email;
    private double salarioBase;
    private String cargo;

    public Funcionario(String nome, String email, double salarioBase, String cargo) {
        this.nome = nome;
        this.email = email;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public String getCargo() {
        return cargo;
    }
}
