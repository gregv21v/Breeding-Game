package main

import processing.core._


/**
 * @author alex deacon
 */


class Equipment(var id: Int, var pApp: PApplet) extends PApplet {
  var color = pApp.color(25);
  
  val radius = 40f
  var position = new PVector(radius + pApp.width/2, radius + pApp.height/2)
  
  def render {
      pApp.fill(color);
      pApp.ellipse(position.x, position.y, radius, radius);
   }
}