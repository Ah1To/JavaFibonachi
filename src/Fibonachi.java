import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fibonachi {
    public static void main(String[] args){


        Scanner in = new Scanner(System.in);
        System.out.println("Enter max Fibonachi number");
        int endNumber = Integer.parseInt(in.next());


        ArrayList<Integer> fibList = new ArrayList<>();

        for(int i = 1; i < endNumber + 1; i++ ){
            fibList.add(Fib(i));
        }

        printFib(fibList);

        System.out.println("\nWrite in file?");
        String write = in.next();


        if(write.toLowerCase().equals("y") ){
            System.out.println("write file path");
            write = in.next();
            File pathToWrite = new File(write);
            try(BufferedWriter br = new BufferedWriter(new FileWriter(pathToWrite))){
                writeInFile(br, fibList);

            }
            catch (Exception e){

            }

        }


    }

    static void writeInFile(BufferedWriter br, ArrayList<Integer> fibList) throws IOException {
        for (int i=0; i < 3; i++){
            if (i > 0) br.write("\n");
            for(int j = 0; j < fibList.size(); j++) {
                switch(i){
                    case 0: br.write(String.format("%d ", fibList.get(j)));
                        break;
                    case 1: br.write(String.format("%s ", Integer.toBinaryString(fibList.get(j))));
                        break;
                    case 2: br.write(String.format("0x%02x ", fibList.get(j)));

                }
            }
        }

    }

    static void printFib(ArrayList<Integer> fibList ){
        for (int i=0; i < 3; i++){
            if (i > 0) System.out.println();
            for(int j = 0; j < fibList.size(); j++) {
                switch(i){
                    case 0: System.out.print(String.format("%d ", fibList.get(j)));
                        break;
                    case 1: System.out.print(String.format("%s ", Integer.toBinaryString(fibList.get(j))));
                        break;
                    case 2: System.out.print(String.format("0x%02x ", fibList.get(j)));

                }
            }
        }
    }

    static int Fib(int i){
        if (i < 1) return 0;
        if(i == 1) return 1;

        return Fib(i-1) + Fib(i-2);
    }

}
