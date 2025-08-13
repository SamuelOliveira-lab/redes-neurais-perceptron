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
      
     /* public static double[][][] base = { //ROBÔ
    {{0, 0, 0}, {1, 1}},
    {{0, 0, 1}, {0, 1}},
    {{0, 1, 0}, {1, 0}},
    {{0, 1, 1}, {0, 1}},
    {{1, 0, 0}, {1, 0}},
    {{1, 0, 1}, {1, 0}},
    {{1, 1, 0}, {1, 0}},
    {{1, 1, 1}, {1, 0}}
};*/
    
    public static void main(String[] args) {
         Perceptron rna = new Perceptron(2, 1); // Robô tem 3 entradas e 2 saídas, as outras têm 2 entradas e 1 saída

        for (int epoca = 0; epoca < 10000; epoca++) {
            double erroE = 0;

            for (int amostra = 0; amostra < base.length; amostra++) {
                double[] X = base[amostra][0]; 
                double[] Y = base[amostra][1];

                double[] out = rna.treinar(X, Y); 

                double erroA = 0;
                for (int j = 0; j < Y.length; j++) {
                    erroA += Math.abs(Y[j] - out[j]);
                }

                erroE += erroA;
            }

            System.out.println((epoca+1) + " - " + erroE);
        }
    }
}