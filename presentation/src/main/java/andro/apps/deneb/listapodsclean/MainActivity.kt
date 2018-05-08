package andro.apps.deneb.listapodsclean

import andro.apps.deneb.listapodsclean.apodsList.ApodsFragment
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() , ApodsFragment.OnFragmentInteractionListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.container_main, ApodsFragment(), "apodlist")
                .commitNow()


    }


    override fun onFragmentInteraction(uri: Uri) {

    }
}
