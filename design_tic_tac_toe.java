Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|









class TicTacToe {
    
    int[] rowcount;// to keep row count
        int[] colcount ;// to keep col count
        int diag;
        int antidiag;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        
        rowcount = new int[n];// to keep row count
        colcount = new int[n];// to keep col count
        diag = 0;
        antidiag = 0;
        
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        int toadd = player == 1 ? 1:-1;// keep count for player1 as 1 and for player 2 as -1
        
        rowcount[row] = rowcount[row] + toadd;// add the corresponing player for the respective rows
        colcount[col] = colcount[col] + toadd;
        
        if(row == col){// then its a diagonal
            diag = diag + toadd;
            
        }
        
        if(col == (rowcount.length -1) - row){ // then it is a anti diagonal
            
            antidiag = antidiag + toadd;
            
        }
        int n = rowcount.length;// it is just the max size of the matrix
        if(Math.abs(rowcount[row] ) == n ||Math.abs(colcount[col]) == n || Math.abs(diag) == n || Math.abs(antidiag) == n){
            return player;// return player who is responsible for the last winning move
            
        }
        
        return 0;// no one wins
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */