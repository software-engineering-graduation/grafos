package com.grafos.lista1.services;

import com.grafos.lista1.util.ConsoleColors;

public class MenuService {
    public void printMainMenu(String implementationType) {
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

    public void printPropertiesMenu() {
        System.out.println(ConsoleColors.CYAN + "\n=== Menu de Propriedades ===" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "1." + ConsoleColors.RESET + " Visualizar grafo");
        System.out.println(ConsoleColors.WHITE_BOLD + "2." + ConsoleColors.RESET + " Verificar se é simples");
        System.out.println(ConsoleColors.WHITE_BOLD + "3." + ConsoleColors.RESET + " Verificar se é completo");
        System.out.println(ConsoleColors.WHITE_BOLD + "4." + ConsoleColors.RESET + " Verificar se é regular");
        System.out.println(ConsoleColors.WHITE_BOLD + "5." + ConsoleColors.RESET + " Verificar se é conexo");
        System.out.println(ConsoleColors.WHITE_BOLD + "6." + ConsoleColors.RESET + " Verificar se é bipartido");
        System.out.println(ConsoleColors.WHITE_BOLD + "0." + ConsoleColors.RESET + " Voltar");
        System.out.print("\nEscolha uma opção: ");
    }
}
