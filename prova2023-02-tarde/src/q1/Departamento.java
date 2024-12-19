package q1;

import java.util.HashSet;
import java.util.Set;

public class Departamento extends UnidadeOrganizacional {
    private Set<Setor> setores = new HashSet<>();

    public void adicionarSetor(Setor setor) {
        setores.add(setor);
    }

    public Set<Setor> getSetores() {
        return setores;
    }

    @Override
    public double getSalarioMedio() {
        double totalSalarios = 0;
        int totalFuncionarios = 0;

        for (Setor setor : setores) {
            totalSalarios += setor.getSalarioMedio() * setor.getFuncionarios().size();
            totalFuncionarios += setor.getFuncionarios().size();
        }

        return totalFuncionarios == 0 ? 0 : totalSalarios / totalFuncionarios;
    }

    @Override
    public Set<Funcionario> getFuncionarios() {
        Set<Funcionario> funcionarios = new HashSet<>();
        for (Setor setor : setores) {
            funcionarios.addAll(setor.getFuncionarios());
        }
        return funcionarios;
    }
}

