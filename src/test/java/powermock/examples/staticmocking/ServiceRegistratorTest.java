package powermock.examples.staticmocking;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * An example on how to mock the call to a static method.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class ServiceRegistratorTest {

    @Test
    public void registersServiceToRepository() throws Exception {
        long expectedId = 42;

        // We create a new instance of the class under test as usually.
        ServiceRegistrator tested = new ServiceRegistrator();

        // This is the way to tell PowerMock to mock all static methods of a given class
        mockStatic(IdGenerator.class);

        /*
         * The static method call to IdGenerator.generateNewId() expectation.
         * This is why we need PowerMock.
         */
        when(IdGenerator.generateNewId()).thenReturn(expectedId);

        long actualId = tested.registerService(new Object());

        // Note how we verify the class, not the instance!
        verify(IdGenerator.class);

        // Assert that the ID is correct
        assertThat(actualId, is(expectedId));
    }
}