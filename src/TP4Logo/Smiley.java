package TP4Logo;

public class Smiley extends Accessoire{

    public Smiley(Logo logo) {
        super(logo);
    }

    @Override
    public double CombienCaCoute(){
        return 1.3 + this.logo.CombienCaCoute();
    }

    @Override
    public MyImage getLogo() {
        MyImage logo = this.logo.getLogo();
        logo.paintOver("img/Smiley.png",260, 210);
        return logo;
    }
}
