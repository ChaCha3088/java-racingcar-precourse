package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarGameAnalyze {
    public static List<String> analyzeWinner(List<Car> cars) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Car car : cars) {
            result.put(car.getName(), car.getPosition());
        }
        return findMaxKeys(result);
    }

    public static Boolean analyzeFinalMove(Integer i, Integer MOVECOUNTS) {
        if (i == MOVECOUNTS-1) {
            return true;
        }
        return false;
    }

    public static Boolean analyzeMovement(Integer randomNumber) {
        if (randomNumber>= 4 & randomNumber<=9) {
            return true;
        }
        return false;
    }

    private static List<String> findMaxKeys(LinkedHashMap<String, Integer> result) {
        List<String> resultList = new ArrayList<>();
        Integer maxValue = Collections.max(result.values());
        for (Map.Entry<String, Integer> m : result.entrySet()) {
            if (m.getValue() == maxValue) {
                resultList.add(m.getKey());
            }
        }
        return resultList;
    }
}
