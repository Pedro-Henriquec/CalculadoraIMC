package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        val resultFormatado = String.format("%.2f", result)

        tvResult.text = resultFormatado


        val classificacao = if (result < 18.5f){
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.abaixoDoPeso))
            "ABAIXO DO PESO"
        }else {
            if(result in 18.5f..24.9f) {
                tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.normal))
                "NORMAL"
            }else if(result in 25f..29.9f) {
                tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                "SOBREPESO"
            }else if(result in 30f..39.9f) {
                tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.obesidade))
                "OBESIDADE"
            } else {
                tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.obesidadeGrave))
                "OBESIDADE GRAVE"

            }
        }

    tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return super.onOptionsItemSelected(item)
    }
}

private fun TextView.setTextColor(resultActivity: ResultActivity, normal: String) {

}
