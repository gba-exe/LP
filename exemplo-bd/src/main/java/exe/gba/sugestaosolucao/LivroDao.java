package exe.gba.sugestaosolucao;

import exe.gba.minhasolucao.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class LivroDao {
    private Conexao conexao;
    private JdbcTemplate con;

    public LivroDao(){
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
        con.execute("""
                CREATE TABLE IF NOT EXISTS livro (
                    id_livro INT PRIMARY KEY AUTO_INCREMENT,
                    nome varchar(255),
                    preco numeric(5,2)
                )
                """);
    }

    public void cadastrarLivro (Livro livro) {
        con.update("""
                INSERT INTO livro VALUES (
                NULL,
                ?,
                ?
                )  
                """, livro.getNome(), livro.getPreco());
    }
}
