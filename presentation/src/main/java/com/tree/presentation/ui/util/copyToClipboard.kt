package com.tree.presentation.ui.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

fun copyToClipboard(context: Context, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("링크가 복사되었습니다.", text)
    clipboard.setPrimaryClip(clip)
}