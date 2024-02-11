package com.ravimhzn.domainproperties.environment

import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

//Demonstration class to read environments (SIT, UAT, PRD...)
const val ENV_KEY = "envs"

@Singleton
class EnvFile @Inject constructor() {
    fun file(): File {
        return File(
            ENV_KEY,
            "SIT.json"
        )
    }
}