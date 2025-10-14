/*
EJERCICIO: 21

21. Problema: El cuarto del caos (10 puntos):
Bit es un chico muy travieso y descuidado, tiene su cuarto muy desordenado y hasta
el momento eso no fue algo que le preocupara, Sin embargo, le han pedido que 
lleve a la escuela su colección de númerso enteros, pero el el problema es que tiene su
cuarto tan desordenado que tiene números enteros, strings y otros tipos de datos
que no puede encontrar todos los ejemplares y necesita tu ayuda.

Intruccinones
Ayuda a Bit a clasificar y obtener todos los números enteros de su cuarto para que 
pueda llevarlos a su escuela.

Crea una función con el siguiente formato:
fun classifyIntegers(items: List<Any>) : List<Int> {
    // Escribe tu código aquí
    // retorna tu resultado
}

Y retorna una lista solo de números enteros para ayudar a cumplir la tarea de Bit.
La lista puede estar en culquier orden, solo se necesita obtener una correcta clasificación.

Ejemplos:
val items : List <Any> = listOf(1, 2, 3, "pc", true, 1.2, 0)
val result = classifyIntegers(items)
println(result) // Salida: [1, 2, 3, 0]

val items: List<Any> = listOf("itemA", "itemB", true, false)
val result = classifyIntegers(items)
println(result) // Salida: []

*/

//Solución:

fun classifyIntegers(items: List<Any>): List<Int> {
    return items.filterIsInstance<Int>()
}

fun main() {
    val items1: List<Any> = listOf(1, 2, 3, "pc", true, 1.2, 0)
    val result1 = classifyIntegers(items1)
    println(result1) 

    val items2: List<Any> = listOf("itemA", "itemB", true, false)
    val result2 = classifyIntegers(items2)
    println(result2) 
}