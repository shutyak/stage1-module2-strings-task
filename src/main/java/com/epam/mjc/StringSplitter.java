package com.epam.mjc;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String regex= String.join("|", delimiters);
        return Arrays.stream(source.split(regex)).filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }
}
