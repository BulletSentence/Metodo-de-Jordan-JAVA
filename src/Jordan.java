import java.text.DecimalFormat;

public class Jordan {

    private double[][] aMatriz;

    public Jordan(double[][] matrix) {
        aMatriz = matrix;
    }

    public void calculaMatriz() {
        int iniColuna = 0;
        for (int lin = 0; lin < aMatriz.length; lin++) {

            //Se o numero do Inicio da Coluna for zero, ele passa pra outro
            while (aMatriz[lin][iniColuna] == 0){
                boolean ehZero = false;
                int i=lin;

                // enquanto não for zero e as linhas forem menor que amatriz
                while (!ehZero && i < aMatriz.length) {
                    if(aMatriz[i][iniColuna]!=0.0){
                        double[] temp = aMatriz[i];
                        aMatriz[i]= aMatriz[lin];
                        aMatriz[lin]=temp;
                        ehZero = true;
                    }
                    i++;
                }

                //Se o proximo numero também for zero
                if (aMatriz[lin][iniColuna] == 0) {
                    iniColuna++;
                }
            }
            //Reduz o numero para um (Diag principal)
            if(aMatriz[lin][iniColuna]!=1.0) {
                double divisor = aMatriz[lin][iniColuna];
                for (int i = iniColuna; i< aMatriz[lin].length; i++) {
                    aMatriz[lin][i] = aMatriz[lin][i]/divisor;
                }
            }

            //Verifica se são zeros da diagonal principal e diagonal baixa
            for (int i = 0; i< aMatriz.length; i++) {
                if (i!=lin && aMatriz[i][iniColuna]!= 0) {
                    double multiplicacao = 0 - aMatriz[i][iniColuna];
                    for (int j = iniColuna; j< aMatriz[lin].length; j++){
                        aMatriz[i][j] +=
                                multiplicacao* aMatriz[lin][j];
                    }
                }
            }
            iniColuna++;
        }
    }


    public String toString() {
        String valorfinal = "";
        for (int i = 0; i< aMatriz.length; i++) {
            for (int j = 0; j < aMatriz[i].length; j++) {
                valorfinal += aMatriz[i][j] + " | ";
            }
            valorfinal += "\n";
        }
        return valorfinal;
    }
}