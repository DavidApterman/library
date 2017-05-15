//Clyde "Thluffy" Sinclair
//APCS2 pd00
//HW40 -- Cementing OOPiness, familiarizing with common animation techniques
//2017-05-15   

/**
 * demo for Processing 
 * this class definition must be in same folder as driver file
 * (eg Chain_Reaction/Chain_Reaction.pde, Chain_Reaction/Ball.pde)
 **/

class Ball 
{

  //constants to represent state of a Ball
  final static int MOVING = 0;
  final static int GROWING = 1;
  final static int SHRINKING = 2;
  final static int DEAD = 3;

  //modify these to affect growth rate and threshold radius
  final float CHANGE_FACTOR = .25;
  final float MAX_RADIUS = 50;

  //position
  float x;
  float y;

  //radius
  float rad;

  //color
  color c;

  //change in x, y for each repaint
  float dx;
  float dy;

  //current state
  int state;

  /* used in development...
   Ball(float initX, float initY, color initC, float initDX, float initDY) {
   x = initX;
   y = initY;
   r = 50;
   c = initC;
   dx = initDX;
   dy = initDY;
   }
   */


  Ball() 
  {
    //init random color
    float r = random(256);
    float g = random(256);
    float b = random(256);
    c = color(r, g, b);

    //init radius
    rad = 10;

    //init random placement
    x = random((width - rad) + rad/2);
    y = random((height - rad) + rad/2);

    dx = random(10) - 5;
    dy = random(10) - 5;

    //all live Balls are in motion at startup
    state = MOVING;
  }


  //effect motion   
  void move() 
  {
    x = x + dx;
    y = y + dy;
    bounce();
  }

  //do stuff, according to state
  void process() 
  {
    if ( rad >= MAX_RADIUS )
      state = SHRINKING;
    if ( rad <= 0 ) 
      state = DEAD;
    if ( state == MOVING )
      move();
    else if ( state == GROWING )
      grow();
    else if ( state == SHRINKING )
      shrink();
  }

  //update visual representation according to current attribute vals
  void drawMe() 
  { 
    if ( state != DEAD ) {
      ellipseMode(RADIUS);
      fill(c);
      stroke(c);
      ellipse(x, y, rad, rad);
    }
  }

  //effect bounce
  void bounce() 
  {
    if (x < 0 ) 
      dx = abs(dx);
    if ( x > width ) 
      dx = -1 * abs(dx);
    if (y < 0 ) 
      dy = abs(dy);
    if ( y > height ) 
      dy = -1 * abs(dy);
  }

  //collision detection
  boolean isTouching( Ball other ) 
  {
    return sqrt( (x - other.x) * (x - other.x) + (y - other.y) * (y - other.y) ) < rad + other.rad;
  }


  //effect growth
  void grow() 
  {
    rad = rad + CHANGE_FACTOR;
  }


  //effect shrinkage
  void shrink() 
  {
    rad = rad - CHANGE_FACTOR;
  }
  
}//end class