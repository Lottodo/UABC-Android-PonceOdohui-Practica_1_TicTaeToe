package uabc.ico.tictaetoe

import android.util.Log

class Juego {

    val jugador1: Jugador = Jugador()
    val jugador2: Jugador = Jugador()
    var turno: Boolean = false //
    var movimientos: Int = 0
    var espacios = BooleanArray(9)

    //Variable posicion se comporta tomando valores de 0 a 9
    fun jugarTurno(pos: Int) { //: Int{
        //Actualizar posiciones
        if(movimientos<9) {
            movimientos++

            espacios[pos] = true
            turno = !turno
            if (turno==false) {
                Log.d("JUEGO", "RESULTADO: 0")
                jugador1.jugarTurno(pos)
            } //return 0 }
            else {
                Log.d("JUEGO", "RESULTADO: 1")
                jugador2.jugarTurno(pos)
            } //return 1 }

        }
        //No hacer nada
     //return 2
    }

    fun verificarPosicionDisponible(posicion: Int) : Boolean {
        return !espacios[posicion] && movimientos<9
    }


    fun verificarGanador(jugador: Jugador): Int {
        val spc = jugador.espacios
        val movAux = movimientos
        movimientos = 9
        if (spc[0]&&spc[4]&&spc[8]) return 0; if (spc[2]&&spc[4]&&spc[6]) return 1 //DIAGONALES
        if (spc[0]&&spc[1]&&spc[2]) return 2; if (spc[3]&&spc[4]&&spc[5]) return 3; if (spc[6]&&spc[7]&&spc[8]) return 4 //HORIZONTALES
        if (spc[0]&&spc[3]&&spc[6]) return 5; if (spc[1]&&spc[4]&&spc[7]) return 6; if (spc[2]&&spc[5]&&spc[8]) return 7 //VERTICALES

        movimientos = movAux
        return -1 //NO GANÓ
    }

    fun reiniciarJuego() {
        movimientos = 0
        espacios = BooleanArray(9)
        turno = false
        jugador1.reiniciarJugador()
        jugador2.reiniciarJugador()
    }
}