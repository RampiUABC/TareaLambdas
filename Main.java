package org.uabc.ic;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. EL MULTIPLICADOR ===");
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Antes: " + nums);
        NumerosUtil.multiplicar(nums, 3);
        System.out.println("Después (x3): " + nums);

        System.out.println("\n=== 2. EL FILTRO SELECTIVO ===");
        ArrayList<String> palabras = new ArrayList<>(Arrays.asList("Manzana", "Sol", "Mesa", "Avena", "Pez"));
        System.out.println("Antes: " + palabras);
        // Elimina palabras que inicien con 'M' O  menos de 4 letras
        CadenasUtil.filtrarCadenas(palabras, 'M', 4);
        System.out.println("Después: " + palabras);

        System.out.println("\n=== 3. CONVERSOR DE MAYÚSCULAS ===");
        ArrayList<String> minusculas = new ArrayList<>(Arrays.asList("java", "lambda", "stream"));
        System.out.println("Original: " + minusculas);
        ArrayList<String> mayusculas = CadenasUtil.convertirMayusculas(minusculas);
        System.out.println("En mayúsculas: " + mayusculas);

        System.out.println("\n=== 4. CUADRADOS ÚNICOS ===");
        ArrayList<Integer> duplicados = new ArrayList<>(Arrays.asList(2, 3, 2, 4, 4, 5, 6));
        System.out.println("Original: " + duplicados);
        HashSet<Integer> cuadrados = NumerosUtil.cuadradosDePares(duplicados);
        System.out.println("Cuadrados de pares únicos: " + cuadrados);

        System.out.println("\n=== 5. MAPA DE LONGITUDES ===");
        ArrayList<String> frutas = new ArrayList<>(Arrays.asList("Fresa", "Plátano", "Uva"));
        System.out.println("Lista: " + frutas);
        HashMap<String, Integer> mapaLong = CadenasUtil.mapaLongitudes(frutas);
        System.out.println("Mapa resultado: " + mapaLong);

        System.out.println("\n=== 6. MODIFICADOR DE INVENTARIO ===");
        HashMap<String, Double> inventario = new HashMap<>();
        inventario.put("Laptop", 1000.0);
        inventario.put("Teclado", 50.0);
        System.out.println("Imprimiendo catálogo con descuento del 10%:");
        CadenasUtil.imprimirCatalogoConDescuento(inventario);

        System.out.println("\n=== 7. CONTADOR DE FRECUENCIAS ===");
        ArrayList<String> repetidas = new ArrayList<>(Arrays.asList("hola", "mundo", "hola", "java", "hola"));
        System.out.println("Lista: " + repetidas);
        HashMap<String, Integer> frecs = CadenasUtil.contarFrecuencias(repetidas);
        System.out.println("Frecuencias: " + frecs);

        System.out.println("\n=== 8. CLASIFICADOR DE PALABRAS ===");
        System.out.println("Mapa de frecuencias: " + frecs);
        ArrayList<String> masFrecuentes = CadenasUtil.filtrarPorFrecuencia(frecs, 2);
        System.out.println("Palabras con frecuencia >= 2: " + masFrecuentes);

        System.out.println("\n=== 9. DEDUPLICACIÓN DE PALABRAS ===");
        String frase = "el gato en el sombrero comio el pescado del gato";
        System.out.println("Frase: \"" + frase + "\"");
        HashSet<String> fraseUnica = CadenasUtil.deduplicarFrase(frase, 3);
        System.out.println("Palabras únicas de >= 3 letras: " + fraseUnica);

        System.out.println("\n=== 10. EL TOPE DE FRECUENCIAS ===");
        HashMap<String, Integer> mapaTopes = new HashMap<>();
        mapaTopes.put("hola", 10);
        mapaTopes.put("mundo", 2);
        System.out.println("Antes del tope: " + mapaTopes);
        CadenasUtil.limitarFrecuencias(mapaTopes, 5);
        System.out.println("Después del tope (máximo 5): " + mapaTopes);

        System.out.println("\n=== PRUEBA DE CASOS EXTREMOS (EDGE CASES) ===");
        // Probar qué pasa con listas vacías o nulas
        NumerosUtil.multiplicar(null, 5); // No marca error gracias al if (lista == null)
        System.out.println("Cuadrados con lista vacía: " + NumerosUtil.cuadradosDePares(new ArrayList<>()));
        System.out.println("Conversor mayúsculas con lista nula: " + CadenasUtil.convertirMayusculas(null));
    }
}
