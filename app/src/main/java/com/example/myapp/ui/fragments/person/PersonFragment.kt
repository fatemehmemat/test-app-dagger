package com.example.myapp.ui.fragments.person

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.R
import com.example.myapp.data.api.ApiService
import com.example.myapp.databinding.FragmentPersonBinding
import com.example.myapp.ui.adapters.UserAdapters
import com.example.myapp.utils.Status
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PersonFragment : Fragment(), HasAndroidInjector {
    companion object{
        private const val TAG = "PersonFragment"
    }
    private lateinit var binding: FragmentPersonBinding
    private lateinit var userAdapters: UserAdapters

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[PersonViewModel::class.java]
    }

    @Inject
    lateinit var apiService: ApiService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AndroidSupportInjection.inject(this)
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person, container, false)
        setupObserver()
        return binding.root
    }

    private fun setupObserver() {
        viewModel.getUsers()?.observe(viewLifecycleOwner) {
            Log.d(TAG, "setupObserver:status " + it.status)
            Log.d(TAG, "setupObserver:data " + it.data)

            if (it.status == Status.SUCCESS) {
                userAdapters.submitList(it.data)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userAdapters = UserAdapters()
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapters
        }
        
    }
}