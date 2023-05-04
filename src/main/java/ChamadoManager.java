import java.util.*;

public class ChamadoManager {

	private final List<Chamado> chamados;


	public ChamadoManager() {
		this.chamados = new LinkedList<>();
	}

	public boolean addChamado(Chamado chamado)
	{
		return chamados.add(chamado);
	}

	public List<Chamado> findChamadoByFuncionario(Funcionario funcionario)
	{
		List<Chamado> chamadosByFuncionario = new LinkedList<>();

		for (Chamado chamado : chamados)
		{
			if (chamado.getFuncionario().equals(funcionario))
			{
				chamadosByFuncionario.add(chamado);
			}
		}

		return chamadosByFuncionario;
	}

	public List<Chamado> findChamadosByEquipamento(Equipamento equipamento)
	{
		List<Chamado> chamadosByEquipamento = new LinkedList<>();

		for (Chamado chamado : chamados)
		{
			if (chamado.getEquipamento().equals(equipamento))
			{
				chamadosByEquipamento.add(chamado);
			}
		}

		return chamadosByEquipamento;
	}

	public Chamado findChamadoById(int id)
	{
		for (Chamado chamado : chamados)
		{
			if (chamado.getId() == id)
			{
				return chamado;
			}
		}
		return null;
	}

	public List<Chamado> getChamados()
	{
		return chamados;
	}

	public boolean mudarStatusDeChamado(Chamado chamado)
	{
		for (Chamado existingChamado : chamados)
		{
			if (existingChamado.equals(chamado))
			{
				if (existingChamado.getStatus().equals(Chamado.Status.ABERTO))
				{
					existingChamado.setStatus(Chamado.Status.ANDAMENTO);
					return true;
				}
				else if (existingChamado.getStatus().equals(Chamado.Status.ANDAMENTO))
				{
					existingChamado.setStatus(Chamado.Status.CONCLUIDO);
					return true;
				}
				else
				{
					System.out.println("Chamado já está concluido");
					return false;
				}
			}
		}

		return false;
	}

	public List<Chamado> findChamadosByKeyword(String keyword)
	{
		List<Chamado> chamadosByKeyword = new LinkedList<>();

		for (Chamado chamado : chamados)
		{
			if (chamado.getEquipamento().getDescricao().contains(keyword) ||
					chamado.getFuncionario().getNome().contains(keyword) ||
					chamado.getFuncionario().getDepartamento().contains(keyword) ||
					chamado.getTextoResolucao().contains(keyword) ||
					chamado.getTextoSolitacao().contains(keyword))
			{
				chamadosByKeyword.add(chamado);
			}
		}

		return chamadosByKeyword;
	}

	public double getPorcentagemChamadosByStatus(String status)
	{
		int count = 0;

		if (chamados.isEmpty())
		{
			return 0.0;
		}

		for (Chamado chamado : chamados)
		{
			if (chamado.getStatus().toString().equals(status.toString()))
			{
				count++;
			}
		}


		return ((double) count / chamados.size()) * 100;
	}

	public double getMediaChamadosPorDia()
	{

		if (chamados.isEmpty())
		{
			return 0.0;
		}

		Set<Date> distinctDias = new HashSet<>();

		int countChamados = chamados.size();

		for (Chamado chamado : chamados)
		{
			distinctDias.add(chamado.getDataSolicitacao());
		}


		return ((double) countChamados / distinctDias.size());
	}

}
