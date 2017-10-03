/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magictest;

/**
 *
 * @author Tan
 */
public class Magic {
    private int n;
    private int[][] I;
    private int[][] J;
    
    public Magic(int n) {
        this.n = n;
    }
    public int[][] getMagic(){
        int[][] M=null;
        if(n<=2)return M;
        if(n%2==1){
            meshGrid();
            M=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++){
                    int a=mod(I[i][j]+J[i][j]-(n+3)/2,n);
                    int b=mod(I[i][j]+2*J[i][j]-2,n);
                    M[i][j]=n*a+b+1;
                }
        }
        else if(n%4==0){
            meshGrid();
            M=reshape();
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++){
                    int a=(int)Math.floor(mod(I[i][j],4)/2.0);
                    int b=(int)Math.floor(mod(J[i][j],4)/2.0);
                    if(a==b){
                        M[i][j]=n*n+1-M[i][j];
                    }
                }
        }
        else{
            int p=n/2;
            Magic magic=new Magic(p);
            int[][] temp=magic.getMagic();
            M=new int[n][n];
            for(int i=0;i<p;i++){
                for(int j=0;j<p;j++){
                    M[i][j]=temp[i][j];
                    M[i][j+p]=temp[i][j]+2*p*p;
                    M[i+p][j]=temp[i][j]+3*p*p;
                    M[i+p][j+p]=temp[i][j]+p*p;
                }
            }
            int k=(n-2)/4;
            for(int j=0;j<k;j++){
                for(int i=0;i<p;i++){
                    int t=M[i][j];
                    M[i][j]=M[i+p][j];
                    M[i+p][j]=t;
                }
            }
            for(int j=n-k+1;j<n;j++){
                for(int i=0;i<p;i++){
                    int t=M[i][j];
                    M[i][j]=M[i+p][j];
                    M[i+p][j]=t;
                }
            }
            int t=M[k][0];M[k][0]=M[k+p][0];M[k+p][0]=t;
            t=M[k][k];M[k][k]=M[k+p][k];M[k+p][k]=t;
        }
        return M;
    }
    private void meshGrid(){
        if(n>2){
            I=new int[n][n];
            J=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++){
                    I[i][j]=i+1;
                    J[i][j]=j+1;
                }
        }
    }
    private int[][] reshape(){
        if(n>2){
            int[][] M=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++){
                    M[i][j]=i*n+j+1;
                }
            return M;
        }
        return null;
    }
    private int mod(int a,int n){
        int m=a%n;
        if(m<0)
            m+=n;
        return m;
    }
    public void printMagic(){
        this.getMagic();
        int[][] a=this.getMagic();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}