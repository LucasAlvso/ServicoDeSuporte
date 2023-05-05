import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EquipamentoManager {

	private List<Equipamento> equipamentos;

	public EquipamentoManager(){
		this.equipamentos = new LinkedList<>();
	}

	public Equipamento findEquipamentoById(int id) {
		for(Equipamento e:equipamentos){
			if (e.getId()==id) return e;
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

	public boolean adicionaEquipamento(Equipamento e){
		equipamentos.add(e);
		return true;
	}

}

