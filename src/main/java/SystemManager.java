import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class SystemManager
{

	private final FuncionarioManager funcionarioManager;
	private final EquipamentoManager equipamentoManager;
	private final ChamadoManager chamadoManager;
	private Funcionario funcionarioAtual;

	public SystemManager()
	{
		this.funcionarioManager = new FuncionarioManager();
		this.equipamentoManager = new EquipamentoManager();
		this.chamadoManager = new ChamadoManager();
	}

	public void inserirDadosIniciais()
	{
		Equipamento equipamento1 = new Equipamento(1, "Notebook Dell", new Date(1234567890000L), "Departamento de TI");
		Equipamento equipamento2 = new Equipamento(2, "Impressora HP", new Date(1234567890000L), "Departamento de Marketing");
		Equipamento equipamento3 = new Equipamento(3, "Mesa de escritório", new Date(1234567890000L), "Departamento Administrativo");
		Equipamento equipamento4 = new Equipamento(4, "Projetor Epson", new Date(1234567890000L), "Departamento de Treinamento");
		Equipamento equipamento5 = new Equipamento(5, "Cadeira ergonômica", new Date(1234567890000L), "Departamento de RH");

		FuncionarioDeSuporte suporte1 = new FuncionarioDeSuporte(11, "João Silva", "Departamento de TI");
		FuncionarioDeSuporte suporte2 = new FuncionarioDeSuporte(12, "Maria Santos", "Departamento de TI");
		FuncionarioDeSuporte suporte3 = new FuncionarioDeSuporte(13, "Ana Paula", "Departamento de Suporte");
		FuncionarioDeSuporte suporte4 = new FuncionarioDeSuporte(14, "Felipe Mendes", "Departamento de Suporte");

		Chamado chamado1 = new Chamado(suporte1, equipamento1, 1, new Date(1651361400000L), "Problema com o sistema operacional");
		Chamado chamado2 = new Chamado(suporte2, equipamento2, 2, new Date(1651202400000L), "Impressora não está imprimindo");
		Chamado chamado3 = new Chamado(suporte3, equipamento3, 3, new Date(1651278000000L), "Mesa com defeito na gaveta");
		Chamado chamado4 = new Chamado(suporte4, equipamento4, 4, new Date(1651036800000L), "Projetor com imagem distorcida");
		Chamado chamado5 = new Chamado(suporte1, equipamento5, 5, new Date(1650950400000L), "Cadeira com problema no ajuste de altura");

		Funcionario funcionario1 = new Funcionario(1, "José da Silva", "Departamento de TI");
		Funcionario funcionario2 = new Funcionario(2, "Maria Oliveira", "Departamento de Marketing");
		Funcionario funcionario3 = new Funcionario(3, "Ana Santos", "Departamento Administrativo");
		Funcionario funcionario4 = new Funcionario(4, "Felipe Rodrigues", "Departamento de Treinamento");
		Funcionario funcionario5 = new Funcionario(5, "João Paulo", "Departamento de RH");
		Funcionario funcionario6 = new Funcionario(6, "Pedro Silva", "Departamento de TI");
		Funcionario funcionario7 = new Funcionario(7, "Carla Oliveira", "Departamento de Marketing");
		Funcionario funcionario8 = new Funcionario(8, "Paula Santos", "Departamento Administrativo");
		Funcionario funcionario9 = new Funcionario(9, "Fernanda Rodrigues", "Departamento de Treinamento");
		Funcionario funcionario10 = new Funcionario(10, "Ana Paula", "Departamento de RH");


		funcionarioManager.addFuncionario(funcionario1);
		funcionarioManager.addFuncionario(funcionario2);
		funcionarioManager.addFuncionario(funcionario3);
		funcionarioManager.addFuncionario(funcionario4);
		funcionarioManager.addFuncionario(funcionario5);
		funcionarioManager.addFuncionario(funcionario6);
		funcionarioManager.addFuncionario(funcionario7);
		funcionarioManager.addFuncionario(funcionario8);
		funcionarioManager.addFuncionario(funcionario9);
		funcionarioManager.addFuncionario(funcionario10);

		funcionarioManager.addFuncionario(suporte1);
		funcionarioManager.addFuncionario(suporte2);
		funcionarioManager.addFuncionario(suporte3);
		funcionarioManager.addFuncionario(suporte4);

		equipamentoManager.adicionaEquipamento(equipamento1);
		equipamentoManager.adicionaEquipamento(equipamento2);
		equipamentoManager.adicionaEquipamento(equipamento3);
		equipamentoManager.adicionaEquipamento(equipamento4);
		equipamentoManager.adicionaEquipamento(equipamento5);

		chamadoManager.addChamado(chamado1);
		chamadoManager.addChamado(chamado2);
		chamadoManager.addChamado(chamado3);
		chamadoManager.addChamado(chamado4);
		chamadoManager.addChamado(chamado5);
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
					System.out.println("Digite [1] para adicionar um usuario normal ou [2] para criar um usuario de suporte: ");
					try
					{
						int opcao = optionScanner.nextInt();
						System.out.println("ID: ");
						int idNovoFuncionario = optionScanner.nextInt();
						System.out.println("Nome: ");
						String nomeNovoFuncionario = optionScanner.next();
						System.out.println("Departamento: ");
						String departamentoNovoFuncionario = optionScanner.next();
						cadastrarFuncionario(idNovoFuncionario, nomeNovoFuncionario, departamentoNovoFuncionario, opcao);
					} catch (Exception e)
					{
						System.out.println("Valores de entrada invalidos.");
					}

					break;

				case "2":
					printFuncionarios();
					System.out.println("Digite o id do funcionário para login: ");
					Scanner input2 = new Scanner(System.in);
					try
					{
						int id = input2.nextInt();
						selecionarUsuarioAtual(id);
					} catch (Exception e)
					{
						System.out.println("Entrada inválida");
					}

					break;


				case "3":
					System.out.println("Digite o id do equipamento");
					int idEquip = optionScanner.nextInt();
					System.out.println("Digite a descricao do Produto");
					String descricao = optionScanner.next();
					System.out.println("Entre uma data (formato: MM/dd/yyyy): ");
					String dateStr = optionScanner.next();
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date data;
					try
					{
						data = dateFormat.parse(dateStr);
						System.out.println("Digite o setor:");
						String EquipSetor = optionScanner.nextLine();
						cadastrarEquipamento(idEquip, descricao, data, EquipSetor);
					} catch (ParseException e)
					{
						System.out.println("Formato de data inválido.");
					}
					System.out.println("Novo equipamento cadastrado");
					break;


				case "4":
					System.out.println("Digite o id do equipamento que precisa de suporte");
					int idEquipSup = optionScanner.nextInt();
					System.out.println("Entre uma data (formato: MM/dd/yyyy): ");
					String dateStrSup = optionScanner.next();
					SimpleDateFormat dateFormatSup = new SimpleDateFormat("MM/dd/yyyy");
					Date dataSup = null;
					try
					{
						dataSup = dateFormatSup.parse(dateStrSup);
					} catch (ParseException e)
					{
						System.out.println("Invalid date format.");
					}
					System.out.println("Digite o texto da Solicitacao");
					String text = optionScanner.next();
					System.out.println("Digite o id do Funcionario de Suporte");
					int idFs = optionScanner.nextInt();
					cadastrarChamado(idFs, idEquipSup, dataSup, text);
					break;


				case "5":
					System.out.println("Digite o id do chamado: ");
					Scanner input5 = new Scanner(System.in);
					try
					{
						int id = input5.nextInt();
						atualizarStatusDeChamado(id);
					} catch (Exception e)
					{
						System.out.println("Entrada inválida");
					}
					break;


				case "6":
					System.out.println("Digite o id do equipamento: ");
					Scanner input6 = new Scanner(System.in);
					Scanner input6String = new Scanner(System.in);
					try
					{
						int id = input6.nextInt();
						System.out.println("Digite o novo setor");
						String setor = input6String.nextLine();

						mudarSetorDeEquipamento(id, setor);
					} catch (Exception e)
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
					} catch (Exception e)
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
					} catch (IOException e)
					{
						System.out.println("Erro ao salvar arquivo");
					}
					break;

				case "12":
					Scanner input12 = new Scanner(System.in);
					System.out.println("Digite a descrição do equipamento");
					String descricaoEquipamento = input12.nextLine();
					buscarEquipamentosPorDescricao(descricaoEquipamento);
					break;

				case "13":
					printEquipamentos();
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
		System.out.println();
		System.out.println("---------- <<<< MENU >>>> ----------");
		System.out.println("[1] - Cadastrar funcionário");//
		System.out.println("[2] - Selecionar usuário atual");//
		System.out.println("[3] - Cadastrar equipamento");//
		System.out.println("[4] - Cadastrar chamado");
		System.out.println("[5] - Atualizar status de chamado");//
		System.out.println("[6] - Mudar setor de equipamento"); //
		System.out.println("[7] - Listar chamados por equipamento");    //A listagem de chamado por equipamento deve ser por ordem crescente de data de abertura.
		System.out.println("[8] - Buscar chamado por palavra-chave");//
		System.out.println("[9] - Listagem de estatísticas de chamados");//
		System.out.println("[10] - Listar Funcionários de suporte sem chamados ativos");//
		System.out.println("[11] - Salvar chamados em arquivo csv");//
		System.out.println("[12] - Buscar equipamento por descrição");//
		System.out.println("[13] - Lista de equipamentos");
		System.out.println("------------------------------------");
		System.out.println("[SAIR] Digite qualquer outra opcao");
		System.out.println();//

	}

	public boolean listarFuncionariosSemChamadosAtivos()
	{
		List<Funcionario> funcionarios = new LinkedList<>();

		for (Funcionario funcionario : funcionarioManager.getFuncionarios())
		{
			if (funcionario instanceof FuncionarioDeSuporte)
			{
				if (((FuncionarioDeSuporte) funcionario).getHistoricoChamados().isEmpty())
				{
					funcionarios.add(funcionario);
					continue;
				}

				for (Chamado chamado : ((FuncionarioDeSuporte) funcionario).getHistoricoChamados())
				{

					if (chamado.getStatus().equals(Chamado.Status.ABERTO) || chamado.getStatus().equals(Chamado.Status.ANDAMENTO))
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
		printWriter.write("Status,");
		printWriter.write("Texto de Resolução");
		printWriter.println();

		for (Chamado chamado : chamados)
		{
			printWriter.write(chamado.getId() + ",");
			printWriter.write(chamado.getFuncionario().getNome() + ",");
			printWriter.write(chamado.getEquipamento().getId() + ",");
			printWriter.write(chamado.getDataSolicitacao() + ",");
			printWriter.write(chamado.getStatus() + ",");
			printWriter.write(chamado.getTextoResolucao() + "\n");
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
			System.out.println(chamado.toString());
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

		chamados.sort(Comparator.comparing(Chamado::getDataSolicitacao));

		for (Chamado chamado : chamados)
		{
			System.out.println(chamado.toString());
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

	public boolean cadastrarEquipamento(int id, String descricao, Date dataAquisicao, String setor)
	{
		Equipamento e = new Equipamento(id, descricao, dataAquisicao, setor);
		if (equipamentoManager.findEquipamentoById(id) != null)
		{
			System.out.println("ID já cadastrado.");
			return false;
		}
		equipamentoManager.adicionaEquipamento(e);
		System.out.println("Equipamento adicionado com sucesso.");
		return true;
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
		System.out.println("[LISTA DE FUNCIONARIOS]");
		System.out.println();
		for (Funcionario funcionario : funcionarioManager.getFuncionarios())
		{
			System.out.println("Nome:" + funcionario.getNome()  + "\nID:" + funcionario.getId() + "\n" + funcionario.getDepartamento());
			System.out.println("-------------------------------------");
		}
	}
	public void printEquipamentos()
	{
		System.out.println("[LISTA DE EQUIPAMENTOS]");
		System.out.println();
		for (Equipamento equipamento : equipamentoManager.getEquipamentos())
		{
			System.out.println("ID:" + equipamento.getId()  + "\nDescricao:" + equipamento.getDescricao() + "\nSetor:" + equipamento.getSetor() + "\nData de aquisicao:" + equipamento.getDataAquisicao());
			System.out.println("-------------------------------------");
		}
	}

	public boolean cadastrarFuncionario(int id, String nome, String Departamento, int tipo)
	{
		if (tipo == 1)
		{
			Funcionario novoFuncionario = new Funcionario(id, nome, Departamento);
			if (funcionarioManager.findFuncionarioById(id) != null)
			{
				System.out.println("ID já cadastrado");
				return false;
			}
			funcionarioManager.addFuncionario(novoFuncionario);
			System.out.println("Funcionario comum adicionado com sucesso.");
		}
		if (tipo == 2)
		{
			FuncionarioDeSuporte novoFuncionarioDeSuporte = new FuncionarioDeSuporte(id, nome, Departamento);
			if (funcionarioManager.findFuncionarioById(id) != null)
			{
				System.out.println("ID já cadastrado");
				return false;
			}
			funcionarioManager.addFuncionario(novoFuncionarioDeSuporte);
			System.out.println("Funcionario de Suporte adicionado com sucesso.");
		} else
		{
			return false;
		}
		return true;
	}

	public boolean buscarEquipamentosPorDescricao(String descricao)
	{
		List<Equipamento> equipamentos = equipamentoManager.findEquipamentoByDescricao(descricao);

		if (equipamentos.isEmpty())
		{
			System.out.println("Nenhum equipamento encontrado para essa descrição");
			return false;
		}

		for (Equipamento equipamento : equipamentos)
		{
			System.out.println(equipamento.toString());
		}
		return true;
	}

	public boolean cadastrarChamado(int fsid, int equipId, Date dataSol, String descricao)
	{
		if (funcionarioAtual == null) return false;
		Funcionario fs = funcionarioManager.findFuncionarioById(fsid);
		if (fs instanceof FuncionarioDeSuporte)
		{
			Equipamento e = equipamentoManager.findEquipamentoById(equipId);
			Chamado c = new Chamado((FuncionarioDeSuporte) fs, e, equipId, dataSol, descricao);
			if (chamadoManager.findChamadoById(c.getId()) != null)
			{
				System.out.println("ID já cadastrado");
				return false;
			}
			((FuncionarioDeSuporte) fs).adicionarChamado(c);
			chamadoManager.addChamado(c);
			return true;
		} else return false;


	}
}

