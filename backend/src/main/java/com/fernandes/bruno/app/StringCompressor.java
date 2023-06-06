public class StringCompressor {

  public static String compress(String input) {
    StringBuilder compressed = new StringBuilder();
    int count = 1;

    for (int i = 0; i < input.length(); i++) {
      if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
        count++;
      } else {
        compressed.append(input.charAt(i));
        if (count > 1) {
          compressed.append(count);
        }
        count = 1;
      }
    }

    return compressed.toString();
  }

  public static String decompress(String input) {
    StringBuilder decompressed = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (Character.isDigit(c)) {
        int count = c - '0';
        char prevChar = decompressed.charAt(decompressed.length() - 1);
        while (count > 1) {
          decompressed.append(prevChar);
          count--;
        }
      } else {
        decompressed.append(c);
      }
    }

    return decompressed.toString();
  }

  public static void main(String[] args) {
    String input = "abc";
    String compressed = compress(input);
    String decompressed = decompress(compressed);

    System.out.println("Original: " + input);
    System.out.println("Compressed: " + compressed);
    System.out.println("Decompressed: " + decompressed);
  }
}
