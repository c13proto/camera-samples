package com.android.example.cameraxbasic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.android.example.cameraxbasic.R
import com.android.example.cameraxbasic.databinding.TestFragmentBinding

class TestFragment internal constructor(): Fragment(){
    private var _testFragmentBinding:TestFragmentBinding?=null
    private val testFragmentBinding get() = _testFragmentBinding!!
    /** AndroidX navigation arguments */
    private val args: GalleryFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _testFragmentBinding= TestFragmentBinding.inflate(inflater, container, false)
        return testFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testFragmentBinding.test1.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                Navigation.findNavController(requireActivity(), R.id.fragment_container).navigate(
                    TestFragmentDirections.actionTestFragmentToPermissionsFragment()
                )
            }
        }
        testFragmentBinding.test2.setOnClickListener {
            Toast.makeText(requireContext(),"test2",Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        _testFragmentBinding=null
        super.onDestroyView()
    }
}
