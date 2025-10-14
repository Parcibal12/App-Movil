/*
EJERCICIO 22:

22. Número espejo (10 puntos):
Instrucciones:
Crea un programa que determine si un número enetero es un número espejo
(palíndromo), es decir, que se lee igual al derecho y al revés.

Ejemplo: 121, 1331, 909 son números espejo.
Restricciones: Sin usar conversiones de tipo
    Entrada: 1221
    Salida: Es un número espejo

    Entrada: 1234
    Salida: No es un número espejo
*/

//Solución:
fun esNumeroEspejo(numero: Int): Boolean {
    var original = numero
    var invertido = 0

    while (original != 0) {
        val digito = original % 10
        invertido = invertido * 10 + digito
        original /= 10
    }

    return numero == invertido
}

fun main() {
    val numeros = listOf(1221, 1234, 121, 909, 1331)
    for (num in numeros) {
        if (esNumeroEspejo(num)) {
            println("$num: Es un número espejo")
        } else {
            println("$num: No es un número espejo")
        }
    }
}

