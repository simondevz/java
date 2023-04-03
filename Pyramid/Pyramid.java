import java.util.Scanner;

class Pyramid {
    public static void main(String[] args) {
        // Ask for a number
        System.out.print("How many layers? ");
        int layers = 0;
        
        // If input is invalid keep asking till it is valid
        do {
            try {
                // Reads the number
                Scanner scanner = new Scanner(System.in);
                layers = scanner.nextInt();
                
                // If it is less than 0 throw error else break
                if (layers <= 0) {
                    throw new Exception();
                } else {
                    scanner.close();
                    break;
                }
                
            } catch(Exception e) {
                System.out.print("Input a number more than 0: ");
            }
        } while (true);
        
        // Loops through to print pyramid
        for (int i=layers; i >= 1; i--) {
            for (int j=0; j <= layers ; j++ ) {
                if (j < i) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.print(" ");
            
            for (int k=layers; k >= 0 ; k-- ) {
                if (k < i) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.print("\n");
        }
    }
} 