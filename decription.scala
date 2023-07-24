object Q1 {
  def getinput(): String = {
    println("Enter the Cipher Text:")
    val cipherText = scala.io.StdIn.readLine()
    cipherText
  }

  def decryption(cipherText: Array[Char], key: Int): Array[Char] = {
    val decryptedText = new Array[Char](cipherText.length)

    for (i <- 0 until cipherText.length) {
      var character = cipherText(i)

      if (character >= 'A' && character <= 'Z') {
        character = ((character - 'A' - key + 26) % 26 + 'A').toChar
      } else if (character >= 'a' && character <= 'z') {
        character = ((character - 'a' - key + 26) % 26 + 'a').toChar
      }

      decryptedText(i) = character
    }

    decryptedText
  }

  def main(args: Array[String]): Unit = {
    val cipherText = getinput()
    println("Enter the key (a non-negative integer):")
    val key = scala.io.StdIn.readInt()

    val decryptedText = decryption(cipherText.toCharArray, key)
    println("Decrypted Text:")
    println(decryptedText.mkString)
  }
}
