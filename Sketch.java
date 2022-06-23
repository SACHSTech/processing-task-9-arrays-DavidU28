import processing.core.PApplet;

public class Sketch extends PApplet {
	
	float[] circleY = new float[10];
  float [] circleX =  new float [10];
  float playerY = 350;
  float playerX = 200;
  boolean [] ballHideStatus = new boolean [10];
  int lives = 3;
  boolean downPressed = false;
  boolean upPressed = false;
  boolean wPressed = false;
  boolean aPressed = false;
  boolean sPressed = false;
  boolean dPressed = false;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);

    for (int x = 0; x < circleX.length; x++){
      circleX[x] = random(width);
      circleY[x] = random(height);
    }
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    for (int i = 0; i < circleY.length; i++) {
      ballHideStatus[i] = false;
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(0);

    for (int i = 0; i < circleY.length; i++) {
      if (ballHideStatus[i] == false){
        fill(255);
        ellipse(circleX[i], circleY[i], 30, 30);
        stroke(0);
  
        circleY[i] += 2;
 
      if(circleY[i] > height) {
        circleY[i] = 0;
      }
      else if(ballHideStatus[i] == true){
        fill(0);
        ellipse(circleX[i], circleY[i], 25, 25);
        stroke(0);
      }
    
      if((playerX <= circleX[i] + 20) && (playerX >= circleX[i] - 20)){
        if((playerY <= circleY[i] + 20) && (playerY >= circleY[i] - 20)){
          lives = lives - 1;
          ballHideStatus[i] = true;

      }
    }
  
      if(mousePressed){
        if((mouseX <= circleX[i] + 20) && (mouseX >= circleX[i] - 20)){
          if((mouseY <= circleY[i] + 20) && (mouseY >= circleY[i] - 20)){
            ballHideStatus[i] = true;
        }
      }
    }

    //Change snowball speed
    if (downPressed){
      circleY[i] ++;
    }
    else if(upPressed){
        circleY[i] --;
    }

   //Movement of player
    if(wPressed){
      playerY -= 0.4;
    }
    else if (aPressed){
      playerX -= 0.4;
    }
    else if (sPressed){
      playerY += 0.4;
    }
    else if (dPressed){
      playerX += 0.4;
    }

  }
    //Draw player
    fill(0, 0, 255);
    ellipse(playerX, playerY, 40, 40);

    //Display health
    if(lives == 3){
      fill(240, 24, 24);
      rect(280, 10, 20, 20);
      rect(320, 10, 20, 20);
      rect(360, 10, 20, 20);
    }
    else if(lives == 2){
      fill(240, 24, 24);
      rect(320, 10, 20, 20);
      rect(360, 10, 20, 20);
    }
    else if(lives == 1){
      fill(240, 24, 24);
      rect(360, 10, 20, 20);
    }
    else{
      background(255);
    }
  
    //Collision detection
    if (playerX > width - 15){
      playerX = width - 15;
    }
    else if (playerX < 15){
      playerX = 15;
    }
    else if (playerY < 15){
      playerY = 15;
    }
    else if (playerY > height - 15){
      playerY = height - 15;
    }
  }

}

  public void keyReleased() {
    if (keyCode == UP) {
      upPressed = false;
    }
    else if (keyCode == DOWN){
      downPressed = false;
    }
    else if (key == 'w') {
      wPressed = false;
    }
    else if (key == 'a') {
      aPressed = false;
    }
    else if (key == 's') {
      sPressed = false;
    }
    else if (key == 'd') {
      dPressed = false;
    }
  }

  public void keyPressed() {
    if (keyCode == DOWN) {
      downPressed = true;
    }
    else if (keyCode == UP) {
      upPressed = true;
    }
    else if (key == 'w') {
      wPressed = true;
    }
    else if (key == 'a') {
      aPressed = true;
    }
    else if (key == 's') {
      sPressed = true;
    }
    else if (key == 'd') {
      dPressed = true;
    }
  }

}