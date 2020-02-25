package inf112.skeleton.app.utilities;

import java.io.*;
import java.util.Scanner;

public class CsvReader {
    private int[][] boardids;

    public CsvReader(String filename) throws FileNotFoundException{ 
        File file = new File(filename);
        Scanner scan = new Scanner(file);

        String numLine = scan.nextLine();
        final int n = Integer.parseInt(numLine.split(",")[0]);
        final int m = Integer.parseInt(numLine.split(",")[1]);

        //Allocate arrays with length n
        boardids = new int[n][m];
        
        int y = 0;
        while(scan.hasNext()){
            String[] inputArr = scan.nextLine().split(",");
            for (int x = 0; x < n; x++) {
				boardids[y][x] = Integer.parseInt(inputArr[x]);
			}
            if (y >= m) break;
            y++;
        }
        scan.close();
    }

    public int[][] getBoardIds(){
        return this.boardids;
    }
}
