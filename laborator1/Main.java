package com.company;
import java.util.Scanner;
import java.lang.*;

public class Main {
    public static int[] viz=new int[50000];
    public static void matrix(int[][] array,int n){
        int i,j;
        for(i=0;i<n;i++)
            for(j=0;j<i;j++) {
                array[i][j] = (int) ((Math.random() * 10) % 2);
                array[j][i] = array[i][j];
            }
    }
    public static void afisare(int[][] array,int n){
        int i,j;
        for(i=0;i<n;i++) {
            for (j = 0; j < n; j++)
                System.out.print(array[i][j]+" ");
            System.out.println();
        }
    }
    public static void BFS(int[][] array,int n,int k,int nrComp){
        int[] c=new int[n];
        int p,u,x,i;
        p=0;
        u=0;
        c[p]=k;
        viz[k]=nrComp;
        while(p<=u){
            x=c[p++];
            for(i=0;i<n;i++){
                if(array[x][i]==1 && viz[i]==0){
                    c[++u]=i;
                    viz[i]=nrComp;
                }
            }
        }
    }
    public static int isConnected(int[][] array,int n){
        int i,k=0;
        for(i=0;i<n;i++)
            if(viz[i]==0) {
                k++;
                BFS(array, n, i,k);
            }
        return k;
    }
    public static void afisareComponenteConexe(int[] array,int n,int k) {
        int i, ok;
        ok = 0;
        for (i = 0; i < n; i++)
            if (array[i] == k){
                if (ok == 0)
                    System.out.print(i);
                else
                    System.out.print("," + i);
            ok=1;
            }
        System.out.println();
    }
    public static void partialTree(int[][] array,int n,int x){
        int i,p,u;
        int[] c=new int[n];
        int[] vizitat=new int[n];
        p=0;u=0;
        c[p]=x;
        vizitat[x]=1;
        int[][] matriceAdiacenta=new int[n][n];
        while(p<=u){
            x=c[p++];
            for(i=0;i<n;i++)
                if(array[x][i]==1 && vizitat[i]==0){
                    c[++u]=i;
                    matriceAdiacenta[x][i]=1;
                    matriceAdiacenta[i][x]=1;
                    vizitat[i]=1;
                }
        }
        System.out.println("arbore Partial:");
        afisare(matriceAdiacenta,n);
    }
    public static int x=0,maxim=0;
       public static void arbore(int level){
        int n,m,next;
        n=8;
        m=4;
        maxim++;
        for(int i=0;i<level;i++)
            System.out.print("  ");
        System.out.println("node"+x);
        if(maxim<n){
            next= (int) ((Math.random() * 10) % m);
            int ok=0;
            while(next>0){
                if(ok==0){
                    level++;
                    ok=1;
                }
                x++;
                arbore(level);
                next--;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("hello");
        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n;
        n = (int) (Math.random() * 1_000_000);

        n*=3;
        String binary="10101";
        int decimal=Integer.parseInt(binary,2);
        n+=decimal;

        String hex="FF";
        decimal=Integer.parseInt(hex,16);
        n+=decimal;

        n*=6;
        int result=0;
        while(n>9){
            result=0;
            while(n!=0){
                result+=n%10;
                n/=10;
            }
            n=result;
        }
        System.out.println( "Willy-nilly, this semester I will learn " + languages[result]);

        //optional
        long timpInitial = System.nanoTime();
        int m,i;
        Scanner in = new Scanner(System.in);
        if(args.length>0)
            m=Integer.parseInt(args[0]);
        else
            m = Integer.parseInt(in.nextLine());
        if(m%2==0)
            System.out.println("Inputul trebuie sa fie nr impar");
        else{
            int[][] matrice=new int[m][m];
            matrix(matrice,m);
            afisare(matrice,m);
            for(i=0;i<n;i++)
                viz[i]=0;
            int ok=isConnected(matrice,m);
            if(ok==1) {
                System.out.println("Graf conex");
                partialTree(matrice,m,0);
            }
            else{
                System.out.println("Graf neconex.Componente conexe:");
                for(i=1;i<=ok;i++){
                    System.out.print(i+":");
                    afisareComponenteConexe(viz,m,i);
                }
            }
        }
        long timpFinal = System.nanoTime();
        System.out.println("Durata rulare program: " + (timpFinal-timpInitial) + " nanosecunde");
        //Bonus
        System.out.println("Bonus:");
        arbore(0);
    }
}
