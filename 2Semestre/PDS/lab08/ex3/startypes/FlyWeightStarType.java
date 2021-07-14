package lab08.ex3.startypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lab08.ex3.startypes.StarType;

public class FlyWeightStarType {
    static int CANVAS_SIZE = 1200;

    private Map<Character, StarType> stars = new HashMap<>();

    public StarType makeStar(char starType) {
        StarType star = stars.get(starType);
        if (star == null) {
            int x = random(0, CANVAS_SIZE);
            int y = random(0, CANVAS_SIZE);

            switch (starType) {
                case 'O':
                    star = new OStar(x, y);
                    break;
                case 'A':
                    star = new AStar(x, y);
                    break;
                case 'B':
                    star = new BStar(x, y);
                    break;
                case 'F':
                    star = new FStar(x, y);
                    break;
                case 'G':
                    star = new GStar(x, y);
                    break;
                case 'K':
                    star = new KStar(x, y);
                    break;
                case 'M':
                    star = new MStar(x, y);
                    break;
            }
            stars.put(starType, star);

        }
        return star;

    }
    
    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}