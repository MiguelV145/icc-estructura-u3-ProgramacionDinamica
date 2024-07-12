package Ejercicios.contorllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Ejercicios.models.Celda;

/*
 * Un jugador está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior izquierda con el jugador, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 *
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */
public class Laberinto {

    public List<Celda> getPath(boolean[][] grid) {
        Map<Celda, Boolean> cacheMap = new HashMap<>();
        List<Celda> path = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return path;
        }
        if (getPath(grid, 0, 0, path, cacheMap)) {
            return path;
        }
        return new ArrayList<>();
    }
    private boolean getPath(boolean[][] grid, int x, int y, List<Celda> path, Map<Celda, Boolean> cacheMap) {
        if (x >= grid.length || y >= grid[0].length || !grid[x][y]) {
            return false;
        }
        
        Celda point = new Celda(x, y);

        if (cacheMap.containsKey(point)) {
            return cacheMap.get(point);
        }

        boolean isAtEnd = (x == grid.length - 1) && (y == grid[0].length - 1);
        boolean succes =false;

        if (isAtEnd || getPath(grid, x + 1, y, path, cacheMap) || getPath(grid, x, y + 1, path, cacheMap)) {
            path.add(point);
            succes =true;
        }

        cacheMap.put(point, false);
        return  succes;
    }
}