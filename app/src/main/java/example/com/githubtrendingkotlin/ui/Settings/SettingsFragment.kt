package example.com.githubtrendingkotlin.ui.Settings

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.com.githubtrendingkotlin.Adapters.LanguageAdapter
import example.com.githubtrendingkotlin.Adapters.SpokenLanguagesAdapter
import example.com.githubtrendingkotlin.R

class SettingsFragment : Fragment() {

    private lateinit var viewModel: SettingsViewModel
    private lateinit var root: View

    private lateinit var spokenRecycler:RecyclerView
    private lateinit var languageRecycler:RecyclerView
    private lateinit var spokenAdapter : SpokenLanguagesAdapter
    private lateinit var languageAdapter : LanguageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_settings, container, false)
        activity?.let { initRecycler(it) }
        initialVM()
        getData()
        return root
    }
    private fun initialVM(){
        val key = "966dd09665mshfee82873a81b1f5p1a2d3bjsnb22c69531b3e"
        val host = "github-trending.p.rapidapi.com"
        viewModel = ViewModelProvider(
            this,
            FactorySettings(Application(), SpokenLanguagesRepository(key, host ), LanguageRepository(key,host))
        ).get(SettingsViewModel::class.java)
    }
    private fun getData() {
        viewModel.getLanguagesData().observe(this, Observer {
            languageAdapter.submitList(it)

        })
        viewModel.getSpokenLanguagesData().observe(this, Observer {
            spokenAdapter.submitList(it)

        })
    }
    private fun initRecycler(fragmentActivity: FragmentActivity){
        spokenRecycler = root.findViewById(R.id.availableSpokenRecycler)
        spokenRecycler.layoutManager = LinearLayoutManager(fragmentActivity)
        spokenRecycler.setHasFixedSize(true)
        spokenAdapter = SpokenLanguagesAdapter()
        spokenRecycler.adapter = spokenAdapter

        languageRecycler = root.findViewById(R.id.availableLanguageRecycler)
        languageRecycler.layoutManager = LinearLayoutManager(fragmentActivity)
        languageRecycler.setHasFixedSize(true)

        languageAdapter = LanguageAdapter()
        languageRecycler.adapter = languageAdapter

    }
}