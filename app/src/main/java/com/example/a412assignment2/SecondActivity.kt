package com.example.a412assignment2
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import com.example.a412assignment2.ui.theme._412Assignment2Theme
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a412assignment2.MainActivity


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _412Assignment2Theme {
                SecondScreen()
            }
        }
    }

    @Composable
    fun SecondScreen() {
        val context = LocalContext.current

        Column(
            //styling to make page bigger
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            //Header
            Text(
                text = "Mobile Software Engineering Challenges:",
                style = MaterialTheme.typography.headlineSmall
            )
            //List of data using trimToIndent to make the styling look better
            Text(
                text = """
              1. Limited battery and performance
              2. Handling different screen sizes
              3. Network reliability
              4. Security and privacy concerns
              5. App lifecycle management
            """.trimIndent()
            )
            //button to go back to main activity
            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Main Activity")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SecondScreenPreview() {
        _412Assignment2Theme {
            SecondScreen()
        }
    }
}

