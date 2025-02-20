package com.example.endocalendar.ui.datos

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.endocalendar.R
import com.example.endocalendar.databinding.FragmentDatosBinding
import com.example.endocalendar.ui.MiDialogFragment

class DatosFragment : Fragment() {


    private var _binding: FragmentDatosBinding? = null
    private val binding get() = _binding!!

    private lateinit var textView: TextView
    private lateinit var textViewDos: TextView
    private lateinit var txtFecha: TextView
    private lateinit var layoutDoctor : ConstraintLayout
    private lateinit var linearLayout : LinearLayout
    private lateinit var layoutTratamiento : ConstraintLayout



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(DatosViewModel::class.java)

        _binding = FragmentDatosBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView=binding.textoUno
        textViewDos=binding.textoDos
        txtFecha=binding.txtFecha
        layoutDoctor=binding.layoutDoctor
        layoutTratamiento = binding.layout9
        val nombre = arguments?.getString("nombre") // Recibe el String
        val edad = arguments?.getInt("edad") // Recibe el Int
        textView.text = "Nombre: $nombre, Edad: $edad"
        textViewDos.setOnClickListener{
            val dialog = MiDialogFragment()
            dialog.show(parentFragmentManager,"MiDialogFragment")
            
        }

        txtFecha.text=nombre

        layoutDoctor.setOnClickListener{
            val dialog = MiDialogFragment()
            dialog.show(parentFragmentManager,"MiDialogFragment")
        }

        linearLayout = binding.linearContenedor

        layoutTratamiento.setOnClickListener { tratatamiento() }

    }

    private fun tratatamiento (){
        val golocita = layoutInflater.inflate(R.layout.go_lo_tratamientos, linearLayout, false)
        linearLayout.addView(golocita)
    }
}