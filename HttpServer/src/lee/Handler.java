package lee;

import java.io.*;
import java.net.Socket;

public class Handler extends Thread{
    private File root;
    private Socket socket;
    private String requestString;

    BufferedReader br;
    BufferedWriter bw;
    PrintWriter pw;

    public Handler(Socket socket, File root) {
        this.socket = socket;
        this.root = root;
    }

    public void initStream() throws IOException{
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        pw = new PrintWriter(bw, true);
    }

    public void handlerGet(String requestString, PrintWriter printWriter) throws IOException {
        File requestFile = new File(root.getAbsolutePath() + requestString);
        if (requestFile.exists()) {
            FileInputStream fileInputStream = new FileInputStream(root.getAbsolutePath() + requestString);
            byte[] buf = new byte[fileInputStream.available()];
            fileInputStream.read(buf);

        }
    }

    public void run() {
        try {
            initStream();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
