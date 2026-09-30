package TP4;

public class PrincipalCafe {
    public static void main(String[] args) {
        Boisson boisson = new BoissonChantilly(new BoissonChantilly(new BoissonCreme(new Deca())));
        System.out.println(boisson);
    }
}
