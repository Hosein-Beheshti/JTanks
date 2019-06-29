import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * this class is for connection and share data
 * for Game network
 */
public class MultiPlayer {
    private boolean server = false;
    private static Socket socket;
    ObjectInputStream in = null;
    ObjectOutputStream out = null;

    /**
     * startConnection
     */
    public void startConnection()  {
        if (server) {
            System.out.println("1");
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(7654);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("2");
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("3");
        } else {
            try {
                socket = new Socket("127.0.0.1", 7654);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Connected to server.");
        }
    }

    /**
     * a method for share information between client and server
     */
    public int sendInformation(int data) {
        int getData = 0;
        if (FramesInformation.isServer()) {
            sendServerSharedInformation(data);
            try {
                getData = getServerSharedInformation();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("information sended");

        } else {
            try {
                getData = getServerSharedInformation();
                System.out.println(getData);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            sendServerSharedInformation(data);
            System.out.println("information taked");

        }
        return getData;
    }

    /**
     * get data from network
     */
    private int getServerSharedInformation() throws IOException, ClassNotFoundException {
       int data = 0;

        in = new ObjectInputStream(socket.getInputStream());
        data = (int) in.readObject();

        return data;
    }

    /**
     * send data to nerwork
     */
    private void sendServerSharedInformation(int data) {
        try {

            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(data);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setServer(boolean server) {
        this.server = server;
    }

    public boolean isServer() {
        return server;
    }
}
