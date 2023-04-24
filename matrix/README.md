# Matrix Library

A Matrix library that implements the following API:

| public class Matrix                                |                       |
| -------------------------------------------------- | --------------------- |
| static double dot(double[] x, double[] y)          | vector dot product    |
| static double[][] mult(double[][] a, double[][] b) | matrix-matrix product |
| static double[][] transpose(double[][] a)          | transpose             |
| static double[] mult(double[][] a, double[] x)     | matrix-vector product |
| static double[] mult(double[] y, double[][] a)     | vector-matrix product |

And test client that tests all the methods.
