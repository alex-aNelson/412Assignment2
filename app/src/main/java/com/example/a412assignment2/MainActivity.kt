package com.example.a412assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a412assignment2.ui.theme._412Assignment2Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.Button
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //request custom permission at runtime
        if (ContextCompat.checkSelfPermission(
                this,
                "com.example.a412assignment2.MSE412"
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf("com.example.a412assignment2.MSE412"),
                100
            )
        }

        enableEdgeToEdge()
        setContent {
            _412Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Mainscreen(
                        name = "Alexander Nelson", studentID = 1413384,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Mainscreen(name: String, studentID: Int, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Surface(color = Color.Blue) {
        Column(
            //styling to make page bigger
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "My name is $name and my student id is $studentID",
                modifier = modifier.padding(24.dp)
            )

            //Explicit button
            Button(
                onClick = {
                    // Explicit intent to start SecondActivity
                    val intent = Intent(context, SecondActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Start Activity Explicitly")
            }

            //Implicit button
            Button(
                onClick = {
                    val intent = Intent("com.example.a412assignment2.OPEN_SECOND_ACTIVITY")
                    context.startActivity(intent)

                }
            ) {
                Text("Start Activity Implicitly")
            }

            //start of assignment 4
            // View Image Activity button
            Button(
                onClick = {
                    val intent = Intent(context, ViewImageActivity::class.java)
                    context.startActivity(intent)
                }
            ) {
                Text("View Image Activity")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainscreenPreview() {
    _412Assignment2Theme {
        Mainscreen("Alexander Nelson", 1413384)
    }
}