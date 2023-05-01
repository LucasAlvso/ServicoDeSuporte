import java.util.ArrayList;
import java.util.List;

public class FuncionarioManager {

	private List<Funcionario> funcionarios;

	public Funcionario findFuncionarioById(int id) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId() == id) {
				return funcionario;
			}
		}
		return null;
	}

	public List<Funcionario> findFuncionariosBySetor(String setor) {
		List<Funcionario> funcionarioPorSetor = new ArrayList<>();
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getDepartamento() == setor) {
				funcionarioPorSetor.add(funcionario);
			}
		}
		return funcionarioPorSetor;
	}
}
