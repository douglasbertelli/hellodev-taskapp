package br.com.majoris.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.majoris.taskapp.R
import br.com.majoris.taskapp.databinding.FragmentDoneBinding
import br.com.majoris.taskapp.databinding.FragmentHomeBinding
import br.com.majoris.taskapp.databinding.FragmentTodoBinding
import br.com.majoris.taskapp.ui.adapter.TaskAdapter
import br.com.majoris.taskapp.ui.data.model.Status
import br.com.majoris.taskapp.ui.data.model.Task

class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter : TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListerns()
        initRecyclerTask(getTasks())
    }

    private fun initListerns() {
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.formTaskFragment)
        }
    }

    private fun initRecyclerTask(taskList: List<Task>) {
        taskAdapter = TaskAdapter(taskList)

        binding.rvTasks.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTasks.setHasFixedSize(true)
        binding.rvTasks.adapter = taskAdapter
    }

    private fun getTasks () = listOf(
        Task("0", "Criar nova tela do app", Status.TODO),
        Task("1", "Validar informações na tela de login", Status.TODO),
        Task("2", "Adicionar nova funcionalidade no app", Status.TODO),
        Task("3", "Salvar token localmente", Status.TODO),
        Task("4", "Criar funcionalidade de logout no app.", Status.TODO),
        Task("5", "Validar os dados do login.", Status.TODO),
        Task("6", "Adicionar funcionalidade de validade login.", Status.TODO),
    )

}