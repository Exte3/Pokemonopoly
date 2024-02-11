
package monopolis;

import Frame_Imagen.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Datos.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("unused")
public class Monopolis {
    public static ArrayList<Propiedades> proBanco = new ArrayList();
    public static ArrayList<Jugador> jugadores = new ArrayList();
    public static int turno = 0;
    public static int nPlayers = 2;
    public static Tarjeta[] barajaTarjetasSuerte = new Tarjeta[10];
    public static Tarjeta[] barajaTarjetasComunidad = new Tarjeta[10];
    public static String FILE_NAME = "Propiedades.txt";
    public static String FILE_NAME1 = "Suerte.txt";
    public static String FILE_NAME2 = "Comunidad.txt";
    public static boolean go = false;

    public static void main(String[] args) {
        iniciarJuego();
    }

    private static void iniciarJuego() {
        Inicio ini = new Inicio();
        ini.setVisible(true);

        while (ini.isVisible()) {
            crearJugadores();
        }

        mostrarTablero();
    }

    private static void crearJugadores() {
        Jugador banco = new Jugador("Banco", 10000000, 0, false, false, 0); // Banco tiene todas las propiedades

        for (int i = 0; i < nPlayers; i++) {
            String nombreJugador = "Jugador" + i;
            jugadores.add(new Jugador(nombreJugador, 1500, 0, true, true, 0));
        }
    }

    private static void mostrarTablero() {
        boolean go = true;
        SuperFrame tablero = new SuperFrame();
        tablero.setVisible(go);
    }

    // -.Funciones.-//

    // Función para lanzar un dado y devolver el resultado
    public static int lanzarDado() {
        return (int) (Math.random() * 6 + 1);
    }

    // Función para seleccionar aleatoriamente una tarjeta de un array de Tarjetas
    public static Tarjeta seleccionarTarjetaAleatoria(Tarjeta[] tar) {
        int random = (int) (Math.random() * 9 + 0);
        return tar[random];
    }

