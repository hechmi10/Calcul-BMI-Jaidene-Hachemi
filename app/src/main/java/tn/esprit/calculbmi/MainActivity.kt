package tn.esprit.calculbmi



import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etWeight:EditText
    private lateinit var etHeight:EditText
    private lateinit var btnCalculateBMI:Button
    private lateinit var tvBMI:TextView
    private lateinit var tvInterpretation:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etWeight=findViewById(R.id.etWeight)
        etHeight=findViewById(R.id.etHeight)
        btnCalculateBMI=findViewById(R.id.btnCalculateBMI)
        tvBMI=findViewById(R.id.tvBMI)
        tvInterpretation=findViewById(R.id.tvInterpretation)
        btnCalculateBMI.setOnClickListener {
            calculateBMI()
        }
    }
    private fun calculateBMI(){
        val weight=etWeight.text.toString().toDoubleOrNull()
        val height=etHeight.text.toString().toDoubleOrNull()
        val bmi= weight?.div((height !!*height))
        tvBMI.text="There is your BMI:$bmi"
        if(bmi !=null) {
            if (bmi < 18.5) {
                tvInterpretation.text = "You're underweight"
            } else if (bmi in 18.5..24.9) {
                tvInterpretation.text = "You're normal"
            } else if (bmi in 25.0..29.9) {
                tvInterpretation.text = "You're overweight"
            } else if (bmi in 30.0..34.9) {
                tvInterpretation.text = "You're obese"
            } else {
                tvInterpretation.text = "You're extremely obese"
            }
        }
    }
}