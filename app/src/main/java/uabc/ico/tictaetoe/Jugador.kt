package uabc.ico.tictaetoe

class Jugador {

    var espacios = BooleanArray(9)

    fun jugarTurno(pos: Int){
        espacios[pos] = true
    }
}