package com.cdr.practicetaskjetpackcomposearticle.presentation.newEmployee

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cdr.practicetaskjetpackcomposearticle.ui.theme.PracticeTaskJetpackComposeArticleTheme

class NewEmployeeActivity : ComponentActivity() {

    private val viewModel: NewEmployeeViewModel = NewEmployeeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTaskJetpackComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewEmployeeContent(activity = this, viewModel = viewModel)
                }
            }
        }
    }

    companion object {
        fun newIntent(activity: Activity): Intent =
            Intent(activity, NewEmployeeActivity::class.java)
    }
}