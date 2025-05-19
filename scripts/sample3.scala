import java.io.File

object PathTraversal {
  def openFile(fileName: String): File = {
    val basePath = "/var/data/files/"
    val file = new File(basePath + fileName) // vulnerable to path traversal
    if (file.exists()) file else throw new Exception("File not found")
  }
}
