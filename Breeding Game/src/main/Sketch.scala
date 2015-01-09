package main

import processing.core.PApplet

object Sketch extends PApplet {
  var world: World = _
  
  override def setup() {
    size(1000, 1000)
    world = new World(this)
    
    world.print
    
  }
  override def draw() {
    background(255, 255, 255)
    world.render
    world.attractions
    world.movement
  }
  
  

}