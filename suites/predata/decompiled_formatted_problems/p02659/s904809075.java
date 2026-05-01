import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Main {
  public static void main(final String[] array) {
    final InputStream in = System.in;
    final PrintStream out = System.out;
    final InputReader inputReader = new InputReader(in);
    final PrintWriter printWriter = new PrintWriter(out);
    new CMultiplication3().solve(1, inputReader, printWriter);
    printWriter.close();
  }

  static class CMultiplication3 {
    public void solve(final int n, final InputReader inputReader, final PrintWriter printWriter) {
      final String[] split = inputReader.readLine().split(" ");
      printWriter.println(
          String.valueOf(
              Long.parseLong(split[0]) * Long.parseLong(split[1].replaceAll("\\.", "")) / 100L));
    }
  }

  static class InputReader {
    private InputStream stream;
    private byte[] buf;
    private int curChar;
    private int numChars;

    public InputReader(final InputStream stream) {
      this.buf = new byte[1024];
      this.stream = stream;
    }

    public int read() {
      if (this.numChars == -1) {
        throw new InputMismatchException();
      }
      if (this.curChar >= this.numChars) {
        this.curChar = 0;
        try {
          this.numChars = this.stream.read(this.buf);
        } catch (final IOException ex) {
          throw new InputMismatchException();
        }
        if (this.numChars <= 0) {
          return -1;
        }
      }
      return this.buf[this.curChar++];
    }

    private String readLine0() {
      final StringBuilder sb = new StringBuilder();
      for (int codePoint = this.read();
          codePoint != 10 && codePoint != -1;
          codePoint = this.read()) {
        if (codePoint != 13) {
          sb.appendCodePoint(codePoint);
        }
      }
      return sb.toString();
    }

    public String readLine() {
      String s;
      for (s = this.readLine0(); s.trim().length() == 0; s = this.readLine0()) {}
      return s;
    }
  }
}
