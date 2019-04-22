package GameFiles;
/**
 * Enumerator to select the birds 
 *
 */
public enum Type {
	AIRCURRENT,
	BUSH,
	CLAPPERRAIL,
	FISH,
	FOX,
	GAMEOBJECT,
	INVISIBLEWALL,
	OSPREY,
	STICK,
	TRASH;
	
	/**
	 * @return String
	 * 
	 * this method will be used to print out the name of the type of bird 
	 */
	public String toString() {
		switch (this) {
		case AIRCURRENT:
			return "Air Current";
		case BUSH:
			return "Bush";
		case CLAPPERRAIL:
			return "Clapper Rail";
		case FISH:
			return "Fish";
		case FOX:
			return "Fox";
		case GAMEOBJECT:
			return "GameObject";
		case INVISIBLEWALL:
			return "Invisible Wall";
		case OSPREY:
			return "Osprey";
		case STICK:
			return "Stick";
		case TRASH:
			return "Trash";
		default:
			return "Not a valid enum";
		}
	}
	/**
	 * @param String
	 * @return Type
	 * 
	 * this method will return the enumerated type
	 */
	public Type getType(String s) {
		switch (s) {
		case "Air Current":
			return AIRCURRENT;
		case "Bush":
			return BUSH;
		case "Clapper Rail":
			return CLAPPERRAIL;
		case "Fish":
			return FISH;
		case "Fox":
			return FOX;
		case "GameObject":
			return GAMEOBJECT;
		case "Invisible Wall":
			return INVISIBLEWALL;
		case "Osprey":
			return OSPREY;
		case "Stick":
			return STICK;
		case "Trash":
			return TRASH;
		default:
			return null;
		}
	}
}
