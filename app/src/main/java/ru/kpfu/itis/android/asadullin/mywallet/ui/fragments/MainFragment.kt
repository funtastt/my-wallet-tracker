package ru.kpfu.itis.android.asadullin.mywallet.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.main_page_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        val bnvMainPage: BottomNavigationView = requireView().findViewById(R.id.bnv_main_page)

        NavigationUI.setupWithNavController(bnvMainPage, navController)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}