package com.example.endocalendar.ui.home

import android.graphics.drawable.Drawable

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.applandeo.materialcalendarview.CalendarDay
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.EventDay
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import com.example.endocalendar.R
import com.example.endocalendar.databinding.FragmentHomeBinding
import java.time.LocalDateTime

import java.time.ZoneId
import java.util.Calendar
import java.util.Date



class HomeFragment : Fragment() {

    private lateinit var linearLayout : LinearLayout
private lateinit var calendarView : CalendarView
private var events : MutableMap<String,String> = mutableMapOf()



private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root



    return root




  }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        linearLayout = binding.linearContenedor
        // Inflar el ConstraintLayout desde su archivo XML
        val golocita = layoutInflater.inflate(R.layout.go_lo_cita, linearLayout, false)
        val golo = layoutInflater.inflate(R.layout.go_lo_cita, linearLayout, false)
        val tecsto = golocita.findViewById<TextView>(R.id.paciente)
        tecsto.text= "Loayza Salas"

        linearLayout.addView(golocita)
        linearLayout.addView(golo)



         calendarView = binding.calendarView

        val calendars : ArrayList<CalendarDay> = ArrayList()
        val localDateTime  : LocalDateTime = LocalDateTime.now()

        val calendar = localDateTime.toCalendar()

        val calendarDay = CalendarDay(calendar)



       // calendarDay.labelColor = R.color.red
        calendarDay.backgroundResource=R.drawable.replsntr
        //calendarDay.selectedBackgroundResource = R.drawable.ic_dot


        ////////////////////////////////////////////////////////////////////////////////

        // Obtén el ícono que deseas usar como superíndice
        val superScriptIcon: Drawable = ContextCompat.getDrawable(this@HomeFragment.requireContext() , R.drawable.tres_circulos)!!
        val superScriptIconnn: Drawable = ContextCompat.getDrawable(this@HomeFragment.requireContext() , R.drawable.dos_circulos)!!
        val superScriptIconn: Drawable = ContextCompat.getDrawable(this@HomeFragment.requireContext() , R.drawable.un_circulo)!!
        // Define los días específicos que deseas decorar
        val eventDays = listOf(
            EventDay(getCalendar(2025, 2, 15), superScriptIcon),
            EventDay(getCalendar(2025, 2, 20), superScriptIconnn),
            EventDay(getCalendar(2025, 2, 25), superScriptIconn)
        )

        // Agrega los eventos al calendario
        calendarView.setEvents(eventDays)


        //////////////////////////////////////////////////////////////////////////////////////


        //////////////////////////////////////////////////////////////////////////////////////
        calendars.add(calendarDay)
        events["20-02-2025"] = "Joshe´s Day"
        calendarView.setCalendarDays(calendars)

        calendarView.setOnDayClickListener(object : OnDayClickListener{
            override fun onDayClick(eventDay: EventDay) {

                // Obtén la fecha del día clickeado
                val clickedDay = eventDay.calendar
                // Formatea la fecha
                val day = String.format("%02d", clickedDay.get(Calendar.DAY_OF_MONTH))
                val month = String.format("%02d", clickedDay.get(Calendar.MONTH) + 1) // Los meses en Calendar van de 0 a 11
                val year = clickedDay.get(Calendar.YEAR)

                prueeba(year,month,day)

                val fecha = "$day/$month/$year"
                val bundle = Bundle().apply {
                    putString("nombre", fecha)
                    putInt("edad", 25)
                }
                //funcioma de ptm
                findNavController().navigate(R.id.nav_datos,bundle)

                //Toast.makeText(this@HomeFragment.requireContext(), "Prrillo lo lograste $day$month$year", Toast.LENGTH_SHORT).show()


            }
        })






    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun LocalDateTime.toCalendar(): Calendar {
        val instant = this.atZone(ZoneId.systemDefault()).toInstant()
        val date = Date.from(instant)

        return Calendar.getInstance().apply {
            time = date
        }
    }

    private fun prueeba(year: Int, month: String, day: String) {
        val golocita = layoutInflater.inflate(R.layout.go_lo_cita, linearLayout, false)
        val fecha: TextView = golocita.findViewById(R.id.fecha)
        fecha.text = "$day/$month/$year"
        linearLayout.addView(golocita)
    }

    private fun getCalendar(year: Int, month: Int, day: Int): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, day) // Meses en Calendar van de 0 a 11
        return calendar
    }



}

