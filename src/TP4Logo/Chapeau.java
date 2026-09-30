package TP4Logo;

public class Chapeau extends Accessoire{

    public Chapeau(Logo logo){
        super(logo);
    }

    @Override
    public MyImage getLogo() {
        MyImage img = this.logo.getLogo();
        img.paintOver("img/Chapeau.png", 280, 42);
        return img;
    }

    @Override
    public double CombienCaCoute(){
        return 1.5 + this.logo.CombienCaCoute();
    }
}
