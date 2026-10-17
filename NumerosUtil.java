package org.uabc.ic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class NumerosUtil {

    // 1. El multiplicador
    public static void multiplicar(ArrayList<Integer> lista, int factor) {
        if (lista == null) return;

        // replaceAll recorre la lista y reemplaza cada uno por el resultado de la lambda
        lista.replaceAll(numero -> numero * factor);
    }

    // 4. Cuadrados Unicos
    public static HashSet<Integer> cuadradosDePares(ArrayList<Integer> lista) {
        if (lista == null) return new HashSet<>();

        return (HashSet<Integer>) lista.stream()
                .filter(n -> n % 2 == 0)      // deja pasar solo los numeros pares
                .map(n -> n * n)              // eleva cada numero al cuadrado
                .collect(Collectors.toSet()); // recolecta
    }
}
