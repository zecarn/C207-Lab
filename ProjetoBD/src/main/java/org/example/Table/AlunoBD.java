package org.example.Table;

import org.example.Classes.Aluno;

import java.sql.SQLException;

public class AlunoBD extends ConexaoBD{
    boolean sucesso = false;

    //------------------------INSERIR NOVO REGISTRO DE ALUNO NO DATABASE----------------------------
    public void insertAluno(Aluno aluno){

        connect();

        String sql = "INSERT INTO aluno (matricula, nome, endereco, data_de_nascimento, Curso_sigla, Responsavel_id, bolsa) values (?,?,?,?,?,?,?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,aluno.getMatricula());
            pst.setString(2,aluno.getNome());
            pst.setString(3,aluno.getEndereco());
            pst.setString(4,aluno.getData_de_nascimento());
            pst.setInt(5, aluno.getCurso_sigla());
            pst.setInt(6, aluno.getResponsavel_id());
            pst.setString(7,aluno.getBolsa());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex){
            System.out.println("Erro de conexao  = " + ex.getMessage());
            sucesso = false;
        }finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
    }

    //------------------------SELECIONAR ALUNO POR MATRICULA NO DATABASE----------------------------
    public boolean selectALUNOMatricula(int matricula) {

        connect();
        boolean verificado = false;

        String sql = "SELECT * FROM aluno";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql); //ref. a tabela resultante da busca
            while (resultSet.next()) {
                Aluno alunoTemp = new Aluno(resultSet.getInt("matricula"), resultSet.getString("nome"), resultSet.getString("endereco"), resultSet.getString("data_de_nascimento"), resultSet.getInt("Curso_sigla"), resultSet.getInt("Responsavel_id"), resultSet.getString("bolsa"));
                if(alunoTemp.getMatricula() == matricula) {
                    verificado = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            verificado = false;
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return verificado;
    }
    //------------------------SELECIONAR NOME DE ALUNO ESPECÌFICO NO DATABASE----------------------------
    public String selectMatriculaNome(int matricula) {

        connect();

        String nome = null;
        String sql = "SELECT * FROM aluno";

        try {

            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();

            while(resultSet.next()){
                Aluno alunoTemp = new Aluno(resultSet.getInt("matricula"), resultSet.getString("nome"), resultSet.getString("endereco"), resultSet.getString("data_de_nascimento"), resultSet.getInt("Curso_sigla"), resultSet.getInt("Responsavel_id"), resultSet.getString("bolsa"));

                if(alunoTemp.getMatricula() == matricula){
                    nome = alunoTemp.getNome();
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return nome;
    }

}
