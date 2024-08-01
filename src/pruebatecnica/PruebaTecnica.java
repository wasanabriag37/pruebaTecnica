/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebatecnica;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class PruebaTecnica {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        menu();
    }
    /**
     * Metodo esta definido como static lo que permite llamar el metodo sin
     * crear el objecto clase Funcionalidad: El metodo me recibe un lista de
     * enteros que me permite intera de forma dinamica cada uno de sus valores y
     * realizar la verificacion con la obtencion de los datos
     */
    public static void menu() {
        int s = MD5Hash.getHash();
        String[] opciones = {"Opción 1 Desafio Codigo Uno", "Opción 2 Desafio Codigo Dos", "Opción 3 Desafio Codigo Tres","Opción 3: Salir"};

        // Mostrar el JOptionPane con una lista desplegable
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la funcionalidad que desea realizar:",
                "Menú de Funcionalidades",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        // Ejecutar la funcionalidad seleccionada
        if (seleccion != null) {
            switch (seleccion) {
                case "Opción 1 Desafio Codigo Uno":
                    DesafioCodigoUno.subMenu(s);
                    break;
                case "Opción 2 Desafio Codigo Dos":
                    DesafioCodigoDos.subMenu(s);
                    break;
                case "Opción 3 Desafio Codigo Tres":
                    DesafioCodigoTres.subMenu(s);
                    break;
                case "Opción 3: Salir":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Selección no válida.");
            }
        }
    }

}
