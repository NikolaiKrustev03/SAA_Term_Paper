# from random import randint

def get_user_input(prompt):
    while True:
        try:
            user_input = int(input(prompt))
            return user_input
        except ValueError:
            print("Invalid input. Please enter an integer.")


def initialise_matrix(n):
    return [[get_user_input(f"Enter value for row {i + 1}, column {j + 1}: ") for j in range(n)] for i in range(n)]


def sum_of_squares(matrix):
    len_matrix = len(matrix)
    end_column = len_matrix - 2
    start_column = 1
    arr_with_sums = []

    for _ in range(len_matrix - 2):
        perfect_squares = []

        for i in range(len_matrix - 2):
            for j in range(start_column + 1, len_matrix):
                if i < end_column:
                    curr_add = matrix[i][j - 1]
                    perfect_squares.append(curr_add)

        if len(perfect_squares) != 1:
            arr_with_sums.append(sum(perfect_squares))

        end_column -= 1
        start_column += 1

    return arr_with_sums


def check_monotonicity(array_to_check):
    return array_to_check == sorted(array_to_check) or array_to_check == sorted(array_to_check, reverse=True)


len_matrix = int(input("Enter the size of NxN array: "))
square_matrix = initialise_matrix(len_matrix)

arr_with_sums = sum_of_squares(square_matrix)

print(f"{len_matrix} by {len_matrix} array:")
for row in square_matrix:
    print(row)

arr_with_sums = [sq_sum for sq_sum in arr_with_sums if sq_sum != 0]

if len(arr_with_sums) >= 2:
    if check_monotonicity(arr_with_sums):
        print(f"The array with sums {arr_with_sums} is monotone")
    else:
        print(f"The array with sums {arr_with_sums} is not monotone")
else:
    print(f"Array {arr_with_sums} doesn't have 2 or more elements to check for monotonicity")
