package example.com.githubtrendingkotlin.ui.Developer

import android.app.Application
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.com.githubtrendingkotlin.Adapters.DeveloperAdapter
import example.com.githubtrendingkotlin.R

class DeveloperFragment : Fragment() {

    private lateinit var viewModel: DeveloperViewModel
    private lateinit var root: View
    private lateinit var recyclerAdapter: DeveloperAdapter
    private lateinit var developerRecycler: RecyclerView
    private lateinit var editText: EditText
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_developer, container, false)
        activity?.let {
            initRecycler(it)
        }
        initialUI()
        initialVM()
        //getData()
        return root
    }

    private fun initialUI() {
        editText = root.findViewById(R.id.searchInput)
        editText.addTextChangedListener(textWatcher)
    }

    private fun initialVM() {
        val key = "966dd09665mshfee82873a81b1f5p1a2d3bjsnb22c69531b3e"
        val host = "github-trending.p.rapidapi.com"
        viewModel = ViewModelProvider(
                this,
                FactoryDeveloper(Application(), DevelopersRepo(key, host, "daily", "en"))
        ).get(DeveloperViewModel::class.java)
    }

    private fun getData(language:String) {
        viewModel.getDeveloperData(language).observe(this, Observer {
            recyclerAdapter.submitList(it)

        })
    }

    private fun initRecycler(fragmentActivity: FragmentActivity) {
        developerRecycler = root.findViewById(R.id.developersRecycler)
        developerRecycler.layoutManager = LinearLayoutManager(fragmentActivity)
        developerRecycler.setHasFixedSize(true)

        recyclerAdapter = DeveloperAdapter()
        developerRecycler.adapter = recyclerAdapter

    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(s!!.length>=3 ){
                Log.d("TAG", "onTextChanged: " + s.toString())
                getData(s.toString())
            }
        }

    }
}