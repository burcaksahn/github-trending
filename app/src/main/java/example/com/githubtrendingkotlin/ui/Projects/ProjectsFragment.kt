package example.com.githubtrendingkotlin.ui.Projects

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.com.githubtrendingkotlin.Adapters.ProjectAdapter
import example.com.githubtrendingkotlin.R

class ProjectsFragment : Fragment() {

    private lateinit var viewModel: ProjectsViewModel
    private lateinit var root: View
    private lateinit var projectsRecycler : RecyclerView
    private lateinit var adapter : ProjectAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_projects, container, false)
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
            FactoryProject(Application(), RepoRepository(key, host , "" , "daily","en"))
        ).get(ProjectsViewModel::class.java)
    }
    private fun getData() {
        Log.d("TAG", "getData: ")
        viewModel.getProjectData().observe(this, Observer {
            adapter.submitList(it)

        })
    }
    private fun initRecycler(fragmentActivity: FragmentActivity){
        projectsRecycler = root.findViewById(R.id.projectRecycler)
        projectsRecycler.layoutManager = LinearLayoutManager(fragmentActivity)
        projectsRecycler.setHasFixedSize(true)

        adapter = ProjectAdapter()
        projectsRecycler.adapter = adapter

    }

}