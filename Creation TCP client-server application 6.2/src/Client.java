import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 12345;

        try {
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Підключено до сервера");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Введіть повідомлення для сервера: ");
            String message = userInput.readLine();

            out.println(message);

            String response = in.readLine();
            System.out.println("Відповідь від сервера: " + response);

            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Помилка при підключенні до сервера: " + e.getMessage());
        }
    }
}