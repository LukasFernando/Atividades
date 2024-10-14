package fatec.atividade1;

public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private TrianguloTipos tipo;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.tipo = determinarTipo();
    }

    private TrianguloTipos determinarTipo() {
        if (!validarTriangulo()) {
            return TrianguloTipos.INVALIDO;
        }
        if (ladoA == ladoB && ladoB == ladoC) {
            return TrianguloTipos.EQUILATERO;
        }
        if (ladoA == ladoB || ladoB == ladoC || ladoA == ladoC) {
            return TrianguloTipos.ISOSCELES;
        }
        return TrianguloTipos.ESCALENO;
    }

    private boolean validarTriangulo() {
        return ladoA > 0 && ladoB > 0 && ladoC > 0 &&
                ladoA + ladoB > ladoC &&
                ladoA + ladoC > ladoB &&
                ladoB + ladoC > ladoA;
    }

    public TrianguloTipos pegarTipo() {
        return tipo;
    }
}