from collections import deque

class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        #* Idea: We can use DFS to search the board (flood-fill algorithm). A slight change is that,
        #* we will only care about region with NO cell on the edge (i.e. (i, j) where i = 0 or m-1 or 
        #* j = 0 or n-1). We can achieve this by using a boolean.
        def edge_cell(i, j, m, n):
            """
            Check if the cell is an edge cell
            """
            return (i == 0 or i == m-1) or  (j == 0 or j == n-1)
        
        def mod_dfs(board: list[list[str]], m: int, n: int, s: tuple[int, int], visited: dict[tuple, None]):
            """
            DFS from s in graph "board". visited is a map which keeps track of visited maps.
            Return a SURROUNDED region. If not surrounded, return None  
            """
            surround = True 
            stack = deque()
            stack.append(s)  # s is an iterable so we have to add after initialization
            region = []
            while len(stack) != 0:
                x = stack.pop()
                i, j = x
                if surround and edge_cell(i, j, m, n):
                    surround = False
                visited[x] = None
                region.append(x)
                # There are only 4 neighbors at most (i-1,j), (i,j-1), (i+1,j), (i,j+1)
                if i-1 >= 0 and (i-1, j) not in visited and board[i-1][j] == 'O':
                    stack.append((i-1, j))
                if i+1 < m and (i+1, j) not in visited and board[i+1][j] == 'O':
                    stack.append((i+1, j))
                if j-1 >= 0 and (i, j-1) not in visited and board[i][j-1] == 'O':
                    stack.append((i, j-1))
                if j+1 < n and (i, j+1) not in visited and board[i][j+1] == 'O':
                    stack.append((i, j+1))
            
            # Modify the region if surrounded
            if surround:
                for point in region:
                    board[point[0]][point[1]] = 'X'
            
        # Keep track of visited cells
        visited = {(0, 0): None}
        # DFS over the entire graph/board
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                if (i, j) not in visited and board[i][j] == 'O':
                    mod_dfs(board, m, n, (i, j), visited)
        
    def solve2(self, board):
        #* Idea 2: The key observation is that we need to modify the board, not returning surrounded regions 
        #* We'll search for all non-surrounded regions (DFS from 'O' that are edge cells)
        #* While DFS, we mark 'O' with 'C' (or essentially any character that is not 'X' and 'O').
        #* Then we simply loop through all cells, change 'C' back to 'O' and 'O' to 'X.'
        #* One major observation is that if we mark an 'O' to a 'C', it's visited. Then we don't
        #* need any sort of "visited" map
        if len(board) == 0:
            return
        
        m, n = len(board), len(board[0])
        def dfs(i, j):
            # Out of bounds or visited (or not of interest)
            if i < 0 or i > m-1 or j < 0 or j > n-1 or board[i][j] != "O":
                return
            board[i][j] = 'C'  # Mark the cell as visited (and belongs to a non-surrounded region)
            # Recursively exploring
            dfs(i-1, j)
            dfs(i+1, j)
            dfs(i, j-1)
            dfs(i, j+1)
        
        # DFS starts from all edge cells
        for i in range(m):
            dfs(i, 0)
            dfs(i, n-1)
        for j in range(n):
            dfs(0, j)
            dfs(m-1, j)
        
        # Modify cells if needed
        for i in range(m):
            for j in range(n):
                # This cell belongs to some surrounded region
                if board[i][j] == 'O':
                    board[i][j] = 'X' 
                # This cell belongs to some non-surrounded region
                if board[i][j] == 'C':
                    board[i][j] = 'O'