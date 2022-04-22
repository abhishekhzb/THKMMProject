package ns.thkmmproject

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    private val client = HttpClient()
    suspend fun getHtml(): String {
        val response = client.get("https://fakestoreapi.com/products/categories")
        return response.bodyAsText()
    }
}