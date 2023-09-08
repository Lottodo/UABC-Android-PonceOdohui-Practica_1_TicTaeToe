package uabc.ico.tictaetoe

//import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {

    private val juego: Juego = Juego()
    private lateinit var turnoV: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)



        var iV: ImageView = findViewById(R.id.diagonalImageView) //Para voltear usa scaleX
        iV.alpha = 0.0F
        iV = findViewById(R.id.rectaImageView)
        iV.alpha = 0.0F

        turnoV = findViewById(R.id.turnoView)
        turnoV.setImageResource(R.drawable.x)

    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    fun presionarBoton(view: View?) {
        val posicion: Int = getImageButtonId(view)

        if(juego.verificarPosicionDisponible(posicion)) {
            actualizarTablero(false,juego.jugarTurno(posicion))
            if(!juego.espacios.all { it }) actualizarTablero(true,juego.jugarTurnoCPU())

            if (juego.movimientos>=9) {
                val reinicioV: View = findViewById(R.id.reinicioView)
                reinicioV.alpha = 1.0F; reinicioV.isClickable = true
                turnoV.alpha=0.0F
                val tV: TextView = findViewById(R.id.jugandoView)
                tV.text="empate"
            }

            if (juego.verificarGanador(juego.jugador1) != -1) {
                Toast.makeText(applicationContext,"GANÓ EL JUGADOR",Toast.LENGTH_LONG).show()
                dibujarGanador(juego.verificarGanador(juego.jugador1), false)
            }
            if (juego.verificarGanador(juego.jugador2) != -1) {
                Toast.makeText(applicationContext,"GANÓ EL CPU",Toast.LENGTH_LONG).show()
                dibujarGanador(juego.verificarGanador(juego.jugador2), true)
            }
        }

    }

    private fun getImageButtonId(view: View?): Int {
        when (view) {
            findViewById<ImageView>(R.id.imageButton00) -> return 0 //00
            findViewById<ImageView>(R.id.imageButton01) -> return 1 //01
            findViewById<ImageView>(R.id.imageButton02) -> return 2 //02
            findViewById<ImageView>(R.id.imageButton10) -> return 3  //10
            findViewById<ImageView>(R.id.imageButton11) -> return 4  //11
            findViewById<ImageView>(R.id.imageButton12) -> return 5  //12
            findViewById<ImageView>(R.id.imageButton20) -> return 6  //20
            findViewById<ImageView>(R.id.imageButton21) -> return 7  //21
            findViewById<ImageView>(R.id.imageButton22) -> return 8  //22
        }
        return -1
    }

    private fun actualizarTablero(jugador: Boolean, pos: Int) {
        val simbolo: Int
        simbolo = if(jugador) R.drawable.x else R.drawable.o

        var iV: ImageView? = null

        when (pos) {
            0 -> iV = findViewById<ImageView>(R.id.imageButton00)
            1 -> iV = findViewById<ImageView>(R.id.imageButton01)
            2 -> iV = findViewById<ImageView>(R.id.imageButton02)
            3 -> iV = findViewById<ImageView>(R.id.imageButton10)
            4 -> iV = findViewById<ImageView>(R.id.imageButton11)
            5 -> iV = findViewById<ImageView>(R.id.imageButton12)
            6 -> iV = findViewById<ImageView>(R.id.imageButton20)
            7 -> iV = findViewById<ImageView>(R.id.imageButton21)
            8 -> iV = findViewById<ImageView>(R.id.imageButton22)
        }
        iV?.alpha = 1.0F
        iV?.setImageResource(simbolo)



    }


    @SuppressLint("SetTextI18n")
    private fun dibujarGanador(linea: Int, jugador: Boolean) {

        //False: Jugador 1, True: Jugador 2
        when(linea) {
            0 -> dibujarBarraGanadora(0)
            1 -> dibujarBarraGanadora(1)
            2 -> dibujarBarraGanadora(false,0)
            3 -> dibujarBarraGanadora(false,1)
            4 -> dibujarBarraGanadora(false,2)
            5 -> dibujarBarraGanadora(true,0)
            6 -> dibujarBarraGanadora(true,1)
            7 -> dibujarBarraGanadora(true,2)
        }

        val reinicioV = findViewById<ImageView>(R.id.reinicioView)
        reinicioV.alpha = 1.0F; reinicioV.isClickable = true

        val jugandoV: TextView = findViewById(R.id.jugandoView)
        jugandoV.text = "HA GANADO"
        val turnoV: ImageView = findViewById(R.id.turnoView)
        if(jugador) turnoV.setImageResource(R.drawable.x)
        else turnoV.setImageResource(R.drawable.o)
    }

    private fun dibujarBarraGanadora(posicion: Int) {
        val diag: ImageView = findViewById(R.id.diagonalImageView)
        diag.alpha = 1.0F

        if(posicion == 0) //posicion = 0 izq a der, posicion = 1 der a izq
            diag.scaleX = 1F
        else
            diag.scaleX = -1F
    }

    private fun dibujarBarraGanadora(vertical: Boolean, posicion: Int) {
            val recta: ImageView = findViewById(R.id.rectaImageView)

            recta.alpha = 1.0F
            val pos0Aux: ImageView = findViewById(R.id.imageButton00)
            val pos1Aux: ImageView = findViewById(R.id.imageButton11)
            val pos2Aux: ImageView = findViewById(R.id.imageButton22)

            if (vertical) {
                recta.rotation = 0F
                recta.y = pos0Aux.y + (pos0Aux.height.toFloat()/4)
                when(posicion) {
                    0 -> { recta.x = pos0Aux.x + (pos0Aux.width.toFloat()/4)}
                    1 -> { recta.x = pos1Aux.x + (pos0Aux.width.toFloat()/4)}
                    2 -> { recta.x = pos2Aux.x + (pos0Aux.width.toFloat()/4)}
                }
            } else {
                recta.rotation = 90F
                recta.x = pos0Aux.x + pos0Aux.width.toFloat()*1.5F///4)
                when(posicion) {
                    0 -> { recta.y = pos0Aux.y - recta.height/4 - pos0Aux.height/4}
                    1 -> { recta.y = pos1Aux.y - recta.height/4 - pos0Aux.height/4}
                    2 -> { recta.y = pos2Aux.y - recta.height/4 - pos0Aux.height/4}
                }
            }

    }

    @SuppressLint("CutPasteId", "SetTextI18n")
    fun reiniciarJuego(view: View?) {
        juego.reiniciarJuego()

        turnoV = findViewById(R.id.turnoView)
        turnoV.setImageResource(R.drawable.x)

        val tV: TextView = findViewById(R.id.jugandoView)
        tV.text = "jugando"

        var iV: ImageView = findViewById(R.id.diagonalImageView) //Para voltear usa scaleX
        iV.alpha = 0.0F
        iV = findViewById(R.id.rectaImageView)
        iV.alpha = 0.0F
        iV = findViewById(R.id.imageButton00); iV.alpha = 0.0F
        iV = findViewById(R.id.imageButton01); iV.alpha = 0.0F
        iV = findViewById(R.id.imageButton02); iV.alpha = 0.0F
        iV = findViewById(R.id.imageButton10); iV.alpha = 0.0F
        iV = findViewById(R.id.imageButton11); iV.alpha = 0.0F
        iV = findViewById(R.id.imageButton12); iV.alpha = 0.0F
        iV = findViewById(R.id.imageButton20); iV.alpha = 0.0F
        iV = findViewById(R.id.imageButton21); iV.alpha = 0.0F
        iV = findViewById(R.id.imageButton22); iV.alpha = 0.0F
        iV = findViewById(R.id.turnoView); iV.alpha = 1.0F

        if (view != null) {
            view.alpha = 0.0F
            view.isClickable = false
        }
    }
}