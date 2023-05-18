package Ejercicio2;

public class Principal {
    
    public static void main(String[]args){
        CasillaLaberinto casilla1=new CasillaLaberinto(1, false, true, false, false);
        CasillaLaberinto casilla2=new CasillaLaberinto(2, true, false, false, true);
        CasillaLaberinto casilla3=new CasillaLaberinto(3, true, true, false, false);
        CasillaLaberinto casilla4=new CasillaLaberinto(4, true, false, false, true);
        CasillaLaberinto casilla5=new CasillaLaberinto(5, false, false, false, false);
        CasillaLaberinto casilla6=new CasillaLaberinto(6, false, true, false, false);
        CasillaLaberinto casilla7=new CasillaLaberinto(7, true, false, true, true);
        CasillaLaberinto casilla8=new CasillaLaberinto(8, false, true, false, true);
        CasillaLaberinto casilla9=new CasillaLaberinto(9, true, false, true, true);
        CasillaLaberinto casilla10=new CasillaLaberinto(10, false, false, false, false);
        CasillaLaberinto casilla11=new CasillaLaberinto(11, false, false, false, false);
        CasillaLaberinto casilla12=new CasillaLaberinto(12, false, true, true, false);
        CasillaLaberinto casilla13=new CasillaLaberinto(13, true, false, true, true);
        CasillaLaberinto casilla14=new CasillaLaberinto(14, false, true, true, false);
        CasillaLaberinto casilla15=new CasillaLaberinto(15, true, false, false, true);
        CasillaLaberinto casilla16=new CasillaLaberinto(16, false, false, false, false);
        CasillaLaberinto casilla17=new CasillaLaberinto(17, true, true, false, true);
        CasillaLaberinto casilla18=new CasillaLaberinto(18, true, true, true, false);
        CasillaLaberinto casilla19=new CasillaLaberinto(19, false, true, false, true);
        CasillaLaberinto casilla20=new CasillaLaberinto(20, false, false, true, false);
        CasillaLaberinto casilla21=new CasillaLaberinto(21, false, false, false, false);
        CasillaLaberinto casilla22=new CasillaLaberinto(22, false, true, true, false);
        CasillaLaberinto casilla23=new CasillaLaberinto(23, true, true, false, false);
        CasillaLaberinto casilla24=new CasillaLaberinto(24, false, false, false, false);
        CasillaLaberinto casilla25=new CasillaLaberinto(25, false, false, false, false);

        CasillaLaberinto[][]laberinto=new CasillaLaberinto[5][5];
        CasillaLaberinto[] casillas = {casilla1, casilla2, casilla3, casilla4, casilla5, casilla6, casilla7, casilla8, casilla9, casilla10, casilla11, casilla12, casilla13, casilla14, casilla15, casilla16, casilla17, casilla18, casilla19, casilla20, casilla21, casilla22, casilla23, casilla24, casilla25};

        int contador = 0;
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                laberinto[i][j] = casillas[contador];
                contador++;
            }
        }

        SalidaLaberinto salidaLaberinto = new SalidaLaberinto(laberinto);

        System.out.println(salidaLaberinto.buscarSalida(1, 24).toString());

    }
}
