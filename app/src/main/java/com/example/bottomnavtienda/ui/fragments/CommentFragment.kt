package com.example.bottomnavtienda.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomnavtienda.ui.adapters.CommentAdapter
import com.example.bottomnavtienda.ui.listeners.OnCommentListener
import com.example.bottomnavtienda.data.models.Comment
import com.example.bottomnavtienda.databinding.FragmentCommentBinding
import com.example.bottomnavtienda.ui.viewmodels.CommentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CommentFragment : Fragment() {

    private var _binding: FragmentCommentBinding? = null

    private val binding get() = _binding!!

    private val commentViewModel: CommentViewModel by viewModel()

    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_comment, container, false)
        _binding = FragmentCommentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        commentManager = LinearLayoutManager(requireContext())
        commentAdapter = CommentAdapter(
            listOf()
        )
        commentAdapter.listener = object : OnCommentListener {
            override fun onClick(comment: Comment) {
                Log.d("CLICK",comment.name)
            }
        }
        commentViewModel.loadComments()
        binding.commentRecycler.apply {
            adapter = commentAdapter
            layoutManager = commentManager
        }
        commentViewModel.comments.observe(viewLifecycleOwner, Observer { comments ->
            commentAdapter.newDataset(comments)

        })
    }

}
