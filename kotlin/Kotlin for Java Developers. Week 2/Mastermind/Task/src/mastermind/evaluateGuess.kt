package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    if (secret == guess) {
        return Evaluation(4, 0)
    }
    var rightPosition = 0
    var wrongPosition = 0

    var mySecret = secret
    var myGuess = guess

    for (i in 0..3) {
        if (myGuess[i] == secret[i]) {
            rightPosition++;
            mySecret = mySecret.replaceRange(i, i + 1, "*")
            myGuess = myGuess.replaceRange(i, i + 1, "#")
        }
    }
    for (i in 0..3) {
        val indexOf = mySecret.indexOf(myGuess[i])
        if (indexOf != -1) {
            wrongPosition++;
            mySecret = mySecret.replaceRange(indexOf, indexOf + 1, "*")
        }

    }

    return Evaluation(rightPosition, wrongPosition)


}
