package svcs

import java.io.File

const val CONFIG = "vcs/config.txt"
const val INDEX = "vcs/index.txt"

fun main(args: Array<String>) {
    val folder = File("vcs")
    if (!folder.exists() || !folder.isDirectory) folder.mkdir()

    val fileConfig = File(CONFIG)
    if (!fileConfig.exists()) fileConfig.writeText("")
    val fileIndex = File(INDEX)
    if (!fileIndex.exists()) fileIndex.writeText("")


    if (args.isEmpty()) {
        println(
            "These are SVCS commands:\n" +
                    "config     Get and set a username.\n" +
                    "add        Add a file to the index.\n" +
                    "log        Show commit logs.\n" +
                    "commit     Save changes.\n" +
                    "checkout   Restore a file."
        )
    } else when (args[0]) {
            "add" -> {
                if (args.size == 1) {
                    if (fileIndex.readText().isEmpty()) {
                        println("Add a file to the index.")
                    } else {
                        println("Tracked files:")
                        print(fileIndex.readText())
                    }
                } else {
                    val fileTrack = File(args[1])
                    if (fileTrack.exists()) {
                        File(INDEX).appendText("${args[1]}\n")
                        println("The file '${args[1]}' is tracked.")
                    } else {
                        println("Can't find '${args[1]}'.")
                    }
                }
            }
            "checkout" -> println("Restore a file.")
            "commit" -> println("Save changes.")
            "log" -> println("Show commit logs.")
            "--help" -> println("These are SVCS commands:\n" +
                    "config     Get and set a username.\n" +
                    "add        Add a file to the index.\n" +
                    "log        Show commit logs.\n" +
                    "commit     Save changes.\n" +
                    "checkout   Restore a file.")
            "config" -> if (args.size == 1) {
                println(
                    if (fileConfig.readText().isEmpty()) {
                        "Please, tell me who you are."
                    } else {
                        "The username is ${fileConfig.readText()}."
                    }
                )
            } else {
                File(CONFIG).writeText(args[1])
                println("The username is ${fileConfig.readText()}.")
            }
            else -> println("'${args[0]}' is not a SVCS command.")
        }
}
