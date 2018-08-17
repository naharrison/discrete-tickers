package edu.ung.phys;

import processing.core.PApplet;

/**
 * @author naharrison
 */
public class Tickers extends PApplet {


  public int nTicks, frRate, reducedFrameCount;
  public boolean isRunning;


  public static void main(String[] args) {
    PApplet.main("edu.ung.phys.Tickers");
  }

  
  public void settings() {
    size(1600, 620);
  }


  public void setup() {
    frRate = 40; // frameRate is the literal frame rate which changes slightly from frame to frame, so use frRate for const. value
    frameRate(frRate);
    nTicks = 20;
    reducedFrameCount = 0;
    isRunning = false;
  }

  
  public void draw() {
    background(200);

    drawTicker(1*width/4 - width/8, height/2, 2*frRate);
    drawTicker(2*width/4 - width/8, height/2, frRate);
    drawTicker(3*width/4 - width/8, height/2, frRate/2);
    drawTicker(4*width/4 - width/8, height/2, 1);

    if(isRunning) reducedFrameCount++;
  }


  public void mouseClicked() {
    isRunning = !isRunning;
  }


  public void drawTicker(int x, int y, int updateDelay) {
    pushMatrix();

    translate(x, y);
    scale((float) 0.2);
    stroke(0);
    fill(255);
    strokeWeight(20);
    ellipse(0, 0, width, width);

    fill(0);
    for(int k = 0; k < nTicks; k++) {
      pushMatrix();
      rotate(2*PI*k/nTicks);
      ellipse(0, width/2 - 22, 20, 20);
      popMatrix();
    }

    pushMatrix();
    float angleIncrement = 2*PI/(nTicks*((float) frRate/(float) updateDelay));
    float totalAngle = ((float) reducedFrameCount/(float) frRate)*(2*PI/nTicks);
    float nIncrements = (float) Math.floor(totalAngle/angleIncrement);
    rotate(angleIncrement*nIncrements);
    line(0, 0, 0, width/2 - 25);
    popMatrix();

    popMatrix();
  }

}


// TODO:
  // make corresponding graphs w/ root
  // make simple code to calculate total distance given step width, step height, and #steps (for me)
  // design group activity - calculate by hand for 2-3 variations
