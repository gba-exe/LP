package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.execute("DROP TABLE filme IF EXISTS");

        con.execute("""
                CREATE TABLE filme (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nome VARCHAR(255),
                    ano_lancamento INT
                )
                """);

        con.update("""
                INSERT INTO filme(nome, ano_lancamento) VALUES(
                'Drive',
                2011
                );
                """);
        con.update("""
                INSERT INTO filme(nome, ano_lancamento) VALUES(
                'La La Land',
                2016
                );
                """);

        con.update("""
                INSERT INTO filme(nome, ano_lancamento) VALUES(
                'Fallen Angels',
                1995
                );
                """);

        List<Filme> filmesDoBanco = con.query("SELECT * FROM filme;", new BeanPropertyRowMapper<>(Filme.class));

        System.out.println(filmesDoBanco);

        String busca = "%an%";

        List<Filme> listaBusca = con.query("SELECT * FROM filme WHERE nome LIKE ?;", new BeanPropertyRowMapper<>(Filme.class), busca);

        System.out.println(listaBusca);

        Filme novoFilme = new Filme();
        novoFilme.setNome("Cungking Express");
        novoFilme.setAnoLancamento(1994);

        con.update("""
                INSERT INTO filme(nome, ano_lancamento) VALUES(
                ?,
                ?
                );
                """, novoFilme.getNome(), novoFilme.getAnoLancamento());

        filmesDoBanco = con.query("SELECT * FROM filme;", new BeanPropertyRowMapper<>(Filme.class));

        System.out.println(filmesDoBanco);

        novoFilme.setId(4);
        novoFilme.setNome("Chungking Express");

        con.update("""
                UPDATE filme SET nome = ?, ano_lancamento = ? WHERE id = ?
                """, novoFilme.getNome(), novoFilme.getAnoLancamento(), novoFilme.getId());

        filmesDoBanco = con.query("SELECT * FROM filme;", new BeanPropertyRowMapper<>(Filme.class));

        System.out.println(filmesDoBanco);

        con.update("""
                DELETE FROM filme WHERE id = ?
                """, novoFilme.getId());

        filmesDoBanco = con.query("SELECT * FROM filme;", new BeanPropertyRowMapper<>(Filme.class));

        System.out.println(filmesDoBanco);
    }
}