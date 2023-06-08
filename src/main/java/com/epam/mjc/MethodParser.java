package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] part1=signatureString.split("\\(");
        String[] metod=part1[0].split(" ");
        String methodName=metod[metod.length-1];
        String returnType=metod[metod.length-2];
        String accessModifier= (metod.length==3)?metod[0]:null;

        MethodSignature m;
        if (part1[1].length()==1){
            m = new MethodSignature(methodName);
        }else {
            List<MethodSignature.Argument> argumentList= new ArrayList<>();
            String[] argumets =part1[1].substring(0,part1[1].length()-1).split(",");
            for (String arg:argumets
            ) {
                var partOfArg=arg.trim().split(" ");
                argumentList.add(new MethodSignature.Argument(partOfArg[0],partOfArg[1]));
            }
            m = new MethodSignature(methodName,argumentList);
        }
        m.setAccessModifier(accessModifier);
        m.setReturnType(returnType);
        return m;
    }
}
