import java.util.Scanner;
class Palindrome {
    boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    boolean isPalindromeRecursive(String text) {
        return checkRecursive(text, 0, text.length() - 1);
    }

    boolean checkRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return checkRecursive(text, left + 1, right - 1);
    }

    boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        String reversed = new String(arr);
        return text.equals(reversed);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        Palindrome obj = new Palindrome();
        boolean result1 = obj.isPalindromeIterative(text);
        boolean result2 = obj.isPalindromeRecursive(text);
        boolean result3 = obj.isPalindromeArrayReversal(text);
        System.out.println("Iterative: " +
                (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " +
                (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " +
                (result3 ? "Palindrome" : "Not Palindrome"));
    }
}
