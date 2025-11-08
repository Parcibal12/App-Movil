import java.util.Date

data class EntradaDiario(
    val id: String,
    val fecha: Date,
    val texto: String,
    val emocion: String,
    val contexto: List<String>,
    val lugar: String? = null
)

object PlantillasDiario {
    private val plantillas = mutableMapOf<String, EntradaDiario>()

    init {
        plantillas["ESTRES_LABORAL"] = EntradaDiario(
            id = "plantilla_trabajo",
            fecha = Date(),
            texto = "",
            emocion = "Ansiedad",
            contexto = listOf("Trabajo", "Proyecto"),
            lugar = "Oficina"
        )

        plantillas["TIEMPO_FAMILIAR"] = EntradaDiario(
            id = "plantilla_familia",
            fecha = Date(),
            texto = "",
            emocion = "Alegría",
            contexto = listOf("Familia"),
            lugar = "Casa"
        )
    }


    fun crearEntradaDesdePlantilla(idPlantilla: String): EntradaDiario? {
        val prototipo = plantillas[idPlantilla]
        
        return prototipo?.copy(
            id = "entrada_${System.currentTimeMillis()}",
            fecha = Date()
        )
    }
}

fun main() {
    println("--- Ejemplo del Patrón Prototype ---")
    
    val nuevaEntradaTrabajo = PlantillasDiario.crearEntradaDesdePlantilla("ESTRES_LABORAL")
    
    if (nuevaEntradaTrabajo != null) {
        val entradaFinal = nuevaEntradaTrabajo.copy(
            texto = "Hoy tuve una reunión muy difícil con el equipo de marketing"
        )
        
        println("Nueva entrada creada desde Prototipo:")
        println(entradaFinal)
    } else {
        println("No se encontró la plantilla.")
    }
    
    val nuevaEntradaFamiliar = PlantillasDiario.crearEntradaDesdePlantilla("TIEMPO_FAMILIAR")
    if(nuevaEntradaFamiliar != null) {
        val entradaFinal = nuevaEntradaFamiliar.copy(texto = "Cena en casa de la abuela")
        println("\nNueva entrada creada desde Prototipo:")
        println(entradaFinal)
    }
}