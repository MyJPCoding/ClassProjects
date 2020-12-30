import java.util.Arrays;

public class Basics{
    public int[] counter(){
        int[] arr = {0};
        for (int i=1; i<255; i++){
            System.out.println(i);
            arr = new int[i+1];
        }

        return arr;

    }

    public int[] oddcounter(){
        int[] arr = {0};
        for (int i=1; i<255; i+=2){
            System.out.println(i);
            arr = new int[i];
        }

        return arr;

    }

    public int[] sumcounter(){
        int[] arr = {0};
        for (int i=1; i<255; i++){
            System.out.println(i);
            arr = new int[i];
        }

        return arr;

    }

    public String interatearray(int[] array){
        String alltogether = "";
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
            alltogether += ", " + array[i];
        }

        return alltogether;

    }

    public int max(int[] array){
        int max = 0;
        for (int i=0; i<array.length; i++){
            if (array[i] > max ){
                max = array[i];
            }
        }

        return max;

    }

    public double average(int[] array){
        double ave = 0;
        int sum = 0;
        int counter = 0;
        for (counter=0; counter<array.length; counter++){
            sum += array[counter];
        }
        
        ave = sum/counter;

        return ave;

    }

    public int[] oddarray(){
        int[] arr = {0};
        for (int i=1; i<255; i+=2){
            arr = new int[i];
        }

        return arr;

    }

    public int[] greater(int[] array, int num){
        int[] newarr = {0};
        for (int i=0; i<array.length; i++){
            if (array[i] > num){
                newarr = new int[array[i]];
            }
        }

        return newarr;

    }

    public int[] positive(int[] array){
        int[] newarr = {0};
        for (int i=0; i<array.length; i++){
            if (array[i] > 0){
                newarr = new int[array[i]];
            }
        }

        return newarr;

    }

    public int[] allabove(int[] array){
        int sum = array[0];
        int max = array[0];
        int average = array[0];
        int min = array[0];
        int counter = 0;
        for (counter=1; counter<array.length; counter++){
            if (array[counter] > max){
                max = array[counter];
            }
            if (array[counter] < min){
                min = array[counter];
            }
            sum += array[counter];
        }

        average = sum/counter;

        int [] newarr = {max, min, average};

        return newarr;

    }

    public int[] shift(int[] array){
        int[] newarr = {0};
        for (int i=1; i<array.length; i++){
            if (array[i] > 0){
                newarr = new int[array[i]];
            }
        }

        newarr = new int[0];

        return newarr;

    }


}