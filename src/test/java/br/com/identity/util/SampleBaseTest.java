package br.com.identity.util;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class SampleBaseTest {

    @Before 
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
