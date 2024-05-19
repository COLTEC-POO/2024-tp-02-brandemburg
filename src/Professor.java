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
    boolean devolverLivro(Livro livro){
        int i = 0;

        do{
            if (livrosProfessor[i]!= null) {
                if (livrosProfessor[i].getCodigoLivro() == livro.getCodigoLivro()) {
                    livrosProfessor[i] = null;
                    System.out.println("Livro devolvido com sucesso!");
                    return true;
                }
                i++;
            }
            i++;
        }while ( i < livrosProfessor.length);
        System.out.println("Livro não encontrado...");
        return false;
    }
    public Livro[] getVetor(){
        return livrosProfessor;
    }
}
