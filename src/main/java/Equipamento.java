import java.util.Date;

public class Equipamento {

	private int id;

	private String descricao;

	private Date dataAquisicao;

	private String setor;

	public Equipamento(int id, String descricao, Date dataAquisicao, String setor)
	{
		this.id = id;
		this.descricao = descricao;
		this.dataAquisicao = dataAquisicao;
		this.setor = setor;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public Date getDataAquisicao()
	{
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao)
	{
		this.dataAquisicao = dataAquisicao;
	}

	public String getSetor()
	{
		return setor;
	}

	public void setSetor(String setor)
	{
		this.setor = setor;
	}
}
