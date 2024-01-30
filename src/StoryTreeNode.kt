class StoryTreeNode(private var content: String, private var choices: Map<String, StoryTreeNode>) {
    fun getContent() = content
    fun getChoices() = choices
    fun setContent(newContent: String) {
        content = newContent
    }

    fun setChoices(newChoices: Map<String, StoryTreeNode>) {
        choices = newChoices
    }

    private fun getOrderedChoices(): List<Pair<String, StoryTreeNode>> {
        return choices.entries.map { it.toPair() }
    }

    fun displayStory() {
        // Display contents with 0.05 sec delay between characters
        for (c in content) {
            print(c)
            Thread.sleep(50)
        }

        print("\n")
        val orderedChoices = getOrderedChoices()

        if (orderedChoices.isNotEmpty()) {
            orderedChoices.forEachIndexed { index, (choice, _) ->
                println("${index + 1}: $choice")
            }
            println("Make your choice(enter number)")
        } else {
            println("No choices available. This is the end.") // Handle the case where there are no choices
            return
        }


        // Get user input (ensure to parse and handle it properly in real implementation)
        val choiceIndex = readlnOrNull()?.toIntOrNull() ?: -1

        if (choiceIndex in 1..orderedChoices.size) {
            // -1 because list is 0-indexed but displayed choices start at 1
            val selectedNode = orderedChoices[choiceIndex - 1].second
            selectedNode.displayStory() // Recursively display the selected story
        } else {
            println("Invalid choice. Please try again.")
            displayStory() // Optionally, allow user to try again
        }
    }
}