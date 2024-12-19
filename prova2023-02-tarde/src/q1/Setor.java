package q1;

import java.util.HashSet;
import java.util.Set;

public class Setor extends UnidadeOrganizacional {
    private Set<Funcionario> funcionarios = new HashSet<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        funcionario.setSetor(this);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    @Override
    public double getSalarioMedio() {
        double totalSalarios = 0;

        for (Funcionario funcionario : funcionarios) {
            totalSalarios += funcionario.getSalario();
        }

        return funcionarios.isEmpty() ? 0 : totalSalarios / funcionarios.size();
    }

    @Override
    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}