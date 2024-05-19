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
    public Livro[] getVetor(){
        return livrosMorador;
    }

    boolean devolverLivro(Livro livro){
        int i = 0;

        do{
            if (livrosMorador[i]!= null) {
                if (livrosMorador[i].getCodigoLivro() == livro.getCodigoLivro()) {
                    livrosMorador[i] = null;
                    System.out.println("Livro devolvido com sucesso!");
                    return true;
                }
                i++;
            }
            i++;
        }while ( i < livrosMorador.length);
        System.out.println("Livro não encontrado...");
        return false;
    }
}
