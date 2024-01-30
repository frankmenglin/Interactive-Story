fun main(){
val correctAnswer = StoryTreeNode("You answer it correctly!", mapOf())
val incorrectAnswer = StoryTreeNode("You answer it incorrectly!", mapOf())
val simpleQuestion =
    StoryTreeNode("43+57=", mapOf("80" to incorrectAnswer, "100" to correctAnswer, "120" to incorrectAnswer))
simpleQuestion.displayStory()
return
}
