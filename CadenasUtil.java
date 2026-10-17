package org.uabc.ic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CadenasUtil {

    // 2. El Filtro Selectivo
    public static void filtrarCadenas(ArrayList<String> lista, char letra, int tamanoMinimo) {
        if (lista == null) return;

        String letraBuscada = String.valueOf(letra).toLowerCase();

        // removeIf borra los elementos que cumplan la condicion
        lista.removeIf(palabra -> palabra.toLowerCase().startsWith(letraBuscada) || palabra.length() < tamanoMinimo);
    }

    // 3. Conversor de Mayusculas
    public static ArrayList<String> convertirMayusculas(ArrayList<String> lista) {
        if (lista == null) return new ArrayList<>();

        return lista.stream()
                .map(palabra -> palabra.toUpperCase()) //las hace mayusculas
                .collect(Collectors.toCollection(ArrayList::new)); // Lo guarda en un nuevo ArrayList
    }

    // 5. Mapa de Longitudes
    public static HashMap<String, Integer> mapaLongitudes(ArrayList<String> lista) {
        if (lista == null) return new HashMap<>();

        return lista.stream()
                .collect(Collectors.toMap(
                        palabra -> palabra,          // La Clave (Key) es la palabra
                        palabra -> palabra.length(), // El Valor (Value) es su longitud
                        (existente, nuevo) -> existente, // Si hay palabras repetidas, conserva la primera
                        HashMap::new
                ));
    }

    // 6. Modificador de Inventario
    public static void imprimirCatalogoConDescuento(HashMap<String, Double> inventario) {
        if (inventario == null) return;

        // forEach en mapas recibe dos variables: (clave, valor)
        inventario.forEach((producto, precio) -> {
            double precioConDescuento = precio * 0.90; // Calcula el 10% de descuento
            System.out.println("Producto: " + producto + " | Precio con 10% desc: $" + precioConDescuento);
        });
    }

    // 7. Contador de Frecuencias
    public static HashMap<String, Integer> contarFrecuencias(ArrayList<String> palabras) {
        HashMap<String, Integer> frecuencias = new HashMap<>();
        if (palabras == null) return frecuencias;

        for (String palabra : palabras) {
            // merge busca 'palabra': si no está pone 1, si ya está ejecuta la lambda (sumar 1)
            frecuencias.merge(palabra, 1, (frecuenciaActual, valorInicial) -> frecuenciaActual + 1);
        }
        return frecuencias;
    }

    // 8. Clasificador de Palabras
    public static ArrayList<String> filtrarPorFrecuencia(HashMap<String, Integer> frecuencias, int minimo) {
        if (frecuencias == null) return new ArrayList<>();

        return frecuencias.entrySet().stream()
                .filter(entrada -> entrada.getValue() >= minimo) // Deja pasar solo las que se repiten >= minimo
                .map(entrada -> entrada.getKey())                // Extrae solo el nombre de la palabra
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // 9. Deduplicación de Palabras
    public static HashSet<String> deduplicarFrase(String frase, int minimoLetras) {
        if (frase == null || frase.isEmpty()) return new HashSet<>();

        // Separa la frase en un arreglo de palabras separadas por espacio
        String[] palabras = frase.split(" ");

        return (HashSet<String>) Arrays.stream(palabras)
                .filter(palabra -> palabra.length() >= minimoLetras) // Filtra las de N letras o más
                .map(palabra -> palabra.toLowerCase())              // Convierte a minúsculas
                .collect(Collectors.toSet());                       // Guarda en HashSet (elimina duplicados)
    }

    // 10. El Tope de Frecuencias
    public static void limitarFrecuencias(HashMap<String, Integer> frecuencias, int maximo) {
        if (frecuencias == null) return;

        // replaceAll modifica los valores del mapa usando una lambda
        frecuencias.replaceAll((palabra, frecuencia) -> {
            if (frecuencia > maximo) {
                return maximo; // Si la frecuencia supera el máximo, la fija en el máximo
            } else {
                return frecuencia; // Si no, la deja igual
            }
        });
    }
}