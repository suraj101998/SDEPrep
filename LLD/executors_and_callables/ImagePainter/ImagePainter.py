# Parallel Matrix Painting
# Problem Statement
# You are tasked with creating a Python program that can divide a matrix into quadrants and paint each quadrant with a different color using parallel processing. The program should leverage the concurrent.futures module to achieve parallelism and improve performance.

# Requirements
# The program should include the following components:

# paint_quadrant function:
# Takes a matrix, start and end row indices, start and end column indices, and a color as input.
# Paints the specified quadrant of the matrix with the given color.
# divideandpaint function:
# Takes a matrix and a list of colors as input.
# Divides the matrix into four quadrants (top-left, top-right, bottom-left, bottom-right).
# Utilizes the concurrent.futures.ThreadPoolExecutor to create four separate threads.
# Each thread calls the paint_quadrant function with the corresponding quadrant and color.
# Waits for all threads to complete before returning.
# Example usage:
# Creates a sample 4x4 matrix.
# Calls the divideandpaint function with the matrix and a list of four colors.
# Prints the painted matrix.
# Instructions
# Implement the paint_quadrant function according to the specified requirements.
# Implement the divideandpaint function, which creates a thread pool executor and submits tasks to paint each quadrant in parallel.

import concurrent.futures

def paint_quadrant(matrix, start_row, end_row, start_col, end_col, color):
    """Paints a specific quadrant of the matrix with the given color."""
    for i in range(start_row, end_row):
        for j in range(start_col, end_col):
            matrix[i][j] = color

def divide_and_paint(matrix, colors):
    """Divides the matrix into four quadrants and paints them in parallel."""
    rows, cols = len(matrix), len(matrix[0])
    mid_row, mid_col = rows // 2, cols // 2  # Find midpoints to divide into quadrants

    # Define the quadrants
    quadrants = [
        (0, mid_row, 0, mid_col, colors[0]),  # Top-left
        (0, mid_row, mid_col, cols, colors[1]),  # Top-right
        (mid_row, rows, 0, mid_col, colors[2]),  # Bottom-left
        (mid_row, rows, mid_col, cols, colors[3])  # Bottom-right
    ]

    # Use ThreadPoolExecutor for parallel execution
    with concurrent.futures.ThreadPoolExecutor() as executor:
        futures = [executor.submit(paint_quadrant, matrix, *q) for q in quadrants]
        
        # Wait for all tasks to complete
        concurrent.futures.wait(futures)

# Example usage:
matrix = [[0, 0, 0, 0],
          [0, 0, 0, 0],
          [0, 0, 0, 0],
          [0, 0, 0, 0]]

# Colors assigned to quadrants
colors = ["red", "blue", "green", "yellow"]

# Apply the painting function
divide_and_paint(matrix, colors)

# Print the painted matrix
for row in matrix:
    print(row)
