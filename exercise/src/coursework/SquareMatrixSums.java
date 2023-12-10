package coursework;

import java.util.*;

public class SquareMatrixSums {
    public static void main(String[] args) {

    }


    public static int[][] matrixInitialisation(int n, Scanner scanner) {
        int[][] matrix = new int[n][n];

        System.out.println("Enter size for NxN array");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter number on position [" + (i + 1) + "] [" + (j + 1) + "] : ");
                matrix[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        return matrix;
    }

    public static List<Integer> sumOfSuares(int[][] matrix) {
        int len_matrix = matrix.length;
        int end_column = len_matrix - 2;
        int start_column = 1;
        List<Integer> arr_with_sums = new ArrayList<>();
        for (int k = 0; k < len_matrix - 2; k++) {
            List<Integer> perfect_squares = new ArrayList<>();
            for (int i = 0; i < len_matrix - 2; i++) {
                for (int j = start_column + 1; j < len_matrix; j++) {
                    if (i < end_column) {
                        int curr_add = matrix[i][j - 1];
                        perfect_squares.add(curr_add);
                    }
                }
            }
            if (perfect_squares.size() != 1) {
                int sum = 0;
                for (int num : perfect_squares) {
                    sum += num;
                }
                arr_with_sums.add(sum);
            }
            end_column -= 1;
            start_column += 1;
        }
        return arr_with_sums;
    }
}

