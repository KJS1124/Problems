import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-21
 * Time:08:22
 */
public class BoardAssignment1 {
    static ExecutorService executors = Executors.newFixedThreadPool(16);
    public static int SIZE = 7;
    public static void main(String args[]) throws InterruptedException {
        List<Future<List<Cell>>> result = new ArrayList<>();
        List<Callable<List<Cell>>> callables = new ArrayList<>();
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    int finalI = i;
                    int finalJ = j;

                    callables.add(() -> {
                        return getCells(finalI, finalJ);
                    });
                }
            }
            result = executors.invokeAll(callables);
            for (Future<List<Cell>> future : result) {
                try {
                    // Retrieve the result of each task (blocking operation)
                    List<Cell> results = future.get();
                    if(results != null) {
                        System.out.println("Starting point : " + results.get(0).x + "," + results.get(0).y + " for size " + SIZE);
                    } else {
                        System.out.println("Not Worked");
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
    }

    private static List<Cell> getCells(int i, int j) {
        List<Cell> result;
        Cell startingPosition = new Cell(i, j);
        boolean[][] isVisited = new boolean[SIZE][SIZE];
        List<Cell> newList = new ArrayList<>();
        newList.add(startingPosition);
        result = findPath(startingPosition, isVisited, newList);
        return result;
    }

    public static List<Cell> findPath(Cell currentPosition, boolean isVisited[][], List<Cell> path) {
        System.out.println("Path size " + path.size() + "Starting point : " + path.get(0).x + "," + path.get(0).y +  " for size " + SIZE);
        if(path.size() == SIZE * SIZE) {
            System.out.println("Starting point : " + path.get(0).x + "," + path.get(0).y + " for size " + SIZE);
            executors.shutdownNow();
            return path;
        }
        if(!isSafe(currentPosition.x, currentPosition.y)) {
            return null;
        }

        if(isVisited[currentPosition.x][currentPosition.y]) {
            return null;
        }
        isVisited[currentPosition.x][currentPosition.y] = true;

        int x[] = {0, 0, 3,-3};
        int xx[] = {0, 0, 2,-2};
        for(int tempX : x) {
            for(int tempy: x) {
                List<Cell> newList = new ArrayList<>(path);
                newList.add(new Cell(currentPosition.x + tempX, currentPosition.y + tempy));
                List<Cell> newPath = findPath(new Cell(currentPosition.x + tempX, currentPosition.y + tempy), isVisited, newList);
                if(newPath != null) return newPath;
            }
        }

        for(int tempX : xx) {
            for(int tempy: xx) {
                List<Cell> newList = new ArrayList<>(path);
                newList.add(new Cell(currentPosition.x + tempX, currentPosition.y + tempy));
                List<Cell> newPath = findPath(new Cell(currentPosition.x + tempX, currentPosition.y + tempy), isVisited, newList);
                if(newPath != null) return newPath;
            }
        }
        isVisited[currentPosition.x][currentPosition.y] = false;
        return null;
    }


    public static boolean isSafe(int x, int y) {
        return x>=0 && x<SIZE && y>=0 && y<SIZE;
    }
}


class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
