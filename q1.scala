object Q1 {
  def getinput(): String = {
    println("Enter the Plain Text:")
    val plainText = scala.io.StdIn.readLine()
    plainText
  }

  def encryption(plainText: Array[Char], key: Int): Array[Char] = {
    val encryptedText = new Array[Char](plainText.length)

    for (i <- 0 until plainText.length) {
      var character = plainText(i)

      if (character >= 'A' && character <= 'Z') {
        character = ((character - 'A' + key) % 26 + 'A').toChar
      } else if (character >= 'a' && character <= 'z') {
        character = ((character - 'a' + key) % 26 + 'a').toChar
      }

      encryptedText(i) = character
    }

    encryptedText
  }

  def decryption(encryptedText: Array[Char], key: Int): Array[Char] = {
    val decryptedText = new Array[Char](encryptedText.length)

    for (i <- 0 until encryptedText.length) {
      var character = encryptedText(i)

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
    val plainText = getinput()
    println("Enter the key (a non-negative integer):")
    val key = scala.io.StdIn.readInt()

    val encryptedText = encryption(plainText.toCharArray, key)
    println("Encrypted Text:")
    println(encryptedText.mkString)

    val decryptedText = decryption(encryptedText, key)
    println("Decrypted Text:")
    println(decryptedText.mkString)
  }
}
