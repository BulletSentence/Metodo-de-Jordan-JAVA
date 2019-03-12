
public class EntradaMain {

    public static void main(String[] args) {
        double[][] sl = {
            {1,1,2,4},
            {2,-1,-1,0},
            {1,-1,-1,-1}
        };

        Jordan sistemaLinear = new Jordan(sl);
        sistemaLinear.calculaMatriz();
        System.out.println(sistemaLinear);
    }
}

