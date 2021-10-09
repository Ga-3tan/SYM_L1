package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Activitée  gérant les logs du cycle de vie de l'application
 * @author Alessandro Parrino, Daniel Sciarra, Gaétan Zwick
 * @sdk 29
 * @date 10.10.21
 */
abstract class LifeCycleAppCompatActivity : AppCompatActivity() {

    private fun logLifeCycleFunction(funcName: String) {
        Log.i(TAG_LIFECYCLE, "$localClassName: Entered the $funcName method")
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