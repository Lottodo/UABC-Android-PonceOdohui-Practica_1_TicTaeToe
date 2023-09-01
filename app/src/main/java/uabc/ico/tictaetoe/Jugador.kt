package uabc.ico.tictaetoe

class Jugador {

    var espacios = BooleanArray(9)

    fun jugarTurno(pos: Int){
        espacios[pos] = true
    }

    fun reiniciarJugador() {
        espacios = BooleanArray(9)
    }
}