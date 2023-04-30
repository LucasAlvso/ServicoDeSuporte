import java.util.*;

public class FuncionarioManager {
	private final List<Funcionario> funcionarios;

  public FuncionarioManager() {
      funcionarios = new LinkedList<>();
  }

  public boolean addFuncionario(Funcionario employee) {
    Funcionario idAlreadyInUse = findFuncionarioById(employee.getId());

    if (idAlreadyInUse != null) {
      return false;
    }

    return funcionarios.add(employee);
  }

  public List<Funcionario> getFuncionarios() {
    return funcionarios;
  }

	public Funcionario findFuncionarioById(int id) {
    for (Funcionario funcionario : funcionarios)
		{
			if (funcionario.getId() == id)
			{
				return funcionario;
			}
		}

    return null;
	}

}