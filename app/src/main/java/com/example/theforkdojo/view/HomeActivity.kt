package com.example.theforkdojo.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.theforkdojo.R
import com.example.theforkdojo.data.HomeRepository
import com.example.theforkdojo.domain.Action
import com.example.theforkdojo.presenter.HomePresenter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeView {

    //Injection
    private val presenter = HomePresenter(this, HomeRepository())

    private lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeAdapter = HomeAdapter()
        recycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = homeAdapter
        }

        presenter.initialize()
    }

    override fun displayMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun displayActions(actions: List<Action>) {
        homeAdapter.setItems(actions)
    }

}
