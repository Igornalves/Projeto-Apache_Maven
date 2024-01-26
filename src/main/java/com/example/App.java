package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args )
    {

        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aprendendo_sql", "igorn", "08901");
            if (conexao != null) {
                System.out.println("vc se conectou ao banco de dados com sucesso\n");
                Statement stm = conexao.createStatement();
                // inserirDados(stm);
                // System.out.println("os dados foram inseridos com sucesso no banco de dados com sucesso \n");
                consultarDados(stm);
                conexao.close();
            }else{
                System.out.println("vc não de conectou ao banco de dados desejado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void consultarDados(Statement stm){
        String query = "Select * from testedetabela ";
        try {
            ResultSet resultado = stm.executeQuery(query);
            System.out.println("todo que estar na tabela de teste para conexão com o postgresql\n");
            while (resultado.next()) {
                System.out.println("id: "+ resultado.getInt("id") + "\nprimeiro nome: " + resultado.getString("primeironome") + "\nsegundo nome: " + resultado.getString("segundonome") + "\nidade: " + resultado.getInt("idade"));
                System.out.print("\n\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirDados(Statement stm){
        // String sql = "insert into testedetabela (id,primeironome,segundonome,idade) values ('7352631','carla','nascimento','17')";
        // try {
        //     stm.executeUpdate(sql);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    }
}
