/*
 * Sketch:
 *  This where all the interaction happens
 */




package main

import processing.core._
import scala.concurrent._

object Sketch extends PApplet {
  var world: World = _
  var keys = Array.fill[Boolean](4)(false)
  
  var ruleSet = new DNARules

 
  override def setup {
    size(1000, 1000)
    world = new World(this)
    
    ruleSet.generatePairs
    ruleSet.generateRules

  }
  override def draw {
    background(255, 255, 255)
    world.draw
    world.attractions
    world.movement
    world.player.move(keys)
  }
  
  // this function is called whenever a key is pressed
  override def keyPressed {
    key match {
      case 'w' => keys(0) = true
      case 'a' => keys(1) = true
      case 's' => keys(2) = true
      case 'd' => keys(3) = true
    }
  }
  
  override def keyReleased {
    key match {
      case 'w' => keys(0) = false
      case 'a' => keys(1) = false
      case 's' => keys(2) = false
      case 'd' => keys(3) = false
    }
  }
  
  override def mousePressed {
    var creature: Creature = null
    if(mouseButton == PConstants.LEFT) {
      creature = world.clicked
      creature.color = color(0, 0, 255)
    }
  }
  
  
  
  
  

}