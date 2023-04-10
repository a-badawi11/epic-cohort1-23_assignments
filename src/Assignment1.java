public class Assignment1 {
    public final static int MAX = 100;

    public static void main(String[] args) {

        sumOfMax(true);
        System.out.println();
        sumOfMax(false);
        System.out.println();
        sumOfDivisibleBy7();
    }

    static void sumOfMax(boolean evenOrOdd) {

        int start = evenOrOdd ? 0 : 1;

        System.out.println("Sum of " + (evenOrOdd ? "even" : "odd") + " numbers:-");

        int sum1 = 0;
        for(int i = start; i <= MAX; i+=2) {
            sum1 += i;
        }
        System.out.println("using for-loop, sum = " + sum1);

        int sum2 = 0;
        int i = start;
        while(i <= MAX) {
            sum2 += i;
            i+=2;
        }
        System.out.println("using while-loop, sum = " + sum2);

        int sum3 = 0;
        int i1 = start;
        do {
            sum3 += i1;
            i1+=2;
        }
        while(i1 <= MAX);
        System.out.println("using do-while-loop, sum = " + sum3);

    }

    static void sumOfDivisibleBy7() {

        System.out.println("Numbers divisible By 7:-");
        int sum1 = 0;
        for(int i = 0; i <= MAX; i++) {
            sum1 += (i % 7 == 0 ? i : 0);
        }
        System.out.println("using for-loop, sum = " + sum1);

        int sum2 = 0;
        int i = 0;
        while(i <= MAX) {
            sum2 += (i % 7 == 0 ? i : 0);
            i++;
        }
        System.out.println("using while-loop, sum = " + sum2);

        int sum3 = 0;
        int i1 = 0;
        do {
            sum3 += (i1 % 7 == 0 ? i1 : 0);
            i1++;
        }
        while(i1 <= MAX);
        System.out.println("using do-while-loop, sum = " + sum3);
    }

}
