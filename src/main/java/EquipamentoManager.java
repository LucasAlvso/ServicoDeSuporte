import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EquipamentoManager {

	private List<Equipamento> equipamentos;

	public EquipamentoManager(){
		this.equipamentos = new LinkedList<>();
	}

	public Equipamento findEquipamentoById(int id) {
		Equipamento[] equipamentoEncontrado = new Equipamento[1];
		equipamentos.forEach((equipamento) -> {
			if (equipamento.getId() == id) {
				equipamentoEncontrado[0] = equipamento;
			}
		});
		return equipamentoEncontrado[0];
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

	public boolean adicionaEquipamento(Equipamento e){
		equipamentos.add(e);
		return true;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}
}

