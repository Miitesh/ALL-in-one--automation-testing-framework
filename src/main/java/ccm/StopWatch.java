package ccm;

public class StopWatch {
	
	

		  private long startTime = 0;
		  private long stopTime = 0;
		  private boolean running = false;


		  public void start() {
		    this.startTime = System.currentTimeMillis();
		    this.running = true;
		    System.out.print("\nStart Time is "+ startTime);
		  }


		  public void stop() {
		    this.stopTime = System.currentTimeMillis();
		    this.running = false;
		    System.out.print("\nStop Time is "+ stopTime);
		  }


		  //Elapsed time in milliseconds
		  public long getElapsedTime() {
		    long elapsed;
		    if (running) {
		      elapsed = (System.currentTimeMillis() - startTime);
		    }
		    else {
		      elapsed = (stopTime - startTime);
		    }
		    return elapsed;
		  }


		  //Elapsed time in seconds
		  public long getElapsedTimeSecs() {
		    long elapsed;
		    if (running) {
		      elapsed = ((System.currentTimeMillis() - startTime) / 1000);
		    }
		    else {
		      elapsed = ((stopTime - startTime) / 1000);
		    }
		    return elapsed;
		  }
		}



