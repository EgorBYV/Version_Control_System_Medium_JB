package svcs

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("These are SVCS commands:\n" +
                "config     Get and set a username.\n" +
                "add        Add a file to the index.\n" +
                "log        Show commit logs.\n" +
                "commit     Save changes.\n" +
                "checkout   Restore a file.")
    } else println(
        when (args[0]) {
            "add" -> "Add a file to the index."
            "checkout" -> "Restore a file."
            "commit" -> "Save changes."
            "log" -> "Show commit logs."
            "--help" -> "These are SVCS commands:\n" +
                "config     Get and set a username.\n" +
                "add        Add a file to the index.\n" +
                "log        Show commit logs.\n" +
                "commit     Save changes.\n" +
                "checkout   Restore a file."
            "config" -> "Get and set a username."
            else -> "'${args[0]}' is not a SVCS command."
        }
    )
}