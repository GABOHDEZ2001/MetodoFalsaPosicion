package Ejemplos;
import java.util.function.Function;

public class Ejemplo5 {



        // Función para la que se busca la raíz
        public static double funcion(double x) {
            // Aquí debes definir tu propia función
            return Math.pow(x, 2) - 4;
        }

        // Método de la falsa posición para encontrar la raíz en un intervalo [a, b]
        public static double falsaPosicion(Function<Double, Double> funcion, double a, double b, double tolerancia) {
            double c;

            do {
                // Calcular el punto intermedio
                c = (a * funcion.apply(b) - b * funcion.apply(a)) / (funcion.apply(b) - funcion.apply(a));

                // Verificar si c es la raíz o está en el intervalo de tolerancia
                if (funcion.apply(c) == 0 || Math.abs(b - a) < tolerancia) {
                    break;
                }

                // Actualizar el intervalo [a, b] basado en la posición de c
                if (funcion.apply(c) * funcion.apply(a) < 0) {
                    b = c;
                } else {
                    a = c;
                }

            } while (Math.abs(b - a) >= tolerancia);

            return c;
        }

        public static void main(String[] args) {
            // Definir el intervalo [a, b] y la tolerancia
            double a = 0;
            double b = 3;
            double tolerancia = 0.0001;

            // Encontrar la raíz usando el método de la falsa posición
            double raiz = falsaPosicion(Ejemplo5::funcion, a, b, tolerancia);

            // Imprimir la raíz encontrada
            System.out.println("La raíz aproximada es: " + raiz);
        }
    }


