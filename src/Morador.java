import java.util.Date;

public class Morador extends Usuario{
    Livro[] livrosMorador = new Livro[2];

    public Morador(String nome, String cpf, Date data, int id) {
        super(nome, cpf, data, id);
    }
}
