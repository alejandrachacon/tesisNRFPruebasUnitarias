package tesis.tesisnrf;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ValidarClienteTests {

	@Mock
	DataService dataServiceMock;

	@InjectMocks
	ValidarCliente validarCliente;

	@Test
	public void testValidateClientFieldsWhenCorrectEmail(){
		when(dataServiceMock.retrieveClient()).thenReturn(new ClienteDTO().setName("test").setEmail("test@email.com"));

		Assert.assertEquals(true, validarCliente.validateClientFields());

	}

	@Test
	public void testValidateClientFieldsWhenWrongEmail(){
		when(dataServiceMock.retrieveClient()).thenReturn(new ClienteDTO().setName("test").setEmail("email"));

		Assert.assertEquals(false, validarCliente.validateClientFields());

	}


	@Test
	public void testRequestMessageCanada(){
		when(dataServiceMock.retrieveClient()).thenReturn(new ClienteDTO().setName("Endava SAS").setEmail("alejandra.kcm@gmail.com"));
		when(dataServiceMock.getTypeOfMatter()).thenReturn("auditing");
		when(dataServiceMock.getLocation()).thenReturn("Bogotá");
		when(dataServiceMock.getMatterField()).thenReturn("Software Security");

		String response = "Hi! This is an automatic message to inform you that Endava SAS in Bogotá" +
				" has requested an auditing matter in Software Security. Please check the platform for further information. Thanks! ";

		Assert.assertEquals(response, validarCliente.getMensajeSolicitudCanada());


	}



}
