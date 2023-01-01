import java.util.Scanner;

public class Program5 {
    static final int N = 3;

  static int[][] table = new int[N][N];

  static int[][] dv = new int[N][N];

  public static void main(String[] args) {
    initialize();

    run();
  }

  public static void initialize() {
    Scanner in = new Scanner(System.in);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i == j) {
          table[i][j] = 0;
        } else {
          System.out.print("Enter cost from node " + (i+1) + " to node " + (j+1) + ": ");
          table[i][j] = in.nextInt();
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        dv[i][j] = table[i][j];
      }
    }
  }

  public static void run() {
    boolean changed = true;

    while (changed) {
      changed = false;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          int min = Integer.MAX_VALUE;
          for (int k = 0; k < N; k++) {
            if (k == i) continue;
            int distance = dv[k][j] + table[i][k];
            if (distance < min) min = distance;
          }

          if (min < dv[i][j]) {
            dv[i][j] = min;
            changed = true;
          }
        }
      }
    }

    for (int i = 0; i < N; i++) {
      System.out.print("Distance vector for node " + (i+1) + ": ");
      for (int j = 0; j < N; j++) {
        System.out.print(dv[i][j] + " ");
      }
      System.out.println();
    }
  }
}
