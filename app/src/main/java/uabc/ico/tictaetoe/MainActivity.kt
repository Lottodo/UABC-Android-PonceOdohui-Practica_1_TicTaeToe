package uabc.ico.tictaetoe

//import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("ResourceAsColor")
    fun presionarBoton(view: View?) {
        Log.d("BOTON", "PRESIONASTE UN BOTON")
        when(view)
        {
            findViewById<Button>(R.id.button00) -> {
                view?.setAlpha(1.0F)
                view?.setBackgroundResource(R.drawable.o)
                view?.setBackgroundColor(R.color.black)
            }

        }


    }
}