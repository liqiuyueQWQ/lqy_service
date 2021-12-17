package com.liqiuyue.effective.commonobj;

import java.util.Objects;

/**
 * @ClassName: CaseInsensitiveString
 * @Author: liqiuyue
 * @Date: 2021-12-15
 */
public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }


}
