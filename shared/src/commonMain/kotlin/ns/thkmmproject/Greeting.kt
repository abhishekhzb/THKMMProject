package ns.thkmmproject

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}