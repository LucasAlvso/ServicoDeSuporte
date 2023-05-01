import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SystemManager
{

	private final FuncionarioManager funcionarioManager;

	private final EquipamentoManager equipamentoManager;

	private final ChamadoManager chamadoManager;
	private  Funcionario funcionarioAtual;

	public SystemManager()
	{
		this.funcionarioManager = new FuncionarioManager();
		this.equipamentoManager = new EquipamentoManager();
		this.chamadoManager = new ChamadoManager();
	}

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
					System.out.println("Digite 1 para criar um usuario normal e 2 para criar um usuario de suporte: ");
					try{
						int opcao = optionScanner.nextInt();
						System.out.println("ID: ");
						int idNovoFuncionario = optionScanner.nextInt();
						System.out.println("Nome: ");
						String nomeNovoFuncionario = optionScanner.next();
						System.out.println("Departamento: ");
						String departamentoNovoFuncionario = optionScanner.next();
						cadastrarFuncionario(idNovoFuncionario, nomeNovoFuncionario, departamentoNovoFuncionario, opcao);
					}
					catch(Exception e){
						System.out.println("Valores de entrada invalidos.");
					}
					System.out.println("Funcionario criado com sucesso.");
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

	public boolean cadastrarFuncionario(int id, String nome, String Departamento, int tipo)
	{		
		if (tipo == 1){
			Funcionario novoFuncionario = new Funcionario(id, nome, Departamento);
			funcionarioManager.addFuncionario(novoFuncionario);
		}
		if (tipo == 2){
			FuncionarioDeSuporte novoFuncionarioDeSuporte = new FuncionarioDeSuporte(id, nome, Departamento);
			funcionarioManager.addFuncionario(novoFuncionarioDeSuporte);
		}	
		else {
			return false;
		}	
		return true;
	}
}

