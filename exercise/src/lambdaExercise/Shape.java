package lambdaExercise;

import java.util.*;

class SquareMatrixSums {
    public static void main(String[] args) {
        System.out.println("Enter size for NxN array:");
        Scanner scanner = new Scanner(System.in);
        int lenMatrix = Integer.parseInt(scanner.nextLine());
        int[][] squareMatrix = matrixInitialisation(lenMatrix, scanner);
        List<Integer> arr_with_sums = sumOfSquares(squareMatrix);
        System.out.println(lenMatrix + " by " + lenMatrix + " array:");
        for (int[] row : squareMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        arr_with_sums.removeIf(sq_sum -> sq_sum == 0);
        if (arr_with_sums.size() > 2) {
            if (checkMonotonicity(arr_with_sums)) {
                System.out.println("The array with sums " + arr_with_sums + " is monotone");
            } else {
                System.out.println("The array with sums " + arr_with_sums + " is not monotone");
            }
        } else {
            System.out.println("Array " + arr_with_sums + " doesn't have 3 or more elements to check for monotonicity");
        }
    }

    public static int[][] matrixInitialisation(int n, Scanner scanner) {
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(100) + 1;
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
            List<Integer> perfectSquares = new ArrayList<>();
            for (int i = 0; i < lenMatrix - 2; i++) {
                for (int j = startColumn + 1; j < lenMatrix; j++) {
                    if (i < endColumn) {
                        int curr_add = matrix[i][j - 1];
                        perfectSquares.add(curr_add);
                    }
                }
            }
            if (perfectSquares.size() != 1) {
                int sum = 0;
                for (int num : perfectSquares) {
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
        List<Integer> reverseSortedArray = new ArrayList<>(arrayToCheck);
        sortedArray.sort(null);
        reverseSortedArray.sort(Comparator.reverseOrder());
        return arrayToCheck.equals(sortedArray) || arrayToCheck.equals(reverseSortedArray);
    }
}


