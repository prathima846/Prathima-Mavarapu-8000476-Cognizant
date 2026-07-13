package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testExternalApiMockingAndStubbing() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getDataFor(anyString())).thenReturn("Matched Value");

        MyService service = new MyService(mockApi);
        String result = service.fetchDataWithArg("input-123");

        assertEquals("Matched Value", result);
        verify(mockApi).getDataFor(eq("input-123"));
    }

    @Test
    public void testHandlingVoidMethods() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).performAction("SAVE");

        MyService service = new MyService(mockApi);
        service.processAction("SAVE");

        verify(mockApi).performAction("SAVE");
    }

    @Test
    public void testMockingAndStubbingWithMultipleReturns() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First Response", "Second Response");

        MyService service = new MyService(mockApi);

        assertEquals("First Response", service.fetchData());
        assertEquals("Second Response", service.fetchData());
    }

    @Test
    public void testVerifyingInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getDataFor("foo")).thenReturn("Foo Response");

        MyService service = new MyService(mockApi);
        service.fetchData();
        service.fetchDataWithArg("foo");

        InOrder ordered = inOrder(mockApi);
        ordered.verify(mockApi).getData();
        ordered.verify(mockApi).getDataFor("foo");
    }

    @Test
    public void testHandlingVoidMethodsWithExceptions() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new RuntimeException("Failure action")).when(mockApi).performActionThatThrows("FAIL");

        MyService service = new MyService(mockApi);

        assertThrows(RuntimeException.class, () -> service.processActionThatThrows("FAIL"));
        verify(mockApi).performActionThatThrows("FAIL");
    }
}
