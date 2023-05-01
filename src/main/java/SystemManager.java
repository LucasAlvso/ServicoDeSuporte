import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SystemManager
{

	private FuncionarioManager funcionarioManager;

	private EquipamentoManager equipamentoManager;

	private ChamadoManager chamadoManager;

	private Funcionario funcionarioAtual;

	public void runCliMenu()
	{
		boolean leave = false;

		do
		{
			printOptions();
			Scanner optionScanner = new Scanner(System.in);
			String option = optionScanner.nextLine();

			switch (option)
			{
				case "1":

					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				case "5":
					break;
				case "6":
					break;
				case "7":
					System.out.println("Digite o id do equipamento: ");
					Scanner input = new Scanner(System.in);
					try
					{
						int id = input.nextInt();
						listarChamadosPorEquipamento(id);
					}
					catch (Exception e)
					{
						System.out.println("Número inválido");
					}
					break;

				case "8":
					break;
				case "9":
					break;
				case "10":
					break;
				case "11":
					break;
				case "12":
					break;
				default:
					leave = true;
					break;

			}

		}
		while (!leave);
	}


	public void printOptions()
	{
		System.out.println("---------- MENU ----------");
		System.out.println("1 - Cadastrar funcionário");
		System.out.println("2 - Selecionar usuário atual");
		System.out.println("3 - Cadastrar equipamento");
		System.out.println("4 - Cadastrar chamado");
		System.out.println("5 - Atualizar status de chamado");
		System.out.println("6 - Mudar setor de equipamento");
		System.out.println("7 - Listar chamados por equipamento"); 	//A listagem de chamado por equipamento deve ser por ordem crescente de data de abertura.
		System.out.println("8 - Buscar chamado por palavra-chave");
		System.out.println("9 - Listagem de estatísticas de chamados");
		System.out.println("10 - Listar Funcionários sem chamados ativos");
		System.out.println("11 - Salvar chamados em arquivo csv");
		System.out.println("Qualquer outra opção - Sair");
	}

	public boolean listarFuncionariosSemChamadosAtivos(String idFuncionario)
	{
		return false;
	}

	public boolean salvarChamadosEmArquivoCsv(String nomeArquivoSemExtensao)
	{
		return false;

	}

	public void listarEstatisticasDeChamados()
	{

	}

	public boolean buscarChamadoPorPalavraChave(String palavraChave)
	{
		return false;

	}

	public void listarChamadosPorEquipamento(int idEquipamento)
	{
		Equipamento equipamento = equipamentoManager.findEquipamentoById(idEquipamento);

		if (equipamento == null)
		{
			System.out.println("Equipamento não encontrado.");
			return;
		}

		List<Chamado> chamados = chamadoManager.findChamadosByEquipamento(equipamento);

		if (chamados == null || chamados.isEmpty())
		{
			System.out.println("Nenhum chamado encontrado para esse equipamento");
			return;
		}

		chamados.sort(Comparator.comparing(Chamado::getDataAbertura));

		for (Chamado chamado : chamados)
		{
			System.out.println(chamado);
		}

	}

	public boolean mudarSetorDeEquipamento()
	{
		return false;

	}

	public boolean atualizarStatusDeChamado()
	{
		return false;

	}

	public boolean cadastrarChamado()
	{
		return false;

	}

	public boolean cadastrarEquipamento()
	{
		return false;

	}

	public boolean selecionarUsuarioAtual()
	{
		return false;

	}

	public boolean cadastrarFuncionario()
	{
		return false;

	}
}

