package com.janlazaropardoprovapractica03

import android.content.Context

data class ValidationError(
    var loc: Array<String>,
    var msg: String,
    var type: String,
    var input: Any,
    var ctx: Context
)
