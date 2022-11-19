package steps;

import org.junit.Before;
import testbase.BaseClass;

public class Hooks {

    @Before
    public void start() {
        BaseClass.Setup();
    }


}