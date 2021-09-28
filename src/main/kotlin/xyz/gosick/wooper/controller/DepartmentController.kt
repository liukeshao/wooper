package xyz.gosick.wooper.controller

import cn.dev33.satoken.stp.StpUtil
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.find
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import xyz.gosick.wooper.model.Department
import xyz.gosick.wooper.model.departments
import javax.annotation.Resource

/**
 *
 * @author liukeshao
 * @date 2021-09-27 15:21
 */
@RestController
class DepartmentController {

    @Resource
    lateinit var database: Database

    @GetMapping("/departments/get-by-id")
    fun getDepartmentById(@RequestParam("id") id: Int): Department? {
        return database.departments.find { it.id eq id }
    }


}