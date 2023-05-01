import java.util.ArrayList;

public class FuncionarioDeSuporte extends Funcionario{
    private ArrayList<Chamado> historicoChamados;

    public FuncionarioDeSuporte(int id, String nome, String departamento) {
        super(id, nome, departamento);
        historicoChamados = new ArrayList<Chamado>();
    }

    public ArrayList<Chamado> getHistoricoChamados(){
        return historicoChamados;
    }

    public void atualizarStatusChamado(Chamado chamado, Chamado.Status novoStatus){
        chamado.setStatus(novoStatus);
    }

    public void concluirChamado(Chamado chamado, String resolucao){
        chamado.setTextoResolucao(resolucao);
        chamado.setStatus(Chamado.Status.CONCLUIDO);
    }

    public void moverEquipamento(Equipamento equipamento, String novoSetor){
        equipamento.setSetor(novoSetor);
    }

}
