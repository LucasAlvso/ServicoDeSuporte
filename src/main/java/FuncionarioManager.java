import java.util.*;

public class FuncionarioManager {
	private final List<Funcionario> funcionarios;

  public FuncionarioManager() {
      funcionarios = new LinkedList<>();
  }

  public boolean addFuncionario(Funcionario employee) {
      if (employee == null || funcionarios.contains(employee)) {
          return false;
      }
      return funcionarios.add(employee);
  }


  public List<Funcionario> getFuncionarios() {
    return funcionarios;
  }

	public Funcionario findFuncionarioById(int id) {
        Funcionario[] funcionarioEncontrado = new Funcionario[1];
        funcionarios.forEach((funcionario) -> {
            if (funcionario.getId() == id) {
                funcionarioEncontrado[0] = funcionario;
            }
        });
        return funcionarioEncontrado[0];
	}

}