import java.net.*;
import java.io.*;


public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(Integer.parseInt(args[0]));
        } catch (Exception e) {
        }
        while (true) {
            Socket client = null;
            PrintStream output = null;
            DataInputStream input = null;
            try {
                client = server.accept();
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                output = new PrintStream(client.getOutputStream());
                input = new DataInputStream(client.getInputStream());
            } catch (Exception e) {
                System.out.println(e);
            }
            //Send the command prompt to client
            output.println("Enter the filename :>");
            try {
                //get the filename from client
                String filename = input.readLine();
                System.out.println("Client requested file :" + filename);
                try {
                    File f = new File(filename);
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    String data;
                    while ((data = br.readLine()) != null) {
                        output.println(data);
                    }
                } catch (FileNotFoundException e) {
                    output.println("File not found");
                }
                client.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
