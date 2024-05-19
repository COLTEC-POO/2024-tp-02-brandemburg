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
    public Livro[] getVetor(){
        return livrosAluno;
    }

    boolean devolverLivro(Livro livro){
        int i = 0;

        do{
            if (livrosAluno[i]!= null) {
                if (livrosAluno[i].getCodigoLivro() == livro.getCodigoLivro()) {
                    livrosAluno[i] = null;
                    System.out.println("Livro devolvido com sucesso!");
                    return true;
                }
                i++;
            }
            i++;
        }while ( i < livrosAluno.length);
        System.out.println("Livro não encontrado...");
        return false;
    }
}
