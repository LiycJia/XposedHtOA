package top.programan.xposedht

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val sp = getSharedPreferences("temp", Context.MODE_PRIVATE)
            sp.edit().putString("name", et.text.toString()).apply()
        }
    }
}
