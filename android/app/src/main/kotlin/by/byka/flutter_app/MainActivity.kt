package by.byka.flutter_app

import android.os.Bundle

import io.flutter.app.FlutterActivity
import io.flutter.plugins.GeneratedPluginRegistrant
import android.widget.Toast
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegistrant.registerWith(this)
        FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w("test", "getInstanceId failed", task.exception)
                        return@OnCompleteListener
                    }

                    // Get new Instance ID token
                    val token = task.result!!.token

                    // Log and toast
//                    val msg = getString(R.string.msg_token_fmt, token)
                    Log.d("test", token)
//                    Toast.makeText(this@MainActivity, token, Toast.LENGTH_SHORT).show()
                    try {
                        val connection = URL("http://172.20.5.48:8080/test/token/$token").openConnection() as HttpURLConnection
                        connection.connect()
                    } catch (e: Exception) {
                        Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
                    }

                })
    }
}
