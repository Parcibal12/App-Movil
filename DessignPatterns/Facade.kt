import java.util.Date

data class EntradaDiario(
    val id: String,
    val fecha: Date,
    val texto: String,
    val emocion: String,
    val contexto: List<String>,
    val lugar: String? = null
)



private class BaseDatosDiario {
    fun obtenerEntradas(desde: Date, hasta: Date): List<EntradaDiario> {
        println("Fachada: [1] Obteniendo entradas de la base de datos...")
       
        return listOf(
            EntradaDiario("1", Date(), "Día estresante", "Ansiedad", listOf("Trabajo"), "Oficina")
        )
    }
}

private class ServicioAnaliticas {
    fun generarPatrones(entradas: List<EntradaDiario>): String {
        println("Fachada: [2] Analizando ${entradas.size} entradas y generando patrones...")
        return "Reporte de Patrones: Se detectó alta ansiedad en contextos de 'Trabajo'."
    }
}

private class GeneradorReportes {
    fun crearReporte(datosReporte: String): String {
         println("Fachada: [3] Creando archivo de reporte...")
        return "--- REPORTE OFICIAL ---\n$datosReporte\n--- FIN REPORTE ---"
    }
}

private class GestorCompartirArchivos {
    fun compartirArchivo(archivo: String) {
        println("Fachada: [4] Abriendo diálogo de 'Compartir' del sistema operativo...")
        println("Archivo a compartir:\n$archivo")
    }
}


class FachadaReportesMindLog {

    private val baseDatos = BaseDatosDiario()
    private val analiticas = ServicioAnaliticas()
    private val generador = GeneradorReportes()
    private val gestorCompartir = GestorCompartirArchivos()

   
    fun generarYCompartirReporte(desde: Date, hasta: Date) {
        println("\n--- Se llama a 'Exportar reporte' ---")
        
        val entradas = baseDatos.obtenerEntradas(desde, hasta)
        val patrones = analiticas.generarPatrones(entradas)
        val archivoReporte = generador.crearReporte(patrones)
        
        gestorCompartir.compartirArchivo(archivoReporte)
        
        println("--- Proceso de Fachada completado ---")
    }
}


fun main() {
    println("--- Ejemplo del Patrón Facade (Fachada) ---")
    
    val miFachada = FachadaReportesMindLog()

    miFachada.generarYCompartirReporte(Date(), Date())
}