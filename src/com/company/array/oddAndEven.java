package com.company.array;

public class oddAndEven {

    public static void main(String[] args) {
        int[] array = {1, 4, 7, 2, 22, 9, 35, 32, 67, 90, 45};
        for (int i = 0, j = array.length - 1; i < j; ) {
            if (array[i] % 2 != 0)
                i ++;
            if (array[j] % 2 == 0)
                j --;
            int temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }

        for (int i = 0; i < array.length; i ++)
            System.out.print(array[i] + " ");

    }
}
