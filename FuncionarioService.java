import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FuncionarioService {
  public static List<Funcionario> inserirFuncionarios(List<Funcionario> funcionarios){
    System.out.println("Inserindo funcionários...");

    funcionarios.add(new Funcionario("Maria",
            LocalDate.of(2000, 10, 18),
            new BigDecimal("2009.44"), "Operador"));

    funcionarios.add(new Funcionario("João",
            LocalDate.of(1990, 5, 12),
            new BigDecimal("2284.38"), "Operador"));

    funcionarios.add(new Funcionario("Caio",
            LocalDate.of(1961, 5,12),
            new BigDecimal("9836.14"), "Coordenador"));

    funcionarios.add(new Funcionario("Miguel",
            LocalDate.of(1988, 10,14),
            new BigDecimal("19119.88"), "Diretor"));

    funcionarios.add(new Funcionario("Alice",
            LocalDate.of(1995, 1,5),
            new BigDecimal("2234.68"), "Recepcionista"));

    funcionarios.add(new Funcionario("Heitor",
            LocalDate.of(1999, 11,19),
            new BigDecimal("1582.72"), "Operador"));

    funcionarios.add(new Funcionario("Arthur",
            LocalDate.of(1993, 3,31),
            new BigDecimal("4071.84"), "Contador"));

    funcionarios.add(new Funcionario("Laura",
            LocalDate.of(1994, 7, 8),
            new BigDecimal("3017.45"), "Gerente"));

    funcionarios.add(new Funcionario("Heloísa",
            LocalDate.of(2003, 5, 24),
            new BigDecimal("1606.85"), "Eletricista"));

    funcionarios.add(new Funcionario("Helena",
            LocalDate.of(1996, 9, 2),
            new BigDecimal("2799.93"), "Gerente"));
    return funcionarios;
  }

  public static List<Funcionario> removerFuncionario(List<Funcionario> funcionarios, String nome) {
    System.out.println("Removendo funcionário: " + nome);

    funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));

    System.out.println(funcionarios);
    return funcionarios;
  }

  public static List<Funcionario> imprimirFuncionarios(List<Funcionario> funcionarios) {
    System.out.println("Imprimindo funcionários...");
    for(Funcionario funcionario : funcionarios) {
      System.out.println(funcionario);
    }
    return funcionarios;
  }

  public static List<Funcionario> atualizarSalario(List<Funcionario> funcionarios) {
    System.out.println("Atualizando o salário dos funcionários...");
    for(Funcionario funcionario : funcionarios) {
      BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.10"));
      funcionario.setSalario(novoSalario);
    }
    System.out.println(funcionarios);
    return funcionarios;
  }


  //Acredito que aqui sirva para a questão 3.5 e 3.6
  public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
    System.out.println("Agrupando por função...");
    System.out.println(funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao)));
     return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
  }

  public static List<Funcionario> funcionariosComMesAniversario(List<Funcionario> funcionarios) {
    System.out.println("Imprimindo funcionários que nasceram no mês 10 e 12...");
    LocalDate hoje = LocalDate.now();
    int mesAtual = hoje.getMonthValue();

    List<Funcionario> imprimirComMesAniversario = funcionarios.stream()
            .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12)
            .toList();
    System.out.println(imprimirComMesAniversario);
    return imprimirComMesAniversario;
  }

  public static Optional<Funcionario> funcionarioMaisVelho(List<Funcionario> funcionarios) {
    System.out.println("Imprimindo funcionário mais velho...");
    Optional<Funcionario> funcionarioMaisVelho = funcionarios.stream()
            .max(Comparator.comparing(Funcionario::getDataNascimento).reversed());
    System.out.println(funcionarioMaisVelho);
    return funcionarioMaisVelho;
  }

  public static List<Funcionario> imprimirFuncionariosOrdenados(List<Funcionario> funcionarios) {
    System.out.println("Imprimindo funcionários por ordem alfabética...");
    List<Funcionario> funcionariosOrdenados = funcionarios.stream()
            .sorted(Comparator.comparing(Funcionario::getNome))
            .collect(Collectors.toList());

    System.out.println(funcionariosOrdenados);

    return funcionariosOrdenados;
  }

  public static BigDecimal totalSalarios(List<Funcionario> funcionarios) {
    System.out.println("Imprimindo o total de salários...");
    BigDecimal totalSalarios = funcionarios.stream()
            .map(Funcionario::getSalario)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println(totalSalarios);
    return totalSalarios;
  }

  public static List<BigDecimal> imprimirSalariosMinimo(List<Funcionario> funcionarios) {
    System.out.println("Imprimindo salários mínimos...");
    BigDecimal salarioMinimo = new BigDecimal("1212.00");

    List<BigDecimal> salariosMinimo = funcionarios.stream()
            .map(funcionario -> funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP))
            .collect(Collectors.toList());
    System.out.println(salarioMinimo);

    return salariosMinimo;
  }


}
