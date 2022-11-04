package com.example.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Service.class)
//@PrepareForTest(fullyQualifiedNames = "com.example.service.*")
public class ServiceClassTest {

    @Test
    public void mockStaticMethodTest(){
        //Arrange
        String expectedMessage = "This is mocked message for static method.";
        PowerMockito.mockStatic(Service.class);
        when(Service.staticMessage()).thenReturn(expectedMessage);
        //another way
       // Service spy = PowerMockito.spy(new Service());
       // PowerMockito.when(spy.staticMessage()).thenReturn(expectedMessage);

        //Act
        String message = Service.staticMessage();

        //Assert
        Assert.assertEquals(message,expectedMessage);

        PowerMockito.verifyStatic(Service.class, times(1));
        Service.staticMessage();
    }

    @Test
    public void mockFinalMethodTest() {
        //Mock final method
        Service serviceMock = PowerMockito.mock(Service.class,
                withSettings()
                .name("ServiceMock")
                        .verboseLogging());

        //Set expectation
        when(serviceMock.finalMessage()).thenReturn("New Message from Mock!");

        //invoke the method
        String message = serviceMock.finalMessage();

        //Assert the stub response
        Assert.assertEquals(message, "New Message from Mock!");

        verify(serviceMock).finalMessage();
    }

    @Test
    public void mockPrivateMethodTest() throws Exception {
        Service mock = PowerMockito.spy(new Service());
        PowerMockito.doReturn("New Message from Mock!").when(mock,
                "privateMessage");
        String privateMessage = Whitebox.invokeMethod(mock, "privateMessage");
        Assert.assertEquals(privateMessage, "New Message from Mock!");

        PowerMockito.verifyPrivate(mock, times(1)).invoke("privateMessage");
    }
}



