package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class LifeCycleAppCompatActivity : AppCompatActivity() {

    private fun logLifeCycleFunction(function: String) {
        Log.i(TAG_LIFECYCLE, "$localClassName: Entered the $function method")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLifeCycleFunction("onCreate()")
    }

    override fun onStart() {
        super.onStart()
        logLifeCycleFunction("onStart()")
    }

    override fun onResume() {
        super.onResume()
        logLifeCycleFunction("onResume()")
    }

    override fun onPause() {
        super.onPause()
        logLifeCycleFunction("onPause()")
    }

    override fun onStop() {
        super.onStop()
        logLifeCycleFunction("onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        logLifeCycleFunction("onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifeCycleFunction("onDestroy()")
    }

    companion object {
        private const val TAG_LIFECYCLE = "LogLifeCycle"
    }
}