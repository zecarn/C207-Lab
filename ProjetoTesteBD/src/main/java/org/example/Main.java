package org.example;

//Import de funções utilizadas no código
import java.text.DecimalFormat;
import java.util.Scanner;

import org.example.Classes.User;
import org.example.Table.UserBD;

public class Main {
    public static void main(String[] args){

        //Estanciando variáveis de entrada e controle
        Scanner sc = new Scanner(System.in);
        Boolean flag = true;

        //Estanciando as classes de BD utilizadas
        UserBD userBD = new UserBD();

        // Informações do User
        String matricula;
        String nome;
        int idade;
        String cidade;

        // MENU PARA SELEÇÃO INICIAL
        while (flag) {
            System.out.println("\n+------------------------------------------------------------+");
            System.out.println("|                  Bem vindo ao site Inatel                  |");
            System.out.println("+------------------------------------------------------------+");
            System.out.println("\nPor favor selecione uma das opções abaixo: ");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Ja possuo conta");
            System.out.println("3 - Sair");
            System.out.print("\nOpção: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.println("\n==============================================================");
                    System.out.println("                    Crição de novo usuário                    ");
                    System.out.println("==============================================================");

                    System.out.println("\nPor favor entre com as informações abaixo: ");

                    System.out.print("\nEntre com seu nome: ");
                    nome = sc.nextLine(); //Entrando com o nome do usuário

                    System.out.print("Entre com a sua matrícula: ");
                    matricula = sc.nextLine(); //Entrando com o CPF do usuário

                    System.out.print("Entre com a sua idade: ");
                    idade = sc.nextInt(); //Entrando com a idade do usuário

                    System.out.println("Entre com a cidade: ");
                    cidade = sc.nextLine(); //Entrnado com a cidade

                    User user = new User(matricula, nome, idade, cidade);
                    userBD.insertCliente(user); //Inserindo na tabela o usuário criado
                    break;

                case 2:
                    System.out.print("\nEntre com sua matrícula: ");
                    matricula = sc.nextLine();

                    if (userBD.selectUserMatricula(matricula)) { //Verficiando se a matricula inserida está presente no BD

                        System.out.println("\n==============================================================");
                        System.out.println("                    Seja bem vindo " + userBD.selectMatriculaNome(matricula));
                        System.out.println("==============================================================");
                    }
                    break;

                case 3:
                    flag = false;
                    break;
            }
        }
    }
}
