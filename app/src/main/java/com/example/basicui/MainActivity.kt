package com.example.basicui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicui.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import splitties.toast.toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.sendEmailFab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
            sendEmail("macha@chillcoding.com", "Hi", "Hello!")
        }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sendEmail(to: String, subject: String, msg: String) {
        val emailIntent = Intent(Intent.ACTION_SEND)
         emailIntent.run {
             data = Uri.parse("mailto:")
             type = "text/plain"
             putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
             putExtra(Intent.EXTRA_SUBJECT, subject)
             putExtra(Intent.EXTRA_TEXT, msg)
         }

        try {
            startActivity(Intent.createChooser(emailIntent, getString(R.string.title_send_email)))
        } catch (ex: ActivityNotFoundException) {
            toast(R.string.toast_error_send_email)
            Log.e(MainActivity::class.simpleName, "Error while sending email")
        }
    }
}