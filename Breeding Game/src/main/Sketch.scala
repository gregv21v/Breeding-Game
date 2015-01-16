package main

import processing.core.PApplet

object Sketch extends PApplet {
  var world: World = _
  var player: Player = _
  
  override def setup {
    size(1000, 1000)
    world = new World(this)
    player = new Player(this)
    
    world.print
    
  }
  override def draw {
    background(255, 255, 255)
    world.render
    world.attractions
    world.movement
   
    player.draw
  }
  
  
  override def keyPressed {
    key match {
      case 'w' => player.moveUp
      case 'a' => player.moveLeft
      case 's' => player.moveDown
      case 'd' => player.moveRight
    }
  }
  
  

}