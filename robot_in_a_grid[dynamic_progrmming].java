Arraylist<Point> getPath(boolean[][] maze) {
	if (maze ==null I I maze.length== 0) return null;
	Arraylist<Point> path=new Arraylist<Point>();
	HashSet<Point> failedPoints = new HashSet<Point>();
	if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
		return path;
	return null;
}
}


boolean getPath(boolean[][] maze, int row, int col, Arraylist<Point> path,HashSet<Point> failedPoints) {
/* If out of bounds or not available, return.*/
if (col < 0 11 row < 0 11 !maze[row][col]) {
	return false;
}

Point p = new Point(row, col);
/* If we've already visited this cell, return. */
if (failedPoints.contains(p)) {
return false;
}

boolean isAtOrigin=(row== 0) && (col== 0);
/* If there's a path from start to my current location, add my location.*/
if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) { // first only the recurion occurs and the if loop is never enterd. And only if we succsefully reach the start position then isAtorigin will be  true it allows to enter into the if loop . We add the path and return true so that as recursion falls back [we are going back in recursion] the true we are sending will allow us to add that path. 
	path.add(p);
	return true;
}
failedPoints.add(p); // Cache result. Also we add to failed paths only when both the go up and go left path fail and we did not reach the starting point.And then we go back in recurison so that in next recuriosn the same point is not visited again.
return false;
}
