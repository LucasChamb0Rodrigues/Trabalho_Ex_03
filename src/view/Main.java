package view;

import model.Pedido;
import model.Produto;

import controller.GerenciadorLanchonete;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorLanchonete sistema = new GerenciadorLanchonete();
        List<Produto> cardapio = new ArrayList<>();

        int opcao = -1;

        do {
            System.out.println("\n=== LANCHONETE EXPRESS ===");
            System.out.println("1. Cadastrar Produto no Cardápio");
            System.out.println("2. Novo Pedido");
            System.out.println("3. Relatório de Vendas (Hoje)");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do Produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Descrição: ");
                        String desc = scanner.nextLine();
                        System.out.print("Preço: ");
                        double preco = Double.parseDouble(scanner.nextLine());
                        cardapio.add(new Produto(nome, desc, preco));
                        System.out.println("Produto adicionado ao cardápio!");
                        break;

                    case 2:
                        if (cardapio.isEmpty()) {
                            System.out.println("Erro: O cardápio está vazio!");
                            break;
                        }

                        Pedido novoPedido = new Pedido();
                        boolean adicionando = true;

                        while (adicionando) {
                            System.out.println("\n--- Cardápio ---");
                            for (int i = 0; i < cardapio.size(); i++) {
                                System.out.println(i + " - " + cardapio.get(i));
                            }
                            System.out.print("Escolha o produto pelo número (ou -1 para finalizar): ");
                            int escolha = Integer.parseInt(scanner.nextLine());

                            if (escolha == -1) {
                                try {
                                    sistema.registrarPedido(novoPedido);
                                    adicionando = false;
                                } catch (IllegalStateException e) {
                                    System.out.println("ERRO: " + e.getMessage());
                                    System.out.println("Adicione pelo menos um item!");
                                }
                            } else if (escolha >= 0 && escolha < cardapio.size()) {
                                novoPedido.adicionarProduto(cardapio.get(escolha));
                                System.out.println("Produto adicionado! Total atual: R$ " + novoPedido.calcularTotal());
                            }
                        }
                        break;

                    case 3:
                        sistema.consultarFaturamentoPorData(LocalDate.now());
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);

        scanner.close();
    }
}