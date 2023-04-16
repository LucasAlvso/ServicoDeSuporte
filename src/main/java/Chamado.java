import java.util.Collection;
import java.util.Date;

public class Chamado {

	private Funcionario funcionario;

	private Equipamento equipamento;

	private int dataSolicitacao;

	private Date dataAbertura;

	private String status;

	private String textoResolucao;

	private String textoSolicitacao;

	public Chamado(Funcionario funcionario, Equipamento equipamento, int dataSolicitacao, Date dataAbertura, String textoSolicitacao)
	{
		this.funcionario = funcionario;
		this.equipamento = equipamento;
		this.dataSolicitacao = dataSolicitacao;
		this.dataAbertura = dataAbertura;
		this.status = "ABERTO";
		this.textoSolicitacao = textoSolicitacao;
	}

	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario)
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

	public int getDataSolicitacao()
	{
		return dataSolicitacao;
	}

	public void setDataSolicitacao(int dataSolicitacao)
	{
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataAbertura()
	{
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura)
	{
		this.dataAbertura = dataAbertura;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getTextoResolucao()
	{
		return textoResolucao;
	}

	public String getTextoSolitacao()
	{
		return textoSolicitacao;
	}
}
