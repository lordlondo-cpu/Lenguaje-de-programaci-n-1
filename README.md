Juego de Adivinanzas en Red - Cliente/Servidor TCP
Integrante
Juan Camilo Londoño Londoño
---
Descripción de la Aplicación
Esta aplicación implementa un juego de adivinanzas utilizando el modelo Cliente-Servidor mediante sockets TCP en Java.
El servidor genera un número aleatorio entre 1 y 100 y espera conexiones de múltiples clientes. Cada cliente puede enviar intentos para adivinar el número secreto.
El servidor responde indicando si el número ingresado es:
Muy bajo
Muy alto
Correcto
Cuando un cliente adivina correctamente el número, el servidor genera un nuevo número aleatorio y el juego continúa.
---
Objetivos del Proyecto
Implementar comunicación mediante sockets TCP.
Aplicar el modelo Cliente-Servidor.
Utilizar programación concurrente mediante hilos (Threads).
Permitir la conexión simultánea de varios clientes.
Demostrar la gestión de recursos compartidos mediante sincronización.
---
Arquitectura Cliente-Servidor
Servidor
El servidor escucha conexiones, acepta múltiples clientes y administra el número secreto compartido.
Cliente
El cliente se conecta al servidor, envía intentos de adivinanza y recibe respuestas.
---
Uso de la Concurrencia
La concurrencia se implementa mediante la clase `Thread`. Cada vez que un cliente se conecta, el servidor crea un hilo independiente para atenderlo.
Se utiliza `synchronized (Server.class)` para proteger el acceso concurrente al número secreto.
---
Host y Puerto Utilizados
Host: localhost
Puerto: 5000
Protocolo: TCP
---
Estructura del Proyecto
```text
ProyectoAdivinanzas
│
└── Source Packages
    ├── servidor
    │   └── Server.java
    └── cliente
        └── Client.java
```
---
Instrucciones de Compilación y Ejecución
Ejecutar `Server.java`.
Esperar el mensaje de servidor iniciado.
Ejecutar uno o varios `Client.java`.
Ingresar números hasta adivinar.
---
Ejemplo de Intercambio de Información
Cliente:
```text
Ingrese un número: 30
Servidor: Muy bajo
```
Cliente:
```text
Ingrese un número: 80
Servidor: Muy alto
```
Cliente:
```text
Ingrese un número: 65
Servidor: CORRECTO
```
---
Tecnologías Utilizadas
Java
Sockets TCP
Threads
NetBeans
Arquitectura Cliente-Servidor
---
Conclusión
Este proyecto permitió implementar una aplicación distribuida utilizando sockets TCP en Java. Gracias al uso de hilos fue posible atender múltiples clientes de forma simultánea, aplicando conceptos de programación concurrente, redes y comunicación cliente-servidor.
