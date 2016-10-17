package com.sishu.architecture1.architecture1customermgr;

import com.sishu.architecture1.architecture1common.Base1;

public class Customter1
{
    public void c1(String s)
    {
        new Base1().base1("customer1 call");
        System.out.println("now in c1 === " + s);
    }
}
