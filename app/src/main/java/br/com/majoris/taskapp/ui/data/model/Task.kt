package br.com.majoris.taskapp.ui.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
	val id: String,
	val description: String
) : Parcelable
