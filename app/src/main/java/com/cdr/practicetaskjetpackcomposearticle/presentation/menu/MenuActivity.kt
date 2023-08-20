package com.cdr.practicetaskjetpackcomposearticle.presentation.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cdr.practicetaskjetpackcomposearticle.ui.theme.PracticeTaskJetpackComposeArticleTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MenuViewModel = MenuViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTaskJetpackComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MenuContent(activity = this, viewModel = viewModel)
                }
            }
        }
    }
}