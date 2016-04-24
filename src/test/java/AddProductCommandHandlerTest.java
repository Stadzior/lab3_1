import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.application.api.command.AddProductCommand;
import pl.com.bottega.ecommerce.sales.application.api.handler.AddProductCommandHandler;
import pl.com.bottega.ecommerce.sales.domain.client.Client;
import pl.com.bottega.ecommerce.sales.domain.client.ClientRepository;
import pl.com.bottega.ecommerce.sales.domain.equivalent.SuggestionService;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.Product;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductRepository;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sales.domain.reservation.Reservation;
import pl.com.bottega.ecommerce.sales.domain.reservation.ReservationRepository;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import pl.com.bottega.ecommerce.system.application.SystemContext;
import pl.com.bottega.ecommerce.system.application.SystemUser;

import java.util.Date;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Created by Kamil on 2016-04-24.
 */
public class AddProductCommandHandlerTest {
    AddProductCommandHandler handler;
    AddProductCommand command;
    ReservationRepository reservationRepository;
    ProductRepository productRepository;
    SuggestionService suggestionService;
    ClientRepository clientRepository;
    SystemContext systemContext;
    Reservation reservation;
    Product product,equivalent;
    ClientData clientData;
    Client client;
    @Before
    public void initialize(){
        handler = new AddProductCommandHandler();
        product = new Product(Id.generate(),new Money(1),"Test", ProductType.DRUG);
        equivalent = new Product(Id.generate(),new Money(2),"Test Equivalent", ProductType.DRUG);
        command = new AddProductCommand(Id.generate(),Id.generate(),1);
        clientData = new ClientData(Id.generate(),"John");
        client = new Client();
        reservation = new Reservation(Id.generate(), Reservation.ReservationStatus.OPENED, clientData,new Date());

        reservationRepository = Mockito.mock(ReservationRepository.class);
        when(reservationRepository.load(command.getOrderId())).thenReturn(reservation);
        doNothing().when(reservationRepository).save(reservation);

        productRepository = Mockito.mock(ProductRepository.class);
        when(productRepository.load(product.getId())).thenReturn(product);

        systemContext = Mockito.mock(SystemContext.class);
        when(systemContext.getSystemUser()).thenReturn(new SystemUser(new Id("1")));

        clientRepository = Mockito.mock(ClientRepository.class);

        when(clientRepository.load(systemContext.getSystemUser().getClientId())).thenReturn(client);

        suggestionService = Mockito.mock(SuggestionService.class);
        when(suggestionService.suggestEquivalent(product,client)).thenReturn(equivalent);

    }

    @Test
    public void ShouldCallSuggestEquivalentOnce_WhenProductIsNotAvailable(){
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void ShouldCallReservationLoadAndSaveOnce(){
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void IsProductAddedToReservationRepository_WhenItIsAvailable(){
        //Arrange

        //Act
        //Assert
    }
}
