package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leetHuam
 * @version 1.0
 */
public class BufferedInputFile {
    static String file = "out.txt";
    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String s;
            while ((s = in.readLine()) != null)
                list.add(s);
            in.close();
        } catch (FileNotFoundException fn) {
            fn.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = list.size() - 1; i >= 0; i--)
            sb.append(list.get(i) + "\n");
        return sb.toString();
    }
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
//        System.out.println(BufferedInputFile.read("xml.txt"));
//        StringReader in = new StringReader(BufferedInputFile.read("xml.txt"));
//        int c;
//        while ((c = in.read()) != -1)
//            System.out.println((char) c);
//        try {
//            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("xml.txt").getBytes()));
//            while (in.available() != 0)
//                System.out.print((char) in.readByte());
//        } catch (EOFException e) {
//            e.printStackTrace();
//        }
//        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("xml.txt")));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
//        int lineCount = 1;
//        String s;
//        while ((s = in.readLine()) != null)
//            out.println(lineCount++ + ": " + s);
//        out.close();
//        System.out.print(BufferedInputFile.read(file));
//        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//        String s;
//        while((s = stdin.readLine()) != null && s.length() != 0)
//            System.out.println(s);
//        PrintStream console = System.out;
//        BufferedInputStream in = new BufferedInputStream(new FileInputStream("xml.txt"));
//        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("out.txt")));
//        System.setIn(in);
//        System.setOut(out);
//        System.setErr(out);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s;
//        while((s = br.readLine()) != null)
//            System.out.println(s);
//        out.close();
//        System.setOut(console);
        if (args.length != 2){
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(), out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
//        while(in.read(buffer) != -1) {
//            buffer.flip();
//            out.write(buffer);
//            buffer.clear();
//        }
        in.transferTo(0, in.size(), out);
    }
}

