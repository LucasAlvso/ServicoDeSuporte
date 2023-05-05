import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.Before;


public class FuncionarioManagerTest {
    FuncionarioDeSuporte funcionario = new FuncionarioDeSuporte(1, "João da Silva", "RH");
    Funcionario funcionario2 = new Funcionario(2, "Jonas de Oliveira", "Vendas");
    Funcionario funcionario3 = new Funcionario(2, "Fernanda da Paz", "Marketing");

    private FuncionarioManager funcionarioManager;

    @Before
    public void setUp() {
        funcionarioManager = new FuncionarioManager();
    }


    @Test
    public void testAddFuncionario() {
        boolean result = funcionarioManager.addFuncionario(funcionario);
        List<Funcionario> funcionarios = funcionarioManager.getFuncionarios();
        assertTrue(result);
        assertEquals(1, funcionarios.size());
    }

    @Test
    public void testAddFuncionarioSameId() {
        funcionarioManager.addFuncionario(funcionario2);        
        assertEquals(funcionarioManager.addFuncionario(funcionario3), false);
    }

    @Test
    public void testFindFuncionarioById() {
      funcionarioManager.addFuncionario(funcionario);
      Funcionario result = funcionarioManager.findFuncionarioById(1);
      assertEquals(funcionario, result);
    }

    @Test
    public void testFindFuncionarioByIdNotFound() {
      Funcionario result = funcionarioManager.findFuncionarioById(2);
      assertNull(result);
    }

}