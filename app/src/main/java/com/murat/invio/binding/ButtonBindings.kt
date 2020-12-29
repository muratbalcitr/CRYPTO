package com.murat.invio.binding

import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter

@BindingAdapter("app:is_selected")
fun bindButtonTitle(button: AppCompatButton, selected: Boolean) {
    button.isSelected = selected
}