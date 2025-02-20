package com.example.endocalendar.ui.doctor

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.endocalendar.R
import com.example.endocalendar.databinding.FragmentDoctorBinding
import com.example.endocalendar.databinding.FragmentGalleryBinding
import com.example.endocalendar.ui.gallery.GalleryViewModel

class DoctorFragment : Fragment() {



    private var _binding: FragmentDoctorBinding? = null
    private val binding get() = _binding!!
    private lateinit var linearLayout : LinearLayout



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(DoctorViewModel::class.java)

        _binding = FragmentDoctorBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayout = binding.linearContenedor
        val doc = layoutInflater.inflate(R.layout.go_lo_doctor, linearLayout, false)
        val doc2 = layoutInflater.inflate(R.layout.go_lo_doctor, linearLayout, false)
        linearLayout.addView(doc)
        linearLayout.addView(doc2)

        doc.setOnClickListener {

            findNavController().navigate(R.id.nav_verdoctor)

        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
