package src.zxy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.util.StringTokenizer;

/**
 * work thread
 *
 * @author zxy
 */
public class Handler implements Runnable { // 负责与单个客户通信的线程
    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;
    private PrintWriter pw;
    private BufferedOutputStream ostream;
    private HttpResponse httpResponse;
    private String body;
    private StringBuffer header;
    private BufferedInputStream istream;
    private byte[] buffer;
    private static int buffer_size = 8192;
    private String method;

    public Handler(Socket socket, HttpResponse httpResponse) {
        this.socket = socket;
        this.httpResponse = httpResponse;
    }

    private void initStream() throws IOException { // 初始化输入输出流对象方法
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        pw = new PrintWriter(bw, true);
        // 字节流 往客户端写数据
        ostream = new BufferedOutputStream(socket.getOutputStream());
        istream = new BufferedInputStream(socket.getInputStream());
        buffer = new byte[buffer_size];
        header = new StringBuffer();
        body = "";
    }

    public void run() { // 执行的内容
        try {
            System.out.println("新连接，连接地址：" + socket.getInetAddress() + "："
                    + socket.getPort()); // 客户端信息
            initStream(); // 初始化输入输出流对象

            System.out.println("处理请求");
            processRequest(); //处理请求

            method = getMethod(header.toString());//获取方法
            System.out.println("method" + method);
            if (method != null) {
                System.out.println("httpResponse Handle");
                httpResponse.Handle(method, body, header, ostream);
            } else {
                String httpVersion = "HTTP/1.0";
                String response = httpVersion + " " + "400" + " "
                        + "Bad Request";
                response += Client.CRLF;
                response += Client.CRLF;
                ostream.write(response.getBytes());
                ostream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getMethod(String header) {
        // TODO Auto-generated method stub
        StringTokenizer stringTokenizer = new StringTokenizer(header, "\n");
        if (stringTokenizer.hasMoreTokens()) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), " ");
            if (stringTokenizer2.hasMoreTokens())
                return stringTokenizer2.nextToken();
        }
        return null;
    }

    private void processRequest() throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        int last = 0, c = 0;
        /**
         * Process the header and add it to the header StringBuffer.
         */
        boolean inHeader = true; // loop control
        try {
            while (inHeader) {
                System.out.println("进入循环");

                c = istream.read();// 这里被阻塞了，前面你已经把输入流中的东西取出来了，使用info=br.readline()函数把输入流的数据取走了，
                // 所以这里处于阻塞状态，程序停留在这一直等输入流来数据，但是这边回到客户端那边
                if (c == -1)
                    break;
                switch (c) {
                    case '\r':
                        break;
                    case '\n':
                        if (c == last) {
                            inHeader = false;
                            break;
                        }
                        last = c;
                        header.append("\n");
                        break;
                    default:
                        last = c;
                        header.append((char) c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("header: " + header);

        /**
         * Read the contents and add it to the response StringBuffer.
         */
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(istream.available());
        while (istream.available() > 0) {
            istream.read(buffer);
            stringBuffer.append(new String(buffer, "iso-8859-1"));
            Thread.sleep(10);
        }
        body = stringBuffer.toString();
    }

}
