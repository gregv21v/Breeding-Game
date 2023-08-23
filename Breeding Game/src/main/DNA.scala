package main

import processing.core.PApplet

object DNA {
  val basePairs = "ATCG";
}



class DNA(var pApp: PApplet){
  private var sequence = "";

  def view = println(sequence)
  
  def encode(value: Int) {
    
    var temp = value
    var remainder = 0;
    if(temp < 0) {
      sequence += DNA.basePairs(1)
    } else {
      sequence += DNA.basePairs(0)
    }
    
    for(i <- 0 until 16) {
      remainder = value % 4;
      temp /= 4;
      sequence += DNA.basePairs(remainder);
    }
  }
  
  def encodeColor(color: Int) {
	   var temp = color
     var remainder = 0;
     
     for(i <- 0 until 4) {
        remainder =  pApp.red(temp).toInt % 4;
        temp = pApp.color((pApp.red(temp)) / 4, pApp.green(temp), pApp.blue(temp));
        sequence += DNA.basePairs(remainder);
     }
     for(i <- 0 until 4) {
        remainder = pApp.green(temp).toInt % 4;
        temp = pApp.color(pApp.red(temp), pApp.green(temp) / 4, pApp.blue(temp));
        sequence += DNA.basePairs(remainder);
     }
     for(i <- 0 until 4) {
        remainder = pApp.blue(temp).toInt % 4;
        temp = pApp.color(pApp.red(temp), pApp.green(temp), pApp.blue(temp) / 4);
        sequence += DNA.basePairs(remainder);
     }
  }
  
  def decodeInt(sequence: String) : Int = {
    var value = 0
    
    for(i <- 1 until sequence.length) {
      value += Math.pow(4, i).toInt * DNA.basePairs.indexOf(sequence(i));
    }
    if(sequence(1) == DNA.basePairs(1))
      -value
    else
      value
  }

}