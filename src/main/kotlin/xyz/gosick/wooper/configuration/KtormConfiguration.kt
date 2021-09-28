package xyz.gosick.wooper.configuration

import com.fasterxml.jackson.databind.Module
import org.ktorm.database.Database
import org.ktorm.jackson.KtormModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.annotation.Resource
import javax.sql.DataSource

/**
 *
 * @author liukeshao
 * @date 2021-09-27 14:51
 */
@Configuration
class KtormConfiguration {
    @Resource
    lateinit var dataSource: DataSource

    /**
     * Register the [Database] instance as a Spring bean.
     */
    @Bean
    fun database(): Database {
        return Database.connectWithSpringSupport(dataSource)
    }

    /**
     * Register Ktorm's Jackson extension to the Spring's container
     * so that we can serialize/deserialize Ktorm entities.
     */
    @Bean
    fun ktormModule(): Module {
        return KtormModule()
    }
}