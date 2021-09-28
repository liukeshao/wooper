package xyz.gosick.wooper.model

import org.ktorm.database.Database
import org.ktorm.entity.Entity
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.*
import java.time.LocalDate

/**
 *
 * @author liukeshao
 * @date 2021-09-27 15:02
 */
interface Employee : Entity<Employee> {
    companion object : Entity.Factory<Employee>()
    var id: Int
    var name: String
    var job: String
    var manager: Employee?
    var hireDate: LocalDate
    var salary: Long
    var department: Department
}

object Employees : Table<Employee>("t_employee") {

    /**
     * Employee ID.
     */
    val id = int("id").primaryKey().bindTo { it.id }

    /**
     * The employee's name.
     */
    val name = varchar("name").bindTo { it.name }

    /**
     * The employee's job.
     */
    val job = varchar("job").bindTo { it.job }

    val managerId = int("manager_id").bindTo { it.manager?.id }
    val hireDate = date("hire_date").bindTo { it.hireDate }
    val salary = long("salary").bindTo { it.salary }
    val departmentId = int("department_id").references(Departments) { it.department }
}

val Database.employees get() = this.sequenceOf(Employees)