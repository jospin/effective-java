package br.com.effective.java.cap3;

import br.com.effective.java.cap3.item10.CaseInsensitiveString;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        tunItem10();
    }

    private static void tunItem10() {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(s));
    }
}
