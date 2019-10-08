package com.company.Homework4;

import static org.junit.Assert.*;

public class ListClassTest {
    private ListClass testListClass;

    @Before
    public void initTest(){
        testListClass = new ListClass();
    }

    @Test
    public void deleteWithStream() {
        assertThat(testListClass.deleteWithStream(), not(hasItems(255)));
    }

    @Test
    public void deleteWitoutStream() {
        assertThat(testListClass.deleteWitoutStream(), not(hasItems(255)));
    }
}