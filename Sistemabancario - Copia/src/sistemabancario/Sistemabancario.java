package sistemabancario;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Sistemabancario {
    public static void main(String[] args) {

        // Variáveis de entrada
        Scanner teclado = new Scanner(System.in);

        // Variáveis de senha
        String senha = "1234";
        String teste_senha = "";
        String nova_senha = "";

        // Variáveis de dinheiro
        float dinheiro = 1000.00f;
        float deposito = 0;
        float saque = 0;
        float totalDepositos = 0;
        float totalSaques = 0;

        // Variáveis contadoras
        int ccdep = 0;
        int ccsaq = 0;
        int opcao = 0;
        int tent = 3;

        // LOGIN
        System.out.print("Digite sua senha bancária: ");
        teste_senha = teclado.nextLine();

        while (!teste_senha.equals(senha) && tent > 1) {

            tent--;

            System.out.println("Senha incorreta!");
            System.out.println("Tentativas restantes: " + tent);
            System.out.print("Digite sua senha novamente: ");
            teste_senha = teclado.nextLine();
        }

        // Verifica se a senha está correta
        if (!teste_senha.equals(senha)) {
            System.out.println("Número de tentativas excedido.");
            System.out.println("Acesso bloqueado.");
            teclado.close();
            return;
        }

        System.out.println("Login realizado com sucesso!");

        // MENU
        do {

            System.out.println();
            System.out.println("===== BANCO =====");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Extrato");
            System.out.println("5 - Alterar senha");
            System.out.println("6 - Sair");
            System.out.println();

            System.out.print("Escolha: ");
            opcao = teclado.nextInt();

            // Cada opção do menu feita em switch case
            switch (opcao) {

                case 1:

                    System.out.println();
                    System.out.println("===== VER SALDO =====");
                    System.out.printf("Seu saldo atual é de R$%.2f%n", dinheiro);

                    break;

                case 2:

                    System.out.println();
                    System.out.println("===== DEPOSITAR =====");
                    System.out.printf("Seu saldo atual: R$%.2f%n", dinheiro);

                    System.out.print("Digite o valor para depósito: ");
                    deposito = teclado.nextFloat();

                    while (deposito <= 0) {
                        System.out.println("Erro! Digite um valor válido.");
                        System.out.print("Digite o valor para depósito: ");
                        deposito = teclado.nextFloat();
                    }

                    ccdep++;
                    dinheiro += deposito;
                    totalDepositos += deposito;

                    System.out.printf(
                            "Ação bem-sucedida! Agora seu saldo atual é de R$%.2f%n",
                            dinheiro
                    );

                    break;

                case 3:

                    System.out.println();
                    System.out.println("===== SACAR =====");
                    System.out.printf("Seu saldo atual é de R$%.2f%n", dinheiro);

                    System.out.print("Digite o valor do saque: R$");
                    saque = teclado.nextFloat();

                    while (saque <= 0) {
                        System.out.println("ERRO! Digite um valor válido.");
                        System.out.print("Digite o valor do saque: R$");
                        saque = teclado.nextFloat();
                    }

                    while (saque > dinheiro) {
                        System.out.println(
                                "ERRO! O valor do saque ultrapassou seu saldo."
                        );
                        System.out.printf("Seu saldo atual é de R$%.2f%n", dinheiro);
                        System.out.print("Digite novamente o valor do saque: R$");
                        saque = teclado.nextFloat();
                    }

                    ccsaq++;
                    dinheiro -= saque;
                    totalSaques += saque;

                    System.out.printf(
                            "Transação bem-sucedida! Seu saldo atual é de R$%.2f%n",
                            dinheiro
                    );

                    break;

                case 4:

                    System.out.println();
                    System.out.println("===== EXTRATO =====");
                    System.out.printf("Saldo atual: R$%.2f%n", dinheiro);
                    System.out.printf("Total depositado: R$%.2f%n", totalDepositos);
                    System.out.printf("Total sacado: R$%.2f%n", totalSaques);
                    System.out.printf("Quantidade de depósitos: %d%n", ccdep);
                    System.out.printf("Quantidade de saques: %d%n", ccsaq);

                    break;

                case 5:

                    System.out.println();
                    System.out.println("===== ALTERAR SENHA =====");

                    teclado.nextLine();

                    tent = 3;

                    System.out.print("Digite sua senha antiga: ");
                    teste_senha = teclado.nextLine();

                    while (!teste_senha.equals(senha) && tent > 1) {

                        tent--;

                        System.out.println();
                        System.out.println("Senha incorreta!");
                        System.out.println("Tentativas restantes: " + tent);
                        System.out.print("Digite novamente sua senha: ");
                        teste_senha = teclado.nextLine();
                    }

                    if (!teste_senha.equals(senha)) {

                        System.out.println();
                        System.out.println("A quantidade de tentativas foi excedida.");

                    } else {


                        // NOVA SENHA
                        tent = 3;

                        System.out.println();
                        System.out.println("A senha deve ter no máximo 8 caracteres.");
                        System.out.println("Digite sua nova senha: ");

                        nova_senha = teclado.nextLine();

                        while (nova_senha.length() > 8 && tent > 1 || nova_senha.equals(senha) && tent > 1) {

                            tent--;

                            System.out.println();
                            System.out.println("A senha deve ter no máximo 8 caracteres e não deve ser igual a antiga.");
                            System.out.println("Tentativas restantes: " + tent);

                            System.out.print("Digite outra senha: ");
                            nova_senha = teclado.nextLine();



                        }


                        if (senha.length() > 8){
                            System.out.println();
                            System.out.println("A quantidade de tentativas foi excedida.");
                        } else if (senha.equals(nova_senha)) {
                            System.out.println("A quantidade de tentativas foi excedida.");
                        } else {
                            System.out.println();
                            System.out.println("Senha trocada com sucesso!");
                        }
                    }

                    break;

                case 6:

                    System.out.println();
                    System.out.println("===== SAINDO =====");
                    System.out.println("Obrigado por utilizar nosso banco!");

                    break;

                default:

                    System.out.println();
                    System.out.println("Opção inválida! Escolha uma opção de 1 a 6.");

                    break;
            }

        } while (opcao != 6);

        teclado.close();
    }
}