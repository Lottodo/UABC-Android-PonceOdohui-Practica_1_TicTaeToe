package uabc.ico.tictaetoe

class JugadorCPU {
    fun jugarFicha(espaciosActuales: BooleanArray): Int {
        val espaciosLibres = mutableListOf<Int>()

        for((index,espacio) in espaciosActuales.withIndex()) {
            if (espacio) {
                espaciosLibres.add(index)
            }
        }

        return espaciosLibres.random()
    }
}