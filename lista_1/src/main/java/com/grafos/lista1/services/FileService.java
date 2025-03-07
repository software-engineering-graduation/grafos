package com.grafos.lista1.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.grafos.lista1.util.ConsoleColors;

public class FileService {
    private List<String> fileList = new ArrayList<>();

    public void mostrarArquivosDisponiveis() {
        fileList.clear();
        File grafosDir = new File("./grafos");
        System.out.println(ConsoleColors.CYAN + "\nArquivos disponíveis:" + ConsoleColors.RESET);
        listarArquivosRecursivamente(grafosDir, "", 0);
        System.out.println();
    }

    private void listarArquivosRecursivamente(File dir, String indent, int index) {
        File[] files = dir.listFiles();
        if (files == null) return;

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

    public String getFilepathFromIndex(int index) {
        if (index < 1 || index > fileList.size()) {
            throw new IllegalArgumentException("Índice de arquivo inválido");
        }
        return fileList.get(index - 1);
    }
}
