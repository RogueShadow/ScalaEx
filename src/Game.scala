import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL10
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.Texture
import scala.collection.mutable.ArrayBuffer
import com.badlogic.gdx.graphics.FPSLogger

class Game extends ApplicationListener {
  var x, y: Float = _
  var dx, dy: Float = _
  var spriteBatch: SpriteBatch = _
  var texReg:TextureRegion = _
  var tex:Texture = _ 
  var delta: Float = _
  val entities = new ArrayBuffer[Entity]
  var fpsLogger: FPSLogger = _
  
  
  def create(): Unit = {
    fpsLogger = new FPSLogger()
    Gdx.graphics.setVSync(false)
    for(i <- 0 to 50) {
      x = 240f
      y = 6 + i * 8f
      entities += new Entity(x, y)
    }
    spriteBatch = new SpriteBatch()
    tex = new Texture(Gdx.files.internal("./res/sheepvert.gif"))
    texReg = new TextureRegion(tex ,20,20,32,32)
    
  }
  def dispose(): Unit = {
    spriteBatch.dispose()
    tex.dispose()
  }
  def pause(): Unit = {}
  def render(): Unit = {
    Gdx.gl.glClearColor(0.2f,0.7f,0.3f, 1)
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)
    
    delta = Gdx.graphics.getDeltaTime()
    dx = 0
    dy = 0

    if(Gdx.input.isKeyPressed(19)) dy += 34 * delta
    if(Gdx.input.isKeyPressed(21)) dx -= 34 * delta
    if(Gdx.input.isKeyPressed(20)) dy -= 34 * delta
    if(Gdx.input.isKeyPressed(22)) dx += 34 * delta

    entities.foreach(_.update(dx, dy, delta))
    
    spriteBatch.begin()
      entities.foreach(_.draw(spriteBatch))
      spriteBatch.draw(texReg, 20, 80)
    spriteBatch.end()
    
    fpsLogger.log()
  }
  
  def resize(x: Int, y: Int): Unit = {}
  def resume(): Unit = {}
  def update(delta: Float) {}
}
