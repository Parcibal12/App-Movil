package com.example.layouts2

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.layouts2.ui.theme.Layouts2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Layouts2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaDePermisosMindLog()
                }
            }
        }
    }
}

@Composable
fun PantallaDePermisosMindLog() {
    val contexto = LocalContext.current

    val permisoMapa = Manifest.permission.ACCESS_FINE_LOCATION
    val permisoNotificaciones = Manifest.permission.POST_NOTIFICATIONS

    var estadoPermisoMapa by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                contexto,
                permisoMapa
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val lanzadorPermisoMapa = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { fueConcedido ->
            estadoPermisoMapa = fueConcedido
        }
    )

    var estadoPermisoNotificaciones by remember {
        mutableStateOf(
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ContextCompat.checkSelfPermission(
                    contexto,
                    permisoNotificaciones
                ) == PackageManager.PERMISSION_GRANTED
            } else {
                true
            }
        )
    }

    val lanzadorPermisoNotificaciones = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { fueConcedido ->
            estadoPermisoNotificaciones = fueConcedido
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            "Tu app 'MindLog' necesita tu ubicación para registrar la métrica de 'Lugar'.",
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            lanzadorPermisoMapa.launch(permisoMapa)
        }) {
            Text("Permiso de Ubicación")
        }

        Text(
            if (estadoPermisoMapa)
                "Estado: CONCEDIDO"
            else
                "Estado: DENEGADO"
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            "Tu app 'MindLog' necesita enviar notificaciones para tus recordatorios y rachas.",
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                lanzadorPermisoNotificaciones.launch(permisoNotificaciones)
            }
        }) {
            Text("Permiso de Notificaciones")
        }

        Text(
            if (estadoPermisoNotificaciones)
                "Estado: CONCEDIDO"
            else
                "Estado: DENEGADO"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PermissionScreenPreview() {
    Layouts2Theme {
        PantallaDePermisosMindLog()
    }
}