package com.example.adaptador

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adaptador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.rvwNews.layoutManager = LinearLayoutManager(this)
        binding.rvwNews.adapter = NoticiaAdapter(getNews())
    }

    fun getNews(): List<Noticia> {
        val noticias = listOf(Noticia("Titulo 1", "Descripcion 1"),
            Noticia("Titulo 2", "Descripcion 2"),
            Noticia("Titulo 3", "Descripcion 3"),
            Noticia("Titulo 4", "Descripcion 4"),
            Noticia("Titulo 5", "Descripcion 5"),
            Noticia("Titulo 6", "Descripcion 6")
            }
    return noticias
    }
}