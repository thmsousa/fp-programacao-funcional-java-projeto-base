package exercicios;

import exercicios.base.Aula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Esta é uma classe para você poder implementar as atividades propostas no README.
 * Você <b>NÃO</b> deve alterar:
 * <ul>
 *     <li>a estrutura deste arquivo;</li>
 *     <li>o nome da classe, dos métodos ou dos atributos;</li>
 *     <li>parâmetros e tipo de retorno dos métodos.</li>
 * </ul>
 *
 * <b>Mas você PRECISA alterar valores dos atributos existentes</b>.
 *
 * <p>Você pode alterar o código interno dos métodos, criar métodos auxiliares que podem ser chamados
 * pelos existentes, mas não deve alterar a estrutura dos métodos disponíveis.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Aula06 extends Aula {

    /**
     * {@link Predicate<Estudante>} que seleciona somente as mulheres
     * matriculadas em algum curso e com nota maior ou igual a 6.
     * Este deve ser um predicado composto usando {@link Predicate#and(Predicate)}.
     * Você deve trocar o valor armazenado ao atributo para ele seguir a regra definida acima.
     */
    private final Predicate<Estudante> mulheresAprovadas =
            e -> e.isMulher() && e.hasCurso() && e.isAprovado(); //TODO: Atribua aqui o predicado composto com o filtro indicado acima

    /**
     * Você pode chamar os métodos existentes e outros que você criar aqui,
     * incluir prints e fazer o que desejar neste método para conferir os valores retornados pelo seu método.
     * Para verificar se sua implementação está correta, clique com o botão direito no nome do projeto na aba esquerda
     * do IntelliJ e selecione a opção "Run All Tests".
     */
    public Aula06() {
        //TODO: Insira chamdas das funções existentes aqui, para você conferir como estão funcionando
        final var curso = generator.CURSOS[3];
        final char homem = 'M';
        final char mulher = 'F';

        getEstudantesMulheresAprovadas().forEach(System.out::println);
        System.out.println("" +
                "");
        getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota().forEach(System.out::println);
        System.out.println("" +
                "");
        getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente().forEach(System.out::println);
        System.out.println("" +
                "");
        getEstudantesMulheresAprovadasNaoOrdenadasModificavel().forEach(System.out::println);
    }

    /**
     * Veja o método construtor {@link #Aula06()}.
     */
    public static void main(String[] args) {
        new Aula06();
    }

    /**
     * Obtém uma Lista <b>NÃO-MODIFICÁVEL</b> de mulheres matriculadas e aprovadas em algum curso
     * O método usa o predicado {@link #mulheresAprovadas} para filtrar a lista de estudantes.
     * Desta forma, você precisa definir um predicado composto com {@link Predicate#and(Predicate)}
     * para tal atributo.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadas() {
        return List.copyOf(estudantes.stream()
                .filter(mulheresAprovadas)
                .toList()
        );
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada por curso e nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota() {
        return List.copyOf(
                getEstudantesMulheresAprovadas()
                        .stream()
                        .sorted(Comparator.comparing(Estudante::getCurso)
                                .thenComparing(Estudante::getNota))
                        .toList()
        );
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada de forma decrescente pelo nome do curso e crescente pela nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente() {
        return List.copyOf(
                getEstudantesMulheresAprovadas()
                        .stream()
                        .sorted(Comparator.comparing(Estudante::getCurso, Comparator.reverseOrder())
                                .thenComparing(Estudante::getNota, Comparator.naturalOrder()))
                        .toList()
        );
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas na ordem original retornada pela Stream.
     * A lista deve ser <b>MODIFICÁVEL</b>.
     *
     * @return uma Lista <b>MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {
        return new ArrayList<>(getEstudantesMulheresAprovadas());
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada de forma decrescente tanto pelo nome do curso quanto pela nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente() {
        return List.copyOf(getEstudantesMulheresAprovadas().stream()
                .sorted(Comparator.comparing(Estudante::getCurso, Comparator.reverseOrder())
                        .thenComparing(Estudante::getNota, Comparator.reverseOrder()))
                .toList()
        );
    }

    /**
     * Obtém uma Lista com os mesmos filtros do método {@link #getEstudantesMulheresAprovadas()},
     * mas ordenada de forma crescente pelo nome do curso e descrecente pela nota.
     *
     * @return uma Lista <b>NÃO-MODIFICÁVEL</b> de estudantes selecionados pelo predicado {@link #mulheresAprovadas}
     */
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente() {
        return List.copyOf(
                getEstudantesMulheresAprovadas()
                        .stream()
                        .sorted(Comparator.comparing(Estudante::getCurso)
                                .thenComparing(Estudante::getNota, Comparator.reverseOrder()))
                        .toList()
        );
    }
}
