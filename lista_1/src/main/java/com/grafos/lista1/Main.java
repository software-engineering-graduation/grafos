package com.grafos.lista1;

import com.grafos.lista1.interfaces.IGrafo;
import com.grafos.lista1.services.FileService;
import com.grafos.lista1.services.GrafoService;
import com.grafos.lista1.services.MenuService;
import com.grafos.lista1.util.ConsoleColors;
import com.grafos.lista1.util.GrafoPrinter;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static IGrafo grafo = null;
    private static String implementationType = null;
    private static final MenuService menuService = new MenuService();
    private static final FileService fileService = new FileService();
    private static final GrafoService grafoService = new GrafoService();

    public static void main(String[] args) {
        setupInicial();
        
        while (true) {
            menuService.printMainMenu(implementationType);
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    escolherImplementacao();
                    break;
                case 2:
                    carregarGrafo();
                    break;
                case 3:
                    verificarPropriedades();
                    break;
                case 0:
                    System.out.println(ConsoleColors.YELLOW + "\nSaindo..." + ConsoleColors.RESET);
                    scanner.close();
                    return;
                default:
                    System.out.println(ConsoleColors.RED + "\nOpção inválida!" + ConsoleColors.RESET);
            }
        }
    }

    private static void setupInicial() {
        System.out.println(ConsoleColors.CYAN + "\n=== Configuração Inicial ===" + ConsoleColors.RESET);
        
        // Força escolha da implementação
        while (implementationType == null) {
            escolherImplementacao();
        }
        
        // Força carregamento do grafo
        while (grafo == null) {
            carregarGrafo();
        }
    }

    private static int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void escolherImplementacao() {
        System.out.println(ConsoleColors.CYAN + "\n=== Escolha a Implementação ===" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "1." + ConsoleColors.RESET + " Matriz de Adjacência");
        System.out.println(ConsoleColors.WHITE_BOLD + "2." + ConsoleColors.RESET + " Lista de Adjacência");
        System.out.print("\nEscolha uma opção: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    implementationType = "Matriz de Adjacência";
                    break;
                case 2:
                    implementationType = "Lista de Adjacência";
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "Opção inválida!" + ConsoleColors.RESET);
                    return;
            }
            System.out.println(ConsoleColors.GREEN + "\nImplementação escolhida: " + implementationType + ConsoleColors.RESET);
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColors.RED + "Entrada inválida!" + ConsoleColors.RESET);
        }
    }

    private static void carregarGrafo() {
        if (implementationType == null) {
            System.out.println(ConsoleColors.RED + "\nPor favor, escolha uma implementação primeiro!" + ConsoleColors.RESET);
            return;
        }

        fileService.mostrarArquivosDisponiveis();
        System.out.print("Digite o índice do arquivo: ");

        try {
            int index = Integer.parseInt(scanner.nextLine());
            String filepath = fileService.getFilepathFromIndex(index);
            List<LeitorGrafo.GrafoInfo> grafos = LeitorGrafo.lerGrafos(filepath);
            
            System.out.println("\nGrafos disponíveis no arquivo:");
            for (int i = 0; i < grafos.size(); i++) {
                System.out.println(ConsoleColors.WHITE_BOLD + (i + 1) + "." + ConsoleColors.RESET + " " + grafos.get(i).nome);
            }
            
            System.out.print("\nEscolha o grafo (1-" + grafos.size() + "): ");
            int grafoIndex = Integer.parseInt(scanner.nextLine()) - 1;
            
            if (grafoIndex < 0 || grafoIndex >= grafos.size()) {
                throw new IllegalArgumentException("Índice de grafo inválido");
            }
            
            LeitorGrafo.GrafoInfo grafoSelecionado = grafos.get(grafoIndex);
            grafo = grafoService.createGrafo(implementationType, grafoSelecionado.matriz);
            System.out.println(ConsoleColors.GREEN + "\nGrafo '" + grafoSelecionado.nome + "' carregado com sucesso!" + ConsoleColors.RESET);
            GrafoPrinter.printGrafo(grafo);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(ConsoleColors.RED + "\nErro: " + e.getMessage() + ConsoleColors.RESET);
        }
    }

    private static void verificarPropriedades() {
        if (grafo == null) {
            System.out.println(ConsoleColors.RED + "\nNenhum grafo foi carregado!" + ConsoleColors.RESET);
            return;
        }

        while (true) {
            menuService.printPropertiesMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println();

                if (choice == 0) return;
                if (choice == 1) {
                    GrafoPrinter.printGrafo(grafo);
                } else {
                    grafoService.verificarPropriedade(grafo, choice);
                }
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED + "Entrada inválida!" + ConsoleColors.RESET);
            } catch (UnsupportedOperationException e) {
                System.out.println(ConsoleColors.RED + "Funcionalidade ainda não implementada!" + ConsoleColors.RESET);
            }
        }
    }
}