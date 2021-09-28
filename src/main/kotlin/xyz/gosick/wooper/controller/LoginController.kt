package xyz.gosick.wooper.controller

import cn.dev33.satoken.stp.StpUtil
import cn.dev33.satoken.util.SaResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author liukeshao
 * @date 2021-09-28 11:26
 */
@RestController
class LoginController {
    @GetMapping("/login")
    fun login(name: String, password: String): SaResult {
        if ("zhang" == name && "123456" == password) {
            StpUtil.login(1001)
            return SaResult.ok("登录成功")
        }
        return SaResult.error("登录失败")
    }

    @GetMapping("test")
    fun test(businessNo: String, fileType: Int, version: String) {
        println(businessNo)
        println(fileType)
        println(version)
    }
}