/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magictest;
import java.util.Scanner;
/**
 *
 * @author Tan
 */
public class MagicTest {
 
   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int key =1;
        while(key==1)
        {
        System.out.println("Please enter the magic square of order:");
        int n;
        n=sc.nextInt();
        Magic m=new Magic(n);
        m.printMagic();
        System.out.println("Continue please enter 1,or else enter 0:");
        key=sc.nextInt();
        }
    } 
}
