package br.com.majoris.taskapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.majoris.taskapp.databinding.ItemTaskBinding
import br.com.majoris.taskapp.ui.data.model.Task

class TaskAdapter(
	private val tasklist : List<Task>

) : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
		return MyViewHolder(
			ItemTaskBinding.inflate(
				LayoutInflater.from(parent.context),
				parent,
				false
			)
		)
	}

	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		val task = tasklist[position]

		holder.binding.textDescription.text = task.description
	}

	override fun getItemCount() = tasklist.size

	inner class MyViewHolder(val binding : ItemTaskBinding)
		: RecyclerView.ViewHolder(binding.root)
}
