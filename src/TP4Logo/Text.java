package TP4Logo;

public class Text extends Accessoire{

    private String texte;
    private int x;
    private int y;

    public Text(Logo logo, String texte){
        super(logo);
        this.texte = texte;
        this.x = 260;
        this.y = 210;
    }

    public Text(Logo logo, String texte, int x, int y) {
        super(logo);
        this.texte = texte;
        this.x = x;
        this.y = y;
    }

    @Override
    public double CombienCaCoute(){
        return 1 + this.logo.CombienCaCoute();
    }

    @Override
    public MyImage getLogo() {
        MyImage logo = this.logo.getLogo();
        logo.textOver(this.texte, this.x, this.y);
        return logo;
    }
}
