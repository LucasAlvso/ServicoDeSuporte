import java.util.*;

public class ChamadoManager {

	private final List<Chamado> chamados;


	public ChamadoManager() {
		this.chamados = new LinkedList<>();
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

	public boolean mudarStatusDeChamado(Chamado chamado)
	{
		for (Chamado existingChamado : chamados)
		{
			if (existingChamado.equals(chamado))
			{
				if (existingChamado.getStatus().equalsIgnoreCase("ABERTO"))
				{
					existingChamado.setStatus("EM ANDAMENTO");
					return true;
				}
				else if (existingChamado.getStatus().equalsIgnoreCase("EM ANDAMENTO"))
				{
					existingChamado.setStatus("CONCLUIDO");
					return true;
				}
				else
				{
					System.out.println("Chamado já está concluído");
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

		for (Chamado chamado : chamados)
		{
			if (chamado.getStatus().equalsIgnoreCase(status))
			{
				count++;
			}
		}

		return ((double) count / chamados.size()) * 100;
	}

	public double getMediaChamadosPorDia(Date data)
	{
		int countChamados = 0;

		Set<Date> distinctDias = new HashSet<>();

		for (Chamado chamado : chamados)
		{
			if (chamado.getDataAbertura().equals(data))
			{
				countChamados++;
			}

			distinctDias.add(chamado.getDataAbertura());
		}

		return ((double) countChamados / distinctDias.size());
	}

}
