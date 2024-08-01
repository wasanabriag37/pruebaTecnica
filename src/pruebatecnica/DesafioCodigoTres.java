/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebatecnica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import static pruebatecnica.DesafioCodigoUno.processList;

/**
 *
 * @author LENOVO
 */
public class DesafioCodigoTres {

    public static void subMenu(int s) {
        List<List<Integer>> examples = new ArrayList<>();
        String[] opc = {"Opción 1: Desea mantener los datos del ejemplo", "Opción 2: Deseo ingresar mis propios valores"};
        String seleccionCaso1 = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la opción que desea realizar:",
                "Menú de opciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opc,
                opc[0]);
        if (seleccionCaso1 != null) {
            switch (seleccionCaso1) {
                case "Opción 1: Desea mantener los datos del ejemplo":
                    examples.add(List.of(5, 7, 1, 1, 2, 3, 22));
                    examples.add(List.of(1, 1, 1, 1, 1));
                    examples.add(List.of(1, 5, 1, 1, 1, 10, 15, 20, 100));
                    StringBuilder mensajeBuilder = new StringBuilder("Listas:\n");
                    for (int i = 0; i < examples.size(); i++) {
                        mensajeBuilder.append("Lista ").append(i + 1).append(": ")
                                .append(examples.get(i).toString())
                                .append("\n");
                    }
                    JOptionPane.showMessageDialog(null, mensajeBuilder.toString(), "Datos Ingresados", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Opción 2: Deseo ingresar mis propios valores":
                    String datos = JOptionPane.showInputDialog(
                            null,
                            "Introduce las listas de números separados por comas (por ejemplo: 1,2,3,4; 10,20; 6)",
                            "Entrada de Datos",
                            JOptionPane.QUESTION_MESSAGE
                    );
                    if (datos != null && !datos.trim().isEmpty()) {
                        String[] listStrings = datos.split(";");
                        for (String listString : listStrings) {
                            List<Integer> list = new ArrayList<>();
                            String[] numbers = listString.split(",");
                            for (String number : numbers) {
                                try {
                                    list.add(Integer.parseInt(number.trim()));
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "Entrada inválida: " + number + " no es un número entero.",
                                            "Error de Entrada",
                                            JOptionPane.ERROR_MESSAGE
                                    );
                                    return;
                                }
                            }
                            examples.add(list);
                        }
                    }
                    break;
            }
        }

        StringBuilder mensajeBuilder = new StringBuilder();
        for (int i = 0; i < examples.size(); i++) {
            mensajeBuilder.append("Input: ")
                    .append(examples.get(i))
                    .append(" -> Output: ")
                    .append(findMinimumChange(examples.get(i)))
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, mensajeBuilder.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int findMinimumChange(List<Integer> coins) {
        List<Integer> mutableCoins = new ArrayList<>(coins); // Copiamos la lista a una lista mutable
        Collections.sort(mutableCoins);
        int currentChange = 0;
        for (int coin : mutableCoins) {
            if (coin > currentChange + 1) {
                break;
            }
            currentChange += coin;
        }
        return currentChange + 1;
    }
}
