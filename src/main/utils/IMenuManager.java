package main.utils;

/**
 * An interface for MenuManager, allowing for unique menu items based on type of menu manager
 */
public interface IMenuManager {
    /**
     * A method that prints all available operation options to the user
     * @return an integer that is inputted by the user
     */
    public int menuItem();
}
