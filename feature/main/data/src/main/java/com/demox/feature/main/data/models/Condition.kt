package com.demox.feature.main.data.models

import com.demox.core.data.database.tables.condition.ConditionTable
import com.demox.feature.main.domain.models.ConditionData

data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)

fun Condition.toConditionTable() = ConditionTable(
    code = this.code,
    icon = "https:"+this.icon,
    text = this.text
)

fun ConditionTable.toConditionData() = ConditionData(
    code = this.code,
    icon = this.icon,
    text = this.text,
)