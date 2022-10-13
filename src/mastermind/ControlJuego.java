/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

/**
 *
 * @author reney
 */
import java.util.Scanner;
import java.util.ArrayList;

public class ControlJuego {
    
    private Scanner scan;
    private Tablero interfazGrafica;
    //ArrayList de string donde se podrá introducir el código a descifrar
    private ArrayList <String> codigoPosible;
    private int espacio = 0;
    private int intentos = 1;
   
    
    public ControlJuego()
    {
        scan = new Scanner(System.in);
        interfazGrafica = new Tablero();
        interfazGrafica.dibujarTablero(15,6);
        codigoPosible = new ArrayList();
        
        //Se crea el tamaño del arraylist (4 partes de código) concorde al
        //tamaño del código
        for(int i = 0; i<6; i++)
        {
            codigoPosible.add("");
        }
    }
    
    
    //Inicia un nuevo juego
    public void iniciarJuego()
    {
        while(intentos<=15)
        {
            System.out.println("\nIntento " + intentos);
            introducirCodigo();
            colocarBolas();
        }
        
        //indica el límite de intentos para adivinar el código
       if(intentos>=15)
       {
           System.out.println("Límite de intentos");
       }
     
    }
    
    
    
    //para introducir cada parte del código
    public void setCodigo(int posicion,String color)
    {
        String codigo;
        codigo = color.toUpperCase();
        codigoPosible.set(posicion,codigo);
    }
  
    
    //Se introduce los 4 colores del código
    public void introducirCodigo()
    {
       
        int j = 1;
        
        for(int i = 0; i<6; i++)
        {
            
                System.out.println("Introduzca el color " + j + " del código a adivinar: (AZ,RO,VE,AM,BL,NA,MO,RS) ");
                setCodigo(i,scan.next());
                j++;
        
        }
        
        
    }
    
    //concorde al color introducido, la bola se dibujara del color seleccionado en el tablero
   public void colocarBolas()
   {
       
       for(int i = 0; i<codigoPosible.size(); i++)
        {
            switch(codigoPosible.get(i))
            {
               
                case "RO":
                    interfazGrafica.ponerBola(espacio,"red");
                break;
                
                case "AZ":
                    interfazGrafica.ponerBola(espacio,"blue");
                break;
               
                case "AM":
                   interfazGrafica.ponerBola(espacio,"yellow");
                break;
               
                case "VE":
                   interfazGrafica.ponerBola(espacio,"green");
                break;
               
                case "NA":
                   interfazGrafica.ponerBola(espacio,"orange");
                break;
               
                case "BL":
                   interfazGrafica.ponerBola(espacio,"white");
                break;
                
                case "MO":
                   interfazGrafica.ponerBola(espacio,"purple");
                break;
                
                case "RS":
                   interfazGrafica.ponerBola(espacio,"pink");
                break;

               default:
               
               
            }
            espacio++;
        }
       
            intentos++;
    }

       
}