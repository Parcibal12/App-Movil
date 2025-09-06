fun main() {
    val nombreCompleto = "Daniel Irigoyen Miranda"
    val nombreMateria = "Aplicaciones Móviles"
    val peso = 54
    val altura = 1.68
    val edad = 20
    

    val edadEsPar: Boolean = (edad % 2 == 0)

    val genero = "Masculino"

    println("Hola, mi nombre es $nombreCompleto.")
    println("Estoy en la materia de $nombreMateria.")
    println("Mis datos son: Peso: ${peso}kg, Altura: ${altura}m, Edad: $edad años.")
    println("Mi edad es par? $edadEsPar")
    println("Mi género es: $genero")
}