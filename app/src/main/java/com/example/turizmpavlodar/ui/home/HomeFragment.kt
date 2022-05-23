package com.example.turizmpavlodar.ui.home

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.turizmpavlodar.R
import com.example.turizmpavlodar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

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


        val data = arrayListOf<HomeItems>()
        data.add(HomeItems("Saryarka", R.drawable.saryarka, "23000 ₸",3.5))
        data.add(HomeItems("Hotel Irtysh", R.drawable.irtish,  "18000 ₸", 4.6))
        data.add(HomeItems("Dvin Hotel", R.drawable.dvin,  "16000 ₸", 3.9))
        data.add(HomeItems("Sever Hotel", R.drawable.sever,  "17700 ₸",5.0))
        data.add(HomeItems("Garden Park", R.drawable.nurtau,  "12000 ₸",4.2))

        val adapter = context?.let { HomeAdapter(data, it) }
        binding.recyclerView.adapter = adapter

        if (context?.let { ContextCompat.checkSelfPermission(it,android.Manifest.permission.CALL_PHONE) } != PackageManager.PERMISSION_GRANTED) {
            activity?.let {
                ActivityCompat.requestPermissions(
                    it, arrayOf(android.Manifest.permission.CALL_PHONE),
                    0)
            }

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}