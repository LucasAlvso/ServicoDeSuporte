import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

public class Chamado {
	public enum Status{
		ABERTO, ANDAMENTO, CONCLUIDO;
	}

	private int id;

	private Equipamento equipamento;

	private Date dataSolicitacao;

	private Status status;

	private String textoResolucao;

	private String textoSolicitacao;

	private FuncionarioDeSuporte funcionario;

	public Chamado(FuncionarioDeSuporte funcionario, Equipamento equipamento, int id, Date dataSolicitacao, String textoSolicitacao)
	{
		this.funcionario = funcionario;
		this.equipamento = equipamento;
		this.id = id;
		this.dataSolicitacao = dataSolicitacao;
		this.status = Status.ABERTO;
		this.textoSolicitacao = textoSolicitacao;
	}
	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	public void setFuncionario(FuncionarioDeSuporte funcionario)
	{
		this.funcionario = funcionario;
	}

	public Equipamento getEquipamento()
	{
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento)
	{
		this.equipamento = equipamento;
	}

	public Date getDataSolicitacao()
	{
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao)
	{
		this.dataSolicitacao = dataSolicitacao;
	}

	public Status getStatus()
	{
		return this.status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

	public void setTextoResolucao(String textoResolucao){
		this.textoResolucao = textoResolucao;
	}

	public String getTextoSolitacao()
	{
		return textoSolicitacao;
	}

  public String getTextoResolucao()
	{
		return textoResolucao;
	}

	public int getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return "Chamado " +
				"id =" + id +
				", equipamento = " + equipamento.getDescricao() +
				", dataSolicitacao = " + dataSolicitacao.toString() +
				", dataAbertura = " + dataAbertura.toString() +
				", status = " + status.toString() +
				", textoResolucao = '" + textoResolucao + '\'' +
				", textoSolicitacao = '" + textoSolicitacao + '\'' +
				", funcionario = " + funcionario;
	}
}
