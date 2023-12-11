package coursework;

import java.util.*;

public class SquareMatrixSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size for NxN matrix");
        int lenMatrix = Integer.parseInt(scanner.nextLine());
        int[][] squareMatrix = matrixInitialisation(lenMatrix, scanner);
        List<Integer> arrWithSums = sumOfSquares(squareMatrix);
        System.out.println(lenMatrix + " by " + lenMatrix + " array:");
        for (int[] row : squareMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        if (arrWithSums.size() >= 3) {
            if (checkMonotonicity(arrWithSums)) {
                System.out.println("The array with sums " + arrWithSums + " is monotone");
            } else {
                System.out.println("The array with sums " + arrWithSums + " is not monotone");
            }
        } else {
            System.out.println("Array " + arrWithSums + " doesn't have 3 or more elements to check for monotonicity");
        }
    }

    public static int[][] matrixInitialisation(int n, Scanner scanner) {
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /*boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Enter value for row " + (i + 1) + ", column " + (j + 1) + ": ");
                        String input = scanner.nextLine();
                        matrix[i][j] = Integer.parseInt(input);
                        validInput = true; // If no exception is thrown, the input is valid
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                    }
                }*/
                matrix[i][j] = random.nextInt(-100, 100);
            }
        }
        return matrix;
    }

    public static List<Integer> sumOfSquares(int[][] matrix) {
        int lenMatrix = matrix.length;
        int endColumn = lenMatrix - 2;
        int startColumn = 1;
        List<Integer> arr_with_sums = new ArrayList<>();
        for (int k = 0; k < lenMatrix - 2; k++) {
            List<Integer> perfect_squares = new ArrayList<>();
            for (int i = 0; i < lenMatrix - 2; i++) {
                for (int j = startColumn + 1; j < lenMatrix; j++) {
                    if (i < endColumn) {
                        int curr_add = matrix[i][j - 1];
                        perfect_squares.add(curr_add);
                    }
                }
            }
            if (perfect_squares.size() > 1) {
                int sum = 0;
                for (int num : perfect_squares) {
                    sum += num;
                }
                arr_with_sums.add(sum);
            }
            endColumn -= 1;
            startColumn += 1;
        }
        return arr_with_sums;
    }

    public static boolean checkMonotonicity(List<Integer> arrayToCheck) {
        List<Integer> sortedArray = new ArrayList<>(arrayToCheck);
        Collections.sort(sortedArray);

        List<Integer> reverseSortedArray = new ArrayList<>(arrayToCheck);
        reverseSortedArray.sort(Comparator.reverseOrder());

        return arrayToCheck.equals(sortedArray) || arrayToCheck.equals(reverseSortedArray);
    }
}