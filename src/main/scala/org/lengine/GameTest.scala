package org.lengine

import org.lengine.level.Level
import org.lengine.render.Sprite
import org.lengine.tests.EntityPlayer
import org.lwjgl.input.{Keyboard, Mouse}

object GameTest extends GameBase("test") {

  var level: Level = _

  var testSprite: Sprite = _

  override def initGame: Unit = {
    level = new Level
    val player: EntityPlayer = new EntityPlayer
    level spawn player
    testSprite = new Sprite("assets/textures/test.png")
    testSprite.width /= 2f
    testSprite.height /= 2f
    testSprite.getCenter /= 2f
  }

  override def update(delta: Float): Unit = {
    level update(delta)
    if(isKeyPressed(Keyboard.KEY_SPACE)) {
      testSprite.setAngle(testSprite.getAngle()+0.025f)
    }
  }

  override def render(delta: Float): Unit = {
    level.render(delta)
    testSprite.render(delta)
  }

  override def getBaseHeight: Int = 640

  override def onScroll(x: Int, y: Int, dir: Int): Unit = {
    testSprite.setAngle(testSprite.getAngle() + dir*0.25f)
  }

  override def onMouseMoved(x: Int, y: Int, dx: Int, dy: Int): Unit = {
    testSprite.setPos(x-testSprite.getCenter().x, y-testSprite.getCenter().y)
  }

  override def onMousePressed(x: Int, y: Int, button: Int): Unit = {}

  override def onMouseReleased(x: Int, y: Int, button: Int): Unit = {}

  override def onKeyPressed(keyCode: Int, char: Char): Unit = {}

  override def onKeyReleased(keyCode: Int, char: Char): Unit = {}
}