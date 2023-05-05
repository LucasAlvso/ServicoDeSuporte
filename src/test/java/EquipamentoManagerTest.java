import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class EquipamentoManagerTest {

         Equipamento equipamento1 = new Equipamento(1, "Notebook Dell", new Date(1234567890000L), "Departamento de TI");
         Equipamento equipamento2 = new Equipamento(2, "Impressora HP", new Date(1234567890000L), "Departamento de Marketing");
         Equipamento equipamento3 = new Equipamento(3, "Mesa de escritório", new Date(1234567890000L), "Departamento Administrativo");
         Equipamento equipamento4 = new Equipamento(4, "Projetor Epson", new Date(1234567890000L), "Departamento de Treinamento");
         Equipamento equipamento5 = new Equipamento(5, "Cadeira ergonômica", new Date(1234567890000L), "Departamento de RH");

     private EquipamentoManager equipamentoManager;

     @Before
     public void setUp() {
         equipamentoManager = new EquipamentoManager();
     }

    @Test
    public void testAddFuncionario() {
        boolean result = equipamentoManager.adicionaEquipamento(equipamento1);
        List<Equipamento> equipamentos = equipamentoManager.getEquipamentos();
        assertTrue(result);
        assertEquals(1, equipamentos.size());
    }

    @Test
    public void testAddEquipamentoSameId() {
        equipamentoManager.adicionaEquipamento(equipamento2);
        assertEquals(equipamentoManager.adicionaEquipamento(equipamento3), false);
    }

    @Test
    public void testFindEquipamentoById() {
        equipamentoManager.adicionaEquipamento(equipamento1);
        Equipamento result = equipamentoManager.findEquipamentoById(5);
        assertEquals(equipamento1, result);
    }

    @Test
    public void testFindEquipamentoByIdNotFound() {
        Equipamento result = equipamentoManager.findEquipamentoById(4);
        assertNull(result);
    }
 }
