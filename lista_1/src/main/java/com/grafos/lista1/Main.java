package com.grafos.lista1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grafos.lista1.interfaces.IGrafo;
import com.grafos.lista1.util.ConsoleColors;
import com.grafos.lista1.util.GrafoConverter;
import com.grafos.lista1.util.GrafoPrinter;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static IGrafo grafo = null;
    private static String implementationType = null;
    private static List<String> fileList = new ArrayList<>();

    public static void main(String[] args) {
        setupInicial();
        
        while (true) {
            printMenu();
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

    private static void printMenu() {
        System.out.println(ConsoleColors.CYAN + "\n=== Menu Principal ===" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "1." + ConsoleColors.RESET + " Escolher implementação (Matriz/Lista)");
        System.out.println(ConsoleColors.WHITE_BOLD + "2." + ConsoleColors.RESET + " Carregar grafo de arquivo");
        System.out.println(ConsoleColors.WHITE_BOLD + "3." + ConsoleColors.RESET + " Verificar propriedades do grafo");
        System.out.println(ConsoleColors.WHITE_BOLD + "0." + ConsoleColors.RESET + " Sair");
        System.out.println("\nImplementação atual: " + 
            (implementationType == null ? 
                ConsoleColors.RED + "Não selecionada" : 
                ConsoleColors.GREEN + implementationType) + 
            ConsoleColors.RESET);
        System.out.print("\nEscolha uma opção: ");
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

        mostrarArquivosDisponiveis();
        System.out.print("Digite o índice do arquivo: ");

        try {
            int index = Integer.parseInt(scanner.nextLine());
            String filepath = getFilepathFromIndex(index);
            int[][] matriz = lerMatrizDeArquivo(filepath);
            grafo = implementationType.equals("Matriz de Adjacência") ? 
                GrafoConverter.matrixFromFile(matriz) :
                GrafoConverter.listFromFile(matriz);
            System.out.println(ConsoleColors.GREEN + "\nGrafo carregado com sucesso!" + ConsoleColors.RESET);
            GrafoPrinter.printGrafo(grafo);
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED + "\nErro ao ler arquivo: " + e.getMessage() + ConsoleColors.RESET);
        } catch (IllegalArgumentException e) {
            System.out.println(ConsoleColors.RED + "\n" + e.getMessage() + ConsoleColors.RESET);
        }
    }

    private static void verificarPropriedades() {
        if (grafo == null) {
            System.out.println(ConsoleColors.RED + "\nNenhum grafo foi carregado!" + ConsoleColors.RESET);
            return;
        }

        while (true) {
            System.out.println(ConsoleColors.CYAN + "\n=== Menu de Propriedades ===" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD + "1." + ConsoleColors.RESET + " Visualizar grafo");
            System.out.println(ConsoleColors.WHITE_BOLD + "2." + ConsoleColors.RESET + " Verificar se é simples");
            System.out.println(ConsoleColors.WHITE_BOLD + "3." + ConsoleColors.RESET + " Verificar se é completo");
            System.out.println(ConsoleColors.WHITE_BOLD + "4." + ConsoleColors.RESET + " Verificar se é regular");
            System.out.println(ConsoleColors.WHITE_BOLD + "5." + ConsoleColors.RESET + " Verificar se é conexo");
            System.out.println(ConsoleColors.WHITE_BOLD + "6." + ConsoleColors.RESET + " Verificar se é bipartido");
            System.out.println(ConsoleColors.WHITE_BOLD + "0." + ConsoleColors.RESET + " Voltar");
            System.out.print("\nEscolha uma opção: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println(); // line break for better formatting

                switch (choice) {
                    case 0:
                        return;
                    case 1:
                        GrafoPrinter.printGrafo(grafo);
                        break;
                    case 2:
                        System.out.println("É simples? " + 
                            (grafo.isSimples() ? ConsoleColors.GREEN + "Sim" : ConsoleColors.RED + "Não") + 
                            ConsoleColors.RESET);
                        break;
                    case 3:
                        System.out.println("É completo? " + 
                            (grafo.isCompleto() ? ConsoleColors.GREEN + "Sim" : ConsoleColors.RED + "Não") + 
                            ConsoleColors.RESET);
                        break;
                    case 4:
                        System.out.println("É regular? " + 
                            (grafo.isRegular() ? ConsoleColors.GREEN + "Sim" : ConsoleColors.RED + "Não") + 
                            ConsoleColors.RESET);
                        break;
                    case 5:
                        System.out.println("É conexo? " + 
                            (grafo.isConexo() ? ConsoleColors.GREEN + "Sim" : ConsoleColors.RED + "Não") + 
                            ConsoleColors.RESET);
                        break;
                    case 6:
                        System.out.println("É bipartido? " + 
                            (grafo.isBipartido() ? ConsoleColors.GREEN + "Sim" : ConsoleColors.RED + "Não") + 
                            ConsoleColors.RESET);
                        break;
                    default:
                        System.out.println(ConsoleColors.RED + "Opção inválida!" + ConsoleColors.RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED + "Entrada inválida!" + ConsoleColors.RESET);
            } catch (UnsupportedOperationException e) {
                System.out.println(ConsoleColors.RED + "Funcionalidade ainda não implementada!" + ConsoleColors.RESET);
            }
        }
    }

    private static int[][] lerMatrizDeArquivo(String filepath) throws IOException {
        return LeitorGrafo.lerGrafo(filepath);
    }

    private static void mostrarArquivosDisponiveis() {
        fileList.clear();
        File grafosDir = new File("./grafos");
        System.out.println(ConsoleColors.CYAN + "\nArquivos disponíveis:" + ConsoleColors.RESET);
        listarArquivosRecursivamente(grafosDir, "", 0);
        System.out.println();
    }

    private static void listarArquivosRecursivamente(File dir, String indent, int index) {
        File[] files = dir.listFiles();
        if (files == null)
            return;

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(indent + "├── " + file.getName() + "/");
                listarArquivosRecursivamente(file, indent + "│   ", index);
            } else {
                fileList.add(file.getAbsolutePath());
                System.out.println(indent + "├── " + fileList.size() + ". " + file.getName());
            }
        }
    }

    private static String getFilepathFromIndex(int index) {
        if (index < 1 || index > fileList.size()) {
            throw new IllegalArgumentException("Índice de arquivo inválido");
        }
        return fileList.get(index - 1);
    }
}