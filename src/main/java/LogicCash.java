import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LogicCash {
    private final Integer numberOfRequestsToTheServer;

    /* по элементам смотрю есть ли он в кеше если есть добавляю если нет то смотрю
     * сколько раз он используется если используется больше какого то из элементов, то заменяю в кеше на него*/
    public LogicCash(Integer[] inputAr, Integer cashingSize) {
        Integer[] cache = new Integer[cashingSize];
        Map<Integer, Integer> counter = new HashMap<>();
        int requestsToTheServer = 0;

        for (int x : inputAr) {
            int newValue = counter.getOrDefault(x, 0) + 1;
            counter.put(x, newValue);
        }

        for (Integer integer : inputAr) {
            if (!existsInCache(cache, integer)) {
                int lowIndex = lowestPriorityInCash(cache, counter);
                if (cache[lowIndex] == null) {
                    cache[lowIndex] = integer;
                } else {
                    if (counter.get(cache[lowIndex]) < counter.get(integer)) {
                        cache[lowIndex] = integer;
                    }
                }
                counter.put(integer, counter.get(integer) - 1);
                requestsToTheServer++;
            } else {
                counter.put(integer, counter.get(integer) - 1);
            }
        }
        System.out.println("количество обращений к серверу:" + requestsToTheServer);
        this.numberOfRequestsToTheServer = requestsToTheServer;
    }

    public Integer getNumberOfRequestsToTheServer() {
        return numberOfRequestsToTheServer;
    }

    //проверка есть ли он уже в кеше
    private boolean existsInCache(Integer[] cache, Integer element) {
        return Arrays.asList(cache).contains(element);
    }

    //поиск индекса элемента в кеше который встречается меньше всего
    private Integer lowestPriorityInCash(Integer[] cache, Map<Integer, Integer> popularityOfRequest) {
        int min = 0;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == null) {
                return i;
            } else {
                if (popularityOfRequest.get(cache[min]) > popularityOfRequest.get(cache[i])) min = i;
            }
        }
        return min;
    }
}
