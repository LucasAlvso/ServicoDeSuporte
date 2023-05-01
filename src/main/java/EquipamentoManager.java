import java.util.ArrayList;
import java.util.List;

public class EquipamentoManager {

	private List<Equipamento> equipamentos;

	public Equipamento findEquipamentoById(int id) {
		for (Equipamento equipamento : equipamentos) {
			if (equipamento.getId() == id) {
				return equipamento;
			}
		}
		return null;
	}

	public List<Equipamento> findEquipamentoByDescricao(String descricao) {
		List<Equipamento> equipamentosEncontrados = new ArrayList<>();
		for (Equipamento equipamento : equipamentos) {
			if (equipamento.getDescricao().equals(descricao)) {
				equipamentosEncontrados.add(equipamento);
			}
		}
		return equipamentosEncontrados;
	}

	public boolean mudarSetor(int id, String novoSetor) {
		for (Equipamento equipamento : equipamentos) {
			if (equipamento.getId() == id) {
				equipamento.setSetor(novoSetor);
				return true;
			}
		}
		return false;

	}

}

