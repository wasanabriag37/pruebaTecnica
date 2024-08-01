/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebatecnica;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class MD5Hash {

    public static int getHash() {
        String nombre = JOptionPane.showInputDialog(null, "Por favor, ingrese su nombre para obtener MD5 Hash:", "Entrada nombre", JOptionPane.QUESTION_MESSAGE);
        int s = 0;
        try {
            // Crear instancia de MessageDigest con el algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Actualizar el MessageDigest con los bytes del input
            md.update(nombre.getBytes());

            // Obtener el hash bytes
            byte[] digest = md.digest();

            // Convertir los bytes a formato hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));

            }

            // Convertir a to string
            String hashMD5 = sb.toString();
            
            //recorre cada letra de hash con el fin de saber si es numero
            for (char c : hashMD5.toCharArray()) {
                if (Character.isDigit(c)) {
                    s = Character.getNumericValue(c);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Hash Obtenido: \n"+hashMD5 + "\n Primer numero encontrado: \n"+s , "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return s;
    }
}
