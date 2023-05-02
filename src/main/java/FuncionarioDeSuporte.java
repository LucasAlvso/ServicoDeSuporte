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

    public void adicionarChamado(Chamado chamado)
    {
        historicoChamados.add(chamado);
    }

    @Override
    public String toString()
    {
        return "Funcionario" +
                "id = " + super.getId() +
                ", nome = '" + super.getNome() + '\'' +
                ", departamento = '" + super.getDepartamento() + '\'';
    }

    public String getNome(){
        return super.getNome();
    }

    public String getDepartamento(){
        return super.getDepartamento();
    }

    public int getId(){
        return super.getId();
    }

}
