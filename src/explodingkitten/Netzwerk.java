package explodingkitten;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Netzwerk {
    public static void send(String adresse,int message) {
        Socket socket = null;
        try {
            socket = new Socket(adresse, 4014);
            OutputStream outstream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outstream);
            out.write(message);
            out.flush();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static int recive() {
        try {
            ServerSocket s = new ServerSocket(4014);
            Socket incomingSocket = s.accept();
            s.close();
            int bytesRead = incomingSocket.getInputStream().read();
            return bytesRead;
        } catch (IOException e) {
            System.out.println(e);
            return 0;
        }
    }
    public static String get_ip(){
        try {
            ServerSocket s = new ServerSocket(4014);
            Socket incomingSocket = s.accept();
            int bytesRead = incomingSocket.getInputStream().read();
            s.close();
            String ret = incomingSocket.getRemoteSocketAddress().toString();
            String retu = ret.substring(1,ret.indexOf(':'));
            return retu;
        } catch (IOException e) {
            System.out.println(e);
            return "127.0.0.1";
        }
    }
}
