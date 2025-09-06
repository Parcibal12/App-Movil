fun saludar(saludo: String = "Hola", nombre: String) {
    println("$saludo, mi nombre es $nombre.")
}

fun mostrarGenero(genero: String) {
    println("mi género es.... $genero")
}

fun main() {
    val nombreCompleto = "Daniel Irigoyen Miranda"
    val nombreMateria = "Aplicaciones Móviles"
    val peso = 54
    val altura = 1.68
    val edad = 20
    val edadEsPar: Boolean = (edad % 2 == 0)
    val genero = "Masculino"

    saludar(nombre = nombreCompleto)
    mostrarGenero(genero = genero)
}