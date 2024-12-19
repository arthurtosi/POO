package q1;

public class Funcionario {
    private double salario;
    private Setor setor;

    public Funcionario(double salario) {
        this.salario = salario;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Setor getSetor() {
        return setor;
    }

    public double getSalario() {
        return salario;
    }
}