    // Función para leer datos desde un archivo y crear objetos Propiedades
    public static void leerPropiedades() {
        try {
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                String nombre = line;
                String dueno = br.readLine();
                int precio = Integer.parseInt(br.readLine());
                int renta = Integer.parseInt(br.readLine());
                int pos = Integer.parseInt(br.readLine());
                boolean tarjeta = Boolean.parseBoolean(br.readLine());

                proBanco.add(new Propiedades(nombre, dueno, precio, renta, pos, tarjeta));

                line = br.readLine(); // Leer la siguiente línea
            }

            fr.close();
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo " + FILE_NAME);
        }
    }

    public static void leerTarjetas(String fileName) throws IOException {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int contadorSuerte = 0;
            int contadorComunidad = 0;

            while (line != null) {
                String tar = line;
                String texto = br.readLine();
                int plata = Integer.parseInt(br.readLine());
                boolean tarj = tar.equals("true");

                if (tarj) {
                    barajaTarjetasSuerte[contadorSuerte++] = new Tarjeta(tarj, texto, plata);
                } else {
                    barajaTarjetasComunidad[contadorComunidad++] = new Tarjeta(tarj, texto, plata);
                }

                // No es recomendable imprimir aquí, pero se mantiene por el ejemplo
                // System.out.println("tarjeta " + tar);
                // System.out.println("texto " + texto);
                // System.out.println("plata " + plata);

                line = br.readLine(); // Leemos la siguiente línea
            }

            fr.close();
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo " + fileName);
        }
    }

    public static void mostrarInformacionJugadores() {
        for (int i = 0; i < nPlayers; i++) {
            mostrarInfoJugador(jugadores.get(i));
        }
    }

    private static void mostrarInfoJugador(Jugador jugador) {
        System.out.println("Jugador: " + jugador.getNombre() +
                ", Dinero: " + jugador.getCoins() +
                ", Posición: " + jugador.getPosicion() +
                ", Jugando: " + jugador.getPlay() +
                ", Condena: " + jugador.getCondena());
    }

    public static void Go(SuperFrame tablero) {
        tablero = new SuperFrame();
        tablero.setVisible(true);
    }

    public static void procesarEventoCasilla(Jugador jugador) {
        int posicion = jugador.getPosicion();
        String nombreJugador = jugador.getNombre();

        if (posicion == 30 || posicion == 2 || posicion == 7 || posicion == 17 || posicion == 22 || posicion == 33
                || posicion == 36) {
            procesarEventoEspecial(jugador);
        } else {
            procesarCompraPropiedad(jugador);
        }
    }

    private static void procesarEventoEspecial(Jugador jugador) {
        int posicion = jugador.getPosicion();

        if (posicion == 30) {
            procesarEventoCarcel(jugador);
        } else if (posicion == 2 || posicion == 17 || posicion == 33) {
            procesarEventoSuerte(jugador);
        } else if (posicion == 7 || posicion == 22 || posicion == 36) {
            procesarEventoComunidad(jugador);
        }
    }

    private static void procesarEventoCarcel(Jugador jugador) {
        jugador.setPosicion(10);
        jugador.setCondena(3);
        jugador.setMov(false);
        JOptionPane.showMessageDialog(null,
                "Tus Pokémon han sido debilitados. Espera 3 turnos para recuperarlos o saca un doble.");
        avanzarTurno();
    }

    private static void procesarEventoSuerte(Jugador jugador) {
        Tarjeta suerte = seleccionarTarjetaAleatoria(barajaTarjetasSuerte);
        JOptionPane.showMessageDialog(null, suerte.getMensaje());
        avanzarTurno();
    }

    private static void procesarEventoComunidad(Jugador jugador) {
        Tarjeta comunidad = seleccionarTarjetaAleatoria(barajaTarjetasComunidad);
        JOptionPane.showMessageDialog(null, comunidad.getMensaje());
        avanzarTurno();
    }

    private static void procesarCompraPropiedad(Jugador jugador) {
        int posicion = jugador.getPosicion();
        String nombrePropietario = proBanco.get(posicion).getPropietario();
        int dinero = jugador.getCoins();

        if (nombrePropietario.equals("Comprar")) {
            procesarCompra(jugador);
        } else if (nombrePropietario.equals("Banco") || nombrePropietario.equals(jugador.getNombre())) {
            procesarCompra(jugador);
            avanzarTurno();
        } else {
            procesarPagoRenta(jugador, nombrePropietario);
            avanzarTurno();
        }
    }

    private static void procesarCompra(Jugador jugador) {
        int posicion = jugador.getPosicion();
        String nombrePropiedad = proBanco.get(posicion).getNombrePro();
        int precio = proBanco.get(posicion).getPrecio();
        int dinero = jugador.getCoins();

        if (dinero > precio) {
            mostrarOpcionCompraPropiedad(nombrePropiedad, precio);
        } else {
            Frame_Imagen.SuperFrame.visibilidad(false);
            avanzarTurno();
        }
    }

    private static void mostrarOpcionCompraPropiedad(String nombrePropiedad, int precio) {
        String mensaje = "¿Desea comprar la propiedad " + nombrePropiedad + " por $" + precio + "?";
        Frame_Imagen.SuperFrame.SetterCompra(mensaje);
        Frame_Imagen.SuperFrame.visibilidad(true);
    }

    private static void procesarPagoRenta(Jugador jugador, String propietario) {
        int posicion = jugador.getPosicion();
        int renta = proBanco.get(posicion).getRenta();
        int dinero = jugador.getCoins();

        jugador.setCoins(dinero - renta);
        JOptionPane.showMessageDialog(null, "Debe pagar $" + renta + " al jugador " + propietario);

        aumentarMonedasPropietario(propietario, renta);
    }

    private static void aumentarMonedasPropietario(String nombreJugador, int monto) {
        for (Jugador jugador : jugadores) {
            if (nombreJugador.equals(jugador.getNombre())) {
                int monedas = jugador.getCoins();
                jugador.setCoins(monedas + monto);
                break;
            }
        }
    }

    private static void avanzarTurno() {
        if (turno < nPlayers) {
            turno++;
        } else {
            turno = 0;
        }
    }
}
