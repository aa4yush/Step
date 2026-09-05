import java.util.Scanner;
class ISBN {
    String normalizeCode(String raw) {
        raw = raw.trim();
        String publisher = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);
        return publisher + rest;
    }
    String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain digits";
            }
        }
        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);
        StringBuilder result = new StringBuilder();
        result.append("[")
                .append(publisher)
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalog);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ISBN code: ");
        String raw = sc.nextLine();
        ISBN obj = new ISBN();
        String normalized = obj.normalizeCode(raw);
        System.out.println(obj.validateAndFormat(normalized));
    }
}
