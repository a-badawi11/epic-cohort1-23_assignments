public class Assignment2 {

    public static void main(String[] args) {

        System.out.println("sum of odd numbers = " + sumOfOdd(0, 100, 0));
        System.out.println("sum of even numbers = " + sumOfEven(0, 100, 0));
        System.out.println("sum of numbers divisible by 7 = " + sumOfDivisibleBy7(0, 100, 0));

    }

    static int sumOfOdd(int start, int end, int sum) {
        return start > end ?
                sum : sumOfOdd(start + 1, end, sum + (start % 2 != 0 ? start:0));

    }

    static int sumOfEven(int start, int end, int sum) {
        return start > end ?
                sum : sumOfEven(start + 1, end, sum + (start % 2 == 0 ? start:0));

    }

    static int sumOfDivisibleBy7(int start, int end, int sum) {
        return start > end ?
                sum : sumOfDivisibleBy7(start + 1, end, sum + (start % 7 == 0 ? start:0));
    }

}
