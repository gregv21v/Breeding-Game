package main

import processing.core._

class Station(
    pApp: PApplet,
    var position: PVector = new PVector,
    width: Float = 55f,
    height: Float = 55f){
  
  var color = pApp.color(51, 51, 51)
  
  def draw()
  {
    pApp.fill(color)
    pApp.rect(position.x, position.y, width, height)
  }
  
  
}