package TP4Logo;

public class Lunette extends Accessoire{

    public Lunette(Logo logo){
        super(logo);
    }

    @Override
    public double CombienCaCoute(){
        return 1.7 + this.logo.CombienCaCoute();
    }

    @Override
    public MyImage getLogo(){
        MyImage logo = this.logo.getLogo();
        logo.paintOver("img/Sunglasses.png",255, 76);
        return logo;
    }
}
