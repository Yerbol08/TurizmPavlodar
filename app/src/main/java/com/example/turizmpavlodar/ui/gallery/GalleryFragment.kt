package com.example.turizmpavlodar.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.turizmpavlodar.R
import com.example.turizmpavlodar.databinding.FragmentGalleryBinding
import com.example.turizmpavlodar.ui.home.HomeAdapter
import com.example.turizmpavlodar.ui.home.HomeItems

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val data = arrayListOf<HomeItems>()
        data.add(HomeItems("Alpenhof", R.drawable.rest_alpenhof, "5000 ₸",4.5))
        data.add(HomeItems("Кофейня Крендель", R.drawable.rest_2,  "6000 ₸", 4.0))
        data.add(HomeItems("Зимняя Вишня", R.drawable.rest_3,  "4000 ₸", 4.5))
        data.add(HomeItems("Velvet", R.drawable.rest_4,  "6000 ₸",4.0))
        data.add(HomeItems("Гриль-бар \"Veranda\"", R.drawable.rest_5,  "5000 ₸",4.0))

        val adapter = context?.let { RestorantAdapter(data, it) }
        binding.recyclerView.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}