package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishlistAdapter
    private val wishlistItems = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.wishlistRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = WishlistAdapter(wishlistItems)
        recyclerView.adapter = adapter

        val itemNameEditText: EditText = findViewById(R.id.itemName)
        val itemPriceEditText: EditText = findViewById(R.id.itemPrice)
        val itemUrlEditText: EditText = findViewById(R.id.itemUrl)
        val addItemButton: Button = findViewById(R.id.addItemButton)

        addItemButton.setOnClickListener {
            val name = itemNameEditText.text.toString()
            val price = itemPriceEditText.text.toString()
            val url = itemUrlEditText.text.toString()

            if (name.isNotEmpty() && price.isNotEmpty() && url.isNotEmpty()) {
                val newItem = WishlistItem(name, price, url)
                adapter.addItem(newItem)

                // Clear input fields after adding item
                itemNameEditText.text.clear()
                itemPriceEditText.text.clear()
                itemUrlEditText.text.clear()
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}