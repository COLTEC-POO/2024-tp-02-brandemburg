import java.util.Date;

public class Professor extends Usuario{

    private String formacao;
    Livro[] livrosProfessor = new Livro[10];
    private int livrosEmprestados = 0;

    public Professor(String nome, String cpf, Date data, int id, String formacao){
        super(nome, cpf, data, id);
        this.formacao = formacao;
    }
    @Override
    void imprimirUsuario(){
        super.imprimirUsuario();
        System.out.println("Formação: "+ formacao);
    }
    void imprimirLivrosEmprestados(){
        super.imprimirLivrosEmprestados(livrosProfessor);
    }
    boolean pegarLivro(Livro livro){
        if (livrosEmprestados >= livrosProfessor.length){
            System.out.println("Quantidade máxima de livros emprestados atingida!");
            return false;
        }
        livrosProfessor[livrosEmprestados] = livro;
        livrosEmprestados++;
        imprimirLivrosEmprestados();
        return true;
    }
}
