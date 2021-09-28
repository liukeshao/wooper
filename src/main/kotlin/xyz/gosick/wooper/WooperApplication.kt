package xyz.gosick.wooper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WooperApplication

fun main(args: Array<String>) {
	runApplication<WooperApplication>(*args)
}
