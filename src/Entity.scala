import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.Gdx

class Entity(var x: Float, var y: Float) {
  var rot: Float = _
  var sprite: Sprite = _
  sprite = new Sprite(Asset.wingTex)
  //var delta: Float = _
  
  def update(offx: Float, offy: Float, delta: Float): Unit = {
    //delta = Gdx.graphics.getDeltaTime()
    x += offx
    y += offy
    rot += (y + y / 2) * delta
  }
  
  def draw(spriteBatch: SpriteBatch): Unit = {
    sprite.setPosition(x, y)
    sprite.setRotation(rot)
    sprite.draw(spriteBatch)
  }
}