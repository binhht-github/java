import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class serverSocKet {
    public static void main(String[] args)  throws Exception {
//        String sentence_from_client;
//        String sentence_to_client;
//
//        //Tạo socket server, chờ tại cổng '6543'
//        ServerSocket welcomeSocket = new ServerSocket(6543);
//
//        while(true) {
//            //chờ yêu cầu từ client
//            Socket connectionSocket = welcomeSocket.accept();
//
//            //Tạo input stream, nối tới Socket
//            BufferedReader inFromClient =
//                    new BufferedReader(new
//                            InputStreamReader(connectionSocket.getInputStream()));
//
//            //Tạo outputStream, nối tới socket
//            DataOutputStream outToClient =
//                    new DataOutputStream(connectionSocket.getOutputStream());
//
//            //Đọc thông tin từ socket
//            sentence_from_client = inFromClient.readLine();
//
//            sentence_to_client = sentence_from_client +" (Server accepted!)" + '\n';
//            //ghi dữ liệu ra socket
//            outToClient.writeBytes(sentence_to_client);
//            return;
//        }
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = din.readUTF();
            System.out.println("client says: " + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
}
