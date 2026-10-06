package TP4Logo;


import java.util.Scanner;

public class Main
{
   
    public static void main(String args[])
    {
        /*
        ReneLaTaupe l = new ReneLaTaupe();
        MyImage i = l.getLogo(); 
        
        i.paintOver("img/Chapeau.png", 280,42);
        i.paintOver("img/Sunglasses.png", 255,76);
        i.display();  // Permet l'affichage dans une fenetre de l'image associee

        Logo rene = new Lunette(new Chapeau(new ReneLaTaupe()));
        rene.getLogo().display();
        System.out.println("Prix total : " + rene.CombienCaCoute() + " €");

        Logo frog = new Lunette(new Chapeau(new CrazyFrog()));
        frog.getLogo().display();
        System.out.println("Prix total : " + frog.CombienCaCoute() + " €");
*/
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez votre texte pour le logo : ");
        String texteSaisi = sc.nextLine();

        Logo monLogo = new Text(new Lunette(new Chapeau(new ReneLaTaupe())), texteSaisi);
        monLogo.getLogo().display();
        System.out.println("Prix : " + monLogo.CombienCaCoute() + " €");
    }
        
}
