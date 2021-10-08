package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class LifeCycleAppCompatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG_LIFECYCLE,  getLocalClassName() + ": Entered the onCreate() method")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG_LIFECYCLE, getLocalClassName() + ": Entered the onStart() method")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG_LIFECYCLE, getLocalClassName() + ": Entered the onResume() method")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG_LIFECYCLE, getLocalClassName() + ": Entered the onPause() method")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG_LIFECYCLE, getLocalClassName() + ": Entered the onStop() method")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG_LIFECYCLE, getLocalClassName() + ": Entered the onRestart() method")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG_LIFECYCLE, getLocalClassName() + ": Entered the onDestroy() method")
    }

    companion object {
        const val TAG_LIFECYCLE = "LogLifeCycle"
    }
}