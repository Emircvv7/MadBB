package com.example.madb

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.madb.databinding.FragmentDoorBinding

class DoorFragment : Fragment() {

    private var _binding: FragmentDoorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoorBinding.inflate(inflater, container, false)

        val containers = listOf(binding.container2, binding.container3, binding.container4, binding.container5)

        for (container in containers) {
            container.setOnClickListener {
                if (binding.yourImageviewId.visibility == View.VISIBLE) {
                    val moveDown = ObjectAnimator.ofFloat(container, "translationY", 0f)
                    moveDown.duration = 500
                    moveDown.start()

                    val moveUp = ObjectAnimator.ofFloat(binding.yourImageviewId, "translationY", -container.height.toFloat())
                    moveUp.duration = 500
                    moveUp.start()
                } else {
                    binding.yourImageviewId.visibility = View.VISIBLE
                    val moveDown = ObjectAnimator.ofFloat(container, "translationY", container.height.toFloat())
                    moveDown.duration = 500
                    moveDown.start()

                    val moveUp = ObjectAnimator.ofFloat(binding.yourImageviewId, "translationY", 0f)
                    moveUp.duration = 500
                    moveUp.start()
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
