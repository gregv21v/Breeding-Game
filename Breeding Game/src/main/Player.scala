package main

import processing.core._

class Player(var pApp: PApplet) {
  var position = new PVector(20, 20, 0)
  var radius = 20
  val speed = 20
  
  
  
  
  
  def moveLeft {
    position.x -= speed
  }
  
  def moveRight {
    position.x += speed
    
  }
  
  
  def moveUp {
    position.y -= speed
  }
  
  def moveDown {
    position.y += speed
  }
  
  
  def draw {
    pApp.fill(255, 0, 0)
    pApp.rect(position.x, position.y, radius*2, radius*2)
  }
}