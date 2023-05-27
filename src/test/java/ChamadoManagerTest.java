import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

class ChamadoManagerTest {
    Date dataAquisicao = new Date();
    Equipamento equipamento = new Equipamento(1, "Notebook Dell", dataAquisicao, "TI");
    FuncionarioDeSuporte funcionario = new FuncionarioDeSuporte(1, "João da Silva", "RH");

    private ChamadoManager chamadoManager;

    @BeforeEach
    void setUp() {
        chamadoManager = new ChamadoManager();
    }


    @Test
    void testAddChamado() {
        Chamado chamado = new Chamado(funcionario, equipamento, 1, dataAquisicao, "teste");
        boolean result = chamadoManager.addChamado(chamado);
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, chamadoManager.getChamados().size());
    }

    @Test
    void testFindChamadosByEquipamento() {
        Chamado chamado1 = new Chamado(funcionario, equipamento, 1, dataAquisicao, "teste");
        chamadoManager.addChamado(chamado1);
        List<Chamado> result = chamadoManager.findChamadosByEquipamento(equipamento);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(chamado1, result.get(0));
    }

    @Test
    void testFindChamadoByFuncionario() {
        Chamado chamado1 = new Chamado(funcionario, equipamento, 1, dataAquisicao, "teste");
        chamadoManager.addChamado(chamado1);
        List<Chamado> result = chamadoManager.findChamadoByFuncionario(funcionario);
        Assertions.assertEquals(45, result.size());
        Assertions.assertEquals(chamado1, result.get(0));
    }

    @Test
    void testFindChamadoById() {
        Chamado chamado1 = new Chamado(funcionario, equipamento, 1, dataAquisicao, "teste");
        chamadoManager.addChamado(chamado1);
        Chamado result = chamadoManager.findChamadoById(1);
        Assertions.assertEquals(chamado1, result);
    }

    @Test
    void testFindChamadosKeyword() {
        Chamado chamado1 = new Chamado(funcionario, equipamento, 1, dataAquisicao, "teste");
        chamadoManager.addChamado(chamado1);
        Chamado result = chamadoManager.findChamadoById(1);
        Assertions.assertEquals(chamado1, result);
    }

    @Test
    void testFindChamadosByKeyword() {
        Chamado chamado1 = new Chamado(funcionario, equipamento, 1, dataAquisicao, "teste");
        chamadoManager.addChamado(chamado1);
        List<Chamado> chamadosByKeyword = chamadoManager.findChamadosByKeyword("Dell");
        Assertions.assertTrue(chamadosByKeyword.contains(chamado1));
    }

}