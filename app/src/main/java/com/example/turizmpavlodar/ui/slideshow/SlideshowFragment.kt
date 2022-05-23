package com.example.turizmpavlodar.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.turizmpavlodar.R
import com.example.turizmpavlodar.databinding.FragmentSlideshowBinding
import com.example.turizmpavlodar.ui.gallery.RestorantAdapter
import com.example.turizmpavlodar.ui.home.HomeItems

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val data = arrayListOf<HomeItems>()
        data.add(HomeItems("Alpenhof", R.drawable.places, "",4.5))
        data.add(HomeItems("Кофейня Крендель", R.drawable.places2,  "", 4.0))
        data.add(HomeItems("Зимняя Вишня", R.drawable.places3,  "", 4.5))
        data.add(HomeItems("Velvet", R.drawable.places4,  "",4.0))
        data.add(HomeItems("Гриль-бар \"Veranda\"", R.drawable.places5,  "",4.0))

        val adapter = context?.let { PlacesAdapter(data, it) }
        binding.recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}