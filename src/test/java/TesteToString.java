import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

public class TesteToString {

    @Test
    public void testeToStringEquipamento() {
        Equipamento equipamento = new Equipamento(1, "Notebook Dell", new Date(1234567890000L), "Departamento de TI");

        String resultado = equipamento.toString();

        String esperado = "Equipamento:" +
                "id = 1," +
                "descricao = 'Notebook Dell'," +
                "dataAquisicao = Fri Feb 13 23:31:30 BRT 2009," +
                "setor = 'Departamento de TI'";
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void testeToStringFuncionario() {
        Funcionario funcionario = new Funcionario(1, "Pedro de Carvalho", "Vendas");

        String resultado = funcionario.toString();

        String esperado = "Funcionário:" +
                "id = 1," +
                "Nome = 'Pedro de Carvalho'," +
                "Departamento = 'Vendas'";
        Assert.assertEquals(esperado, resultado);


    }
}