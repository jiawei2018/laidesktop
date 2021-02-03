package test001;

import com.sun.jdi.PathSearchingVirtualMachine;

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class llll {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(999999999);
        BigDecimal c = new BigDecimal(9999);

        System.out.println(a.multiply(b).multiply(c));

        for(int i =1; i < 1000; i++){
            a = a.multiply(new BigDecimal(i));
        }
        System.out.println(a);


        Map<Character, Integer> map = new HashMap<>();
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            entry.getValue();
        }
        List<String> list = new ArrayList<>();
        list.stream().map(s -> s+"1");

    }

}
