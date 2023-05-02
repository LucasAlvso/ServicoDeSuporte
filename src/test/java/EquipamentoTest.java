import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class EquipamentoTest {

    @Test
    public void testGettersAndSetters() {
        // cria um novo equipamento
        Equipamento equipamento = new Equipamento(1, "Notebook", new Date(), "TI");

        // verifica se os valores iniciais são os esperados
        assertEquals(1, equipamento.getId());
        assertEquals("Notebook", equipamento.getDescricao());
        assertEquals("TI", equipamento.getSetor());

        // altera os valores do equipamento
        equipamento.setId(2);
        equipamento.setDescricao("Desktop");
        equipamento.setSetor("Administração");

        // verifica se as alterações foram realizadas com sucesso
        assertEquals(2, equipamento.getId());
        assertEquals("Desktop", equipamento.getDescricao());
        assertEquals("Administração", equipamento.getSetor());
    }

}
