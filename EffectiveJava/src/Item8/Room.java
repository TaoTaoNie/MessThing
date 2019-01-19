package Item8;

import java.io.*;

/**
 * @author leetHuam
 * @version 1.0
 */

public class Room {
    public Room() {
        System.out.println("room test!");
    }
    public static void main(String[] args) throws IOException {
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader("IDEAWorkspace.iml"));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("dst.txt"))) {
            char[] buf = new char[1024];
            int n;
            while ((n = bufferedReader.read(buf)) >= 0)
                bufferedWriter.write(buf, 0, n);
        }
    }

}
