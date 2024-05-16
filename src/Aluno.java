import java.util.Date;

public class Aluno extends Usuario{
    private String escola;
    Livro[] livrosAluno = new Livro[5];
    private int livrosEmprestados = 0;

    public Aluno(String nome, String cpf, Date data, int id, String escola) {
        super(nome, cpf, data, id);
        this.escola = escola;
    }
    void imprimirUsuario(){
        super.imprimirUsuario();
        System.out.println("Escola: "+escola);
    }
    void imprimirLivrosEmprestados(){
        super.imprimirLivrosEmprestados(livrosAluno);
    }
    boolean pegarLivro(Livro livro){
        if (livrosEmprestados >= livrosAluno.length){
            System.out.println("Quantidade máxima de livros emprestados atingida!");
            return false;
        }
        livrosAluno[livrosEmprestados] = livro;
        livrosEmprestados++;
        imprimirLivrosEmprestados();
        return true;
    }
}
