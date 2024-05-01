package org.example;

//Import de funções utilizadas no código
import java.util.Scanner;

import org.example.Classes.Aluno;
import org.example.Table.AlunoBD;

public class Main {
    public static void main(String[] args){

        //Estanciando variáveis de entrada e controle
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        //Estanciando as classes de BD utilizadas
        AlunoBD alunoBD = new AlunoBD();

        // Informações do User
        int matricula;
        String nome;
        String endereco;
        String data_de_nascimento;
        int Curso_sigla;
        int Responsavel_id;
        String bolsa;

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

                    System.out.print("\nEntre com a sua matrícula: ");
                    matricula = sc.nextInt(); //Entrando com o CPF do usuário

                    System.out.print("\nEntre com seu nome: ");
                    nome = sc.nextLine(); //Entrando com o nome do usuário

                    System.out.print("\nEntre com o endereço: ");
                    endereco = sc.nextLine(); //Entrando com o endereco

                    System.out.print("\nEntre com a data de nasimento: ");
                    data_de_nascimento = sc.nextLine(); //Entrnado com a data de nascimento

                    System.out.print("\nEntre com a sigla do curso matriculado: ");
                    Curso_sigla = sc.nextInt(); //Entrando com o curso da matricula

                    System.out.print("\nEntre com o id do seu responsável (se tiver): ");
                    Responsavel_id = sc.nextInt(); //Entrando com o Responsavel do aluno (se tiver)

                    System.out.print("\nTem bolsa? (Sim / Não): ");
                    bolsa = sc.nextLine(); //Entrando com a bolsa

                    Aluno aluno = new Aluno(matricula, nome, endereco, data_de_nascimento, Curso_sigla, Responsavel_id, bolsa);
                    alunoBD.insertAluno(aluno); //Inserindo na tabela o usuário criado
                    break;

                case 2:
                    System.out.print("\nEntre com sua matrícula: ");
                    matricula = sc.nextInt();

                    if (alunoBD.selectALUNOMatricula(matricula)) { //Verficiando se a matricula inserida está presente no BD

                        System.out.println("\n==============================================================");
                        System.out.println("                    Seja bem vindo " + alunoBD.selectMatriculaNome(matricula));
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