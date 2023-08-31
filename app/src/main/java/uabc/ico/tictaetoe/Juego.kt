package uabc.ico.tictaetoe

import android.util.Log

class Juego {

    //val jugador1: Jugador? = null
    //val jugador2: Jugador? = null
    var turno: Boolean = false //
    var movimientos: Int = 0

    fun jugarTurno(): Int{
        if(movimientos<9) {
            turno = !turno
            if (turno==false){
                Log.d("BOTON", "RESULTADO: 0")
                return 0
            }
            else {
                Log.d("BOTON", "RESULTADO: 1")
                return 1

            }
        }
        return 2
    }

}