package com.company;
import java.lang.Math;
public class Problem {
    private int[][] matrix;
    private int n,m;
    public Problem(int n,int m) {
        matrix = new int[n+1][m+1];
        this.n=n+1;
        this.m=m+1;
    }
    public void buildMatrix(int[]x,int[]y){
        int i,j;
        for(i=0;i<n-1;i++)
            for(j=0;j<n-1;j++) {
                double rand = Math.random();
                matrix[i][j] = (int) (rand * 9 +1);
            }
        for(i=0;i<n-1;i++){
            matrix[n-1][i]=y[i];
            matrix[i][m-1]=x[i];
        }
    }
    public void afisareMatrix() {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
    private static int big()
    public void rezolvare(){
        int ok=1,i,j;
        while(ok==1){
            for(i=0;i<n-1;i++)
                if(matrix[i][m-1]!=0){
                    for(j=0;j<m-1;j++)
                        if(matrix[n-1][j]!=0){

                        }
                }
        }
    }
}
