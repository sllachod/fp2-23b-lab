import java.util.*;
public class VideoJuego5{
    public static void main(String[]args){
        int n = 10; // Número de soldados por ejército
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
        HashMap<String, Soldado> ejercito1 = new HashMap<>();
        HashMap<String, Soldado> ejercito2 = new HashMap<>();
        
        inicializarTablero(tablero, ejercito1, ejercito2, n);
        
        imprimirTablero(tablero);
        imprimirDatosSoldados(ejercito1, ejercito2);
        imprimirRankingDePoder(ejercito1, ejercito2);
        imprimirSoldadoConMayorVida(ejercito1, ejercito2);
        imprimirPromedioDeVida(ejercito1, ejercito2);

    }

    private static void inicializarTablero(ArrayList<ArrayList<Soldado>> tablero, HashMap<String, Soldado> ejercito1,HashMap<String, Soldado> ejercito2, int n) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            tablero.add(new ArrayList<>());
        }

        for (int i = 0; i < 10; i++) {
            // Crear soldado para el ejército 1
            Soldado soldado1 = crearSoldados1(i, 1, random, tablero);
            ejercito1.put(soldado1.getNombre(), soldado1);

            // Crear soldado para el ejército 2
            Soldado soldado2 = crearSoldados2(i, 2, random, tablero);
            ejercito2.put(soldado2.getNombre(), soldado2);
        }
    }
    private static void imprimirTablero(ArrayList<ArrayList<Soldado>> tablero) {
        for (int i = 0; i < tablero.size(); i++) {
            for (Soldado soldado : tablero.get(i)) {
                System.out.print(soldado.getNombre() + " | ");
            }
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------");
        }
        System.out.println();
    }
    private static Soldado crearSoldados1(int index, int ejercito, Random random, ArrayList<ArrayList<Soldado>> tablero) {
        int puntosVida = random.nextInt(5) + 1;
        String nombre = "Soldado " + index + "X" + ejercito + " |" + puntosVida + "| vida";
        int fila, columna;

        do {
            fila = random.nextInt(10);
            columna = random.nextInt(10);
        } while (yaOcupado(tablero, fila, columna));

        Soldado soldado = new Soldado(nombre, puntosVida, fila, columna);
        tablero.get(fila).add(soldado);

        return soldado;
    }

    private static Soldado crearSoldados2(int index, int ejercito, Random random, ArrayList<ArrayList<Soldado>> tablero) {
        int puntosVida = random.nextInt(5) + 1;
        String nombre = "Soldado " + index + "X" + ejercito + " _" + puntosVida + "_ vida";
        int fila, columna;

        do {
            fila = random.nextInt(10);
            columna = random.nextInt(10);
        } while (yaOcupado(tablero, fila, columna));

        Soldado soldado = new Soldado(nombre, puntosVida, fila, columna);
        tablero.get(fila).add(soldado);

        return soldado;
    }

    private static boolean yaOcupado(ArrayList<ArrayList<Soldado>> tablero, int fila, int columna) {
        return !tablero.get(fila).isEmpty() && tablero.get(fila).get(tablero.get(fila).size() - 1).getColumna() == columna;
    }

    private static void imprimirDatosSoldados(HashMap<String, Soldado> ejercito1, HashMap<String, Soldado> ejercito2) {
        System.out.println("Datos de los soldados del Ejército 1:");
        for (Soldado soldado : ejercito1.values()) {
            System.out.println(soldado.getNombre() + " - Puntos de Vida: " + soldado.getPuntosDeVida());
        }
        System.out.println();
        System.out.println("Datos de los soldados del Ejército 2:");
        for (Soldado soldado : ejercito2.values()) {
            System.out.println(soldado.getNombre() + " - Puntos de Vida: " + soldado.getPuntosDeVida());
        }
        System.out.println();
    }
    private static void imprimirRankingDePoder(HashMap<String, Soldado> ejercito1, HashMap<String, Soldado> ejercito2) {
        // Ordenar soldados por puntos de vida de forma ascendente (menor a mayor)
        List<Soldado> listaEjercito1 = new ArrayList<>(ejercito1.values());
        List<Soldado> listaEjercito2 = new ArrayList<>(ejercito2.values());
        Collections.sort(listaEjercito1, Comparator.comparingInt(Soldado::getPuntosDeVida).reversed());
        Collections.sort(listaEjercito2, Comparator.comparingInt(Soldado::getPuntosDeVida).reversed());

        System.out.println("Ranking de poder del Ejército 1 (mayor a menor):");
        for (Soldado soldado : listaEjercito1) {
            System.out.println(soldado.getNombre() + " - Puntos de Vida: " + soldado.getPuntosDeVida());
        }

        System.out.println();

        System.out.println("Ranking de poder del Ejército 2 (mayor a menor):");
        for (Soldado soldado : listaEjercito2) {
            System.out.println(soldado.getNombre() + " - Puntos de Vida: " + soldado.getPuntosDeVida());
        }
        System.out.println();
    }
    private static void imprimirSoldadoConMayorVida(HashMap<String, Soldado> ejercito1, HashMap<String, Soldado> ejercito2) {
        Soldado maxVidaEjercito1 = Collections.max(ejercito1.values(), Comparator.comparingInt(Soldado::getPuntosDeVida));
        Soldado maxVidaEjercito2 = Collections.max(ejercito2.values(), Comparator.comparingInt(Soldado::getPuntosDeVida));

        System.out.println("Soldado con mayor vida del Ejército 1: " + maxVidaEjercito1.getNombre() + " - Puntos de Vida: " + maxVidaEjercito1.getPuntosDeVida());
        System.out.println("Soldado con mayor vida del Ejército 2: " + maxVidaEjercito2.getNombre() + " - Puntos de Vida: " + maxVidaEjercito2.getPuntosDeVida());
        if (maxVidaEjercito1.getPuntosDeVida() > maxVidaEjercito2.getPuntosDeVida()) {
            System.out.println(" > El Ejército 1 gana por tener un soldado con mayor vida.\n");
        } else if (maxVidaEjercito1.getPuntosDeVida() < maxVidaEjercito2.getPuntosDeVida()) {
            System.out.println(" > El Ejército 2 gana por tener un soldado con mayor vida.\n");
        } else {
            System.out.println(" > Ambos ejércitos tienen un soldado con la misma vida máxima.\n");
        }
    }
    private static void imprimirPromedioDeVida(HashMap<String, Soldado> ejercito1, HashMap<String, Soldado> ejercito2) {
        double promedioVidaEjercito1 = calcularPromedioVida(ejercito1);
        double promedioVidaEjercito2 = calcularPromedioVida(ejercito2);

        System.out.println("Promedio de vida del Ejército 1: " + promedioVidaEjercito1);
        System.out.println("Promedio de vida del Ejército 2: " + promedioVidaEjercito2);
        if (promedioVidaEjercito1 > promedioVidaEjercito2) {
            System.out.println(" > El Ejército 1 ganaria por tener un promedio de vida mayor.\n");
        } else if (promedioVidaEjercito1 < promedioVidaEjercito2) {
            System.out.println(" > El Ejército 2 ganaria por tener un promedio de vida mayor.\n");
        } else {
            System.out.println(" > Ambos ejércitos tienen el mismo promedio de vida.\n");
        }
    }
    private static double calcularPromedioVida(HashMap<String, Soldado> ejercito) {
        double sumaVida = 0;
    
        for (Soldado soldado : ejercito.values()) {
            sumaVida += soldado.getPuntosDeVida();
        }
    
        if (ejercito.size() > 0) {
            return sumaVida / ejercito.size();
        } else {
            return 0;
        }
    }
}