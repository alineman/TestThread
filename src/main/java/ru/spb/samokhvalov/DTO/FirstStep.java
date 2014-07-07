package ru.spb.samokhvalov.DTO;

import lombok.Data;

/**
 * Created by ivan on 08.07.14.
 */
@Data
public class FirstStep  implements Comparable{
    private String code;
    private String name;

    public FirstStep(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
