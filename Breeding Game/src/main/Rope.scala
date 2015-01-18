package main


import processing.core._


/*
 * 
 */
class Rope(private var pApp: PApplet) {
  private var length = 40
  private var color = pApp.color(150, 75, 0)
  private var start = new PVector(0, 0)
  private var end = new PVector(0, 0)
  
  private var lastStart = new PVector(0, 0)
  private var lastEnd = new PVector(0, 0)
  
  
  
  
  def draw {
    pApp.fill(color)
    pApp.line(start.x, start.y, end.x, end.y)
  }
  
  def update {
    if(start.dist(end) > length) {
      start.set(lastStart.x, lastStart.y)
      end.set(lastEnd.x, lastEnd.y)
    }
    
    lastStart.set(start.x, start.y)
    lastEnd.set(end.x, end.y)
    
  }
  
  
  def attachStart(creature: Creature) {
    start = creature.position
  }
  def attachEnd(creature: Creature) {
    end = creature.position 
  }
  
  

}