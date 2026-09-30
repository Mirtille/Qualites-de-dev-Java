package TP4Logo;



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
        */
        Logo monLogo = new Lunette(new Chapeau(new ReneLaTaupe()));
        monLogo.getLogo().display();
        System.out.println("Prix total : " + monLogo.CombienCaCoute() + " €");
        
        
    }
        
}
