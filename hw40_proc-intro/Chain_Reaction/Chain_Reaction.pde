//Clyde "Thluffy" Sinclair
//APCS2 pd00
//HW40 -- Cementing OOPiness, familiarizing with common animation techniques
//2017-05-15   

/**
 * demo for Processing 
 * this driver file is in dir of same name
 * (eg Chain_Reaction/Chain_Reaction.pde)
 * ...along with definition of class Ball (Ball.pde)
 **/

//array of Balls to animate
Ball[] balls;

//global boolean to tell whether reaction has been triggered
boolean reactionStarted;


//tasks to perform once, upon launch
void setup() 
{
  //DIAGNOSTIC: lower frame rate from default 60fps to explore, troubleshoot...
  //frameRate(10);
  
  //set canvas size to 600x600 pixels
  size(600, 600);

  //until mouse is clicked, reaction has not started
  reactionStarted = false; 

  //initialize array   
  balls = new Ball[25];

  //instantiate each Ball
  for (int i=0; i < balls.length; i++ )
    balls[i] = new Ball();

  //special Ball for seeding reaction
  //init'd to DEAD, will come to life upon click
  balls[0].state = Ball.DEAD;
}


//tasks to be performed with each screen refresh
void draw() {
  //repaint background, effectively erasing ball "ghosts"
  background(0); 

  //iterate through balls, updating each
  for (int i=0; i < balls.length; i++ ) {

    //check for growth state and collisions, update state vars accordingly
    if ( balls[i].state == Ball.GROWING || balls[i].state == Ball.SHRINKING) {      
      for (int j=0; j < balls.length; j++ ) {
        if ( balls[j].state == Ball.MOVING && balls[i].isTouching( balls[j] ) )
          balls[j].state = Ball.GROWING;
      }
    }
  }

  //iterate thru balls, re-drawing and processing according to state
  for (int i=0; i < balls.length; i++ ) {
    balls[i].drawMe();
    balls[i].process();
  }
}


//upon primary mouse button click, start reaction at pointer location 
//(bring special dead ball to life)
void mouseClicked() 
{
  if ( !reactionStarted ) {
    balls[0].x = mouseX;
    balls[0].y = mouseY;
    balls[0].rad = 0.1;
    balls[0].state = Ball.GROWING;
    reactionStarted = true;
  }
}