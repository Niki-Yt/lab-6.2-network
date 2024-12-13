import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущено, очікування на підключення...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клієнт підключився!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String messageFromClient = in.readLine();
            System.out.println("Отримано повідомлення від клієнта: " + messageFromClient);

            out.println("Привіт, клієнте! Ви надіслали: " + messageFromClient);

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Помилка при запуску сервера: " + e.getMessage());
        }
    }
}