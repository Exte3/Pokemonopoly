
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
import java.io.InputStream;
import java.io.InputStreamReader;

@SuppressWarnings("unused")
public class Monopolis {
    public static ArrayList<Propiedad> proBanco = new ArrayList();
    public static ArrayList<Jugador> jugadores = new ArrayList();
    public static int turno = 0;
    public static int nPlayers = 2;
    public static Tarjeta[] barajaTarjetasSuerte = new Tarjeta[10];
    public static Tarjeta[] barajaTarjetasComunidad = new Tarjeta[10];
    public static String FILE_NAME = "Propiedades.csv";
    public static String FILE_NAME1 = "/Datos/Suerte.csv";
    public static String FILE_NAME2 = "/Datos/Comunidad.csv";
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

    public static int lanzarDado() {
        return (int) (Math.random() * 6 + 1);
    }

    public static Tarjeta seleccionarTarjetaAleatoria(Tarjeta[] tar) {
        int random = (int) (Math.random() * 9 + 0);
        return tar[random];
    }

    public static void leerPropiedades() {
        String FILE_NAME = "/Datos/Propiedades.csv"; // Ruta del archivo
        String DELIMITER = ","; // Delimitador CSV

        try (
                InputStream inputStream = Monopolis.class.getResourceAsStream(FILE_NAME);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine(); // Leer la cabecera
            if (line == null) {
                System.out.println("El archivo CSV está vacío.");
                return;
            }

            // Leer las propiedades
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(DELIMITER);
                if (datos.length != 6) {
                    System.out.println("Error al leer la línea del archivo CSV: " + line);
                    continue;
                }

                String nombre = datos[0].trim();
                String dueno = datos[1].trim();
                int precio = Integer.parseInt(datos[2].trim());
                int renta = Integer.parseInt(datos[3].trim());
                int pos = Integer.parseInt(datos[4].trim());
                boolean tarjeta = Boolean.parseBoolean(datos[5].trim());

                proBanco.add(new Propiedad(nombre, dueno, precio, renta, pos, tarjeta));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo " + FILE_NAME);
        }
    }

    public static void leerTarjetas(String fileName) {
        try (
                InputStream inputStream = Monopolis.class.getResourceAsStream(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            // Leer y descartar la primera línea (encabezado)
            br.readLine();

            String line;
            int contadorSuerte = 0;
            int contadorComunidad = 0;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";"); // Separar la línea en partes usando la coma como delimitador

                boolean tarj = Boolean.parseBoolean(parts[0]); // El primer valor es el evento
                String texto = parts[1]; // El segundo valor es el efecto
                int plata = Integer.parseInt(parts[2]); // El tercer valor es el monto

                if (tarj) {
                    barajaTarjetasSuerte[contadorSuerte++] = new Tarjeta(tarj, texto, plata);
                } else {
                    barajaTarjetasComunidad[contadorComunidad++] = new Tarjeta(tarj, texto, plata);
                }
            }
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
