

class GameFactory {
//creates a factory class
	public Game getGame(String gameType){

		try{
			//returns a new instance on a Game subclass based on the string inputted into the method
			return (Game) Class.forName(gameType).newInstance();
		}
		//catches any exceptions
		catch(Exception e){
			throw new IllegalArgumentException("Input not understood");
		}

	}

}
