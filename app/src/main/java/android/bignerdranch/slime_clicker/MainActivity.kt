package android.bignerdranch.slime_clicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var currentScore: Int = 0
    var DPS = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgSlime: ImageView = findViewById(R.id.imgSlime)
        val clicki: TextView = findViewById(R.id.clicki)





        imgSlime.setOnClickListener {
            currentScore++
            clicki.text = "$currentScore"

        }

//        killer.setOnClickListener {
//
//            if (currentScore >= 150) {
//                currentScore -= 150
//                DPS += 5
//                clicki.text = "$currentScore"
//            } else {
//                Toast.makeText(
//                    this,
//                    "Недостаточно голды,чтобы купить убийцу дракона!",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }


//            mag.setOnClickListener {
//
//                if (currentScore >= 50) {
//                    currentScore -= 50
//                    DPS += 3
//                    clicki.text = "$currentScore"
//                } else {
//                    Toast.makeText(
//                        this,
//                        "Недостаточно бабок, чтобы купить деда!",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }

        NPC(mag, 3, 50,"Недостаточно бабок, чтобы купить деда!")
        NPC(soldier, 2, 25,"Недастаточно голды, чтобы купить воина!")
        NPC(killer, 5, 150,"Недастаточно голды, чтобы купить убийцу дроконов!")
        if (DPS >= 0) {
            MainScope().launch {
                while (DPS >= 0) {
                    currentScore = currentScore + DPS
                    clicki.text = "$currentScore"
                    delay(1000)


                }
            }
        }
    }


    fun NPC(view: View, dps: Int, gold: Int,text: String) {
        view.setOnClickListener {
            if (currentScore >= gold) {
                currentScore -= gold
                DPS += dps
                clicki.text = "$currentScore"
            } else {
                Toast.makeText(
                    this,text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}


