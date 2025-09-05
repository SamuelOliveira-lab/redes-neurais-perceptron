package rnamain;


public class RnaMain {

    public static double[][][] base = { //AND
        {{0, 0}, {0}},
        {{0, 1}, {0}},
        {{1, 0}, {0}},
        {{1, 1}, {1}}
    }; 

      /*public static double[][][] base = { //OR
        {{0, 0}, {0}},
        {{0, 1}, {1}},
        {{1, 0}, {1}},
        {{1, 1}, {1}}
    };*/
      
    /* public static double[][][] base = { //XOR
        {{0, 0}, {0}},
        {{0, 1}, {1}},
        {{1, 0}, {1}},
        {{1, 1}, {0}}
    };*/
      
     /*   public static double[][][] base = { //ROBÔ
    {{0, 0, 0}, {1, 1}},
    {{0, 0, 1}, {0, 1}},
    {{0, 1, 0}, {1, 0}},
    {{0, 1, 1}, {0, 1}},
    {{1, 0, 0}, {1, 0}},
    {{1, 0, 1}, {1, 0}},
    {{1, 1, 0}, {1, 0}},
    {{1, 1, 1}, {1, 0}}
};*/
    public static void main(String[] args) throws Exception {

        int entradas = base[0][0].length;
        int saidas = base[0][1].length;

        Perceptron rna = new Perceptron(entradas, saidas);

        for (int epoca = 0; epoca < 100; epoca++) { 
            double erroAproximacaoEpoca = 0;
            double erroClassificacaoEpoca = 0;

            for (int amostra = 0; amostra < base.length; amostra++) {
                double[] X = base[amostra][0];
                double[] Y = base[amostra][1];

                double[] out = rna.treinar(X, Y);

               
                double erroAmostra = 0;
                for (int i = 0; i < Y.length; i++) {
                    erroAmostra += Math.abs(Y[i] - out[i]);
                }
                erroAproximacaoEpoca += erroAmostra;

                
                double[] outBin = new double[out.length];
                for (int i = 0; i < out.length; i++) {
                    outBin[i] = (out[i] >= 0.5) ? 1.0 : 0.0;
                }

              
                int erroClassifAmostra = 0;
                for (int i = 0; i < Y.length; i++) {
                    if (Math.abs(Y[i] - outBin[i]) > 0) {
                        erroClassifAmostra = 1;
                        break;
                    }
                }
                erroClassificacaoEpoca += erroClassifAmostra;
            }

            
            System.out.println((epoca + 1) + " - "
                    + erroAproximacaoEpoca + " - "
                    + erroClassificacaoEpoca);
        }
    }
}