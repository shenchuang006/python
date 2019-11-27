package com.ssm.test.compare;

import java.util.Comparator;

class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o2.getAge() - o1.getAge() >= 0 ? -1 : 1;
    }
}
