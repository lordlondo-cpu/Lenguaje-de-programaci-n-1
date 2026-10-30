package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {

    private static int numeroSecreto = new Random().nextInt(100) + 1;

    public static void main(String[] args) {

        try {
            ServerSocket servidor = new ServerSocket(5000);

            System.out.println("=================================");
            System.out.println("SERVIDOR INICIADO");
            System.out.println("Puerto: 5000");
            System.out.println("Esperando clientes...");
            System.out.println("=================================");

            while (true) {

                Socket cliente = servidor.accept();

                System.out.println(
                        "Cliente conectado: "
                        + cliente.getInetAddress());

                ClienteHandler hilo =
                        new ClienteHandler(cliente);

                hilo.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClienteHandler extends Thread {

        private Socket socket;

        public ClienteHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try {

                BufferedReader entrada =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));

                PrintWriter salida =
                        new PrintWriter(
                                socket.getOutputStream(),
                                true);

                salida.println("Bienvenido al juego");
                salida.println("Adivina un numero entre 1 y 100");

                String mensaje;

                while ((mensaje = entrada.readLine()) != null) {

                    int intento = Integer.parseInt(mensaje);

                    synchronized (Server.class) {

                        if (intento < numeroSecreto) {

                            salida.println("Muy bajo");

                        } else if (intento > numeroSecreto) {

                            salida.println("Muy alto");

                        } else {

                            salida.println("CORRECTO");

                            System.out.println(
                                    "Numero adivinado por un cliente: "
                                            + numeroSecreto);

                            numeroSecreto =
                                    new Random().nextInt(100) + 1;

                            System.out.println(
                                    "Nuevo numero generado");
                        }
                    }
                }

                socket.close();

            } catch (Exception e) {

                System.out.println(
                        "Cliente desconectado");
            }
        }
    }
}