import java.util.Date;

public class Morador extends Usuario{
    Livro[] livrosMorador = new Livro[2];
    private int livrosEmprestados = 0;

    public Morador(String nome, String cpf, Date data, int id) {
        super(nome, cpf, data, id);
    }
    void imprimirLivrosEmprestados(){
        super.imprimirLivrosEmprestados(livrosMorador);
    }
    boolean pegarLivro(Livro livro){
        if (livrosEmprestados >= livrosMorador.length){
            System.out.println("Quantidade máxima de livros emprestados atingida!");
            return false;
        }
        livrosMorador[livrosEmprestados] = livro;
        livrosEmprestados++;
        imprimirLivrosEmprestados();
        return true;
    }
}
