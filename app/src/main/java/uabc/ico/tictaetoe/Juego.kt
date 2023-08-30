package uabc.ico.tictaetoe

class Juego {

    val jugador1: Jugador? = null
    val jugador2: Jugador? = null
    var turno: Boolean = false //
    var movimientos: Int = 0

    fun jugarTurno(): Int{
        if(movimientos<9) {
            if (turno==false) return 0
            else return 1

            turno = !turno
        }
        return 2
    }

}