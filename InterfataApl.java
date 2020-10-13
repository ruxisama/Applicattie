package aplicatiePachet;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public interface InterfataApl {

    public static void main(String[] args) throws IOException {

        
       
        Scanner incomanda = new Scanner(System.in);
        System.out.println("Introduceti comanda: ");

        boolean continuare = true;

        while (continuare) {

            File cale = new File("C:\\");

           
            String comanda = incomanda.nextLine();

            switch (comanda) {
                case "list":

                    metode.getlist();

                    break;
                case "info":
                    

                    metode.getinfo();
                    
            
                    break;
                    
            
        
    

                case "create_dir":
   
                    
                    metode.createdir();



                    break;
                case "rename":
 
                    metode.rename();

                    break;
                
                
        
                case "copy":
                
                    metode.copy();

                    
                 
               
                    break;
                case "move":
                
                    metode.move();

                 
               
                    break;
                case "delete":

                   
                   metode.delete();
                    

                    break;
                case "exit":
                    
                    System.out.println("Iesire din program");

                    continuare = false;

                    break;
                   
                

            default:
                 
                 System.out.println("Optiunea " + comanda + " nu exista");        
                     
               
                
                
 }}

  
        
        
          
        
    }


}
