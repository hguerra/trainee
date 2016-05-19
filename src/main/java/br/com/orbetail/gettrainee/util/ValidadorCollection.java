package br.com.orbetail.gettrainee.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author heitor
 * @since 18/05/16.
 */
public class ValidadorCollection {
    public static final Validador<String> isStringNotNullOrEmpty = string -> string != null && !string.isEmpty();
    public static final Validador<List> isListNotNullOrEmpty = list -> list != null
            && !list.isEmpty();
    public static final Validador<Object> isNull = object -> object == null;
    public static final Validador<Object> isNotNull = object -> object != null;

    // SearchWord
    public static Integer search(String word, String text) {
        Integer result = null;
        List<String> list = asList(text);
        result = Collections.binarySearch(list, word);
        return result;
    }

    public static List<String> asList(String text) {
        return Arrays.asList(text.split(" "));
    }

    // DuplicatedElements
    public static Map<String, Integer> allElementFrequencyMapSorted(
            List<String> list) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (String temp : list) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        return map;
    }

    public static Map<String, Integer> allElementFrequencyMap(List<String> list) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String temp : list) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        return map;
    }

    @SuppressWarnings("rawtypes")
    public static Map<Object, Integer> allElementFrequencyMapObject(List list) {
        Map<Object, Integer> map = new HashMap<Object, Integer>();
        for (Object temp : list) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        return map;
    }

    public static String allElementFrequencyString(List<String> list) {
        StringBuilder stringBuffer = new StringBuilder();
        Set<String> uniqueSet = new HashSet<String>(list);
        for (String temp : uniqueSet) {
            stringBuffer.append(temp).append(":").append(Collections.frequency(list, temp));
            stringBuffer.append(";");
        }
        return stringBuffer.toString();
    }

    public static Integer elementFrequency(String element, List<String> list) {
        return Collections.frequency(list, element);
    }

    public static <T> Set<T> findDuplicatesGeneric(Collection<T> list) {
        Set<T> duplicates = new LinkedHashSet<T>();
        Set<T> uniques = new HashSet<T>();
        for (T t : list) {
            if (!uniques.add(t)) {
                duplicates.add(t);
            }
        }
        return duplicates;
    }
}
