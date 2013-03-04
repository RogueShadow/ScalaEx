import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.GL10
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.Texture

class Game extends ApplicationListener {
  var cam: OrthographicCamera = _ 
  var x, y: Float = _
  var spriteBatch: SpriteBatch = _
  var texReg:TextureRegion = _
  var tex:Texture = _
    
  def create(): Unit = {
    Gdx.graphics.setVSync(false)
    cam = new OrthographicCamera()
    cam.setToOrtho(false,320,200)
    
    //for(i <- 0 to 50) {
    //  x = 40f
    //  y = i * 15f
    //entities += new Entity(x, y)
    //}
    spriteBatch = new SpriteBatch()
    tex = new Texture(Gdx.files.internal("./res/sheepvert.gif"))
    texReg = new TextureRegion(tex ,20,20,32,32)
    
  }
  def dispose(): Unit = {}
  def pause(): Unit = {}
  def render(): Unit = {
    Gdx.gl.glClearColor(0.2f,0.7f,0.3f, 1)
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)
    
    spriteBatch.begin()
      spriteBatch.draw(texReg, 20, 80)
    spriteBatch.end()
  }
  
  def resize(x: Int, y: Int): Unit = {}
  def resume(): Unit = {}
  def update(delta: Float) {
  }
}