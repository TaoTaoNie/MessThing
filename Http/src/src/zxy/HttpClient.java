package src.zxy;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.RootPaneContainer;

/**
 * Class <em>HttpClient</em> is a class representing a simple HTTP client.
 *
 * @author zxy
 */

public class HttpClient {
    private String rootString = "D:\\client";
    /**
     * default HTTP port is port 8081
     */
    private static int port = 8081;

    /**
     * Allow a maximum buffer size of 8192 bytes
     */
    private static int buffer_size = 8192;

    /**
     * Response is stored in a byte array.
     */
    private byte[] buffer;

    /**
     * My socket to the world.
     */
    Socket socket = null;

    /**
     * Default port is 8081.
     */
    private static final int PORT = 8081;

    /**
     * Output stream to the socket.
     */
    private BufferedOutputStream ostream = null;

    /**
     * Input stream from the socket.
     */
    private BufferedInputStream istream = null;

    private BufferedReader bufferedReader = null;

    /**
     * StringBuffer storing the header
     */
    private StringBuffer header = null;

    /**
     * StringBuffer storing the response.
     */
    private StringBuffer response = null;

    /**
     * String to represent the Carriage Return and Line Feed character sequence.
     */
    static private String CRLF = "\r\n";

    /**
     * HttpClient constructor;
     */
    public HttpClient() {
        buffer = new byte[buffer_size];
        header = new StringBuffer();
        response = new StringBuffer();
    }

    /**
     * <em>connect</em> connects to the input host on the default http port --
     * port 8081. This function opens the socket and creates the input and
     * output streams used for communication.
     */
    public void connect(String host) throws Exception {

        /**
         * Open my socket to the specified host at the default port.
         */
        socket = new Socket(host, PORT);

        /**
         * Create the output stream.
         */
        ostream = new BufferedOutputStream(socket.getOutputStream());

        /**
         * Create the input stream.
         */
        istream = new BufferedInputStream(socket.getInputStream());
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * <em>processGetRequest</em> process the input GET request.
     */
    void processGetRequest(String request) throws Exception {
        /**
         * Send the request to the server.
         */
        request += CRLF + CRLF;
        buffer = request.getBytes();
        ostream.write(buffer, 0, request.length());
        ostream.flush();
        /**
         * waiting for the response.
         */
        // 程序走到了这里
        processResponse();
    }

    /**
     * <em>processPutRequest</em> process the input PUT request.
     */
    void processPutRequest(String request) throws Exception {
        // =======start your job here============//
        if (request != null) {
            String fName;
            fName = request.substring(5);
            System.out.println(fName);
            System.out.println(rootString);
            String fPath = rootString + "\\" + fName;
            System.out.println(fPath);
            File file = new File(fPath);
            if (file.exists() && !file.isDirectory()) {
                String reqMessage = request + CRLF;
                reqMessage += "Accept: */*" + CRLF;
                reqMessage += "Accept-Language: zh-cn" + CRLF;
                reqMessage += "Content-Length: " + file.length() + CRLF;
                if (fName.endsWith("txt") || fName.endsWith("htm")
                        || fName.endsWith("html"))
                    reqMessage += "Content-Type: text/html" + CRLF;
                else if (fName.endsWith("jpg") || fName.endsWith("jpeg")) {
                    reqMessage += "Content-Type: image/jpeg" + CRLF;
                } else {
                    reqMessage += "Content-Type: application/octet-stream"
                            + CRLF;
                }
                reqMessage += CRLF;
                System.out.println(reqMessage);
                buffer = reqMessage.getBytes();
                ostream.write(buffer);
                FileInputStream in = new FileInputStream(file);
                System.out.println(in.available());

                // StringBuffer stringBuffer=new StringBuffer();
                while (in.read(buffer) != -1) {
                    ostream.write(buffer);
                    // stringBuffer.append(new String(buffer));
                }

                // ostream.write(stringBuffer.toString().getBytes("iso-8859-1"));

                // System.out.println(stringBuffer);
                ostream.flush();
                in.close();
            } else {
                System.err.println("文件不存在");
            }
        }
        processResponse();
        // =======end of your job============//
    }

    /**
     * <em>processResponse</em> process the server response.
     */
    void processResponse() throws Exception {
        int last = 0, c = 0;
        /**
         * Process the header and add it to the header StringBuffer.
         */
        boolean inHeader = true; // loop control
        System.out.println("1循环之前");
        // 程序到了你这个跳不出循环的方法了，我前面说的，你再服务器那边有这样一句代码： pw.println("you said:" + info); 所以，
        // 第一次调用这个方法回来的时候输入流里面的数据是"you said:" + info，这跟这个循环所判断的头部肯定不一样啊，所以肯定跳不出循环对吧
        while (inHeader && ((c = istream.read()) != -1)) {
            System.out.println("循环开始");
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
            System.out.println("1停在这里？");
            System.out.println(inHeader);
        }

        System.out.println("1跳得出来吗？");
        // System.out.println(header);
        System.out.println("Header:" + header.toString());

        /**
         * Read the contents and add it to the response StringBuffer.
         */
        // int len;
        // System.out.println("2循环之前");
        // while ((len = istream.read(buffer)) != -1) {
        // System.out.println("2停在这里 前？");
        // response.append(new String(buffer,0,len,"iso-8859-1"));
        // System.out.println("2停在这里 后？");
        // }
        // System.out.println("2跳得出来吗？");
        while (istream.available() > 0) {
            istream.read(buffer);
            response.append(new String(buffer, "iso-8859-1"));
        }
        System.out.println("body:" + response);
    }

    /**
     * Get the response header.
     */
    public String getHeader() {
        // System.out.println(header);
        return header.toString();
    }

    /**
     * Get the server's response.
     */
    public String getResponse() {
        return response.toString();
    }

    /**
     * Close all open connections -- sockets and streams.
     */
    public void close() throws Exception {
        socket.close();
        istream.close();
        ostream.close();
    }
}
