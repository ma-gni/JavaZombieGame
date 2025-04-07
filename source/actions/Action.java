/**
 * The Action class represents an action that can be performed by either a Survivor or a Zombie.
 * Actions include various interactions such as movement, attacks, etc.
 */
package actions;

import actors.*;

public class Action {
	// Fields
	protected Survivor survivor;
	protected int nbpoints;
	protected Zombie zombie;
	protected Actors actor;

	/**
	 * Constructor for creating an Action object for either a Survivor or a Zombie.
	 *
	 * @param actor The actor (Survivor or Zombie) performing the action.
	 */
	public Action(Actors actor) {
		this.nbpoints = 1;
		if (actor instanceof Survivor) {
			this.survivor = (Survivor) actor;
		} else if (actor instanceof Zombie) {
			this.zombie = (Zombie) actor;
		}
	}

	/**
	 * Constructor for creating an Action object for a Survivor with a specified number of action points.
	 *
	 * @param s    The Survivor performing the action.
	 * @param nbpt The number of action points required for the action.
	 */
	public Action(Survivor s, int nbpt) {
		this.survivor = s;
		this.nbpoints = nbpt;
	}

	/**
	 * Retrieves the Survivor associated with this action.
	 *
	 * @return The Survivor associated with this action.
	 */
	public Survivor getSurvivor() {
		return this.survivor;
	}

	/**
	 * Retrieves the number of action points required for this action.
	 *
	 * @return The number of action points required.
	 */
	public int getNbPoints() {
		return this.nbpoints;
	}

	/**
	 * Executes the action.
	 */
	public void execute() {
		// This method is meant to be overridden by subclasses.
	}

	/**
	 * Executes the action with a specified actor.
	 *
	 * @param a The actor involved in the action.
	 */
	public void execute(Actors a) {
		// This method is meant to be overridden by subclasses.
	}
}
