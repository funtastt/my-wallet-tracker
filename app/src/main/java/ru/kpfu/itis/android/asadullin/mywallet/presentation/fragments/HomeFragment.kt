package ru.kpfu.itis.android.asadullin.mywallet.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.presentation.adapters.CategoryAdapter
import ru.kpfu.itis.android.asadullin.mywallet.databinding.FragmentHomeBinding
import ru.kpfu.itis.android.asadullin.mywallet.data.local.repositories.CategoryRepositoryImpl

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private val categories = CategoryRepositoryImpl.categories
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        with(binding) {
            rvCategories.layoutManager = GridLayoutManager(activity, 2)
            rvCategories.adapter = CategoryAdapter(categories)
        }
    }

}