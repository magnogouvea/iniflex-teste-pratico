import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa {
  private BigDecimal salario;
  private String funcao;

  public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
    super(nome, dataNascimento);
    this.salario = salario;
    this.funcao = funcao;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  @Override
  public String toString() {
    return String.format("%s - Salário: %s - Função: %s",
            super.toString(),
            formatarSalario(this.salario),
            this.funcao);
  }
  private static String formatarSalario(BigDecimal salario) {
    return String.format("R$%,.2f", salario);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Funcionario that)) return false;
    return Objects.equals(getSalario(), that.getSalario()) && Objects.equals(getFuncao(), that.getFuncao());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSalario(), getFuncao());
  }
}
