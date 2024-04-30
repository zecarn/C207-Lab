package org.example.Table;

import org.example.Classes.User;
import java.sql.SQLException;

public class UserBD extends ConexaoBD{
    boolean sucesso = false;

    //------------------------INSERIR NOVO REGISTRO DE CLIENTE NO DATABASE----------------------------
    public boolean insertCliente(User user){

        connect();

        String sql = "INSERT INTO cliente (Nome,CPF,Telefone) values (?,?,?)";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,user.getMatricula());
            pst.setString(2,user.getNome());
            pst.setInt(3,user.getIdade());
            pst.setString(4,user.getCidade());
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
        return sucesso;
    }

    //------------------------SELECIONAR CLIENTE POR CPF NO DATABASE----------------------------
    public boolean selectUserMatricula(String matricula) {

        connect();
        boolean verificado = false;

        String sql = "SELECT * FROM cliente";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql); //ref. a tabela resultante da busca
            while (resultSet.next()) {
                User userTemp = new User(resultSet.getString("matricula"), resultSet.getString("nome"), resultSet.getInt("idade"), resultSet.getString("cidade"));
                if(userTemp.getMatricula().equals(matricula)) {
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

    //------------------------SELECIONAR NOME DE CLIENTE ESPECÌFICO NO DATABASE----------------------------
    public String selectMatriculaNome(String matricula) {

        connect();

        String nome = null;
        String sql = "SELECT * FROM cliente";

        try {

            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();

            while(resultSet.next()){
                User userTemp = new User(resultSet.getString("matricula"), resultSet.getString("nome"), resultSet.getInt("idade"), resultSet.getString("cidade"));

                if(userTemp.getMatricula().equals(matricula)){
                    nome = userTemp.getNome();
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
