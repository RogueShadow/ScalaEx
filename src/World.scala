import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.io.FileInputStream

object World {
  var worldMap = Array.ofDim[Int](10 ,10)
  var tileData: String = _
  var line: String = _
  var reader:BufferedReader =_
  var i: Int = 0
  
  def init(): Unit = {
  
  }
  def edit(tileX: Int, tileY: Int, tileI: Int): Unit = {
    worldMap(tileX)(tileY) = tileI
    println(worldMap(tileX)(tileY))
  }
  
  def load(mapFile: String): String = {
    println("Loading: " + mapFile)
    line = null
    tileData = null
    
    try {
      reader = new BufferedReader( new FileReader("./res/" + mapFile) )
      i = 0
      while(i == 0) {
        line = reader.readLine()
        if(line == null) {
          i = 1 // Can't believe I resorted to this.
          println("Loaded: " + mapFile + "\n---")
        }
        else {
          tileData = tileData + line;
          tileData = tileData + System.getProperty("line.separator");
          //println("... :" + line)
        }
      }
    } catch {
      case ioe: IOException =>
        println("Error: could not open file.")
        println("       -> " + ioe)
        //exit(1)
    } finally {
      reader.close()
    }
    
    tileData // Send off this Data
  }
}