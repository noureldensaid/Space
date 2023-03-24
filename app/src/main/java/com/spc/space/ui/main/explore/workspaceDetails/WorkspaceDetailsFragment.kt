package com.spc.space.ui.main.explore.workspaceDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.spc.space.R
import com.spc.space.databinding.FragmentWorkspaceDetailsBinding
import com.spc.space.models.UnsplashPhoto
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkspaceDetailsFragment : Fragment(R.layout.fragment_workspace_details) {
    private var _binding: FragmentWorkspaceDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentWorkspaceDetailsBinding.bind(view)
        val workspaceData = arguments?.getParcelable<UnsplashPhoto>("workspaceData")

        binding.apply {
            if (workspaceData != null) {
                Glide.with(view)
                    .load(workspaceData.urls.regular)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .transform(CenterCrop(), RoundedCorners(24))
                    .error(R.drawable.error_placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(workspaceIv)
            }
        }

        binding.pickRoomBtn.setOnClickListener {
            findNavController().navigate(R.id.action_workspaceDetailsFragment_to_chooseRoomFragment)
        }
    }


    companion object {
        fun newInstance(workspaceData: UnsplashPhoto) = WorkspaceDetailsFragment()
            .apply {
                arguments = Bundle().apply {
                    putParcelable("workspaceData", workspaceData)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}