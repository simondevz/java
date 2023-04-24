import java.util.Arrays;

public class Matrix {
    static double dot(double[] x, double[] y) {
        /* 
        Steps to dot product
        - multiply each value with its coresponding value
          on the other vector, i.e 1st by 1st, 2nd by 2nd so on
        - add all the products.
        */  
        
        int len = (x.length >= y.length) ? x.length : y.length;
        double dotProduct = 0.00;
        
        for (int i = 0; i < len; i++) {
            double a = (i >= x.length) ? 0.00 : x[i];
            double b = (i >= y.length) ? 0.00 : y[i];
            
            dotProduct += a * b;
        }
        
        return dotProduct;
    }
    
    static double[][] mult(double[][] a, double[][] b) {
        /*
        Steps to multiply Matrixes
        - dot product of each column of the second and every row
          of the first matrix i.e 1st row by 1st column, 2nd row by 1st column
          and so on 
        - the dot product becomes the content of the new matrix aligning them
          selves according to what row and column was multiplied to get them
        - Rule to multiply matrix row of first must equal column of second
        */
        
        //if (a.length != b[0].length) return;
        double[][] product = new double[a.length][b[0].length];
        
        for (int i = 0; i < b[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    product[j][i] += a[j][k] * b[k][i];
                }
            }
        }
        
        return product;
    }
    
    static double[][] transpose(double[][] a) {
        /*
        Steps to transpose a matrix
        - basically just make rows columns
        note that the transpose of an M by N matrix
        is an N by M matrix
        */
        
        double[][] b = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[j][i] = a[i][j];
            }
        }
        return b;
    }
    
    static double[] mult(double[][] a, double[] x) {
        double[] b = new double[a.length];
        
        for (int i = 0; i < a.length; i++) {
            b[i] = dot(a[i], x);
        }
        return b;
    }
    
    static double[] mult(double[] y, double[][] a) {
        double[] x = new double[a[0].length];
        
        for (int i = 0; i < a[0].length; i++)
            for (int j = 0; j < y.length; j++) {
                x[i] += y[j] * a[j][i];
            }
        return x;
    }
    
    public static void main(String[] args) {
        double[] w = {1, 5, 9};
        double[] x = {1, -2};
        double[][] y = {{2, 3, 9}, {-5, 6, -7}};
        double[][] z = {{8, 4}, {16, 8}, {9, 4}};
        
        double a = dot(w, x);
        double[] b = mult(w, z);
        double[] c = mult(y, w);
        double[][] d = mult(y, z);
        double[][] e = transpose(z);
        
        double f = -9.0;
        double[] g = {169.0, 80.0};
        double[] h = {98.0, -38.0};
        double[][] i = {{145, 68}, {-7, 0}};
        double[][] j = {{8, 16, 9}, {4, 8, 4}};
        
        assert a == f : "dot product failed";
        assert Arrays.equals(b, g) : "vector matrix multiplication failed";
        assert Arrays.equals(c, h) : "matrix vector multiplication failed";
        assert Arrays.deepEquals(d, i) : "matrix matrix multiplication failed";
        assert Arrays.deepEquals(e, j) : "transpose failed";
    }
}