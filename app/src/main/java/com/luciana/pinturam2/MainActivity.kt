package com.luciana.pinturam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.IllegalArgumentException
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var altura: EditText
    lateinit var largura: EditText
    lateinit var area: TextView
    lateinit var demaos: EditText
    lateinit var rendimento: EditText
    lateinit var consumo: TextView
    lateinit var preco: EditText
    lateinit var resultado: TextView
    lateinit var botaoResultado: Button
    lateinit var botaoLimpar: Button
    lateinit var botaoSair: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        altura = findViewById(R.id.edtAltura)
        largura = findViewById(R.id.edtLargura)
        area = findViewById(R.id.txtArea)
        demaos = findViewById(R.id.edtDemaos)
        rendimento = findViewById(R.id.edtRendimento)
        consumo = findViewById(R.id.txtValorConsumo)
        preco = findViewById(R.id.edtPreco)
        resultado = findViewById(R.id.txtResultado)
        botaoResultado = findViewById(R.id.btnResultado)
        botaoLimpar = findViewById(R.id.btnLimpar)
        botaoSair = findViewById(R.id.btnSair)

        var vAltura: Double
        var vLargura: Double
        var vArea: Double
        var vDemaos: Int
        var vRendimento: Double
        var vConsumo: Double
        var vPreco: Double
        var vResultado: Double

        val dfA = DecimalFormat("#,##0.00")

        altura.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                try {
                    vAltura = altura.text.toString().toDouble()
                } catch (e: IllegalArgumentException) {
                    vAltura = 0.0
                }

                try {
                    vLargura = largura.text.toString().toDouble()
                } catch (e: IllegalArgumentException) {
                    vLargura = 0.0
                }

                vArea = vAltura * vLargura
                area.text = dfA.format(vArea).toString()
            }
        }

        largura.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                try {
                    vAltura = altura.text.toString().toDouble()
                } catch (e: IllegalArgumentException) {
                    vAltura = 0.0
                }

                try {
                    vLargura = largura.text.toString().toDouble()
                } catch (e: IllegalArgumentException) {
                    vLargura = 0.0
                }

                vArea = vAltura * vLargura
                area.text = dfA.format(vArea).toString()
            }
        }

        rendimento.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                try {
                    vDemaos = demaos.text.toString().toInt()
                } catch (e: IllegalArgumentException) {
                    vDemaos = 0
                }

                try {
                    vRendimento = rendimento.text.toString().toDouble()
                } catch (e: IllegalArgumentException) {
                    vRendimento = 0.0
                }

                vArea = area.text.toString().toDouble()

                vConsumo = vArea * vDemaos / vRendimento

                val dfC = DecimalFormat("#,###.000")
                consumo.text = dfC.format(vConsumo).toString()
            }
        }

        botaoResultado.setOnClickListener() {
            try {
                vPreco = preco.text.toString().toDouble()
            } catch (e: IllegalArgumentException) {
                vPreco = 0.0
            }
            vConsumo = Math.ceil(consumo.text.toString().toDouble())
            vResultado = vConsumo * vPreco

            val dfG = DecimalFormat("#,###")
            val dfP = DecimalFormat("#,##0.00")
            resultado.text = dfG.format(vConsumo).toString() + " galões - R$ " + dfP.format(vResultado).toString()
        }

        botaoLimpar.setOnClickListener() {
            limparCampos()
        }

        botaoSair.setOnClickListener() {
            this.finishAffinity()
        }

    }

    private fun limparCampos() {
        altura.text.clear()
        largura.text.clear()
        area.text = ""
        demaos.text.clear()
        rendimento.text.clear()
        consumo.text = ""
        preco.text.clear()
        resultado.text = ""
        altura.requestFocus()
    }
}

