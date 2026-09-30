package TP4Logo;

import javax.swing.*;

public class Sucrerie extends Accessoire {

    public Sucrerie(Logo logo) {
        super(logo);
    }

    @Override
    public double CombienCaCoute() {
        return 0.8 + this.logo.CombienCaCoute();
    }

    @Override
    public MyImage getLogo(){
        MyImage logo = this.logo.getLogo();
        logo.paintOver("img/Candy.png",441, 202);
        return logo;
    }
}
