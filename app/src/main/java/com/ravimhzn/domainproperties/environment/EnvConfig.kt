package com.ravimhzn.domainproperties.environment

import java.io.Serializable

data class EnvConfig(
    val baseUrl: String = "https://google.com.au",
    val timeout: Int = 50
): Serializable