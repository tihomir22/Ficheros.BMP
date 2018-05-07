/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros.bmp;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sportak
 */
public class FicherosBMP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = "wolf2.bmp";
        File imagen = new File(nombre);
        int cont = 0;
        int compresion = 0;
        String tipo = "";
        int byteLect;
        if (imagen.exists()) {
            System.out.println("El fichero" + "\t" + imagen.getName());
            System.out.println("Con ruta" + "\t" + imagen.getAbsolutePath());
            try {
                DataInputStream lecturaImg = new DataInputStream(new FileInputStream(imagen));
                while (cont < 54) {
                    byteLect = lecturaImg.readByte();
                    if (cont == 0 || cont == 1) { // Determinar el tipo del fichero
                        tipo += (char) byteLect;
                    }
                    if (cont == 30) {
                        compresion = byteLect;
                    }

                    cont++;
                }
                System.out.println("Tipo de fichero" + "\t" + tipo);
                if(compresion==0){
                    System.out.println("Y esta COMPRIMIDO");
                }else{
                    System.out.println("Y NO ESTA COMPRIMIDO");
                }
               

            } catch (FileNotFoundException ex) {
                Logger.getLogger(FicherosBMP.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FicherosBMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
