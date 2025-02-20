package com.example.endocalendar.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.endocalendar.R
import com.example.endocalendar.databinding.DialogMiDialogBinding


class MiDialogFragment:DialogFragment() {
    private var _binding: DialogMiDialogBinding? = null
    private val binding get() = _binding!!
    private lateinit var linearLayout : LinearLayout
    private lateinit var boton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogMiDialogBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linearLayout = binding.linearContenedore
        boton = binding.boton

        equis()

        boton.setOnClickListener{
            dismiss()//cierra el dialogFragment
            findNavController().navigate(R.id.nav_verdoctor)}
        
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setGravity(Gravity.CENTER)  // Esto centrará el diálogo


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun equis() {
        val doc = layoutInflater.inflate(R.layout.go_lo_doctor, linearLayout, false)
        val doc2 = layoutInflater.inflate(R.layout.go_lo_doctor, linearLayout, false)
        val texto = doc.findViewById<  TextView >(R.id.paciente)
        texto.text= "ejemplo 1"

        linearLayout.addView(doc)
        linearLayout.addView(doc2)

    }

}
