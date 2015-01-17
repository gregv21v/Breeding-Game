package main

import processing.core._
import scala.util._
import scala.collection.mutable._

class World(var pApp: PApplet) {
	val CREATURE_COUNT = 20;
	val creatures = Array.ofDim[Creature](CREATURE_COUNT)
  
  val odors = Array("Poison", "Gas", "Rubber", "Oil")

  
	for(i <- 0 until CREATURE_COUNT)
	{
		creatures(i) = new Creature(i, pApp)
    creatures(i).position.x = Random.nextInt(pApp.width + 1)
    creatures(i).position.y = Random.nextInt(pApp.height + 1)
    creatures(i).color = pApp.color(0, 255, 0)
    creatures(i).odor = odors(Random.nextInt(odors.length))
    creatures(i).attractedTo = Array(odors(Random.nextInt(odors.length)))
	}
	
	
	
	

	
	def render {
	    for(i <- 0 until CREATURE_COUNT)
	    {
	      creatures(i).draw
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