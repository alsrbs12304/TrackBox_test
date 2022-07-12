package com.example.trackbox.view.ui.add

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trackbox.R
import com.example.trackbox.databinding.FragmentAddDeliveryBinding
import com.example.trackbox.view.util.CarrierIdUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip

class AddDeliveryFragment : BottomSheetDialogFragment() {
    private var _binding : FragmentAddDeliveryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddDeliveryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setChipGroup(binding)

        binding.imageButtonAddCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun setChipGroup(binding: FragmentAddDeliveryBinding) {
        for (name in CarrierIdUtil.getCarrierKeys()) {
            binding.chipGroupAddCarrierName.addView(
                Chip(activity).apply {
                    text = name
                    isCheckable = true
                    isClickable = true
                    setTextColor(Color.WHITE)
                    setEnsureMinTouchTargetSize(false)
                    checkedIcon = resources.getDrawable(R.drawable.truck)
                    chipBackgroundColor = resources.getColorStateList(R.color.color_add_chip_bg)
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}