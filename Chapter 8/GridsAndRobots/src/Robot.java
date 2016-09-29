public class Robot
{
  private static Grid grid;
  private static Location robotLoc;
  private static char direction;
  private static int delay = 250;
  
  private static final String ROBOT_NORTH_IMAGE = "robotnorth.gif";
  private static final String ROBOT_SOUTH_IMAGE = "robotsouth.gif";
  private static final String ROBOT_EAST_IMAGE = "roboteast.gif";
  private static final String ROBOT_WEST_IMAGE = "robotwest.gif";
  
  private static final Color LIGHT_COLOR = new Color(229, 170, 122);
  private static final Color DARK_COLOR = new Color(153, 114, 81);
  
  private Robot() {}
  
  /**
   * Loads a map file for the robot. The file must contain a rectangular set
   * of characters where X is a wall, . is a light tile, : is a dark tile,
   * and N, S, E or W represents the starting position and orientation
   * of the robot (use only one letter once). 
   * @param mapFileName Name of the file containing the map of the floor.
   */
  public static void load(String mapFileName)
  {
    if (grid != null)
      throw new RuntimeException("Cannot load map \"" + mapFileName + "\" because a map has already been loaded");
    String[] lines = FileUtil.load(mapFileName);
    int numRows = lines.length;
    int numCols = lines[0].length();
    grid = new Grid(numRows, numCols);
    grid.setTitle("Robot");
    grid.setLineColor(new Color(0, 0, 0));
    
    for (int row = 0; row < numRows; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        Location loc = new Location(row, col);
        char ch = lines[row].charAt(col);
        if (ch == 'N' || ch == 'S' || ch == 'E' || ch == 'W')
        {
          grid.setColor(loc, LIGHT_COLOR);
          if (ch == 'N')
            grid.setImage(loc, ROBOT_NORTH_IMAGE);
          else if (ch == 'S')
            grid.setImage(loc, ROBOT_SOUTH_IMAGE);
          else if (ch == 'E')
            grid.setImage(loc, ROBOT_EAST_IMAGE);
          else
            grid.setImage(loc, ROBOT_WEST_IMAGE);
          robotLoc = loc;
          direction = ch;
        }
        else if (ch == 'X')
        {
          grid.setImage(loc, "wall.gif");
        }
        else if (ch == '.')
          grid.setColor(loc, LIGHT_COLOR);
        else if (ch == ':')
          grid.setColor(loc, DARK_COLOR);
        else
          throw new RuntimeException("Invalid character '" + ch + "' in map file \"" + mapFileName + "\"");
      }
    }
  }
  
  /**
   * Move the robot one position in its current direction. 
   * @throws RuntimeException if the map is not loaded yet or if the robot attempts to move to an invalid or occupied location. 
   */
  public static void move()
  {
    if (grid == null)
      throw new RuntimeException("Map not loaded yet");
    int row = robotLoc.getRow();
    int col = robotLoc.getCol();
    Location newLoc;
    if (direction == 'N')
      newLoc = new Location(row - 1, col);
    else if (direction == 'S')
      newLoc = new Location(row + 1, col);
    else if (direction == 'E')
      newLoc = new Location(row, col + 1);
    else
      newLoc = new Location(row, col - 1);
    
    if (!grid.isValid(newLoc))
      throw new RuntimeException("Attempt to move robot from " + robotLoc + " to invalid location " + newLoc);
    if (grid.getImage(newLoc) != null)
      throw new RuntimeException("Attempt to move robot from " + robotLoc + " to occupied location " + newLoc);
    
    String image = grid.getImage(robotLoc);
    grid.setImage(robotLoc, null);
    robotLoc = newLoc;
    grid.setImage(robotLoc, image);
    Grid.pause(delay);
  }
  
  /**
   * Turns the robot 90 degrees counter-clockwise in its current position
   */
  public static void turnLeft()
  {
    if (grid == null)
      throw new RuntimeException("Map not loaded yet");
    if (direction == 'N')
    {
      direction = 'W';
      grid.setImage(robotLoc, ROBOT_WEST_IMAGE);
    }
    else if (direction == 'S')
    {
      direction = 'E';
      grid.setImage(robotLoc, ROBOT_EAST_IMAGE);
    }
    else if (direction == 'E')
    {
      direction = 'N';
      grid.setImage(robotLoc, ROBOT_NORTH_IMAGE);
    }
    else
    {
      direction = 'S';
      grid.setImage(robotLoc, ROBOT_SOUTH_IMAGE);
    }
    Grid.pause(delay);
  }
  
  /**
   * Makes the tile underneath the robot light.
   * @throws RuntimeException if the map is not loaded yet or if the floor tile is already light.
   */
  public static void makeLight()
  {
    if (grid == null)
      throw new RuntimeException("Map not loaded yet");
    if (!onDark())
      throw new RuntimeException("Location " + robotLoc + " is already light");
    grid.setColor(robotLoc, LIGHT_COLOR);
    Grid.pause(delay);
  }
 
  /**
   * Makes the tile underneath the robot dark.
   * @throws RuntimeException if the map is not loaded yet or if the floor tile is already dark.
   */
  public static void makeDark()
  {
    if (grid == null)
      throw new RuntimeException("Map not loaded yet");
    if (onDark())
      throw new RuntimeException("Location " + robotLoc + " is already dark");
    grid.setColor(robotLoc, DARK_COLOR);
    Grid.pause(delay);
  }
  
  /**
   * Returns true if the robot is currently on a dark tile; false otherwise
   * @throws RuntimeException if the map is not loaded yet
   * @return true or false depending on whether the robot is on a dark tile or not, respectively
   */
  public static boolean onDark()
  {
    if (grid == null)
      throw new RuntimeException("Map not loaded yet");
    return grid.getColor(robotLoc).equals(DARK_COLOR);
  }
  
  /**
   * Returns true if the position in front of the robot is clear (i.e. no wall and not off the floor)
   * @throws RuntimeException if the map is not loaded yet
   * @return true or false depending on whether the position in front of the robot is clear or not
   */
  public static boolean frontIsClear()
  {
    if (grid == null)
      throw new RuntimeException("Map not loaded yet");
    int row = robotLoc.getRow();
    int col = robotLoc.getCol();
    Location loc;
    if (direction == 'N')
      loc = new Location(row - 1, col);
    else if (direction == 'S')
      loc = new Location(row + 1, col);
    else if (direction == 'E')
      loc = new Location(row, col + 1);
    else
      loc = new Location(row, col - 1);

    return grid.isValid(loc) && grid.getImage(loc) == null;
  }
  
  /**
   * Sets the delay between the execution of robot commands
   * @param milliseconds The number of milliseconds between robot commands
   */
  public static void setDelay(int milliseconds)
  {
    delay = milliseconds;
  }
}