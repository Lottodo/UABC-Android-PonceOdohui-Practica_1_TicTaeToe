package uabc.ico.tictaetoe

//import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val juego: Juego = Juego()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var line: ImageView = findViewById(R.id.diagonalImageView) //Para voltear usa scaleX
        line.alpha = 0.0F
        line = findViewById(R.id.rectaImageView)
        line.alpha = 0.0F

    }

    @SuppressLint("ResourceAsColor")
    fun presionarBoton(view: View?) {


        val turno: Int = juego.jugarTurno()
        val simbolo: Int


        if(turno != 2) {
            simbolo = if (turno == 0) R.drawable.x else R.drawable.o
            var imgV: ImageView? = null
            when (view) {
                findViewById<ImageView>(R.id.imageButton00) -> imgV = findViewById(R.id.imageButton00)
                findViewById<ImageView>(R.id.imageButton01) -> imgV = findViewById(R.id.imageButton01)
                findViewById<ImageView>(R.id.imageButton02) -> imgV = findViewById(R.id.imageButton02)
                findViewById<ImageView>(R.id.imageButton10) -> imgV = findViewById(R.id.imageButton10)
                findViewById<ImageView>(R.id.imageButton11) -> imgV = findViewById(R.id.imageButton11)
                findViewById<ImageView>(R.id.imageButton12) -> imgV = findViewById(R.id.imageButton12)
                findViewById<ImageView>(R.id.imageButton20) -> imgV = findViewById(R.id.imageButton20)
                findViewById<ImageView>(R.id.imageButton21) -> imgV = findViewById(R.id.imageButton21)
                findViewById<ImageView>(R.id.imageButton22) -> imgV = findViewById(R.id.imageButton22)
            }
            if (imgV != null) {
                imgV.alpha = 1.0F
                imgV.setImageResource(simbolo)
            }
        }


    }


    /*fun dibujarBarraGanadora(diagonal: Boolean, vertical: Boolean, posicion: Int) {
        if(diagonal) {
            val diag: ImageView = findViewById(R.id.diagonalImageView)
            diag.alpha = 1.0F


            if(posicion == 0) //posicion = 0 izq a der, posicion = 1 der a izq
                diag.scaleX = 1F
            else
                diag.scaleX = -1F
        }
        else {
            val recta: ImageView = findViewById(R.id.rectaImageView)                                     //DEBUG

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
    }*/
}