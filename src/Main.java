import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Clase que representa una carta de poker
class Card {
    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return palo + "," + color + "," + valor;
    }
}

// Clase que representa el deck de poker
class Deck {
    private ArrayList<Card> cartas;

    public Deck() {
        cartas = new ArrayList<>();
        inicializarDeck();
    }

    private void inicializarDeck() {
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] colores = {"Negro", "Rojo"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? colores[1] : colores[0];
            for (String valor : valores) {
                cartas.add(new Card(palo, color, valor));
            }
        }
    }

    // Método para mezclar el deck
    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }

    // Método para mostrar la primera carta y removerla del deck
    public void head() {
        if (!cartas.isEmpty()) {
            Card primeraCarta = cartas.remove(0);
            System.out.println(primeraCarta);
            System.out.println("Quedan " + cartas.size() + " cartas en deck.");
        } else {
            System.out.println("No quedan cartas en el deck.");
        }
    }

    // Método para seleccionar una carta al azar y removerla del deck
    public void pick() {
        if (!cartas.isEmpty()) {
            Random random = new Random();
            int indice = random.nextInt(cartas.size());
            Card cartaAlAzar = cartas.remove(indice);
            System.out.println(cartaAlAzar);
            System.out.println("Quedan " + cartas.size() + " cartas en deck.");
        } else {
            System.out.println("No quedan cartas en el deck.");
        }
    }

    // Método para seleccionar una mano de 5 cartas y removerlas del deck
    public void hand() {
        if (cartas.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card carta = cartas.remove(0);
                System.out.println(carta);
            }
            System.out.println("Quedan " + cartas.size() + " cartas en deck.");
        } else {
            System.out.println("No hay suficientes cartas para repartir una mano.");
        }
    }

    public int getNumCartas() {
        return cartas.size();
    }
}

// Clase principal para probar el deck
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();  // Mezclar el deck
        deck.head();     // Mostrar la primera carta y removerla
        deck.pick();     // Seleccionar una carta al azar y removerla
        deck.hand();     // Seleccionar una mano de 5 cartas y removerlas
    }
}
