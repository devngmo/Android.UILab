package tml.lab.androiduilab.ui.viewmodeldemo

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tml.lab.androiduilab.R

class ViewModelDemoFragment : Fragment() {

    companion object {
        fun newInstance() = ViewModelDemoFragment()
    }

    private lateinit var viewModel: ViewModelDemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.view_model_demo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewModelDemoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
