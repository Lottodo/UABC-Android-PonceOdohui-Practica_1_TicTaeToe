package uabc.ico.tictaetoe

import android.util.Log

class Juego {

    val jugador1: Jugador = Jugador()
    val jugador2: Jugador = Jugador()
    var turno: Boolean = false //
    var movimientos: Int = 0
    var espacios = BooleanArray(9)

    //Variable posicion se comporta tomando valores de 0 a 9
    fun jugarTurno(pos: Int) : Int{
        //Actualizar posiciones
        if(movimientos<9) {
            movimientos+=2

            espacios[pos] = true
            jugador1.jugarTurno(pos)
            return pos
        }
        //No hacer nada
     return -1
    }

    fun jugarTurnoCPU(): Int {
        val espacioLibre = getEspacioLibreRandom()
        Log.d("JUEGO","Espacio libre:"+espacioLibre)
        espacios[espacioLibre] = true
        jugador2.jugarTurno(espacioLibre)

        if(espacios[espacioLibre]) Log.d("JUEGO","LUGAR "+espacioLibre+" OCUPADO")

        return espacioLibre
    }

    fun verificarPosicionDisponible(posicion: Int) : Boolean {
        return !espacios[posicion]
    }

    fun getEspacioLibreRandom(): Int {
        val espaciosLibres = mutableListOf<Int>()

        espacios.forEachIndexed { index, value ->
            if(!value) espaciosLibres.add(index)
        }

        return espaciosLibres.random()
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