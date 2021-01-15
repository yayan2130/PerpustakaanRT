package com.example.finalproject

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.Database.data
import com.example.finalproject.adapter.adapter
import com.example.finalproject.viewmodel.BukuViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var toggle:ActionBarDrawerToggle
    lateinit var viewModel: BukuViewModel
    lateinit var adapter: adapter

    override fun onCreate(savedInstanceState: Bundle?) {

        //RECYCLEVIEW
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(
            this@MainActivity,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        ).get(BukuViewModel::class.java)
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.setHasFixedSize(true)

        viewModel.getData().observe(this, Observer {
            this.adapter = adapter(it)
            rv_list.adapter = this.adapter
            adapter.setOnClickListener(object : adapter.OnItemClickListener {
                override fun onClickedItem(barang: data) {
                    val showDetailActivityIntent = Intent(this@MainActivity, detail::class.java)
                    showDetailActivityIntent.putExtra(Intent.EXTRA_SHORTCUT_ID, barang.id)
                    showDetailActivityIntent.putExtra("gambar", barang.gambarBuku)
                    showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, barang.namaBuku)
                    showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, barang.sinopsisBuku)
                    startActivity(showDetailActivityIntent)
                }
            })
        })

        //NAVBAR
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home ->
                    Toast.makeText(applicationContext, "Home", Toast.LENGTH_SHORT).show()
                R.id.AboutMe -> {
                    startActivity(
                        Intent(this, profile::class.java)
                    )
                    true
                }
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}