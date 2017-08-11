package com.thomson.effective.mthdcommon2allobjs.item8;

/**
 * Obey the general contract when overriding equals
 *
 * Symmetry-----any two objects must agree on whether on they are equals.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 6/19/13
 */
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString)
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        if (o instanceof String)
//            return s.equalsIgnoreCase((String) o);
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        return  (o instanceof CaseInsensitiveString && ((CaseInsensitiveString)o).s.equalsIgnoreCase(s));
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Tgk");
        String s = "tgk";

        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
    }
}
