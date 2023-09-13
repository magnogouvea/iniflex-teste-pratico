import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {
  public static void main(String[] args) {
    List<Funcionario> funcionarios = new ArrayList<>();
    FuncionarioService.inserirFuncionarios(funcionarios);
    FuncionarioService.removerFuncionario(funcionarios, "João");
    FuncionarioService.imprimirFuncionarios(funcionarios);
    FuncionarioService.atualizarSalario(funcionarios);
    FuncionarioService.agruparPorFuncao(funcionarios);
  }
}
