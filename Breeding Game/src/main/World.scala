package main

import processing.core._
import scala.collection.mutable._

class World(var pApp: PApplet) {
	val CREATURE_COUNT = 2;
	val creatures = Array.ofDim[Creature](CREATURE_COUNT)

  
	for(i <- 0 until CREATURE_COUNT)
	{
		creatures(i) = new Creature(i, pApp)
		//creatures(i).position.add(i * creatures(i).radius * 2, 0.0f, 0.0f);
	}
	creatures(0).position.x = 40
	creatures(0).position.y = 40
	creatures(0).color = pApp.color(0, 255, 0)
	creatures(0).odor = "Poison"	
	creatures(1).attractedTo = Array("Poison")
	

	
	def render {
	    for(i <- 0 until CREATURE_COUNT)
	    {
	      creatures(i).render
	    }
	}
  
  def attractions {
      for(i <- 0 until CREATURE_COUNT) {
        for(j <- i+1 until CREATURE_COUNT) {
          if(creatures(i).isAttractedTo(creatures(j))) {
            creatures(i).moveTowards(creatures(j))
          }
          if(creatures(j).isAttractedTo(creatures(i))) {
            creatures(j).moveTowards(creatures(i))
          }
        }
      }
  }
  
  def movement {
    for(i <- 0 until CREATURE_COUNT)
    {
       creatures(i).move
    }
    
   
  }
  
  def print {
    for(i <- 0 until CREATURE_COUNT)
    {
       println(creatures(i))
       println()
    } 
  }
  
  


}