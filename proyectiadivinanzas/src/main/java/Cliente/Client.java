package Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 5000);

            BufferedReader entrada =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter salida =
                    new PrintWriter(
                            socket.getOutputStream(),
                            true);

            Scanner teclado = new Scanner(System.in);

            System.out.println(entrada.readLine());
            System.out.println(entrada.readLine());

            while (true) {

                System.out.print("Ingrese un número: ");

                String intento = teclado.nextLine();

                salida.println(intento);

                String respuesta = entrada.readLine();

                System.out.println("Servidor: " + respuesta);

                if (respuesta.equals("CORRECTO")) {
                    System.out.println("¡Ganaste!");
                    break;
                }
            }

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}