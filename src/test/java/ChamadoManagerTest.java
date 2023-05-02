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


}