package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.core.base.ProjectConfig
import ir.khanbeiki.kmpclean.core.common.model.PlatformData

expect fun getPlatform(): PlatformData

expect fun getProjectConfig(): ProjectConfig
