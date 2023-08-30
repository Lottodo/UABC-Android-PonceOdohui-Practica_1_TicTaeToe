package uabc.ico.tictaetoe

//import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
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
        Log.d("BOTON", "PRESIONASTE UN BOTON")



        when(view)
        {
            findViewById<ImageView>(R.id.imageButton00) -> {
                view?.alpha = 1.0F
                view?.setBackgroundResource(R.drawable.o)

                dibujarBarraGanadora(true,false,0) //Diag 1
            }
            findViewById<ImageView>(R.id.imageButton01) -> {
                view?.alpha = 1.0F
                view?.setBackgroundResource(R.drawable.o)

                dibujarBarraGanadora(true,false,1) //Diag 2
            }
            findViewById<ImageView>(R.id.imageButton02) -> {
                view?.alpha = 1.0F
                view?.setBackgroundResource(R.drawable.o)

                dibujarBarraGanadora(false,true,0) //vert 0
            }
            findViewById<ImageView>(R.id.imageButton10) -> {
                view?.alpha = 1.0F
                view?.setBackgroundResource(R.drawable.o)

                dibujarBarraGanadora(false,true,1) //vert 1
            }
            findViewById<ImageView>(R.id.imageButton11) -> {
                view?.alpha = 1.0F
                view?.setBackgroundResource(R.drawable.o)

                dibujarBarraGanadora(false,true,2) //vert 2
            }
            findViewById<ImageView>(R.id.imageButton12) -> {
                view?.alpha = 1.0F
                view?.setBackgroundResource(R.drawable.o)

                dibujarBarraGanadora(false,false,0) //hori 0
            }
            findViewById<ImageView>(R.id.imageButton20) -> {
                view?.alpha = 1.0F
                view?.setBackgroundResource(R.drawable.o)

                dibujarBarraGanadora(false,false,1) //hori 1
            }
            findViewById<ImageView>(R.id.imageButton21) -> {
                view?.alpha = 1.0F
                view?.setBackgroundResource(R.drawable.o)

                dibujarBarraGanadora(false,false,2) //hori 2
            }
            findViewById<ImageView>(R.id.imageButton22) -> {
                view?.alpha = 1.0F
                view?.setBackgroundResource(R.drawable.o)
            }

        }


    }

    fun dibujarBarraGanadora(diagonal: Boolean, vertical: Boolean, posicion: Int) {
        if(diagonal) {
            val diag: ImageView = findViewById(R.id.diagonalImageView)
            diag.alpha = 1.0F

            val recta: ImageView = findViewById(R.id.rectaImageView)

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
    }
}