package xyz.gosick.wooper.model

import org.ktorm.database.Database
import org.ktorm.entity.Entity
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/**
 *
 * @author liukeshao
 * @date 2021-09-27 15:08
 */
interface Department : Entity<Department> {
    companion object : Entity.Factory<Department>()

    var id: Int
    var name: String
    var location: String
}

object Departments : Table<Department>("t_department") {
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val location = varchar("location").bindTo { it.location }
}

val Database.departments get() = this.sequenceOf(Departments)