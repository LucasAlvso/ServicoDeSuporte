import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

					break;
				case "2":
					printFuncionarios();
					System.out.println("Digite o id do funcionário para login: ");
					Scanner input2 = new Scanner(System.in);
					try
					{
						int id = input2.nextInt();
						selecionarUsuarioAtual(id);
					}
					catch (Exception e)
					{
						System.out.println("Entrada inválida");
					}

					break;


				case "3":
					break;
				case "4":
					break;
				case "5":
					System.out.println("Digite o id do chamado: ");
					Scanner input5 = new Scanner(System.in);
					try
					{
						int id = input5.nextInt();
						atualizarStatusDeChamado(id);
					}
					catch (Exception e)
					{
						System.out.println("Entrada inválida");
					}
					break;


				case "6":
					System.out.println("Digite o id do equipamento: ");
					Scanner input6 = new Scanner(System.in);
					try
					{
						int id = input6.nextInt();
						System.out.println("Digite o novo setor");
						String setor = input6.nextLine();

						mudarSetorDeEquipamento(id, setor);
					}
					catch (Exception e)
					{
						System.out.println("Entrada inválida");
					}

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
					System.out.println("Digite a palavra-chave");
					Scanner input8 = new Scanner(System.in);
					String palavraChave = input8.nextLine();

					buscarChamadoPorPalavraChave(palavraChave);
					break;

				case "9":
					listarEstatisticasDeChamados();
					break;
				case "10":
					listarFuncionariosSemChamadosAtivos();
					break;
				case "11":
					Scanner input11 = new Scanner(System.in);
					System.out.println("Digite o nome do arquivo sem extensão");
					String nomeArquivo = input11.nextLine();

					try
					{
						salvarChamadosEmArquivoCsv(nomeArquivo);
					}
					catch (IOException e)
					{
						System.out.println("Erro ao salvar arquivo");
					}
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
		System.out.println("5 - Atualizar status de chamado");//
		System.out.println("6 - Mudar setor de equipamento"); //
		System.out.println("7 - Listar chamados por equipamento"); 	//A listagem de chamado por equipamento deve ser por ordem crescente de data de abertura.
		System.out.println("8 - Buscar chamado por palavra-chave");//
		System.out.println("9 - Listagem de estatísticas de chamados");//
		System.out.println("10 - Listar Funcionários sem chamados ativos");//
		System.out.println("11 - Salvar chamados em arquivo csv");//
		System.out.println("Qualquer outra opção - Sair");//
	}

	public boolean listarFuncionariosSemChamadosAtivos()
	{
		List<Funcionario> funcionarios = new LinkedList<>();

		for (Funcionario funcionario : funcionarioManager.getFuncionarios())
		{
			if (funcionario instanceof FuncionarioDeSuporte)
			{
				for (Chamado chamado: ((FuncionarioDeSuporte) funcionario).getHistoricoChamados())
				{
					if (chamado.equals(Chamado.Status.ABERTO) || chamado.equals(Chamado.Status.ANDAMENTO))
					{
						break;
					}
				}
				funcionarios.add(funcionario);
			}
		}

		if (funcionarios.isEmpty())
		{
			System.out.println("Nenhum funcionário sem chamados abertos");
			return false;
		}

		for (Funcionario funcionario : funcionarios)
		{
			System.out.println(funcionario.getNome());
		}

		return true;
	}

	public boolean salvarChamadosEmArquivoCsv(String nomeArquivoSemExtensao) throws IOException
	{
		List<Chamado> chamados = chamadoManager.getChamados();

		FileWriter fileWriter = new FileWriter(nomeArquivoSemExtensao + ".csv");
		PrintWriter printWriter = new PrintWriter(fileWriter);

		// Write header row
		printWriter.write("id,");
		printWriter.write("Funcionário,");
		printWriter.write("id do Equipamento, ");
		printWriter.write("Data de Solicitação,");
		printWriter.write("Data de Abertura,");
		printWriter.write("Status,");
		printWriter.write("Texto de Resolução");
		printWriter.println();

		for (Chamado chamado : chamados)
		{
			printWriter.write(chamado.getId() + ",");
			printWriter.write(chamado.getFuncionario().getNome() + ",");
			printWriter.write(chamado.getEquipamento().getId() + ",");
			printWriter.write(chamado.getDataSolicitacao() + ",");
			printWriter.write(chamado.getDataAbertura() + ",");
			printWriter.write(chamado.getStatus() + ",");
			printWriter.write(chamado.getTextoResolucao() + ",");
		}
		printWriter.close();

		System.out.println("Arquivo salvo com sucesso");
		return true;
	}

	public void listarEstatisticasDeChamados()
	{
		System.out.println("Total de chamados abertos: " + chamadoManager.getPorcentagemChamadosByStatus(String.valueOf(Chamado.Status.ABERTO)));
		System.out.println("Total de chamados em andamento: " + chamadoManager.getPorcentagemChamadosByStatus(String.valueOf(Chamado.Status.ANDAMENTO)));
		System.out.println("Total de chamados concluídos: " + chamadoManager.getPorcentagemChamadosByStatus(String.valueOf(Chamado.Status.CONCLUIDO)));
		System.out.println("Média de chamados por dia: " + chamadoManager.getMediaChamadosPorDia());
	}

	public boolean buscarChamadoPorPalavraChave(String palavraChave)
	{
		List<Chamado> chamados = chamadoManager.findChamadosByKeyword(palavraChave);

		if (chamados == null || chamados.isEmpty())
		{
			System.out.println("Nenhum chamado encontrado para essa palavra-chave");
			return false;
		}

		for (Chamado chamado : chamados)
		{
			System.out.println(chamado);
		}
		return true;
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

	public boolean mudarSetorDeEquipamento(int idEquipamento, String setor)
	{
		Equipamento equipamento = equipamentoManager.findEquipamentoById(idEquipamento);

		if (equipamento == null)
		{
			System.out.println("Equipamento não encontrado.");
			return false;
		}

		equipamento.setSetor(setor);
		System.out.println("Setor atualizado com sucesso.");
		return true;
	}


	public boolean atualizarStatusDeChamado(int idChamado)
	{
		if (!(funcionarioAtual instanceof FuncionarioDeSuporte))
		{
			System.out.println("Apenas funcionários de suporte podem atualizar o status de um chamado.");
			return false;
		}

		Chamado chamado = chamadoManager.findChamadoById(idChamado);

		if (chamado == null)
		{
			System.out.println("Chamado não encontrado.");
			return false;
		}

		chamadoManager.mudarStatusDeChamado(chamado);
		return true;
	}

	public boolean cadastrarChamado()
	{
		return false;

	}

	public boolean cadastrarEquipamento()
	{
		return false;

	}

	public boolean selecionarUsuarioAtual(int id)
	{
		List<Funcionario> funcionarios = funcionarioManager.getFuncionarios();

		for (Funcionario funcionario : funcionarios)
		{
			if (funcionario.getId() == id)
			{
				funcionarioAtual = funcionario;
				System.out.println("Usuário " + funcionario.getNome() + " selecionado com sucesso.");
				return true;
			}
		}

		System.out.println("Usuário não encontrado.");
		return false;
	}

	public void printFuncionarios()
	{
		for (Funcionario funcionario : funcionarioManager.getFuncionarios())
		{
			System.out.println(funcionario.getNome() + " - " + funcionario.getId());
		}
	}

	public boolean cadastrarFuncionario()
	{
		return false;

	}
}

