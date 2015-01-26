package main

import util.Random

class DNARules {
  
  var rules = Array.ofDim[String](10) // 0 - 9
  var pairs = Array.ofDim[String](16)
  var bases = "ATCG"
  
  
  def generatePairs {
    var k = 0
    for(i <- 0 until bases.length) {
      for(j <- 0 until bases.length) {
        pairs(k) = "" + bases(i) + bases(j)
        k += 1
      }
    }
  }
  

  
  
  def generateRules {
     var availiableIndices = (0 until 16).toArray
     
     // shuffle the indices
     for(i <- 0 until 20) // amount of swaps 
     {
       // swap the elements of at two random indices
       var index1 = Random.nextInt(16)
       var index2 = Random.nextInt(16)
       var temp = availiableIndices(index1)
       availiableIndices(index1) = availiableIndices(index2)
       availiableIndices(index2) = temp
     }
     
     // move the first 10 indices to the rules
     for(i <- 0 until 10) {
       rules(i) = pairs(availiableIndices(i))
     }
    
  }

}