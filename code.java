public class MathUtil {
    // If a number is prime
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false; // If divisible, it's not prime
        }
        return true; 
    }

    // Find the greatest common divisor (GCD) of two numbers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b; // Store b in a temporary variable
            b = a % b; // Update b to the remainder of a divided by b
            a = temp; // Update a to the old value of b
        }
        return a; // Return the GCD
    }

    // Find the least common multiple (LCM) of two numbers
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b); // LCM formula
    }

    // Return the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n non-negative");
        if (n == 0) return 0; 
        if (n == 1) return 1; 

        int prev = 0, curr = 1; // Start with 0 and 1
        for (int i = 2; i <= n; i++) {
            int next = prev + curr; // Calculate the next Fibonacci number
            prev = curr; // Move to the next
            curr = next; // Move to the next
        }
        return curr; // Return the nth Fibonacci number
    }

    // Calculate the factorial of n
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n non-negative");
        long result = 1; // Initialize result to 1
        for (int i = 1; i <= n; i++) {
            result *= i; // Multiply numbers from 1 to n
        }
        return result; // Return factorial
    }

    // Check if a number is a perfect number
    public boolean isPerfectNumber(int n) {
        int sum = 0; // Initialize sum of divisors
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i; // Add divisor to sum
        }
        return sum == n; // Check if sum of divisors equals n
    }

    // Calculate the sum of digits of n
    public int sumOfDigits(int n) {
        int sum = 0; // Initialize sum
        while (n != 0) {
            sum += n % 10; // Add last digit to sum
            n /= 10; // Remove last digit
        }
        return sum; // Return sum of digits
    }

    // Reverse the digits of n
    public int reverseNumber(int n) {
        int reversed = 0; // Initialize reversed number
        while (n != 0) {
            reversed = reversed * 10 + n % 10; // Build reversed number
            n /= 10; // Remove last digit
        }
        return reversed; // Return reversed number
    }

    // Check if a number is an Armstrong number
    public boolean isArmstrongNumber(int n) {
        int sum = 0, original = n;
        int digits = String.valueOf(n).length(); // Count digits
        while (n != 0) {
            int digit = n % 10; // Get last digit
            sum += Math.pow(digit, digits); // Raise to the power of the number of digits
            n /= 10; // Remove last digit
        }
        return sum == original; // Check if sum equals original number
    }

    // Find the next prime number after n
    public int nextPrime(int n) {
        do {
            n++; // Increment n
        } while (!isPrime(n)); // Keep checking until a prime is found
        return n; // Return the next prime number
    }

    public static void main(String[] args) {
        // Test static methods
        System.out.println("Testing static methods:");
        System.out.println("isPrime(17): " + isPrime(17)); // true
        System.out.println("gcd(56, 98): " + gcd(56, 98)); // 14
        System.out.println("lcm(6, 8): " + lcm(6, 8)); // 24
        System.out.println("fibonacci(10): " + fibonacci(10)); // 55
        System.out.println("factorial(6): " + factorial(6)); // 720

        // Test non-static methods
        MathUtil mathUtil = new MathUtil();
        System.out.println("\nTesting non-static methods:");
        System.out.println("isPerfectNumber(28): " + mathUtil.isPerfectNumber(28)); // true
        System.out.println("sumOfDigits(456): " + mathUtil.sumOfDigits(456)); // 15
        System.out.println("reverseNumber(12345): " + mathUtil.reverseNumber(12345)); // 54321
        System.out.println("isArmstrongNumber(370): " + mathUtil.isArmstrongNumber(370)); // true
        System.out.println("nextPrime(20): " + mathUtil.nextPrime(20)); // 23
    }
}
