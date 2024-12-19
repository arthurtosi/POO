package q1;

import java.util.HashSet;
import java.util.Set;

public class Empresa {
    private Set<Departamento> departamentos = new HashSet<>();

    public void adicionarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public Set<Departamento> getDepartamentos() {
        return departamentos;
    }
}