package board;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a building containing rooms.
 */
public class Building {
	private List<Room> rooms;

	/**
	 * Constructs a new building with no rooms.
	 */
	public Building() {
		this.rooms = new ArrayList<>();
	}

	/**
	 * Gets the list of rooms in the building.
	 * @return The list of rooms.
	 */
	public List<Room> getRooms() {
		return rooms;
	}

	/**
	 * Adds a room to the building.
	 * @param room The room to add.
	 */
	public void addRoom(Room room) {
		rooms.add(room);
	}
}
