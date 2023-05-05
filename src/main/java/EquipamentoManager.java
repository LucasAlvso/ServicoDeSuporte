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
		List<Equipamento> lista = new ArrayList<>();
		for(Equipamento e:equipamentos){
			if (e.getDescricao().toLowerCase().contains(descricao.toLowerCase())) {
				lista.add(e);
			}
		}
		return lista;
	}

	public boolean mudarSetor(int id, String novoSetor) {
		Equipamento e = this.findEquipamentoById(id);
		if(e != null) {			
			e.setSetor(novoSetor);
			return true;
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

