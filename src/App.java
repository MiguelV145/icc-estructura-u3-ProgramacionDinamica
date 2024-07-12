import java.util.HashMap;
import java.util.Map;

import Ejercicios.contorllers.Laberinto;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Programación Dinámica");

        long startime, endtime = 0;
        startime = System.nanoTime();
        System.out.println(fibonacci(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");
        System.out.println("Time taken: " + (endtime - startime)/1_000_000_000.0 + " s");


        System.out.println("------------ \n fibonacciithCaching");
        startime = System.nanoTime();
        System.out.println(fibonacciWithCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");
        System.out.println("Time taken: " + (endtime - startime)/1_000_000_000.0 + " s");

        System.out.println("------------ \n fibonacciCaching");
        startime = System.nanoTime();
        System.out.println(fibonacciCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");
        System.out.println("Time taken: " + (endtime - startime)/1_000_000_000.0 + " s");
        /// Ejericio 1
        runEjercicio();

    }

    // Normal recursive method
    public static int fibonacci(int n) {
        if(n <=1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // First caching method: Using a Map

    private static Map<Integer, Integer> cachMap= new HashMap<>();
    public static int fibonacciWithCaching(int n) {
        if (n<=1){
            return n;
        }
        //Revisar en nuestro cach si ya se calculo 
        if(cachMap.containsKey(n)){
            return cachMap.get(n);
        }

        int result=fibonacciWithCaching(n-1)+fibonacciWithCaching(n-2);
        cachMap.put(n, result);
        return result;


    }

    // Second caching method: Using an array
    public static int fibonacciCaching(int n) {
        int[] cache = new int[n+1];
        return fibonacciArregloV(n,cache);
    } 

    private static int fibonacciArregloV(int n, int[] cache) {
      if (n<= 1){
        return n;
      }

      if (cache[n] !=0){
        return cache[n];
      }
      cache[n]= fibonacciArregloV(n-1,cache)+fibonacciArregloV(n-2,cache);
      return cache[n];
    }

    public static void runEjercicio() {

        Laberinto lab= new Laberinto();
        boolean[][] grid = {
        { true, true, true, true },
        { false, false, false, true },
        { true, true, false, true },
        { true, true, false, true }
        };


        System.out.println(lab.getPath(grid));

    }
}
